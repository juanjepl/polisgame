package game;

public class EndGameCheckStandardEndGame extends EndGameManager {
	
	public EndGameCheckStandardEndGame(Game game, Player player){
		
		super(game, player);
		
		Integer player1Score = getPlayerTotalPrestige(getPlayer());
		Integer player2Score = getPlayerTotalPrestige(getOponent());
		
		if (player1Score < player2Score)
		{
			getGame().setWinner(getOponent());
		}
		else if (player1Score == player2Score)
		{
			Integer player1ResourceCount = getPlayerResourceCount(getPlayer());
			Integer player2ResourceCount = getPlayerResourceCount(getOponent());
			
			if (player1ResourceCount < player2ResourceCount) 
			{
				getGame().setWinner(getOponent());
			}
		}
		else
		{
			getGame().setWinner(getPlayer());
		}
		
	}

	private Integer getPlayerTotalPrestige(Player player)
	{
		if (player == null) throw new IllegalArgumentException("player can not be null");
		
		Integer totalPopulation = 0;
		for(Polis polis: player.getPlayerPolis()) totalPopulation += polis.getActualPopulation();
		
		Integer playerPrestige = player.getPrestige();
		
		Integer totalProjectPosterityPrestige = 0;
		
		for(Polis polis: player.getPlayerPolis())
		{
			for(Project project: polis.getProjects())
			{
				if (project.getFinished()) 
				{
					totalProjectPosterityPrestige += project.getPrestigeToPosterity();
				}
			}
		}
		
		return (totalPopulation + playerPrestige + totalProjectPosterityPrestige);
	}
	
	private int getPlayerResourceCount(Player player)
	{
		if (player == null) throw new IllegalArgumentException("player can not be null");
		
		return (player.getMetal() + player.getWood() + player.getWine() + player.getOil() + player.getSilver() + player.getWheat());
	}
}