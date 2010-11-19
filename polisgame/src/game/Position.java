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
	
	public String getSysName() {
		return sysName;
	}
}
