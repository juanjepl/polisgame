package game;

/**
 * This class contains methods to manage the final of the game, when all rounds
 * have finished
 */
public class EndGameManager {

	private Game game;
	private Player player;
	private Player oponent;
	
	public EndGameManager(Game game, Player player) {
		
		if (game == null) throw new IllegalArgumentException("game can not be null");
		if (player == null) throw new IllegalArgumentException("player can not be null");
		
		this.player = player;
		this.game = game;
		
		if(getGame().getAthensPlayer().equals(player))
		{
			this.oponent = getGame().getSpartaPlayer();
		}else
		{
			this.oponent = getGame().getAthensPlayer();
		}
	}

	public Player getPlayer()
	{
		return player;
	}
	
	public Game getGame()
	{
		return game;
	}
	
	public Player getOponent()
	{
		return oponent;
	}

}