package game;

import java.util.List;
import java.util.ArrayList;

import exceptions.PolisGameRunningException;
import utils.RandomCollections;

/** Game player class */
public class Player {
	private String name;
	private Boolean hasPassedTurn;
	private List<Polis> playerPolis;
	private List<Unit> playerUnits;
	private TradeDock playerTradeDock;
	private Polis capital;
	private Proxenus playerProxenus;
	private Integer prestige;
	private Integer wood;
	private Integer metal;
	private Integer wine;
	private Integer oil;
	private Integer wheat;
	private Integer silver;

	public Player(String name){
		this.name = name;
		hasPassedTurn = false;
		playerPolis = new ArrayList<Polis>();
		playerUnits = new ArrayList<Unit>();
		playerTradeDock = null;
		playerProxenus = null;
		capital = null;
		prestige = 0;
		wood = 0;
		metal = 0;
		wine = 0;
		oil = 0;
		wheat = 0;
		silver = 0;
	}

	/**
	 * Getters and setters methods for Player class
	 */
	
	public String getName() {
		return name;
	}

	public void setName(String name) { // Player's name can be set in order to, after this creation, we'll change it in game display
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
	
	public Integer getResource(String resource)
	{
		String resourcelower = resource.toLowerCase();
		Integer value = 0;
		
		if(resourcelower.equals("silver"))
		{
			value = silver;
		}else if(resourcelower.equals("wheat"))
		{
			value = wheat;
		}
		else if(resourcelower.equals("oil"))
		{
			value = oil;
		}else if(resourcelower.equals("wine"))
		{
			value = wine;
		}else if(resourcelower.equals("metal"))
		{
			value = metal;
		}else if(resourcelower.equals("wood"))
		{
			value = wood;
		}
		
		return value;
	}
	
	public void setResource(String resource,Integer value)
	{
		
		if(resource.equals("silver"))
		{
			this.silver = value;
		}else if(resource.equals("wheat"))
		{
			this.wheat = value;
		}
		else if(resource.equals("oil"))
		{
			this.oil = value;
		}else if(resource.equals("wine"))
		{
			this.wine = value;
		}else if(resource.equals("metal"))
		{
			this.metal = value;
		}else if(resource.equals("wood"))
		{
			this.wood = value;
		}
		
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

	/** Method to get your 'bag of units' */
	public List<Unit> getPlayerUnits() {
		return playerUnits;
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

	public Proxenus getPlayerProxenus() {
		return playerProxenus;
	}

	public void setPlayerProxenus(Proxenus playerProxenus) {
		this.playerProxenus = playerProxenus;
	}

	public void killProxenus(){
		playerProxenus = null;
		for(Unit u: getPlayerUnits()){
			if(u instanceof Proxenus){
				removeUnit(u);
			}
		}
	}
	
	/** Method to add a polis to our owns */
	public void addPolis(Polis polis){
		if (!playerPolis.contains(polis)){
			playerPolis.add(polis);
		}else{
			throw new PolisGameRunningException("You cannot add another time a polis that you already have");
		}
	}

	/** Method to remove polis from our owns */
	public void removePolis(Polis polis){
		if (playerPolis.contains(polis)){
			playerPolis.remove(polis);
		}else {
			throw new PolisGameRunningException("You cannot remove a polis from yours, if this polis does not exists in your 'bag of polis'");
		}
	}
	
	/** Method to add an unit to our owns */
	public void addUnit(Unit u){
		if(!playerUnits.contains(u)){
			playerUnits.add(u);
		}else{
			throw new PolisGameRunningException("You cannot add another time an unit that you already have");
		}
	}
	
	/** Method to remove polis from our owns */
	public void removeUnit(Unit u){
		if(playerUnits.contains(u)){
			playerUnits.remove(u);
		}else{
			throw new PolisGameRunningException("You cannot remove an unit from yours, if this unit does not exists in your 'bag of units'");
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
		
		//Better solution:
		//Random generator = new Random()dice;
		//return generator.nextInt(4) + 1;
		//(actual solution is in order to reuse source code)
	}
}
