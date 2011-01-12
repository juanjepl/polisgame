package ui;

import java.util.List;
import java.util.Map;

public class GameMainMenuOptions extends AbstractMenu {

	public GameMainMenuOptions(Map<String, String> gameTexts, List<IMenu> menuList){
		super(gameTexts,menuList);
		String renamePlayer = getGameTexts().get("gameMainMenuOptions_renamePlayer");
		String back = getGameTexts().get("back");
		
		getMenuOptionsList().add(back);
		getMenuOptionsList().add(renamePlayer);
		

	}

	public String getHeaderMessage(){
		return getGameTexts().get("gameMainMenuOptions_headerMessage");
	}

	public void execute() {
		showMenuContents();
		setPlayerChoice(requestPlayerChoice());
		
	}

	public IMenu getNextMenu() {
		IMenu nextMenu = null;
		if(getPlayerChoice().equals(0))
		{
			nextMenu = getMenuList().get(getMenuList().size() - 1);
			
		}else if(getPlayerChoice().equals(1))
		{
			nextMenu = new renamePlayerMenu(getGameTexts(),getMenuList(), getGame());
		}
		
		return nextMenu;
	}
}
