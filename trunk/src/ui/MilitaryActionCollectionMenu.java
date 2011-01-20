package ui;

import exceptions.PolisGameRunningException;
import game.AvailableActionsManager;
import game.Game;
import game.Player;
import game.Territory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MilitaryActionCollectionMenu extends AbstractMenu {
	private Game game;
	private List<String> availableValuesForRequest;
	private List<Territory> territoriesToPlunder;
	
	public MilitaryActionCollectionMenu(Map<String, String> gameTexts, List<IMenu> menuList, Game game) {
		super(gameTexts, menuList);
		if (game == null) throw new IllegalArgumentException("'game' cannot be null");
		this.game = game;
		availableValuesForRequest = new ArrayList<String>();
		territoriesToPlunder = new ArrayList<Territory>();
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
			
			// Opciones de territorios a saquear
			Map<String, Territory> gameTerritories = game.getGameTerritories();
			for (Territory territory: gameTerritories.values()) {
				if (AvailableActionsManager.checkPlunderTerritoryAction(currentPlayer, territory, game.getRound(), 1)) {
					territoriesToPlunder.add(territory);
					
					// Nueva opcion para el menu
					optList.add(territory.getName());
					Integer optionIndex = availableValuesForRequest.size();
					availableValuesForRequest.add(optionIndex.toString());
				}
			}
		}
		
		showMenuContents();
		setPlayerChoice(requestPlayerChoice(getAvailableValuesForRequest()));
	}

	private List<String> getAvailableValuesForRequest() {
		return availableValuesForRequest;
	}
	
	public String getHeaderMessage() {
		return getGameTexts().get("gameMilitaryActionCollectionMenu_headerMessage");
	}

	public IMenu getNextMenu() {
		IMenu next;
		Integer userChoice = getPlayerChoice();
		if (userChoice < 0 || userChoice > (availableValuesForRequest.size() - 1)) throw new PolisGameRunningException("Option not available choosen at MilitaryActionCollectionMenu");
		
		if(userChoice.equals(0)){
			next = getMenuList().get((getMenuList().size()-1) - 1);
		} else {
			Territory choosenTerritoryToPlunder = territoriesToPlunder.get(userChoice - 1);
			next = new MilitaryActionCollectionResourceMenu(getGameTexts(), getMenuList(), game, choosenTerritoryToPlunder);
		}
		
		return next;
	}
}
