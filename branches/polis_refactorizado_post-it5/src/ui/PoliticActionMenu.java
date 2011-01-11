package ui;

import java.util.List;
import java.util.Map;
import exceptions.PolisGameRunningException;
import game.Game;

public class PoliticActionMenu extends AbstractMenu {
	private Game game;
	
	public PoliticActionMenu(Map<String, String> gameTexts, List<IMenu> menuList, Game game) {
		super(gameTexts, menuList);
		if (game == null) throw new IllegalArgumentException("'game' cannot be null");
		this.game = game;
		Map<String, String> texts = getGameTexts();
		List<String> optionList = getMenuOptionsList();
		
		// TODO Hay que ver cuales opciones de las siguientes estan disponibles:
		optionList.add(texts.get("gamePoliticActionMenu_startProjectOpt"));
		optionList.add(texts.get("gamePoliticActionMenu_tradeOpt"));
		optionList.add(texts.get("gamePoliticActionMenu_moveProxenusOpt"));
		optionList.add(texts.get("gamePoliticActionMenu_makeCivilWarOpt"));
		optionList.add(texts.get("gamePoliticActionMenu_cancel"));
	}

	public void execute() {
		setPlayerChoice(requestPlayerChoice());
	}

	public String getHeaderMessage() {
		return getGameTexts().get("gamePoliticActionMenu_headerMessage");
	}

	public IMenu getNextMenu() {
		IMenu next = null;
		
		switch (getPlayerChoice()) {
			case 0:
				next = new PoliticActionStartProjectMenu(getGameTexts(), getMenuList(), game);
				break;
			case 1:
				next = new PoliticActionTradeMenu(getGameTexts(), getMenuList(), game);
				break;
			case 2:
				next = new PoliticActionMoveProxenusMenu(getGameTexts(), getMenuList(), game);
				break;
			case 3:
				next = new PoliticActionMakeCivilWarMenu(getGameTexts(), getMenuList(), game);
				break;
			case 4:
				next = getMenuList().get((getMenuList().size()) - 1); // Last element
				break;
			default:
				throw new PolisGameRunningException("Invalid option choosen at PoliticActionMenu");
		}
		
		return next;
	}

}
