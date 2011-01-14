package ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import game.AvailableActionsManager;
import game.Game;

public class MilitaryActionMenu extends AbstractMenu {
	private Game game;
	private List<String> availableValuesForRequest;
	
	public MilitaryActionMenu(Map<String, String> gameTexts, List<IMenu> menuList, Game game) {
		super(gameTexts, menuList);
		if (game == null) throw new IllegalArgumentException("'game' cannot be null");
		this.game = game;
		availableValuesForRequest = new ArrayList<String>();
	}
	
	public Game getGame(){
		return game;
	}
	
	public void setGame(Game game){
		this.game = game;
	}
	
	public void execute() {
		
		if(getMenuOptionsList().isEmpty())
		{
			Map<String, String> texts = getGameTexts();
			
			String back = texts.get("back");
			String notAvailable = texts.get("notAvailable");
			String moveHoplite = texts.get("gameMilitaryActionMenu_moveHoplitesOpt");
			String moveTrirreme = texts.get("gameMilitaryActionMenu_moveTrirremesOpt");
			String siegePolis = texts.get("gameMilitaryActionMenu_besiegePolisOpt");
			String plunderTerritory = texts.get("gameMilitaryActionMenu_collectionOpt");
			
			// Options		
			getMenuOptionsList().add(back);
			getAvailableValuesForRequest().add("0");
			
			// Move Hoplite
			if(AvailableActionsManager.checkMoveHopliteAnyAction(getGame(), getGame().getWhoHasTheTurn())){
				getMenuOptionsList().add(moveHoplite);
				getAvailableValuesForRequest().add("1");
			}else{
				getMenuOptionsList().add(moveHoplite + notAvailable);
			}
			
			// Move Trirreme
			if(AvailableActionsManager.checkMoveTrirremeAnyAction(getGame(), getGame().getWhoHasTheTurn())){
				getMenuOptionsList().add(moveTrirreme);
				getAvailableValuesForRequest().add("2");
			}else{
				getMenuOptionsList().add(moveTrirreme + notAvailable);
			}
			
			// SiegePolis
			if(AvailableActionsManager.checkSiegePolisAnyAction(getGame(), getGame().getWhoHasTheTurn())){
				getMenuOptionsList().add(siegePolis);
				getAvailableValuesForRequest().add("3");
			}else{
				getMenuOptionsList().add(siegePolis + notAvailable);
			}
			
			// Plunder territory
			if(AvailableActionsManager.checkPlunderTerritoryAnyAction(getGame(), getGame().getWhoHasTheTurn())){
				getMenuOptionsList().add(plunderTerritory);
				getAvailableValuesForRequest().add("4");
			}else{
				getMenuOptionsList().add(plunderTerritory + notAvailable);
			}
		}
		
		showMenuContents();
		setPlayerChoice(requestPlayerChoice(getAvailableValuesForRequest()));

	}

	public String getHeaderMessage() {
		return getGameTexts().get("gameMilitaryActionMenu_headerMessage");
	}

	public IMenu getNextMenu() {
		IMenu nextMenu = null;
		
		switch (getPlayerChoice()) {
			case 0:
				nextMenu = getMenuList().get((getMenuList().size()-1) - 1); //go back
				break;
			case 1:
				nextMenu = new MilitaryActionMoveHoplitesOriginMenu(getGameTexts(), getMenuList(), game);
				break;
			case 2:
				nextMenu = new MilitaryActionMoveTrirremesOriginMenu(getGameTexts(), getMenuList(), game);
				break;
			case 3:
				nextMenu = new MilitaryActionBesiegePolisMenu(getGameTexts(), getMenuList(), game);
				break;
			case 4:
				nextMenu = new MilitaryActionCollectionMenu(getGameTexts(), getMenuList(), game);
				break;

			default:
				
		}
		
		return nextMenu;
	}
	
	public List<String> getAvailableValuesForRequest(){
		return availableValuesForRequest;
	}
}
