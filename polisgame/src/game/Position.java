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
	
	public String getSysName() {
		return sysName;
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

	/** Adds an unit to the position */
	public void addUnit(Unit unit){		
		units.add(unit);
	}
	
	/** Removes an unit from the position */
	public void removeUnit(Unit unit){
		if(units.contains(unit)){
			units.remove(unit);
		}else{
			//TODO manage this exception
		}
	}
	
	/** Adds a group of units to the position */
	public void addGroupOfUnits(List<Unit> group){
		units.addAll(group);
	}
	
	/** Removes a group of units from the position */
	public void removeGroupOfUnits(List<Unit> group){
		if(units.containsAll(group)){
			units.removeAll(group);
		}else{
			//TODO manage this exception
		}
	}
	
	/** This method without attribute, returns the number of total free slots for this round */
	public Integer getNumberOfTotalFreeSlots(Round round){
		Integer slots = round.getMaximumPositionSlotsForThisRound() - getUnits().size();
		return slots;
	}
	
	/** This method without attribute, returns the number of free slots for this player and round in position */
	public Integer getNumberOfFreeSlotsForAPlayer(Player player, Round round){
		Integer slots = 0;
		for(Unit u : getUnits()){
			Integer playerUnits = 0;
			if(u.getOwner().equals(player)){
				playerUnits += 1;				
			}
			slots = round.getMaximumPositionSlotsForThisRound()- playerUnits; //FIXME can be an exception returning this a negative integer?
		}
		return slots;
	}
	
	public Boolean getLockForAPlayer(Player player){
		Boolean locked = false;
		Integer owns = 0;
		Integer enemies = 0;
		for(Unit u: units){
			if(u.getOwner().equals(player)){
				owns += 1;
			}else{
				enemies += 1;
			}
		}
		if(enemies > owns){ // >, not >=, in ties, position isn't locked
			locked = true;
		}else{
			//Do nothing
		}
		return locked;
	}
}
