package game;

import java.util.Map;

/**
 * Class who represents the Festival type Project 
 */
public class Festival extends Project{

	public Festival(String sysName, String name, Integer prestige, Integer prestigeToPosterity, Map<String,Integer> resourcesRequired){
		super(sysName,name,prestige,prestigeToPosterity,resourcesRequired); // Uses the Project constructor		
	}
}