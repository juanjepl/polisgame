package game;

/** This class contains the methods for pass turn in the game and fills "no-actions" */
public class EmptyAction extends GameAction{

	private final String actionType = "emptyAction"; // A constant to check action's type

	
	public EmptyAction(){}
	
	
	public String getActionType() {
		return actionType;
	}
	
}
