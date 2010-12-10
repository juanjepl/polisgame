package game;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cfg.GameConfigurations;

import utils.RandomCollections;

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
	public Player makeAssault(Integer spartaUnitCountBet, Integer athensUnitCountBet)
	{
		if (spartaUnitCountBet == null) throw new NullPointerException("'spartaUnitCountBet' can not be null");
		if (spartaUnitCountBet < 0) throw new IllegalArgumentException("'spartaUnitCountBet' must be greater than or equal to 0");
		if (athensUnitCountBet == null) throw new NullPointerException("'athensUnitCountBet' can not be null");
		if (athensUnitCountBet < 0) throw new IllegalArgumentException("'athensUnitCountBet' must be greater than or equal to 0");
		if (!assaultAvailable()) throw new UnsupportedOperationException("Assault is not available");
		
		Player winner = null;
		Player loser = null;
		
		/* Reglas: Sobre la mesa situaran boca abajo la carta elegida por ellos con la cantidad
		total (suma de ambos jugadores) de hoplitas o trirremes que creen que van a atacar en este asalto.
		El mazo de cartas de cada jugador va del 0 al 10. */
		
		// Reutilizamos RandomCollections para generar un numero al azar
		ArrayList<Integer> cards = new ArrayList<Integer>(11);
		for(int i = 0; i<11; i++) cards.add(i);
		int unitTotal = new RandomCollections<Integer>().getRandomSublist(cards, 1).get(0);
		
		/* Reglas: Se revelan los cubos de las manos y luego las cartas. El que mas se acerca con su carta al total
		de atacantes, infringe tantas bajas como la diferencia (da igual si fue a favor o en contra) entre los cubos elegidos 
		en este asalto, y recibe tanto Prestigio como dichas bajas. */
		
		int spartaDistance = Math.abs(unitTotal - spartaUnitCountBet);
		int athensDistance = Math.abs(unitTotal - athensUnitCountBet);
		int distanceDifference = Math.abs(spartaDistance - athensDistance);
		
		if (spartaDistance != athensDistance)
		{
			int winnerUnitCountBet, loserUnitCountBet;
			
			if (spartaDistance < athensDistance)
			{
				winner = sparta;
				winnerUnitCountBet = spartaUnitCountBet;
				
				loser = athens;
				loserUnitCountBet = athensUnitCountBet;
			}
			else // Equivalent to 'else if (spartaDistance > athensDistance)'
			{
				winner = athens;
				winnerUnitCountBet = athensUnitCountBet;
				
				loser = sparta;
				loserUnitCountBet = spartaUnitCountBet;
			}
			
			produceLower(loser, distanceDifference);
			incrementPrestige(winner, distanceDifference);
			
			/* Reglas: Si el jugador que gana el asalto eligio menos cubos que el oponente infringe tantas bajas 
			como la diferencia y recibe ese Prestigio pero el tambien recibe 1 baja (pero que no aporta Prestigio al oponente). */

			if (winnerUnitCountBet < loserUnitCountBet) produceLower(winner, 1);
		}
		else
		{
			/* Reglas: En caso de empate de cercania al total con las cartas, 
			si la batalla es terrestre gana Esparta y si es naval gana Atenas. */
			
			if (position instanceof Territory)
			{
				winner = sparta;
				loser = athens;
			}
			else
			{
				winner = athens;
				loser = sparta;
			}
			
			/* Reglas: Si el jugador que gana el asalto eligio los mismos cubos que el oponente, es decir, la
			diferencia fue 0, causa 1 baja al enemigo y recibe 1 Prestigio. */

			produceLower(loser, 1);
			incrementPrestige(winner, 1);
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