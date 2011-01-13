package ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import exceptions.PolisGameRunningException;
import game.AvailableActionsManager;
import game.Game;
import game.Player;
import game.Round;

public class CreationActionMenu extends AbstractMenu {
	private Game game;
	private List<String> availableValuesForRequest;
	private Player currentPlayer;
	private Round currentRound;
	
	public CreationActionMenu(Map<String, String> gameTexts, List<IMenu> menuList, Game game) {
		super(gameTexts, menuList);
		if (game == null) throw new IllegalArgumentException("'game' cannot be null");
		
		this.game = game;	
		availableValuesForRequest = new ArrayList<String>();
		currentPlayer = game.getWhoHasTheTurn();
		currentRound = game.getRound();
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
			
			String createHoplitesText = texts.get("gameCreationAction_createHoplitesOpt");
			String createTrirremesText = texts.get("gameCreationAction_createTrirremesOpt");
			String createMerchantsText = texts.get("gameCreationAction_createMerchantsOpt");
			String createProxenusText = texts.get("gameCreationAction_createProxenus");
			String back = texts.get("back");
			String notAvailableText = texts.get("notAvailable");
			
			// Opt 0 (Exit):
			optionList.add(back);
			availableValuesForRequest.add("0");
			
			// Opt 1 (Create Hoplites):
			if (AvailableActionsManager.checkCreateHopliteAnyAction(currentRound, currentPlayer)) {
				optionList.add(createHoplitesText);
				availableValuesForRequest.add("1");
			}
			else {
				optionList.add(createHoplitesText + notAvailableText);
			}
			
			// Opt 2 (Create Trirremes):
			if (AvailableActionsManager.checkCreateTrirremeAnyAction(currentRound, currentPlayer)) {
				optionList.add(createTrirremesText);
				availableValuesForRequest.add("2");
			}
			else {
				optionList.add(createTrirremesText + notAvailableText);
			}
			
			// Opt 3 (Create Merchants/Trade Boats):
			if (AvailableActionsManager.checkCreateTradeBoatAnyAction(currentRound, currentPlayer)) {
				optionList.add(createMerchantsText);
				availableValuesForRequest.add("3");
			}
			else {
				optionList.add(createMerchantsText + notAvailableText);
			}
			
			// Opt 4 (Create Proxenus):
			if (AvailableActionsManager.checkCreateProxenusAnyAction(currentPlayer)) {
				optionList.add(createProxenusText);
				availableValuesForRequest.add("4");
			}
			else {
				optionList.add(createProxenusText + notAvailableText);
			}
		}
		showMenuContents();
		setPlayerChoice(requestPlayerChoice(getAvailableValuesForRequest()));
	}

	public String getHeaderMessage() {
		return getGameTexts().get("gameCreationAction_headerMessage");
	}

	public IMenu getNextMenu() {
		IMenu next = null;
		Integer choice = getPlayerChoice();
		if (!availableValuesForRequest.contains(String.valueOf(choice))) throw new PolisGameRunningException("Option not available choosen at CreationActionMenu");
		
		switch (getPlayerChoice()) {
			case 0:
				// Exit:
				next = getMenuList().get((getMenuList().size()-1) - 1); // Last element
				break;
			case 1:
				next = new CreateHopliteChoosePolisMenu(getGameTexts(), getMenuList(), game);
				break;
			case 2:
				next = new CreationActionCreateTrirremesMenu(getGameTexts(), getMenuList(), game);
				break;
			case 3:
				next = new CreationActionCreateMerchantsMenu(getGameTexts(), getMenuList(), game);
				break;
			case 4:
				next = new CreationActionCreateProxenusMenu(getGameTexts(), getMenuList(), game);
				break;
		}
		
		return next;
	}
	
	public List<String> getAvailableValuesForRequest() {
		return availableValuesForRequest;
	}
}
