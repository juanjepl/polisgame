package tests;
import game.EndTurnCheckBattles;
import game.EndTurnManager;
import game.Game;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class TestEndTurnCheckBattles {
	@Mock Game mockGame;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	@After
	public void tearDown() throws Exception {

	}
	
	@Test
	public void testEndGameCheckBattles(){
		EndTurnManager endTurn = new EndTurnManager(mockGame);
		assert (endTurn.getGame().equals(mockGame));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNullGame(){
		EndTurnCheckBattles endBattle = new EndTurnCheckBattles(null);
		assert (endBattle.getGame().equals(mockGame));
	}
	
	

}
