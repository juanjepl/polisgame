package utils;

import cfg.GameConfigurations;
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

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;


public class PolReader implements IPolisFilesReader{ // Reads .pol files
	
	public PolReader(){}
	
	// This method reads all Seas files and returns a map with the Sea objects
	public Map<String,Sea> readSeas(){
		String pathOfSeas = GameConfigurations.getPathOfSeas();
		Map<String,Sea> seasMap = new HashMap<String,Sea>();

		List<List<String>> seasTexts = GenericDirectoryReader.getDirectoryFiles(pathOfSeas);
		
		for(List<String> seaInfo:seasTexts){
			seasMap.put(seaInfo.get(0), new Sea(seaInfo.get(0),seaInfo.get(1))); //TODO not tested!!
		}
		
		return seasMap;
	}
	
	// Same with Trade Docks files
	public Map<String,TradeDock> readTradeDocks(){
		String pathOfTradeDocks = GameConfigurations.getPathOfTradeDocks();
		Map<String,TradeDock> tradeDocksMap = new HashMap<String,TradeDock>();
		
		List<List<String>> tradeDocksTexts = GenericDirectoryReader.getDirectoryFiles(pathOfTradeDocks);
		
		for(List<String> tradeDockInfo:tradeDocksTexts){
			tradeDocksMap.put(tradeDockInfo.get(0), new TradeDock(tradeDockInfo.get(0),tradeDockInfo.get(1)));
		}
		
		return tradeDocksMap;
		
	}
	
	public List<Project> readProjects(){
		String pathOfProjects = GameConfigurations.getPathOfProjects();
		List<Project> projectList = new ArrayList<Project>();
		
		List<List<String>> projectTexts = GenericDirectoryReader.getDirectoryFiles(pathOfProjects);
		
		for(List<String> projectInfo : projectTexts){
			Map<String,Integer> proyectRequestedResources = new HashMap<String,Integer>();
			
			for(int i=4; i < projectTexts.size(); i++){
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
	
	public Map<String,Market> readMarkets(){
		
		Map<String,Market> marketsMap = new HashMap<String,Market>();
		//TODO
		return marketsMap;
	}
	
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
	
	public Map<String,Polis> readPolis(){
		
		Map<String,Polis> polisMap = new HashMap<String,Polis>();
		//TODO
		return polisMap;
	}
	
	public Map<String,Territory> readTerritories(){
		
		Map<String,Territory> territoriesMap = new HashMap<String,Territory>();
		//TODO
		return territoriesMap;
	}
	
}
