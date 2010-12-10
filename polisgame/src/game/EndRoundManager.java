package game;

import java.util.List;


import ui.TextModeUi;

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
		ListOfpolisToCheck.addAll(game.getGamePolis().values());
		Player enemyPlayer;

		if (!ListOfpolisToCheck.isEmpty()) {

			// CHECK ENEMY
			if (player.equals(game.getAthensPlayer())) {

				enemyPlayer = game.getSpartaPlayer();
			} else {

				enemyPlayer = game.getAthensPlayer();
			}
			for (int i = 0; i < player.getPlayerPolis().size(); i++) {
				// Check if Sieged Polis is Nuetral
				if ((player.getPlayerPolis().get(i).getSieged())
						&& (!enemyPlayer.getPlayerPolis().contains(
								player.getPlayerPolis().get(i)))) {
					// Polis is added to Player
					// Siege False and population is recalculate

					player.getPlayerPolis().get(i).setSieged(false);

					Integer rollDice = TextModeUi.showRollTheDice(1);
					;

					Integer newPopulation = player.getPlayerPolis().get(i)
							.getBasePopulation();
					newPopulation = newPopulation - rollDice;
					if (newPopulation <= 0) {
						newPopulation = 1;
					}
					// We have to repopulate the polis with hoplites
					// Necesary UI FIXME
					// AddPrestige
					Integer Prestige = player.getPlayerPolis().get(i)
							.getActualPopulation();
					Prestige = Prestige + player.getPrestige();
					player.setPrestige(Prestige);
				}
				// Check if sieged Polis is enemy
				if ((player.getPlayerPolis().get(i).getSieged())
						&& (enemyPlayer.getPlayerPolis().contains(player
								.getPlayerPolis().get(i)))) {
					if (!enemyPlayer.getPlayerPolis().get(i).getLockForAPlayer(
							player)) {

						// Remove Units
						for (int a = 0; a < enemyPlayer.getPlayerPolis().get(i)
								.getUnits().size(); a++) {
							enemyPlayer.removeUnit(enemyPlayer.getPlayerPolis()
									.get(i).getUnits().get(a));
						}

					} else {
						// Enemy Units must go
					}
					// Remove Enemy Proxenus

					if ((enemyPlayer.getPlayerProxenus() != null)
							&& (enemyPlayer.getPlayerProxenus().getPosition()
									.equals(player.getPlayerPolis().get(i)))) {
						enemyPlayer.removeUnit(enemyPlayer.getPlayerProxenus());

					}
					// AddPolis
					player.getPlayerPolis().get(i).setSieged(false);
					Integer rollDice = TextModeUi.showRollTheDice(1);
					;

					Integer newPopulation = player.getPlayerPolis().get(i)
							.getBasePopulation();
					newPopulation = newPopulation - rollDice;
					if (newPopulation <= 0) {
						newPopulation = 1;
					}
					// We have to repopulate the polis with hoplites
					// Necesary UI FIXME
					// Remove polis
					// AddPrestige
					enemyPlayer.getPlayerPolis().remove(
							enemyPlayer.getPlayerPolis().get(i));
					Integer Prestige = player.getPlayerPolis().get(i)
							.getActualPopulation();
					Prestige = Prestige + player.getPrestige();
					player.setPrestige(Prestige);
				}

			}
		}
	}

	/**
	 * This method checks for any started project, who player obtains its
	 * prestige
	 */
	public void checkProjects(Player player) {
		if (player == null) {
			throw new NullPointerException(
					"Player in checkProjects can´t be Null");
		}

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
	public void checkFeeding(Player player) {
		// check if player can feed with wheat
		Integer amountOfWheatNeeded = 0;
		for (Polis p : player.getPlayerPolis()) {
			amountOfWheatNeeded += p.getActualPopulation();
		}

		if (player.getWheat() >= amountOfWheatNeeded) {
			// player can feed with wheat
			player.setWheat(player.getWheat() - amountOfWheatNeeded);
		} else {
			// player pays all disponible wheat
			Integer feededPopulation = player.getWheat();
			Integer pendingFeedingPopulation = amountOfWheatNeeded
					- player.getWheat();
			player.setWheat(0);
			// player can't feed with wheat so he needs to paid with prestige or
			// loose some polis
			TextModeUi.showMessage("");
			TextModeUi.showMessage("Se han podido alimentar "
					+ feededPopulation + " ciudadanos");

			while (pendingFeedingPopulation > 0) {
				TextModeUi.showMessage("");
				TextModeUi.showMessage("Quedan " + pendingFeedingPopulation
						+ " ciudadanos por alimentar.");

				// ask to player what method he want to use
				String method = TextModeUi.requestPaidMethod("feeding");

				if (method.equals("prestige")) {
					pendingFeedingPopulation -= 1;
					player.setPrestige(player.getPrestige() - 1);

				} else if (method.equals("polis")) {

					String p = TextModeUi.requestLoosePolis(); // FIXME create
																// method in
																// TextModeUi
					Integer polisId = Integer.parseInt(p);
					Polis polis = player.getPlayerPolis().get(polisId);

					pendingFeedingPopulation -= polis.getActualPopulation();
					if (pendingFeedingPopulation < 0) {
						pendingFeedingPopulation = 0;
					}
					player.getPlayerPolis().remove(polis);

				}
			}
		}

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
