package game;

import java.util.Map;


public class Philosopher extends Project{
	
	public Philosopher(String sysName, String name, Integer prestige, Integer prestigeToPosterity, Map<String,Integer> resourcesRequired){
		
		super(sysName,name,prestige,prestigeToPosterity,resourcesRequired); // Uses the Project constructor
		
	}
}
