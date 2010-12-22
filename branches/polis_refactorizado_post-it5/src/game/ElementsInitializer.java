package game;

import java.util.List;
import java.util.Map;
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
		//Graph hopliteGraph = TODO
		//Graph trirremeGraph = TODO
		//Graph tradeBoadGraph = TODO
		//Graph proxenusGraph = TODO
		
		//// Initialization of the round
		Round theRound = new Round3(gameProjects,gameEventsList.get(0)); //FIXME I take round 3 projects (first round)
		
		//// Initialization of the market chart
		MarketChart theMarketChart = new MarketChart();
				
		//// Initialization of the game players
		List<String> players = 	TextModeUi.requestPlayerNames(); // A method who request Game users their names
		
		Player sparta = new Player(players.get(0)); // When Game requests players names, the method returns a list with 2 names, this 2 lines takes this information to create Players instances.
		Player athens = new Player(players.get(1));
		
		//// Initialization of the Game object, who contains all elements of the game initialized before.
		Game polisGame = new Game(sparta,athens,territoriesMap,seasMap,tradeDocksMap,marketsMap,polisMap,gameProjects,gameEventsList,theRound,theMarketChart);
		return polisGame;
	}
}
