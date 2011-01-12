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
	private Boolean autoExecutable;
	
	public AbstractMenu(Map<String, String> gameTexts,List<IMenu> menuList) {
		if (gameTexts == null || menuList == null){
			throw new IllegalArgumentException("Invalid parameter for AbstractMenu constructor, cannot be null");
		}
		this.menuList = menuList;
		this.gameTexts = gameTexts;
		this.menuOptionsList = new ArrayList<String>();
		this.autoExecutable = true;
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
	
	public Integer requestPlayerChoice(List<String> availableValues){
		String choose = "WrongValue"; // "Random" value for entering to next while
		
		// Granted values for player choose
		List<String> grantedOptions = new ArrayList<String>();
		for(int i=0 ; i<=getMenuOptionsList().size() ; i++){
			grantedOptions.add(new Integer(i).toString());
		}
		
		// request player's choose
		while(!(grantedOptions.contains(choose)) && !(availableValues.contains(choose))){
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // request athens's player's name
			try {
				choose = br.readLine();
			} catch (Exception e) {	
				//TODO
			}
			
			if(!(grantedOptions.contains(choose)) && !(availableValues.contains(choose))){
				System.out.println(" ");
				System.out.println(getGameTexts().get("abstractMenu_BadInputMessage"));
			}else if(grantedOptions.contains(choose) && !(availableValues.contains(choose))){
				System.out.println(" ");
				System.out.println(getGameTexts().get("abstractMenu_unAvailableMessage"));
			}
		}
		return Integer.parseInt(choose);
	}
	
	public abstract IMenu getNextMenu();
	
	public void convertChoose(Integer choose) {
		//TODO
	}
	
	public Boolean getAutoExecutable()
	{
		return autoExecutable;
	}
	
	public void setAutoExecutable(Boolean auto)
	{
		this.autoExecutable = auto;
	}
	

	public void showMenuContents(){
		System.out.println(" "); // White line
		System.out.println(getHeaderMessage()); // Prints message for the player
		System.out.println(" "); // White line
		
		// Shows the list of options to be chosen if exists
		if(!(getMenuOptionsList().isEmpty())){
			Integer counter = 0;
			for(String optionInMenu : getMenuOptionsList()){
				System.out.println(counter.toString() + " - "+ optionInMenu);
				counter += 1;
			}
		}
	}
	
}
