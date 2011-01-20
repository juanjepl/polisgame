package tests;
import game.Player;
import game.Polis;
import game.SiegePolisAction;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.Mock;
public class TestSiegePolisAction {
	@Mock Player mockPlayer;
	@Mock Polis mockPolis;
	Player nullPlayer;
	Polis nullPolis;
	@Before
	public void Setup(){
		nullPlayer=null;
		nullPolis=null;
		MockitoAnnotations.initMocks(this);
	}
	@Test(expected=IllegalArgumentException.class)
	public void TestSiegePolisActionPlayerNull(){
		SiegePolisAction spa=new SiegePolisAction(nullPlayer, mockPolis);
		assert(spa.getPlayer().equals(nullPlayer));
	}
	@Test(expected=IllegalArgumentException.class)
	public void TestSiegePolisActionPolisNull(){
		SiegePolisAction spa=new SiegePolisAction(mockPlayer, nullPolis);
		assert(spa.getPolisToSiege().equals(nullPolis));
	}
	@Test
	public void TestSiegePolisActionPlayerWithoutPrestige(){
		mockPlayer.setPrestige(0);
		SiegePolisAction spa=new SiegePolisAction(mockPlayer, mockPolis);
		assert(mockPlayer.getPrestige()==spa.getPlayer().getPrestige());
	}
	
}
