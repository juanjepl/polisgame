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
		
		// LACONIA
		Vector<Integer> metalAtLaconia = new Vector<Integer>();
		metalAtLaconia.add(1);
		metalAtLaconia.add(3);
		metalAtLaconia.add(6);
		metalAtLaconia.add(10);
		Vector<Integer> oilAtLaconia = new Vector<Integer>();
		oilAtLaconia.add(1);
		oilAtLaconia.add(3);
		oilAtLaconia.add(6);
		Vector<Integer> silverAtLaconia = new Vector<Integer>();
		silverAtLaconia.add(1);
		silverAtLaconia.add(3);
		
		Map<String,Vector<Integer>> laconiaResources = new HashMap<String,Vector<Integer>>();
		laconiaResources.put("Metal", metalAtLaconia);
		laconiaResources.put("Oil", oilAtLaconia);
		
		
		// MESENIA
		Vector<Integer> oilAtMesenia = new Vector<Integer>();
		oilAtMesenia.add(1);
		oilAtMesenia.add(3);
		oilAtMesenia.add(6);
		oilAtMesenia.add(10);
		Vector<Integer> wheatAtMesenia = new Vector<Integer>();
		wheatAtMesenia.add(1);
		wheatAtMesenia.add(3);
		wheatAtMesenia.add(6);
		
		Map<String,Vector<Integer>> meseniaResources = new HashMap<String,Vector<Integer>>();
		meseniaResources.put("Oil", oilAtMesenia);
		meseniaResources.put("Wheat", wheatAtMesenia);
		
		
		//SICILIA
		Vector<Integer> wineAtSicilia = new Vector<Integer>();
		wineAtSicilia.add(1);
		wineAtSicilia.add(3);
		wineAtSicilia.add(6);
		wineAtSicilia.add(10);
		wineAtSicilia.add(15);
		Vector<Integer> oilAtSicilia = new Vector<Integer>();
		oilAtSicilia.add(1);
		oilAtSicilia.add(3);
		oilAtSicilia.add(6);
		oilAtSicilia.add(10);
		oilAtSicilia.add(15);
		Vector<Integer> wheatAtSicilia = new Vector<Integer>();
		wheatAtSicilia.add(1);
		wheatAtSicilia.add(3);
		wheatAtSicilia.add(6);
		
		Map<String,Vector<Integer>> siciliaResources = new HashMap<String,Vector<Integer>>();
		siciliaResources.put("Wine", wineAtSicilia);
		siciliaResources.put("Oil", oilAtSicilia);
		siciliaResources.put("Wheat", wheatAtSicilia);
		
		
		//MEGARIS
		Vector<Integer> woodAtMegaris = new Vector<Integer>();
		woodAtMegaris.add(1);
		woodAtMegaris.add(3);
		woodAtMegaris.add(6);
		woodAtMegaris.add(10);
		woodAtMegaris.add(15);
		Vector<Integer> silverAtMegaris = new Vector<Integer>();
		silverAtMegaris.add(1);
		silverAtMegaris.add(3);
		silverAtMegaris.add(6);
		Vector<Integer> wheatAtMegaris = new Vector<Integer>();
		wheatAtMegaris.add(1);
		wheatAtMegaris.add(3);
		
		Map<String,Vector<Integer>> megarisResources = new HashMap<String,Vector<Integer>>();
		megarisResources.put("Wood", woodAtMegaris);
		megarisResources.put("Silver", silverAtMegaris);
		megarisResources.put("Wheat", wheatAtMegaris);
		
		
		//ARCADIA
		Vector<Integer> metalAtArcadia = new Vector<Integer>();
		metalAtArcadia.add(1);
		metalAtArcadia.add(3);
		metalAtArcadia.add(6);
		metalAtArcadia.add(10);
		
		Vector<Integer> woodAtArcadia = new Vector<Integer>();
		woodAtArcadia.add(1);
		woodAtArcadia.add(3);
		woodAtArcadia.add(6);
		woodAtArcadia.add(10);
		
		Vector<Integer> wineAtArcadia = new Vector<Integer>();
		wineAtArcadia.add(1);
		wineAtArcadia.add(3);
		
		Vector<Integer> oilAtArcadia = new Vector<Integer>();
		oilAtArcadia.add(1);
		oilAtArcadia.add(3);
		
		Map<String,Vector<Integer>> arcadiaResources = new HashMap<String,Vector<Integer>>();
		megarisResources.put("Metal", metalAtArcadia);
		megarisResources.put("Wood", woodAtArcadia);
		megarisResources.put("Wine", wineAtArcadia);
		megarisResources.put("Oil", oilAtArcadia);
		
		
		//ACAYA
		Vector<Integer> metalAtAcaya = new Vector<Integer>();
		metalAtAcaya.add(1);
		metalAtAcaya.add(3);
		Vector<Integer> woodAtAcaya = new Vector<Integer>();
		woodAtAcaya.add(1);
		woodAtAcaya.add(3);
		Vector<Integer> wineAtAcaya = new Vector<Integer>();
		wineAtAcaya.add(1);
		Vector<Integer> oilAtAcaya = new Vector<Integer>();
		oilAtAcaya.add(1);
		
		Map<String,Vector<Integer>> acayaResources = new HashMap<String,Vector<Integer>>();
		acayaResources.put("Metal", metalAtAcaya);
		acayaResources.put("Wood", woodAtAcaya);
		acayaResources.put("Wine", wineAtAcaya);
		acayaResources.put("Oil", oilAtAcaya);
		
		
		//JONIA
		Vector<Integer> wineAtJonia = new Vector<Integer>();
		wineAtJonia.add(1);
		wineAtJonia.add(3);
		wineAtJonia.add(6);
		wineAtJonia.add(10);
		Vector<Integer> silverAtJonia = new Vector<Integer>();
		silverAtJonia.add(1);
		silverAtJonia.add(3);
		Vector<Integer> wheatAtJonia = new Vector<Integer>();
		wheatAtJonia.add(1);
		
		Map<String,Vector<Integer>> joniaResources = new HashMap<String,Vector<Integer>>();
		joniaResources.put("Wine", wineAtJonia);
		joniaResources.put("Silver", silverAtJonia);
		joniaResources.put("Wheat", wheatAtJonia);
		
		
		//ATICA
		Vector<Integer> wineAtAtica = new Vector<Integer>();
		wineAtAtica.add(1);
		wineAtAtica.add(3);
		wineAtAtica.add(6);
		wineAtAtica.add(10);
		Vector<Integer> oilAtAtica = new Vector<Integer>();
		oilAtAtica.add(1);
		oilAtAtica.add(3);
		oilAtAtica.add(6);
		oilAtAtica.add(10);
		Vector<Integer> silverAtAtica = new Vector<Integer>();
		silverAtAtica.add(1);
		silverAtAtica.add(3);
		silverAtAtica.add(6);
		Vector<Integer> wheatAtAtica = new Vector<Integer>();
		wheatAtAtica.add(1);
		
		Map<String,Vector<Integer>> aticaResources = new HashMap<String,Vector<Integer>>();
		aticaResources.put("Wine", wineAtAtica);
		aticaResources.put("Oil", oilAtAtica);
		aticaResources.put("Silver", silverAtAtica);
		aticaResources.put("Wheat", wheatAtAtica);
		
		//BEOCIA
		Vector<Integer> metalAtBeocia = new Vector<Integer>();
		metalAtBeocia.add(1);
		metalAtBeocia.add(3);
		metalAtBeocia.add(6);
		metalAtBeocia.add(10);
		metalAtBeocia.add(15);
		Vector<Integer> woodAtBeocia = new Vector<Integer>();
		woodAtBeocia.add(1);
		woodAtBeocia.add(3);
		woodAtBeocia.add(6);
		woodAtBeocia.add(10);
		Vector<Integer> oilAtBeocia = new Vector<Integer>();
		oilAtBeocia.add(1);
		oilAtBeocia.add(3);
		oilAtBeocia.add(6);
		Vector<Integer> wheatAtBeocia = new Vector<Integer>();
		wheatAtBeocia.add(1);
		
		Map<String,Vector<Integer>> beociaResources = new HashMap<String,Vector<Integer>>();
		beociaResources.put("Metal", metalAtBeocia);
		beociaResources.put("Wood", woodAtBeocia);
		beociaResources.put("Oil", oilAtBeocia);
		beociaResources.put("Wheat", wheatAtBeocia);
		
		
		//MACEDONIA
		Vector<Integer> woodAtMacedonia = new Vector<Integer>();
		woodAtMacedonia.add(1);
		woodAtMacedonia.add(3);
		woodAtMacedonia.add(6);
		woodAtMacedonia.add(10);
		Vector<Integer> wineAtMacedonia = new Vector<Integer>();
		wineAtMacedonia.add(1);
		wineAtMacedonia.add(3);
		wineAtMacedonia.add(6);
		Vector<Integer> wheatAtMacedonia = new Vector<Integer>();
		wheatAtMacedonia.add(1);
		wheatAtMacedonia.add(3);
		
		Map<String,Vector<Integer>> macedoniaResources = new HashMap<String,Vector<Integer>>();
		macedoniaResources.put("Wood", woodAtMacedonia);
		macedoniaResources.put("Wine", wineAtMacedonia);
		macedoniaResources.put("Wheat", wheatAtMacedonia);
		
		
		//TESALIA
		Vector<Integer> metalAtTesalia = new Vector<Integer>();
		metalAtTesalia.add(1);
		metalAtTesalia.add(3);
		metalAtTesalia.add(6);
		Vector<Integer> woodAtTesalia = new Vector<Integer>();
		woodAtTesalia.add(1);
		woodAtTesalia.add(3);
		woodAtTesalia.add(6);
		Vector<Integer> wheatAtTesalia = new Vector<Integer>();
		wheatAtTesalia.add(1);
		
		Map<String,Vector<Integer>> tesaliaResources = new HashMap<String,Vector<Integer>>();
		tesaliaResources.put("Metal", metalAtTesalia);
		tesaliaResources.put("Wood", woodAtTesalia);
		tesaliaResources.put("Wheat", wheatAtTesalia);
		
		
		//ACARNANIA
		Vector<Integer> metalAtAcarnania = new Vector<Integer>();
		metalAtAcarnania.add(1);
		metalAtAcarnania.add(3);
		metalAtAcarnania.add(6);
		metalAtAcarnania.add(10);
		Vector<Integer> wineAtAcarnania = new Vector<Integer>();
		wineAtAcarnania.add(1);
		wineAtAcarnania.add(3);
		wineAtAcarnania.add(6);
		Vector<Integer> silverAtAcarnania = new Vector<Integer>();
		silverAtAcarnania.add(1);
		silverAtAcarnania.add(3);
		
		Map<String,Vector<Integer>> acarnaniaResources = new HashMap<String,Vector<Integer>>();
		acarnaniaResources.put("Metal", metalAtAcarnania);
		acarnaniaResources.put("Wine", wineAtAcarnania);
		acarnaniaResources.put("Silver", silverAtAcarnania);
		
		
	//// Territories creation	
		Territory laconia = new Territory("Laconia","Laconia",laconiaResources);
		Territory mesenia = new Territory("Mesenia","Mesenia",meseniaResources);
		Territory sicilia = new Territory("Sicilia","Sicilia",siciliaResources);
		Territory megaris = new Territory("Megaris","Megaris",megarisResources);
		Territory arcadia = new Territory("Arcadia","Arcadia",arcadiaResources);
		Territory acaya = new Territory("Acaya","Acaya",acayaResources);
		Territory jonia = new Territory("Jonia","Jonia",joniaResources);
		Territory atica = new Territory("Atica","Atica",aticaResources);
		Territory beocia = new Territory("Beocia","Beocia",beociaResources);
		Territory macedonia = new Territory("Macedonia","Macedonia",macedoniaResources);
		Territory tesalia = new Territory("Tesalia","Tesalia",tesaliaResources);
		Territory acarnania = new Territory("Acarnania","Acarnania",acarnaniaResources);
		
	//// Seas creation
		//FIXME -> OBSOLETE, now: external files -> not delete for the moment, first remove its coupling with the others initializations
		Sea jonicoSea = new Sea("JonicoSea","JonicoSea");
		Sea mirtosSea = new Sea("MirtosSea","MirtosSea") ;
		Sea esporadasSea = new Sea("EsporadasSea","EsporadasSea") ;
		Sea cicladasSea = new Sea("CicladasSea","CicladasSea") ;
		Sea traciaSea = new Sea("TraciaSea","TraciaSea") ;
		
	//// TradeDocks creation
		
		TradeDock spartaDock = new TradeDock("SpartaDock","SpartaDock");
		TradeDock athensDock = new TradeDock("AthensDock","AthensDock") ;
	
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
		
	//// ALL POSITIONS (some maps)
		
		Map<String,Territory> territoriesMap = new HashMap<String,Territory>();
		territoriesMap.put("Laconia",laconia);
		territoriesMap.put("Mesenia",mesenia);
		territoriesMap.put("Sicilia",sicilia);
		territoriesMap.put("Megaris",megaris);
		territoriesMap.put("Arcadia",arcadia);
		territoriesMap.put("Acaya",acaya);
		territoriesMap.put("Jonia",jonia);
		territoriesMap.put("Atica",atica);
		territoriesMap.put("Beocia",beocia);
		territoriesMap.put("Macedonia",macedonia);
		territoriesMap.put("Tesalia",tesalia);
		territoriesMap.put("Acarnania",acarnania);
		
		IPolisFilesReader archivesReader = new PolReader(); ////////// <--------------------------------------------------- FILES READER HERE!!!!!!!!!!!!!!
		
		Map<String,Sea> seasMap = archivesReader.readSeas(); // new-using-external-files-call
		
		
		
		Map<String,TradeDock> tradeDocksMap = new HashMap<String,TradeDock>();
		tradeDocksMap.put("SpartaDock",spartaDock);
		tradeDocksMap.put("AthensDock",athensDock);
		
		Map<String,Market> marketsMap = new HashMap<String,Market>();
		marketsMap.put("Iliria",iliria);
		marketsMap.put("Tracia",tracia);
		marketsMap.put("EuxinosPontos",euxinosPontos);
		marketsMap.put("ImperioPersa",imperioPersa);
		marketsMap.put("Egipto",egipto);
		
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
		
		
//// PROJECTS
		List<Project> gameProjects = archivesReader.readProjects();
		
//// GAME EVENTS
		List<List<GameEvent>> gameEventsList = archivesReader.readGameEvents();
		
//// ROUND
		Round theRound = new Round();
		
//// MARKET CHART
		MarketChart theMarketChart = new MarketChart();
		
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
