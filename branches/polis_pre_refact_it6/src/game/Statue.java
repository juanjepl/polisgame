package game;

import java.util.Map;

/**
 * Class who represents the Statue type Project 
 */
public class Statue extends Project{
	
	public Statue(String sysName, String name, Integer prestige, Integer prestigeToPosterity, Map<String,Integer> resourcesRequired){
		super(sysName,name,prestige,prestigeToPosterity,resourcesRequired); // Uses the Project constructor	
	}
}