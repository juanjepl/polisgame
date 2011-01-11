package ui;

import java.util.Map;
import java.util.List;
import exceptions.PolisGameRunningException;

public class CreditsMenu extends AbstractMenu{

	public CreditsMenu(Map<String,String> gameTexts, List<IMenu> menuList){
		super(gameTexts,menuList);
		
		String back = getGameTexts().get("back");
		getMenuOptionsList().add(back);

	}
	public String getHeaderMessage(){
		return getGameTexts().get("creditsMenu_HeaderMessage");
	}
	
	public void execute(){
		showGameCredits();
		showMenuContents();
		setPlayerChoice(requestPlayerChoice());
	}
	
	public IMenu getNextMenu(){
		IMenu nextMenu;
		
		if(getPlayerChoice().equals(0)){
			nextMenu = getMenuList().get((getMenuList().size()) - 1);// Last element
		}else{
			throw new PolisGameRunningException("Invalid option choosen at CreditsMenu");
		}
		return nextMenu;
	}
	
	public void showGameCredits(){
		System.out.println(" "); // White space
		System.out.println("********************************************************");
		System.out.println("*           P O L I S   :   T H E   G A M E            *");
		System.out.println("********************************************************");
		System.out.println(" ");
		System.out.println("********************************************************");
		System.out.println("*         Proyecto creado para asignatura ISG2         *");
		System.out.println("********************************************************");
		System.out.println("*  Equipo desarrollador:                               *");
		System.out.println("*                                                      *");
		System.out.println("*                   Samuel Navas Portillo              *");
		System.out.println("*                   Juan Jesús Pérez Luna              *");
		System.out.println("*                   José Antonio Jiménez Carmona       *");
		System.out.println("*                   Manuel de los Santos Campos        *");
		System.out.println("*                   Ángel Martínez Olivares            *");
		System.out.println("*                   María José Sancha Maya             *");
		System.out.println("*                                                      *");
		System.out.println("********************************************************");
		System.out.println(" ");
		System.out.println("********************************************************");
		System.out.println("*            ¡¡ Gracias por jugar a Polis !!           *");
		System.out.println("********************************************************");
		System.out.println(" ");
	}
}
