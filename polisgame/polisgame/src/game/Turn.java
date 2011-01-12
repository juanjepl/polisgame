package game;

/** Class that manage game turns */
public class Turn {
	private GameAction firstAction = null;
	private GameAction secondAction = null;
	private static Integer turnCount = 0;
	
	public Turn(){
		turnCount++; // increases turn number for each instance of Turn
	}

	/** This method adds an action to the turn */
	public void addAction(GameAction action) {
		if (firstAction == null){
			firstAction = action;
		}
		else{
			if(secondAction == null){
				secondAction = action;
			}
			else{
				//TODO Exception: no more than 2 actions by turn
			}
			
		}
	}

	
	/** Getters */

	public GameAction getFirstAction() {
		return firstAction;
	}

	public GameAction getSecondAction() {
		return secondAction;
	}

	public static Integer getTurnCount() {
		return turnCount;
	}
	
	
	
}
