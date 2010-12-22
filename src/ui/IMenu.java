package ui;

import java.util.List;

/**
 * This Interface defines structure
 * for a generic Menu
 */
public interface IMenu {
	/** returns the message for the Player with the kind of the chooses */	
	public String getMessageHeader();
	
	/** returns the options available to be chosen*/
	public List<String> getOptionsToBeChosen();
	
	/** returns the choose chosen by the Player */
	public Integer getPlayerChoice();
}