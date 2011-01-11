package ui;

import java.util.List;
import java.util.Map;

public class MainMenu extends AbstractMenu{
	
	public MainMenu(Map<String,String> gameTexts, List<IMenu> menuList){
		super(gameTexts,menuList);
		String newGame = getGameTexts().get("mainMenu_newGame");
		String credits = getGameTexts().get("mainMenu_credits");
		String exit = getGameTexts().get("mainMenu_exit");
		getMenuOptionsList().add(newGame);
		getMenuOptionsList().add(credits);
		getMenuOptionsList().add(exit);
	}
	
	/**
	 * Getter methods for this class
	 */
	
	public String getHeaderMessage(){
		return getGameTexts().get("mainMenu_headerMessage");
	}

	public void execute() {

		setPlayerChoice(requestPlayerChoice());
		
	}

	public IMenu getNextMenu() {
		
		IMenu nextMenu = null;
		if(getPlayerChoice().equals(0))
		{
			nextMenu = new GameMainMenu(getGameTexts(),getMenuList());
		}else if(getPlayerChoice().equals(1))
		{
			nextMenu = new CreditsMenu(getGameTexts(),getMenuList());
		}else if(getPlayerChoice().equals(2))
		{
			nextMenu = new ExitMenu(getGameTexts(),getMenuList());
		}
		return nextMenu;
	}
}