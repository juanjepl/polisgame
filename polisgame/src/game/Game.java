package game;

import java.util.List;
import java.util.Map;

public class Game {

	private Player spartaPlayer;
	private Player athensPlayer;
	private List<Project> projectList;
	private Map<String,Position> gamePositions;
	private List<GameEvent> gameEvents;
	private MarketChart marketChart;
	private Round round;
	

	
	public Game(Player spartaPlayer, Player athensPlayer, Map<String,Position> gamePositions, List<Project> projectList, List<GameEvent> gameEvents,Round round,MarketChart marketChart){
		this.spartaPlayer = spartaPlayer;
		this.athensPlayer = athensPlayer;
		this.gamePositions = gamePositions;
		this.projectList = projectList;
		this.gameEvents = gameEvents;
		this.round = round;
		this.marketChart = marketChart;
		
	}

	public Player getSpartaPlayer() {
		return spartaPlayer;
	}

	public Player getAthensPlayer() {
		return athensPlayer;
	}

	public Map<String,Position> getGamePositions() {
		return gamePositions;
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
}
