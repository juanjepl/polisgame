package game;

/**
 * This class contains methods to manage the final of the game, when all rounds
 * have finished
 */
public class EndGameManager {

	private Player winner = null; // Player who wins the game. (null while game
									// has not a winner)

	public EndGameManager() {
	}

	/** This method checks if any player has lost his capital */
	public Boolean checkCapitals(Player polisGamer) {

		// TODO this method checks no one player has lost his capital (game
		// over)
		return !polisGamer.getPlayerPolis().contains(polisGamer.getCapital());
	}

	/** This method checks if any player has lost all prestige points */
	public Boolean checkNoPrestige(Player playerGamer) {

		// TODO this method checks no one player has lost all his prestige (game
		// over)

		return playerGamer.getPrestige() == 0;
	}

	/**
	 * This method checks the final "score" to decide a winner (following the
	 * game rules)
	 */
	public Player checkStandardEndGame(Player player1, Player player2) {

		// TODO this method tell us the winner of the game (is called standard
		// because in the future, can be more types of endings)
		Player winner = player1;
		
		int player1Score = getPlayerScore(player1);
		int player2Score = getPlayerScore(player2);
		
		if (player1Score < player2Score)
		{
			winner = player2;
		}
		else if (player1Score == player2Score)
		{
			int player1ResourceCount = getPlayerResourceCount(player1);
			int player2ResourceCount = getPlayerResourceCount(player2);
			
			if (player1ResourceCount < player2ResourceCount) winner = player2;
		}
		
		return winner;
	}
	
	private int getPlayerScore(Player player)
	{
		int totalPopulation = 0;
		for(Polis polis: player.getPlayerPolis()) totalPopulation += polis.getActualPopulation();
		
		int playerPrestige = player.getPrestige();
		
		int totalProjectPosterityPrestige = 0;
		for(Polis polis: player.getPlayerPolis())
		{
			for(Project project: polis.getProjects())
			{
				if (project.getFinished()) totalProjectPosterityPrestige += project.getPrestigeToPosterity();
			}
		}
		
		return (totalPopulation + playerPrestige + totalProjectPosterityPrestige);
	}
	
	private int getPlayerResourceCount(Player player)
	{
		return (player.getMetal() + player.getWood() + player.getWine() + player.getOil() + player.getSilver() + player.getWheat());
	}

	public Player getWinner() { // FIXME is it necessary?
		// TODO
		return winner;
	}

	/** This method ends the game */
	// FIXME is also it necessary?
	public void endTheGame() {

		// TODO

	}

}
