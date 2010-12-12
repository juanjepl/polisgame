package tests;

import static org.junit.Assert.assertTrue;
import game.ElementsInitializer;
import game.EndRoundManager;
import game.Game;
import game.Player;
import game.Project;
import game.StandardStartInitializer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestEndRoundManager {
	ElementsInitializer gameElements;
	Game polis_game;
	EndRoundManager round;

	@Before
	public void setup() {
		ElementsInitializer gameElements = new ElementsInitializer();
		Game polis_game = gameElements.InitializeGameElements(); // Initializes
		// all game
		// elements

		StandardStartInitializer.standardStart(polis_game); // Initializes the
		// game standard
		// start position

		polis_game.getRound().startRound(polis_game); // Starts initial round

		@SuppressWarnings("unused")
		EndRoundManager round = new EndRoundManager();
	}

	@After
	public void tearDown() {
	}

	@Test(expected = NullPointerException.class)
	public void checkProjectsNulls() {

		// EndRoundManager round = new EndRoundManager();

		round.checkProjects(null);
	}

	@Test
	public void checkProjectsNotNullsAndFidiasArtist() {

		Project project = null;

		Player player = polis_game.getAthensPlayer();

		for (Project proj : polis_game.getProjectList()) {
			if (proj.getSysName() == "phidiasArtist") {

				project = proj;
				break;
			}
		}
		player.getCapital().addProject(project);
		round.checkProjects(player);
		assertTrue(player.getPrestige() == 3);
	}

	@Test
	public void checkProjectsNotNulls() {

		Project project = null;

		Player player = polis_game.getAthensPlayer();

		for (Project proj : polis_game.getProjectList()) {
			if (proj.getSysName() == "normalTheatre") {

				project = proj;
				break;
			}
		}
		player.getCapital().addProject(project);
		round.checkProjects(player);
		assertTrue(player.getPrestige() == 2);
	}

	@Test(expected = NullPointerException.class)
	public void checkMegalopolisNulls() {

		round.checkMegalopolis(null);

	}

	public void checkMegalopolisNotNulls() {

		polis_game.getAthensPlayer().getCapital().setActualPopulation(10);
		polis_game.getAthensPlayer().setPrestige(0);
		round.checkMegalopolis(polis_game.getAthensPlayer());
		assertTrue(polis_game.getAthensPlayer().getPrestige() == 1);
	}

	@Test(expected = NullPointerException.class)
	public void checkGoodsAdjustNull() {

		round.checkGoodsAdjust(null);
	}

	@Test
	public void checkGoodsAdjustNotNull() {
		polis_game.getAthensPlayer().setMetal(10);
		polis_game.getAthensPlayer().setSilver(20);
		polis_game.getAthensPlayer().setWheat(30);
		polis_game.getAthensPlayer().setWine(40);
		polis_game.getAthensPlayer().setOil(50);
		polis_game.getAthensPlayer().setWood(60);
		// Must be 15 Wheat, 20 wine, 25 oil
		round.checkGoodsAdjust(polis_game.getAthensPlayer());
		boolean logic;
		logic = (polis_game.getAthensPlayer().getWheat() == 15)
				&& (polis_game.getAthensPlayer().getWine() == 20)
				&& (polis_game.getAthensPlayer().getOil() == 25);

		assertTrue(logic);

	}
}
