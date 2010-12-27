package game;


/** This class, contains methods to manage the end of game rounds */
public class EndRoundManager {

	EndRoundCheckSieges ercSieges;
	EndRoundCheckProjects ercProjects;
	EndRoundCheckFeeding ercFeeding;
	EndRoundCheckGrowth ercGrowth;
	EndRoundCheckMegalopolis ercMegalopolis;
	EndRoundCheckGoodsAdjust ercGoodsAdjust;
	EndRoundCheckPhoros ercPhoros;
	EndRoundInitializeNextRound erInitializeNextRound;
	
	public EndRoundManager() {
		//TODO with correct parameters
		
		ercSieges = new EndRoundCheckSieges();
		ercProjects = new EndRoundCheckProjects();
		ercFeeding = new EndRoundCheckFeeding();
		ercGrowth = new EndRoundCheckGrowth();
		ercMegalopolis = new EndRoundCheckMegalopolis();
		ercGoodsAdjust = new EndRoundCheckGoodsAdjust();
		ercPhoros = new EndRoundCheckPhoros();
		erInitializeNextRound = new EndRoundInitializeNextRound();
		
	}

	/** To reuse the same object in some endRounds of the game */
	public void executeAgain(){
		ercSieges = new EndRoundCheckSieges();
		ercProjects = new EndRoundCheckProjects();
		ercFeeding = new EndRoundCheckFeeding();
		ercGrowth = new EndRoundCheckGrowth();
		ercMegalopolis = new EndRoundCheckMegalopolis();
		ercGoodsAdjust = new EndRoundCheckGoodsAdjust();
		ercPhoros = new EndRoundCheckPhoros();
		erInitializeNextRound = new EndRoundInitializeNextRound();
	}
	
	
	/** This method checks for any sieged polis, if siege completes or not */
	
	/*
	public void checkSieges(Game game, Player player) {

		if (game == null) {
			throw new NullPointerException("Game in CheckSieges can´t be Null");
		}
		if (player == null) {
			throw new NullPointerException(
					"Player in CheckSieges can´t be Null");
		}
		// TODO
		List<Polis> ListOfpolisToCheck = new LinkedList<Polis>(game
				.getGamePolis().values());
		Player enemyPlayer;

		// CHECK ENEMY
		if (player.equals(game.getAthensPlayer())) {

			enemyPlayer = game.getSpartaPlayer();
		} else {

			enemyPlayer = game.getAthensPlayer();
		}

		if (!ListOfpolisToCheck.isEmpty()) {

			for (Polis polisToCheck : ListOfpolisToCheck) {
				// Locking for SiegedPolis

				if (polisToCheck.getSieged()) {

					// Check if polisToCheck is a neutral polis
					boolean neutralPolis = true;
					List<Unit> listOfUnitsToCheck = polisToCheck.getUnits();
					for (Unit u : listOfUnitsToCheck) {
						if (u.getOwner().equals(enemyPlayer)) {
							neutralPolis = false;
							break;
						}
					}
					boolean siegedPolis;
					if (neutralPolis) {
						// Siege Complete
						siegedPolis = true;
					} else {
						// Check if Siege have at last one lock
						// If not their units Die
						if (!polisToCheck.getLockForAPlayer(player)) {

							for (Unit u : listOfUnitsToCheck) {
								if (u.getOwner().equals(enemyPlayer)) {
									// Remove
									// Units from SiegedPolis
									// Remove from Player
									polisToCheck.removeUnit(u);
									player.getPlayerUnits().remove(u);

								}
							}
							// Siege Not Complete Because Owner Units DIE
							siegedPolis = false;

						} else {
							// Siege Complete
							siegedPolis = true;

						}
						if (siegedPolis) {
							// KILL Proxenus TODO
							if ((!enemyPlayer.getPlayerProxenus().equals(null))
									&& (enemyPlayer.getPlayerProxenus()
											.getPosition().equals(polisToCheck))) {
								enemyPlayer.setPlayerProxenus(null);
							}
							Integer rollDice = TextModeUi.showRollTheDice(1);
							Integer newPopulation;
							if (neutralPolis) {
								newPopulation = polisToCheck
										.getBasePopulation();
								newPopulation = newPopulation - rollDice;
							} else {
								// NOT NEUTRAL POLIS
								newPopulation = polisToCheck
										.getActualPopulation();
								newPopulation = newPopulation - rollDice;
							}
							if (newPopulation <= 0) {
								newPopulation = 1;
							}
							if (newPopulation < polisToCheck
									.getBasePopulation()) {
								// FIXME USER INTERFACE REQUEST
								// NEED HOPLITES TO GET BASEPOPULATION
								// JUANJE ADVIDE
								Integer hoplitesCounterStriker = 0;
								for (Unit u : listOfUnitsToCheck) {
									if ((u instanceof Hoplite)
											&& (u.getOwner().equals(player))) {
										hoplitesCounterStriker++;
									}
								}
								// FIXME
								// Now UI must Return a int with hoplites to
								// repoblate
								// UI(hoplitesCounterStriker,max
								// (basepopulation-hoplitesCounterStriker,
								// hoplitesCounterStriker-basepopulation);
								Integer UI = 0;
								newPopulation = newPopulation + UI;
								polisToCheck.setActualPopulation(newPopulation);
								// Remove UI units of the list
								while (UI > 0) {
									for (Unit u : listOfUnitsToCheck) {
										if ((u instanceof Hoplite)
												&& (u.getOwner().equals(player))) {
											listOfUnitsToCheck.remove(u);
											UI--;
										}
									}
								}

							}

							// RepoblateTerritory with HoplitesStrikers
							//
							for (Unit u : listOfUnitsToCheck) {
								if ((u instanceof Hoplite)
										&& (u.getOwner().equals(player))) {
									polisToCheck.getPolisParentTerritory()
											.addUnit(u);
									listOfUnitsToCheck.remove(u);
								}
							}
							// Check round and move hoplites

							Integer hoplitesOnTerritory = 0;

							for (Unit u : polisToCheck
									.getPolisParentTerritory().getUnits()) {
								if ((u instanceof Hoplite)
										&& (u.getOwner().equals(player))) {
									hoplitesOnTerritory++;

								}
							}
							Integer maxPostionsForTerritory = game.getRound()
									.getMaximumPositionSlotsForThisRound();
							if (hoplitesOnTerritory > maxPostionsForTerritory) {
								// MOVE THE DIFERENCE
								// UI
								Integer hoplitesToMove = hoplitesOnTerritory
										- maxPostionsForTerritory;
								while (hoplitesToMove > 0) {
									// UI MOVE HOPLITE
									// FIXME
									hoplitesToMove--;
								}
							} else {
								// DO NOTHING BECAUSE HOPLITES ARE RIGHT
							}
							// refresh actualPopulation
							// Change Sieged to false and add polis to player
							polisToCheck.setActualPopulation(newPopulation);
							polisToCheck.setSieged(false);
							player.addPolis(polisToCheck);
						}
					}

				}

			}

		}
	}
	
	*/

	/**
	 * This method checks for any started project, who player obtains its
	 * prestige
	 */
	
	/*
	 
	public void checkProjects(Player player) {
		if (player == null) {
			throw new NullPointerException(
					"Player in checkProjects can´t be Null");
		}

		List<Polis> listPolis;
		listPolis = player.getPlayerPolis();
		List<Project> listOfProjects;

		for (Polis polisToCheck : listPolis) {

			listOfProjects = polisToCheck.getProjects();
			for (Project projectToCheck : listOfProjects) {

				if (projectToCheck.getUsed() && projectToCheck.getFinished()) {

					if ((projectToCheck.getSysName()
							.equalsIgnoreCase("phidiasArtist"))) {
						Integer population;
						Integer prestige;
						population = polisToCheck.getActualPopulation();

						if (population % 2 == 0) {
							population /= 2;
							prestige = player.getPrestige();
							prestige += population;
							player.setPrestige(prestige);
						} else {
							population /= 2;
							prestige = player.getPrestige();
							prestige += population + 1;
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
	
	*/

	/** This method manages Player's population feeding */
	
	/*
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

*/
	/**
	 * This method manages if Players wanna to increase his population using his
	 * wheat surplus
	 */
	
	/*
	public void checkGrowth(Player player, Round round) {

		Map<String, Integer> option;
		Boolean completed = false;
		if (player.getWheat() > 0) {
			while (!completed) {
				option = TextModeUi.requestGrowth();
				String optionName = "";
				for (String name : option.keySet()) {
					optionName = name;
				}
				Integer optionValue = option.get(optionName);

				if (optionName.equals("finalize") || player.getWheat() == 0) {
					// player don't create more population
					completed = true;
				} else {
					// player select one polis for create population

					Polis polis = null;

					// Find polis to add population
					for (Polis p : player.getPlayerPolis()) {
						if (p.getSysName().equals(optionName)) {
							polis = p;
						}
					}

					// add optionValue to ActualPopulation
					polis.setActualPopulation(polis.getActualPopulation()
							+ optionValue);
					// player loose optionValue units of Wheat
					player.setWheat(player.getWheat() - optionValue);

				}
			}

		}

	}
	
	*/

	/**
	 * This method checks in any polis from a player, if has more population
	 * than its base (and puts prestige like rules say)
	 */
	
	/*
	public void checkMegalopolis(Player player) {

		for (Polis p : player.getPlayerPolis()) {
			if (p.getActualPopulation() > p.getBasePopulation()) {
				player.setPrestige(player.getPrestige() + 1);
			}
		}

	}
*/
	/**
	 * This method manages the by-two divison of perishables surplus (rounded
	 * up)
	 */
	
	/*
	public void checkGoodsAdjust(Player player) {

		player.setOil(Math.round((player.getOil() / 2)));
		player.setWine(Math.round((player.getWine() / 2)));
		player.setWheat(Math.round((player.getWheat() / 2)));

	}

*/
	/**
	 * This method checks Phoros rule. (player can trade prestige to silver 1 to
	 * 1)
	 */
	/*
	public void checkPhoros(Player player) {

		// ask to user how many prestige want to spend
		if (player.getPrestige() > 0) {

			Integer prestigeToSpend = TextModeUi.requestPhoros();

			// player obtains prestigeToSpend units of Silver
			player.setSilver(player.getSilver() + prestigeToSpend);
			// player spend prestigeToSpend units of Prestige
			player.setPrestige(player.getPrestige() - prestigeToSpend);

		}
	}

*/
	
	
	/** This method prepares the next round elements */
	
	/*
	public void initializeNextRound(Game game) {

		// All plundered territories reborns like not plundered
		for (Territory terr : game.getGameTerritories().values()) {
			if (terr.getPlundered() == true) {
				terr.setPlundered(false);
			}
		}

		// Trade boats returns to its trade docks
		for (Market mark : game.getGameMarkets().values()) {
			for (Unit u : mark.getUnits()) {
				if (u instanceof TradeBoat) {
					mark.removeUnit(u);
					u.getOwner().getPlayerTradeDock().addUnit(u);
					u.setPosition(u.getOwner().getPlayerTradeDock());
				}
			}
		}

		// Sign projects from previous round like used.
		for (Project proj : game.getRound().getProjectsInThisRound()) {
			proj.setUsed(true);
		}

		// Change name of round and positions allowed for it, get 3 new projects
		// and the new game event
		game.getRound().startRound(game);

		// Player with less prestige, starts the round

		Integer prestigeAth = game.getAthensPlayer().getPrestige();
		Integer prestigeSpa = game.getSpartaPlayer().getPrestige();

		if (prestigeAth > prestigeSpa) {
			game.setWhoHasTheTurn(game.getSpartaPlayer());
		} else if (prestigeAth < prestigeSpa) {
			game.setWhoHasTheTurn(game.getAthensPlayer());
		} else { // prestigeAth == prestigeSpa
			// Do nothing (the turn is ordered by previous round ending)
		}
	}
*/
}

