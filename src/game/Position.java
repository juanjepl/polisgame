package game;

import java.util.List;
import java.util.ArrayList;
import exceptions.PolisGameRunningException;

/** Class who represents each game map position*/
public abstract class Position {
	private String sysName;
	private String name;
	private List<Unit> units; // sheltered units in this position
	
	public Position(String sysName,String name){
		this.sysName = sysName;
		this.name = name;
		units = new ArrayList<Unit>(12); // why 10? -> by default, in the game, the maximum
										 // number of units in a position 10 (last round -> 5+5
	}
	
	/**
	 * Getters and setters methods
     */
	
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
		if(units == null){
			throw new IllegalArgumentException("Invalid parameter for setUnits()");
		}
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
			throw new PolisGameRunningException("You cannot remove an unit that isn't yours");
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
			throw new PolisGameRunningException("You cannot remove units that aren't yours");
		}
	}
	
	/** Returns the units for a specific player */
	public List<Unit> getUnitsForAPlayer(Player p){
		List<Unit> playerUnits = new ArrayList<Unit>();
		for(Unit u: units){
			if(u.getOwner().equals(p)){
				playerUnits.add(u);
			}
		}
		return playerUnits;
	}
	
	/** This method without attribute, returns the number of total free slots for this round */
	public Integer getNumberOfTotalFreeSlots(Round round){
		Integer slots = round.getMaximumPositionSlotsForThisRound() - getUnits().size();
		return slots;
	}
	
	/** This method without attribute, returns the number of free slots for this player and round in position */
	public Integer getNumberOfFreeSlotsForAPlayer(Player player, Round round){
		Integer slots = 0;
		
		if(getUnits().isEmpty()){
			slots = round.getMaximumPositionSlotsForThisRound();
		}else{
			Integer playerUnits = 0;
			for(Unit u : getUnits()){
				if(u.getOwner().equals(player)){
					playerUnits += 1;				
				}
				slots = round.getMaximumPositionSlotsForThisRound() - playerUnits; //FIXME can be an exception returning this a negative integer?
			}
		}
		return slots;
	}
	
	/** This method returns a Boolean with "if we can cross this position" */
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
		}
		
		return locked;
	}
}
