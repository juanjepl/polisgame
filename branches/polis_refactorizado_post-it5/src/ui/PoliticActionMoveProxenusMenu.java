package ui;

import game.Game;
import java.util.List;
import java.util.Map;

public class PoliticActionMoveProxenusMenu extends AbstractMenu {
	private Game game;
	
	public PoliticActionMoveProxenusMenu(Map<String, String> gameTexts, List<IMenu> menuList, Game game) {
		super(gameTexts, menuList);
		if (game == null) throw new IllegalArgumentException("'game' cannot be null");
		this.game = game;
		// TODO
	}

	public void execute() {
		setPlayerChoice(requestPlayerChoice());
		// TODO
	}

	public String getHeaderMessage() {
		return getGameTexts().get("gamePoliticActionMoveProxenusMenu_headerMessage");
	}

	public IMenu getNextMenu() {
		IMenu next = null;
		Integer choice = getPlayerChoice();
		
		// TODO
		
		return next;
	}
}