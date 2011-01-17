package ui;

import game.AvailableActionsManager;
import game.Game;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class GameMainMenu extends AbstractMenu{
	
	private Game game;
	private List<String> availableValuesForRequest;
	
	public GameMainMenu(Map<String, String> gameTexts, List<IMenu> menuList, Game game) {
		super(gameTexts, menuList);
		this.game = game;
		availableValuesForRequest = new ArrayList<String>();
	}

	public Game getGame(){
		return game;
	}
	
	public void setGame(Game game){
		this.game = game;
	}
	
	public String getHeaderMessage(){
		return getGameTexts().get("gameMainMenu_headerMessage");
	}
	
	public void execute() {
		
		setAutoExecutable(true); // Only in this Menu class
	
		if(getMenuOptionsList().isEmpty())
		{
			String notAvailable = getGameTexts().get("notAvailable");
			String options = getGameTexts().get("gameMainMenu_options");
			String creatorAction = getGameTexts().get("gameMainMenu_creatorAction");
			String militaryAction = getGameTexts().get("gameMainMenu_militaryAction");
			String politicAction = getGameTexts().get("gameMainMenu_politicAction");
			String passTurn = getGameTexts().get("gameMainMenu_passTurn");
			
			// Options		
			getMenuOptionsList().add(options);
			getAvailableValuesForRequest().add("0");
			
			// Creator Action
			if(AvailableActionsManager.checkCreatorAction(getGame().getRound(),getGame().getWhoHasTheTurn())){
				getMenuOptionsList().add(creatorAction);
				getAvailableValuesForRequest().add("1");
			}else{
				getMenuOptionsList().add(creatorAction + notAvailable);
			}
			
			// Military Action
			if(AvailableActionsManager.checkMilitaryAction(getGame(),getGame().getWhoHasTheTurn())){
				getMenuOptionsList().add(militaryAction);
				getAvailableValuesForRequest().add("2");
			}else{
				getMenuOptionsList().add(militaryAction + notAvailable);
			}
			
			// Politic Action
			if(AvailableActionsManager.checkPoliticAction(getGame(),getGame().getWhoHasTheTurn())){
				getMenuOptionsList().add(politicAction);
				getAvailableValuesForRequest().add("3");
			}else{
				getMenuOptionsList().add(politicAction + notAvailable);
			}
			
			// Pass Turn
			getMenuOptionsList().add(passTurn);
			getAvailableValuesForRequest().add("4");
			
		}
		
		showMenuContents();
		setPlayerChoice(requestPlayerChoice(getAvailableValuesForRequest()));
	}

	public IMenu getNextMenu() {
		IMenu nextFocusedMenu = null;
		
		if(getPlayerChoice().equals(0)){
			nextFocusedMenu = new GameMainMenuOptions(getGameTexts(),getMenuList(), getGame().getWhoHasTheTurn(), getGame().getSpartaPlayer(), getGame().getAthensPlayer());
		}else if(getPlayerChoice().equals(1)){
			nextFocusedMenu = new CreationActionMenu(getGameTexts(), getMenuList(), getGame());
		}else if(getPlayerChoice().equals(2)){
			nextFocusedMenu = new MilitaryActionMenu(getGameTexts(), getMenuList(), getGame());
		}else if(getPlayerChoice().equals(3)){
			nextFocusedMenu = new PoliticActionMenu(getGameTexts(), getMenuList(), getGame());
		}else if(getPlayerChoice().equals(4)){
			
			getGame().getWhoHasTheTurn().setHasPassedTurn(true);
			nextFocusedMenu = new GameMainMenu(getGameTexts(),getMenuList(), getGame()); //go back to this menu with other player
			nextFocusedMenu.setAutoExecutable(false);
		}else{
			// Nothing
		}
		return nextFocusedMenu;
	}

	public List<String> getAvailableValuesForRequest(){
		return availableValuesForRequest;
	}	
}