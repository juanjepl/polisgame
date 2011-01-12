package ui;

import game.AvailableActionsManager;
import game.Game;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import cfg.GameConfigurations;

public class GameMainMenu extends AbstractMenu{
	
	private Game game;
	private List<String> availableValuesForRequest;
	
	public GameMainMenu(Map<String, String> gameTexts, List<IMenu> menuList, Game game) {
		super(gameTexts, menuList);
		this.game = game;
		availableValuesForRequest = new ArrayList<String>();
		
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
		if(AvailableActionsManager.checkCreatorAction(game.getRound(),game.getWhoHasTheTurn())){
			getMenuOptionsList().add(creatorAction);
			getAvailableValuesForRequest().add("1");
		}else{
			getMenuOptionsList().add(creatorAction + notAvailable);
		}
		
		// Military Action
		if(AvailableActionsManager.checkMilitaryAction(game,game.getWhoHasTheTurn())){
			getMenuOptionsList().add(militaryAction);
			getAvailableValuesForRequest().add("2");
		}else{
			getMenuOptionsList().add(militaryAction + notAvailable);
		}
		
		// Politic Action
		if(AvailableActionsManager.checkPoliticAction(game,game.getWhoHasTheTurn())){
			getMenuOptionsList().add(politicAction);
			getAvailableValuesForRequest().add("3");
		}else{
			getMenuOptionsList().add(politicAction + notAvailable);
		}
		
		// Pass Turn
		getMenuOptionsList().add(passTurn);
		getAvailableValuesForRequest().add("4");
	}

	public Game getGame(){
		return game;
	}
	
	public String getHeaderMessage(){
		return getGameTexts().get("gameMainMenu_headerMessage");
	}
	
	public void execute() {
		
		setAutoExecutable(true); // Only in this Menu class
		
		if(GameConfigurations.getAthensPlayerName() == null && GameConfigurations.getSpartaPlayerName() == null){
			requestPlayerNames();
		}
		
		showMenuContents();
		requestPlayerChoice(getAvailableValuesForRequest());
		
		//TODO trabajando en ello...
		
	}

	public IMenu getNextMenu() {
		IMenu nextFocusedMenu = null;
		
		if(getPlayerChoice().equals(0)){
			//TODO
		}else if(getPlayerChoice().equals(1)){
			//TODO
		}else if(getPlayerChoice().equals(2)){
			//TODO
		}else if(getPlayerChoice().equals(3)){
			//TODO
		}else if(getPlayerChoice().equals(4)){
			//TODO
		}else{ //(getPlayerChoice().equals(5))
			//TODO
		}
		return nextFocusedMenu;
	}
	
	public void requestPlayerNames(){
		System.out.println(" ");
		System.out.println(getGameTexts().get("gameMainMenu_requestPlayerNames"));
		System.out.println(" ");
		System.out.println(getGameTexts().get("gameMainMenu_spartaPlayer") + " :");
		
		String spartaName = null;
		String athensName = null;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // request sparta player's name
		try {
			spartaName = br.readLine();
		} catch (Exception e) {	
			//TODO
		}
		
		System.out.println(" ");
		System.out.println(getGameTexts().get("gameMainMenu_athensPlayer") + " :");
		
		athensName = spartaName;
		Boolean firstTime = true;
		while(spartaName.equals(athensName)){
			
			if(!firstTime){
				System.out.println(" ");
				System.out.println(getGameTexts().get("gameMainMenu_errorSameNames") + " :");
			}
			
			BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in)); // request sparta player's name
			try {
				athensName = br2.readLine();
			} catch (Exception e) {	
				//TODO
			}
			
			firstTime = false;
		}
		GameConfigurations.setSpartaPlayerName(spartaName);
		GameConfigurations.setAthensPlayerName(athensName);	
	}
	
	public List<String> getAvailableValuesForRequest(){
		return availableValuesForRequest;
	}
	
}
