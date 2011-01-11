package game;

import java.util.List;
import java.util.Map;

import navigation.Graph;

import cfg.GameConfigurations;
import utils.PolReader;

/** This class is responsible for initializing the elements of the game */
public class ElementsInitializer {

	public ElementsInitializer(){}
	
	/** Method who initialize all elements of the game */
	public Game InitializeGameElements(){ // TODO Game graphs need to be initialized
	
		//// Initialization of the game files reader utility		
		PolReader polisFilesReader = new PolReader();

		//// Readings and initialization for territories	
		Map<String,Territory> territoriesMap = polisFilesReader.readTerritories();
		
		//// Readings and initialization for seas	
		Map<String,Sea> seasMap = polisFilesReader.readSeas();
			
		//// Readings and initialization for trade docks	
		Map<String,TradeDock> tradeDocksMap = polisFilesReader.readTradeDocks();
			
		//// Readings and initialization for markets		
		Map<String,Market> marketsMap = polisFilesReader.readMarkets();
		
		//// Readings and initialization for projects
		List<Project> gameProjects = polisFilesReader.readProjects();

		//// Readings and initialization for polis. (must be the last of positions to be initialized. Projects also needs to be initialized before.)
		Map<String,Polis> polisMap = polisFilesReader.readPolis(territoriesMap,seasMap,gameProjects);
		
		//// Readings and initialization for game events
		List<List<GameEvent>> gameEventsList = polisFilesReader.readGameEvents();
		
		//// Reading and initialization for graphs
		Graph hopliteGraph = polisFilesReader.readGraphs(polisMap, territoriesMap, seasMap, marketsMap, tradeDocksMap).get(0);
		Graph proxenusGraph = polisFilesReader.readGraphs(polisMap, territoriesMap, seasMap, marketsMap, tradeDocksMap).get(1);
		Graph tradeBoatGraph = polisFilesReader.readGraphs(polisMap, territoriesMap, seasMap, marketsMap, tradeDocksMap).get(2);
		Graph trirremeGraph = polisFilesReader.readGraphs(polisMap, territoriesMap, seasMap, marketsMap, tradeDocksMap).get(3);
		
		
		
		//// Initialization of the round
		Round theRound = new Round3(gameProjects,gameEventsList.get(0)); //FIXME I take round 3 projects (first round)
		
		//// Initialization of the market chart
		MarketChart theMarketChart = new MarketChart();
				
		//// Initialization of the game players
		Player sparta = new Player(GameConfigurations.getSpartaPlayerName());
		Player athens = new Player(GameConfigurations.getAthensPlayerName());
		
		//// Initialization of the Game object, who contains all elements of the game initialized before.
		Game polisGame = new Game(sparta,athens,territoriesMap,seasMap,tradeDocksMap,marketsMap,polisMap,gameProjects,gameEventsList,theRound,theMarketChart, hopliteGraph, proxenusGraph, tradeBoatGraph, trirremeGraph);
		return polisGame;
	}
}
