package game;

import java.util.List;
import java.util.LinkedList;

public abstract class Position {
	private String name;
	private List<Unit> units;
	
	
	public Position(String name){
		this.name = name;
		this.units = new LinkedList<Unit>();
	}
	
	public String getName() {
		return name;
	}

	public List<Unit> getUnits() {
		return units;
	}
	
	public void setUnits(List<Unit> units){
		this.units = units;
	}

	public void addUnit(Unit unit){
		//TODO
	}
	
	public void removeUnit(Unit unit){
		//TODO
	}
}
