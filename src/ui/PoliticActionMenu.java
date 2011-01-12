package ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import exceptions.PolisGameRunningException;
import game.AvailableActionsManager;
import game.Game;
import game.Player;

public class PoliticActionMenu extends AbstractMenu {
	private Game game;
	private List<String> optionList;
	private List<String> availableValuesForRequest;
	Map<String, String> texts;
	
	public PoliticActionMenu(Map<String, String> gameTexts, List<IMenu> menuList, Game game) {
		super(gameTexts, menuList);
		if (game == null) throw new IllegalArgumentException("'game' cannot be null");
		
		this.game = game;	
		texts = getGameTexts();
		optionList = getMenuOptionsList();
		availableValuesForRequest = new ArrayList<String>();
		Player currentPlayer = game.getWhoHasTheTurn();
		
		// Opt 0 (Start Project):
		if (AvailableActionsManager.checkStartProjectAnyAction(game, currentPlayer))
		{
			
		}
		else
		{
			
		}
		
		optionsAvailable.put(0, opt0);
		if (opt0) optionList.add(texts.get("gamePoliticActionMenu_startProjectOpt"));
		else optionList.add(texts.get("gamePoliticActionMenu_startProjectOpt") + texts.get("notAvailable"));
		
		// Opt 1 (Trade):
		Boolean opt1 = AvailableActionsManager.checkTradeAnyAction(game, currentPlayer);
		optionsAvailable.put(1, opt1);
		if (opt1) optionList.add(texts.get("gamePoliticActionMenu_tradeOpt"));
		else optionList.add(texts.get("gamePoliticActionMenu_tradeOpt") + texts.get("notAvailable"));
		
		// Opt 2 (Move Proxenus):
		Boolean opt2 = AvailableActionsManager.checkMoveProxenusAnyAction(game, currentPlayer);
		optionsAvailable.put(2, opt2);
		if (opt2) optionList.add(texts.get("gamePoliticActionMenu_moveProxenusOpt"));
		else optionList.add(texts.get("gamePoliticActionMenu_moveProxenusOpt") + texts.get("notAvailable"));
		
		// Opt 3 (Make Civil War):
		Boolean opt3 = AvailableActionsManager.checkCivilWarAnyAction(game, currentPlayer);
		optionsAvailable.put(3, opt3);
		if (opt3) optionList.add(texts.get("gamePoliticActionMenu_makeCivilWarOpt"));
		else optionList.add(texts.get("gamePoliticActionMenu_makeCivilWarOpt") + texts.get("notAvailable"));
		
		// Opt 4:
		// Exit:
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
				if (!optionsAvailable.get(0)) throw new PolisGameRunningException("Option not available choosen at PoliticActionMenu");
				next = new PoliticActionStartProjectMenu(getGameTexts(), getMenuList(), game);
				break;
			case 1:
				if (!optionsAvailable.get(1)) throw new PolisGameRunningException("Option not available choosen at PoliticActionMenu");
				next = new PoliticActionTradeMenu(getGameTexts(), getMenuList(), game);
				break;
			case 2:
				if (!optionsAvailable.get(2)) throw new PolisGameRunningException("Option not available choosen at PoliticActionMenu");
				next = new PoliticActionMoveProxenusMenu(getGameTexts(), getMenuList(), game);
				break;
			case 3:
				if (!optionsAvailable.get(3)) throw new PolisGameRunningException("Option not available choosen at PoliticActionMenu");
				next = new PoliticActionMakeCivilWarMenu(getGameTexts(), getMenuList(), game);
				break;
			case 4:
				// Exit:
				next = getMenuList().get((getMenuList().size()) - 1); // Last element
				break;
			default:
				throw new PolisGameRunningException("Invalid option choosen at PoliticActionMenu");
		}
		
		return next;
	}

}
