package ui_2;

public class TextInterface implements ITextInterface{

	private IMenu focusedMenu;
	
	public TextInterface(){
		//TODO IMenu mainMenu = new MainMenu(//TODO parameters);
		//TODO showMenu;
	}
	
	public IMenu getMenu(){
		return focusedMenu;
	}
	
	public void setMenu(IMenu nextMenu){
		if(!(nextMenu instanceof IMenu)){
			throw new IllegalArgumentException("Setted menu isn't a instance of IMenu");
		}
		focusedMenu = nextMenu;
		showMenu();
	}
	
	public void showMenu(){
		focusedMenu.showContents();
	}
}