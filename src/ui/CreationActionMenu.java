package ui;

import java.util.List;
import java.util.Map;
import exceptions.PolisGameRunningException;
import game.Game;

public class CreationActionMenu extends AbstractMenu {
	private Game game;
	
	public CreationActionMenu(Map<String, String> gameTexts, List<IMenu> menuList, Game game) {
		super(gameTexts, menuList);
		if (game == null) throw new IllegalArgumentException("'game' cannot be null");
		this.game = game;
		Map<String, String> texts = getGameTexts();
		List<String> optionList = getMenuOptionsList();
		
		// TODO Hay que ver cuales opciones de las siguientes estan disponibles:
		optionList.add(texts.get("gameCreationAction_createHoplitesOpt"));
		optionList.add(texts.get("gameCreationAction_createTrirremesOpt"));
		optionList.add(texts.get("gameCreationAction_createMerchantsOpt"));
		optionList.add(texts.get("gameCreationAction_createProxenus"));
		optionList.add(texts.get("gamePoliticActionMenu_cancel"));
	}

	public void execute() {
		setPlayerChoice(requestPlayerChoice());
		// TODO
	}

	public String getHeaderMessage() {
		return getGameTexts().get("gameCreationAction_headerMessage");
	}

	public IMenu getNextMenu() {
		IMenu next = null;
		
		// TODO Hay que ver cuales opciones de las siguientes estan disponibles:
		/*switch (getPlayerChoice()) {
			case 0:
				next = new CreationActionCreateHoplitesMenu(getGameTexts(), getMenuList(), game);
				break;
			case 1:
				next = new CreationActionCreateTrirremesMenu(getGameTexts(), getMenuList(), game);
				break;
			case 2:
				next = new CreationActionCreateMerchantsMenu(getGameTexts(), getMenuList(), game);
				break;
			case 3:
				next = new CreationActionCreateProxenusMenu(getGameTexts(), getMenuList(), game);
				break;
			case 4:
				next = getMenuList().get((getMenuList().size()) - 1); // Last element
				break;
			default:
				throw new PolisGameRunningException("Invalid option choosen at CreationActionMenu");
		}*/
		
		return next;
	}
}

