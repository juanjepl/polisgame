package ui;

import game.AvailableActionsManager;
import game.Game;
import game.Market;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TradeChooseResourcesMenu extends AbstractMenu{
	
	private Market market;
	private List<String> availableValuesForRequest;
	
	public TradeChooseResourcesMenu(Map<String, String> gameTexts, List<IMenu> menuList,Game game, Market market)
	{
		super(gameTexts, menuList);
		this.setGame(game);
	if (game == null) throw new IllegalArgumentException("'game' cannot be null");
		
		availableValuesForRequest = new ArrayList<String>();

	}

	public Market getMarket()
	{
		return market;
	}
	
	public void execute() {
		
		if(getMenuOptionsList().isEmpty())
		{
			List<String> optionList = getMenuOptionsList();
			
			// Opt 0 (Exit):
			optionList.add(getGameTexts().get("back"));
			availableValuesForRequest.add("0");
			
			Integer index = 1;
			
			for(String resource1: getMarket().getResources().keySet())
			{
				for(String resource2: getMarket().getResources().get(resource1).keySet())
				{
					
					optionList.add(resource2);
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
		return getGameTexts().get("gamePoliticActionTradeMenu_headerMessage");
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
			String resource2 = getMenuOptionsList().get(getPlayerChoice());
			next = new TradeChooseResourceNeededMenu(getGameTexts(), getMenuList(), getGame(), market, resource2);
			break;
		}
		return next;
	}
	
	public List<String> getAvailableValuesForRequest(){
		return availableValuesForRequest;
	}
}
