package ui_2;

import game.Game;

import java.util.List;

public class MainMenu{// implements IMenu{

	private String headerMessage;
	private List<String> optionsList;
	
	public MainMenu(){
		headerMessage = Game.getGameTexts().get("MainMenu_headerMessage");
		//TODO
	}
	
}
