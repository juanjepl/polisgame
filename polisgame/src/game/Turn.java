package game;

/** Class that manage game turns */
public class Turn {
	private Action firstAction = null;
	private Action secondAction = null;
	private static Integer turnCount = 0;
	
	public Turn(){
		turnCount++; // increases turn number for each instance of Turn
	}

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

	public static Integer getTurnCount() {
		return turnCount;
	}
	
	
	
}
