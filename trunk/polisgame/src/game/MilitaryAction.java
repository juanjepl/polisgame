package game;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Vector;

import ui.TextModeUi;

/** This class contains the methods for execute military actions in the game */
public class MilitaryAction extends GameAction{

	private final String actionType = "militaryAction"; // A constant to check action's type
	
	
	public MilitaryAction(){}
	
	
	/** To move an Hoplite or Hoplites group, to other position */
	public Boolean moveHoplite(Player player, Round round, Territory initialPosition, Territory finalPosition, Integer numberOfUnits, Boolean multiMovement){
		Boolean success = false;
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
			
			// Do not waste prestige if is 2nd movement of a multimovement for example
			if(!multiMovement){
				player.setPrestige(player.getPrestige()-1);
			}
			
			if(!(numberOfUnits>1)){
				TextModeUi.showMessage("Hoplite moved from "+initialPosition.getName()+" to "+finalPosition.getName());
			}else{
				TextModeUi.showMessage(numberOfUnits.toString()+" "+"Hoplites moved from "+initialPosition.getName()+" to "+finalPosition.getName());
			}
				
		}else{
			// Do nothing
		}

		return success;
	}
	
	/** To move a Trirreme or Trirremes group, to other sea */
	public Boolean moveTrirreme(Player player, Round round, Sea initialSea, Sea finalSea, Integer numberOfUnits,Boolean multiMovement) {
		if (round == null) throw new NullPointerException("'round' can not be null");
		if (player == null) throw new NullPointerException("'player' can not be null");
		if (initialSea == null) throw new NullPointerException("'initialSea' can not be null");
		if (finalSea == null) throw new NullPointerException("'finalSea' can not be null");
		if (numberOfUnits == null) throw new NullPointerException("'numberOfUnits' can not be null");
		
		Boolean success = AvailableActionsManager.checkMoveTrirremeAction(player, round, initialSea, finalSea, numberOfUnits);
		
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
					unit.setPosition(finalSea);
					unitMovedCount++;
				}
			}
			
			// Do not waste prestige if is 2nd movement of a multimovement for example
			if(!multiMovement){
				player.setPrestige(player.getPrestige() - 1);
			}
		}
		
		return success;
	}
	
	/** Method to manage polis's siegues */
	public Boolean siegePolis(Player player,Position initialPosition, Polis siegedPolis ){
		
		if (player == null) throw new NullPointerException("'player' can not be null");
		if (initialPosition == null) throw new NullPointerException("'initialPosition' can not be null");
		if (siegedPolis == null) throw new NullPointerException("'siegedPolis' can not be null");
		
		Boolean success = true;

		if(success)
		{
			
			Integer count = siegedPolis.getBasePopulation();
			List<Unit> unitsToRemove = new ArrayList<Unit>();
			for(Unit u: initialPosition.getUnits()){
				if(count > 0){
					if(u instanceof Hoplite && u.getOwner().equals(player)){
						unitsToRemove.add(u);
						siegedPolis.addUnit(u);
						u.setPosition(siegedPolis);
						count -= 1;
					}
					
				}else{
					break;
				}
			}
			
			initialPosition.removeGroupOfUnits(unitsToRemove); //removes nothing if empty (i cant remove a unit in initialposition while im looping in it (for)
			
			siegedPolis.setSieged(true);
			player.setPrestige(player.getPrestige() - 1);
			
			TextModeUi.showMessage(siegedPolis.getName()+" has been sieged by "+player.getName()); //FIXME from gametexts...
			
			success = false;
		}
			
		return success;
	}
	
	/** Method to manage takings in the territories */
	public Boolean plunderTerritory(Player player, Round round, Territory territory, Map<String, Integer> exactlyPlunder){
		
		if (player == null) throw new NullPointerException("'player' can not be null");
		if (territory == null) throw new NullPointerException("'territory' can not be null");
		
		Map<String, Integer> hoplites = exactlyPlunder;
		
		Integer troops = 0;
		for(Integer numHoplites: hoplites.values())
		{
			troops += numHoplites;
			
			//move hoplite to territory plundersUnits
			for(int i = 0; i < numHoplites; i++)
			{
				Unit u = territory.getUnits().remove(i);
				territory.setPlundersUnits(u);
				//remove from player's units because aren't disponible for a while
				player.getPlayerUnits().remove(u);
				
			}
		}
		
		Boolean success = false;
		
		Map<String, Vector<Integer>> resources = territory.getResources();
		
		for(String resource:hoplites.keySet())
		{
			Integer amount = hoplites.get(resource);
			
			Integer amountObtainedOfResource = resources.get(resource).get(amount);
			
			Integer amountOfResource = player.getResource(resource);
			amountOfResource += amountObtainedOfResource;
			player.setResource(resource, amountOfResource);
		}
		
		territory.setPlundered(true);
		//if is natal territory don't paid prestige 
		player.setPrestige(player.getPrestige() - 1);
		success = true;
		//FIXME cuando termina turno hay que devolver las unidades de nuevo a donde corresponden, eso se hace cuando se inicia turno!!
		
		//message
		for(String st : exactlyPlunder.keySet()){
			
			String toShow = "";
			
			if(st.equals("Metal")){
				toShow = "Metal"; //FIXME this metal from gametexts...
			}else if(st.equals("Wood")){
				toShow = "Madera"; //FIXME this metal from gametexts...
			}else if(st.equals("Oil")){
				toShow = "Aceite"; //FIXME this metal from gametexts...
			}else if(st.equals("Silver")){
				toShow = "Plata"; //FIXME this metal from gametexts...
			}else if(st.equals("Wine")){
				toShow = "Vino"; //FIXME this metal from gametexts...
			}else if(st.equals("Wheat")){
				toShow = "Trigo"; //FIXME this metal from gametexts...
			}else{
				throw new IllegalArgumentException("Territory with wrong value for resource");
			}
			
			TextModeUi.showMessage(toShow+": Obtained " + territory.getResources().get(st).get(exactlyPlunder.get(st)-1) +" unit(s)"); //FIXME from gametexts // -1 because 2 hoplites are position "1" (starts in 0)
		}
		
		
		return success;
	}

	public String getActionType() {
		return actionType;
	}


}