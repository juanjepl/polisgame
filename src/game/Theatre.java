package game;

import java.util.Map;

/**
 * Class who represents the Theatre type Project 
 */
public class Theatre extends Project{

	public Theatre(String sysName, String name, Integer prestige, Integer prestigeToPosterity, Map<String,Integer> resourcesRequired){
		super(sysName,name,prestige,prestigeToPosterity,resourcesRequired); // Uses the Project constructor		
	}
}