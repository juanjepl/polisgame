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
		if(sysName == null || name == null){
			throw new IllegalArgumentException("Invalid parameter for Position constructor");
		}
		this.sysName = sysName;
		this.name = name;
		units = new ArrayList<Unit>();
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
		if(unit == null){
			throw new IllegalArgumentException("Invalid parameter for addUnit()");
		}
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
		if(group == null){
			throw new IllegalArgumentException("Invalid parameter for addGroupOfUnits()");
		}
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
	
	/** Returns the hoplites for a specific player */
	public List<Hoplite> getHoplitesForAPlayer(Player p){
		List<Hoplite> playerHoplites = new ArrayList<Hoplite>();
		for(Unit u : getUnitsForAPlayer(p)){
			if(u instanceof Hoplite){
				playerHoplites.add((Hoplite)u);
			}
		}
		return playerHoplites;
	}
	
	/** Returns the trirremes for a specific player */
	public List<Trirreme> getTrirremesForAPlayer(Player p){
		List<Trirreme> playerTrirremes = new ArrayList<Trirreme>();
		for(Unit u : getUnitsForAPlayer(p)){
			if(u instanceof Trirreme){
				playerTrirremes.add((Trirreme)u);
			}
		}
		return playerTrirremes;
	}
	
	/** Returns the trade boats for a specific player */
	public List<TradeBoat> getTradeBoatsForAPlayer(Player p){
		List<TradeBoat> playerTradeBoats = new ArrayList<TradeBoat>();
		for(Unit u : getUnitsForAPlayer(p)){
			if(u instanceof TradeBoat){
				playerTradeBoats.add((TradeBoat)u);
			}
		}
		return playerTradeBoats;
	}
	
	/** This method without attribute, returns the number of total free slots for this round */
	public Integer getNumberOfTotalFreeSlots(Round round){
		Integer slots = round.getMaximumPositionSlotsForThisRound() - getUnits().size();
		if(slots < 0){
			throw new PolisGameRunningException("A position cannot take a negative value for free slots");
		}
		return slots;
	}
	
	/** This method without attribute, returns the number of free slots for this player and round in position */
	public Integer getNumberOfFreeSlotsForAPlayer(Player player, Round round){
		Integer slots = round.getMaximumPositionSlotsForThisRound() - getUnitsForAPlayer(player).size();
		if(slots < 0){
			throw new PolisGameRunningException("A position cannot take a negative value for free slots for a player");
		}
		return slots;
	}
	
	/** This method returns a Boolean with "if we can cross this position" */
	public Boolean getLockForAPlayer(Player player){
		Boolean locked = false;
		Integer enemies = 0;
		Integer owns = 0;
		for(Unit u:getUnits()){
			if(u.getOwner().equals(player)){
				owns += 1;
			}else{
				enemies += 1;
			}
		}
		if(owns < enemies){
			locked = true;
		}
		return locked;
	}
}