package ui;

import java.util.List;
import java.util.Map;

public class MainMenu implements IMenu{

	private String headerMessage;
	private List<String> optionsToBeChosen;
	private Integer playerChoice;
	
	public MainMenu(Map<String,String> gameTexts){
		headerMessage = gameTexts.get("MainMenu_headerMessage");
		
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