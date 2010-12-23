package ui;

import game.Round;
import game.Game;
import game.Player;
import game.Turn;

/**
 * This interface's objetive is to manage
 * navigation between menu and another one:
 * we'll have an instance of menu saved in an
 * attribute and we'll change and show it to
 * the player when in a menu we'll navigate to
 * other menu's option
 */
public interface ITextInterface {
	/** Getter method for Menu "focused" instance */
	public IMenu getMenu();
	
	/** We'll overwrite this variable with the next menu to be shown */
	public void setMenu(IMenu nextMenu);
	
	/** Shows in text console, the "focused" menu */
	public void showMenuContents();
	
	/** This method shows an ASCII ART with the game title */
	public void showGameTitle();
	
	/** Shows a message when the round changes */
	public void showChangeOfRound(Round theNewRound);
	
	/** Shows the actual Round-Turn-Action and Player who has the turn message */
	public void showRTAPMessage(Player player, Turn turn);
	
	/** Shows the current state of the game */
	public void showCurrentStateOfTheGame(Game theGame);
}