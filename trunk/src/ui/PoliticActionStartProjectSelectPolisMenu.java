package ui;

import game.AvailableActionsManager;
import game.Game;
import game.Polis;
import game.Project;

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

		
		
	}

	public String getHeaderMessage() {
		return getGameTexts().get("politicActionStartProjectSelectPolisMenu_headerMessage");
	}

	public IMenu getNextMenu() {
		IMenu next = null;
		switch (getPlayerChoice()) {
		case 0:
			// Exit:
			next = getMenuList().get((getMenuList().size()-1) - 1); // Last element
			break;
		
		default:
			//create new menu and pass selected project
			next = new PoliticActionStartProjectSelectResourcesMenu(getGameTexts(),getMenuList(), getGame(), getProject(), getPossiblePolis().get(getPlayerChoice() - 1));
			break;
		}
		return next;
	}
	
	public List<String> getAvailableValuesForRequest(){
		return availableValuesForRequest;
	}


}
