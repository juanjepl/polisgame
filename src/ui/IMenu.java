package ui;

import java.util.List;

/**
 * This Interface defines structure
 * for a generic Menu
 */
public interface IMenu {
	/** returns the message for the Player with the kind of the chooses */	
	public String getHeaderMessage();
	
	/** returns the options available to be chosen*/
	public List<String> getMenuOptionList();
	
	/** Runs the menu and returns the next menu to show or null if there isn't any menu to show **/
	public void execute();
	
	/** returns the choose chosen by the Player */
	public Integer requestPlayerChoice();
	
	public IMenu getNextMenu();
}