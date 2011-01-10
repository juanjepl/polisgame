package ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class AbstractMenu implements IMenu {
	private Map<String, String> gameTexts;
	private List<String> menuOptionsList;
	private Integer playerChoice;
	private List<IMenu> menuList;
	
	public AbstractMenu(Map<String, String> gameTexts,List<IMenu> menuList) {
		if (gameTexts == null || menuList == null){
			throw new IllegalArgumentException("Invalid parameter for AbstractMenu constructor, cannot be null");
		}
		this.menuList = menuList;
		this.gameTexts = gameTexts;
		this.menuOptionsList = new ArrayList<String>();
	}
	
	public Map<String, String> getGameTexts() {
		return gameTexts;
	}
	
	public abstract String getHeaderMessage();
	
	public List<String> getMenuOptionsList() {
		return menuOptionsList;
	}
	
	public Integer getPlayerChoice() {
		return playerChoice;
	}
	
	public List<IMenu> getMenuList(){
		return menuList;
	}
	
	public void setPlayerChoice(Integer choice) {
		playerChoice = choice;
	}
	
	public abstract void execute();

	public Integer requestPlayerChoice() {
		//TODO
		return null;
	}
	
	public abstract IMenu getNextMenu();
	
	public void convertChoose(Integer choose) {
		//TODO
	}
}
