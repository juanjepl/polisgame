package game;

/** This class contains the methods for execute military actions in the game */
public class MilitaryAction extends Action{

	private final String actionType = "militaryAction"; // A constant to check action's type
	
	
	public MilitaryAction(){}
	
	
	/** To move an Hoplite or Hoplites group, to other position */
	public Boolean moveHoplite(Player player, Position initialPosition, Position finalPosition, Integer numberOfUnits, Boolean multiMovement){
		Boolean success = false;
		//TODO
		return success;
	}
	
	/** To move a Trirreme or Trirremes group, to other sea */
	public Boolean moveTrirreme(Player player, Sea initialSea, Sea finalSea, Integer numberOfUnits, Boolean multiMovement){
		Boolean success = false;
		//TODO
		return success;
	}
	
	/** Method to manage polis's siegues */
	public Boolean siegePolis(Player player,Position initialPosition, Polis siegedPolis ){
		Boolean success = false;
		//TODO
		// not needs numberOfUnits (u CAN or CANNOT siegue a polis)
		return success;
	}
	
	/** Method to manage takings in the territories */
	public Boolean plunderTerritory(Player player){
		Boolean success = false;
		//TODO
		return success;
	}

	public String getActionType() {
		return actionType;
	}


}