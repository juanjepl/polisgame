package ui;

import game.AvailableActionsManager;
import game.Game;
import game.MoveTrirremeAction;
import game.Player;
import game.Polis;
import game.SiegePolisAction;

//import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MilitaryActionBesiegePolisMakeMenu extends AbstractMenu {
	private Game game;
	//private List<String> availableValuesForRequest;
	private Polis polisToSiege;
	
	public MilitaryActionBesiegePolisMakeMenu(Map<String, String> gameTexts, List<IMenu> menuList, Game game, Polis polisToSiege) {
		super(gameTexts, menuList);
		if (game == null) throw new IllegalArgumentException("'game' cannot be null");
		this.game = game;
		this.polisToSiege = polisToSiege;
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

		if(AvailableActionsManager.checkSiegePolisAction(currentPlayer, polisToSiege)) {
			SiegePolisAction action = new SiegePolisAction(currentPlayer, polisToSiege);
			System.out.println(texts.get("gameMilitaryActionBesiegePolisMakeMenu_success"));
			game.getRound().getCurrentTurn().addGameAction(action);
		}
		else {
			System.out.println(texts.get("gameMilitaryActionBesiegePolisMakeMenu_error"));
		}
	}

	/*private List<String> getAvailableValuesForRequest() {
		return availableValuesForRequest;
	}*/

	public String getHeaderMessage() {
		return getGameTexts().get("gameMilitaryActionBesiegePolisMakeMenu_headerMessage");
	}

	public IMenu getNextMenu() {
		// Volvemos al menu de juego:
		return getMenuList().get(0);
	}
}
