package game;


public class Turn {
	private Action firstAction;
	private Action secondAction;
	
	public Turn(Action firstAction, Action secondAction){
		//first and second actions must have different type (sons of Action, create.... military...)
		this.firstAction = firstAction;
		this.secondAction = secondAction;
				
	}

	public Action getFirstAction() {
		return firstAction;
	}

	public Action getSecondAction() {
		return secondAction;
	}
	
	
	
}
