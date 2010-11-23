package utils;

import cfg.GameConfigurations;
import game.Graph;
import game.Position;
import game.Sea;
import game.TradeDock;
import game.Project;
import game.GameEvent;
import game.Territory;
import game.Polis;
import game.Market;
import game.Philosopher;
import game.Artist;
import game.Temple;
import game.ProjectGame;
import game.Theatre;
import game.Statue;
import game.Festival;
import game.Vertex;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Vector;

/** This class reads game files and returns game objects instantiations, each method one type of them */
public class PolReader{ // Reads .pol files
	
	public PolReader(){}
	
	/** This method reads all seas files and returns a map with the Sea objects */
	public Map<String,Sea> readSeas(){
		String pathOfSeas = GameConfigurations.getPathOfSeas();
		Map<String,Sea> seasMap = new HashMap<String,Sea>();

		List<List<String>> seasTexts = GenericDirectoryReader.getDirectoryFiles(pathOfSeas);
		
		for(List<String> seaInfo:seasTexts){
			seasMap.put(seaInfo.get(0), new Sea(seaInfo.get(0),seaInfo.get(1))); //TODO not tested!!
		}
		
		return seasMap;
	}

	/** This method read all trade docks files and returns a map with the trade docks objects */
	public Map<String,TradeDock> readTradeDocks(){
		String pathOfTradeDocks = GameConfigurations.getPathOfTradeDocks();
		Map<String,TradeDock> tradeDocksMap = new HashMap<String,TradeDock>();
		
		List<List<String>> tradeDocksTexts = GenericDirectoryReader.getDirectoryFiles(pathOfTradeDocks);
		
		for(List<String> tradeDockInfo:tradeDocksTexts){
			tradeDocksMap.put(tradeDockInfo.get(0), new TradeDock(tradeDockInfo.get(0),tradeDockInfo.get(1)));
		}
		
		return tradeDocksMap;
		
	}
	
	/** This method reads all projects files and returns a list with the projects objects */
	public List<Project> readProjects(){
		String pathOfProjects = GameConfigurations.getPathOfProjects();
		List<Project> projectList = new ArrayList<Project>();
		
		List<List<String>> projectTexts = GenericDirectoryReader.getDirectoryFiles(pathOfProjects);
		
		for(List<String> projectInfo : projectTexts){
			Map<String,Integer> proyectRequestedResources = new HashMap<String,Integer>();
			
			for(int i=4; i < projectInfo.size(); i++){
				List<String> mapField = StringUtilities.stringSplitterForPolis(projectInfo.get(i),":");
				proyectRequestedResources.put(mapField.get(0), Integer.parseInt(mapField.get(1)));
			}
			
			if(projectInfo.get(0).endsWith("Philosopher")){
				Project project = new Philosopher(projectInfo.get(0),projectInfo.get(1),Integer.parseInt(projectInfo.get(2)),Integer.parseInt(projectInfo.get(3)),proyectRequestedResources);
				projectList.add(project);
			}
			else if(projectInfo.get(0).endsWith("Artist")){
				Project project = new Artist(projectInfo.get(0),projectInfo.get(1),Integer.parseInt(projectInfo.get(2)),Integer.parseInt(projectInfo.get(3)),proyectRequestedResources);
				projectList.add(project);
			}
			else if(projectInfo.get(0).endsWith("Temple")){
				Project project = new Temple(projectInfo.get(0),projectInfo.get(1),Integer.parseInt(projectInfo.get(2)),Integer.parseInt(projectInfo.get(3)),proyectRequestedResources);
				projectList.add(project);
			}
			else if(projectInfo.get(0).endsWith("Theatre")){
				Project project = new Theatre(projectInfo.get(0),projectInfo.get(1),Integer.parseInt(projectInfo.get(2)),Integer.parseInt(projectInfo.get(3)),proyectRequestedResources);
				projectList.add(project);
			}
			else if(projectInfo.get(0).endsWith("Statue")){
				Project project = new Statue(projectInfo.get(0),projectInfo.get(1),Integer.parseInt(projectInfo.get(2)),Integer.parseInt(projectInfo.get(3)),proyectRequestedResources);
				projectList.add(project);
			}
			else if(projectInfo.get(0).endsWith("Festival")){
				Project project = new Festival(projectInfo.get(0),projectInfo.get(1),Integer.parseInt(projectInfo.get(2)),Integer.parseInt(projectInfo.get(3)),proyectRequestedResources);
				projectList.add(project);
			}
			else if(projectInfo.get(0).endsWith("ProjectGame")){
				Project project = new ProjectGame(projectInfo.get(0),projectInfo.get(1),Integer.parseInt(projectInfo.get(2)),Integer.parseInt(projectInfo.get(3)),proyectRequestedResources);
				projectList.add(project);
			}
			else{
				//TODO possible exception, wrong format name for project files
			}
		}
		return projectList;
	}
	
	/** This method reads all markets files and returns a map with the markets objects */
	public Map<String,Market> readMarkets(){
		String pathOfMarkets = GameConfigurations.getPathOfMarkets();
		Map<String,Market> marketsMap = new HashMap<String,Market>();

		List<List<String>> marketsTexts = GenericDirectoryReader.getDirectoryFiles(pathOfMarkets);
		
		Map<String, Map<String, Integer>> resources = new HashMap<String, Map<String, Integer>>();
		
		for(List<String> marketInfo :marketsTexts)
		{
			for(int i = 2; i < marketInfo.size(); i++)
			{
				List<String> trade = StringUtilities.stringSplitterForPolis(marketInfo.get(i), ":");
				Map<String, Integer> resource2 = new HashMap<String, Integer>();
				resource2.put(trade.get(1), Integer.parseInt(trade.get(2)));
				if(resources.containsKey(trade.get(0)))
				{
					resources.get(trade.get(0)).put(trade.get(1), Integer.parseInt(trade.get(2)));
				} 
				else
				{
					resources.put(trade.get(0), resource2);
				}
			}
			
			Market market = new Market(marketInfo.get(0), marketInfo.get(1), resources);
			marketsMap.put(marketInfo.get(0), market);
		}
		return marketsMap;
	}
	
	/** This method reads all game events files and returns a list with the game events objects */
	public List<List<GameEvent>> readGameEvents(){
		String pathOfGameEvents = GameConfigurations.getPathOfGameEvents();
		List<List<GameEvent>> gameEventsList = new ArrayList<List<GameEvent>>();

		List<List<String>> gameEventsTexts = GenericDirectoryReader.getDirectoryFiles(pathOfGameEvents);
		
		List<GameEvent> gameEventListForRound3 = new ArrayList<GameEvent>();
		List<GameEvent> gameEventListForRound4 = new ArrayList<GameEvent>();
		List<GameEvent> gameEventListForRound5a = new ArrayList<GameEvent>();
		List<GameEvent> gameEventListForRound5b = new ArrayList<GameEvent>();
		
		for(List<String> gameEventInfo :gameEventsTexts ){
			if(gameEventInfo.get(3).equals("3")){
				gameEventListForRound3.add(new GameEvent(gameEventInfo.get(0),gameEventInfo.get(1),gameEventInfo.get(2),gameEventInfo.get(3)));
			}
			else if(gameEventInfo.get(3).equals("4")){
				gameEventListForRound4.add(new GameEvent(gameEventInfo.get(0),gameEventInfo.get(1),gameEventInfo.get(2),gameEventInfo.get(3)));
			}
			else if(gameEventInfo.get(3).equals("5a")){
				gameEventListForRound5a.add(new GameEvent(gameEventInfo.get(0),gameEventInfo.get(1),gameEventInfo.get(2),gameEventInfo.get(3)));
			}
			else if(gameEventInfo.get(3).equals("5b")){
				gameEventListForRound5b.add(new GameEvent(gameEventInfo.get(0),gameEventInfo.get(1),gameEventInfo.get(2),gameEventInfo.get(3)));
			}
			else{
				//TODO possible file reader exception ( no correct String value in file's round line )
			}
		}
	
		gameEventsList.add(gameEventListForRound3);
		gameEventsList.add(gameEventListForRound4);
		gameEventsList.add(gameEventListForRound5a);
		gameEventsList.add(gameEventListForRound5b);
		return gameEventsList;
	}
	
	/** This method reads all polis files and returns a map with the polis objects, using also the territories, seas and projects to composite it */
	public Map<String,Polis> readPolis(Map<String,Territory> territoriesMap,Map<String,Sea> seasMap,List<Project> gameProjects){
		String pathOfPolis = GameConfigurations.getPathOfPolis();
		Map<String,Polis> polisMap = new HashMap<String,Polis>();
		
		List<List<String>> gamePolisTexts = GenericDirectoryReader.getDirectoryFiles(pathOfPolis);
		
		for(List<String> polisInfo : gamePolisTexts){
			List<Project> polisProjects = new ArrayList<Project>();
			List<Sea> polisSeas = new ArrayList<Sea>();
			Territory polisParentTerritory = null;
			Boolean hasTradeDock = false;
			
			if(!(polisInfo.get(5).startsWith("none"))){
				List<String> projectsForPolis = StringUtilities.stringSplitterForPolis(polisInfo.get(5), ":");
				for(String s: projectsForPolis){
					for(Project proj : gameProjects){
						if(proj.getSysName().equals(s)){
							polisProjects.add(proj);
						}
					}					
				}
			}
			else{
				// Do nothing.
			}
			
			if(!(polisInfo.get(6).startsWith("none"))){
				// Territory always is a single String, don't need to be splitted.
				polisParentTerritory = territoriesMap.get(polisInfo.get(6));
			}
			else{
				// Do nothing.
			}
			
			if(!(polisInfo.get(7).startsWith("none"))){
				List<String> seasForPolis = StringUtilities.stringSplitterForPolis(polisInfo.get(7), ":");
				for(String str : seasForPolis){
					polisSeas.add(seasMap.get(str));
				}	
			}
			else{
				// Do nothing.
			}
			
			if( polisInfo.get(0).equals("athens") || polisInfo.get(0).equals("pylos") || polisInfo.get(0).equals("gythion")){
				hasTradeDock = true;
			}
			else{
				// Do nothing.
			}

		Polis thePolis = new Polis(polisInfo.get(0),polisInfo.get(1),Integer.parseInt(polisInfo.get(2)),Integer.parseInt(polisInfo.get(3)),Integer.parseInt(polisInfo.get(4)),polisParentTerritory,polisProjects,polisSeas,hasTradeDock);
		polisMap.put(polisInfo.get(0), thePolis);
		}

		return polisMap;
	}
	
	/** This method reads all territories files and returns a map with the territories objects */
	public Map<String,Territory> readTerritories(){
		String pathOfTerritories = GameConfigurations.getPathOfTerritories();
		Map<String,Territory> territoriesMap = new HashMap<String,Territory>();
		
		List<List<String>> gameTerritoriesTexts = GenericDirectoryReader.getDirectoryFiles(pathOfTerritories);
		for(List<String> gameTerritoryInfo : gameTerritoriesTexts){
			
			Map<String,Vector<Integer>> territoryResources = new HashMap<String,Vector<Integer>>();
			
			for(int i=2 ; i<gameTerritoryInfo.size() ; i++){
				List<String> mapField = StringUtilities.stringSplitterForPolis(gameTerritoryInfo.get(i),":");
				
				Vector<Integer> elementResources = new Vector<Integer>();
		
				for ( int j=1 ; j<mapField.size() ; j++ ){
					elementResources.add(Integer.parseInt(mapField.get(j)));
				}
				
				territoryResources.put(mapField.get(0),elementResources);
			}
			
			Territory territory = new Territory(gameTerritoryInfo.get(0),gameTerritoryInfo.get(1),territoryResources);
			territoriesMap.put(gameTerritoryInfo.get(0),territory);
		}
		

		return territoriesMap;
	}
	
	/** This method reads all graphs files and return a map with map type and map values */
	public List<Graph> readGraphs(Map<String,Polis> polisMap,Map<String,Territory> territoriesMap,Map<String,Sea> seasMap, Map<String,Market> marketsMap, Map<String, TradeDock> tradesMap){
		String pathOfGraphs = GameConfigurations.getPathOfGraphs();
		Map<Vertex<? extends Position>, List<Vertex<? extends Position>>> graphVertexMap = new HashMap<Vertex<? extends Position>, List<Vertex<? extends Position>>>();
		List<Graph> graphsList = new ArrayList<Graph>();
		Map<String,List<String>> gameGraphTexts = GenericDirectoryReader.getDirectoryFilesMap(pathOfGraphs);
		
		for(String filename: gameGraphTexts.keySet()){
		
			List<String> gameGraphInfo = gameGraphTexts.get(filename);
			
			for(int i=1 ; i<gameGraphInfo.size() ; i++){
				List<String> vertices = StringUtilities.stringSplitterForPolis(gameGraphInfo.get(i),":");
				
				List<Vertex<? extends Position>> adjacents = new ArrayList<Vertex<? extends Position>>();
				
				
				for(int j=0; j<vertices.size(); j++)
				{
					if(territoriesMap.containsKey(vertices.get(j)))
					{
						Territory position = territoriesMap.get(vertices.get(j));
						Vertex<Territory> vertex = new Vertex<Territory>(position);
						adjacents.add(vertex);
					}else if(seasMap.containsKey(vertices.get(j)))
					{
						Sea position = seasMap.get(vertices.get(j));
						Vertex<Sea> vertex = new Vertex<Sea>(position);
						adjacents.add(vertex);
					}else if(marketsMap.containsKey(vertices.get(j)))
					{
						Market position = marketsMap.get(vertices.get(j));
						Vertex<Market> vertex = new Vertex<Market>(position);
						adjacents.add(vertex);
					}else if(tradesMap.containsKey(vertices.get(j)))
					{
						TradeDock position = tradesMap.get(vertices.get(j));
						Vertex<TradeDock> vertex = new Vertex<TradeDock>(position);
						adjacents.add(vertex);
					}else if(polisMap.containsKey(vertices.get(j)))
					{
						Polis position = polisMap.get(vertices.get(j));
						Vertex<Polis> vertex = new Vertex<Polis>(position);
						adjacents.add(vertex);
					}
					
					

					graphVertexMap.put(adjacents.get(0), adjacents.subList(1, adjacents.size()));
					
					
				}
			}
			
			Graph graph = new Graph(graphVertexMap);
			graphsList.add(graph);
		}
		
		return graphsList;
		
	}

}