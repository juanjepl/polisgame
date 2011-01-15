package ui;

import game.AvailableActionsManager;
import game.Game;
import game.Player;
import game.PlunderTerritoryAction;
import game.Territory;
import java.util.List;
import java.util.Map;

public class MilitaryActionCollectionMakeMenu extends AbstractMenu {
	private Game game;
	private Territory territoryToPlunder;
	private Map<String, Integer> resourceTypeUnitCount;
	
	public MilitaryActionCollectionMakeMenu(Map<String, String> gameTexts, List<IMenu> menuList, Game game, Territory territoryToPlunder, Map<String, Integer> resourceTypeUnitCount) {
		super(gameTexts, menuList);
		if (game == null) throw new IllegalArgumentException("'game' cannot be null");
		this.game = game;
		this.territoryToPlunder = territoryToPlunder;
		this.resourceTypeUnitCount = resourceTypeUnitCount;
	}

	public Game getGame(){
		return game;
	}
	
	public void setGame(Game game){
		this.game = game;
	}
	
	public void execute() {
		Map<String, String> texts = getGameTexts();
		
		// Hacemos la accion
		Player currentPlayer = game.getWhoHasTheTurn();
			
		Integer hoplitesCount = 0;
		for (Integer resourceHoplites: resourceTypeUnitCount.values()) hoplitesCount += resourceHoplites;
			
		if (AvailableActionsManager.checkPlunderTerritoryAction(currentPlayer, territoryToPlunder, game.getRound(), hoplitesCount)) {
			PlunderTerritoryAction action = new PlunderTerritoryAction(currentPlayer, territoryToPlunder, resourceTypeUnitCount);
			System.out.println(texts.get("gameMilitaryActionCollectionMakeMenu_success"));
			game.getRound().getCurrentTurn().addGameAction(action);
		}
		else {
			System.out.println(texts.get("gameMilitaryActionCollectionMakeMenu_error"));
		}
	}

	public String getHeaderMessage() {
		return getGameTexts().get("gameMilitaryActionCollectionMakeMenu_headerMessage");
	}

	public IMenu getNextMenu() {
		// Volvemos al menu de juego:
		return getMenuList().get(0);
	}
}
