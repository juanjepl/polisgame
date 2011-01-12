package ui;

import game.Player;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

import cfg.GameConfigurations;

public class GameMainMenuOptions extends AbstractMenu {

	private Player actual;
	private Player sparta;
	private Player athens;
	private Player oponent;
	
	public GameMainMenuOptions(Map<String, String> gameTexts, List<IMenu> menuList, Player actual, Player sparta, Player athens){
		super(gameTexts,menuList);
		String renamePlayer = getGameTexts().get("gameMainMenuOptions_renamePlayer");
		String back = getGameTexts().get("back");
		
		getMenuOptionsList().add(back);
		getMenuOptionsList().add(renamePlayer);
		
		this.actual = actual;
		this.sparta = sparta;
		this.athens = athens;
		
		if(actual.equals(sparta))
		{
			this.oponent = athens;
		}else{
			this.oponent = sparta;
		}

	}

	public Player getActual()
	{
		return actual;
	}
	
	public Player getSparta()
	{
		return sparta;
	}
	
	public Player getAthens()
	{
		return athens;
	}
	
	public Player getOponent()
	{
		return oponent;
	}
	
	public String getHeaderMessage(){
		return getGameTexts().get("gameMainMenuOptions_headerMessage");
	}

	public void execute() {
		showMenuContents();
		setPlayerChoice(requestPlayerChoice());
		
	}

	public IMenu getNextMenu() {
		IMenu nextMenu = null;
		if(getPlayerChoice().equals(0))
		{
			nextMenu = getMenuList().get(getMenuList().size() - 1);
			
		}else if(getPlayerChoice().equals(1))
		{
			requestPlayerName();
			nextMenu = getMenuList().get(getMenuList().size() - 1);
		}
		
		return nextMenu;
	}
	
	public void requestPlayerName(){
		System.out.println(" ");
		System.out.println(getGameTexts().get("gameMainMenuOptions_chooseNick"));
		String playerName = null;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // request player's name
		try {
	
			playerName = br.readLine();
			while(playerName.equals(getOponent().getName()))
			{
				playerName = br.readLine();
			}
			
		} catch (Exception e) {	
			//TODO
		}
		
		if(getActual().equals(getSparta()))
		{
			GameConfigurations.setSpartaPlayerName(playerName);
		}else
		{
			GameConfigurations.setAthensPlayerName(playerName);	
		}
	}
}
