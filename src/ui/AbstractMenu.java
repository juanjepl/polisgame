package ui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
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

	public Integer requestPlayerChoice(){
		String choose = "WrongValue"; // "Random" value for entering to next while
		
		// Granted values for player choose
		List<String> grantedOptions = new ArrayList<String>();
		for(int i=0 ; i<=getMenuOptionsList().size() ; i++){
			grantedOptions.add(new Integer(i).toString());
		}
		
		// request player's choose
		
		Boolean showBadInputMessage = false;
		while(!(grantedOptions.contains(choose))){
			
			if(showBadInputMessage){
				System.out.println(" ");
				System.out.println(getGameTexts().get("abstractMenu_BadInputMessage"));
			}
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // request athens's player's name
			try {
				choose = br.readLine();
			} catch (Exception e) {	
				//TODO
			}
			
			showBadInputMessage = true; // if fails input, next iteration shows the error message
		}
		
		return Integer.parseInt(choose);
	}
	
	public abstract IMenu getNextMenu();
	
	public void convertChoose(Integer choose) {
		//TODO
	}
}
