package game;

import exceptions.PolisGameRunningException;

/**
 * This class represents a generic
 * unit of the game
 */
public abstract class Unit {

	private Player owner; // owner of the unit (a player)
	private Position position; // position that unit is
	
	public Unit(Player p, Position actualPosition){
		if(p == null || actualPosition == null){
			throw new IllegalArgumentException("Invalid parameter in Unit constructor, cannot be null");
		}
		owner = p;
		position = actualPosition;
	}
	
	public Player getOwner(){
		return owner;
	}
	
	public Position getPosition(){
		if(position == null){
			throw new PolisGameRunningException("The unit has not position");
		}
		return position;
	}
	
	public void setPosition(Position p){
		if(p == null){
			throw new IllegalArgumentException("Invalid parameter for setPosition, cannot be null");
		}
		position = p;
	}
}