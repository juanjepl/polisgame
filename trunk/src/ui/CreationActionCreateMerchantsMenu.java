package ui;

import java.util.List;
import java.util.Map;
import exceptions.PolisGameRunningException;
import game.Game;

public class CreationActionCreateMerchantsMenu extends AbstractMenu {
	private Game game;

	public CreationActionCreateMerchantsMenu(Map<String, String> gameTexts, List<IMenu> menuList, Game game) {
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
		return getGameTexts().get("gameCreationActionCreateMerchantsMenu_headerMessage");
	}

	public IMenu getNextMenu() {
		IMenu next = null;
		Integer choice = getPlayerChoice();
		
		// TODO
		
		return next;
	}
}
