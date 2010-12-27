package ui;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class MainMenu implements IMenu{

	private String headerMessage;
	private List<String> optionsToBeChosen;
	private Integer playerChoice;
	
	public MainMenu(Map<String,String> gameTexts){
		headerMessage = gameTexts.get("mainMenu_headerMessage");
		playerChoice = null;
		optionsToBeChosen = new ArrayList<String>();
		//TODO
	}
	
	/**
	 * Getter methods for this class
	 */
	
	public String getHeaderMessage(){
		return headerMessage;
	}
	
	public List<String> getOptionsToBeChosen(){
		return optionsToBeChosen;
	}
	
	public Integer getPlayerChoice(){
		return playerChoice;
	}
}