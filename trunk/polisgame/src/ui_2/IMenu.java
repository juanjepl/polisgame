package ui_2;

/** Defines structure of generic menu */
public interface IMenu {
	/** Shows a message for the Player with the kind of the chooses */	
	public void showMessageHeaderForMenu();
	
	/** Shows the options to choose for this menu */
	public void showPlayerChoices();
	
	/**  */
	public void showContents();
	public Integer getPlayerChoice();

}
