package tests;
import game.Round;
import game.MoveTrirremeAction;
import game.Player;
import game.Sea;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
public class TestMoveTrirremeAction {
	@Mock Player mockPlayer;
	@Mock Sea mockInitialSea;
	@Mock Sea mockEndSea;
	@Mock Round mockRound;
		Player mockNullPlayer;
		Sea mockNullInitialSea;
		Sea mockNullEndSea;
		Integer numOfUnits;
		Boolean multiMovement;
	@Before
	public void Setup(){
		mockNullEndSea=null;
		mockNullInitialSea=null;
		mockNullPlayer=null;
		MockitoAnnotations.initMocks(this);
		numOfUnits=4;
		multiMovement=true;
	}
	@Test
	public void TestMoveTrirremeActionPlayerWithoutPrestige(){
		mockPlayer.setPrestige(0);
		MoveTrirremeAction move=new MoveTrirremeAction(mockPlayer, mockInitialSea, mockEndSea, numOfUnits, multiMovement);
		assert(move.getPlayer().getPrestige()==0);
	}
	@Test(expected=IllegalArgumentException.class)
	public void TestMoveTrirremeActionNullPlayer(){
		MoveTrirremeAction move=new MoveTrirremeAction(mockNullPlayer, mockInitialSea, mockEndSea, numOfUnits, multiMovement);
		assert(move.getPlayer().equals(mockNullPlayer));
	}
	@Test(expected=IllegalArgumentException.class)
	public void TestMoveTrirremeActionWithNumOfUnitsLessThanZero(){
		numOfUnits=-1;
		MoveTrirremeAction move=new MoveTrirremeAction(mockPlayer, mockInitialSea, mockEndSea, numOfUnits, multiMovement);
		assert(move.getEndSea().getTrirremesForAPlayer(move.getPlayer()).size()>=0);
	}
	@Test(expected=IllegalArgumentException.class)
	public void TestMoveTrirremeActionNullEndSea(){
		MoveTrirremeAction move=new MoveTrirremeAction(mockPlayer, mockInitialSea, mockNullEndSea, numOfUnits, multiMovement);
		assert(move.getEndSea().equals(null));
	}
	@Test(expected=IllegalArgumentException.class)
	public void TestMoveTrirremeActionNullInitialTerritory(){
		MoveTrirremeAction move=new MoveTrirremeAction(mockPlayer, mockNullInitialSea, mockEndSea, numOfUnits, multiMovement);
		assert(move.getInitialSea().equals(null));
	}
}
