package game;


public class MilitaryAction extends Action{

	public MilitaryAction(){
		
	}
	
	public void moveHoplite(Player player, Position initialPosition, Position finalPosition, Integer numberOfUnits){
		//TODO
		// -> sobrecargar este método para hacer multimovimiento ( varios initial y final y varios numeros de unidades, todo con sus restricciones, por supuesto. )
	}
	public void moveTirreme(Player player, Sea initialSea, Sea finalSea, Integer numberOfUnits){
		//TODO
		// (mismo modus operandi.)
	}
	public void siegePolis(Player player,Position initialPosition, Polis siegedPolis ){
		//TODO
		// hacer subuso del moveHoplite, no necesito el numero, ya que sera forzosamente el q digan las reglas, si se puede si , si no no
		
	}
	public void plunderTerritory(Player player){
		//TODO
	}


}