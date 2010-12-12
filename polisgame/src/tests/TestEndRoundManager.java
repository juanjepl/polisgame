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
	}

	@After
	public void tearDown() {
	}

	@Test(expected = NullPointerException.class)
	public void checkProjectsNulls() {

		EndRoundManager round = new EndRoundManager();

		round.checkProjects(null);
	}

	@Test(expected = NullPointerException.class)
	public void checkProjectsNoNulls() {

		EndRoundManager round = new EndRoundManager();
		Project project = null;

		Player player = polis_game.getAthensPlayer();
		// player.getCapital().addProject()
		for (Project proj : polis_game.getProjectList()) {
			if (proj.getSysName() == "fidiasArtist") {

				project = proj;
				break;
			}
		}
		player.getCapital().addProject(project);
		round.checkProjects(player);
		assertTrue(player.getPrestige() != 0);
	}
}
