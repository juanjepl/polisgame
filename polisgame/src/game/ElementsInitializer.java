package game;

import java.util.List;
import java.util.Map;
import ui.TextModeUi;
import utils.IPolisFilesReader;
import utils.PolReader;

public class ElementsInitializer {

	public ElementsInitializer(){}
	
	public static Game InitializeGameElements(){ // TODO Game graphs need to be initialized
	
//////// READERS USE		
		IPolisFilesReader polisFilesReader = new PolReader();

//// TERRITORIES		
		Map<String,Territory> territoriesMap = polisFilesReader.readTerritories();
		
//// SEAS		
		Map<String,Sea> seasMap = polisFilesReader.readSeas();
			
//// TRADE DOCKS		
		Map<String,TradeDock> tradeDocksMap = polisFilesReader.readTradeDocks();
			
//// MARKETS		
		Map<String,Market> marketsMap = polisFilesReader.readMarkets();
		
		/*
		obsolete version: like reference for the moment. 
		marketsMap.put("Iliria",iliria);
		marketsMap.put("Tracia",tracia);
		marketsMap.put("EuxinosPontos",euxinosPontos);
		marketsMap.put("ImperioPersa",imperioPersa);
		marketsMap.put("Egipto",egipto);
		
		
		Market iliria = new Market("Iliria","Iliria") ;
		Market tracia = new Market("Tracia","Tracia") ;
		Market euxinosPontos = new Market("EuxinosPontos","EuxinosPontos") ;
		Market imperioPersa = new Market("ImperioPersa","ImperioPersa") ;
		Market egipto = new Market("Egipto","Egipto") ;
		*/
		
		
//// PROJECTS
		List<Project> gameProjects = polisFilesReader.readProjects();

//// POLIS (must be the last of positions to be initialized. Projects also needs to be initialized before.)
		Map<String,Polis> polisMap = polisFilesReader.readPolis(territoriesMap,seasMap,gameProjects);
		
//// GAME EVENTS
		List<List<GameEvent>> gameEventsList = polisFilesReader.readGameEvents();
		
//// ROUND
		Round theRound = new Round();
		
//// MARKET CHART
		MarketChart theMarketChart = new MarketChart();
				
//// PLAYERS
		TextModeUi userInterface = new TextModeUi(); // Creates a user interface object -> in the future, choose graphical/text mode in cfg. 
		List<String> players = 	userInterface.requestPlayerNames();
		
		Player sparta = new Player(players.get(0));
		Player athens = new Player(players.get(1));
		
//// FINALLY, CREATE THE GAME:
		
		Game polisGame = new Game(sparta,athens,territoriesMap,seasMap,tradeDocksMap,marketsMap,polisMap,gameProjects,gameEventsList,theRound,theMarketChart);
		return polisGame;
	}
}
