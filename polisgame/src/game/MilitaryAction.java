package game;

/** This class contains the methods for execute military actions in the game */
public class MilitaryAction extends Action{

	private final String actionType = "militaryAction"; // A constant to check action's type
	
	
	public MilitaryAction(){}
	
	
	/** To move an Hoplite or Hoplites group, to other position */
	public void moveHoplite(Player player, Position initialPosition, Position finalPosition, Integer numberOfUnits, Boolean multiMovement){
		
		//TODO
		
	}
	
	/** To move a Trirreme or Trirremes group, to other sea */
	public void moveTrirreme(Player player, Sea initialSea, Sea finalSea, Integer numberOfUnits, Boolean multiMovement){
		
		//TODO
		
	}
	
	/** Method to manage polis's siegues */
	public void siegePolis(Player player,Position initialPosition, Polis siegedPolis ){
		
		//TODO
		// not needs numberOfUnits (u CAN or CANNOT siegue a polis)
		
	}
	
	/** Method to manage takings in the territories */
	public void plunderTerritory(Player player){
		
		//TODO
		
	}

	public String getActionType() {
		return actionType;
	}


}