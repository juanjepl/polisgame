package game;

/** This class contains the methods for execute politic actions in the game */
public class PoliticAction extends Action{

	private final String actionType = "politicAction"; // A constant to check action's type
	
	
	public PoliticAction(){}
	
	
	/** Method to manage when a player starts a project into a polis */
	public void startProject(Player player, Project project, Polis polis){
		
		//TODO
		
	}
	
	/** Method to manage when a tradeboat swaps resources into a market */
	public void trade(Player player, TradeBoat tradeboat, Market market){
		
		//TODO needs also a parameter who says what transaction to do
		
	}
	
	/** Method to manage proxenus's movements */
	public void moveProxenus(Player player, Polis destination){
		
		//TODO
		
	}
	
	/** Method to manage when a proxenus causes a civilwar in a neutral or enemy polis */
	public void civilWar(Player player, Polis designatedPolis){
		
		//TODO
		
	}

	public String getActionType() {
		return actionType;
	}
	
	
}
