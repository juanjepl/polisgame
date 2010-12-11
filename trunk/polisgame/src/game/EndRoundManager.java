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

			for (int i = 0; i < ListOfpolisToCheck.size(); i++) {
				// lock for sieged polis
				if (ListOfpolisToCheck.get(i).getSieged()) {

					if (ListOfpolisToCheck.get(i).getUnits().get(1).getOwner()
							.equals(player)) {

						// Neutral Polis
						if (!enemyPlayer.getPlayerPolis().contains(
								ListOfpolisToCheck.get(i))) {

							Integer rollDice = TextModeUi.showRollTheDice(1);

							Integer newPopulation = ListOfpolisToCheck.get(i)
									.getBasePopulation();
							newPopulation = newPopulation - rollDice;

							if (newPopulation <= 0) {
								newPopulation = 1;
							}
							// Now UI Repoblate the polis with his hoplites
							// FIXME
							ListOfpolisToCheck.get(i).setSieged(false);
							player.getPlayerPolis().add(
									ListOfpolisToCheck.get(i));
							Integer prestige = ListOfpolisToCheck.get(i)
									.getActualPopulation();
							prestige = prestige + player.getPrestige();
							player.setPrestige(prestige);

						} else {
							// First kill proxenus
							if ((enemyPlayer.getPlayerProxenus() != null)
									&& (enemyPlayer.getPlayerProxenus()
											.getPosition()
											.equals(ListOfpolisToCheck.get(i)))) {
								enemyPlayer.setPlayerProxenus(null);
							}

							Polis enemyPolis = null;
							for (Polis pol : enemyPlayer.getPlayerPolis()) {
								if (pol.equals(ListOfpolisToCheck.get(i))) {

									enemyPolis = pol;
									break;
								}
							}
							// Integer indexEnemyPolis = enemyPlayer
							// .getPlayerPolis().indexOf(enemyPolis);
							// Lock for A player
							if (!ListOfpolisToCheck.get(i).getLockForAPlayer(
									player)) {
								// Remove Enemy Units
								// Easily remove enemyPolis with all their units
								enemyPlayer.getPlayerPolis().remove(enemyPolis);

							} else {

								// Enemy Units Must GO FIXME
								// Then remove Polis
								enemyPlayer.getPlayerPolis().remove(enemyPolis);
							}
							// Add polis
							// Recalculate population with UI FIXME
							// Add prestige

							Integer rollDice = TextModeUi.showRollTheDice(1);

							Integer newPopulation = ListOfpolisToCheck.get(i)
									.getBasePopulation();
							newPopulation = newPopulation - rollDice;

							if (newPopulation <= 0) {
								newPopulation = 1;
							}
							// Now UI Repoblate the polis with his hoplites
							// FIXME
							ListOfpolisToCheck.get(i).setSieged(false);
							player.getPlayerPolis().add(
									ListOfpolisToCheck.get(i));
							Integer prestige = ListOfpolisToCheck.get(i)
									.getActualPopulation();
							prestige = prestige + player.getPrestige();
							player.setPrestige(prestige);

						}

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
	public void initializeNextRound(Game game) {
		
		// All plundered territories reborns like not plundered
		for(Territory terr : game.getGameTerritories().values()){
			if(terr.getPlundered() == true){
				terr.setPlundered(false);
			}
		}
		
		// Trade boats returns to its trade docks
		for(Market mark : game.getGameMarkets().values()){
			for(Unit u: mark.getUnits()){
				if(u instanceof TradeBoat){
					mark.removeUnit(u);
					u.getOwner().getPlayerTradeDock().addUnit(u);
					u.setPosition(u.getOwner().getPlayerTradeDock());
				}
			}
		}

		// Sign projects from previous round like used.
		for(Project proj : game.getRound().getProjectsInThisRound()){
			proj.setUsed(true);
		}
		
		// Change name of round and positions allowed for it, get 3 new projects and the new game event
		game.getRound().startRound(game);
		
		// Player with less prestige, starts the round
		
		Integer prestigeAth = game.getAthensPlayer().getPrestige();
		Integer prestigeSpa = game.getSpartaPlayer().getPrestige();
		
		if(prestigeAth > prestigeSpa){
			game.setWhoHasTheTurn(game.getSpartaPlayer());
		}else if(prestigeAth < prestigeSpa){
			game.setWhoHasTheTurn(game.getAthensPlayer());
		}else{ // prestigeAth == prestigeSpa
			// Do nothing (the turn is ordered by previous round ending)
		}
	}
}
