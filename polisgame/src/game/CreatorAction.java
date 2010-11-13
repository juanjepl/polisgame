package game;

/** This class contains the methods for execute creation actions in the game */
public class CreatorAction extends Action{
	
	private final String actionType = "creatorAction"; // A constant to check action's type
	
	public CreatorAction(){}
	
	/** Creates an Hoplite unit in polis's parent territory */
	public void createHoplite(Player owner, Polis polis){
		
		//TODO
	}
	
	/** Creates a Trirreme unit in polis's sea */
	public void createTirreme(Player owner, Polis polis){
		
		//TODO
	}
	
	/** Creates a Trade Boat unit in polis's trade dock */
	public void createTradeBoat(Player owner, Polis polis){
		
		//TODO
	}
	
	/** Creates a Proxenus unit in selected polis */
	public void createProxenus(Player owner, Polis polis){
		
		//TODO
	}

	public String getActionType() {
		return actionType;
	}
	
}
