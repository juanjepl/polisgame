package tests;

import static org.junit.Assert.assertTrue;

import java.util.LinkedList;
import java.util.List;

import game.ElementsInitializer;
import game.EndRoundManager;
import game.Game;
import game.Player;
import game.Polis;
import game.Project;
import game.StandardStartInitializer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestEndRoundManager {
	ElementsInitializer gameElements;
	Game polis_game;
	EndRoundManager endRound;

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

		endRound = new EndRoundManager();
	}

	@After
	public void tearDown() {
	}

	@Test(expected = NullPointerException.class)
	public void checkProjectsNulls() {

		endRound.checkProjects(null);
	}

	@Test
	public void checkProjectsNotNullsAndFidiasArtist() {

		Project project = null;

		Player player = polis_game.getAthensPlayer();

		for (Project proj : polis_game.getProjectList()) {
			if (proj.getSysName().equalsIgnoreCase("phidiasArtist")) {

				project = proj;
				break;
			}
		}
		if (project == null) {
			System.out.println("ESTA NULO EL PROYECTO DE FIDIAS");
		}
		project.setFinished(true);
		project.setUsed(true);
		player.getCapital().addProject(project);
		endRound.checkProjects(player);
		player.setPrestige(0);
		player.getCapital().setActualPopulation(10);
		assertTrue(player.getPrestige() > 0);
	}

	@Test
	public void checkProjectsNotNulls() {

		Project project = null;

		Player player = polis_game.getAthensPlayer();

		for (Project proj : polis_game.getProjectList()) {
			if (proj.getSysName().equalsIgnoreCase("normalTheatre")) {

				project = proj;
				break;
			}
		}
		project.setFinished(true);
		project.setUsed(true);
		player.getCapital().addProject(project);
		player.setPrestige(0);
		endRound.checkProjects(player);
		assertTrue(player.getPrestige() == 2);
	}

	@Test(expected = NullPointerException.class)
	public void checkMegalopolisNulls() {

		endRound.checkMegalopolis(null);

	}

	@Test
	public void checkMegalopolisNotNulls() {

		polis_game.getAthensPlayer().getCapital().setActualPopulation(10);
		polis_game.getAthensPlayer().setPrestige(0);
		endRound.checkMegalopolis(polis_game.getAthensPlayer());
		assertTrue(polis_game.getAthensPlayer().getPrestige() == 1);
	}

	@Test(expected = NullPointerException.class)
	public void checkGoodsAdjustNull() {

		endRound.checkGoodsAdjust(null);
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
		endRound.checkGoodsAdjust(polis_game.getAthensPlayer());
		boolean logic;
		logic = (polis_game.getAthensPlayer().getWheat() == 15)
				&& (polis_game.getAthensPlayer().getWine() == 20)
				&& (polis_game.getAthensPlayer().getOil() == 25);

		assertTrue(logic);

	}

	@Test(expected = NullPointerException.class)
	public void checkPhorosNull() {
		endRound.checkPhoros(null);
	}

	@Test
	public void checkPhorosNotNull() {
		List<Polis> ListOfpolisToCheck = new LinkedList<Polis>(polis_game
				.getGamePolis().values());

		Polis thebesPolis = null;
		for (Polis pol : ListOfpolisToCheck) {
			if (pol.getSysName().equalsIgnoreCase("thebes")) {

				thebesPolis = pol;
				break;
			}
		}
		polis_game.getAthensPlayer().getPlayerPolis().add(thebesPolis);
		polis_game.getAthensPlayer().setPrestige(10);
		polis_game.getAthensPlayer().setSilver(0);
		endRound.checkPhoros(polis_game.getAthensPlayer());
		assertTrue(polis_game.getAthensPlayer().getSilver() > 0);

	}

	@Test(expected = NullPointerException.class)
	public void checkGrowthNull() {
		endRound.checkGrowth(null, null);
	}

	@Test
	public void checkGrowthNotNullNotPrestige() {
		Integer wheatComparator;
		polis_game.getSpartaPlayer().setWheat(333);
		polis_game.getSpartaPlayer().setPrestige(0);
		wheatComparator = polis_game.getSpartaPlayer().getWheat();
		endRound.checkGrowth(polis_game.getSpartaPlayer(), polis_game
				.getRound());
		assertTrue(polis_game.getSpartaPlayer().getWheat() < wheatComparator);
	}

	@Test
	public void checkGrowthNotNullNotWheat() {
		Integer prestigeComparator;
		polis_game.getSpartaPlayer().setWheat(0);
		polis_game.getSpartaPlayer().setPrestige(333);
		prestigeComparator = polis_game.getSpartaPlayer().getPrestige();
		endRound.checkGrowth(polis_game.getSpartaPlayer(), polis_game
				.getRound());
		assertTrue(polis_game.getSpartaPlayer().getWheat() < prestigeComparator);
	}

	@Test
	public void checkGrowthNotNull() {
		Integer wheatComparator;
		Integer prestigeComparator;
		polis_game.getSpartaPlayer().setWheat(333);
		polis_game.getSpartaPlayer().setPrestige(333);
		wheatComparator = polis_game.getSpartaPlayer().getWheat();
		prestigeComparator = polis_game.getSpartaPlayer().getPrestige();
		endRound.checkGrowth(polis_game.getSpartaPlayer(), polis_game
				.getRound());
		assertTrue((polis_game.getSpartaPlayer().getWheat() < wheatComparator)
				|| (polis_game.getSpartaPlayer().getPrestige() < prestigeComparator));
	}
}
