package tests;

import game.GameEvent;
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

import navigation.Graph;

import org.junit.Before;
import org.junit.Test;


import utils.PolReader;

public class TestPolReader {
	
	PolReader pol = new PolReader();
	Map<String,Sea> seaMap;
	Map<String,TradeDock> mapTradeDock;
	List<Project> listProject;
	Map<String,Market> mapMarket;
	List<List<GameEvent>> listGameEvents;
	Map<String,Polis> mapPolis;
	Map<String,Territory> mapTerritories;
	List<Graph> listGraph;
	
	@Before
	public void setup() {
		seaMap = new HashMap<String,Sea>();
		mapTradeDock = new HashMap<String,TradeDock>();
		listProject = new ArrayList<Project>();
		mapMarket = new HashMap<String,Market>();
		listGameEvents = new ArrayList<List<GameEvent>>();
		mapPolis = new HashMap<String,Polis>();
		mapTerritories = new HashMap<String,Territory>();
		listGraph=new ArrayList<Graph>();
	}
	
	@Test
	public void testreadSeas(){
		seaMap = pol.readSeas();
	}
	
	@Test
	public void testreadTradeDocks(){
		mapTradeDock = pol.readTradeDocks();
	}

	@Test
	public void testreadProjects(){
		listProject = pol.readProjects();
	}
	
	@Test
	public void testreadMarkets(){
		mapMarket = pol.readMarkets();
	}

	@Test
	public void readGameEvents(){
		listGameEvents = pol.readGameEvents();
	}

	@Test
	public void testreadPolis(){
		mapPolis = pol.readPolis(mapTerritories,seaMap,listProject);
	}
		
	@Test
	public void testreadTerritories(){
		mapTerritories = pol.readTerritories();
	}
	
	@Test (expected=IndexOutOfBoundsException.class)
	public void testreadGraphs(){
		listGraph = pol.readGraphs(mapPolis, mapTerritories, seaMap, mapMarket, mapTradeDock);
	}


}
