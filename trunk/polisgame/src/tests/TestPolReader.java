package tests;

import game.GameEvent;
import game.Graph;
import game.Market;
import game.Polis;
import game.Project;
import game.Sea;
import game.Territory;
import game.TradeDock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import utils.GenericDirectoryReader;
import utils.PolReader;

public class TestPolReader {
	
	@Before
	public void setup() {

	}
	PolReader pol = new PolReader();
//	/** This method reads all seas files and returns a map with the Sea objects */
//	public Map<String,Sea> readSeas(){
	Map<String,Sea> mapSea = new HashMap<String,Sea>();
	@Test//(expected=FileNotFoundException.class)
	public void testreadSeas(){
		mapSea = pol.readSeas();
		TestUtiles.printMap(mapSea);
	}
//	/** This method read all trade docks files and returns a map with the trade docks objects */
//	public Map<String,TradeDock> readTradeDocks(){
	Map<String,TradeDock> mapTradeDock = new HashMap<String,TradeDock>();
	@Test//(expected=FileNotFoundException.class)
	public void testreadTradeDocks(){
		mapTradeDock = pol.readTradeDocks();
		TestUtiles.printMap(mapTradeDock);
	}
//	/** This method reads all projects files and returns a list with the projects objects */
//	public List<Project> readProjects(){
	List<Project> listProject = new ArrayList<Project>();
	@Test//(expected=FileNotFoundException.class)
	public void testreadProjects(){
		listProject = pol.readProjects();
		TestUtiles.printList(listProject);
	}
//	/** This method reads all markets files and returns a map with the markets objects */
//	public Map<String,Market> readMarkets(){
	Map<String,Market> mapMarket = new HashMap<String,Market>();
	@Test//(expected=FileNotFoundException.class)
	public void testreadMarkets(){
		mapMarket = pol.readMarkets();
		TestUtiles.printMap(mapMarket);
	}
//	/** This method reads all game events files and returns a list with the game events objects */
//	public List<List<GameEvent>> readGameEvents(){
	List<List<GameEvent>> listGameEvents = new ArrayList<List<GameEvent>>();
	@Test//(expected=FileNotFoundException.class)
	public void readGameEvents(){
		listGameEvents = pol.readGameEvents();
		TestUtiles.printListToList(listGameEvents);
	}
//	/** This method reads all polis files and returns a map with the polis objects, using also the territories, seas and projects to composite it */
//	public Map<String,Polis> readPolis(Map<String,Territory> territoriesMap,Map<String,Sea> seasMap,List<Project> gameProjects){
	Map<String,Polis> mapPolis = new HashMap<String,Polis>();
	@Test//(expected=FileNotFoundException.class)
	public void testreadPolis(Map<String,Territory> territoriesMap,Map<String,Sea> seasMap,List<Project> gameProjects){
		mapPolis = pol.readPolis(territoriesMap,seasMap,gameProjects);
		TestUtiles.printMap(mapPolis);
	}
//	/** This method reads all territories files and returns a map with the territories objects */
//	public Map<String,Territory> readTerritories(){		
	Map<String,Territory> mapTerritories = new HashMap<String,Territory>();
	@Test//(expected=FileNotFoundException.class)
	public void testreadTerritories(Map<String,Territory> territoriesMap,Map<String,Sea> seasMap,List<Project> gameProjects){
		mapTerritories = pol.readTerritories();
		TestUtiles.printMap(mapTerritories);
	}
//	/** This method reads all graphs files and return a map with map type and map values */
//	public List<Graph> readGraphs(Map<String,Polis> polisMap,Map<String,Territory> territoriesMap,Map<String,Sea> seasMap, Map<String,Market> marketsMap, Map<String, TradeDock> tradesMap){
//		
	
	

	
	

}
