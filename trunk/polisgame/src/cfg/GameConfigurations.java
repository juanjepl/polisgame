package cfg;

/** This class contains folders pahs and methods to change game's configurations, for example, switch language */
public class GameConfigurations { 

	// static atributes who saved the game folders path
	private static String pathOfSeas = "/data/seas/ES/";
	private static String pathOfTradeDocks = "/data/tradeDocks/ES/";
	private static String pathOfMarkets = "/data/markets/ES/";
	private static String pathOfPolis = "/data/polis/ES/";
	private static String pathOfTerritories = "/data/territories/ES/";
	private static String pathOfProjects = "/data/projects/ES/";
	private static String pathOfGameEvents = "/data/gameEvents/ES/";
	private static String pathOfGraphs = "/data/graphs/";
	
	public GameConfigurations(){}
	

	public static String getPathOfSeas() {
		return pathOfSeas;
	}

	public static String getPathOfTradeDocks() {
		return pathOfTradeDocks;
	}

	public static String getPathOfMarkets() {
		return pathOfMarkets;
	}

	public static String getPathOfPolis() {
		return pathOfPolis;
	}

	public static String getPathOfTerritories() {
		return pathOfTerritories;
	}

	public static String getPathOfProjects() {
		return pathOfProjects;
	}

	public static String getPathOfGameEvents() {
		return pathOfGameEvents;
	}
	
	public static String getPathOfGraphs() {
		return pathOfGraphs;
	}
	
	/** Set game's texts to Spanish */
	public void setLanguageToSpanish(){
		pathOfSeas = "/data/seas/ES/";
		pathOfTradeDocks = "/data/tradeDocks/ES/";
		pathOfMarkets = "/data/markets/ES/";
		pathOfPolis = "/data/polis/ES/";
		pathOfTerritories = "/data/territories/ES/";
		pathOfProjects = "/data/projects/ES/";
		pathOfGameEvents = "/data/gameEvents/ES/";
	}
	
	/** Set game's texts to English */
	public void setLanguageToEnglish(){ //TODO make first files in EN folders
		pathOfSeas = "/data/seas/EN/";
		pathOfTradeDocks = "/data/tradeDocks/EN/";
		pathOfMarkets = "/data/markets/EN/";
		pathOfPolis = "/data/polis/EN/";
		pathOfTerritories = "/data/territories/EN/";
		pathOfProjects = "/data/projects/EN/";
		pathOfGameEvents = "/data/gameEvents/EN/";
	}
	
}
