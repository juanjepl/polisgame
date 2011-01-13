package tests;


import game.EndGameCheckNoPrestige;
import game.Game;
import game.Player;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


public class TestEndGameCheckNoPrestige {
	@Mock Game mockGame;
	@Mock Player mockPlayer;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	@After
	public void tearDown() throws Exception {

	}
	
	@Test
	public void EndGameChecknoPrestigeCreation(){
		EndGameCheckNoPrestige m = new EndGameCheckNoPrestige(mockGame, mockPlayer);
		assert (m.getGame().equals(mockGame));
		assert (m.getPlayer().equals(mockPlayer));
		
	}
}
