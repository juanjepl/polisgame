package ui;

import java.util.List;
import java.util.Map;

public class MainMenu extends AbstractMenu{
	
	public MainMenu(Map<String,String> gameTexts){
		super(gameTexts);
	}
	
	/**
	 * Getter methods for this class
	 */
	
	public String getHeaderMessage(){
		return getGameTexts().get("mainMenu_HeaderMessage");
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<String> getMenuOptionsList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IMenu getNextMenu() {
		// TODO Auto-generated method stub
		return null;
	}
}