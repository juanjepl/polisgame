package game;

/** This class contains methods for check available player's possible actions */
public class AvailableActionsManager {

	public AvailableActionsManager(){}
	
	// 1ST LEVEL METHODS

	public static Boolean checkCreatorAction(Game game,Player player){
		return checkCreateHopliteAnyAction(game,player) || checkCreateTrirremeAnyAction(game,player) || checkCreateTradeBoatAnyAction(game,player) || checkCreateProxenusAnyAction(game,player);
	}
	public static Boolean checkMilitaryAction(Game game,Player player){
		return checkMoveHopliteAnyAction(game,player) || checkMoveTrirremeAnyAction(game,player) || checkSiegePolisAnyAction(game,player) || checkPlunderTerritoryAnyAction(game,player);
	}	
	public static Boolean checkPoliticAction(Game game,Player player){
		return checkStartProjectAnyAction(game,player) || checkTradeAnyAction(game,player) || checkMoveProxenusAnyAction(game,player) || checkCivilWarAnyAction(game,player);
	}

	// 2ND LEVEL METHODS
	
	public static Boolean checkCreateHopliteAnyAction(Game g, Player p){
		Boolean available = false;
		for(Polis po : g.getGamePolis().values()){ 
			if(checkCreateHopliteAction(p,po,g.getRound())){
				available = true;
				break;
			}
		}
		return available;
	}
	public static Boolean checkCreateTrirremeAnyAction(Game g,Player p){
		Boolean available = false;
		for(Polis po : g.getGamePolis().values()){ 
			if(checkCreateTrirremeAction(p,po,g.getRound())){
				available = true;
				break;
			}
		}
		return available;
	}
	public static Boolean checkCreateTradeBoatAnyAction(Game g,Player p){
		Boolean available = false;
		for(Polis po : g.getGamePolis().values()){ 
			if(checkCreateTradeBoatAction(p,po,g.getRound())){ 
				available = true;
				break;
			}
		}
		return available;
	}
	public static Boolean checkCreateProxenusAnyAction(Game g,Player p){
		Boolean available = false;
		for(Polis po : g.getGamePolis().values()){ 
			if(checkCreateProxenusAction(p,po)){ 
				available = true;
				break;
			}
		}
		return available;
	}

	public static Boolean checkMoveHopliteAnyAction(Game g,Player p){
		Boolean available = false;
		for(Territory terrInic : g.getGameTerritories().values()){
			for(Territory terrDest : g.getGameTerritories().values()){
				if(checkMoveHopliteAction(p,g.getRound(),terrInic,terrDest,1)){
					available = true;
					break;
				}
			}
			if(available){
				break;
			}
		}
		return available;
	}
	public static Boolean checkMoveTrirremeAnyAction(Game g,Player p){
		Boolean available = false;
		for(Sea seaInic : g.getGameSeas().values()){
			for(Sea seaDest : g.getGameSeas().values()){
				if(checkMoveTrirremeAction(p, g.getRound(),seaInic, seaDest,1)){
					available = true;
					break;
				}
			}
			if(available){
				break;
			}	
		}
		return available;
	}
	public static Boolean checkSiegePolisAnyAction(Game g,Player p){
		Boolean available = false;
		for(Polis po : g.getGamePolis().values()){
			if(checkSiegePolisAction(p,po)){
				available = true;
				break;
			}
		}
		return available;
	}
	public static Boolean checkPlunderTerritoryAnyAction(Game g,Player p){
		Boolean available = false;
		for(Territory terr: g.getGameTerritories().values()){
			if(checkPlunderTerritoryAction(p,terr,g.getRound(),1)){
				available = true;
				break;
			}
		}
		return available;
	}

	public static Boolean checkStartProjectAnyAction(Game g,Player p){
		Boolean available = false;
		for(Project proj : g.getRound().getProjectsInThisRound()){
			for(Polis po : p.getPlayerPolis()){
				if(checkStartProjectAction(p,po,proj)){
					available = true;
					break;
				}
			}
			if(available){
				break;
			}
		}
		return available;
	}
	public static Boolean checkTradeAnyAction(Game g,Player p){
		Boolean available = false;
		for(Market mar : g.getGameMarkets().values()){
			if(checkTradeAction(p,mar,g.getRound())){
				available = true;
				break;
			}
		}
		return available;
	}
	public static Boolean checkMoveProxenusAnyAction(Game g,Player p){
		Boolean available = false;
		Boolean existsProxenus = false;
		Polis proxenusLocation = null;
		for(Polis po: g.getGamePolis().values()){
			for(Unit u: po.getUnits()){
				if(u instanceof Proxenus && u.getOwner().equals(p)){
					proxenusLocation = po;
					existsProxenus = true;
				}
			}
		}
		
		if(existsProxenus){
			for(Polis po: g.getGamePolis().values()){
				if(checkMoveProxenusAction(p,proxenusLocation,po)){
					available = true;
					break;
				}
			}
		}
		return available;
	}
	public static Boolean checkCivilWarAnyAction(Game g,Player p){
		Boolean available = false;
		Boolean existsProxenus = false;
		
		for(Polis po: g.getGamePolis().values()){
			for(Unit u: po.getUnits()){
				if(u instanceof Proxenus && u.getOwner().equals(p)){
					existsProxenus = true;
				}
			}
		}
		
		if(existsProxenus){
			for(Polis po: g.getGamePolis().values()){
				if(checkCivilWarAction(g,p,po)){
					available = true;
					break;
				}
			}
		}
		return available;
	}
	
	// 3RD LEVEL METHODS
	
	public static Boolean checkCreateHopliteAction(Player player, Polis polis, Round round){
		Boolean available = false;
		
		Boolean condition_imTheOwnerOfThePolis = player.getPlayerPolis().contains(polis);
		Boolean condition_haveResources = player.getMetal()>= 1 || player.getSilver()>= 1;
		Boolean condition_enoughPopulation = polis.getActualPopulation() > 1;
		Boolean condition_hasParentTerritory = polis.getPolisParentTerritory() != null;
		Boolean condition_notSieged = !polis.getSieged();
		Boolean condition_TerritoryWithSlot = false;
		if(condition_hasParentTerritory){
			condition_TerritoryWithSlot = polis.getPolisParentTerritory().getNumberOfFreeSlotsForAPlayer(player, round)>= 1;
		}else{
			condition_TerritoryWithSlot = false;
		}
		available = condition_imTheOwnerOfThePolis && condition_haveResources && condition_enoughPopulation && condition_hasParentTerritory && condition_notSieged && condition_TerritoryWithSlot;
		return available;
	}
	public static Boolean checkCreateTrirremeAction(Player player, Polis polis, Round round){
		Boolean available = false;
		
		Boolean condition_imTheOwnerOfThePolis = player.getPlayerPolis().contains(polis);
		Boolean condition_haveResources = player.getWood()>= 1 || player.getSilver()>= 1;
		Boolean condition_enoughPopulation = polis.getActualPopulation() > 1;
		Boolean condition_notSieged = !polis.getSieged();
		Boolean condition_polisHasSea = polis.getPolisSeas().isEmpty() == false;
		Boolean condition_SeaWithSlotA = false;
		Boolean condition_SeaWithSlotB = false;
		if(polis.getPolisSeas().isEmpty() == false){ // To avoid possible exceptions
			condition_SeaWithSlotA = polis.getPolisSeas().get(0).getNumberOfFreeSlotsForAPlayer(player, round)>= 1;
			if(polis.getPolisSeas().size() == 2){ // To avoid more possible exceptions
			condition_SeaWithSlotB = polis.getPolisSeas().get(1).getNumberOfFreeSlotsForAPlayer(player, round)>= 1;
			}
		}
		
		available = condition_imTheOwnerOfThePolis && condition_haveResources && condition_enoughPopulation && condition_polisHasSea && condition_notSieged && (condition_SeaWithSlotA || condition_SeaWithSlotB);
		return available;
	}
	public static Boolean checkCreateTradeBoatAction(Player player, Polis polis, Round round){
		Boolean available = false;
		Boolean condition_imTheOwnerOfThePolis = player.getPlayerPolis().contains(polis);
		Boolean condition_haveResources = player.getWood()>= 1 || player.getSilver()>= 1;
		Boolean condition_enoughPopulation = polis.getActualPopulation() > 1;
		Boolean condition_hasTradeDock = polis.getHasTradeDock();
		Boolean condition_notSieged = !polis.getSieged();
		Boolean condition_TradeDockWithSlot = player.getPlayerTradeDock().getNumberOfFreeSlotsForAPlayer(player, round)>= 1;
		
		available = condition_imTheOwnerOfThePolis && condition_haveResources && condition_enoughPopulation && condition_hasTradeDock && condition_notSieged && condition_TradeDockWithSlot;
		return available;
	}
	public static Boolean checkCreateProxenusAction(Player player, Polis polis){
		Boolean available = false;
		
		Boolean condition_imTheOwnerOfThePolis = player.getPlayerPolis().contains(polis);
		Boolean condition_haveResources = player.getSilver()>= 5;
		Boolean condition_enoughPopulation = polis.getActualPopulation() > 1;
		Boolean condition_notSieged = !polis.getSieged();
		Boolean condition_notExistsAnotherProxenus = player.getPlayerProxenus() == null;

		available = condition_imTheOwnerOfThePolis && condition_haveResources && condition_enoughPopulation && condition_notSieged && condition_notExistsAnotherProxenus;
		return available;
	}

	
	// 2nd ~ 3rd lvl method
	public static Boolean checkMoveHopliteActionFromX(Game game,Player player,Territory start, Integer troops){
		Boolean available = false;
		for(Territory terr: game.getGameTerritories().values()){
			if(checkMoveHopliteAction(player,game.getRound(),start,terr,troops)){
				available = true;
			}
		}
		return available;
	}
	

	public static Boolean checkMoveHopliteAction(Player player, Round round, Territory start, Territory destiny, Integer troops){
		Boolean available = false;

		Boolean condition_notSame = !(start.equals(destiny));
		Boolean condition_havePrestige = player.getPrestige() >= 1;
		Boolean condition_NumberOfTroops = (troops <= round.getMaximumPositionSlotsForThisRound()) && (troops != 0);
		Boolean condition_TroopsInStart = false;
		if(!(start.getUnits().isEmpty())){
			Integer realTroops = 0;
			for(Unit u: start.getUnits()){
				if(u.getOwner().equals(player)){
					realTroops += 1;
				}else{
					// Do nothing
				}
			}
			condition_TroopsInStart = realTroops == troops;
		}else{
			// Do nothing -> Already: condition_TroopsInStart = false 
		}
		Boolean condition_DestinyWithSlots = destiny.getNumberOfFreeSlotsForAPlayer(player, round) >= troops;
		Boolean condition_WayStartToFinish = GraphNavigatorManager.existsWay(start,destiny,player,"hoplite");
		
		available = condition_notSame && condition_havePrestige && condition_NumberOfTroops && condition_TroopsInStart && condition_DestinyWithSlots && condition_WayStartToFinish;
		
		return available;
	}
	
	// 2nd ~ 3rd lvl method
	public static Boolean checkMoveTrirremeActionFromX(Game game, Player player, Sea start, Integer troops){
		Boolean available = false;
		for(Sea terr: game.getGameSeas().values()){
			if(checkMoveTrirremeAction(player,game.getRound(),start,terr,troops)){
				available = true;
			}
		}
		return available;
	}
	
	public static Boolean checkMoveTrirremeAction(Player player, Round round, Sea start, Sea destiny, Integer troops){
		Boolean available = false;
		
		Boolean condition_notSame = !(start.equals(destiny));
		Boolean condition_havePrestige = player.getPrestige() >= 1;
		Boolean condition_NumberOfTroops = (troops <= round.getMaximumPositionSlotsForThisRound()) && (troops != 0);
		Boolean condition_TroopsInStart = false;
		if(!(start.getUnits().isEmpty())){
			Integer realTroops = 0;
			for(Unit u: start.getUnits()){
				if(u.getOwner().equals(player)){
					realTroops += 1;
				}else{
					// Do nothing
				}
			}
			condition_TroopsInStart = realTroops >= troops;
		}else{
			// Do nothing -> Already: condition_TroopsInStart = false 
		}
		Boolean condition_DestinyWithSlots = destiny.getNumberOfFreeSlotsForAPlayer(player, round) >= troops;
		Boolean condition_WayStartToFinish = GraphNavigatorManager.existsWay(start,destiny,player,"trirreme");
		
		available = condition_notSame && condition_havePrestige && condition_NumberOfTroops && condition_TroopsInStart && condition_DestinyWithSlots && condition_WayStartToFinish;
		
		return available;
	}
	public static Boolean checkSiegePolisAction(Player player, Polis polis){
		Boolean available = false;
	
		if(polis.getPolisParentTerritory() != null)
		{
			Boolean condition_havePrestige = player.getPrestige() >= 1;
			
			Integer realTroops = 0;
			if(!(polis.getPolisParentTerritory().getUnits().isEmpty())){
				
				for(Unit u: polis.getPolisParentTerritory().getUnits()){
					if(u.getOwner().equals(player)){
						realTroops += 1;
					}else{
						// Do nothing
					}
				}
			}
			
			Boolean condition_minNumberOfUnits = realTroops >= polis.getBasePopulation();
			Boolean condition_siegedPolis = polis.getSieged();
			
			available = condition_havePrestige && condition_minNumberOfUnits && condition_siegedPolis;
		}
		
		return available;
	}
	
	public static Boolean checkPlunderTerritoryAction(Player player, Territory terr, Round round, Integer troops){
		Boolean available = false;

		Boolean condition_maxTroops = troops <= round.getMaximumPositionSlotsForThisRound();
		Boolean condition_havePrestige = player.getPrestige() >= 1;
		Boolean condition_isPlundered = terr.getPlundered();
		Integer numHoplites = 0;
		
		for(Unit u: player.getPlayerUnits())
		{
			if(u instanceof Hoplite)
			{
				numHoplites += 1;
			}
		}
		
		Boolean condition_haveHoplites = numHoplites >= 1;
		
		Integer numPolisOwnedInTerritory = 0;
		
		for(Polis p: player.getPlayerPolis())
		{
			if(p.getPolisParentTerritory().getSysName().equals(terr.getSysName()))
			{
				numPolisOwnedInTerritory += 1;
			}
		}
		
		Boolean condition_haveMinPolis = numPolisOwnedInTerritory >= 1;
		
		
		//comprobar si se usa round pa el numero de tropas
		
		available = condition_maxTroops && condition_havePrestige && condition_haveHoplites && condition_haveMinPolis && condition_isPlundered;
		
		return available;
	}

	public static Boolean checkStartProjectAction(Player player,Polis polis,Project project){
		Boolean available = false;
		
		Boolean condition_haveResourcesRequired = true;
		
		//check if player have amount needed of required resources
		for(String resourceName: project.getResourcesRequired().keySet())
		{
			Integer resource = project.getResourcesRequired().get(resourceName);
			if(player.getResource(resourceName) < resource)
			{
				condition_haveResourcesRequired = false;
			}
		}
		
		//check if project exist in polis
		Boolean condition_existProject = polis.getPossiblesProjects().contains(project);
		//check if polis is sieged
		Boolean condition_notSiegedPolis = !polis.getSieged();
		//check if some project is started
		Boolean condition_notStartedProject = true;
		
		for(Project p: polis.getProjects())
		{
			if(!p.getFinished())
			{
				condition_notStartedProject = false;
			}
		}
		
		
		available = condition_haveResourcesRequired && condition_existProject && condition_notSiegedPolis && condition_notStartedProject ;

		return available;
	}
	
	public static Boolean checkTradeAction(Player player, Market market, Round round){
		Boolean available = false;
		
		Boolean condition_existWay = GraphNavigatorManager.existsWay(player.getPlayerTradeDock(),market,player,"tradeBoat");
		
		Boolean condition_disponible = market.getUnits().size() == 0;
		
		Boolean condition_spartaHasOnePolis = false;
		for(Polis p:player.getPlayerPolis())
		{
			if(p.getSysName().equals("gition") || p.getSysName().equals("pilos"))
			{
				condition_spartaHasOnePolis = true;
				break;
			}
		}
		
		available = condition_existWay && condition_disponible && condition_spartaHasOnePolis;
		
		return available;
	}
	public static Boolean checkMoveProxenusAction(Player player,Polis start, Polis destiny){
		Boolean available = false;
		//TODO
		return available;
	}
	public static Boolean checkCivilWarAction(Game game, Player player,Polis polis){
		Boolean available = false;

		Player oponent;
		if(game.getAthensPlayer().equals(player))
		{
			oponent = game.getSpartaPlayer();
		}else
		{
			oponent = game.getAthensPlayer();
		}
		
		Boolean condition_isNeutralOrOponent = true;

		//check if player has minimum amount of silver 
		if(!player.getPlayerPolis().contains(polis) && !oponent.getPlayerPolis().contains(polis))
		{
			//is neutral
			condition_isNeutralOrOponent = player.getSilver() >= (2 * polis.getBasePopulation());
			
		}else if(!player.getPlayerPolis().contains(polis) && oponent.getPlayerPolis().contains(polis))
		{
			//oponent is owner
			condition_isNeutralOrOponent = player.getSilver() >= (3 * polis.getActualPopulation());
		}
		
		Boolean condition_isSieged = !polis.getSieged();
	
		Boolean condition_notOponentCapital = !oponent.getCapital().equals(polis);

		available = condition_isNeutralOrOponent && condition_isSieged && condition_notOponentCapital;
		
		return available;
	}
	
}