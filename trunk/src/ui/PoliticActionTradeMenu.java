package ui;

import game.AvailableActionsManager;
import game.Game;
import game.Market;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PoliticActionTradeMenu extends AbstractMenu {
	
	private List<String> availableValuesForRequest;
	
	public PoliticActionTradeMenu(Map<String, String> gameTexts, List<IMenu> menuList, Game game) {
		super(gameTexts, menuList);
		this.setGame(game);
		if (game == null) throw new IllegalArgumentException("'game' cannot be null");
		
		availableValuesForRequest = new ArrayList<String>();

	}

	public void execute() {
		
		if(getMenuOptionsList().isEmpty())
		{
			List<String> optionList = getMenuOptionsList();
			
			// Opt 0 (Exit):
			optionList.add(getGameTexts().get("back"));
			availableValuesForRequest.add("0");
			
			Integer index = 1;
			
			for(Market mar : getGame().getGameMarkets().values()){
				if(AvailableActionsManager.checkTradeAction(getGame(),getGame().getWhoHasTheTurn(),mar)){
					optionList.add(mar.getName());
					availableValuesForRequest.add(index.toString());
					index++;
				}
			}
		}
		
		showMenuContents();
		setPlayerChoice(requestPlayerChoice(getAvailableValuesForRequest()));
		// TODO
	}

	public String getHeaderMessage() {
		return getGameTexts().get("politicActionTradeMenu_headerMessage");
	}

	public IMenu getNextMenu() {
		IMenu next = null;
		
		switch (getPlayerChoice()) {
		case 0:
			// Exit:
			next = getMenuList().get((getMenuList().size()-1) - 1); // Last element
			break;
		default:
			
			Market market = getGame().getGameMarkets().get(getMenuList().get(getPlayerChoice()));
			next = new PoliticActionTradeChooseResourcesMenu(getGameTexts(), getMenuList(), getGame(), market);
			break;
		}
		return next;
	}
	
	public List<String> getAvailableValuesForRequest(){
		return availableValuesForRequest;
	}
}
