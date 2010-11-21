package game;

import ui.TextModeUi;

/** This class contains the methods for execute creation actions in the game */
public class CreatorAction extends Action{
	
	private final String actionType = "creatorAction"; // A constant to check action's type
	
	public CreatorAction(){}
	
	/** Creates an Hoplite unit in polis's parent territory */
	public Boolean createHoplite(Player owner, Polis polis, Round round){
		Boolean success = false;
		success = AvailableActionsManager.checkCreateHopliteAction(owner, polis, round);
		
		if(success){

			String paid = TextModeUi.requestPaidMethod("hoplite");
			
			if(paid.equals("Metal")){
				owner.setMetal(owner.getMetal() - 1);
			}else if(paid.equals("Silver")){
				owner.setSilver(owner.getSilver() - 1);
			}else{
				success = false; // Invalid resource ( wrong value of paid )
			}
			polis.setActualPopulation(polis.getActualPopulation() - 1);
			polis.getPolisParentTerritory().addUnit(new Hoplite(owner));

		}else{
			// Do nothing -> success returns false
		}
		return success; // returns an "advice" to know if the action has been done or not.
	}
	
	/** Creates a Trirreme unit in polis's sea */
	public Boolean createTirreme(Player owner, Polis polis, Round round){
		Boolean success = false;
		success = AvailableActionsManager.checkCreateTrirremeAction(owner, polis, round);
		
		if(success){
			String paid = TextModeUi.requestPaidMethod("trirreme");
			if(paid.equals("Wood")){
				owner.setMetal(owner.getWood() - 1);
			}else if(paid.equals("Silver")){
				owner.setSilver(owner.getSilver() - 1);
			}else{
				success = false; // Invalid resource ( wrong value of paid )
			}
			polis.setActualPopulation(polis.getActualPopulation() - 1);
			
			// the trirreme is created in the free sea if 2. if both are free, player chooses.
			if(polis.getPolisSeas().size() == 2){ //TODO re-view this if
				if((polis.getPolisSeas().get(0).getNumberOfFreeSlotsForAPlayer(owner, round)>= 1) && (polis.getPolisSeas().get(1).getNumberOfFreeSlotsForAPlayer(owner, round) < 1)){
					polis.getPolisSeas().get(0).addUnit(new Trirreme(owner));
				}else if((polis.getPolisSeas().get(0).getNumberOfFreeSlotsForAPlayer(owner, round) < 1) && (polis.getPolisSeas().get(1).getNumberOfFreeSlotsForAPlayer(owner, round) >= 1)){
					polis.getPolisSeas().get(1).addUnit(new Trirreme(owner));
				}else{
					TextModeUi.requestSeaForCreation(polis.getPolisSeas()).addUnit(new Trirreme(owner)); // Adds the trirreme to the Sea chosen by the player
				}

			}else{
				polis.getPolisSeas().get(0).addUnit(new Trirreme(owner));
			}
		}
		return success;
	}
	
	/** Creates a Trade Boat unit in polis's trade dock */
	public Boolean createTradeBoat(Player owner, Polis polis, Round round){
		Boolean success = false;
		//TODO
		return success;
	}
	
	/** Creates a Proxenus unit in selected polis */
	public Boolean createProxenus(Player owner, Polis polis){
		Boolean success = false;
		//TODO
		return success;
	}

	public String getActionType() {
		return actionType;
	}
	
}
