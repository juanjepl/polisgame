package game;

import java.util.List;
import java.util.ArrayList;

/**
 * This class manages, in round ends
 * the payment to a player for finished
 * projects in his polis
 */
public class EndRoundCheckProjects {

	public EndRoundCheckProjects(Player p){
		if(p == null){
			throw new IllegalArgumentException("Invalid parameter for EndRoundCheckProjects constructor, cannot be null");
		}
		
		List<Project> projectsToPay = new ArrayList<Project>();
		
		// Take the projects to be finished
		for(Polis po: p.getPlayerPolis()){
			for(Project proj: po.getProjects()){
				if((proj.getUsed()) == true && (!(proj.getFinished()))){
					projectsToPay.add(proj);
					break; // only inner loop, only one project can be finished per round in one polis
				}
			}
		}
		
		// Pays to the player, the reward for project finished
		for(Project pj : projectsToPay){
			if(pj.getSysName().equals("phidiasArtist")){ // Only athensPlayer can do this project in his capital
				p.setPrestige(p.getPrestige() + Math.round(p.getCapital().getActualPopulation() / 2));
				pj.setFinished(true);
				
			}else{
				p.setPrestige(p.getPrestige() + pj.getPrestige());
				pj.setFinished(true);
			}
		}
	}	
}