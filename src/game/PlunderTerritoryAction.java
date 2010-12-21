package game;

import java.util.Map;

/**
 * This class manages Territories plunders
 */
public class PlunderTerritoryAction extends MilitaryAction{
	
	private Player player;
	private Territory territoryToPlunder;
	private Map<String, Integer> choosenOptionsToPlunderByPlayer;
	
	public PlunderTerritoryAction(Player pl, Territory terr, Map<String, Integer> exactlyPlunder){
		super();

		if(pl == null || terr == null || exactlyPlunder == null){
			throw new IllegalArgumentException("Invalid parameter at PlunderTerritoryAction");
		}
		
		player = pl;
		territoryToPlunder = terr;
		choosenOptionsToPlunderByPlayer = exactlyPlunder;
		
		// Plunder territory where is your Capital polis, not costs prestige points.
		if(!(territoryToPlunder.equals(getPlayer().getCapital().getPolisParentTerritory()))){
			getPlayer().setPrestige(getPlayer().getPrestige() - 1);
		}
		
		
		for(String resource : getChoosenOptionsToPlunderByPlayer().keySet()){
			// To modify hoplites positions
			Integer count = 0;
			for(Hoplite hop : getTerritoryToPlunder().getHoplitesForAPlayer(getPlayer())){
				if(count < getChoosenOptionsToPlunderByPlayer().get(resource)){
					getPlayer().removeUnit(hop); // Only while plunder units stay inside, to "disable" them
					hop.setPosition(getTerritoryToPlunder());
					getTerritoryToPlunder().removeUnit(hop);
					getTerritoryToPlunder().addPlunderUnit(hop);
					count += 1;
				}else{
					break; // only breaks inner loop
				}
			}
			
			// Resource "extraction"
			Integer slotsOfResourcePlundered = getChoosenOptionsToPlunderByPlayer().get(resource);
			Integer amountObtainedOfResource = getTerritoryToPlunder().getResources().get(resource).get(slotsOfResourcePlundered - 1); // -1 because list first position is '0' not '1'
			getPlayer().setResource(resource, getPlayer().getResource(resource) + amountObtainedOfResource);
		}
		getTerritoryToPlunder().setPlundered(true);
	}
	
	/**
	 * Getters for class attributes
	 */
	
	public Player getPlayer() {
		return player;
	}

	public Territory getTerritoryToPlunder() {
		return territoryToPlunder;
	}

	public Map<String, Integer> getChoosenOptionsToPlunderByPlayer() {
		return choosenOptionsToPlunderByPlayer;
	}
}