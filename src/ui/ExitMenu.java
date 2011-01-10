package ui;

import java.util.Map;

public class ExitMenu extends AbstractMenu {
	public ExitMenu(Map<String, String> gameTexts) {
		super(gameTexts);
	}

	public String getHeaderMessage() {
		return "Salir";
	}
	
	public void execute() {
		System.exit(0);
	}

	public IMenu getNextMenu() {
		return null;
	}
}
