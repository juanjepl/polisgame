package game;

import java.util.List;
import java.util.ArrayList;

/**
 * This class manages in the end of each round,
 * if sieges made by player, turns into complete
 */
public class EndRoundCheckSieges {
	
	public EndRoundCheckSieges(Player p){
		if(p == null){
			throw new IllegalArgumentException("Invalid parameter for EndRoundCheckSieges() constructor, cannot be null");
		}
		// matar al proxeno enemigo si se completa un asedio estando el
		// neutrales automaticas
		// enemigas con bloqueo
		
		List<Polis> polisWhereIHaveASiege = new ArrayList<Polis>();
		
		//if you have hoplites in a polis, always are sieging it (game rules)
		for(Unit u : p.getPlayerUnits()){
			if((u instanceof Hoplite) && (u.getPosition() instanceof Polis) && !(polisWhereIHaveASiege.contains(u.getPosition()))){
				polisWhereIHaveASiege.add((Polis)u.getPosition());
			}
		}
				
		for(Polis po : polisWhereIHaveASiege){
			// case neutral
			if(po.getPolisOwner() == null){
				po.setPolisOwner(p);
				
				//TODO 
				
				
				
				
				
			}else{ // case enemy polis
				
				//TODO
				
			}
		
			
		}
	}
}