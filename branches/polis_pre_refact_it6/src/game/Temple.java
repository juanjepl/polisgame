package game;

import java.util.Map;

/**
 * Class who represents the Temple type Project 
 */
public class Temple extends Project{

	public Temple(String sysName, String name, Integer prestige, Integer prestigeToPosterity, Map<String,Integer> resourcesRequired){
		super(sysName,name,prestige,prestigeToPosterity,resourcesRequired); // Uses the Project constructor		
	}
}