package game;

/** game unit class */
public abstract class Unit {

	private Player owner; // owner of the unit (a player)
	
	public Unit(Player p){
		owner = p;
	}
	
	public Player getOwner(){
		return owner;
	}
}
