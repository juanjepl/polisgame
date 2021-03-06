package ui;

import exceptions.PolisGameRunningException;
import game.Game;
import game.Hoplite;
import game.Player;
import game.Position;
import game.Territory;
import game.Unit;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MilitaryActionMoveHoplitesOriginMenu extends AbstractMenu {
	private Game game;
	private List<String> availableValuesForRequest;
	private List<Territory> originPositions;
	
	public MilitaryActionMoveHoplitesOriginMenu(Map<String, String> gameTexts, List<IMenu> menuList, Game game) {
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
			
			// Opciones de territorios de origen			
			Player currentPlayer = game.getWhoHasTheTurn();
			originPositions = new ArrayList<Territory>();		
			List<Unit> playerUnits = currentPlayer.getPlayerUnits();	
			
			for (Unit unit: playerUnits) {	
				if (unit instanceof Hoplite) {
					Position unitPosition = unit.getPosition();
					if (unitPosition instanceof Territory && !originPositions.contains(unitPosition)) {
						originPositions.add((Territory)unitPosition);
						
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
		return getGameTexts().get("gameMilitaryActionMoveHoplitesOriginMenu_headerMessage");
	}

	public IMenu getNextMenu() {
		IMenu next;
		Integer userChoice = getPlayerChoice();
		if (userChoice < 0 || userChoice > (availableValuesForRequest.size() - 1)) throw new PolisGameRunningException("Option not available choosen at MilitaryActionMoveHoplitesOriginMenu");
		
		if(userChoice.equals(0)){
			next = getMenuList().get((getMenuList().size()-1) - 1);
		} else {
			Territory choosenOriginPosition = originPositions.get(userChoice - 1);
			next = new MilitaryActionMoveHoplitesDestinationMenu(getGameTexts(), getMenuList(), game, choosenOriginPosition);
		}
		
		return next;
	}
}
