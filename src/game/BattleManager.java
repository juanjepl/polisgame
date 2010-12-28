package game;

import java.util.Iterator;
import java.util.List;
import cfg.GameConfigurations;

/**
 * @see Polis Playbook, page 15
 */
public class BattleManager 
{
	
	private Player sparta;
	private Player athens;
	private Position position;
	
	public BattleManager(Player sparta, Player athens, Position position)
	{
		if (sparta == null) throw new IllegalArgumentException("'sparta' can not be null");
		if (athens == null) throw new IllegalArgumentException("'athens' can not be null");
		if (position == null) throw new IllegalArgumentException("'position' can not be null");
		
		this.sparta = sparta;
		this.athens = athens;
		this.position = position;
	}
	
	public Player getSparta() 		{ return sparta; 	}
	public Player getAthens() 		{ return athens;	}
	public Position getPosition() 	{ return position; 	}
	
	/**
	 * According to the playbook, if we have 8 or more units between the two players in the same region, we can make the assault.
	 * @return if assault is available
	 */
	public Boolean assaultAvailable()
	{
		return (getPosition().getUnits().size() >= GameConfigurations.getMinNumberToBattle());
	}
	
	/**
	 * Makes an assault
	 * Throws an 'UnsupportedOperationException' if assault is not available.
	 * @return assault winner player
	 */
	public Player makeAssault(Integer spartaAttackUnitCount, Integer athensAttackUnitCount, Integer spartaTotalUnitCountBet, Integer athensTotalUnitCountBet)
	{
		if (spartaAttackUnitCount == null) throw new NullPointerException("'spartaAttackUnitCount' can not be null");
		if (spartaAttackUnitCount < 0) throw new IllegalArgumentException("'spartaAttackUnitCount' must be greater than or equal to 0");
		if (athensAttackUnitCount == null) throw new NullPointerException("'athensAttackUnitCount' can not be null");
		if (athensAttackUnitCount < 0) throw new IllegalArgumentException("'athensAttackUnitCount' must be greater than or equal to 0");
		if (spartaTotalUnitCountBet == null) throw new NullPointerException("'spartaTotalUnitCountBet' can not be null");
		if (spartaTotalUnitCountBet < 0) throw new IllegalArgumentException("'spartaTotalUnitCountBet' must be greater than or equal to 0");
		if (athensTotalUnitCountBet == null) throw new NullPointerException("'athensTotalUnitCountBet' can not be null");
		if (athensTotalUnitCountBet < 0) throw new IllegalArgumentException("'athensTotalUnitCountBet' must be greater than or equal to 0");
		if (!assaultAvailable()) throw new UnsupportedOperationException("Assault is not available");
		
		Player winner = null;
		Player loser = null;
		
		/* Reglas: 
		En cada uno de ellos, ambos jugadores cogen sus 11 cartas y todos sus hoplitas o trirremes que
		tienen en la region donde se produce la batalla y eligen secretamente con cuantos atacan al
		enemigo (pueden elegir 0) escondiendolos en su mano cerrada.
		
		Sobre la mesa situaran boca abajo la carta elegida por ellos con la cantidad
		total (suma de ambos jugadores) de hoplitas o trirremes que creen que van a atacar en este asalto.
		El mazo de cartas de cada jugador va del 0 al 10.
		
		Se revelan los cubos de las manos y luego las cartas. El que mas se acerca con su carta al total
		de atacantes, infringe tantas bajas como la diferencia (da igual si fue a favor o en contra) entre los cubos elegidos 
		en este asalto, y recibe tanto Prestigio como dichas bajas. 
		
		En caso de empate de cercania al total con las cartas, 
		si la batalla es terrestre gana Esparta y si es naval gana Atenas.
		
		Si el jugador que gana el asalto eligio los mismos cubos que el oponente, es decir, la
		diferencia fue 0, causa 1 baja al enemigo y recibe 1 Prestigio.
		
		Si el jugador que gana el asalto eligio menos cubos que el oponente, infringe tantas bajas 
		como la diferencia y recibe ese Prestigio pero el tambien recibe 1 baja (pero que no aporta Prestigio al oponente). */
		
		Integer assaultUnitCount = spartaAttackUnitCount + athensAttackUnitCount;
		
		Integer spartaDistance = Math.abs(assaultUnitCount - spartaTotalUnitCountBet);
		Integer athensDistance = Math.abs(assaultUnitCount - athensTotalUnitCountBet);
		
		Integer attackUnitCountDiff = Math.abs(spartaAttackUnitCount - athensAttackUnitCount);
		
		Integer winnerAttackUnitCount, loserAttackUnitCount;
			
		if (spartaDistance < athensDistance || (spartaDistance == athensDistance && position instanceof Territory))
		{
			winner = sparta;
			winnerAttackUnitCount = spartaAttackUnitCount;
				
			loser = athens;
			loserAttackUnitCount = athensAttackUnitCount;
		}
		else
		{
			winner = athens;
			winnerAttackUnitCount = athensAttackUnitCount;
			
			loser = sparta;
			loserAttackUnitCount = spartaAttackUnitCount;
		}
		
		if (winnerAttackUnitCount == loserAttackUnitCount)
		{
			produceLower(loser, 1);
			incrementPrestige(winner, 1);
		}
		else
		{
			produceLower(loser, attackUnitCountDiff);
			incrementPrestige(winner, attackUnitCountDiff);
			
			if (winnerAttackUnitCount < loserAttackUnitCount) produceLower(winner, 1);
		}
		
		return winner;
	}
	
	/**
	 * Eliminates some units of battle position of the loser player
	 * @param player Player to remove units (loser player)
	 * @param count Number of units to remove
	 */
	private void produceLower(Player player, Integer count)
	{
		List<Unit> positionUnits = position.getUnits();
		List<Unit> playerUnits = player.getPlayerUnits();
		
		Iterator<Unit> it = positionUnits.iterator();
		Integer removedUnitCount = 0;
		
		while(it.hasNext() && removedUnitCount <= count)
		{
			Unit unit = it.next();
			
			if (playerUnits.contains(unit))
			{
				playerUnits.remove(unit);
				removedUnitCount++;
			}
		}
	}
	
	private void incrementPrestige(Player player, Integer amount)
	{
		player.setPrestige(player.getPrestige() + amount);
	}
}