package game;

/** This class contains the methods for pass turn in the game and fills "no-actions" */
public class EmptyAction extends GameAction{

	private final String actionType = "emptyAction"; // A constant to check action's type

	
	public EmptyAction(){}
	
	
	public String getActionType() {
		return actionType;
	}
	
	/** This method execute pass turn action, ending your moves for actual Round */
	public void passTurn(){
		//TODO
	}
	
	
}
