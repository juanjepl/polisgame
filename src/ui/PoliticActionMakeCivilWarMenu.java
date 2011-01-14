package ui;

import game.CivilWarAction;
import game.Game;

import java.util.List;
import java.util.Map;

public class PoliticActionMakeCivilWarMenu extends AbstractMenu {
	
	public PoliticActionMakeCivilWarMenu(Map<String, String> gameTexts, List<IMenu> menuList, Game game) {
		super(gameTexts, menuList);
		this.setGame(game);
		if (game == null) throw new IllegalArgumentException("'game' cannot be null");
		// TODO
	}

	public void execute() {
		
		getMenuOptionsList().add(getGameTexts().get("back"));
		getMenuOptionsList().add(getGameTexts().get("politicActionMakeCivilWarMenu_doCivilWar"));
		showMenuContents();
		setPlayerChoice(requestPlayerChoice());
		
		if(getPlayerChoice().equals("1"))
		{
			// Do action
			CivilWarAction civilWarAction = new CivilWarAction(getGame().getWhoHasTheTurn());
		
			// Introduces Action in the actual turn
			getGame().getRound().getCurrentTurn().addGameAction(civilWarAction);
		
			// Finally a notification for the player
			showActionDoneMessage(getGame().getWhoHasTheTurn().getPlayerProxenus().getPosition().getName());
		}
	}

	public String getHeaderMessage() {
		return getGameTexts().get("politicActionMakeCivilWarMenu_headerMessage");
	}

	public IMenu getNextMenu() {
		IMenu next = null;
		switch (getPlayerChoice()) {
		case 0:
		// Exit:
		next = getMenuList().get((getMenuList().size()-1) - 1); // Last element
		break;
	
		default:
		next = new GameMainMenu(getGameTexts(),getMenuList(), getGame()); //go back to this menu
		next.setAutoExecutable(false); //FIXME provisional. //action completed
		break;
	}
		
		return next;
	}
	
	public void showActionDoneMessage(String polisName){
		System.out.println(" "); // White space
		System.out.println(getGameTexts().get("politicActionCivilWarMenu_civilWarDone")+ " " + polisName);//FIXME
	}
	

}
