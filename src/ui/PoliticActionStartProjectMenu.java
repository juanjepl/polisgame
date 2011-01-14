package ui;

import game.AvailableActionsManager;
import game.Game;
import game.Polis;
import game.Project;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PoliticActionStartProjectMenu extends AbstractMenu {

	private List<String> availableValuesForRequest;
	private List<Project> possibleProjects;
	
	public PoliticActionStartProjectMenu(Map<String, String> gameTexts, List<IMenu> menuList, Game game) {
		super(gameTexts, menuList);
		this.setGame(game);
		if (game == null) throw new IllegalArgumentException("'game' cannot be null");
		availableValuesForRequest = new ArrayList<String>();
		possibleProjects = new ArrayList<Project>();
	}

	public List<Project> getPossibleProjects()
	{
		return possibleProjects;
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
                for(Project proj: getGame().getRound().getProjectsInThisRound()){
                        if(AvailableActionsManager.checkStartProjectAction(po, proj)){
                                possibleProjects.add(proj);
                                optionList.add(proj.getName());
                                availableValuesForRequest.add(index.toString());
                                index++;
                        }
                }
        }
			
			
		}
		
		showMenuContents();
		setPlayerChoice(requestPlayerChoice(getAvailableValuesForRequest()));
		
	}

	public String getHeaderMessage() {
		return getGameTexts().get("politicActionStartProjectMenu_headerMessage");
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
			next = new PoliticActionStartProjectSelectPolisMenu(getGameTexts(),getMenuList(), getGame(), getPossibleProjects().get(getPlayerChoice()));
			break;
		}
		return next;
	}
	
	public List<String> getAvailableValuesForRequest(){
		return availableValuesForRequest;
	}

}
