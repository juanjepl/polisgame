package game;

import ui.TextModeUi;

/** This class contains the methods for execute creation actions in the game */
public class CreatorAction extends GameAction{
	
	private final String actionType = "creatorAction"; // A constant to check action's type
	
	public CreatorAction(){}
	
	/** Creates an Hoplite unit in polis's parent territory */
	public Boolean createHoplite(Player owner, Polis polis, Round round){
		Boolean success = false;
		success = AvailableActionsManager.checkCreateHopliteAction(owner, polis, round);
		
		if(success){
			
			// if only have metal to pay, uses it, same with silver. if both -> player chooses.
			if(owner.getMetal() >= 1 && owner.getSilver() < 1){
				owner.setMetal(owner.getMetal() - 1);
			}else if(owner.getMetal() < 1 && owner.getSilver() >= 1){
				owner.setSilver(owner.getSilver() - 1);
			}else{
				
				String paid = TextModeUi.requestPaidMethod("hoplite");
				
				if(paid.equals("Metal")){
					owner.setMetal(owner.getMetal() - 1);
				}else if(paid.equals("Silver")){
					owner.setSilver(owner.getSilver() - 1);
				}else{
					success = false; // Invalid resource ( wrong value of paid )
				}	
			}
			
			polis.setActualPopulation(polis.getActualPopulation() - 1);
			Hoplite hop = new Hoplite(owner,polis.getPolisParentTerritory());
			polis.getPolisParentTerritory().addUnit(hop);
			owner.addUnit(hop);
			
			TextModeUi.showMessage("Hoplite created at "+polis.getPolisParentTerritory().getName());
			
		}else{
			// Do nothing -> success returns false
		}

		return success; // returns an "advice" to know if the action has been done or not.
	}
	
	/** Creates a Trirreme unit in polis's sea */
	public Boolean createTrirreme(Player owner, Polis polis, Round round){
		Boolean success = false;
		success = AvailableActionsManager.checkCreateTrirremeAction(owner, polis, round);
		
		if(success){
			
			// if only have wood to pay, uses it, same with silver. if both -> player chooses.
			if(owner.getWood() >= 1 && owner.getSilver() < 1){
				owner.setMetal(owner.getWood() - 1);
			}else if(owner.getWood() < 1 && owner.getSilver() >= 1){
				owner.setSilver(owner.getSilver() - 1);
			}else{
				String paid = TextModeUi.requestPaidMethod("trirreme");
				if(paid.equals("Wood")){
					owner.setMetal(owner.getWood() - 1);
				}else if(paid.equals("Silver")){
					owner.setSilver(owner.getSilver() - 1);
				}else{
					success = false; // Invalid resource ( wrong value of paid )
				}
			}
			
			polis.setActualPopulation(polis.getActualPopulation() - 1);
			
			// the trirreme is created in the free sea if 2. if both are free, player chooses.
			if(polis.getPolisSeas().size() == 2){ //TODO re-view this if
				if((polis.getPolisSeas().get(0).getNumberOfFreeSlotsForAPlayer(owner, round)>= 1) && (polis.getPolisSeas().get(1).getNumberOfFreeSlotsForAPlayer(owner, round) < 1)){
					
					Trirreme tri1 = new Trirreme(owner,polis.getPolisSeas().get(0));
					polis.getPolisSeas().get(0).addUnit(tri1);
					owner.addUnit(tri1);
					
					TextModeUi.showMessage("Trirreme created at "+polis.getPolisSeas().get(0).getName()); //FIXME from gameTexts
					
				}else if((polis.getPolisSeas().get(0).getNumberOfFreeSlotsForAPlayer(owner, round) < 1) && (polis.getPolisSeas().get(1).getNumberOfFreeSlotsForAPlayer(owner, round) >= 1)){
					
					Trirreme tri2 = new Trirreme(owner,polis.getPolisSeas().get(1));
					polis.getPolisSeas().get(1).addUnit(tri2);
					owner.addUnit(tri2);
					
					TextModeUi.showMessage("Trirreme created at "+polis.getPolisSeas().get(1).getName()); //FIXME from gameTexts
					
				}else{
					Sea theSea = TextModeUi.requestSeaForCreation(polis.getPolisSeas());
					Trirreme tri3 = new Trirreme(owner,theSea);
					theSea.addUnit(tri3); // Adds the trirreme to the Sea chosen by the player
					owner.addUnit(tri3);
					
					TextModeUi.showMessage("Trirreme created at "+theSea.getName()); //FIXME from gameTexts
				}

			}else{
				Trirreme tri4 = new Trirreme(owner,polis.getPolisSeas().get(0));
				polis.getPolisSeas().get(0).addUnit(tri4);
				owner.addUnit(tri4);
				
				TextModeUi.showMessage("Trirreme created at "+polis.getPolisSeas().get(0).getName()); //FIXME from gameTexts
			}
		}
		return success;
	}
	
	/** Creates a Trade Boat unit in polis's trade dock */
	public Boolean createTradeBoat(Player owner, Polis polis, Round round){
		Boolean success = false;
		
		success = AvailableActionsManager.checkCreateTrirremeAction(owner,polis,round);
		
		if(success){

			if(owner.getWood()>=1 && owner.getSilver()<1){
				owner.setWood(owner.getWood() - 1);
			}else if(owner.getWood()<1 && owner.getSilver()>=1){
				owner.setSilver(owner.getSilver() - 1);
			}else{

				String paid = TextModeUi.requestPaidMethod( "tradeBoat" );

				if(paid.equals( "Wood" ) ){
					owner.setWood(owner.getWood() - 1);
				}else if(paid.equals( "Silver" ) ){
					owner.setSilver(owner.getSilver() - 1);
				}else{
					success = false;
				}
			}
			polis.setActualPopulation(polis.getActualPopulation() - 1);
			
			TradeBoat tb = new TradeBoat(owner,owner.getPlayerTradeDock());
			owner.getPlayerTradeDock().addUnit(tb);
			owner.addUnit(tb);
			
			}else{
				//Do nothing,success=false;
			}
		return success;
	}
	
	/** Creates a Proxenus unit in selected polis */
	public Boolean createProxenus(Player owner, Polis polis){
		Boolean success = false;
		success = AvailableActionsManager.checkCreateProxenusAction (owner , polis);
		
		if(success){
		
		owner.setSilver ( owner.getSilver() - 4);
		polis.setActualPopulation ( polis.getActualPopulation() - 1);
		Proxenus prox = new Proxenus(owner,polis);
		polis.getUnits().add(prox);
		owner.setPlayerProxenus(prox);
		
		}else{
			//do nothing->return success=false
		}
		return success;
	}

	public String getActionType() {
		return actionType;
	}
}
