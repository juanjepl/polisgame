package tests;

import game.Player;
import game.CivilWarAction;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
public class TestCivilWarAction {
	Player mockNullPlayer;
	@Before
	public void Setup(){
		mockNullPlayer=null;
		MockitoAnnotations.initMocks(this);
	}
	@Test(expected=IllegalArgumentException.class)
	public void TestCivilWarActionNullPlayer(){
		CivilWarAction cw=new CivilWarAction(mockNullPlayer);
		assert(cw.getPlayer().equals(mockNullPlayer));
	}
}
