package ui;

import exceptions.PolisGameRunningException;
import game.Game;
import game.Player;
import game.Position;
import game.Sea;
import game.Trirreme;
import game.Unit;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MilitaryActionMoveTrirremesOriginMenu extends AbstractMenu {
	private Game game;
	private List<String> availableValuesForRequest;
	private List<Sea> originPositions;
	
	public MilitaryActionMoveTrirremesOriginMenu(Map<String, String> gameTexts, List<IMenu> menuList, Game game) {
		super(gameTexts, menuList);
		if (game == null) throw new IllegalArgumentException("'game' cannot be null");
		this.game = game;
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
			
			// Opcion volver
			optList.add(texts.get("back"));
			availableValuesForRequest.add("0");
			
			// Opciones de oceanos de origen			
			Player currentPlayer = game.getWhoHasTheTurn();
			originPositions = new ArrayList<Sea>();		
			List<Unit> playerUnits = currentPlayer.getPlayerUnits();	
			
			for (Unit unit: playerUnits) {	
				if (unit instanceof Trirreme) {
					Position unitPosition = unit.getPosition();
					if (unitPosition instanceof Sea && !originPositions.contains(unitPosition)) {
						originPositions.add((Sea)unitPosition);
						
						// Nueva opcion para el menu
						optList.add(unitPosition.getName());
						Integer optionIndex = availableValuesForRequest.size();
						availableValuesForRequest.add(optionIndex.toString());
					}
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
		return getGameTexts().get("gameMilitaryActionMoveTrirremesOriginMenu_headerMessage");
	}

	public IMenu getNextMenu() {
		IMenu next;
		Integer userChoice = getPlayerChoice();
		if (userChoice < 0 || userChoice > (availableValuesForRequest.size() - 1)) throw new PolisGameRunningException("Option not available choosen at MilitaryActionMoveTrirremesOriginMenu");
		
		if(userChoice.equals(0)){
			next = getMenuList().get((getMenuList().size()-1) - 1);
		} else {
			Sea choosenOriginPosition = originPositions.get(userChoice - 1);
			next = new MilitaryActionMoveTrirremesDestinationMenu(getGameTexts(), getMenuList(), game, choosenOriginPosition);
		}
		
		return next;
	}
}
