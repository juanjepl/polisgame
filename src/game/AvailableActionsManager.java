package game;

import navigation.HopliteGraphNavigator;
import navigation.ProxenusGraphNavigator;
import navigation.TradeBoatGraphNavigator;
import navigation.TrirremeGraphNavigator;

/** This class contains methods for check available player's possible actions */
public class AvailableActionsManager {

	public AvailableActionsManager(){}
	
	// 1ST LEVEL METHODS

	public static Boolean checkCreatorAction(Round round,Player player){
		Boolean checkPreviousAction = true;
		if(round.getCurrentTurn().getFirstAction() != null)
		{
			if(round.getCurrentTurn().getFirstAction() instanceof CreatorAction)
			{
				checkPreviousAction = false;
			}
		}

		return checkPreviousAction || checkCreateHopliteAnyAction(round,player) || checkCreateTrirremeAnyAction(round,player) || checkCreateTradeBoatAnyAction(round,player) || checkCreateProxenusAnyAction(player);
	}
	public static Boolean checkMilitaryAction(Game game, Player player){
		
		Boolean checkPreviousAction = true;
		if(game.getRound().getCurrentTurn().getFirstAction() != null)
		{
			if(game.getRound().getCurrentTurn().getFirstAction() instanceof MilitaryAction)
			{
				checkPreviousAction = false;
			}
		}
		
		return checkPreviousAction || checkMoveHopliteAnyAction(game,player) || checkMoveTrirremeAnyAction(game,player) || checkSiegePolisAnyAction(game,player) || checkPlunderTerritoryAnyAction(game,player);
	}	
	public static Boolean checkPoliticAction(Game game,Player player){
		
		Boolean checkPreviousAction = true;
		if(game.getRound().getCurrentTurn().getFirstAction() != null)
		{
			if(game.getRound().getCurrentTurn().getFirstAction() instanceof PoliticAction)
			{
				checkPreviousAction = false;
			}
		}
		
		return checkPreviousAction || checkStartProjectAnyAction(game,player) || checkTradeAnyAction(game,player) || checkMoveProxenusAnyAction(game,player) || checkCivilWarAction(player, (Polis) player.getPlayerProxenus().getPosition());
	}

	// 2ND LEVEL METHODS
	
	public static Boolean checkCreateHopliteAnyAction(Round r, Player p){
		Boolean available = false;
		for(Polis po : p.getPlayerPolis()){ 
			if(checkCreateHopliteAction(p,po,r)){
				available = true;
				break;
			}
		}
		return available;
	}
	public static Boolean checkCreateTrirremeAnyAction(Round r,Player p){
		Boolean available = false;
		for(Polis po : p.getPlayerPolis()){ 
			if(checkCreateTrirremeAction(p,po,r)){
				available = true;
				break;
			}
		}
		return available;
	}
	public static Boolean checkCreateTradeBoatAnyAction(Round r,Player p){
		Boolean available = false;
		for(Polis po : p.getPlayerPolis()){ 
			if(checkCreateTradeBoatAction(p,po,r)){ 
				available = true;
				break;
			}
		}
		return available;
	}
	public static Boolean checkCreateProxenusAnyAction(Player p){
		Boolean available = false;
		for(Polis po : p.getPlayerPolis()){ 
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
				if(checkMoveHopliteAction(g, p,g.getRound(),terrInic,terrDest,1)){
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
				if(checkMoveTrirremeAction(g, p, g.getRound(),seaInic, seaDest,1)){
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
				if(checkStartProjectAction(po,proj)){
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
			if(checkTradeAction(g,p,mar)){
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
				if(checkMoveProxenusAction(g,p,proxenusLocation,po)){
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
			if(checkMoveHopliteAction(game, player,game.getRound(),start,terr,troops)){
				available = true;
			}
		}
		return available;
	}
	

	public static Boolean checkMoveHopliteAction(Game game, Player player, Round round, Territory start, Territory destiny, Integer troops){
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
		HopliteGraphNavigator hopliteGraphNavigator = new HopliteGraphNavigator(player, start, destiny, game.getHopliteGraph());
		Boolean condition_WayStartToFinish = hopliteGraphNavigator.getExists();
		
		available = condition_notSame && condition_havePrestige && condition_NumberOfTroops && condition_TroopsInStart && condition_DestinyWithSlots && condition_WayStartToFinish;
		
		return available;
	}
	
	// 2nd ~ 3rd lvl method
	public static Boolean checkMoveTrirremeActionFromX(Game game, Player player, Sea start, Integer troops){
		Boolean available = false;
		for(Sea se: game.getGameSeas().values()){
			if(checkMoveTrirremeAction(game, player,game.getRound(),start,se,troops)){
				available = true;
			}
		}
		return available;
	}
	
	public static Boolean checkMoveTrirremeAction(Game game, Player player, Round round, Sea start, Sea destiny, Integer troops){
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
		
		TrirremeGraphNavigator trirremeGraphNavigator = new TrirremeGraphNavigator(player, start, destiny, game.getTrirremeGraph());
		Boolean condition_WayStartToFinish = trirremeGraphNavigator.getExists();
		
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
					}
				}
			}
			
			Boolean condition_minNumberOfUnits = realTroops >= polis.getBasePopulation();
			Boolean condition_siegedPolis = !(polis.getSieged());
			Boolean condition_isNotMine = polis.getPolisOwner() == null || !polis.getPolisOwner().equals(player);
			available = condition_havePrestige && condition_minNumberOfUnits && condition_siegedPolis && condition_isNotMine;
		}
		
		return available;
	}
	
	public static Boolean checkPlunderTerritoryAction(Player player, Territory terr, Round round, Integer troops){
		Boolean available = false;

		Boolean condition_maxTroops = troops <= round.getMaximumPositionSlotsForThisRound();
		Boolean condition_havePrestige = player.getPrestige() >= 1;
		Boolean condition_isPlundered = !(terr.getPlundered());
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
		
		Boolean condition_haveAtLeastOneTroopInTerritory = false;
		for(Unit u: terr.getUnits()){
			if(u instanceof Hoplite && u.getOwner().equals(player)){
				condition_haveAtLeastOneTroopInTerritory = true;
				break;
			}
		}
		
		
		//comprobar si se usa round pa el numero de tropas
		
		available = condition_maxTroops && condition_havePrestige && condition_haveHoplites && condition_haveAtLeastOneTroopInTerritory && condition_haveMinPolis && condition_isPlundered;
		
		return available;
	}

	public static Boolean checkStartProjectAction(Polis polis,Project project){
		Boolean available = false;
		
		Boolean condition_haveResourcesRequired = true;
		
		//check if player have amount needed of required resources
		for(String resourceName: project.getResourcesRequired().keySet())
		{
			Integer resource = project.getResourcesRequired().get(resourceName);
		
			if(polis.getPolisOwner().getResource(resourceName) < resource)
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
	
	public static Boolean checkTradeAction(Game game, Player player, Market market){
		Boolean available = false;

		TradeBoatGraphNavigator tradeBoatGraphNavigator = new TradeBoatGraphNavigator(player, player.getPlayerTradeDock(), market, game.getTradeBoatGraph());
		Boolean condition_existWay = tradeBoatGraphNavigator.getExists();
		
		Boolean condition_disponible = market.getUnits().size() == 0;
		
		available = condition_existWay && condition_disponible;
		
		if(player.getCapital().getSysName().equals("sparta"))
		{
			Boolean condition_spartaHasOnePolis = false;
			for(Polis p:player.getPlayerPolis())
			{

				if(p.getSysName().equals("gythion") || p.getSysName().equals("pylos"))
				{
					condition_spartaHasOnePolis = true;
					break;
				}
			}

			available = available && condition_spartaHasOnePolis;
		}
		
		
		return available;
	}
	
	/** Utility method for Trades  */
	public static Boolean checkResourceAvailabilityInATrade(Round r, Market m, String resource){
		return m.getAssociatedResource(resource, r.getMaximumPositionSlotsForThisRound()) != null;
	}
	
	/** checks if i have enough amount of a resource for paying a trade in a market */
	public static Boolean checkIfICanPayThisTradeWithThisResource(Player p, MarketChart marketChart, String resourceForPay){
		return p.getResource(resourceForPay) >= marketChart.getPrice(resourceForPay);
	}
	
	public static Boolean checkMoveProxenusAction(Game game, Player player, Polis start, Polis destiny){
		Boolean available = true;
		
		ProxenusGraphNavigator proxenusGraphNavigator = new ProxenusGraphNavigator(player, start, destiny, game.getProxenusGraph());
		Boolean condition_existsWayForProxenus = proxenusGraphNavigator.getExists();
		//Boolean condition_existsWayForProxenus = true;
		Boolean condition_playerHaveMinimumAmountOfSilver = player.getSilver() >= proxenusGraphNavigator.getAmountToPayForWay();
		//Boolean condition_playerHaveMinimumAmountOfSilver = true;
		Boolean condition_onlyOneProxenusInDestiny = destiny.getPolisOwner() == null || !destiny.getPolisOwner().getPlayerProxenus().getPosition().equals(destiny);
			
		available = condition_existsWayForProxenus && condition_playerHaveMinimumAmountOfSilver && condition_onlyOneProxenusInDestiny;
		return available;
	}
	
	public static Boolean checkCivilWarAction(Player player,Polis polis){
		Boolean available = false;
		
		Boolean condition_isNeutralOrOponent = false;

		//check if player has minimum amount of silver 
		if(polis.getPolisOwner() == null){
			//is neutral
			condition_isNeutralOrOponent = player.getSilver() >= (2 * polis.getBasePopulation());
			
		}else if(!polis.getPolisOwner().equals(player))
		{
			//oponent is owner
			condition_isNeutralOrOponent = player.getSilver() >= (3 * polis.getActualPopulation());
		}
		
		Boolean condition_isSieged = !polis.getSieged();
		
		Boolean condition_notOponentCapital = polis.getPolisOwner() == null || !(polis.getPolisOwner().equals(player)) && !polis.getPolisOwner().getCapital().equals(polis);

		available = condition_isNeutralOrOponent && condition_isSieged && condition_notOponentCapital;
		
		return available;
	}	
}