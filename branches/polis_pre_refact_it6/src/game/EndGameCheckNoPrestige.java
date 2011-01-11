package game;

public class EndGameCheckNoPrestige extends EndGameManager{
	
	public EndGameCheckNoPrestige(Game game, Player player){
		
		super(game, player);
		
		if(player.getPrestige() == 0)
		{
			getGame().setWinner(getOponent());
		}
		
	}

}
