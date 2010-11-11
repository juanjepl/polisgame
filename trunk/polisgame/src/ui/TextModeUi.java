package ui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class TextModeUi implements IUserInterface{

	public TextModeUi(){}
	
	// This method request player's name and returns them.
	public List<String> requestPlayerNames(){
	
	String spartaPlayer = "";	
	String athensPlayer = "";
	
	System.out.print("Sparta player's name: ");
	BufferedReader br_sparta = new BufferedReader(new InputStreamReader(System.in));
	try {
		spartaPlayer = br_sparta.readLine();
	} catch (Exception e) {
		//TODO
	}

	System.out.print("Athens player's name: ");
	BufferedReader br_athens = new BufferedReader(new InputStreamReader(System.in));
	try {
		athensPlayer = br_athens.readLine();
	} catch (Exception e) {	
		//TODO
	}
	
	List<String> twoNames = new ArrayList<String>(2);
	twoNames.add(spartaPlayer);
	twoNames.add(athensPlayer);
	return twoNames;
	
	}
	
	public void showPlayerTurn(){
		String message = "";
		
		//TODO a "xxxxx's turns round x turn x " --> use translation of data.gameTexts and Game->Players->getnamePlayerX
		
		System.out.println(message);
	}
	
	public void showNewRound(){
		String message = "";
		
		//TODO an advice of changing round
		
		System.out.println(message);
	}
	
	public List<String> showAvailableActions(){
		List<String> availableActions = new LinkedList<String>();
		
		//TODO also the texts in data.gameTexts
		
		Integer index = 1;
		for(String possibleAction : availableActions){
			
			System.out.println(index + " - " + possibleAction);
			index += 1;
		}
		return availableActions;
	}
	
	//TODO more and more methods required.
	

}
