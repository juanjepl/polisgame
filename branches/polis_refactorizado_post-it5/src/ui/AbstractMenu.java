package ui;

import java.util.List;
import java.util.Map;

public abstract class AbstractMenu implements IMenu {
	public AbstractMenu(Map<String, String> gameTexts) {
	}
	
	public abstract String getHeaderMessage();
	
	public abstract List<String> getMenuOptionList();
	
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
