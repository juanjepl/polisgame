package ui;

import java.util.Map;
import utils.PolReader;
import game.Player;
import game.Round;
import game.Game;
import game.Turn;

/**
 * This class implements a user interface
 * using text console
 */
public class TextInterface implements ITextInterface{

	private IMenu focusedMenu;
	private Map<String,String> gameTexts;
	
	public TextInterface(){
		PolReader gameTextsFileReader = new PolReader();
		gameTexts = gameTextsFileReader.readGameTexts();
		
		//TODO IMenu mainMenu = new MainMenu(//TODO parameters);
		//TODO showMenu;
	}

	public void showMenuContents(){
		System.out.println(" "); // White line
		System.out.println(getMenu().getMessageHeader()); // Prints message for the player
		System.out.println(" "); // White line
		
		// Shows the list of options to be chosen if exists
		if(!(getMenu().getOptionsToBeChosen().isEmpty())){
			for(String optionInMenu : getMenu().getOptionsToBeChosen()){
				System.out.println(optionInMenu);
			}
		}
	}
	
	public void showChangeOfRound(Round theNewRound){
		if(theNewRound == null){
			throw new IllegalArgumentException("Invalid parameter for showChangeOfRound, cannot be null");
		}
		System.out.println(" "); // White line
		System.out.println(getGameTexts().get("TextInterface_newRoundMessage")+" "+getGameTexts().get("round")+" "+theNewRound.getRoundName());
	}
	
	public void showGameTitle(){
		System.out.println(" ");
		//TODO complete with ASCII ART of polis game
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
		
		//TODO
		//TODO
	}
	
	/**
	 * Getters and Setters for this class
	 */
	
	public Map<String,String> getGameTexts(){
		return gameTexts;
	}
	
	public IMenu getMenu(){
		return focusedMenu;
	}
	
	public void setMenu(IMenu nextMenu){
		if(nextMenu == null){
			throw new IllegalArgumentException("Invalid parameter for setMenu(), cannot be null");
		}
		focusedMenu = nextMenu;
		showMenuContents();
	}
}