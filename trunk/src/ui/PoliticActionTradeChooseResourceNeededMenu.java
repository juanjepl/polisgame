package ui;

import game.Game;
import game.Market;
import game.TradeAction;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PoliticActionTradeChooseResourceNeededMenu extends AbstractMenu{

	private Market market;
	private String resource2;
	private List<String> availableValuesForRequest;
	
	public PoliticActionTradeChooseResourceNeededMenu(Map<String, String> gameTexts, List<IMenu> menuList,Game game, Market market, String resource2)
	{
		super(gameTexts, menuList);
		this.setGame(game);
	if (game == null) throw new IllegalArgumentException("'game' cannot be null");
		
		availableValuesForRequest = new ArrayList<String>();
		this.resource2 = resource2;

	}

	public String getResource2()
	{
		return resource2;
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
			
			for(String resource1: getMarket().getListOfAvailableResources(getResource2()))
			{
				
				if(getGame().getWhoHasTheTurn().getResource(resource1) >= getGame().getMarketChart().getPrice(getResource2()))
				{
					optionList.add(resource1);
					availableValuesForRequest.add(index.toString());
				}else
				{
					optionList.add(resource1 + getGameTexts().get("notAvailable"));
				}
				index++;
			}
		}
		
		showMenuContents();
		setPlayerChoice(requestPlayerChoice(getAvailableValuesForRequest()));
		
		Market market = getGame().getGameMarkets().get(getMenuList().get(getPlayerChoice()));
		String resource1 = getMenuOptionsList().get(getPlayerChoice());
		
		Integer dice = rollTheDice(2);
		// Do action
		TradeAction tradeAction = new TradeAction(getGame().getWhoHasTheTurn(),getGame().getRound(),getGame().getMarketChart(), market, resource1, getResource2(), dice);
		
		// Introduces Action in the actual turn
		getGame().getRound().getCurrentTurn().addGameAction(tradeAction);
		
		// Finally a notification for the player
		showActionDoneMessage(resource1);
	}

	public String getHeaderMessage() {
		return getGameTexts().get("politicActionTradeChooseResourceNeededMenu_headerMessage");
	}

	public IMenu getNextMenu() {
		IMenu next = null;
		
		switch (getPlayerChoice()) {
		case 0:
			// Exit:
			next = getMenuList().get((getMenuList().size()-1) - 1); // Last element
			break;
		default:
			next = new GameMainMenu(getGameTexts(),getMenuList(), getGame()); //go back to this menu with other player
			next.setAutoExecutable(false);
			break;
		}
		return next;
	}
	
	public void showActionDoneMessage(String resource1){
		System.out.println(" "); // White space
		System.out.println(getGameTexts().get(resource1)+ " " + getGameTexts().get("politicActionTradeChooseResourceNeededMenu_tradedBy") + " " + getResource2());
	}
	
	public List<String> getAvailableValuesForRequest(){
		return availableValuesForRequest;
	}
}
