package ui;

import game.Game;
import game.Polis;
import game.Project;
import game.StartAProjectAction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PoliticActionStartProjectSelectResourcesMenu extends AbstractMenu{
		
	private List<String> availableValuesForRequest;
	private Project project;
	private Polis polis;
	private Map<String, Integer> selectedResources;
	
	public PoliticActionStartProjectSelectResourcesMenu(Map<String, String> gameTexts, List<IMenu> menuList, Game game, Project project, Polis polis) {
		super(gameTexts, menuList);
		this.setGame(game);
		if (game == null) throw new IllegalArgumentException("'game' cannot be null");
		availableValuesForRequest = new ArrayList<String>();
		selectedResources = new HashMap<String, Integer>();
		this.project = project;
		this.polis = polis;
	}
	
	public Map<String, Integer> getSelectedResources()
	{
		return selectedResources;
	}
	public Polis getPolis()
	{
		return polis;
	}
	public Project getProject()
	{
		return project;
	}
	

		
	public void execute() {
		
		if(getMenuOptionsList().isEmpty())
		{

			List<String> optionList = getMenuOptionsList();
			List<String> optionListName = new ArrayList<String>();
			// Opt 0 (Exit):
			optionList.add(getGameTexts().get("back"));
			availableValuesForRequest.add("0");
			
			// Opt 1
			optionList.add(getGameTexts().get("politicActionStartProjectSelectResourcesMenu_payResources"));
			availableValuesForRequest.add("1");
			
			showHeaderMessage();
			showMenuContents();
			setPlayerChoice(requestPlayerChoice(getAvailableValuesForRequest()));
			
			if(getPlayerChoice().equals(1))
			{
				//FIXME falla al mostrar correctamente los recursos a elegir
				for(String resource : getProject().getResourcesRequired().keySet()){
					
					optionList.clear();
					availableValuesForRequest.clear();
					
					System.out.println(getGameTexts().get("politicActionStartProjectSelectResourcesMenu_selectResource"));
					
					optionList.add(getGameTexts().get(resource.toLowerCase()));
					optionListName.add(resource);
					availableValuesForRequest.add("0");
	
					optionList.add(getGameTexts().get("silver"));
					optionListName.add("Silver");
					availableValuesForRequest.add("1");
					
					showMenuContents();
					setPlayerChoice(requestPlayerChoice(getAvailableValuesForRequest()));
					
					if(selectedResources.containsKey(optionListName.get(getPlayerChoice())))
					{
						Integer amount = selectedResources.get(optionListName.get(getPlayerChoice()));
						Integer requiredAmount = getProject().getResourcesRequired().get(optionListName.get(getPlayerChoice()));
						Integer total = amount + requiredAmount;
						selectedResources.put(optionListName.get(getPlayerChoice()) , total);
					}else
					{
						selectedResources.put(optionListName.get(getPlayerChoice()) , getProject().getResourcesRequired().get(optionListName.get(getPlayerChoice())));
					}
	            }
				
				setPlayerChoice(1); //value for execute action
				
				// Do action
				StartAProjectAction startProject = new StartAProjectAction(getGame().getWhoHasTheTurn(),polis,getProject(), getSelectedResources());
				
				// Introduces Action in the actual turn
				getGame().getRound().getCurrentTurn().addGameAction(startProject);
					
				// Finally a notification for the player
				showActionDoneMessage();
			}
				
		}
	}

	public void showHeaderMessage()
	{
		System.out.println(" ");
		System.out.println(getGameTexts().get("politicActionStartProjectSelectResourcesMenu_headerMessage"));
		System.out.println(" ");
	}
	
	public String getHeaderMessage() {
		return "";
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
			
	public void showActionDoneMessage(){
		System.out.println(" "); // White space
		System.out.println(getGameTexts().get("politicActionStartProjectSelectPolisMenu_projectHaveBeenCreated")+ " " + getProject().getName());
	}
			
			
	public List<String> getAvailableValuesForRequest(){
		return availableValuesForRequest;
	}
	
	public void showMenuContents(){
	
		// Shows the list of options to be chosen if exists
		if(!(getMenuOptionsList().isEmpty())){
			Integer counter = 0;
			for(String optionInMenu : getMenuOptionsList()){
				System.out.println(counter.toString() + " - "+ optionInMenu);
				counter += 1;
			}
		}
	}

}
