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
	public static void creditsMessage(){ //FIXME -> from gametexts
		
		System.out.println("****************************************************************");
		System.out.println("*                                                              *");
		System.out.println("*           P O L I S  :          T H E    G A M E             *");
		System.out.println("*                                                              *");
		System.out.println("****************************************************************");
		System.out.println("*                                                              *");
		System.out.println("*  Status: Pre-Alpha  non-functional                           *");
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
		String message = "New Round: "+game.getRound().getName(); //TODO from gametexts...
		System.out.println(message);
	}
	
	/** This method shows the possibles actions that a player can do */
	public static void showAvailableActions(Game g, Player p){//TODO the type of previous action...(condition)
		
		String optionsMessage = "Options";
		String creatorActionMessage = "Creator Action";
		String militaryActionMessage = "Military Action";
		String politicActionMessage = "Politic Action";
		String passTurnMessage = "Pass Turn";
		String unavailable = " -Not Available-";
		
		List<String> grantedOptions = new ArrayList<String>();
		List<String> optionsToChooseText = new ArrayList<String>();
		List<String> availableOptions = new ArrayList<String>();
		
		//1st
		optionsToChooseText.add(optionsMessage);
		availableOptions.add("0");
		grantedOptions.add("0");
	
		//2nd
		if(AvailableActionsManager.checkCreatorAction(g,p)){
			optionsToChooseText.add(creatorActionMessage);
			availableOptions.add("1");
		}else{
			optionsToChooseText.add(creatorActionMessage + unavailable);
		}
		grantedOptions.add("1");
	
		//3rd
		if(false/*AvailableActionsManager.checkMilitaryAction(g,p)*/){ //FIXME not call this method for the moment.
			optionsToChooseText.add(militaryActionMessage);
			availableOptions.add("2");
		}else{
			optionsToChooseText.add(militaryActionMessage + unavailable);
		}
		grantedOptions.add("2");
	
		//4th
		if(AvailableActionsManager.checkPoliticAction(g,p)){
			optionsToChooseText.add(politicActionMessage);
			availableOptions.add("3");
		}else{
			optionsToChooseText.add(politicActionMessage + unavailable);
		}
		grantedOptions.add("3");
		
		//5th
		optionsToChooseText.add(passTurnMessage);
		availableOptions.add("4");
		grantedOptions.add("4");
	
		ShowPlayerChoices("Please choose action to execute: ",optionsToChooseText); //FIXME rescue this text from GameText 
		String chosenOption = RequestPlayerChoices(grantedOptions, availableOptions);

		if(chosenOption.equals("0")){
			showAvailableOptions(g,p);
		}else if(chosenOption.equals("1")){
			showAvailableCreatorActions(g,p);
		}else if(chosenOption.equals("2")){
			showAvailableMilitaryActions(g,p);
		}else if(chosenOption.equals("3")){
			showAvailablePoliticActions(g,p);
		}else if(chosenOption.equals("4")){
			p.setHasPassedTurn(true);
		}else{
				//TODO -> possible exception
		}
	}

	/** This method shows possibles game options that player can do */
	public static void showAvailableOptions(Game g,Player p){
		String optionBack = "Back";
		String optionChangeNicknameMessage = "Change the Nickname";
		
		List<String> grantedOptions = new ArrayList<String>();
		List<String> optionsToChooseText = new ArrayList<String>();
		List<String> availableOptions = new ArrayList<String>();
		
		// 1st
		optionsToChooseText.add(optionBack);
		availableOptions.add("0");
		grantedOptions.add("0");
		
		// 2st
		optionsToChooseText.add(optionChangeNicknameMessage);
		availableOptions.add("1");
		grantedOptions.add("1");
		
		ShowPlayerChoices("Please choose option: ",optionsToChooseText); //FIXME rescue this text from GameText 
		String chosenOption = RequestPlayerChoices(grantedOptions, availableOptions);
		
		if(chosenOption.equals("0")){
			showAvailableActions(g,p); //TODO not very efficient...
		}else if(chosenOption.equals("1")){
			renameAPlayer(g,p);
		
		}else{
				//TODO -> possible exception
		}
	}
	
	/** This method shows the possibles creator actions that a player can do */
	public static void showAvailableCreatorActions(Game g,Player p){
		String unavailable = " -Not Available-";
		String backMessage = "Back";
		String createHopliteMessage = "Create Hoplite";
		String createTrirremeMessage = "Create Trirreme";
		String createTradeBoatMessage = "Create Trade Boat";
		String createProxenusMessage = "Create Proxenus";
		
		List<String> grantedOptions = new ArrayList<String>();
		List<String> optionsToChooseText = new ArrayList<String>();
		List<String> availableOptions = new ArrayList<String>();
		
		// 1st
		optionsToChooseText.add(backMessage);
		availableOptions.add("0");
		grantedOptions.add("0");
		
		// 2nd
		if(AvailableActionsManager.checkCreateHopliteAnyAction(g,p)){
			optionsToChooseText.add(createHopliteMessage);
			availableOptions.add("1");
		}else{
			optionsToChooseText.add(createHopliteMessage + unavailable);
		}
		grantedOptions.add("1");
		
		// 3rd
		if(AvailableActionsManager.checkCreateTrirremeAnyAction(g,p)){
			optionsToChooseText.add(createTrirremeMessage);
			availableOptions.add("2");
		}else{
			optionsToChooseText.add(createTrirremeMessage + unavailable);
		}
		grantedOptions.add("2");
		
		// 4th
		if(AvailableActionsManager.checkCreateTradeBoatAnyAction(g,p)){
			optionsToChooseText.add(createTradeBoatMessage);
			availableOptions.add("3");
		}else{
			optionsToChooseText.add(createTradeBoatMessage + unavailable);
		}
		grantedOptions.add("3");
		
		// 5th
		
		if(AvailableActionsManager.checkCreateProxenusAnyAction(g,p)){
			optionsToChooseText.add(createProxenusMessage);
			availableOptions.add("4");
		}else{
			optionsToChooseText.add(createProxenusMessage + unavailable);
		}
		grantedOptions.add("4");
		
		ShowPlayerChoices("Please choose creator action: ",optionsToChooseText); //FIXME rescue this text from GameText 
		String chosenOption = RequestPlayerChoices(grantedOptions, availableOptions);
		
		if(chosenOption.equals("0")){
			showAvailableActions(g,p); //TODO not very efficient...
		}else if(chosenOption.equals("1")){
			requestCreateHoplite();
		}else if(chosenOption.equals("2")){
			requestCreateTrirreme();
		}else if(chosenOption.equals("3")){	
			requestCreateTradeBoat();
		}else if(chosenOption.equals("4")){	
			requestCreateProxenus();
		}else{
				//TODO -> possible exception
		}
	}
	
	/** This method shows the possibles military actions that a player can do */
	public static void showAvailableMilitaryActions(Game g,Player p){
		/*
		String moveHopliteMessage = "1 - Move Hoplite";
		String moveTrirremeMessage = "2 - Move Trirreme";
		String siegePolisMessage = "3 - Siege Polis";
		String plunderTerritoryMessage = "4 - Plunder Territory";
		 */
		//TODO
	}
	
	/** This method shows the possibles politic actions that a player can do */
	public static void showAvailablePoliticActions(Game g, Player p){
		/*
		String startAProjectMessage = "1 - Start a Project";
		String tradeMessage = "2 - Trade";
		String moveProxenusMessage = "3 - Move the Proxenus";
		String civilWarMessage = "4 - Do a Civil War";
		*/
		//TODO
	}
	
	public static void requestCreateHoplite(){
		//TODO
	}
	
	public static void requestCreateTrirreme(){
		//TODO
	}
	
	public static void requestCreateProxenus(){
		//TODO
	}
	
	public static void requestCreateTradeBoat(){
		//TODO
	}
	
	public static void requestMoveHoplite(){
		//TODO
	}
	
	public static void requestMoveTrirreme(){
		//TODO
	}
	
	public static void requestSiegePolis(){
		//TODO
	}
	
	public static void requestPlunderTerritory(){
		//TODO
	}
	
	public static void requestStartAProject(){
		//TODO
	}
	
	public static void requestTrade(){
		//TODO
	}
	
	public static void requestMoveProxenus(){
		//TODO
	}
	
	public static void requestCivilWar(){
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

	/** This method request player's choice for creation sea for trirremes */
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
	
	/** This method shows a message and options to choose for the player */
	public static void ShowPlayerChoices(String messageOfTheRequest,List<String> optionsToChoose){
		System.out.println(messageOfTheRequest);
		for(String s: optionsToChoose){
			System.out.println(optionsToChoose.indexOf(s)+" - "+s);
		}
	}
	
	/** This method requests an election from the player */
	public static String RequestPlayerChoices(List<String> grantedValues, List<String> availableValues){
		String chosenOption = "";
		Boolean correctChoose = false;

		while(!correctChoose){
			BufferedReader br_choose = new BufferedReader(new InputStreamReader(System.in));
			try {
				chosenOption = br_choose.readLine();
			} catch (Exception e) {	
				//TODO
			}
			if(grantedValues.contains(chosenOption)){
				if(availableValues.contains(chosenOption)){
					break; // out of loop and returns player's choice
				}else{ // when is a correct value, but isn't available
					System.out.print("Choice not available, please, choose another one:"); //FIXME rescue this text from gametexts
				}	
			}else{
				System.out.print("Please, insert a correct value: "); //FIXME rescue this text from gametexts
			}

		}
		return chosenOption;
	}

	/** This method request a new name for a player */
	public static void renameAPlayer(Game g, Player p){
		String newName = "";
		Boolean grantedName = false;
		//TODO
		
		System.out.print("Type new nickname: ");

		while(!grantedName){
			BufferedReader br_new_name = new BufferedReader(new InputStreamReader(System.in)); // request athens's player's name
			try {
				newName = br_new_name.readLine();
			} catch (Exception e) {	
				//TODO
			}
			
			if(p.equals(g.getAthensPlayer())){
				if(!(newName.equals(g.getSpartaPlayer().getName()))){
					g.getAthensPlayer().setName(newName);
					break;
				}
			}else{
				if(!(newName.equals(g.getAthensPlayer().getName()))){
					g.getSpartaPlayer().setName(newName);
					break;
				}
			}
			System.out.print("Name in use, please choose another one: "); //FIXME from gametexts...
		}	
	}
}
