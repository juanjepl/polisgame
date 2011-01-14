package ui;

import game.AvailableActionsManager;
import game.Game;
import game.MoveProxenusAction;
import game.Polis;
import game.Proxenus;
import game.Unit;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import navigation.ProxenusGraphNavigator;

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
		
		List<Polis> polisList = new ArrayList<Polis>(); 
		
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
			polisList.add(null);
			availableValuesForRequest.add("0");
			
			Integer index = 1;
			
			for(Polis destiny : getGame().getGamePolis().values()){ 
				System.out.println(proxenusLocation.getName() + " a " + destiny.getName());
				if(!destiny.getSysName().equals("samos") && !destiny.getSysName().equals("chios"))
				{
				if(AvailableActionsManager.checkMoveProxenusAction(getGame(), getGame().getWhoHasTheTurn(),proxenusLocation,destiny)){
					optionList.add(destiny.getName());
					polisList.add(destiny);
					availableValuesForRequest.add(index.toString());
					index++;
				}else {
					optionList.add(destiny.getName() + texts.get("notAvailable"));
				}
				}
			}
		}
		
		setPlayerChoice(requestPlayerChoice(getAvailableValuesForRequest()));
		
		//obtain destiny polis
		
		Polis destiny = polisList.get(getPlayerChoice());
		
		ProxenusGraphNavigator proxenusGraphNavigator = new ProxenusGraphNavigator(getGame().getWhoHasTheTurn(), (Polis) getGame().getWhoHasTheTurn().getPlayerProxenus().getPosition(), destiny, getGame().getProxenusGraph());
		Integer amountToPay = proxenusGraphNavigator.getAmountToPayForWay();
		//execute moveProxenusAction
		MoveProxenusAction moveProxenusAction = new MoveProxenusAction(getGame().getWhoHasTheTurn(), destiny, amountToPay);
		
		// Introduces Action in the actual turn
		getGame().getRound().getCurrentTurn().addGameAction(moveProxenusAction);
		
		// Finally a notification for the player
		showActionDoneMessage(destiny.getName());
	}

	public String getHeaderMessage() {
		return getGameTexts().get("politicActionMoveProxenusMenu_headerMessage");
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
			next.setAutoExecutable(false); //FIXME provisional. //action completed
				
		}
		
		return next;
	}
	
	public void showActionDoneMessage(String destinyName){
		System.out.println(" "); // White space
		System.out.println(getGameTexts().get("politicActionMoveProxenusMenu_proxenusMovedTo")+ " " + destinyName);//FIXME
	}
	
	public List<String> getAvailableValuesForRequest(){
		return availableValuesForRequest;
	}
}