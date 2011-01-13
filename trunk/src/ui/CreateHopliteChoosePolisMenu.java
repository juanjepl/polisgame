package ui;

import game.AvailableActionsManager;
import game.Game;
import game.Polis;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CreateHopliteChoosePolisMenu extends AbstractMenu {

	List<Polis> availablePolis;
	
	public CreateHopliteChoosePolisMenu(Map<String, String> gameTexts, List<IMenu> menuList, Game game) {
		super(gameTexts, menuList);
		this.setGame(game);
		availablePolis = new ArrayList<Polis>();
	}

	public void execute(){
		
		// back option ("0" option)
		String back = getGameTexts().get("back");
		getMenuOptionsList().add(back);
		
		// polis creation available list ("1" to "n" option(s))	
		for(Polis po : getGame().getWhoHasTheTurn().getPlayerPolis()){
			if(AvailableActionsManager.checkCreateHopliteAction(getGame().getWhoHasTheTurn(), po, getGame().getRound())){
				availablePolis.add(po);
				getMenuOptionsList().add(po.getName());
			}
		}
		showMenuContents();
		setPlayerChoice(requestPlayerChoice());
	}

	public String getHeaderMessage() {
		return getGameTexts().get("gameCreationActionCreateHoplitesMenu_headerMessage");
	}

	public IMenu getNextMenu() {
		IMenu next = null;
		Integer choice = getPlayerChoice();
		
		if(choice.equals(0)){
			next = getMenuList().get((getMenuList().size()-1) - 1);
		}else{
			next = new CreateHopliteChooseResourceToPayMenu(getGameTexts(),getMenuList(),getGame(),getAvailablePolis().get(getPlayerChoice() - 1)); // -1 because 0 option is "back" 1 option is element 0 from polis list
		}
		return next;
	}
	public List<Polis> getAvailablePolis(){
		return availablePolis;
	}
}