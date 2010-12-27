package game;

/**
 * This class manages, the operations to do,
 * when a turn finishes
 */
public class EndTurnManager 
{	
	/**
	 * Gets pending battles.
	 * Call this method as many times as necessary until no more pending battles. For each returned BattleManager object, call its 'makeAssault' method
	 * with both players unit bets
	 * @return list of pending battles
	 */
	
	/*
	public static List<BattleManager> checkBattles(Game game)
	{
		if (game == null) throw new NullPointerException("'game' can not be null");
		
		LinkedList<BattleManager> battlePending = new LinkedList<BattleManager>();
		Player sparta = game.getSpartaPlayer();
		Player athens = game.getAthensPlayer();
		
		for(Territory terr : game.getGameTerritories().values())
		{
			BattleManager batman = new BattleManager(sparta, athens, terr);
			if (batman.assaultAvailable()) battlePending.add(batman);
		}
		
		for(Sea sea : game.getGameSeas().values())
		{
			BattleManager batman = new BattleManager(sparta, athens, sea);
			if (batman.assaultAvailable()) battlePending.add(batman);
		}
		
		return battlePending;
	}
	
	public static void removePlundersUnitsFromTerritory()
	{
		//TODO
	}
	*/
}