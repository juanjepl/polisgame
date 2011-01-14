package ui;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import utils.PolReader;
import game.Player;
import game.Round;
import game.Game;
import game.Turn;

/**
 * This class implements a user interface
 * using text console
 */
public class TextInterface{
	private IMenu focusedMenu;
	private List<IMenu> menuList;
	private Map<String,String> gameTexts;
	
	public TextInterface(Game game){
		//game can be null for initialization
		PolReader gameTextsFileReader = new PolReader();
		gameTexts = gameTextsFileReader.readGameTexts();
		menuList = new ArrayList<IMenu>();
		
		focusedMenu = new MainMenu(getGameTexts(),getMenuList(),game);
		menuList.add(focusedMenu); // First in the list
		
		//TODO
	}

	public void showChangeOfRound(Round theNewRound){
		if(theNewRound == null){
			throw new IllegalArgumentException("Invalid parameter for showChangeOfRound, cannot be null");
		}
		System.out.println(" "); // White line
		System.out.println(getGameTexts().get("TextInterface_newRoundMessage")+" "+getGameTexts().get("round")+" "+theNewRound.getRoundName());
	}
	
	public void showRTAPMessage(Player player, Turn turn){
		if(player == null || turn == null){
			throw new IllegalArgumentException("Invalid paramater(s) for showRTAPMessage(), cannot be null");
		}
		
		String numberAction = "";
		
		if(turn.getSecondAction() == null){
			numberAction = getGameTexts().get("firstAction");
		}else{
			numberAction = getGameTexts().get("secondAction");
		}
		
		System.out.println(" "); // White line
		System.out.println(getGameTexts().get("player")+": "+player.getName()+"   "+getGameTexts().get("turn")+": "+Turn.getTurnCount().toString()+"   "+getGameTexts().get("action")+": "+numberAction);
	}
	
	public void showCurrentStateOfTheGame(Game theGame){
		if(theGame == null){
			throw new IllegalArgumentException("Invalid parameter for showCurrentStateOfTheGame(), cannot be null");
		}
		
		// Shows Round+Turn+Action+Player message (R+T+A+P)
		
		Player focusedPlayer = theGame.getWhoHasTheTurn();
		
		showRTAPMessage(focusedPlayer,theGame.getRound().getCurrentTurn());
		
		System.out.println(" ");
		System.out.println("--- " + getGameTexts().get("resources") + " ---"); 
		System.out.println("[" + getGameTexts().get("prestige") +"]: " + focusedPlayer.getPrestige().toString() + " " + getGameTexts().get("units"));
		System.out.println("[" + getGameTexts().get("metal") +"]: " + focusedPlayer.getMetal().toString() + " " + getGameTexts().get("units"));
		System.out.println("[" + getGameTexts().get("wood") +"]: " + focusedPlayer.getWood().toString() + " " + getGameTexts().get("units"));
		System.out.println("[" + getGameTexts().get("wheat") +"]: " + focusedPlayer.getWheat().toString() + " " + getGameTexts().get("units"));
		System.out.println("[" + getGameTexts().get("oil") +"]: " + focusedPlayer.getOil().toString() + " " + getGameTexts().get("units"));
		System.out.println("[" + getGameTexts().get("wine") +"]: " + focusedPlayer.getWine().toString() + " " + getGameTexts().get("units"));
		System.out.println("[" + getGameTexts().get("silver") +"]: " + focusedPlayer.getSilver().toString() + " " + getGameTexts().get("units"));
		
		
		//+  + " " + "[" + getGameTexts().get("silver") +"]: " + focusedPlayer.getSilver().toString() + " " + getGameTexts().get("units") + " " +"[" + getGameTexts().get("Wood") +"]: " + focusedPlayer.getWood().toString() + " " + getGameTexts().get("units") + " " +"[" + getGameTexts().get("wheat") +"]: " + focusedPlayer.getWheat().toString() + " " + getGameTexts().get("units") + " " +"[" + getGameTexts().get("wine") +"]: " + focusedPlayer.getWine().toString() + " " + getGameTexts().get("units") + " " + "[" + getGameTexts().get("oil") +"]: " + focusedPlayer.getOil().toString() + " " + getGameTexts().get("units") );
		
		//TODO
		//TODO
	}
	
	/**
	 * Getters and Setters for this class
	 */
	
	public Map<String,String> getGameTexts(){
		return gameTexts;
	}
	
	public List<IMenu> getMenuList(){
		return menuList;
	}
	
	public IMenu getMenu(){
		return focusedMenu;
	}
	
	public void executeMenu()
	{
		while(getMenu() != null && getMenu().getAutoExecutable())
		{
			getMenu().execute();
			setMenu();	
		}
	}
	
	public void setMenu(){

		if(!(getMenuList().contains(getMenu())))
		{
			getMenuList().add(getMenu());
		}else
		{
			Integer limit = getMenuList().indexOf(getMenu()); //limit + 2 index = size index
			while(getMenuList().size() - 1 > limit){
				getMenuList().remove((getMenuList().size()) - 1);
			}
		}
		
		focusedMenu = getMenu().getNextMenu();
		
		

	}
	public void showNewRound(Round round)
	{
		System.out.println(" ");
		System.out.println(getGameTexts().get("newRound")  + ": " + round.getRoundName());
	}
	
	public void showFirstActionMessage(){
		System.out.println(" ");
		System.out.println("--- "+getGameTexts().get("firstAction") + " " + getGameTexts().get("action")+" ---");
	}
	
	public void showSecondActionMessage(){
		System.out.println(" ");
		System.out.println("--- "+getGameTexts().get("secondAction") + " " + getGameTexts().get("action")+" ---");
	}

	public void setGame(Game game){
		getMenu().setGame(game);
	}
}