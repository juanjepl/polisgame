package tests;
import java.util.HashMap;
import java.util.Map;

import game.Player;
import game.Territory;
import game.PlunderTerritoryAction;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
public class TestPlunderTerritoryAction {
	@Mock Player mockPlayer;
	@Mock Territory mockTerritory;
	Map<String,Integer>chosenResourcesToPlunder;
	Map<String,Integer>chosenResourcesToPlunderNull;
	Player mockNullPlayer;
	Territory mockNullTerritory;
	
	@Before
	public void Setup(){
		chosenResourcesToPlunder=new HashMap<String, Integer>();
		chosenResourcesToPlunderNull=null;
		MockitoAnnotations.initMocks(this);
	}
	@Test(expected=IllegalArgumentException.class)
	public void TestPlunderTerritoryActionNullPlayer(){
		PlunderTerritoryAction pta=new PlunderTerritoryAction(mockNullPlayer, mockTerritory, chosenResourcesToPlunder);
		assert(pta.getPlayer().equals(mockNullPlayer));
	}
	@Test(expected=IllegalArgumentException.class)
	public void TestPlunderTerritoryActionNullTerritory(){
		PlunderTerritoryAction pta=new PlunderTerritoryAction(mockPlayer, mockNullTerritory, chosenResourcesToPlunder);
		assert(pta.getTerritoryToPlunder().equals(mockNullTerritory));
	}
	@Test(expected=IllegalArgumentException.class)
	public void TestPlunderTerritoryActionNullResourcesToPlunder(){
		PlunderTerritoryAction pta=new PlunderTerritoryAction(mockPlayer, mockTerritory, chosenResourcesToPlunderNull);
		assert(pta.getChoosenOptionsToPlunderByPlayer().equals(chosenResourcesToPlunderNull));
	}
}
