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
	private Territory polisTerritory;
	private List<Sea> polisSeas;
	
	public Polis(String sysName,String name, Integer basePopulation, Integer maxGrowth, Integer maxPopulation, Territory polisTerritory, List<Project> possiblesProjects, List<Sea> polisSeas){
		super(sysName,name);
		this.basePopulation = basePopulation;
		this.maxGrowth = maxGrowth;
		this.maxPopulation = maxPopulation;
		this.possiblesProjects = possiblesProjects;
		projects = new LinkedList<Project>();
		this.polisTerritory = polisTerritory;
		this.polisSeas = polisSeas; 

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
		// add a precondition (p must be in possiblesProjects)
		this.projects.add(p);
	}

	public Territory getPolisTerritory() {
		return polisTerritory;
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
	
}
