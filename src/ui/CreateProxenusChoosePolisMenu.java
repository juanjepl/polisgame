package ui;

import game.AvailableActionsManager;
import game.CreateProxenusAction;
import game.Game;
import game.Polis;
import game.CreatorAction;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CreateProxenusChoosePolisMenu extends AbstractMenu {

	List<Polis> availablePolis;

	public CreateProxenusChoosePolisMenu(Map<String, String> gameTexts, List<IMenu> menuList, Game game) {
		super(gameTexts, menuList);
		setGame(game);
		availablePolis = new ArrayList<Polis>();
	}

	public void execute() {
		// clear options for possible back re-execute
		getMenuOptionsList().clear();
		
		// back option ("0" option)
		String back = getGameTexts().get("back");
		getMenuOptionsList().add(back);
		
		// polis creation available list ("1" to "n" option(s))	
		for(Polis po : getGame().getWhoHasTheTurn().getPlayerPolis()){
			if(AvailableActionsManager.checkCreateProxenusAction(getGame().getWhoHasTheTurn(), po)){
				availablePolis.add(po);
				getMenuOptionsList().add(po.getName());
			}
		}
		showMenuContents();
		setPlayerChoice(requestPlayerChoice());
		
		//Do the action
		
		CreatorAction cA;
		
		if(getPlayerChoice() != 0){
			
			cA = new CreateProxenusAction(getGame().getWhoHasTheTurn(),getAvailablePolis().get(getPlayerChoice() - 1));
			getGame().getRound().getCurrentTurn().addGameAction(cA);
			
			// Player notification
			System.out.println(" ");
			System.out.println(getGameTexts().get("createProxenusChoosePolisMenu_actionDoneMessage" + getAvailablePolis().get(getPlayerChoice() - 1)));
			
		}else{
			// Do nothing, option "0" is for back
		}
	}

	public String getHeaderMessage() {
		return getGameTexts().get("createProxenusChoosePolisMenu_headerMessage");
	}

	public IMenu getNextMenu() {
		IMenu next = null;
		Integer choice = getPlayerChoice();
		
		if(choice.equals(0)){
			next = getMenuList().get((getMenuList().size()-1) - 1);
		}else{
			for(IMenu iteratedMenu : getMenuList()){
				if(iteratedMenu instanceof GameMainMenu){
					next = iteratedMenu;
					next.setAutoExecutable(false);
				}
			}
		}
		return next;
	}
	
	public List<Polis> getAvailablePolis(){
		return availablePolis;
	}
}