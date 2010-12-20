package game;

import exceptions.PolisGameRunningException;

/**
 * This class creates an Hoplite for the player 'player'
 * taking the population neccesary from 'polis' using the
 * rules of the game (is necessary to know 'round')
 * putting it into parent territory of the polis.
 */
public class CreateHopliteAction extends CreatorAction{

	private Player player;
	private Polis polis;
	private Round round;
	private String resourceChosenByThePlayer;
	
	public CreateHopliteAction(Player pl, Polis po, Round ro, String payment){
		if(!(pl instanceof Player) || !(po instanceof Polis) || !(ro instanceof Round) || payment == null){
			throw new IllegalArgumentException("Invalid type parameter(s) for CreateHopliteAction constructor");
		}
		if(!payment.equals("Metal") && !payment.equals("Silver")){
			throw new PolisGameRunningException("String for paying resource in CreateHopliteAction, must be 'Metal' or 'Silver', your parameter -> '"+resourceChosenByThePlayer+"'");
		}

		player = pl;
		polis = po;
		round = ro;
		resourceChosenByThePlayer = payment;
		
		if(payment.equals("Metal")){
			player.setMetal(player.getMetal() - 1);
		}else{ // equals ("Silver")
			player.setSilver(player.getSilver() - 1);
		}

		polis.setActualPopulation(polis.getActualPopulation() - 1);
		Hoplite hoplite = new Hoplite(player,polis.getPolisParentTerritory());
		polis.getPolisParentTerritory().addUnit(hoplite);
		player.addUnit(hoplite);		
	}

	
	/**
	 * Getter methods for class attributes
	 */
	
	public Player getPlayer() {
		return player;
	}

	public Polis getPolis() {
		return polis;
	}

	public Round getRound() {
		return round;
	}
	
	public String getResourceChosenByThePlayer(){
		return resourceChosenByThePlayer;
	}
}