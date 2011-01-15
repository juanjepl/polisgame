package ui;

import exceptions.PolisGameRunningException;
import game.Game;
import game.Hoplite;
import game.Player;
import game.Territory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MilitaryActionCollectionUnitCountMenu extends AbstractMenu {
	private Game game;
	private List<String> availableValuesForRequest;
	private Territory territoryToPlunder;
	private String resourceToPlunder;
	private Integer hopliteToMakePlunderCount;
	Map<String, Integer> resourceTypeUnitCount;
	
	public MilitaryActionCollectionUnitCountMenu(Map<String, String> gameTexts, List<IMenu> menuList, Game game, Territory territoryToPlunder, String resourceToPlunder) {
		super(gameTexts, menuList);
		if (game == null) throw new IllegalArgumentException("'game' cannot be null");
		this.game = game;
		availableValuesForRequest = new ArrayList<String>();
		this.territoryToPlunder = territoryToPlunder;
		this.resourceToPlunder = resourceToPlunder;	
		resourceTypeUnitCount = new HashMap<String, Integer>(6);
	}

	public Game getGame(){
		return game;
	}
	
	public void setGame(Game game){
		this.game = game;
	}
	
	public void execute() {
		if(getMenuOptionsList().isEmpty()) {
			List<String> optList = getMenuOptionsList();
			Map<String, String> texts = getGameTexts();
			
			Player currentPlayer = game.getWhoHasTheTurn();
			
			// Opcion volver
			optList.add(texts.get("back"));
			availableValuesForRequest.add("0");
			
			// Opciones de numero de hoplitas a usar en el saqueo:
			List<Hoplite> playerHoplites = territoryToPlunder.getHoplitesForAPlayer(currentPlayer);
			for (int i = 0; i < playerHoplites.size(); i++) {
				Integer optionIndex = availableValuesForRequest.size();
				optList.add(optionIndex.toString());
				availableValuesForRequest.add(optionIndex.toString());
			}
		}
		
		showMenuContents();
		setPlayerChoice(requestPlayerChoice(getAvailableValuesForRequest()));
	}

	private List<String> getAvailableValuesForRequest() {
		return availableValuesForRequest;
	}

	public String getHeaderMessage() {
		return getGameTexts().get("gameMilitaryActionCollectionUnitCountMenu_headerMessage");
	}

	public IMenu getNextMenu() {
		IMenu next;
		Integer userChoice = getPlayerChoice();
		if (userChoice < 0 || userChoice > (availableValuesForRequest.size() - 1)) throw new PolisGameRunningException("Option not available choosen at MilitaryActionCollectionCountMenu");

		if(userChoice.equals(0)){
			next = getMenuList().get((getMenuList().size()-1) - 1);
		} else {
			hopliteToMakePlunderCount = userChoice;
			resourceTypeUnitCount.put(resourceToPlunder, hopliteToMakePlunderCount);
			next = new MilitaryActionCollectionRepeatMenu(getGameTexts(), getMenuList(), game, territoryToPlunder, resourceTypeUnitCount);
		}
		
		return next;
	}
}
