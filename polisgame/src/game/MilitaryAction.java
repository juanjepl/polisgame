package game;


public class MilitaryAction extends Action{

	private final String actionType = "militaryAction";
	
	public MilitaryAction(){}
	
	public void moveHoplite(Player player, Position initialPosition, Position finalPosition, Integer numberOfUnits, Boolean multiMovement){
		//TODO
	}
	public void moveTirreme(Player player, Sea initialSea, Sea finalSea, Integer numberOfUnits, Boolean multiMovement){
		//TODO
	}
	public void siegePolis(Player player,Position initialPosition, Polis siegedPolis ){
		//TODO
		// not needs numberOfUnits (u can or NOT can siegue a polis)
	}
	public void plunderTerritory(Player player){
		//TODO
	}

	public String getActionType() {
		return actionType;
	}


}