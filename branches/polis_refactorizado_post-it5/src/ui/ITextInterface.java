package ui;

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
	public void showMenu();
}
