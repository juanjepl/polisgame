package game;

/** This class contains the methods for execute creation actions in the game */
public class CreatorAction extends Action{
	
	private final String actionType = "creatorAction"; // A constant to check action's type
	
	public CreatorAction(){}
	
	/** Creates an Hoplite unit in polis's parent territory */
	public Boolean createHoplite(Player owner, Polis polis, Round round, String paid){
		Boolean success = false;
		success = AvailableActionsManager.checkCreateHopliteAction(owner, polis, round);
		
		if(success){
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
	public Boolean createTirreme(Player owner, Polis polis, String paid){
		Boolean success = false;
		
		//TODO 
		
		return success;
	}
	
	/** Creates a Trade Boat unit in polis's trade dock */
	public Boolean createTradeBoat(Player owner, Polis polis, String paid){
		Boolean success = false;
		//TODO
		return success;
	}
	
	/** Creates a Proxenus unit in selected polis */
	public Boolean createProxenus(Player owner, Polis polis, String paid){
		// In this method, String paid isn't neccesary, because proxenus only can be paid by 5 silver, but this rule can change...
		Boolean success = false;
		//TODO
		return success;
	}

	public String getActionType() {
		return actionType;
	}
	
}
