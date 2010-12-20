package game;

/** game unit class */
public abstract class Unit {

	private Player owner; // owner of the unit (a player)
	private Position position; // position that unit is
	
	public Unit(Player p, Position actualPosition){
		owner = p;
		position = actualPosition;
	}
	
	public Player getOwner(){
		return owner;
	}
	
	public Position getPosition(){
		if(position == null){
			//TODO exception
		}
		return position;
	}
	
	public void setPosition(Position p){
		position = p;
	}
}
