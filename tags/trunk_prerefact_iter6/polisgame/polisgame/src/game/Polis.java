package game;

import java.util.List;
import java.util.LinkedList;

/** Polis positions class */
public class Polis extends Position{
	private Integer basePopulation;
	private Integer actualPopulation;
	private Integer maxPopulation;
	private Integer maxGrowth; // maximum change of population number by round
	private Boolean sieged; // if the polis is under siege
	private List<Project> possiblesProjects; // projects that can be started in this polis
	private List<Project> projects; // project started/finished in this polis
	private Territory polisParentTerritory; // territory where is located this polis
	private List<Sea> polisSeas; // seas in which flows the polis
	private Boolean hasTradeDock; // if polis have a trade dock
	
	public Polis(String sysName,String name, Integer basePopulation, Integer maxGrowth, Integer maxPopulation, Territory polisParentTerritory, List<Project> possiblesProjects, List<Sea> polisSeas, Boolean hasTradeDock){
		super(sysName,name); // for this 2 attributes uses Position constructor
		this.basePopulation = basePopulation;
		this.maxGrowth = maxGrowth;
		this.maxPopulation = maxPopulation;
		this.possiblesProjects = possiblesProjects;
		this.polisParentTerritory = polisParentTerritory;
		this.polisSeas = polisSeas; 
		this.hasTradeDock = hasTradeDock;
		projects = new LinkedList<Project>();
		actualPopulation = basePopulation;
		sieged = false;
	}

	/** Getters and setters */
	
	public Integer getActualPopulation() {
		return actualPopulation;
	}

	public void setActualPopulation(Integer actualPopulation) {
		this.actualPopulation = actualPopulation;
	}

	public Boolean getSieged() {
		return sieged;
	}

	public void setSieged(Boolean sieged) {
		this.sieged = sieged;
	}

	public List<Project> getPossiblesProjects() {
		return possiblesProjects;
	}

	public List<Project> getProjects() {
		return projects;
	}
	
	/** Method to add a project in this polis when a player use startProject() in PoliticAction */
	public void addProject(Project p){
		// FIXME add a precondition (p must be in possiblesProjects)
		this.projects.add(p);
	}

	public Territory getPolisParentTerritory() {
		return polisParentTerritory;
	}

	public List<Sea> getPolisSeas() {
		return polisSeas;
	}

	public Integer getBasePopulation() {
		return basePopulation;
	}

	public Integer getMaxPopulation() {
		return maxPopulation;
	}

	public Integer getMaxGrowth() {
		return maxGrowth;
	}

	public Boolean getHasTradeDock() {
		return hasTradeDock;
	}
	
}
