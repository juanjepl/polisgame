package game;

import exceptions.PolisGameRunningException;

/**
 * This class creates a TradeBoat for the player 'player'
 * taking the population neccesary from 'polis' and
 * putting it into the player's TradeDock
 */
public class CreateTradeBoatAction extends CreatorAction{

	private Player player;
	private Polis polis;
	private String resourceChosenByThePlayer;
	
	public CreateTradeBoatAction(Player pl, Polis po, String payment){
		super();
		
		if(!(pl instanceof Player) || !(po instanceof Polis) || payment == null){
			throw new IllegalArgumentException("Invalid type parameter(s) for CreateTradeBoatAction constructor");
		}
		if(!payment.equals("Wood") && !payment.equals("Silver")){
			throw new PolisGameRunningException("String for paying resource in CreateTradeBoatAction, must be 'Wood' or 'Silver', your parameter -> '"+resourceChosenByThePlayer+"'");
		}
		
		player = pl;
		polis = po;
		resourceChosenByThePlayer = payment;
	
		if(payment.equals("Wood")){
			player.setWood(player.getWood() - 1);
		}else{ // equals ("Silver")
			player.setSilver(player.getSilver() - 1);
		}
		
		polis.setActualPopulation(polis.getActualPopulation() - 1);
		TradeBoat tradeBoat = new TradeBoat(player,player.getPlayerTradeDock());
		player.getPlayerTradeDock().addUnit(tradeBoat);
		player.addUnit(tradeBoat);		
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

	public String getResourceChosenByThePlayer(){
		return resourceChosenByThePlayer;
	}
}