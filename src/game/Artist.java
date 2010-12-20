package game;

import java.util.Map;

public class Artist extends Project{
	
public Artist(String sysName, String name, Integer prestige, Integer prestigeToPosterity, Map<String,Integer> resourcesRequired){
		
		super(sysName,name,prestige,prestigeToPosterity,resourcesRequired); // Uses the Project constructor
		
	}

}
