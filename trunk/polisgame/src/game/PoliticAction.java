package game;

import java.util.List;

import ui.TextModeUi;

/** This class contains the methods for execute politic actions in the game */
public class PoliticAction extends GameAction{

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
	public Boolean trade(Player player,Round round, MarketChart marketChart, Market market, String resource1, String resource2){
		Boolean success = false;
		
		//check if player uses silver to trade
		if(resource1.equals("silver")){
			
			//player trade without market fluctuation in resource1
			Integer amountResource2 = market.tradeResources(resource1, resource2);
			
			//player pays the amount of resource1 equivalent to amount of resource2
			Integer amountPaid = player.getSilver();
			amountPaid -= amountResource2;
			player.setSilver(amountPaid);
			
			//player obtains amount of resource2 demanded
			Integer amountObtained = player.getWheat();
			amountObtained += amountResource2;
			player.setWheat(amountObtained);
			
			//associated resource to resource2 must be revaluated
			
			String associatedResource = market.getAssociatedResource(resource2, amountResource2);
			//player rolls the dice twice
			 Integer positions = -(TextModeUi.showRollTheDice(2));
			
			//market add value to resource associated to resource2
			marketChart.moveResourcePrice(round.getName(), associatedResource, positions);
			
			success = true;
			
		}else if(resource1.equals("wheat")){
			
			//player trade without market fluctuation in resource1
			Integer amountResource2 = market.tradeResources(resource1, resource2);
			
			//player pays the amount of resource1 equivalent to amount of resource2
			Integer amountPaid = player.getWheat();
			amountPaid -= amountResource2;
			player.setWheat(amountPaid);
			
			//player obtains amount of resource2 demanded
			Integer amountObtained = player.getSilver();
			amountObtained += amountResource2;
			player.setSilver(amountObtained);
			
			//associated resource to resource2 must be revaluated
			
			String associatedResource = market.getAssociatedResource(resource2, amountResource2); //TODO implement getAssociatedResource
			//player rolls the dice twice
			 Integer positions = -(TextModeUi.showRollTheDice(2));
			
			//market add value to resource associated to resource2
			marketChart.moveResourcePrice(round.getName(), associatedResource, positions);
			
			success = true;
			
		}else
		{
			//player pays the amount of resource1 contained in Market Chart
			Integer amountResource2 = market.tradeResources(resource1, resource2);
			Integer amountResource1 = marketChart.getPrice(resource1); //TODO implement getPrice
			
			Integer amountPaid = player.getResource(resource1); //TODO implement player.getResource()
			amountPaid -= amountResource1;
			player.setResource(resource1, amountPaid); //TODO implement player.setResource()
			
			Integer amountObtained = player.getResource(resource2);
			amountObtained += amountResource2;
			player.setResource(resource2, amountObtained);
			
			//market devaluates resource1
			
			//player rolls the dice once
			Integer positions = -(TextModeUi.showRollTheDice(1));
			marketChart.moveResourcePrice(round.getName(), resource1, positions);
			
			success = true;
			
			
		}
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