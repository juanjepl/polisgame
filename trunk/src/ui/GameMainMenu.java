package ui;

import game.AvailableActionsManager;
import game.Game;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cfg.GameConfigurations;

public class GameMainMenu extends AbstractMenu{

	private Game game;
	public GameMainMenu(Map<String, String> gameTexts, List<IMenu> menuList, Game game) {
		super(gameTexts, menuList);
		this.game = game;
		
	}

	public Game getGame()
	{
		return game;
	}
	
	public String getHeaderMessage() {
		return getGameTexts().get("gameMainMenu_headerMessage");
	}
	
	public void execute() {
		
		setAutoExecutable(true);
		
		if(GameConfigurations.getAthensPlayerName().isEmpty() && GameConfigurations.getSpartaPlayerName().isEmpty())
		{
			requestPlayerNames();
		}
		
		showMenuContents();
		String options = getGameTexts().get("gameMainMenu_options");
		String creatorAction = getGameTexts().get("gameMainMenu_creatorAction");
		String militaryAction = getGameTexts().get("gameMainMenu_militaryAction");
		String politicAction = getGameTexts().get("gameMainMenu_politicAction");
		String passTurn = getGameTexts().get("gameMainMenu_passTurn");
		String notAvailable = getGameTexts().get("notAvailable");
		
		if(AvailableActionsManager.checkCreatorAction(game,p)){
            creatorAction = creatorAction + notAvailable;
		}
		
		
		
	}

	public IMenu getNextMenu() {
		return null;
	}
	
	public void requestPlayerNames()
	{

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
			
			if(!firstTime)
			{
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
	
}
