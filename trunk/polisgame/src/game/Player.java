package game;

import java.util.List;
import java.util.ArrayList;
import utils.RandomCollections;

/** Game player class */
public class Player {
	private String name;
	private List<Polis> playerPolis;  // Polis of which we own
	private TradeDock playerTradeDock; // Own Trade Dock
	private Integer prestige;
	private Integer wood;
	private Integer metal;
	private Integer wine;
	private Integer oil;
	private Integer wheat;
	private Integer silver;
	private Boolean hasPassedTurn; // If this player has passed the turn for actual round
	private Polis capital;
	
	public Player(String name){
		this.name = name;
		hasPassedTurn = false;
		playerPolis = new ArrayList<Polis>();
		prestige = 0;
		wood = 0;
		metal = 0;
		wine = 0;
		oil = 0;
		wheat = 0;
		silver = 0;
	}

	/** Getters and setters */
	
	public String getName() {
		return name;
	}

	public void setName(String name) { // Player's name can be setted in order to, after this creation, we'll change it in game display
		this.name = name;
	}

	public Integer getPrestige() {
		return prestige;
	}

	public void setPrestige(Integer prestige) {
		this.prestige = prestige;
	}

	public Integer getWood() {
		return wood;
	}

	public void setWood(Integer wood) {
		this.wood = wood;
	}

	public Integer getMetal() {
		return metal;
	}

	public void setMetal(Integer metal) {
		this.metal = metal;
	}

	public Integer getWine() {
		return wine;
	}

	public void setWine(Integer wine) {
		this.wine = wine;
	}

	public Integer getOil() {
		return oil;
	}

	public void setOil(Integer oil) {
		this.oil = oil;
	}

	public Integer getWheat() {
		return wheat;
	}

	public void setWheat(Integer wheat) {
		this.wheat = wheat;
	}

	public Integer getSilver() {
		return silver;
	}

	public void setSilver(Integer silver) {
		this.silver = silver;
	}

	public Boolean getHasPassedTurn() {
		return hasPassedTurn;
	}

	public void setHasPassedTurn(Boolean hasPassedTurn) {
		this.hasPassedTurn = hasPassedTurn;
	}
	
	public List<Polis> getPlayerPolis() {
		return playerPolis;
	}

	public TradeDock getPlayerTradeDock() {
		return playerTradeDock;
	}

	public void setPlayerTradeDock(TradeDock playerTradeDock) {
		this.playerTradeDock = playerTradeDock;
	}

	public Polis getCapital() {
		return capital;
	}

	public void setCapital(Polis capital) {
		this.capital = capital;
	}
	
	/** Method to add a polis to our owns */
	public void addPolis(Polis polis){
		//TODO
		if (playerPolis.contains(polis)){
			//FIXME Player must know that this polis is under own control
		}else{
			playerPolis.add(polis);
		}
		
	}

	/** Method to remove polis from our owns */
	public void removePolis(Polis polis){
		//TODO
		if (playerPolis.contains(polis)){
			playerPolis.remove(polis);
		}else {
			//FIXME You can't remove a Polis that you don't have under your control.
		}
	}

	/**
	 * Returns a random number between 1 and 4.
	 * @return The random number.
	 */
	public static Integer rollTheDice(){
		List<Integer> dice = new ArrayList<Integer>(4);
		for(int i = 1; i <= 4; i++) dice.add(i);
		RandomCollections<Integer> diceManager = new RandomCollections<Integer>();
		
		return (diceManager.getRandomSublist(dice, 1)).get(0);
		
		// Better solution:
		//Random generator = new Random()dice;
		//return generator.nextInt(4) + 1;
	}
}
