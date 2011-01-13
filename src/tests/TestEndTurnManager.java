package tests;

import game.EndTurnManager;
import game.Game;
import game.GameEvent;
import game.Market;
import game.MarketChart;
import game.Player;
import game.Polis;
import game.Position;
import game.Project;
import game.Round;
import game.Round3;
import game.Sea;
import game.Territory;
import game.TradeDock;

import java.util.List;
import java.util.Map;

import navigation.Graph;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import utils.PolReader;

public class TestEndTurnManager {

	@Mock
	Game mockGame;

	@Mock
	Territory mockTerr;
	@Mock
	Map<String, Integer> MockExactlyPlunder;

	Game polisGame;
	Player mockNullPlayer;
	Position mockNullPosition;
	Player sparta;
	Player athens;

	@Before
	public void setup() {

		// // Initialization of the game files reader utility
		PolReader polisFilesReader = new PolReader();

		// // Readings and initialization for territories
		Map<String, Territory> territoriesMap = polisFilesReader
				.readTerritories();

		// // Readings and initialization for seas
		Map<String, Sea> seasMap = polisFilesReader.readSeas();

		// // Readings and initialization for trade docks
		Map<String, TradeDock> tradeDocksMap = polisFilesReader
				.readTradeDocks();

		// // Readings and initialization for markets
		Map<String, Market> marketsMap = polisFilesReader.readMarkets();

		// // Readings and initialization for projects
		List<Project> gameProjects = polisFilesReader.readProjects();

		// // Readings and initialization for polis. (must be the last of
		// positions to be initialized. Projects also needs to be initialized
		// before.)
		Map<String, Polis> polisMap = polisFilesReader.readPolis(
				territoriesMap, seasMap, gameProjects);

		// // Readings and initialization for game events
		List<List<GameEvent>> gameEventsList = polisFilesReader
				.readGameEvents();

		// // Reading and initialization for graphs
		Graph hopliteGraph = polisFilesReader.readGraphs(polisMap,
				territoriesMap, seasMap, marketsMap, tradeDocksMap).get(0);
		Graph proxenusGraph = polisFilesReader.readGraphs(polisMap,
				territoriesMap, seasMap, marketsMap, tradeDocksMap).get(1);
		Graph tradeBoatGraph = polisFilesReader.readGraphs(polisMap,
				territoriesMap, seasMap, marketsMap, tradeDocksMap).get(2);
		Graph trirremeGraph = polisFilesReader.readGraphs(polisMap,
				territoriesMap, seasMap, marketsMap, tradeDocksMap).get(3);

		// // Initialization of the round
		Round theRound = new Round3(gameProjects, gameEventsList.get(0)); // FIXME
																			// I
																			// take
																			// round
																			// 3
																			// projects
																			// (first
																			// round)

		// // Initialization of the market chart
		MarketChart theMarketChart = new MarketChart();

		// // Initialization of the game players
		sparta = new Player("Sparta");
		athens = new Player("Athens");

		// // Initialization of the Game object, who contains all elements of
		// the game initialized before.
		polisGame = new Game(sparta, athens, territoriesMap, seasMap,
				tradeDocksMap, marketsMap, polisMap, gameProjects,
				gameEventsList, theRound, theMarketChart, hopliteGraph,
				proxenusGraph, tradeBoatGraph, trirremeGraph);

		MockitoAnnotations.initMocks(this);

	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void testEndTurnManagernCreation() {
		EndTurnManager m = new EndTurnManager(polisGame);
		assert (m.getGame().equals(polisGame));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNullGame() {
		EndTurnManager m = new EndTurnManager(null);
		assert (m.getGame().equals(polisGame));
	}


}
