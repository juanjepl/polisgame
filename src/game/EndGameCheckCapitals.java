package game;

public class EndGameCheckCapitals extends EndGameManager{

	public EndGameCheckCapitals(Game game, Player player){
		
		super(game, player);
		
		if(!getPlayer().getPlayerPolis().contains(getPlayer().getCapital()))
		{
			getGame().setWinner(getOponent());
		}
		
	}

}
