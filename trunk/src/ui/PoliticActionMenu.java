package ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import exceptions.PolisGameRunningException;
import game.AvailableActionsManager;
import game.Game;
import game.Player;

public class PoliticActionMenu extends AbstractMenu {
	private Game game;
	private List<String> availableValuesForRequest;
	private Player currentPlayer;
	
	public PoliticActionMenu(Map<String, String> gameTexts, List<IMenu> menuList, Game game) {
		super(gameTexts, menuList);
		if (game == null) throw new IllegalArgumentException("'game' cannot be null");
		
		this.game = game;	
		availableValuesForRequest = new ArrayList<String>();
		currentPlayer = game.getWhoHasTheTurn();
	}

	public Game getGame(){
		return game;
	}
	
	public void setGame(Game game){
		this.game = game;
	}
	
	public void execute() {
		if(getMenuOptionsList().isEmpty())
		{
			List<String> optionList = getMenuOptionsList();
			Map<String, String> texts = getGameTexts();
				
			String startProjectText = texts.get("gamePoliticActionMenu_startProjectOpt");
			String tradeText = texts.get("gamePoliticActionMenu_tradeOpt");
			String moveProxenusText = texts.get("gamePoliticActionMenu_moveProxenusOpt");
			String makeCivilWarText = texts.get("gamePoliticActionMenu_makeCivilWarOpt");
			String back = texts.get("back");
			String notAvailableText = texts.get("notAvailable");
			
			// Opt 0 (Exit):
			optionList.add(back);
			availableValuesForRequest.add("0");
			
			// Opt 1 (Start Project):
			if (AvailableActionsManager.checkStartProjectAnyAction(game, currentPlayer)) {
				optionList.add(startProjectText);
				availableValuesForRequest.add("1");
			}
			else {
				optionList.add(startProjectText + notAvailableText);
			}
			
			// Opt 2 (Trade):
			if (AvailableActionsManager.checkTradeAnyAction(game, currentPlayer)) {
				optionList.add(tradeText);
				availableValuesForRequest.add("2");
			}
			else {
				optionList.add(tradeText + notAvailableText);
			}
			
			// Opt 3 (Move proxenus):
			if (AvailableActionsManager.checkMoveProxenusAnyAction(game, currentPlayer)) {
				optionList.add(moveProxenusText);
				availableValuesForRequest.add("3");
			}
			else {
				optionList.add(moveProxenusText + notAvailableText);
			}
			
			// Opt 4 (Make Civil War):
			if (AvailableActionsManager.checkCivilWarAnyAction(game, currentPlayer)) {
				optionList.add(makeCivilWarText);
				availableValuesForRequest.add("4");
			}
			else {
				optionList.add(makeCivilWarText + notAvailableText);
			}
		}
		showMenuContents();
		setPlayerChoice(requestPlayerChoice(getAvailableValuesForRequest()));
	}

	public String getHeaderMessage() {
		return getGameTexts().get("gamePoliticActionMenu_headerMessage");
	}

	public IMenu getNextMenu() {
		IMenu next = null;
		Integer choice = getPlayerChoice();
		if (!availableValuesForRequest.contains(String.valueOf(choice))) throw new PolisGameRunningException("Option not available choosen at PoliticActionMenu");
		
		switch (getPlayerChoice()) {
			case 0:
				// Exit:
				next = getMenuList().get((getMenuList().size()-1) - 1); // Last element
				break;
			case 1:
				next = new PoliticActionStartProjectMenu(getGameTexts(), getMenuList(), game);
				break;
			case 2:
				next = new PoliticActionTradeMenu(getGameTexts(), getMenuList(), game);
				break;
			case 3:
				next = new PoliticActionMoveProxenusMenu(getGameTexts(), getMenuList(), game);
				break;
			case 4:
				next = new PoliticActionMakeCivilWarMenu(getGameTexts(), getMenuList(), game);
				break;
			
		}
		
		return next;
	}
	
	public List<String> getAvailableValuesForRequest(){
		return availableValuesForRequest;
	}
}
