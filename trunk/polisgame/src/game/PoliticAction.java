package game;

import java.util.List;

/** This class contains the methods for execute politic actions in the game */
public class PoliticAction extends Action{

	private final String actionType = "politicAction"; // A constant to check action's type

	public PoliticAction(){}
	
	/** Method to manage when a player starts a project into a polis */
	public Boolean startProject(Player player, Project project, Polis polis){
		Boolean success = false;
		
		if (player != null && project != null && polis != null)
		{
			List<Polis> playerPolis = player.getPlayerPolis();
			List<Project> polisPossibleProjects = polis.getPossiblesProjects();
			List<Project> polisProjects = polis.getProjects();
			
			if (playerPolis.contains(polis) && polisPossibleProjects.contains(polis) && !polisProjects.contains(project))
			{
				project.setUsed(true);
				polisProjects.add(project);
				success = true;
			}
		}
		
		return success;
	}
	
	/** Method to manage when a tradeboat swaps resources into a market */
	public Boolean trade(Player player, TradeBoat tradeboat, Market market){
		Boolean success = false;
		//TODO needs also a parameter who says what transaction to do
		return success;
	}
	
	/** Method to manage proxenus's movements */
	public Boolean moveProxenus(Player player, Polis destination){
		Boolean success = false;
		//TODO
		return success;
	}
	
	/** Method to manage when a proxenus causes a civilwar in a neutral or enemy polis */
	public Boolean civilWar(Player player, Polis designatedPolis){
		Boolean success = false;
		//TODO
		return success;
	}

	public String getActionType() {
		return actionType;
	}
	
	
}
