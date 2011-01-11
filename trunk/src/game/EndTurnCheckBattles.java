package game;

public class EndTurnCheckBattles extends EndTurnManager{

	public EndTurnCheckBattles(Game game)
	{
		super(game);
		
		Player sparta = getGame().getSpartaPlayer();
		Player athens = getGame().getAthensPlayer();
		
		for(Territory terr : game.getGameTerritories().values())
		{
			//This manager resolves battles
			BattleManager battleManager = new BattleManager(sparta, athens, terr);
			while(battleManager.assaultAvailable())
			{
				makeAssault(battleManager);
			}
		}
		
		for(Sea sea : game.getGameSeas().values())
		{
			//This manager resolves battles
			BattleManager battleManager = new BattleManager(sparta, athens, sea);
			while(battleManager.assaultAvailable())
			{
				makeAssault(battleManager);
			}
			
		}
		
		
	}
	
	private void makeAssault(BattleManager battleManager)
	{
		//TODO implements UI call for parameters
		Integer spartaAttackUnitCount = 0;
		Integer athensAttackUnitCount = 0;
		Integer spartaTotalUnitCountBet = 0;
		Integer athensTotalUnitCountBet = 0;
		battleManager.makeAssault(spartaAttackUnitCount, athensAttackUnitCount, spartaTotalUnitCountBet, athensTotalUnitCountBet);
		//TODO battleManager returns winner that we'll use to show in UI
	}
}
