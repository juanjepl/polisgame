package ui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import game.CreatorAction;
import game.Game;
import game.Polis;
import game.Round;
import game.Territory;
import game.Turn;
import game.Player;
import game.Sea;
import game.AvailableActionsManager;
import game.Unit;
import game.Hoplite;
import game.Trirreme;



/** Text-mode user interface class */
public class TextModeUi implements IUserInterface{ //TODO rescue language texts from data.gameTexts

	public TextModeUi(){}
	
	/** Welcome message */
	public static void creditsMessage(){ //FIXME -> from gametexts
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("        XXXXXXXXXX             XXXX   XXX");
		System.out.println("         XXX   XXXXX            XXX");
		System.out.println("         XXX   XXXXX  XXXXXXX   XXX  XXXX   XXXXXXX");
		System.out.println("         XXXXXXXXXX  XXX   XXX  XXX   XXX  XXX");
		System.out.println("         XXX         XXX   XXX  XXX   XXX   XXXXXX");
		System.out.println("         XXX         XXX   XXX  XXX   XXX       XXX");
		System.out.println("        XXXXX         XXXXXXX  XXXXX XXXXX XXXXXXX");
		System.out.println("");
		System.out.println("**************************************************************");
		System.out.println("*                                                            *");
		System.out.println("*  Developer Team:    Samuel Navas Portillo                  *");
		System.out.println("*                     Juan Jesús Pérez Luna                  *");
		System.out.println("*                     Ángel Martínez Olivares                *");
		System.out.println("*                     María José Sancha Maya                 *");
		System.out.println("*                     José Antonio Jiménez Carmona           *");
		System.out.println("*                     Manuel de los Santos Campos            *");
		System.out.println("*                                                            *");
		System.out.println("**************************************************************");
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
		String message = "Turn: "+Turn.getTurnCount()+" "+"Player: "+game.getWhoHasTheTurn().getName();	//FIXME from gametexts...
		System.out.println(message);
	}
	
	/** This method shows a change-of-round advice */
	public static void showNewRound(Game game){
		String message = "New Round: "+game.getRound().getName(); //FIXME from gametexts...
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
		if(AvailableActionsManager.checkMilitaryAction(g,p)){
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
			showAvailableActions(g,p);
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
			showAvailableActions(g,p);
		}else if(chosenOption.equals("1")){
			requestCreateHoplite(p,g.getRound());
		}else if(chosenOption.equals("2")){
			requestCreateTrirreme(p,g.getRound());
		}else if(chosenOption.equals("3")){	
			requestCreateTradeBoat(p,g.getRound());
		}else if(chosenOption.equals("4")){	
			requestCreateProxenus(p);
		}else{
				//TODO -> possible exception
		}
	}
	
	/** This method shows the possibles military actions that a player can do */
	public static void showAvailableMilitaryActions(Game g,Player p){
		String unavailable = " -Not Available-";
		String backMessage = "Back";
		String moveHopliteMessage = "Move Hoplite";
		String moveTrirremeMessage = "Move Trirreme";
		String siegePolisMessage = "Siege Polis";
		String plunderTerritoryMessage = "Plunder Territory";
		
		List<String> grantedOptions = new ArrayList<String>();
		List<String> optionsToChooseText = new ArrayList<String>();
		List<String> availableOptions = new ArrayList<String>();
		
		// 1st
		optionsToChooseText.add(backMessage);
		availableOptions.add("0");
		grantedOptions.add("0");
		
		// 2nd
		if(AvailableActionsManager.checkMoveHopliteAnyAction(g,p)){
			optionsToChooseText.add(moveHopliteMessage);
			availableOptions.add("1");
		}else{
			optionsToChooseText.add(moveHopliteMessage + unavailable);
		}
		grantedOptions.add("1");
		
		// 3rd
		if(AvailableActionsManager.checkMoveTrirremeAnyAction(g,p)){
			optionsToChooseText.add(moveTrirremeMessage);
			availableOptions.add("2");
		}else{
			optionsToChooseText.add(moveTrirremeMessage + unavailable);
		}
		grantedOptions.add("2");
		
		// 4th
		if(AvailableActionsManager.checkSiegePolisAnyAction(g,p)){
			optionsToChooseText.add(siegePolisMessage);
			availableOptions.add("3");
		}else{
			optionsToChooseText.add(siegePolisMessage + unavailable);
		}
		grantedOptions.add("3");
		
		// 5th
		
		if(AvailableActionsManager.checkPlunderTerritoryAnyAction(g,p)){
			optionsToChooseText.add(plunderTerritoryMessage);
			availableOptions.add("4");
		}else{
			optionsToChooseText.add(plunderTerritoryMessage + unavailable);
		}
		grantedOptions.add("4");
		
		ShowPlayerChoices("Please choose military action: ",optionsToChooseText); //FIXME rescue this text from GameText 
		String chosenOption = RequestPlayerChoices(grantedOptions, availableOptions);
		
		if(chosenOption.equals("0")){
			showAvailableActions(g,p);
		}else if(chosenOption.equals("1")){
			requestMoveHoplite(g,p);
		}else if(chosenOption.equals("2")){
			requestMoveTrirreme();
		}else if(chosenOption.equals("3")){	
			requestSiegePolis();
		}else if(chosenOption.equals("4")){	
			requestPlunderTerritory();
		}else{
				//TODO -> possible exception
		}
	}
	
	/** This method shows the possibles politic actions that a player can do */
	public static void showAvailablePoliticActions(Game g, Player p){
		String unavailable = " -Not Available-";
		String backMessage = "Back";
		String startAProjectMessage = "Start a Project";
		String tradeMessage = "Trade";
		String moveProxenusMessage = "Move the Proxenus";
		String civilWarMessage = "Do a Civil War";
		
		List<String> grantedOptions = new ArrayList<String>();
		List<String> optionsToChooseText = new ArrayList<String>();
		List<String> availableOptions = new ArrayList<String>();
		
		// 1st
		optionsToChooseText.add(backMessage);
		availableOptions.add("0");
		grantedOptions.add("0");
		
		// 2nd
		if(AvailableActionsManager.checkStartProjectAnyAction(g,p)){
			optionsToChooseText.add(startAProjectMessage);
			availableOptions.add("1");
		}else{
			optionsToChooseText.add(startAProjectMessage + unavailable);
		}
		grantedOptions.add("1");
		
		// 3rd
		if(AvailableActionsManager.checkTradeAnyAction(g,p)){
			optionsToChooseText.add(tradeMessage);
			availableOptions.add("2");
		}else{
			optionsToChooseText.add(tradeMessage + unavailable);
		}
		grantedOptions.add("2");
		
		// 4th
		if(AvailableActionsManager.checkMoveProxenusAnyAction(g,p)){
			optionsToChooseText.add(moveProxenusMessage);
			availableOptions.add("3");
		}else{
			optionsToChooseText.add(moveProxenusMessage + unavailable);
		}
		grantedOptions.add("3");
		
		// 5th
		
		if(AvailableActionsManager.checkCivilWarAnyAction(g,p)){
			optionsToChooseText.add(civilWarMessage);
			availableOptions.add("4");
		}else{
			optionsToChooseText.add(civilWarMessage + unavailable);
		}
		grantedOptions.add("4");
		
		ShowPlayerChoices("Please choose politic action: ",optionsToChooseText); //FIXME rescue this text from GameText 
		String chosenOption = RequestPlayerChoices(grantedOptions, availableOptions);
		
		if(chosenOption.equals("0")){
			showAvailableActions(g,p);
		}else if(chosenOption.equals("1")){
			requestStartAProject();
		}else if(chosenOption.equals("2")){
			requestTrade();
		}else if(chosenOption.equals("3")){	
			requestMoveProxenus();
		}else if(chosenOption.equals("4")){	
			requestCivilWar();
		}else{
				//TODO -> possible exception
		}
	}
	
	public static void requestCreateHoplite(Player p,Round r){

		String message = ("Please, choose Territory's Polis to create the Hoplite: "); //FIXME rescue from gameTexts...
		
		List<Polis> creationPoints = new ArrayList<Polis>();
		
		List<String> grantedOptions = new ArrayList<String>();
		List<String> optionsToChooseText = new ArrayList<String>();
		List<String> availableOptions = new ArrayList<String>();
		
		String chosenOption = "";
		
		Integer count = 0;
		for(Polis po : p.getPlayerPolis()){
			if(AvailableActionsManager.checkCreateHopliteAction(p, po, r)){
				optionsToChooseText.add(po.getName());
				grantedOptions.add(count.toString()); // FIXME works?
				availableOptions.add(count.toString()); // same here.
				creationPoints.add(po);
				count += 1;
			}
		}
		
		ShowPlayerChoices(message,optionsToChooseText);
		chosenOption = RequestPlayerChoices(grantedOptions,availableOptions);
		
		CreatorAction ac1 = new CreatorAction();
		ac1.createHoplite(p, creationPoints.get(Integer.parseInt(chosenOption)), r);
		
	}
	
	public static void requestCreateTrirreme(Player p,Round r){
		String message = ("Please, choose Sea's Polis to create the Trirreme: "); //FIXME rescue from gameTexts...
		
		List<Polis> creationPoints = new ArrayList<Polis>();
		List<String> grantedOptions = new ArrayList<String>();
		List<String> optionsToChooseText = new ArrayList<String>();
		List<String> availableOptions = new ArrayList<String>();
		
		String chosenOption = "";
		
		Integer count = 0;
		for(Polis po : p.getPlayerPolis()){
			if(AvailableActionsManager.checkCreateTrirremeAction(p, po, r)){
				optionsToChooseText.add(po.getName());
				grantedOptions.add(count.toString()); // FIXME works?
				availableOptions.add(count.toString()); // same here.
				creationPoints.add(po);
				count += 1;
			}
		}
		
		ShowPlayerChoices(message,optionsToChooseText);
		chosenOption = RequestPlayerChoices(grantedOptions,availableOptions);
		
		CreatorAction ac1 = new CreatorAction();
		ac1.createTrirreme(p, creationPoints.get(Integer.parseInt(chosenOption)), r);

	}
	
	public static void requestCreateProxenus(Player p){
String message = ("Please, choose Polis to create the Proxenus: "); //FIXME rescue from gameTexts...
		
		List<Polis> creationPoints = new ArrayList<Polis>();
		List<String> grantedOptions = new ArrayList<String>();
		List<String> optionsToChooseText = new ArrayList<String>();
		List<String> availableOptions = new ArrayList<String>();
		
		String chosenOption = "";
		
		Integer count = 0;
		for(Polis po : p.getPlayerPolis()){
			if(AvailableActionsManager.checkCreateProxenusAction(p,po)){
				optionsToChooseText.add(po.getName());
				grantedOptions.add(count.toString());
				availableOptions.add(count.toString());
				creationPoints.add(po);
				count += 1;
			}
		}
		
		ShowPlayerChoices(message,optionsToChooseText);
		chosenOption = RequestPlayerChoices(grantedOptions,availableOptions);
		
		CreatorAction ac1 = new CreatorAction();
		ac1.createProxenus(p, creationPoints.get(Integer.parseInt(chosenOption)));
	}
	
	public static void requestCreateTradeBoat(Player p,Round r){
		//TODO
		
		String message = ("Please, choose Polis to create the TradeBoat: "); //FIXME rescue from gameTexts...
		
		List<Polis> creationPoints = new ArrayList<Polis>();
		List<String> grantedOptions = new ArrayList<String>();
		List<String> optionsToChooseText = new ArrayList<String>();
		List<String> availableOptions = new ArrayList<String>();
		
		String chosenOption = "";
		
		Integer count = 0;
		for(Polis po : p.getPlayerPolis()){
			if(AvailableActionsManager.checkCreateTradeBoatAction(p,po,r)){
				optionsToChooseText.add(po.getName());
				grantedOptions.add(count.toString());
				availableOptions.add(count.toString());
				creationPoints.add(po);
				count += 1;
			}
		}
		
		ShowPlayerChoices(message,optionsToChooseText);
		chosenOption = RequestPlayerChoices(grantedOptions,availableOptions);
		CreatorAction ac1 = new CreatorAction();
		ac1.createTradeBoat(p, creationPoints.get(Integer.parseInt(chosenOption)),r);
	}
	
	public static void requestMoveHoplite(Game g,Player p){
		
		String message = ("Please, choose Polis where you have hoplites and you can do moves: "); //FIXME rescue from gameTexts...
		
		List<Territory> startMovePoints = new ArrayList<Territory>();
		List<String> grantedOptions = new ArrayList<String>();
		List<String> optionsToChooseText = new ArrayList<String>();
		List<String> availableOptions = new ArrayList<String>();
		
		String chosenOption = "";
		
		Map<String,Integer> startTerritories = new HashMap<String,Integer>();
		
		for(Unit u: p.getPlayerUnits()){
			if(startTerritories.containsKey(u.getPosition().getName())){
				Integer mapValue = startTerritories.get(u.getPosition().getName());
				mapValue += 1;
				startTerritories.put((u.getPosition().getName()), mapValue); // can overwrite the value? //TODO -> test it
			}
			
			else if((u instanceof Hoplite) && (AvailableActionsManager.checkMoveHopliteActionFromX(g, p, (Territory)u.getPosition(), 1))){
				startTerritories.put(u.getPosition().getName(),1);
				startMovePoints.add((Territory)u.getPosition());
			}else{
				// Do nothing, next iteration.
			}
		}
		
		Integer count = 0;
		for(Territory terr: startMovePoints){
			optionsToChooseText.add(terr.getName()+" "+startTerritories.get(terr.getName()).toString()+"x");
			grantedOptions.add(count.toString());
			availableOptions.add(count.toString());
			count += 1;
		}
		
		ShowPlayerChoices(message,optionsToChooseText);
		chosenOption = RequestPlayerChoices(grantedOptions,availableOptions);

		// to choose destiny
		List<Territory> endMovePoints = new ArrayList<Territory>();
		List<String> optionsToChooseText2 = new ArrayList<String>();
		List<String> grantedOptions2 = new ArrayList<String>();
		List<String> availableOptions2 = new ArrayList<String>();

		String message2 = "Please, choose destination from hoplite(s): ";//FIXME rescue from gametexts...
		
		String chosenOption2 = "";
		
		Integer Count2 = 0;
		for(Territory terr : g.getGameTerritories().values()){
			if(AvailableActionsManager.checkMoveHopliteAction(p, g.getRound(), startMovePoints.get(Integer.parseInt(chosenOption)), terr, 1)){  //FIXME careful with the +1 is correct?
				endMovePoints.add(terr);
				optionsToChooseText2.add(terr.getName());
				grantedOptions2.add(Count2.toString());
				availableOptions2.add(Count2.toString());
				Count2++;
			}
		}
		
		ShowPlayerChoices(message2,optionsToChooseText2);
		chosenOption2 = RequestPlayerChoices(grantedOptions2,availableOptions2);
		
		//to request number of units to move

		String message3 = "Please, choose number of Hoplites to move: "; //FIXME rescue from gametexts...
		String chosenOption3 = "";
		
		List<String> optionsToChooseText3 = new ArrayList<String>();
		List<String> grantedOptions3 = new ArrayList<String>();
		List<String> availableOptions3 = new ArrayList<String>();
		
		Integer Count3 = 0;
		for(Integer i=1 ; i<g.getRound().getMaximumPositionSlotsForThisRound() ; i++){
			if(AvailableActionsManager.checkMoveHopliteAction(p, g.getRound(),startMovePoints.get(Integer.parseInt(chosenOption)), endMovePoints.get(Integer.parseInt(chosenOption2)+1), i)){
				optionsToChooseText3.add(i.toString()+" Hoplite(s)"); //FIXME from gametexts...
				grantedOptions3.add(Count3.toString());
				availableOptions3.add(Count3.toString());
				Count3++;
			}
		}
		
		ShowPlayerChoices(message3,optionsToChooseText3);
		chosenOption3 = RequestPlayerChoices(grantedOptions3,availableOptions3);	

		
		//TODO number of units, destiny and multimovement.
		//TODO
		//TODO
		//TODO
	}
	
	public static void requestMoveTrirreme(){
		//TODO
	}
	
	public static void requestSiegePolis(){
		//TODO
	}
	
	public static Map<String,Integer> requestPlunderTerritory(){
		//return map with String resource and Integer numHoplites to paid
		Map<String, Integer> a = new HashMap<String, Integer>();
		//TODO
		return a;
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
		
		System.out.println(" ");
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
		
		System.out.println(" ");
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
		System.out.println(" ");
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
		
		System.out.println(" ");
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
	
	/** This method take the higher value from n roll dice  */
	public static Integer showRollTheDice(Integer numRolls){
		Integer diceValue = 0;
		//TODO
		
		for(int i = 0; i < numRolls; i++){
			System.out.println(" ");
			System.out.print("Please, roll the dice (writte anything)"); //FIXME rescue text from gametexts
			
			new BufferedReader(new InputStreamReader(System.in));
			
			Integer thisRoll = Player.rollTheDice();
			System.out.println("Result: "+thisRoll); //FIXME rescue text from gametexts
			if(thisRoll > diceValue){
				diceValue = thisRoll;
			}	
		}
		if(numRolls > 1){
			System.out.println("Maximum dice roll value: "+diceValue); //FIXME rescue text from gametexts
		}
		return diceValue;
	}
	public static void showMessage(String s){
		System.out.println(" ");
		System.out.println(s);
	}

	public static void requestSiegeRepopulation(){
		//TODO
	}
	
	public static void requestFeeding(){
		//TODO
	}
	
	public static String requestLoosePolis(){
		//TODO
		String a = "";
		return a;
	}
	
	public static void requestGrowth(){
		//TODO
	}
	
	public static void requestPhoros(){
		//TODO
	}
	
	public static void requestBattle(){
		//TODO
	}
	
}
