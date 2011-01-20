package game;

/**
 * This class manages the civil wars *
 */
public class CivilWarAction extends PoliticAction{
	
	Player player;
	
	public CivilWarAction(Player pl){
		super();
		
		if(pl == null){
			throw new IllegalArgumentException("Invalid parameter for CivilWarAction");
		}
		
		player = pl;

		Polis polisToMakeACivilWar = (Polis)( getPlayer().getPlayerProxenus().getPosition() );
		
		// neutral polis
		if(polisToMakeACivilWar.getPolisOwner() == null){
			polisToMakeACivilWar.setPolisOwner(getPlayer());
			getPlayer().getPlayerPolis().add(polisToMakeACivilWar);
			getPlayer().setSilver(getPlayer().getSilver() - 2 * polisToMakeACivilWar.getBasePopulation());
			getPlayer().setPrestige(getPlayer().getPrestige() + 2 * polisToMakeACivilWar.getBasePopulation());
			
		}else{ // enemy polis: never a polis allied because a available method is checked before doing this action
			Player enemyPlayer = polisToMakeACivilWar.getPolisOwner();
			polisToMakeACivilWar.setPolisOwner(getPlayer());
			enemyPlayer.removePolis(polisToMakeACivilWar);
			getPlayer().getPlayerPolis().add(polisToMakeACivilWar);
			getPlayer().setSilver(getPlayer().getSilver() - 3 * polisToMakeACivilWar.getActualPopulation());
			getPlayer().setPrestige(getPlayer().getPrestige() + 3 * polisToMakeACivilWar.getActualPopulation());
		}
	}
	
	/**
	 * Getters methods from the class
	 */
	
	public Player getPlayer() {
		return player;
	}
}