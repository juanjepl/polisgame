package ui;

import exceptions.PolisGameRunningException;
import game.AvailableActionsManager;
import game.Game;
import game.Player;
import game.Territory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class MilitaryActionCollectionResourceMenu extends AbstractMenu {
	private Game game;
	private List<String> availableValuesForRequest;
	private Territory territoryToPlunder;
	
	public MilitaryActionCollectionResourceMenu(Map<String, String> gameTexts, List<IMenu> menuList, Game game, Territory territoryToPlunder) {
		super(gameTexts, menuList);
		if (game == null) throw new IllegalArgumentException("'game' cannot be null");
		this.game = game;
		this.territoryToPlunder = territoryToPlunder;
		availableValuesForRequest = new ArrayList<String>();
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
			
			
			// Opciones de recursos
			Map<String, Vector<Integer>> territoryResources = territoryToPlunder.getResources();
			
		}
		
		showMenuContents();
		setPlayerChoice(requestPlayerChoice(getAvailableValuesForRequest()));
	}

	private List<String> getAvailableValuesForRequest() {
		return availableValuesForRequest;
	}

	public String getHeaderMessage() {
		return getGameTexts().get("gameMilitaryActionMoveTrirremesDestinationMenu_headerMessage");
	}

	public IMenu getNextMenu() {
		IMenu next;
	
		Integer userChoice = getPlayerChoice();
		if (userChoice < 0 || userChoice > (availableValuesForRequest.size() - 1)) throw new PolisGameRunningException("Option not available choosen at MilitaryActionMoveTrirremesDestinationMenu");
		
		if(userChoice.equals(0)){
			next = getMenuList().get((getMenuList().size()-1) - 1);
		} else {
			Sea choosenDestinationPosition = destinationPositions.get(userChoice - 1);
			next = new MilitaryActionMoveTrirremesUnitCountMenu(getGameTexts(), getMenuList(), game, originPosition, choosenDestinationPosition);
		}
		
		return next;
	}
}
