package game;

import java.util.Map;

public abstract class Project {
	private String name;
	private Integer prestige;
	private Integer prestigeToPosterity;
	private Map<String,Integer> resourcesRequired;
	private Boolean finished;
	private Boolean used;
	
	public Project(String name, Integer prestige, Integer prestigeToPosterity, Map<String,Integer> resourcesRequired){
		
		this.name = name;
		this.prestige = prestige;
		this.prestigeToPosterity = prestigeToPosterity;
		this.resourcesRequired = resourcesRequired;
		this.finished = false;
		this.used = false;
	}
	
	public Boolean getFinished() {
		return finished;
	}
	public void setFinished(Boolean finished) {
		this.finished = finished;
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

	public void setUsed(Boolean used) {
		this.used = used;
	}
	
}
