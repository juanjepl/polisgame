package game;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

/** This class contains the methods for execute military actions in the game */
public class MilitaryAction extends GameAction{

	private final String actionType = "militaryAction"; // A constant to check action's type
	
	
	public MilitaryAction(){}
	
	
	/** To move an Hoplite or Hoplites group, to other position */
	public Boolean moveHoplite(Player player, Round round,Territory initialPosition, Territory finalPosition, Integer numberOfUnits, Boolean multiMovement){
		Boolean success = false; // This line is not necessary
		success = AvailableActionsManager.checkMoveHopliteAction(player, round, initialPosition, finalPosition, numberOfUnits);
		if(success){
			List<Unit> unitsToMove = new ArrayList<Unit>();
			Integer unitsCount = 0;
			
			for(Unit u: initialPosition.getUnits()){
				if(u.getOwner().equals(player)){
					if(unitsCount < numberOfUnits){
						unitsToMove.add(u);
						unitsCount += 1;
					}else{
						break;
					}	
				}
			}
			initialPosition.removeGroupOfUnits(unitsToMove);
			finalPosition.addGroupOfUnits(unitsToMove);
			
			for(Unit u: unitsToMove){
				u.setPosition(finalPosition);
			}
				
			if(multiMovement){
				
				//TODO
				
			}else{
				//Do nothing, action finished.
				// This block is not necessary
			}
				
		}else{
			// Do nothing
			// This block is not necessary
		}

		return success;
	}
	
	/** To move a Trirreme or Trirremes group, to other sea */
	public Boolean moveTrirreme(Round round, Player player, Sea initialSea, Sea finalSea, Integer numberOfUnits, Boolean multiMovement) {
		if (round == null) throw new NullPointerException("'round' can not be null");
		if (player == null) throw new NullPointerException("'player' can not be null");
		if (initialSea == null) throw new NullPointerException("'initialSea' can not be null");
		if (finalSea == null) throw new NullPointerException("'finalSea' can not be null");
		if (numberOfUnits == null) throw new NullPointerException("'numberOfUnits' can not be null");
		
		Boolean success = AvailableActionsManager.checkMoveTrirremeAction(player, round, initialSea, finalSea, 1);
		
		if (success)
		{
			List<Unit> startSeaUnits = initialSea.getUnits();	
			int unitMovedCount = 0;		
			Iterator<Unit> it = startSeaUnits.iterator();
			
			while(it.hasNext() && unitMovedCount < numberOfUnits)
			{
				Unit unit = it.next();
				
				if (unit.getOwner() == player)
				{
					initialSea.removeUnit(unit);
					finalSea.addUnit(unit);
					unitMovedCount++;
				}
			}
			
			// This is because of game rules
			player.setPrestige(player.getPrestige() - 1);
			
			if (multiMovement)
			{
				//TODO
			}
			else
			{
				//TODO
			}
		}
		
		return success;
	}
	
	/** Method to manage polis's siegues */
	public Boolean siegePolis(Player player,Position initialPosition, Polis siegedPolis ){
		Boolean success = false;
		//TODO
		// not needs numberOfUnits (you CAN or CANNOT siegue a polis)
		return success;
	}
	
	/** Method to manage takings in the territories */
	public Boolean plunderTerritory(Player player){
		Boolean success = false;
		//TODO
		return success;
	}

	public String getActionType() {
		return actionType;
	}


}