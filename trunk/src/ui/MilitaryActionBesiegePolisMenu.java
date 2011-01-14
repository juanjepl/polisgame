package ui;

import exceptions.PolisGameRunningException;
import game.AvailableActionsManager;
import game.Game;
import game.Player;
import game.Polis;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MilitaryActionBesiegePolisMenu extends AbstractMenu {
	private Game game;
	private List<String> availableValuesForRequest;
	private List<Polis> polisToSiege;
	
	public MilitaryActionBesiegePolisMenu(Map<String, String> gameTexts, List<IMenu> menuList, Game game) {
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
		if(getMenuOptionsList().isEmpty()) {
			List<String> optList = getMenuOptionsList();
			Map<String, String> texts = getGameTexts();
			
			// Opcion volver
			optList.add(texts.get("back"));
			availableValuesForRequest.add("0");
			
			// Opciones de elegir ciudad a asediar:
			Player currentPlayer = game.getWhoHasTheTurn();
			Map<String, Polis> gamePolis = game.getGamePolis();
			
			for (Polis polis: gamePolis.values()) {
				if (AvailableActionsManager.checkSiegePolisAction(currentPlayer, polis)) {
					polisToSiege.add(polis);
					
					// Nueva opcion para el menu
					optList.add(polis.getName());
					Integer optionIndex = availableValuesForRequest.size();
					availableValuesForRequest.add(optionIndex.toString());
				}
			}
		}
		
		showMenuContents();
		setPlayerChoice(requestPlayerChoice(getAvailableValuesForRequest()));
	}

	private List<String> getAvailableValuesForRequest() {
		return availableValuesForRequest;
	}
	
	public String getHeaderMessage() {
		return getGameTexts().get("gameMilitaryActionBesiegePolisMenu_headerMessage");
	}

	public IMenu getNextMenu() {
		IMenu next;
		Integer userChoice = getPlayerChoice();
		if (userChoice < 0 || userChoice > (availableValuesForRequest.size() - 1)) throw new PolisGameRunningException("Option not available choosen at MilitaryActionBesiegePolisMenu");
		
		if(userChoice.equals(0)){
			next = getMenuList().get((getMenuList().size()-1) - 1);
		} else {
			Polis choosenPolisToSiege = polisToSiege.get(userChoice - 1);
			next = new MilitaryActionBesiegePolisMakeMenu(getGameTexts(), getMenuList(), game, choosenPolisToSiege);
		}
		
		return next;
	}
}
