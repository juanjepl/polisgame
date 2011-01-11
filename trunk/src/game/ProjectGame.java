package game;

import java.util.Map;

/**
 * Class who represents the Project Game type Project 
 */
public class ProjectGame extends Project{
	
	public ProjectGame(String sysName, String name, Integer prestige, Integer prestigeToPosterity, Map<String,Integer> resourcesRequired){
		super(sysName,name,prestige,prestigeToPosterity,resourcesRequired); // Uses the Project constructor		
	}
}