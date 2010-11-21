package ui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

import game.Game;
import game.Turn;
import game.Player;
import game.Sea;

/** Text-mode user interface class */
public class TextModeUi implements IUserInterface{ //TODO rescue language texts from data.gameTexts

	public TextModeUi(){}
	
	/** Welcome message */
	public static void creditsMessage(){
		
		System.out.println("****************************************************************");
		System.out.println("*                                                              *");
		System.out.println("*           P O L I S  :          T H E    G A M E             *");
		System.out.println("*                                                              *");
		System.out.println("****************************************************************");
		System.out.println("*                                                              *");
		System.out.println("*  Status: Pre-Alpha non-functional                            *");
		System.out.println("*  Developer Team:    Samuel Navas Portillo                    *");
		System.out.println("*                     Juan Jesús Pérez Luna                    *");
		System.out.println("*                     Ángel Martínez Olivares                  *");
		System.out.println("*                     María José Sancha Maya                   *");
		System.out.println("*                     José Antonio Jiménez Carmona             *");
		System.out.println("*                     Manuel de los Santos Campos              *");
		System.out.println("*                                                              *");
		System.out.println("****************************************************************");
		System.out.println("");
		
	}
	
	/** This method request player's name and returns them */
	public static List<String> requestPlayerNames(){
	
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
	public static void showPlayerTurn(Game game){
		String message = "Turn: "+Turn.getTurnCount()+" "+"Player: "+game.getWhoHasTheTurn().getName();		
		System.out.println(message);
	}
	
	/** This method shows a change-of-round advice */
	public static void showNewRound(Game game){
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
	
	public static String requestPaidMethod(String paidReference){ // -> Paid reference: hoplite,trirreme, etc.
		String paid = "";
		String resource = "";
		
		System.out.println("Please, choose the paid method: "); //TODO -> rescue text from data.gameTexts
		
		// For pay an hoplite
		if(paidReference.equals("hoplite")){
			System.out.println("1 - Metal"); //TODO -> from gameTexts
			System.out.println("2 - Silver");//TODO -> from gameTexts
			BufferedReader br_paid = new BufferedReader(new InputStreamReader(System.in));
			try {
				paid = br_paid.readLine();
			} catch (Exception e) {	
				//TODO
			}
			while(!(paid.equals("1")||paid.equals("2"))){
				System.out.print("Please, insert a correct value (1 or 2): ");//TODO -> from gameTexts
				BufferedReader br_paid_tries = new BufferedReader(new InputStreamReader(System.in));
				try {
					paid = br_paid_tries.readLine();
				} catch (Exception e) {	
					//TODO
				}
			}
			if(paid.equals("1")){
				resource = "Metal";
			}else{
				resource = "Silver";
			}
		
		// For pay a trirreme or a tradeBoat	
		}else if(paidReference.equals("trirreme") || paidReference.equals("tradeBoat")){ // same paid trirreme than tradeBoat
			System.out.println("1 - Wood"); //TODO -> from gameTexts
			System.out.println("2 - Silver");//TODO -> from gameTexts
			BufferedReader br_paid = new BufferedReader(new InputStreamReader(System.in));
			try {
				paid = br_paid.readLine();
			} catch (Exception e) {	
				//TODO
			}
			while(!(paid.equals("1")||paid.equals("2"))){
				System.out.print("Please, insert a correct value (1 or 2): ");//TODO -> from gameTexts
				BufferedReader br_paid_tries = new BufferedReader(new InputStreamReader(System.in));
				try {
					paid = br_paid_tries.readLine();
				} catch (Exception e) {	
					//TODO
				}
			}
			if(paid.equals("1")){
				resource = "Wood";
			}else{
				resource = "Silver";
			}
			
		}
		//TODO else if( ){} for any types

		return resource;
	}
	//TODO more and more methods required.
	
	public static Sea requestSeaForCreation(List<Sea> seas){
		
		Sea toReturnSea;
		
		System.out.println("Please, choose the sea to create trirreme: "); //TODO -> rescue text from data.gameTexts
		System.out.println("1 - "+seas.get(0).getName());
		System.out.println("2 - "+seas.get(1).getName());
		
		String chosenSea = "";
		
		BufferedReader br_sea = new BufferedReader(new InputStreamReader(System.in));
		try {
			chosenSea = br_sea.readLine();
		} catch (Exception e) {	
			//TODO
		}
		while(!(chosenSea.equals("1")||chosenSea.equals("2"))){
			System.out.print("Please, insert a correct value (1 or 2): ");//TODO -> from gameTexts
			BufferedReader br_sea_tries = new BufferedReader(new InputStreamReader(System.in));
			try {
				chosenSea = br_sea_tries.readLine();
			} catch (Exception e) {	
				//TODO
			}
		}
		if(chosenSea.equals("1")){
			toReturnSea = seas.get(0);
		}else{
			toReturnSea = seas.get(1);
		}
		
		return toReturnSea;
	}
}
