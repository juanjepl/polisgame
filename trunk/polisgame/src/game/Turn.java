package game;

/** Class that manage game turns */
public class Turn {
	private Action firstAction = null;
	private Action secondAction = null;
	
	public Turn(){}

	/** This method adds an action to the turn */
	public void addAction(Action action) {
		if (firstAction.equals(null)){
			firstAction = action;
		}
		else{
			if(secondAction.equals(null)){
				secondAction = action;
			}
			else{
				//TODO Exception: no more than 2 actions by turn
			}
			
		}
	}

	
	/** Getters */

	public Action getFirstAction() {
		return firstAction;
	}

	public Action getSecondAction() {
		return secondAction;
	}
	
	
	
}
