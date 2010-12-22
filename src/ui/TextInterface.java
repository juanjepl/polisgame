package ui;

import java.util.Map;
import utils.PolReader;

/**
 * This class implements a user interface
 * using text console
 */
public class TextInterface implements ITextInterface{

	private IMenu focusedMenu;
	private Map<String,String> gameTexts;
	
	public TextInterface(){
		PolReader gameTextsFileReader = new PolReader();
		gameTexts = gameTextsFileReader.readGameTexts();
		
		//TODO IMenu mainMenu = new MainMenu(//TODO parameters);
		//TODO showMenu;
	}

	public void showMenuContents(){
		//TODO
	}
	
	/**
	 * Getters and Setters for this class
	 */
	
	public Map<String,String> getGameTexts(){
		return gameTexts;
	}
	
	public IMenu getMenu(){
		return focusedMenu;
	}
	
	public void setMenu(IMenu nextMenu){
		if(nextMenu == null){
			throw new IllegalArgumentException("Invalid parameter for setMenu(), cannot be null");
		}
		focusedMenu = nextMenu;
		showMenuContents();
	}
}