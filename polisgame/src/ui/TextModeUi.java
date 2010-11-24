package ui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;

import game.Game;
import game.Turn;
import game.Player;
import game.Sea;
import game.AvailableActionsManager;

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
	public static void showAvailableActions(Game g, Player p){
    
		String optionsMessage = "0 - Options";
		String creatorActionMessage = "1 - Creator Action";
		String militaryActionMessage = "2 - Military Action";
		String politicActionMessage = "3 - Politic Action";
		String passTurnMessage = "4 - Pass Turn";
		String unavailable = " -Not Available-";

		List<String> unavailableOptions = new ArrayList<String>();
		
		System.out.println("Please choose action to execute: "); //FIXME rescue this text from GameText 
		
		if(!(p.getHasPassedTurn())){ //FIXME necessary?
		
			// Display options to choose.
			System.out.println(optionsMessage);
			if(AvailableActionsManager.checkCreatorAction(g,p)){
				System.out.println(creatorActionMessage);
			}else{
				System.out.println(creatorActionMessage + unavailable);
				unavailableOptions.add("1");
			}
		
			if(AvailableActionsManager.checkMilitaryAction(g,p)){
				System.out.println(militaryActionMessage);
			}else{
				System.out.println(militaryActionMessage + unavailable);
				unavailableOptions.add("2");
			}

			if(AvailableActionsManager.checkPoliticAction(g,p)){
				System.out.println(politicActionMessage);
			}else{
				System.out.println(politicActionMessage + unavailable);
				unavailableOptions.add("3");
			}
		
			System.out.println(passTurnMessage);
			
			// chosen option
			String chosenOption = "";
			
			BufferedReader br_choose = new BufferedReader(new InputStreamReader(System.in));
			try {
				chosenOption = br_choose.readLine();
			} catch (Exception e) {	
				//TODO
			}
			while((unavailableOptions.contains(chosenOption))||(!(chosenOption.equals("0") || chosenOption.equals("1") || chosenOption.equals("2") || chosenOption.equals("3") || chosenOption.equals("4")))){
				if(unavailableOptions.contains(chosenOption)){
					System.out.println("Action not available, please, choose another one:");
				}else{
					System.out.print("Please, insert a correct value: ");//TODO -> from gameTexts
				}
				
				BufferedReader br_choose_tries = new BufferedReader(new InputStreamReader(System.in));
				try {
					chosenOption = br_choose_tries.readLine();
				} catch (Exception e) {	
					//TODO
				}
			}

			if(chosenOption.equals("0")){
				showAvailableOptions();
			}else if(chosenOption.equals("1")){
				showAvailableCreatorActions(g,p);
			}else if(chosenOption.equals("2")){
				showAvailableMilitaryActions(g,p);
			}else if(chosenOption.equals("3")){
				showAvailablePoliticActions(g,p);
			}else if(chosenOption.equals("4")){
				p.setHasPassedTurn(true);
			}else{
				// Game wouldn't never take this case.
			}

		}else{
			// Do nothing
		}

		//TODO -> from "system" strings rescued, use gametexts "names"
		
		/*
		
		String optionChangeNicknameMessage = "1 - Change the Nickname";
		String optionSaveGameMessage = "2 - Save Game";
		String optionLoadGameMessage = "3 - Load Game";		
		
		String moveHopliteMessage = "1 - Move Hoplite";
		String moveTrirremeMessage = "2 - Move Trirreme";
		String siegePolisMessage = "3 - Siege Polis";
		String plunderTerritoryMessage = "4 - Plunder Territory";
		
		String startAProjectMessage = "1 - Start a Project";
		String tradeMessage = "2 - Trade";
		String moveProxenusMessage = "3 - Move the Proxenus";
		String civilWarMessage = "4 - Do a Civil War";
		*/
		

	}

	public static void showAvailableOptions(){
		//TODO
	}
	
	public static void showAvailableCreatorActions(Game g,Player p){
		/*String unavailable = " -Not Available-";
		String backMessage = "0 - Back";
		String createHopliteMessage = "1 - Create Hoplite";
		String createTrirremeMessage = "2 - Create Trirreme";
		String createTradeBoatMessage = "3 - Create Trade Boat";
		String createProxenusMessage = "4 - Create Proxenus";
		
		List<String> unavailableOptions = new ArrayList<String>();
		
		// Display options to choose.
		System.out.println(backMessage);

		//TODO
		
		// chosen option
		String chosenOption = "";
		
		
		
		
		System.out.println("Please choose creator action to execute: "); //FIXME rescue this text from GameText 

		
		
		
		//TODO
		 
		 */
	}
	public static void showAvailableMilitaryActions(Game g,Player p){
		//TODO
	}
	public static void showAvailablePoliticActions(Game g, Player p){
		//TODO
	}
	
	/** This method request player's choice for paying something */
	public static String requestPaidMethod(String paidReference){ // -> Paid reference: hoplite,trirreme, etc.
		String paid = "";
		String resource = "";
		
		System.out.println("Please, choose the paid method: "); //TODO -> rescue text from data.gameTexts
		
		// For pay an hoplite
		if(paidReference.equals("hoplite")){
			System.out.println("1 - Metal"); //TODO -> from gameTexts
			System.out.println("2 - Silver");//TODO -> from gameTexts
			
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
