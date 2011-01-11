package game;

import java.util.Map;

/**
 * Class who represents the Artist type Project 
 */
public class Artist extends Project{
	
public Artist(String sysName, String name, Integer prestige, Integer prestigeToPosterity, Map<String,Integer> resourcesRequired){
		super(sysName,name,prestige,prestigeToPosterity,resourcesRequired); // Uses the Project constructor	
	}
}