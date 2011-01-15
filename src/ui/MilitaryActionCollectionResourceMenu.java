package ui;

import exceptions.PolisGameRunningException;
import game.Game;
import game.Territory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class MilitaryActionCollectionResourceMenu extends AbstractMenu {
	private Game game;
	private List<String> availableValuesForRequest;
	private Territory territoryToPlunder;
	private Map<Integer, String> availableResources;
	
	public MilitaryActionCollectionResourceMenu(Map<String, String> gameTexts, List<IMenu> menuList, Game game, Territory territoryToPlunder) {
		super(gameTexts, menuList);
		if (game == null) throw new IllegalArgumentException("'game' cannot be null");
		this.game = game;
		this.territoryToPlunder = territoryToPlunder;
		availableValuesForRequest = new ArrayList<String>();
		availableResources = new HashMap<Integer, String>(6);
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
			
			// Opcion volver
			optList.add(texts.get("back"));
			availableValuesForRequest.add("0");
				
			// Opciones de recursos
			Map<String, Vector<Integer>> territoryResources = territoryToPlunder.getResources();
			Integer i = 1;
			for (String resourceName: territoryResources.keySet()) {
				
				// Opcion de recurso
				optList.add(texts.get(resourceName));
				availableValuesForRequest.add(i.toString());
				availableResources.put(i, resourceName);
				i++;
			}
		}
		
		showMenuContents();
		setPlayerChoice(requestPlayerChoice(getAvailableValuesForRequest()));
	}

	private List<String> getAvailableValuesForRequest() {
		return availableValuesForRequest;
	}

	public String getHeaderMessage() {
		return getGameTexts().get("gameMilitaryActionCollectionResourceMenu_headerMessage");
	}

	public IMenu getNextMenu() {
		IMenu next;
		
		Integer userChoice = getPlayerChoice();
		if (userChoice < 0 || userChoice > (availableValuesForRequest.size() - 1)) throw new PolisGameRunningException("Option not available choosen at MilitaryActionMoveTrirremesDestinationMenu");
		
		if(userChoice.equals(0)){
			next = getMenuList().get((getMenuList().size()-1) - 1);
		} else {
			String resourceToPlunder = availableResources.get(userChoice);
			next = new MilitaryActionCollectionUnitCountMenu(getGameTexts(), getMenuList(), game, territoryToPlunder, resourceToPlunder);
		}
		
		return next;
	}
}
