package game;


public abstract class Unit {

	private Player owner;
	
	public Unit(Player p){
		
		owner = p;
		
	}
	
	public Player getOwner(){
		return owner;
	}
}
