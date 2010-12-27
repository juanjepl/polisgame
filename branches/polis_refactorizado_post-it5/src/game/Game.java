package game;

import java.util.List;
import java.util.Map;
import cfg.GameConfigurations;
import exceptions.PolisGameRunningException;

/**
 * The most important class in the game,
 * it contains players, rounds, and any all
 * elements of the game
 */
public class Game{
	private Player spartaPlayer;
	private Player athensPlayer;
	private Player whoHasTheTurn;
	private Player winner;
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
	private Graph hopliteGraph;
	private Graph trirremeGraph;
	private Graph proxenusGraph;
	private Graph tradeBoatGraph;
	
	/** Game constructor */
	public Game(Player sparta, Player athens, Map<String,Territory> territoriesMap, Map<String,Sea> seasMap, Map<String,TradeDock> tradeDocksMap, Map<String,Market> marketsMap, Map<String,Polis> polisMap, List<Project> gameProjects, List<List<GameEvent>> gameEventsList, Round theRound, MarketChart theMarketChart){

		spartaPlayer = sparta;
		athensPlayer = athens;
		
		setStarterPlayer(); // initializes starter player using a class own method
		
		winner = null;
		
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
	
	/**
	 * Getter and Setters methods
	 * for this class
	 */
	
	public Player getSpartaPlayer() {
		return spartaPlayer;
	}

	public Player getAthensPlayer() {
		return athensPlayer;
	}
	
	public Player getWinner(){
		return winner;
	}
	
	public void setWinner(Player p){
		if(p == null){
			throw new IllegalArgumentException("Invalid parameter for setWinner(), cannot be null");
		}
		winner = p;
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

	public void setWhoHasTheTurn(Player whoHasTheTurn){
		if(whoHasTheTurn == null){
			throw new IllegalArgumentException("Invalid parameter for setWhoHasTheTurn(), cannot be null");
		}
		this.whoHasTheTurn = whoHasTheTurn;
	}
	
	public Graph getHopliteGraph() {
		return hopliteGraph;
	}

	public Graph getTrirremeGraph() {
		return trirremeGraph;
	}

	public Graph getProxenusGraph() {
		return proxenusGraph;
	}

	public Graph getTradeBoatGraph() {
		return tradeBoatGraph;
	}
	
	public void setStarterPlayer(){
		if(GameConfigurations.getStarterPlayer().equals("sparta")){
			whoHasTheTurn = spartaPlayer;
		}
		else if(GameConfigurations.getStarterPlayer().equals("athens")){
			whoHasTheTurn = athensPlayer;
		}
		else{
			throw new PolisGameRunningException("Wrong value of GameConfigurations.getStarterPlayer() when game called it");
		}
	}
	
	public void setRound(Round round){
		if(round == null)
		{
			throw new IllegalArgumentException("round musn't be null");
		}
		this.round = round;
	}	
}