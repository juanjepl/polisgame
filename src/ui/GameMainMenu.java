package ui;

import game.AvailableActionsManager;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cfg.GameConfigurations;

public class GameMainMenu extends AbstractMenu{

	public GameMainMenu(Map<String, String> gameTexts, List<IMenu> menuList) {
		super(gameTexts, menuList);
	
		
	}

	public String getHeaderMessage() {
		return getGameTexts().get("gameMainMenu_headerMessage");
	}
	
	public void execute() {
		
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
	
}
