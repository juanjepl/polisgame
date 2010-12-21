package game;

/**
 * This class manages Polis's sieges
 */
public class SiegePolisAction extends MilitaryAction{

	Player player;
	Polis polisToSiege;
	
	public SiegePolisAction(Player pl, Polis polisToSiege){
		super();
		
		if(pl == null || polisToSiege == null){
			throw new IllegalArgumentException("Invalid parameter for SiegePolisAction");
		}
		
		player = pl;
		this.polisToSiege = polisToSiege;
		
		// To siege a Polis costs 1 prestige point
		getPlayer().setPrestige(getPlayer().getPrestige() - 1);
		
		Integer counter = 0;
		for(Hoplite hop: getPolisToSiege().getHoplitesForAPlayer(getPlayer())){
			if(counter < getPolisToSiege().getBasePopulation()){
				hop.setPosition(getPolisToSiege());
				getPolisToSiege().getPolisParentTerritory().removeUnit(hop);
				getPolisToSiege().addUnit(hop);
				counter += 1;
			}else{
				break;
			}
		}
		getPolisToSiege().setSieged(true);
	}

	/**
	 * Getters for class attributes
	 */
	
	public Player getPlayer() {
		return player;
	}

	public Polis getPolisToSiege() {
		return polisToSiege;
	}
}