package ui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

import game.Game;
import game.Turn;
import game.Player;

/** Text-mode user interface class */
public class TextModeUi implements IUserInterface{ //TODO rescue language texts from data.gameTexts

	public TextModeUi(){}
	
	/** This method request player's name and returns them */
	public List<String> requestPlayerNames(){
	
	String spartaPlayer = "";	
	String athensPlayer = "";
	
	System.out.print("Sparta player's nickname: "); //TODO rescue this text from data.gametexts
	
	BufferedReader br_sparta = new BufferedReader(new InputStreamReader(System.in)); // request sparta's player's name
	try {
		spartaPlayer = br_sparta.readLine();
	} catch (Exception e) {
		//TODO
	}

	System.out.print("Athens player's nickname: ");

	BufferedReader br_athens = new BufferedReader(new InputStreamReader(System.in)); // request athens's player's name
	try {
		athensPlayer = br_athens.readLine();
	} catch (Exception e) {	
		//TODO
	}
	
	while(athensPlayer.equals(spartaPlayer)){ // requests the Athens player's name, while hasn't changed.
		System.out.print("Your name cannot be the same as the other player, please, retype your nickname: ");
		BufferedReader br_athens_tries = new BufferedReader(new InputStreamReader(System.in));
		try {
			athensPlayer = br_athens_tries.readLine();
		} catch (Exception e) {	
			//TODO
		}
		
	}
	
	
	List<String> twoNames = new ArrayList<String>(2); // create a list with the 2 names and returns it
	twoNames.add(spartaPlayer);
	twoNames.add(athensPlayer);
	return twoNames;
	
	}
	
	/** This method shows the actual player-round-turn */
	public void showPlayerTurn(Game game){
		String message = "Turn: "+Turn.getTurnCount()+" "+"Player: "+game.getWhoHasTheTurn().getName();		
		System.out.println(message);
	}
	
	/** This method shows a change-of-round advice */
	public void showNewRound(Game game){
		String message = "New Round: "+game.getRound().getName();
		System.out.println(message);
	}
	
	/** This method shows the possibles actions that a player can do */
	public List<String> showAvailableActions(Game g, Player p){
		List<String> availableActions = new LinkedList<String>();
		
		//TODO also the texts in data.gameTexts
		/*
		Integer index = 1;
		for(String possibleAction : availableActions){
			
			System.out.println(index + " - " + possibleAction);
			index += 1;
		}*/
		
		//TODO -> from "system" strings rescued, use gametexts "names"
		
		return availableActions;
	}
	
	//TODO more and more methods required.
	

}
