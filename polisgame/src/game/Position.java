package game;

import java.util.List;
import java.util.LinkedList;

/** Class who represents each game map position*/
public abstract class Position {
	private String sysName;
	private String name;
	private List<Unit> units; // sheltered units in this position
	
	public Position(String sysName,String name){
		this.sysName = sysName;
		this.name = name;
		this.units = new LinkedList<Unit>();
	}
	
	/** Getters and setters */
	
	public String getName() {
		return name;
	}

	public List<Unit> getUnits() {
		return units;
	}
	
	public void setUnits(List<Unit> units){
		this.units = units;
	}

	/** Adds an unit to the position */
	public void addUnit(Unit unit){
		//TODO
		//FIXME -> WARNING WITH PRECONDITIONS
	}
	
	/** Removes an unit from the position */
	public void removeUnit(Unit unit){
		//TODO
		
	}
	
	/** Adds a group of units to the position */
	public void addGroupOfUnits(List<Unit> group){
		//TODO using List.addAll() method
		//FIXME -> WARNING WITH PRECONDITIONS
	}
	
	/** Removes a group of units from the position */
	public void removeGroupOfUnits(List<Unit> group){
		//TODO using List.removeAll() method
	}

	public String getSysName() {
		return sysName;
	}
}
