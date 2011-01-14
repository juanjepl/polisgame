package ui;

import exceptions.PolisGameRunningException;
import game.Game;
import game.Player;
import game.Sea;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MilitaryActionMoveTrirremesUnitCountMenu extends AbstractMenu {
	private Game game;
	private List<String> availableValuesForRequest;
	private Sea originPosition;
	private Sea destinationPosition;
	private Integer unitToMoveCount;
	
	public MilitaryActionMoveTrirremesUnitCountMenu(Map<String, String> gameTexts, List<IMenu> menuList, Game game, Sea originPosition, Sea destinationPosition) {
		super(gameTexts, menuList);
		if (game == null) throw new IllegalArgumentException("'game' cannot be null");
		this.game = game;
		this.originPosition = originPosition;
		this.destinationPosition = destinationPosition;
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
			
			// Opciones de numero de trirremes a mover:
			Integer originPositionUnitCount = originPosition.getTrirremesForAPlayer(currentPlayer).size();
			for (int i = 0; i < originPositionUnitCount; i++) {
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
		return getGameTexts().get("gameMilitaryActionMoveTrirremesUnitCountMenu_headerMessage");
	}

	public IMenu getNextMenu() {
		IMenu next;
		Integer userChoice = getPlayerChoice();
		if (userChoice < 0 || userChoice > (availableValuesForRequest.size() - 1)) throw new PolisGameRunningException("Option not available choosen at MilitaryActionMoveTrirremesUnitCountMenu");

		if(userChoice.equals(0)){
			next = getMenuList().get((getMenuList().size()-1) - 1);
		} else {
			unitToMoveCount = userChoice;
			next = new MilitaryActionMoveTrirremesMakeMenu(getGameTexts(), getMenuList(), game, originPosition, destinationPosition, unitToMoveCount);
		}
		
		return next;
	}
}
