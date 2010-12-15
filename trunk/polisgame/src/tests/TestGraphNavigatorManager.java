package tests;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import game.ElementsInitializer;
import game.Game;
import game.GraphNavigatorManager;
import game.Hoplite;
import game.Market;
import game.Polis;
import game.Proxenus;
import game.Sea;
import game.StandardStartInitializer;
import game.Territory;
import game.TradeBoat;
import game.Trirreme;

public class TestGraphNavigatorManager {
	ElementsInitializer gameElements;
	Game polis_game;
	GraphNavigatorManager graph;

	@Before
	public void setUp() {
		gameElements = new ElementsInitializer();
		polis_game = gameElements.InitializeGameElements(); // Initializes
		// all game
		// elements

		StandardStartInitializer.standardStart(polis_game); // Initializes the
		// game standard
		// start position

		polis_game.getRound().startRound(polis_game); // Starts initial round

		graph = new GraphNavigatorManager();
	}

	@After
	public void tearDown() {

	}

	@Test(expected = NullPointerException.class)
	public void existsWayNull() {
		GraphNavigatorManager.existsWay(null, null, null, null);
	}

	@Test
	public void existsWayWith2EqualsParamatres() {

		List<Territory> listOfTerritory = new LinkedList<Territory>(polis_game
				.getGameTerritories().values());

		assertFalse(GraphNavigatorManager.existsWay(listOfTerritory.get(1),
				listOfTerritory.get(1), polis_game.getAthensPlayer(),
				"tradeboat"));

	}

	@Test
	public void existsWayBetween2Polis() {

		List<Polis> ListOfpolisToCheck = new LinkedList<Polis>(polis_game
				.getGamePolis().values());

		Polis thebesPolis = null;
		for (Polis pol : ListOfpolisToCheck) {
			if (pol.getSysName().equalsIgnoreCase("thebes")) {

				thebesPolis = pol;
				break;
			}
		}
		Hoplite hoplite = new Hoplite(polis_game.getAthensPlayer(), polis_game
				.getAthensPlayer().getCapital());
		polis_game.getAthensPlayer().getPlayerUnits().add(hoplite);

		hoplite.setPosition(polis_game.getAthensPlayer().getCapital());

		assertTrue(GraphNavigatorManager.existsWay(polis_game.getAthensPlayer()
				.getCapital(), thebesPolis, polis_game.getAthensPlayer(),
				"hoplite"));
	}

	@Test
	public void existsWayBetween2PolisUnlessException() {

		List<Polis> ListOfpolisToCheck = new LinkedList<Polis>(polis_game
				.getGamePolis().values());
		Hoplite hoplite = new Hoplite(polis_game.getAthensPlayer(), polis_game
				.getAthensPlayer().getCapital());
		polis_game.getAthensPlayer().getPlayerUnits().add(hoplite);

		hoplite.setPosition(polis_game.getAthensPlayer().getCapital());

		boolean assertion = true;
		for (Polis pol : ListOfpolisToCheck) {

			if (!pol.equals(polis_game.getAthensPlayer().getCapital())) {
				assertion = assertion
						&& (GraphNavigatorManager.existsWay(polis_game
								.getAthensPlayer().getCapital(), pol,
								polis_game.getAthensPlayer(), "hoplite"));

			}
		}

		assertTrue(assertion);
	}

	@Test
	public void existsWayHopliteToMarket() {

		List<Market> listOfMarketToCheck = new LinkedList<Market>(polis_game
				.getGameMarkets().values());
		Hoplite hoplite = new Hoplite(polis_game.getAthensPlayer(), polis_game
				.getAthensPlayer().getCapital());
		polis_game.getAthensPlayer().getPlayerUnits().add(hoplite);

		hoplite.setPosition(polis_game.getAthensPlayer().getCapital());

		boolean assertion = true;
		for (Market market : listOfMarketToCheck) {

			assertion = (GraphNavigatorManager.existsWay(polis_game
					.getAthensPlayer().getCapital(), market, polis_game
					.getAthensPlayer(), "hoplite"))
					&& assertion;

		}

		assertFalse(assertion);
	}

	@Test
	public void existsWayTradeBoatToSeaAthensPlayer() {
		List<Sea> seasOfGame = new LinkedList<Sea>(polis_game.getGameSeas()
				.values());
		Sea cycladesIsland = null;
		for (Sea cIsland : seasOfGame) {
			if (cIsland.getSysName().equalsIgnoreCase("cycladesIslands")) {
				cycladesIsland = cIsland;
				break;
			}
		}

		TradeBoat tradeBoat = new TradeBoat(polis_game.getAthensPlayer(),
				cycladesIsland);

		polis_game.getAthensPlayer().getPlayerUnits().add(tradeBoat);

		tradeBoat.setPosition(cycladesIsland);
		boolean assertion = true;

		for (Sea sOfGame : seasOfGame) {

			if (!sOfGame.getSysName().equalsIgnoreCase("cycladesIslands")) {
				assertion = (GraphNavigatorManager.existsWay(cycladesIsland,
						sOfGame, polis_game.getAthensPlayer(), "tradeBoat"))
						&& assertion;
			}
		}

		assertFalse(assertion);
	}

	@Test
	public void existsWayTradeBoatToATerritory() {
		List<Territory> listOfTerritories = new LinkedList<Territory>(
				polis_game.getGameTerritories().values());
		List<Sea> seasOfGame = new LinkedList<Sea>(polis_game.getGameSeas()
				.values());
		Sea cycladesIsland = null;
		for (Sea cIsland : seasOfGame) {
			if (cIsland.getSysName().equalsIgnoreCase("cycladesIslands")) {
				cycladesIsland = cIsland;
				break;
			}
		}

		TradeBoat tradeBoat = new TradeBoat(polis_game.getAthensPlayer(),
				cycladesIsland);

		polis_game.getAthensPlayer().getPlayerUnits().add(tradeBoat);

		tradeBoat.setPosition(cycladesIsland);
		boolean assertion = true;
		for (Territory territoryToGo : listOfTerritories) {

			assertion = (GraphNavigatorManager.existsWay(cycladesIsland,
					territoryToGo, polis_game.getAthensPlayer(), "tradeBoat"))
					&& assertion;
		}

		assertFalse(assertion);
	}

	@Test
	public void existWayTradeboatToABlockSea() {
		List<Sea> seasOfGame = new LinkedList<Sea>(polis_game.getGameSeas()
				.values());
		List<Market> listOfMarket = new LinkedList<Market>(polis_game
				.getGameMarkets().values());
		Market marketIllyria = null;
		for (Market market : listOfMarket) {
			if (market.getSysName().equalsIgnoreCase("illyria")) {
				marketIllyria = market;
				break;
			}
		}

		Sea ionianSea = null;

		for (Sea Io : seasOfGame) {
			if (Io.getSysName().equalsIgnoreCase("ionianSea")) {
				ionianSea = Io;
				break;
			}

		}
		Trirreme spartanTrirreme;
		spartanTrirreme = new Trirreme(polis_game.getSpartaPlayer(), ionianSea);
		polis_game.getSpartaPlayer().addUnit(spartanTrirreme);

		boolean assertion = true;
		for (Sea allSeas : seasOfGame) {
			if (!allSeas.getSysName().equalsIgnoreCase("ionianSea")) {
				TradeBoat athensBoat = new TradeBoat(polis_game
						.getAthensPlayer(), allSeas);
				polis_game.getAthensPlayer().addUnit(athensBoat);

				assertion = (GraphNavigatorManager.existsWay(allSeas,
						marketIllyria, polis_game.getAthensPlayer(),
						"tradeBoat"))
						&& assertion;
			}

		}
		assertFalse(assertion);

	}

	@Test
	public void existWayTradeboatToASeaWithEqualsTrirremes() {
		List<Sea> seasOfGame = new LinkedList<Sea>(polis_game.getGameSeas()
				.values());
		List<Market> listOfMarket = new LinkedList<Market>(polis_game
				.getGameMarkets().values());
		Market marketIllyria = null;
		for (Market market : listOfMarket) {
			if (market.getSysName().equalsIgnoreCase("illyria")) {
				marketIllyria = market;
				break;
			}
		}

		Sea ionianSea = null;

		for (Sea Io : seasOfGame) {
			if (Io.getSysName().equalsIgnoreCase("ionianSea")) {
				ionianSea = Io;
				break;
			}

		}

		Sea myrtonSea = null;

		for (Sea Io : seasOfGame) {
			if (Io.getSysName().equalsIgnoreCase("myrtoanSea")) {
				myrtonSea = Io;
				break;
			}

		}
		// Trirreme spartanTrirreme,
		Trirreme athensTrirreme;
		Trirreme athensTrirreme2;
		// spartanTrirreme = new Trirreme(polis_game.getSpartaPlayer(),
		// ionianSea);
		// polis_game.getSpartaPlayer().addUnit(spartanTrirreme);
		athensTrirreme = new Trirreme(polis_game.getAthensPlayer(), ionianSea);
		polis_game.getAthensPlayer().addUnit(athensTrirreme);
		athensTrirreme2 = new Trirreme(polis_game.getAthensPlayer(), myrtonSea);
		polis_game.getAthensPlayer().addUnit(athensTrirreme2);

		Sea cycladesIsland = null;
		for (Sea cIsland : seasOfGame) {
			if (cIsland.getSysName().equalsIgnoreCase("cycladesIslands")) {
				cycladesIsland = cIsland;
				break;
			}

		}
		assertTrue(GraphNavigatorManager.existsWay(cycladesIsland,
				marketIllyria, polis_game.getAthensPlayer(), "tradeBoat"));

	}

	@Test
	public void existWayTrirremeToSea() {

		List<Sea> seasOfGame = new LinkedList<Sea>(polis_game.getGameSeas()
				.values());

		Sea thraceSea = null;
		for (Sea Io : seasOfGame) {
			if (Io.getSysName().equalsIgnoreCase("thraceSea")) {
				thraceSea = Io;
				break;
			}

		}

		Sea cycladesIsland = null;
		for (Sea cIsland : seasOfGame) {
			if (cIsland.getSysName().equalsIgnoreCase("cycladesIslands")) {
				cycladesIsland = cIsland;
				break;
			}

		}

		Trirreme trirreme = new Trirreme(polis_game.getAthensPlayer(),
				cycladesIsland);
		polis_game.getAthensPlayer().addUnit(trirreme);

		assertTrue(GraphNavigatorManager.existsWay(cycladesIsland, thraceSea,
				polis_game.getAthensPlayer(), "trirreme"));

	}

	@Test(expected = NullPointerException.class)
	public void existWayProxenusNull() {

		GraphNavigatorManager.existsWayForProxenus(null, null, null, null);
	}

	@Test
	public void existProxenusToTerritory() {
		List<Territory> listOfTerritory = new LinkedList<Territory>(polis_game
				.getGameTerritories().values());

		Territory laconiaTerritory = null;
		for (Territory terr : listOfTerritory) {
			if (terr.getSysName().equalsIgnoreCase("laconia")) {
				laconiaTerritory = terr;
				break;
			}
		}
		Proxenus atheansProxenus = new Proxenus(polis_game.getAthensPlayer(),
				polis_game.getAthensPlayer().getCapital());
		polis_game.getAthensPlayer().getCapital().addUnit(atheansProxenus);
		
		
		
		assertTrue(GraphNavigatorManager.existsWayForProxenus(polis_game.getAthensPlayer().getCapital(), laconiaTerritory, polis_game.getAthensPlayer(), "proxenus")> 1);
		
		

	}
	@Test
	public void existProxenus2EqualsTerritory(){
		Proxenus atheansProxenus = new Proxenus(polis_game.getAthensPlayer(),
				polis_game.getAthensPlayer().getCapital());
		polis_game.getAthensPlayer().getCapital().addUnit(atheansProxenus);
		
		
		
		assertTrue(GraphNavigatorManager.existsWayForProxenus(polis_game.getAthensPlayer().getCapital(), polis_game.getAthensPlayer().getCapital(), polis_game.getAthensPlayer(), "proxenus") == -1);
		
		
		
		
	}

}