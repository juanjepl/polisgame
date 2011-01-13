package ui;

import game.AvailableActionsManager;
import game.Game;
import game.Polis;
import game.Proxenus;
import game.Unit;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PoliticActionMoveProxenusMenu extends AbstractMenu {

	private List<String> availableValuesForRequest;
	
	public PoliticActionMoveProxenusMenu(Map<String, String> gameTexts, List<IMenu> menuList, Game game) {
		super(gameTexts, menuList);
		this.setGame(game);
		if (game == null) throw new IllegalArgumentException("'game' cannot be null");
		availableValuesForRequest = new ArrayList<String>();
		// TODO
	}
	
	public void execute() {
		if(getMenuOptionsList().isEmpty())
		{
			List<String> optionList = getMenuOptionsList();
			Map<String, String> texts = getGameTexts();
			
			Polis proxenusLocation = null;
			for(Polis po: getGame().getGamePolis().values()){
				for(Unit u: po.getUnits()){
					if(u instanceof Proxenus && u.getOwner().equals(getGame().getWhoHasTheTurn())){
						proxenusLocation = po;
					}
				}
			}

			// Opt 0 (Exit):
			optionList.add(getGameTexts().get("back"));
			availableValuesForRequest.add("0");
			
			Integer index = 1;
			
			for(Polis destiny : getGame().getGamePolis().values()){ 
				System.out.println(destiny.getName());
				if(AvailableActionsManager.checkMoveProxenusAction(getGame(), getGame().getWhoHasTheTurn(),proxenusLocation,destiny)){
					optionList.add(destiny.getName());
					availableValuesForRequest.add(index.toString());
					index++;
				}else {
					optionList.add(destiny.getName() + texts.get("notAvailable"));
				}
			}
		}
		
		setPlayerChoice(requestPlayerChoice(getAvailableValuesForRequest()));
		// TODO
	}

	public String getHeaderMessage() {
		return getGameTexts().get("gamePoliticActionMoveProxenusMenu_headerMessage");
	}

	public IMenu getNextMenu() {
		IMenu next = null;
		
		switch (getPlayerChoice()) {
		case 0:
			// Exit:
			next = getMenuList().get((getMenuList().size()-1) - 1); // Last element
			break;
		}
		
		return next;
	}
	
	public List<String> getAvailableValuesForRequest(){
		return availableValuesForRequest;
	}
}