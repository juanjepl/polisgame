package tests;

import game.BattleManager;
import game.Player;
import game.Position;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


public class TestBattleManager {

	@Mock
	Player mockSparta;
	@Mock
	Player mockAthens;
	@Mock
	Position mockPosition;
	@Mock
	Player mockPlayer;
	@Mock BattleManager m;
	
	Player mockNullPlayer;
	Position mockNullPosition;
	
	@Before
	public void setup() {
		mockNullPlayer = null;
		mockNullPosition = null;
		
		MockitoAnnotations.initMocks(this);

	}
	@After
	public void tearDown() throws Exception {
		
	}
	@Test
	public void testBattleManagerCreation() {
		BattleManager m = new BattleManager(mockSparta, mockAthens, mockPosition);

		assert(m.getAthens().equals(mockAthens));
		assert(m.getSparta().equals(mockSparta));
		assert(m.getPosition().equals(mockPosition));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNullPlayerSparta() {
		BattleManager m = new BattleManager(null, mockAthens, mockPosition);

		assert(m.getAthens().equals(mockAthens));
		assert(m.getSparta().equals(mockSparta));
		assert(m.getPosition().equals(mockPosition));
		
	}
	@Test(expected = IllegalArgumentException.class)
	public void testNullPlayerAthens() {
		BattleManager m = new BattleManager(mockSparta, null, mockPosition);

		assert(m.getAthens().equals(mockAthens));
		assert(m.getSparta().equals(mockSparta));
		assert(m.getPosition().equals(mockPosition));
		
	}
	@Test(expected = IllegalArgumentException.class)
	public void testNullPosition() {
		BattleManager m = new BattleManager(mockSparta, mockAthens, null);

		assert(m.getAthens().equals(mockAthens));
		assert(m.getSparta().equals(mockSparta));
		assert(m.getPosition().equals(mockPosition));
	}
	
//	@Test(expected = NullPointerException.class)
//	public void testAssaultAvailible() {
//		//BattleManager m = new BattleManager(mockSparta, mockAthens, mockPosition);
//		
//		when(m.assaultAvailable()).thenReturn(true);
//		
//		assert(m.getAthens().equals(mockAthens));
//		assert(m.getSparta().equals(mockSparta));
//		assert(m.getPosition().equals(mockPosition));
//		
//	}


}
