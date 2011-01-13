package ui;

import game.AvailableActionsManager;
import game.Game;
import game.MoveHopliteAction;
import game.Player;
import game.Territory;

//import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MilitaryActionMoveHoplitesMakeMenu extends AbstractMenu {
	private Game game;
	//private List<String> availableValuesForRequest;
	private Territory originPosition;
	private Territory destinationPosition;
	private Integer unitToMoveCount;
	
	public MilitaryActionMoveHoplitesMakeMenu(Map<String, String> gameTexts, List<IMenu> menuList, Game game, Territory originPosition, Territory destinationPosition, Integer unitToMoveCount) {
		super(gameTexts, menuList);
		if (game == null) throw new IllegalArgumentException("'game' cannot be null");
		this.game = game;
		this.originPosition = originPosition;
		this.destinationPosition = destinationPosition;
		this.unitToMoveCount = unitToMoveCount;
		//availableValuesForRequest = new ArrayList<String>();
	}

	public Game getGame(){
		return game;
	}
	
	public void setGame(Game game){
		this.game = game;
	}
	
	public void execute() {
		Map<String, String> texts = getGameTexts();
		Player currentPlayer = game.getWhoHasTheTurn();

		if(AvailableActionsManager.checkMoveHopliteAction(game, currentPlayer, game.getRound(), originPosition, destinationPosition, unitToMoveCount)) {
			new MoveHopliteAction(currentPlayer, game.getRound(), originPosition, destinationPosition, unitToMoveCount, (unitToMoveCount > 1));
		}
		else {
			System.out.println(texts.get("gameMilitaryActionMoveHoplitesMakeMenu_error"));
		}
	}

	/*private List<String> getAvailableValuesForRequest() {
		return availableValuesForRequest;
	}*/

	public String getHeaderMessage() {
		return getGameTexts().get("gameMilitaryActionMoveHoplitesUnitCountMenu_headerMessage");
	}

	public IMenu getNextMenu() {
		// Volvemos al menu de juego:
		return getMenuList().get(0);
	}
}
