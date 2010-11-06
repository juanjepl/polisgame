package game;


public class PoliticAction extends Action{

	private final String actionType = "politicAction";
	
	public PoliticAction(){}
	
	public void startProyect(Player player, Project project, Polis polis){
		//TODO
	}
	
	public void trade(Player player, Market market){
		//TODO needs also a parameter who says what transaction to do
	}
	
	public void moveProxenus(Player player, Polis destination){
		//TODO
	}
	
	public void civilWar(Player player, Polis designatedPolis){
		//TODO
	}

	public String getActionType() {
		return actionType;
	}
	
	
}
