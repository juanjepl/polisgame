package ui;

import game.AvailableActionsManager;
import game.Game;
import game.Polis;
import game.Project;
import game.StartAProjectAction;
import game.TradeAction;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PoliticActionStartProjectSelectPolisMenu extends AbstractMenu{
	
	private List<String> availableValuesForRequest;
	private List<Polis> possiblePolis;
	private Project project;
	
	public PoliticActionStartProjectSelectPolisMenu(Map<String, String> gameTexts, List<IMenu> menuList, Game game, Project project) {
		super(gameTexts, menuList);
		this.setGame(game);
		if (game == null) throw new IllegalArgumentException("'game' cannot be null");
		availableValuesForRequest = new ArrayList<String>();
		possiblePolis = new ArrayList<Polis>();
		this.project = project;
	}
	
	public Project getProject()
	{
		return project;
	}
	
	public List<Polis> getPossiblePolis()
	{
		return possiblePolis;
	}
	
	public void execute() {
		
		if(getMenuOptionsList().isEmpty())
		{

			List<String> optionList = getMenuOptionsList();
			
			// Opt 0 (Exit):
			optionList.add(getGameTexts().get("back"));
			availableValuesForRequest.add("0");
			
			Integer index = 1;
			
			for(Polis po : getGame().getWhoHasTheTurn().getPlayerPolis()){
                        if(AvailableActionsManager.checkStartProjectAction(po, getProject())){

                                optionList.add(po.getName());
                                possiblePolis.add(po);
                                availableValuesForRequest.add(index.toString());
                                index++;
                        }
            }
        }
		
		showMenuContents();
		setPlayerChoice(requestPlayerChoice(getAvailableValuesForRequest()));
		
		Polis polis = getPossiblePolis().get(getPlayerChoice());
		//FIXME payment = map resources
		// Do action
		StartAProjectAction startProject = new StartAProjectAction(getGame().getWhoHasTheTurn(),polis,getProject(), payment);
		
		// Introduces Action in the actual turn
		getGame().getRound().getCurrentTurn().addGameAction(startProject);
		
		// Finally a notification for the player
		showActionDoneMessage(getProject().getName());
		
	}

	public String getHeaderMessage() {
		return getGameTexts().get("gamePoliticActionStartProjectMenuSelectPolis_headerMessage");
	}

	public IMenu getNextMenu() {
		IMenu next = null;
		switch (getPlayerChoice()) {
		case 0:
			// Exit:
			next = getMenuList().get((getMenuList().size()-1) - 1); // Last element
			break;
		
		default:
			next = new GameMainMenu(getGameTexts(),getMenuList(), getGame()); //go back to this menu with other player
			next.setAutoExecutable(false); //FIXME provisional. //action completed
			break;
		}
		return next;
	}
	
	public void showActionDoneMessage(String projectName){
		System.out.println(" "); // White space
		System.out.println(getGameTexts().get("PoliticActionStartProjectSelectPolisMenu_projectHaveBeenCreated")+ " " + projectName);//FIXME
	}
	
	
	public List<String> getAvailableValuesForRequest(){
		return availableValuesForRequest;
	}


}
