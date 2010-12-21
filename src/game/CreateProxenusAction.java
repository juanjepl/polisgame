package game;

/**
 * This class creates a Proxenus for the player 'player'
 * taking the population neccesary from 'polis' and
 * putting it into the same polis as creation.
 */
public class CreateProxenusAction extends CreatorAction{

	private Player player;
	private Polis polis;
	
	public CreateProxenusAction(Player pl, Polis po){
		super();
		
		if(!(pl instanceof Player) || !(po instanceof Polis)){
			throw new IllegalArgumentException("Invalid type parameter(s) for CreateProxenusAction constructor");
		}
		
		player = pl;
		polis = po;
		
		player.setSilver(player.getSilver() - 5);
		
		polis.setActualPopulation(polis.getActualPopulation() - 1);
		Proxenus proxenus = new Proxenus(player,polis);
		player.setPlayerProxenus(proxenus);
		player.addUnit(proxenus);
	}
	
	/**
	 * Getter methods for class attributes
	 */
	
	public Player getPlayer() {
		return player;
	}

	public Polis getPolis() {
		return polis;
	}
}
