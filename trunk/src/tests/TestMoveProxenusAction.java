package tests;
import game.Polis;
import game.MoveProxenusAction;
import game.Player;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
public class TestMoveProxenusAction {
	@Mock Player mockPlayer;
	@Mock Polis mockPolis;
	Player mockNullPlayer;
	Polis mockNullPolis;
	Integer mockPayForWay;
	
	@Before
	public void Setup(){
		mockNullPlayer=null;
		mockNullPolis=null;
		mockPayForWay=4;
		MockitoAnnotations.initMocks(this);
	}
	@Test(expected=IllegalArgumentException.class)
	public void TestMoveProxenusActionNullPlayer(){
		MoveProxenusAction move=new MoveProxenusAction(mockNullPlayer, mockPolis, mockPayForWay);
		assert(move.getPlayer().equals(mockNullPlayer));
	}
	@Test(expected=IllegalArgumentException.class)
	public void TestMoveProxenusActionNullDestiny(){
		MoveProxenusAction move=new MoveProxenusAction(mockPlayer, mockNullPolis, mockPayForWay);
		assert(move.getDestiny().equals(mockNullPolis));
	}
	@Test(expected=NullPointerException.class)
	public void TestMoveProxenusActionPayForWayLessThanZero(){
		mockPayForWay=-1;
		MoveProxenusAction move=new MoveProxenusAction(mockPlayer, mockPolis, mockPayForWay);
		assert(mockPlayer.getSilver()>move.getPlayer().getSilver());
	}
	
	}
