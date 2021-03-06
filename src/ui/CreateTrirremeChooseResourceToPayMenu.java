package ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import game.CreateTrirremeAction;
import game.CreatorAction;
import game.Game;
import game.Polis;

public class CreateTrirremeChooseResourceToPayMenu extends AbstractMenu{

	private Polis selectedPolis;
	private String selectedResource;
	
	public CreateTrirremeChooseResourceToPayMenu(Map<String, String> gameTexts, List<IMenu> menuList, Game game, Polis selectedPolis){
		super(gameTexts,menuList);
		setGame(game);
		
		this.selectedPolis = selectedPolis;
		selectedResource = "";
	}
	
	public void execute(){
		// clear options for possible back re-execute
		getMenuOptionsList().clear();
		
		String silver = getGameTexts().get("silver");
		String wood = getGameTexts().get("wood");
		
		CreatorAction cA;
		
		String back = getGameTexts().get("back");
		getMenuOptionsList().add(back);
		
		
		List<String> payments = new ArrayList<String>();
		
		// two if blocks, not one with else if
		if(getGame().getWhoHasTheTurn().getSilver() > 0){
			getMenuOptionsList().add(silver);
			payments.add("Silver");
		}
		
		if(getGame().getWhoHasTheTurn().getWood() > 0){
			getMenuOptionsList().add(wood);
			payments.add("Wood");
		}
		
		showMenuContents();
		setPlayerChoice(requestPlayerChoice());
		
		
		if(getPlayerChoice().equals(1)){
			setSelectedResource(payments.get(0)); // 0 because is 1st string of the list
			
			if(getSelectedPolis().getPolisSeas().size() > 1){
				
				// we need another menu ( see getNextMenu )
				
			}else{
				// Do action
				cA = new CreateTrirremeAction(getGame().getWhoHasTheTurn(),getSelectedPolis(),getSelectedPolis().getPolisSeas().get(0),getSelectedResource());
				
				// Introduces Action in the actual turn
				getGame().getRound().getCurrentTurn().addGameAction(cA);
				
				// Finally a notification for the player
				showActionDoneMessage();
			}
			
			
		}else if(getPlayerChoice().equals(2)){
			setSelectedResource(payments.get(1)); // 1 because is 2nd string of the list
			
			if(getSelectedPolis().getPolisSeas().size() > 1){
				
				// we need another menu ( see getNextMenu )
				
			}else{
				// Do action
				cA = new CreateTrirremeAction(getGame().getWhoHasTheTurn(),getSelectedPolis(),getSelectedPolis().getPolisSeas().get(0),getSelectedResource());
				
				// Introduces Action in the actual turn
				getGame().getRound().getCurrentTurn().addGameAction(cA);
				
				// Finally a notification for the player
				showActionDoneMessage();
			}
			
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
			
			if(getSelectedPolis().getPolisSeas().size() > 1){
				next = new CreateTrirremeChooseCreationSea(getGameTexts(),getMenuList(),getGame(),getSelectedPolis(),getSelectedResource());
				
			}else{
				for(IMenu iteratedMenu : getMenuList()){
					if(iteratedMenu instanceof GameMainMenu){
						next = iteratedMenu;
						next.setAutoExecutable(false);
					}
				}
			}
			
			
		}
		return next;
	}
	
	public String getHeaderMessage() {
		return getGameTexts().get("createTrirremeChooseResourceToPayMenu_headerMessage");
	}
	
	public Polis getSelectedPolis(){
		return selectedPolis;
	}
	
	public void showActionDoneMessage(){
		System.out.println(" "); // White space
		System.out.println(getGameTexts().get("createTrirremeChooseResourceToPayMenu_actionDoneMessage")+ getSelectedPolis().getPolisSeas().get(0).getName());
	}
	
	public String getSelectedResource(){
		return selectedResource;
	}
	
	public void setSelectedResource(String resource){
		selectedResource = resource;
	}
}