package game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import ui.TextModeUi;
import utils.IPolisFilesReader;
import utils.PolReader;

public class ElementsInitializer {

	public ElementsInitializer(){}
	
	public static Game InitializeGameElements(){ // TODO must be SERIOUSLY MODULARIZED using external files

			
//// TERRITORIES

	//// Markets creation	
		
		Market iliria = new Market("Iliria","Iliria") ;
		Market tracia = new Market("Tracia","Tracia") ;
		Market euxinosPontos = new Market("EuxinosPontos","EuxinosPontos") ;
		Market imperioPersa = new Market("ImperioPersa","ImperioPersa") ;
		Market egipto = new Market("Egipto","Egipto") ;
		
//// POLIS CREATION
	// epidamnos	
		List<Project> possibleProjectsAtEpidamnos = new ArrayList<Project>();
		possibleProjectsAtEpidamnos.add(venusStatue);
		possibleProjectsAtEpidamnos.add(efeboStatue);
		
		List<Sea> startSeasAtEpidamnos = new ArrayList<Sea>();
		startSeasAtEpidamnos.add(jonicoSea);
		
		Polis epidamnos = new Polis("Epidamnos","Epidamnos",1,1,3,null,possibleProjectsAtEpidamnos,startSeasAtEpidamnos); // be careful with the null (no parent territory)
		
	// gela	
		List<Project> possibleProjectsAtGela = new ArrayList<Project>();
		possibleProjectsAtGela.add(venusStatue);
		possibleProjectsAtGela.add(efeboStatue);
		
		List<Sea> startSeasAtGela = new ArrayList<Sea>();
		startSeasAtGela.add(jonicoSea);
		
		Polis gela = new Polis("Gela","Gela",3,1,5,sicilia,possibleProjectsAtGela,startSeasAtGela);
		
	// siracusa
		List<Project> possibleProjectsAtSiracusa = new ArrayList<Project>();
		possibleProjectsAtSiracusa.add(zeusTemple);
		possibleProjectsAtSiracusa.add(apoloTemple);
		possibleProjectsAtSiracusa.add(socrates);
		possibleProjectsAtSiracusa.add(democrito);
		possibleProjectsAtSiracusa.add(protagoras);
		
		List<Sea> startSeasAtSiracusa = new ArrayList<Sea>();
		startSeasAtSiracusa.add(jonicoSea);
		
		Polis siracusa = new Polis("Siracusa","Siracusa",4,2,7,sicilia,possibleProjectsAtSiracusa,startSeasAtSiracusa);
		
	// corcira
		List<Project> possibleProjectsAtCorcira = new ArrayList<Project>();// Has no projects for the moment
		
		List<Sea> startSeasAtCorcira = new ArrayList<Sea>();
		startSeasAtCorcira.add(jonicoSea);
		
		Polis corcira = new Polis("Corcira","Corcira",2,1,3,acarnania,possibleProjectsAtCorcira,startSeasAtCorcira);
		
	// naupacto
		List<Project> possibleProjectsAtNaupacto = new ArrayList<Project>(); // Has no projects for the moment
		
		List<Sea> startSeasAtNaupacto = new ArrayList<Sea>();
		startSeasAtNaupacto.add(jonicoSea);
		
		Polis naupacto = new Polis("Naupacto","Naupacto",1,1,2,tesalia,possibleProjectsAtNaupacto,startSeasAtNaupacto);
		
	// pidna
		List<Project> possibleProjectsAtPidna = new ArrayList<Project>();
		possibleProjectsAtPidna.add(nemeosGames);
		possibleProjectsAtPidna.add(istmicosGames);
		
		List<Sea> startSeasAtPidna = new ArrayList<Sea>();
		startSeasAtPidna.add(traciaSea);
		
		Polis pidna = new Polis("Pidna","Pidna",2,1,3,macedonia,possibleProjectsAtPidna,startSeasAtPidna);
		
	// pilos
		List<Project> possibleProjectsAtPilos = new ArrayList<Project>(); // Has no projects for the moment
		
		List<Sea> startSeasAtPilos = new ArrayList<Sea>();
		startSeasAtPilos.add(jonicoSea);
		
		Polis pilos = new Polis("Pilos","Pilos",2,1,3,mesenia,possibleProjectsAtPilos,startSeasAtPilos);
		
	// esparta
		List<Project> possibleProjectsAtEsparta = new ArrayList<Project>();
		possibleProjectsAtEsparta.add(demeterFestival);
		possibleProjectsAtEsparta.add(dionisoFestival);
		possibleProjectsAtEsparta.add(venusStatue);
		possibleProjectsAtEsparta.add(efeboStatue);
		possibleProjectsAtEsparta.add(zeusTemple);
		possibleProjectsAtEsparta.add(apoloTemple);
		
		List<Sea> startSeasAtEsparta = new ArrayList<Sea>(); // Has no sea for the moment
		
		Polis esparta = new Polis("Esparta","Esparta",4,3,8,laconia,possibleProjectsAtEsparta,startSeasAtEsparta);
		
	// gition
		List<Project> possibleProjectsAtGition = new ArrayList<Project>(); // Has no projects for the moment
		
		List<Sea> startSeasAtGition = new ArrayList<Sea>();
		startSeasAtGition.add(mirtosSea);

		Polis gition = new Polis("Gition","Gition",1,1,2,laconia,possibleProjectsAtGition,startSeasAtGition);
		
	// argos	
		List<Project> possibleProjectsAtArgos = new ArrayList<Project>();
		possibleProjectsAtArgos.add(nemeosGames);
		possibleProjectsAtArgos.add(istmicosGames);
		
		List<Sea> startSeasAtArgos = new ArrayList<Sea>();
		startSeasAtArgos.add(mirtosSea);
		
		Polis argos = new Polis("Argos","Argos",3,1,5,arcadia,possibleProjectsAtArgos,startSeasAtArgos);
		
	// corinto
		List<Project> possibleProjectsAtCorinto = new ArrayList<Project>();
		possibleProjectsAtCorinto.add(nemeosGames);
		possibleProjectsAtCorinto.add(istmicosGames);
		possibleProjectsAtCorinto.add(theatreWithEpseknion);
		possibleProjectsAtCorinto.add(normalTheatre);
		
		List<Sea> startSeasAtCorinto = new ArrayList<Sea>();
		startSeasAtCorinto.add(jonicoSea);
		startSeasAtCorinto.add(cicladasSea);
		
		Polis corinto = new Polis("Corinto","Corinto",4,2,6,megaris,possibleProjectsAtCorinto,startSeasAtCorinto);
		
	// tebas
		List<Project> possibleProjectsAtTebas = new ArrayList<Project>();
		possibleProjectsAtTebas.add(theatreWithEpseknion);
		possibleProjectsAtTebas.add(normalTheatre);
		
		List<Sea> startSeasAtTebas = new ArrayList<Sea>(); // Has no sea for the moment
		
		Polis tebas = new Polis("Tebas","Tebas",3,1,5,beocia,possibleProjectsAtTebas,startSeasAtTebas);
		
	// potidea
		List<Project> possibleProjectsAtPotidea = new ArrayList<Project>();
		possibleProjectsAtPotidea.add(demeterFestival);
		possibleProjectsAtPotidea.add(dionisoFestival);
		
		List<Sea> startSeasAtPotidea = new ArrayList<Sea>();
		startSeasAtPotidea.add(traciaSea);
		
		Polis potidea = new Polis("Potidea","Potidea",2,1,3,macedonia,possibleProjectsAtPotidea,startSeasAtPotidea);
		
	// calcis
		List<Project> possibleProjectsAtCalcis = new ArrayList<Project>(); // Has no projects for the moment
		
		List<Sea> startSeasAtCalcis = new ArrayList<Sea>();
		startSeasAtCalcis.add(cicladasSea);
		
		Polis calcis = new Polis("Calcis","Calcis",1,1,2,atica,possibleProjectsAtCalcis,startSeasAtCalcis);
		
	// atenas
		List<Project> possibleProjectsAtAtenas = new ArrayList<Project>();
		possibleProjectsAtAtenas.add(theatreWithEpseknion);
		possibleProjectsAtAtenas.add(normalTheatre);
		possibleProjectsAtAtenas.add(fidias);
		possibleProjectsAtAtenas.add(socrates);
		possibleProjectsAtAtenas.add(democrito);
		possibleProjectsAtAtenas.add(protagoras);
	
		List<Sea> startSeasAtAtenas = new ArrayList<Sea>();
		startSeasAtAtenas.add(cicladasSea);
		
		Polis atenas = new Polis("Atenas","Atenas",5,3,10,atica,possibleProjectsAtAtenas,startSeasAtAtenas);
		
	// quios
		List<Project> possibleProjectsAtQuios = new ArrayList<Project>(); // Has no projects for the moment
		
		List<Sea> startSeasAtQuios = new ArrayList<Sea>();
		startSeasAtQuios.add(esporadasSea);
		
		Polis quios = new Polis("Quios","Quios",2,1,3,jonia,possibleProjectsAtQuios,startSeasAtQuios);
		
	// samos
		List<Project> possibleProjectsAtSamos = new ArrayList<Project>();
		possibleProjectsAtSamos.add(demeterFestival);
		possibleProjectsAtSamos.add(dionisoFestival);
		
		List<Sea> startSeasAtSamos = new ArrayList<Sea>();
		startSeasAtSamos.add(esporadasSea);
		
		Polis samos = new Polis("Samos","Samos",3,2,6,jonia,possibleProjectsAtSamos,startSeasAtSamos);
		
	// abdera
		List<Project> possibleProjectsAtAbdera = new ArrayList<Project>();
		possibleProjectsAtAbdera.add(venusStatue);
		possibleProjectsAtAbdera.add(efeboStatue);
		
		List<Sea> startSeasAtAbdera = new ArrayList<Sea>();
		startSeasAtAbdera.add(traciaSea);
		
		Polis abdera = new Polis("Abdera","Abdera",1,1,3,null,possibleProjectsAtAbdera,startSeasAtAbdera); // be careful with the null (no parent territory)
		
		
		
		
		
//////// ALL POSITIONS (some maps)
		
		
		IPolisFilesReader polisFilesReader = new PolReader(); ////////// <--------------------------------------------------------------------------- FILES READER HERE!!!!!!!!!!!!!!
		
		
//// TERRITORIES		
		Map<String,Territory> territoriesMap = polisFilesReader.readTerritories();
		
//// SEAS		
		Map<String,Sea> seasMap = polisFilesReader.readSeas(); // new-using-external-files-call
		
		
//// TRADE DOCKS		
		Map<String,TradeDock> tradeDocksMap = polisFilesReader.readTradeDocks();
		
		
//// MARKETS		
		Map<String,Market> marketsMap = new HashMap<String,Market>();
		marketsMap.put("Iliria",iliria);
		marketsMap.put("Tracia",tracia);
		marketsMap.put("EuxinosPontos",euxinosPontos);
		marketsMap.put("ImperioPersa",imperioPersa);
		marketsMap.put("Egipto",egipto);
		

		
		
//// PROJECTS
		List<Project> gameProjects = polisFilesReader.readProjects();
		
//// GAME EVENTS
		List<List<GameEvent>> gameEventsList = polisFilesReader.readGameEvents();
		
//// ROUND
		Round theRound = new Round();
		
//// MARKET CHART
		MarketChart theMarketChart = new MarketChart();
		
//// POLIS (must be the last of positions to initialize)
		Map<String,Polis> polisMap = new HashMap<String,Polis>();
		polisMap.put("Epidamnos",epidamnos);
		polisMap.put("Gela",gela);
		polisMap.put("Siracusa",siracusa);
		polisMap.put("Corcira",corcira);
		polisMap.put("Naupacto",naupacto);
		polisMap.put("Pidna",pidna);
		polisMap.put("Pilos",pilos);
		polisMap.put("Esparta",esparta);
		polisMap.put("Gition",gition);
		polisMap.put("Argos",argos);
		polisMap.put("Corinto",corinto);
		polisMap.put("Tebas",tebas);
		polisMap.put("Potidea",potidea);
		polisMap.put("Calcis",calcis);
		polisMap.put("Atenas",atenas);
		polisMap.put("Quios",quios);
		polisMap.put("Samos",samos);
		polisMap.put("Abdera",abdera);		
		
//// PLAYERS
		TextModeUi userInterface = new TextModeUi(); // Creates a user interface object -> in the future, choose graphical/text mode in cfg. 
		List<String> players = 	userInterface.requestPlayerNames();
		
		Player sparta = new Player(players.get(0));
		Player athens = new Player(players.get(1));
		
//// FINALLY, CREATE THE GAME:
		
		Game polisGame = new Game(sparta,athens,territoriesMap,seasMap,tradeDocksMap,marketsMap,polisMap,gameProjects,gameEventsList,theRound,theMarketChart);
		return polisGame;
	}
}
