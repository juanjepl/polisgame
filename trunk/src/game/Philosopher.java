package game;

import java.util.Map;

/**
 * Class who represents the Philosopher type Project 
 */
public class Philosopher extends Project{
	public Philosopher(String sysName, String name, Integer prestige, Integer prestigeToPosterity, Map<String,Integer> resourcesRequired){
		super(sysName,name,prestige,prestigeToPosterity,resourcesRequired); // Uses the Project constructor		
	}
}