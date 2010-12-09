package game;

import java.util.List;

/** This class, contains methods to manage the end of game rounds */
public class EndRoundManager {

	public EndRoundManager() {
	}

	/** This method checks for any sieged polis, if siege completes or not */
	public void checkSieges(Game game, Player player) {
		if (game == null) {
			throw new NullPointerException("Game in CheckSieges can´t be Null");
		}
		if (player == null) {
			throw new NullPointerException(
					"Player in CheckSieges can´t be Null");
		}
		// TODO
		List<Polis> ListOfpolisToCheck;
		ListOfpolisToCheck = (List<Polis>) game.getGamePolis().values();

		if (ListOfpolisToCheck.size() != 0) {
			Polis polisToCheck;
			List<Polis> listOfPolisPlayer;
			List<Polis> listOfPolisEnemyPlayer;
			listOfPolisPlayer = player.getPlayerPolis();

			// CHECK ENEMY
			if (player.equals(game.getAthensPlayer())) {
				listOfPolisEnemyPlayer = game.getSpartaPlayer()
						.getPlayerPolis();
			} else {
				listOfPolisEnemyPlayer = game.getAthensPlayer()
						.getPlayerPolis();
			}

			for (int i = 0; i < ListOfpolisToCheck.size(); i++) {
				polisToCheck = ListOfpolisToCheck.get(i);
				if (polisToCheck.getSieged()) {
					if (((!(listOfPolisPlayer.contains(polisToCheck) && (!listOfPolisEnemyPlayer
							.contains(polisToCheck)))))) {
						player.addPolis(polisToCheck);
						// FIXME We have to check the population afer siege
						// We need to have contact with UserInterface
					} else {
						if ((!(listOfPolisPlayer.contains(polisToCheck) && (listOfPolisEnemyPlayer
								.contains(polisToCheck))))) {
							// FIXME needs a method that check locks for this
							// enemy
							// siege

						}
					}

				}
			}
		} else {
			// Do Nothing
		}

	}

	/**
	 * This method checks for any started project, who player obtains its
	 * prestige
	 */
	public void checkProjects(Player player) {
		if (player ==  null ){
			throw new NullPointerException("Player in checkProjects can´t be Null");
		}
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
						Integer population;
						Integer prestige;
						population = polisToCheck.getActualPopulation();

						if (population % 2 == 0) {
							population = population / 2;
							prestige = player.getPrestige();
							prestige = prestige + population;
							player.setPrestige(prestige);
						} else {
							population = population / 2;
							prestige = player.getPrestige();
							prestige = prestige + population + 1;
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
	public void checkMegalopolis(Player player) {

		for (Polis p : player.getPlayerPolis()) {
			if (p.getActualPopulation() > p.getBasePopulation()) {
				player.setPrestige(player.getPrestige() + 1);
			}
		}

	}

	/**
	 * This method manages the by-two divison of perishables surplus (rounded
	 * up)
	 */
	public void checkGoodsAdjust(Player player) {

		player.setOil(Math.round((player.getOil() / 2)));
		player.setWine(Math.round((player.getWine() / 2)));
		player.setWheat(Math.round((player.getWheat() / 2)));

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
