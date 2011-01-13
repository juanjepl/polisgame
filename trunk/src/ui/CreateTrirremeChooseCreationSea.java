package ui;

import game.CreateTrirremeAction;
import game.Game;
import game.Polis;
import game.Sea;
import game.CreatorAction;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CreateTrirremeChooseCreationSea extends AbstractMenu{
	
	private Polis selectedPolis;
	private String selectedResource;
	
	public CreateTrirremeChooseCreationSea(Map<String, String> gameTexts, List<IMenu> menuList, Game game, Polis selectedPolis,String selectedResource){
		super(gameTexts,menuList);
		setGame(game);
		
		this.selectedPolis = selectedPolis;
		this.selectedResource = selectedResource;
	}
	
	public void execute(){
		
		CreatorAction cA;
		
		List<Sea> seasAvailables = new ArrayList<Sea>();
		
		for(Sea sea: getSelectedPolis().getPolisSeas()){
			if(sea.getNumberOfFreeSlotsForAPlayer(getGame().getWhoHasTheTurn(),getGame().getRound()) > 0 ){
				seasAvailables.add(sea);
				getMenuOptionsList().add(sea.getName());
			}
		}
		
		showMenuContents();
		setPlayerChoice(requestPlayerChoice());
		
		// Do action if player's choice isn't back
		if(getPlayerChoice() != 0){			
			cA = new CreateTrirremeAction(getGame().getWhoHasTheTurn(), getSelectedPolis() ,seasAvailables.get(getPlayerChoice() - 1) , getSelectedResource());
			getGame().getRound().getCurrentTurn().addGameAction(cA);
			
			System.out.println(" ");
			System.out.println(getGameTexts().get("CreateTrirremeChooseCreationSea_actionDoneMessage"+seasAvailables.get(getPlayerChoice() - 1).getName())); //FIXME "Trirreme creada en "
		}
		
	}
	
	public IMenu getNextMenu(){
		IMenu next = null;
		Integer choice = getPlayerChoice();
		
		if(choice.equals(0)){
			next = getMenuList().get((getMenuList().size()-1) - 1);
		}else{
			for(IMenu iteratedMenu : getMenuList()){
				if(iteratedMenu instanceof GameMainMenu){
					next = iteratedMenu;
					next.setAutoExecutable(false);
				}
			}
		}
		return next;
	}

	public String getHeaderMessage(){
		return getGameTexts().get("createTrirremeChooseCreationSea_headerMessage"); //FIXME gametext-> "Elija el mar donde situar la Trirreme creada:"
	}
	
	public Polis getSelectedPolis() {
		return selectedPolis;
	}

	public String getSelectedResource() {
		return selectedResource;
	}
}