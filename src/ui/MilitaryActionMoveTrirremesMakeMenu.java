package ui;

import game.AvailableActionsManager;
import game.Game;
import game.MoveTrirremeAction;
import game.Player;
import game.Sea;

//import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MilitaryActionMoveTrirremesMakeMenu extends AbstractMenu {
	private Game game;
	private Sea originPosition;
	private Sea destinationPosition;
	private Integer unitToMoveCount;
	
	public MilitaryActionMoveTrirremesMakeMenu(Map<String, String> gameTexts, List<IMenu> menuList, Game game, Sea originPosition, Sea destinationPosition, Integer unitToMoveCount) {
		super(gameTexts, menuList);
		if (game == null) throw new IllegalArgumentException("'game' cannot be null");
		this.game = game;
		this.originPosition = originPosition;
		this.destinationPosition = destinationPosition;
		this.unitToMoveCount = unitToMoveCount;
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

		if(AvailableActionsManager.checkMoveTrirremeAction(game, currentPlayer, game.getRound(), originPosition, destinationPosition, unitToMoveCount)) {
			MoveTrirremeAction action = new MoveTrirremeAction(currentPlayer, originPosition, destinationPosition, unitToMoveCount, (unitToMoveCount > 1));
			System.out.println(texts.get("gameMilitaryActionMoveHoplitesMakeMenu_success"));
			game.getRound().getCurrentTurn().addGameAction(action);
		}
		else {
			System.out.println(texts.get("gameMilitaryActionMoveTrirremesMakeMenu_error"));
		}
	}

	public String getHeaderMessage() {
		return getGameTexts().get("gameMilitaryActionMoveTrirremesUnitCountMenu_headerMessage");
	}

	public IMenu getNextMenu() {
		IMenu next = null;
		
		// Volvemos al menu de juego:
		for(IMenu iteratedMenu : getMenuList()){
			if(iteratedMenu instanceof GameMainMenu){
				next = iteratedMenu;
				next.setAutoExecutable(false);
			}
		}
		
		return next;
	}
}
