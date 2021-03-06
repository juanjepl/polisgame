package cfg;


/**
 * This class contains folders path's names and methods
 * to read and change game's configurations, for example, switch language
 */
public class GameConfigurations { 

	// static attributes who saved the game folder's path
	private static String pathOfSeas = "src/data/seas/ES/";
	private static String pathOfTradeDocks = "src/data/tradeDocks/ES/";
	private static String pathOfMarkets = "src/data/markets/ES/";
	private static String pathOfPolis = "src/data/polis/ES/";
	private static String pathOfTerritories = "src/data/territories/ES/";
	private static String pathOfProjects = "src/data/projects/ES/";
	private static String pathOfGameEvents = "src/data/gameEvents/ES/";
	private static String pathOfGraphs = "src/data/graphs/";
	private static String pathOfGameTexts = "src/data/gameTexts/ES/";
	
	private static Integer minNumberToBattle = 8;
	private static String starterPlayer = "sparta";
	
	private static String spartaPlayerName = null;
	private static String athensPlayerName = null;
	
	public GameConfigurations(){}
	
	
	/** Static Getters for folder path's names (and others) */

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
	
	public static String getPathOfGameTexts(){
		return pathOfGameTexts;
	}
	
	public static String getPathOfGraphs() {
		return pathOfGraphs;
	}
		
	public static String getStarterPlayer() {
		return starterPlayer;
	}

	public static Integer getMinNumberToBattle() {
		return minNumberToBattle;
	}

	public static void setMinNumberToBattle(Integer minNumberToBattle) {
		GameConfigurations.minNumberToBattle = minNumberToBattle;
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
		pathOfGameTexts = "src/data/gameTexts/ES/";
	}
	
	/** Set game's texts to English */
	public void setLanguageToEnglish(){
		pathOfSeas = "/data/seas/EN/";
		pathOfTradeDocks = "/data/tradeDocks/EN/";
		pathOfMarkets = "/data/markets/EN/";
		pathOfPolis = "/data/polis/EN/";
		pathOfTerritories = "/data/territories/EN/";
		pathOfProjects = "/data/projects/EN/";
		pathOfGameEvents = "/data/gameEvents/EN/";
		pathOfGameTexts = "src/data/gameTexts/EN/";
	}
	
	public static String getSpartaPlayerName()
	{
		return spartaPlayerName;
	}
	
	public static void setSpartaPlayerName(String name)
	{
		spartaPlayerName = name;
	}
	
	public static String getAthensPlayerName()
	{
		return athensPlayerName;
	}
	
	public static void setAthensPlayerName(String name)
	{
		athensPlayerName = name;
	}
}