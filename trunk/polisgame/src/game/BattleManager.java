package game;

import java.util.Iterator;
import java.util.List;
import cfg.GameConfigurations;

/**
 * @see Polis Playbook, page 15
 */
public class BattleManager 
{
	// FIXME (spanish text)
	
	// Pasos a seguir:
	// se comprueba que en el territorio o mar hay 8 o mas unidades entre los 2 bandos
	// asalto
	// cada jugador elige en secreto el numero de unidades en este asalto
	// cada jugador elige en secreto una carta con el numero estimado de unidades en el asalto
	// se muestran las unidades de cada uno elegidas
	// se muestran cartas
	// se decide ganador y unidades a "eliminar"
	/// -> se comprueba si hay que hacer mas asaltos --> Debe hacerlo el usuario de esta clase, con 'assaultAvailable'.

	private Player sparta = null;
	private Player athens = null;
	private Position position = null;
	
	public BattleManager(Player sparta, Player athens, Position position)
	{
		setSparta(sparta);
		setAthens(athens);
		setPosition(position);
	}
	
	public Player getSparta() 		{ return sparta; 	}
	public Player getAthens() 		{ return athens;	}
	public Position getPosition() 	{ return position; 	}
	
	public void setSparta(Player sparta)
	{
		if (sparta == null) throw new NullPointerException("'sparta' can not be null");
		if (sparta == athens) throw new NullPointerException("'sparta' can not be the same than 'athens'");
		
		this.sparta = sparta;
	}
	
	public void setAthens(Player athens)
	{
		if (athens == null) throw new NullPointerException("'athens' can not be null");
		if (athens == sparta) throw new NullPointerException("'athens' can not be the same than 'player1'");
		
		this.athens = athens;
	}
	
	public void setPosition(Position position)
	{
		if (position == null) throw new NullPointerException("'position' can not be null");
		
		this.position = position;
	}
	
	/**
	 * According to the playbook, if we have 8 or more units between the two players in the same region, we can make the assault.
	 * @return if assault is available
	 */
	public Boolean assaultAvailable()
	{
		return (position.getUnits().size() >= GameConfigurations.getMinNumberToBattle());
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
		
		int assaultUnitCount = spartaAttackUnitCount + athensAttackUnitCount;
		
		int spartaDistance = Math.abs(assaultUnitCount - spartaTotalUnitCountBet);
		int athensDistance = Math.abs(assaultUnitCount - athensTotalUnitCountBet);
		
		int attackUnitCountDiff = Math.abs(spartaAttackUnitCount - athensAttackUnitCount);
		
		int winnerAttackUnitCount, loserAttackUnitCount;
			
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
		int removedUnitCount = 0;
		
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