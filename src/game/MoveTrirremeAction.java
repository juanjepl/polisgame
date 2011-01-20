package game;

/**
 * This class moves a Trirreme or group of trirremes from
 * Sea "x" to Sea "y"
 */
public class MoveTrirremeAction extends MilitaryAction{
	
	Player player;
	Sea initialSea;
	Sea endSea;
	Integer numberOfUnits;
	Boolean multiMovement;
	
	public MoveTrirremeAction(Player pl, Sea iniS, Sea endS, Integer troops, Boolean multiM){
		super();
		
		if(pl == null || iniS == null || endS == null || troops == null || multiM == null){
			throw new IllegalArgumentException("Invalid parameter for MoveTrirremeAction");
		}
		
		player = pl;
		initialSea = iniS;
		endSea = endS;
		numberOfUnits = troops;
		multiMovement = multiM;
		
		// To move a Trirreme costs 1 prestige point (if is a multi-movement, the set of movements costs 1, not 1 per movement)
		if(!getMultiMovement()){
			player.setPrestige(player.getPrestige() - 1);
		}
		
		Integer counter = 0;
		for(Trirreme tri : getInitialSea().getTrirremesForAPlayer(getPlayer())){
			if(counter < getNumberOfUnits()){
				tri.setPosition(getEndSea());
				getEndSea().addUnit(tri);
				getInitialSea().removeUnit(tri);
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

	public Sea getInitialSea() {
		return initialSea;
	}

	public Sea getEndSea() {
		return endSea;
	}

	public Integer getNumberOfUnits() {
		return numberOfUnits;
	}

	public Boolean getMultiMovement() {
		return multiMovement;
	}
}