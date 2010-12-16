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
				
				TextModeUi.showMessage("Project "+project.getName()+" started at "+polis.getName()); //FIXME from gametexts...
				
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

		return success;
	}
	
	/** Method to manage proxenus's movements */
	public Boolean moveProxenus(Player player, Polis destiny){
		Boolean success = false;
		
		//proxenus pays amount needed of silver
		player.setSilver(player.getSilver() - GraphNavigatorManager.amountToPayForWay);
		
		player.getPlayerProxenus().setPosition(destiny);
		
		TextModeUi.showMessage("Proxenus moved to "+ destiny.getName()); //FIXME from gametexts
		return success;
	}
	
	/** Method to manage when a proxenus causes a civilwar in a neutral or enemy polis */
	public Boolean civilWar(Player player, Polis polis,Game game){
		Boolean success = AvailableActionsManager.checkCivilWarAnyAction(game,player);
		Player enemyPlayer;
		if(player.equals(game.getAthensPlayer())){
			enemyPlayer = game.getSpartaPlayer();
		}else{
			enemyPlayer = game.getAthensPlayer();
		}
		if(success){
	/**First case,the polis is the enemy player's*/
			if(enemyPlayer.getPlayerPolis().contains(polis)){
				enemyPlayer.getPlayerPolis().remove(polis);
				player.getPlayerPolis().add(polis);
				player.setSilver(player.getSilver()-3*polis.getActualPopulation());
	/**second case,the polis is neutral*/		
			}else{
				player.getPlayerPolis().add(polis);
				player.setSilver(player.getSilver()-2*polis.getBasePopulation());
			}
			
			TextModeUi.showMessage("A civil war made at " + player.getPlayerProxenus().getPosition().getName());//FIXME from gametexts
		}
		return success;
	}

	public String getActionType() {
		return actionType;
	}
	
	
}