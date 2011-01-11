package ui;

import java.util.List;
import java.util.Map;
import exceptions.PolisGameRunningException;
import game.Game;

public class MilitaryActionMenu extends AbstractMenu {
	private Game game;
	
	public MilitaryActionMenu(Map<String, String> gameTexts, List<IMenu> menuList, Game game) {
		super(gameTexts, menuList);
		if (game == null) throw new IllegalArgumentException("'game' cannot be null");
		this.game = game;
		Map<String, String> texts = getGameTexts();
		List<String> optionList = getMenuOptionsList();
		
		// TODO Hay que ver cuales opciones de las siguientes estan disponibles:
		optionList.add(texts.get("gameMilitaryActionMenu_moveHoplitesOpt"));
		optionList.add(texts.get("gameMilitaryActionMenu_moveTrirremesOpt"));
		optionList.add(texts.get("gameMilitaryActionMenu_besiegePolisOpt"));
		optionList.add(texts.get("gameMilitaryActionMenu_collectionOpt"));
		optionList.add(texts.get("gamePoliticActionMenu_cancel"));
	}

	public void execute() {
		setPlayerChoice(requestPlayerChoice());
		// TODO
	}

	public String getHeaderMessage() {
		return getGameTexts().get("gameMilitaryActionMenu_headerMessage");
	}

	public IMenu getNextMenu() {
		IMenu next = null;
		
		// TODO Hay que ver cuales opciones de las siguientes estan disponibles:
		/*switch (getPlayerChoice()) {
			case 0:
				next = new MilitaryActionMoveHoplitesMenu(getGameTexts(), getMenuList(), game);
				break;
			case 1:
				next = new MilitaryActionMoveTrirremesMenu(getGameTexts(), getMenuList(), game);
				break;
			case 2:
				next = new MilitaryActionBesiegePolisMenu(getGameTexts(), getMenuList(), game);
				break;
			case 3:
				next = new MilitaryActionCollectionMenu(getGameTexts(), getMenuList(), game);
				break;
			case 4:
				next = getMenuList().get((getMenuList().size()) - 1); // Last element
				break;
			default:
				throw new PolisGameRunningException("Invalid option choosen at PoliticActionMenu");
		}*/
		
		return next;
	}
}
