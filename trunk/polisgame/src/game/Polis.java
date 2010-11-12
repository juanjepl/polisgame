package game;

import java.util.List;
import java.util.LinkedList;

public class Polis extends Position{
	private Integer basePopulation;
	private Integer actualPopulation;
	private Integer maxPopulation;
	private Integer maxGrowth;
	private Boolean sieged;
	private List<Project> possiblesProjects;
	private List<Project> projects;
	private Territory polisParentTerritory;
	private List<Sea> polisSeas;
	private Boolean hasTradeDock;
	
	public Polis(String sysName,String name, Integer basePopulation, Integer maxGrowth, Integer maxPopulation, Territory polisParentTerritory, List<Project> possiblesProjects, List<Sea> polisSeas, Boolean hasTradeDock){
		super(sysName,name);
		this.basePopulation = basePopulation;
		this.maxGrowth = maxGrowth;
		this.maxPopulation = maxPopulation;
		this.possiblesProjects = possiblesProjects;
		projects = new LinkedList<Project>();
		this.polisParentTerritory = polisParentTerritory;
		this.polisSeas = polisSeas; 
		this.hasTradeDock = hasTradeDock;

	}

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
