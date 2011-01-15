package ui;

import exceptions.PolisGameRunningException;
import game.Game;
import game.Territory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MilitaryActionCollectionRepeatMenu extends AbstractMenu {
	private Game game;
	private List<String> availableValuesForRequest;
	private Territory territoryToPlunder;
	private Map<String, Integer> resourceTypeUnitCount;
	
	public MilitaryActionCollectionRepeatMenu(Map<String, String> gameTexts, List<IMenu> menuList, Game game, Territory territoryToPlunder, Map<String, Integer> resourceTypeUnitCount) {
		super(gameTexts, menuList);
		if (game == null) throw new IllegalArgumentException("'game' cannot be null");
		this.game = game;
		availableValuesForRequest = new ArrayList<String>();
		this.territoryToPlunder = territoryToPlunder;
		this.resourceTypeUnitCount = resourceTypeUnitCount;
		resourceTypeUnitCount = new HashMap<String, Integer>(6);
	}

	public Game getGame(){
		return game;
	}
	
	public void setGame(Game game){
		this.game = game;
	}
	
	public void execute() {
		List<String> optList = getMenuOptionsList();
		Map<String, String> texts = getGameTexts();
		
		if(getMenuOptionsList().isEmpty()) {
			// Opcion volver
			optList.add(texts.get("back"));
			availableValuesForRequest.add("0");
			
			// Opcion Aceptar
			optList.add(texts.get("yes"));
			availableValuesForRequest.add("1");
			
			// Opcion Cancelar
			optList.add(texts.get("no"));
			availableValuesForRequest.add("2");
		}
		
		showMenuContents();
		setPlayerChoice(requestPlayerChoice(getAvailableValuesForRequest()));
	}

	private List<String> getAvailableValuesForRequest() {
		return availableValuesForRequest;
	}

	public String getHeaderMessage() {
		return getGameTexts().get("gameMilitaryActionCollectionRepeatMenu_headerMessage");
	}

	public IMenu getNextMenu() {
		IMenu next;
		Integer userChoice = getPlayerChoice();
		if (userChoice < 0 || userChoice > (availableValuesForRequest.size() - 1)) throw new PolisGameRunningException("Option not available choosen at MilitaryActionMoveHoplitesUnitCountMenu");

		if(userChoice.equals(0)) {
			next = getMenuList().get((getMenuList().size()-1) - 1);
		} else if (userChoice.equals(1)) {
			// Volvemos atras para hacer otro saqueo
			List<IMenu> menus = getMenuList();
			int currentMenuPosition = menus.indexOf(this);
			next = menus.get(currentMenuPosition - 1);
			
		} else if (userChoice.equals(2)) {
			next = new MilitaryActionCollectionMakeMenu(getGameTexts(), getMenuList(), game, territoryToPlunder, resourceTypeUnitCount);
		} else {
			throw new PolisGameRunningException("Option not available choosen at MilitaryActionCollectionRepeatMenu");
		}
		
		return next;
	}
}
