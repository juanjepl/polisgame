package ui;

import exceptions.PolisGameRunningException;
import game.AvailableActionsManager;
import game.Game;
import game.Hoplite;
import game.Player;
import game.Position;
import game.Territory;
import game.Unit;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class MilitaryActionMoveHoplitesDestinationMenu extends AbstractMenu {
	private Game game;
	private List<String> availableValuesForRequest;
	private Territory originPosition;
	private List<Territory> destinationPositions;
	
	public MilitaryActionMoveHoplitesDestinationMenu(Map<String, String> gameTexts, List<IMenu> menuList, Game game, Territory originPosition) {
		super(gameTexts, menuList);
		if (game == null) throw new IllegalArgumentException("'game' cannot be null");
		this.game = game;
		this.originPosition = originPosition;
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
			
			// Opciones de territorios de destino
			destinationPositions = new ArrayList<Territory>();
			
			Collection<Territory> gameTerritories = game.getGameTerritories().values();
			for (Territory territory: gameTerritories) {
				if(AvailableActionsManager.checkMoveHopliteAction(game, currentPlayer, game.getRound(), originPosition, territory, 1)) {
					destinationPositions.add(territory);
					
					// Nueva opcion para el menu
					optList.add(territory.getName());
					Integer optionIndex = availableValuesForRequest.size();
					availableValuesForRequest.add(optionIndex.toString());
				}
			}
			
		}
		
		setPlayerChoice(requestPlayerChoice(getAvailableValuesForRequest()));
	}

	private List<String> getAvailableValuesForRequest() {
		return availableValuesForRequest;
	}

	public String getHeaderMessage() {
		return getGameTexts().get("gameMilitaryActionMoveHoplitesOriginMenu_headerMessage");
	}

	public IMenu getNextMenu() {
		Integer userChoice = getPlayerChoice();
		if (userChoice < 0 || userChoice > (availableValuesForRequest.size() - 1)) throw new PolisGameRunningException("Option not available choosen at MilitaryActionMenu");

		Territory choosenDestinationPosition = destinationPositions.get(userChoice - 1);
		//return new MilitaryActionMoveHoplitesUnitCountMenu(getGameTexts(), getMenuList(), game, choosenDestinationPosition);
		return null;
	}
}
