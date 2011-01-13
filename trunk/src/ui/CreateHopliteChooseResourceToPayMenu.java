package ui;

import game.CreateHopliteAction;
import game.CreatorAction;
import game.Game;
import game.Polis;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CreateHopliteChooseResourceToPayMenu extends AbstractMenu{

	private Polis selectedPolis;
	private String selectedResource;
	
	public CreateHopliteChooseResourceToPayMenu(Map<String, String> gameTexts, List<IMenu> menuList, Game game, Polis selectedPolis){
		super(gameTexts,menuList);
		setGame(game);
		
		this.selectedPolis = selectedPolis;
		selectedResource = "";
	}
	
	public void execute(){
		
		String silver = getGameTexts().get("silver");
		String metal = getGameTexts().get("metal");
		
		CreatorAction cA;
		
		List<String> payments = new ArrayList<String>();
		
		// two if blocks, not one with else if
		if(getGame().getWhoHasTheTurn().getSilver() > 0){
			getMenuOptionsList().add(silver);
			payments.add("Silver");
		}
		
		if(getGame().getWhoHasTheTurn().getMetal() > 0){
			getMenuOptionsList().add(metal);
			payments.add("Metal");
		}
		
		showMenuContents();
		setPlayerChoice(requestPlayerChoice());
		
		if(getPlayerChoice().equals(1)){
			setSelectedResource(payments.get(0)); // 0 because is 1st string of the list
			
			// Do action
			cA = new CreateHopliteAction(getGame().getWhoHasTheTurn(),getSelectedPolis(),getSelectedResource());
			
			// Introduces Action in the actual turn
			getGame().getRound().getCurrentTurn().addGameAction(cA);
			
			// Finally a notification for the player
			showActionDoneMessage();
			
		}else if(getPlayerChoice().equals(2)){
			setSelectedResource(payments.get(1)); // 1 because is 2nd string of the list
			
			// Do action
			cA = new CreateHopliteAction(getGame().getWhoHasTheTurn(),getSelectedPolis(),getSelectedResource());
			
			// Introduces Action in the actual turn
			getGame().getRound().getCurrentTurn().addGameAction(cA);
			
			// Finally a notification for the player
			showActionDoneMessage();
			
		}else{
			// do nothing, option "equals(0)" is not used here
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
	
	public String getHeaderMessage() {
		return getGameTexts().get("createHopliteChooseResourceToPay_headerMessage"); //FIXME gametext-> "Elija un recurso a gastar para esta accion:"
	}
	
	public Polis getSelectedPolis(){
		return selectedPolis;
	}
	
	public void showActionDoneMessage(){
		System.out.println(" "); // White space
		System.out.println(getGameTexts().get("createHopliteChooseResourceToPayMenu_actionDoneMessage")+ getSelectedPolis().getPolisParentTerritory().getName()); // FIXME gametext-> "Hoplita creado en "
	}
	
	public String getSelectedResource(){
		return selectedResource;
	}
	
	public void setSelectedResource(String resource){
		selectedResource = resource;
	}
}