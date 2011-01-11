package ui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.List;
import java.util.LinkedList;

import cfg.GameConfigurations;
import utils.PolReader;
import game.Player;
import game.Round;
import game.Game;
import game.Turn;

/**
 * This class implements a user interface
 * using text console
 */
public class TextInterface{
	private IMenu focusedMenu;
	private List<IMenu> menuList;
	private Map<String,String> gameTexts;
	private Map<String,Boolean> checkActionsMap;
	
	public TextInterface(){
		PolReader gameTextsFileReader = new PolReader();
		gameTexts = gameTextsFileReader.readGameTexts();
		menuList = new LinkedList<IMenu>();
		
		focusedMenu = new MainMenu(getGameTexts(),getMenuList());
		menuList.add(focusedMenu); // First in the list
		
		//TODO
	}

	public void showChangeOfRound(Round theNewRound){
		if(theNewRound == null){
			throw new IllegalArgumentException("Invalid parameter for showChangeOfRound, cannot be null");
		}
		System.out.println(" "); // White line
		System.out.println(getGameTexts().get("TextInterface_newRoundMessage")+" "+getGameTexts().get("round")+" "+theNewRound.getRoundName());
	}
	
	public void showRTAPMessage(Player player, Turn turn){
		if(player == null || turn == null){
			throw new IllegalArgumentException("Invalid paramater(s) for showRTAPMessage(), cannot be null");
		}
		
		String numberAction = "";
		
		if(turn.getSecondAction() == null){
			numberAction = getGameTexts().get("firstAction");
		}else{
			numberAction = getGameTexts().get("secondAction");
		}
		
		System.out.println(" "); // White line
		System.out.println(getGameTexts().get("player")+": "+player.getName()+"   "+getGameTexts().get("turn")+": "+Turn.getTurnCount().toString()+"   "+getGameTexts().get("action")+": "+numberAction);
	}
	
	public void showCurrentStateOfTheGame(Game theGame){
		if(theGame == null){
			throw new IllegalArgumentException("Invalid parameter for showCurrentStateOfTheGame(), cannot be null");
		}
		
		//TODO
		//TODO
	}
	
	/**
	 * Getters and Setters for this class
	 */
	
	public Map<String,String> getGameTexts(){
		return gameTexts;
	}
	
	public Map<String,Boolean> getCheckActionsMap(){
		return checkActionsMap;
	}
	
	public List<IMenu> getMenuList(){
		return menuList;
	}
	
	public IMenu getMenu(){
		return focusedMenu;
	}
	
	public void setMenu(){
		
		focusedMenu = focusedMenu.getNextMenu();
		
		if(focusedMenu.getAutoExecutable()){
			
			focusedMenu.execute();
			setMenu();
	
		}else{
			// Do nothing
		}
		
		Integer limit = menuList.indexOf(focusedMenu) + 1; //limit + 1 index = size index
		while(menuList.size() > limit){
			menuList.remove((getMenuList().size()) - 1);
		}
		
		if(!menuList.contains(focusedMenu))
		{
			menuList.add(focusedMenu);
		}


	}
	public void showNewRound(Round round)
	{
		System.out.println(" ");
		System.out.println(getGameTexts().get("newRound")  + ": " + round.getRoundName());
	}
	
	public void showFirstActionMessage(){
		System.out.println(" ");
		System.out.println("--- "+getGameTexts().get("firstAction") + " " + getGameTexts().get("action")+" ---");
	}

}