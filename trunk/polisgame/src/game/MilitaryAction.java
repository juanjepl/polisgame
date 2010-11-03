package game;


public class MilitaryAction extends Action{

	public MilitaryAction(){
		
	}
	
	public void moveHoplite(Player player, Position initialPosition, Position finalPosition, Integer numberOfUnits, Boolean multiMovement){
		//TODO
	}
	public void moveTirreme(Player player, Sea initialSea, Sea finalSea, Integer numberOfUnits, Boolean multiMovement){
		//TODO
	}
	public void siegePolis(Player player,Position initialPosition, Polis siegedPolis ){
		//TODO
		// hacer subuso del moveHoplite, no necesito el numero, ya que sera forzosamente el q digan las reglas, si se puede si , si no no
		
	}
	public void plunderTerritory(Player player){
		//TODO
	}


}