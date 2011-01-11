package game;

import exceptions.PolisGameRunningException;

/**
 * This class creates a Trirreme for the player 'player'
 * taking the population neccesary from 'polis' and
 * putting it into a sea from polis's seas assigned
 */
public class CreateTrirremeAction extends CreatorAction{

	private Player player;
	private Polis polis;
	private Sea choosenSeaToPutTrirreme;
	private String resourceChosenByThePlayer;

	public CreateTrirremeAction(Player pl, Polis po, Sea choosenSea, String payment){
		super();
		
		if(!(pl instanceof Player) || !(po instanceof Polis) || !(choosenSea instanceof Sea) || payment == null){
			throw new IllegalArgumentException("Invalid type parameter(s) for CreateTrirremeAction constructor");
		}
		if(!payment.equals("Wood") && !payment.equals("Silver")){
			throw new PolisGameRunningException("String for paying resource in CreateTrirremeAction, must be 'Wood' or 'Silver', your parameter -> '"+resourceChosenByThePlayer+"'");
		}

		player = pl;
		polis = po;
		resourceChosenByThePlayer = payment;
		choosenSeaToPutTrirreme = choosenSea;
		
		if(payment.equals("Wood")){
			player.setWood(player.getWood() - 1);
		}else{ // equals ("Silver")
			player.setSilver(player.getSilver() - 1);
		}

		polis.setActualPopulation(polis.getActualPopulation() - 1);
		Trirreme trirreme = new Trirreme(player,choosenSeaToPutTrirreme);
		choosenSeaToPutTrirreme.addUnit(trirreme);
		player.addUnit(trirreme);		
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
	
	public Sea getChoosenSeaToPutTrirreme(){
		return choosenSeaToPutTrirreme;
	}
	
	public String getResourceChosenByThePlayer(){
		return resourceChosenByThePlayer;
	}
}