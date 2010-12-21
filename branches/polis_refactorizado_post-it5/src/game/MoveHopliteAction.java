package game;

/**
 * This class moves an Hoplite or group of hoplites from
 * Territory "x" to Territory "y"
 */
public class MoveHopliteAction extends MilitaryAction{
	
	Player player;
	Round round;
	Territory initialTerritory;
	Territory endTerritory;
	Integer numberOfUnits;
	Boolean multiMovement;
	
	public MoveHopliteAction(Player pl, Round ro, Territory iniT, Territory endT, Integer troops, Boolean multiM){
		super();
		
		if(pl == null || ro == null || iniT == null || endT == null || troops == null || multiM == null){
			throw new IllegalArgumentException("Invalid parameter for MoveHopliteAction");
		}
		
		player = pl;
		round = ro;
		initialTerritory = iniT;
		endTerritory = endT;
		numberOfUnits = troops;
		multiMovement = multiM;
		
		// To move an Hoplite costs 1 prestige point (if is a multimovement, the set of movements costs 1, not 1 per moveement)
		if(!getMultiMovement()){
			player.setPrestige(player.getPrestige() - 1);
		}
		
		Integer counter = 0;
		for(Hoplite hop : getInitialTerritory().getHoplitesForAPlayer(pl)){
			if(counter < getNumberOfUnits()){
				hop.setPosition(getEndTerritory());
				getInitialTerritory().removeUnit(hop);
				getEndTerritory().addUnit(hop);
				counter += 1;
			}else{
				break;
			}
		}
	}

	/**
	 * Getters for class attributes
	 */
	
	public Player getPlayer() {
		return player;
	}

	public Round getRound() {
		return round;
	}

	public Territory getInitialTerritory() {
		return initialTerritory;
	}

	public Territory getEndTerritory() {
		return endTerritory;
	}

	public Integer getNumberOfUnits() {
		return numberOfUnits;
	}

	public Boolean getMultiMovement() {
		return multiMovement;
	}
}