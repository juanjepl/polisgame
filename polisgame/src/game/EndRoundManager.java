package game;

import java.util.List;

/** This class, contains methods to manage the end of game rounds */
public class EndRoundManager {

	public EndRoundManager() {
	}

	/** This method checks for any sieged polis, if siege completes or not */
	public void checkSieges(Game game, Player player) {

		// TODO
		List<Polis> ListOfpolisToCheck;
		ListOfpolisToCheck = (List<Polis>) game.getGamePolis().values();

		Polis polisToCheck;
		List<Polis> listOfPolisPlayer;
		List<Polis> listOfPolisEnemyPlayer;
		listOfPolisPlayer = player.getPlayerPolis();

		// CHECK ENEMY
		if (player.equals(game.getAthensPlayer())) {
			listOfPolisEnemyPlayer = game.getSpartaPlayer().getPlayerPolis();
		} else {
			listOfPolisEnemyPlayer = game.getAthensPlayer().getPlayerPolis();
		}

		for (int i = 0; i < ListOfpolisToCheck.size(); i++) {
			polisToCheck = ListOfpolisToCheck.get(i);
			if (polisToCheck.getSieged()) {
				if (((!(listOfPolisPlayer.contains(polisToCheck) && (!listOfPolisEnemyPlayer
						.contains(polisToCheck)))))) {
					player.addPolis(polisToCheck);
					// FIXME We haves to check the poblation afer siege
					//We needs to have contact with UserInterface
				} else {
					if ((!(listOfPolisPlayer.contains(polisToCheck) && (listOfPolisEnemyPlayer
							.contains(polisToCheck))))) {
						// FIXME needs a method that cheks locks for this enemy
						// siege

					}
				}

			}

		}

	}

	/**
	 * This method checks for any started project, who player obtains its
	 * prestige
	 */
	public void checkProjects(Player player) {

		// TODO
		List<Polis> listPolis;
		listPolis = player.getPlayerPolis();
		List<Project> listOfProjects;
		Polis polisToCheck;
		Project projectToCheck;
		for (int i = 0; i < listPolis.size(); i++) {
			polisToCheck = listPolis.get(i);
			listOfProjects = polisToCheck.getProjects();
			for (int j = 0; j < listOfProjects.size(); j++) {
				projectToCheck = listOfProjects.get(j);
				if (projectToCheck.getUsed() && projectToCheck.getFinished()) {

					if ((projectToCheck.getName().equals("fidiasArtist"))) {
						Integer poblation;
						Integer prestige;
						poblation = polisToCheck.getActualPopulation();

						if (poblation % 2 == 0) {
							poblation = poblation / 2;
							prestige = player.getPrestige();
							prestige = prestige + poblation;
							player.setPrestige(prestige);
						} else {
							poblation = poblation / 2;
							prestige = player.getPrestige();
							prestige = prestige + poblation + 1;
							player.setPrestige(prestige);

						}

					} else {
						Integer prestige = player.getPrestige();
						prestige = prestige + projectToCheck.getPrestige();
						player.setPrestige(prestige);
					}
				}

			}

		}

	}

	/** This method manages Player's population feeding */
	public void checkFeeding() {

		// TODO

	}

	/**
	 * This method manages if Players wanna to increase his population using his
	 * wheat surplus
	 */
	public void checkGrowth() {

		// TODO

	}

	/**
	 * This method checks in any polis from a player, if has more population
	 * than its base (and puts prestige like rules say)
	 */
	public void checkMegalopolis() {

		// TODO

	}

	/**
	 * This method manages the by-two divison of perishables surplus (rounded
	 * up)
	 */
	public void checkGoodsAdjust() {

		// TODO

	}

	/**
	 * This method checks Phoros rule. (player can trade prestige to silver 1 to
	 * 1)
	 */
	public void checkPhoros() {

		// TODO

	}

	/** This method prepares the next round elements */
	public void initializeNextRound() {

		// TODO

	}
}
