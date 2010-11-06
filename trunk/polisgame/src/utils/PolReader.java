package utils;

import cfg.GameConfigurations;
import game.Sea;
import game.TradeDock;
import game.Project;
import game.GameEvent;
import game.Territory;
import game.Polis;
import game.Market;

import java.util.Map;
import java.util.HashMap;
import java.util.List;


public class PolReader { // Reads .pol files
	
	public PolReader(){}
	
	// This method reads all Seas files and returns a map with the Sea objects
	public static Map<String,Sea> readSeas(){
		String pathOfSeas = GameConfigurations.pathOfSeas;
		Map<String,Sea> seasMap = new HashMap<String,Sea>();

		List<List<String>> seasTexts = GenericDirectoryReader.getDirectoryFiles(pathOfSeas);
		
		for(List<String> seaInfo:seasTexts){
			seasMap.put(seaInfo.get(0), new Sea(seaInfo.get(0),seaInfo.get(1))); //TODO not tested!!
		}
		
		return seasMap;
	}
	
	// Same with Trade Docks files
	public static Map<String,TradeDock> readTradeDocks(){
		String pathOfTradeDocks = GameConfigurations.pathOfTradeDocks;
		Map<String,TradeDock> tradeDocksMap = new HashMap<String,TradeDock>();
		
		List<List<String>> tradeDocksTexts = GenericDirectoryReader.getDirectoryFiles(pathOfTradeDocks);
		
		for(List<String> tradeDockInfo:tradeDocksTexts){
			tradeDocksMap.put(tradeDockInfo.get(0), new TradeDock(tradeDockInfo.get(0),tradeDockInfo.get(1)));
		}
		
		return tradeDocksMap;
		
	}
	
	
	public static List<Project> readProjects(){
		
		//TODO
		
	}
	
	public static Map<String,Market> readMarkets(){
		
		//TODO
	}
	
	public static List<GameEvent> readGameEvents(){
		
		//TODO
	}
	
	public static Map<String,Polis> readPolis(){
		
		//TODO
	}
	
	public static Map<String,Territory> readTerritories(){
		
		//TODO
	}
	
}
