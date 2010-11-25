package game;

import java.util.List;

/** This class, contains methods to manage the end of game rounds */
public class EndRoundManager {

	
	public EndRoundManager(){}
	
	
	/** This method checks for any sieged polis, if siege completes or not */
	public void checkSieges(){
		
		//TODO
		
		
		
	}
		
	/** This method checks for any started project, who player obtains its prestige */
	public void checkProjects(Player player){
		
		//TODO
		List <Polis> listPolis;
		listPolis =player.getPlayerPolis();
		List <Project> listOfProjects;
		Polis polisToChech;
		Project projectToCheck;
		for( int i = 0 ; i <listPolis.size(); i++){
			polisToChech = listPolis.get(i);
			listOfProjects = polisToChech.getProjects();
			for(int j = 0 ; j < listOfProjects.size(); j ++ ){
				projectToCheck = listOfProjects.get(j);
				if(projectToCheck.getUsed()&&projectToCheck.getFinished()){
					Integer prestige = player.getPrestige();
					prestige = prestige + projectToCheck.getPrestige();
					player.setPrestige(prestige);
					
				}
				
			}
			
		}
		
	}
	
	/** This method manages Player's population feeding */
	public void checkFeeding(){
		
		//TODO
		
	}
		
	/** This method manages if Players wanna to increase his population using his wheat surplus */
	public void checkGrowth(){
		
		//TODO
		
	}
		
	/** This method checks in any polis from a player, if has more population than its base (and puts prestige like rules say) */
	public void checkMegalopolis(){
		
		//TODO
		
	}
	
	/** This method manages the by-two divison of perishables surplus (rounded up) */		
	public void checkGoodsAdjust(){
		
		//TODO
		
	}
		
	/** This method checks Phoros rule. (player can trade prestige to silver 1 to 1) */
	public void checkPhoros(){
		
		//TODO
		
	}
	
	/** This method prepares the next round elements */
	public void initializeNextRound(){
		
		//TODO
		
	}
}

