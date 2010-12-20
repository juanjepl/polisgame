package game;

/**
 * This class creates an Hoplite for the player 'player'
 * taking the population neccesary from 'polis' using the
 * rules of the game (is necessary to know 'round'
 */
public class CreateHopliteAction extends CreatorAction{

	private Player player;
	private Polis polis;
	private Round round;
	
	public CreateHopliteAction(Player pl, Polis po, Round ro){
		player = pl;
		polis = po;
		round = ro;
		
		if(player.getMetal() >= 1 && player.getSilver() < 1){
			player.setMetal(player.getMetal() - 1);
		}else if(player.getMetal() < 1 && player.getSilver() >= 1){
			player.setSilver(player.getSilver() - 1);
		}else{
			
			String resourceChosenByThePlayer = ""; //TODO take from text interface the pay method (string) 

			if(resourceChosenByThePlayer.equals("Metal")){
				player.setMetal(player.getMetal() - 1);
			}else if(resourceChosenByThePlayer.equals("Silver")){
				player.setSilver(player.getSilver() - 1);
			}else{
				throw new IllegalArgumentException("Resource "+resourceChosenByThePlayer+" is NOT a valid Resource for paying hoplite creation");
			}	
		}
		polis.setActualPopulation(polis.getActualPopulation() - 1);
		Hoplite hoplite = new Hoplite(player,polis.getPolisParentTerritory());
		polis.getPolisParentTerritory().addUnit(hoplite);
		player.addUnit(hoplite);
		
	}

	public Player getPlayer() {
		return player;
	}

	public Polis getPolis() {
		return polis;
	}

	public Round getRound() {
		return round;
	}
}