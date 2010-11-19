package game;

import java.util.List;
import java.util.Map;

import cfg.GameConfigurations;

/** The most important class in the game, It contains players, rounds, and any all elements of the game */
public class Game { //TODO add Graphs

	private Player spartaPlayer;
	private Player athensPlayer;
	
	private Player whoHasTheTurn;
	
	private List<Project> projectList;

	private Map<String,Territory> gameTerritories ;
	private Map<String,Sea> gameSeas;
	private Map<String,TradeDock> gameTradeDocks ;
	private Map<String,Market> gameMarkets;
	private Map<String,Polis> gamePolis;
	
	private List<GameEvent> gameEventsRound3;
	private List<GameEvent> gameEventsRound4;
	private List<GameEvent> gameEventsRound5a;
	private List<GameEvent> gameEventsRound5b;
	
	private MarketChart marketChart;
	private Round round;
	
	
	/** Game constructor */
	public Game(Player sparta, Player athens, Map<String,Territory> territoriesMap, Map<String,Sea> seasMap, Map<String,TradeDock> tradeDocksMap, Map<String,Market> marketsMap, Map<String,Polis> polisMap, List<Project> gameProjects, List<List<GameEvent>> gameEventsList, Round theRound, MarketChart theMarketChart){

		spartaPlayer = sparta;
		athensPlayer = athens;
		
		setStarterPlayer(); // initializes starter player using a class own method
		
		gameTerritories = territoriesMap;
		gameSeas = seasMap;
		gameTradeDocks = tradeDocksMap;
		gameMarkets = marketsMap;
		gamePolis = polisMap;
		
		projectList = gameProjects;
		gameEventsRound3 = gameEventsList.get(0);
		gameEventsRound4 = gameEventsList.get(1);
		gameEventsRound5a = gameEventsList.get(2);
		gameEventsRound5b = gameEventsList.get(3);
		
		round = theRound;
		marketChart = theMarketChart;
	}

	
	/** Getter and Setters methods */
	
	
	public Player getSpartaPlayer() {
		return spartaPlayer;
	}

	public Player getAthensPlayer() {
		return athensPlayer;
	}

	public List<Project> getProjectList() {
		return projectList;
	}

	public List<GameEvent> getGameEventsRound3() {
		return gameEventsRound3;
	}

	public List<GameEvent> getGameEventsRound4() {
		return gameEventsRound4;
	}

	public List<GameEvent> getGameEventsRound5a() {
		return gameEventsRound5a;
	}

	public List<GameEvent> getGameEventsRound5b() {
		return gameEventsRound5b;
	}

	public MarketChart getMarketChart() {
		return marketChart;
	}

	public Round getRound() {
		return round;
	}

	public Map<String, Territory> getGameTerritories() {
		return gameTerritories;
	}

	public Map<String, Sea> getGameSeas() {
		return gameSeas;
	}

	public Map<String, TradeDock> getGameTradeDocks() {
		return gameTradeDocks;
	}

	public Map<String, Market> getGameMarkets() {
		return gameMarkets;
	}

	public Map<String, Polis> getGamePolis() {
		return gamePolis;
	}

	public Player getWhoHasTheTurn() {
		return whoHasTheTurn;
	}

	public void setWhoHasTheTurn(Player whoHasTheTurn) {
		this.whoHasTheTurn = whoHasTheTurn;
	}
	
	public void setStarterPlayer(){
		if(GameConfigurations.getStarterPlayer().equals("sparta")){
			whoHasTheTurn = spartaPlayer;
		}
		else if(GameConfigurations.getStarterPlayer().equals("athens")){
			whoHasTheTurn = athensPlayer;
		}
		else{
			//TODO possible exception if in game configurations, name isn't "sparta" or "athens"
		}
	}
	
}
