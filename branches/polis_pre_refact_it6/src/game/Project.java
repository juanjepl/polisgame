package game;

import java.util.Map;

/**
 * This class represents a
 * project in the game
 */
public abstract class Project {
	private String sysName; // system name to compare strings for example
	private String name;    // "beautiful" name to be displayed, it can change in translations
	private Integer prestige;
	private Integer prestigeToPosterity;
	private Map<String,Integer> resourcesRequired; // resources required to start this project into a polis
	private Boolean finished;
	private Boolean used; // if this project has been used from the maze in game (no matter if assigned to a polis)
	
	public Project(String sysName,String name, Integer prestige, Integer prestigeToPosterity, Map<String,Integer> resourcesRequired){
		
		this.sysName = sysName;
		this.name = name;
		this.prestige = prestige;
		this.prestigeToPosterity = prestigeToPosterity;
		this.resourcesRequired = resourcesRequired;
		finished = false;
		used = false;
	}
	
	/**
	 * Getters and setters methods
	 */
	
	public Boolean getFinished() {
		return finished;
	}
	
	public void setFinished(Boolean finished) {
		if(finished == null){
			throw new IllegalArgumentException("Invalid parameter for setFinished(), cannot be null");
		}
		this.finished = finished;
	}
	
	public String getSysName() {
		return sysName;
	}
	
	public String getName() {
		return name;
	}
	
	public Integer getPrestige() {
		return prestige;
	}
	
	public Integer getPrestigeToPosterity() {
		return prestigeToPosterity;
	}
	
	public Map<String, Integer> getResourcesRequired() {
		return resourcesRequired;
	}

	public Boolean getUsed() {
		return used;
	}

	public void setUsed(Boolean used){
		if(used == null){
			throw new IllegalArgumentException("Invalid parameter for setUsed(), cannot be null");
		}
		this.used = used;
	}
}
