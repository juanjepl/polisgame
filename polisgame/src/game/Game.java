package game;

import java.util.List;
import java.util.Map;

public class Game {

	private Player spartaPlayer;
	private Player athensPlayer;
	private List<Project> projectList;

	private Map<String,Territory> gameTerritories ;
	private Map<String,Sea> gameSeas;
	private Map<String,TradeDock> gameTradeDocks ;
	private Map<String,Market> gameMarkets;
	private Map<String,Polis> gamePolis;
	
	private List<GameEvent> gameEvents;
	private MarketChart marketChart;
	private Round round;
	
	//Map<String,Territory> territoriesMap, Map<String,Sea> seasMap, Map<String,TradeDock> tradeDocksMap, Map<String,Market> marketsMap, Map<String,Polis> polisMap
	
	public Game(Player sparta, Player athens, Map<String,Territory> territoriesMap, Map<String,Sea> seasMap, Map<String,TradeDock> tradeDocksMap, Map<String,Market> marketsMap, Map<String,Polis> polisMap, List<Project> gameProjects, List<GameEvent> gameEventsList, Round theRound, MarketChart theMarketChart){

		spartaPlayer = sparta;
		athensPlayer = athens;
		
		gameTerritories = territoriesMap;
		gameSeas = seasMap;
		gameTradeDocks = tradeDocksMap;
		gameMarkets = marketsMap;
		gamePolis = polisMap;
		
		projectList = gameProjects;
		gameEvents = gameEventsList;
		round = theRound;
		marketChart = theMarketChart;
		
	}

	public Player getSpartaPlayer() {
		return spartaPlayer;
	}

	public Player getAthensPlayer() {
		return athensPlayer;
	}


	public List<Project> getProjectList() {
		return projectList;
	}

	public List<GameEvent> getGameEvents() {
		return gameEvents;
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
}
