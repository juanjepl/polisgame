package ui;

import java.util.List;
import java.util.Map;

public class ExitMenu extends AbstractMenu {
	public ExitMenu(Map<String, String> gameTexts, List<IMenu> menuList) {
		super(gameTexts, menuList);
	}

	public String getHeaderMessage() {
		return getGameTexts().get("exit");
	}
	
	public void execute() {
		showMenuContents();
		setPlayerChoice(requestPlayerChoice());
		System.exit(0);
	}

	public IMenu getNextMenu() {
		return null;
	}
}
