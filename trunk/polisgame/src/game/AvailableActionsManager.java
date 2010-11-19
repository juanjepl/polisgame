package game;

/** This class contains methods for check available player's possible actions */
public class AvailableActionsManager {

	/** This method returns the possible actions to do for player p */
	public AvailableActionsManager(){}
		
	public static Boolean checkCreatorAction(Game g,Player p){
		return checkCreateHopliteAction(g,p)||checkCreateTrirremeAction(g,p)||checkCreateTradeBoatAction(g,p)||checkCreateProxenusAction(g,p);
	}
	public static Boolean checkMilitaryAction(Game g,Player p){
		return checkMoveHopliteAction(g,p)||checkMoveTrirremeAction(g,p)||checkSiegePolisAction(g,p)||checkPlunderTerritoryAction(g,p);
	}
	public static Boolean checkPoliticAction(Game g,Player p){
		return checkStartProjectAction(g,p)||checkTradeAction(g,p)||checkMoveProxenusAction(g,p)||checkCivilWarAction(g,p);
	}
	
	/** Sub methods */
	
	public static Boolean checkCreateHopliteAction(Game g,Player p){
		Boolean available = false;
		return available;
		//TODO
	}
	public static Boolean checkCreateTrirremeAction(Game g,Player p){
		Boolean available = false;
		return available;
		//TODO
	}
	public static Boolean checkCreateTradeBoatAction(Game g,Player p){
		Boolean available = false;
		return available;
		//TODO
	}
	public static Boolean checkCreateProxenusAction(Game g,Player p){
		Boolean available = false;
		//TODO
		return available;
	}
	
	public static Boolean checkMoveHopliteAction(Game g,Player p){
		Boolean available = false;
		//TODO
		return available;
	}
	public static Boolean checkMoveTrirremeAction(Game g,Player p){
		Boolean available = false;
		//TODO
		return available;
	}
	public static Boolean checkSiegePolisAction(Game g,Player p){
		Boolean available = false;
		//TODO
		return available;
	}
	public static Boolean checkPlunderTerritoryAction(Game g,Player p){
		Boolean available = false;
		//TODO
		return available;
	}

	public static Boolean checkStartProjectAction(Game g,Player p){
		Boolean available = false;
		//TODO
		return available;
	}
	public static Boolean checkTradeAction(Game g,Player p){
		Boolean available = false;
		//TODO
		return available;
	}
	public static Boolean checkMoveProxenusAction(Game g,Player p){
		Boolean available = false;
		//TODO
		return available;
	}
	public static Boolean checkCivilWarAction(Game g,Player p){
		Boolean available = false;
		//TODO
		return available;
	}
	
}