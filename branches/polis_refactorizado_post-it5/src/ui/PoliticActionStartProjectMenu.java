package ui;

import game.Game;
import java.util.List;
import java.util.Map;

public class PoliticActionStartProjectMenu extends AbstractMenu {
	private Game game;
	
	public PoliticActionStartProjectMenu(Map<String, String> gameTexts, List<IMenu> menuList, Game game) {
		super(gameTexts, menuList);
		if (game == null) throw new IllegalArgumentException("'game' cannot be null");
		this.game = game;
		//TODO: El numero de opciones (proyectos) es variable
	}

	public void execute() {
		setPlayerChoice(requestPlayerChoice());
		// TODO
	}

	public String getHeaderMessage() {
		return getGameTexts().get("gamePoliticActionStartProjectMenu_headerMessager");
	}

	public IMenu getNextMenu() {
		IMenu next = null;
		Integer choice = getPlayerChoice();
		
		//TODO: El numero de opciones (proyectos) es variable, no se puede poner un switch y ni una estructura fija de IFs
		// next = getMenuList().get((getMenuList().size()) - 1); // Esto será para volver al menú anterior
		
		return next;
	}

}
