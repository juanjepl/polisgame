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
	private Game game;
	
	public EndTurnManager(Game game)
	{
		if (game == null) throw new IllegalArgumentException("game can not be null");
		removePlundersUnitsFromTerritory();
	}
	
	public Game getGame()
	{
		return game;
	}
	
	
	public void removePlundersUnitsFromTerritory()
	{
		Player player = getGame().getWhoHasTheTurn();
		
		for(Territory t: getGame().getGameTerritories().values())
		{
			//add plunders units to players units list
			if(t.getPlundersUnits().size() > 0)
			{
				for(Unit u: t.getPlundersUnits())
				{
					player.addUnit(u);
				}
			
				//remove plunders units list in territory
				t.emptyPlundersUnits();
			}
		}
	}
	
}