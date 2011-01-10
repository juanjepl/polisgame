package ui;

import java.util.List;
import java.util.Map;

public abstract class AbstractMenu implements IMenu {
	private Map<String, String> gameTexts;
	
	public AbstractMenu(Map<String, String> gameTexts) {
		if (gameTexts == null) throw new NullPointerException("gameText cannot be null");
		this.gameTexts = gameTexts;
	}
	
	public Map<String, String> getGameTexts() {
		return gameTexts;
	}
	
	public abstract String getHeaderMessage();
	
	public abstract List<String> getMenuOptionsList();
	
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
