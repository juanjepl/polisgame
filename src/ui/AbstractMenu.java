package ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class AbstractMenu implements IMenu {
	private Map<String, String> gameTexts;
	private List<String> menuOptionsList;
	
	public AbstractMenu(Map<String, String> gameTexts) {
		if (gameTexts == null) throw new NullPointerException("'gameTexts' cannot be null");
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
