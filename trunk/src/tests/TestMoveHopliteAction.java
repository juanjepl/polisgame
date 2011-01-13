package tests;
import game.Round;
import game.MoveHopliteAction;
import game.Player;
import game.Territory;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
public class TestMoveHopliteAction {
	@Mock Player mockPlayer;
	@Mock Territory mockInitialTerritory;
	@Mock Territory mockEndTerritory;
	@Mock Round mockRound;
		Player mockNullPlayer;
		Territory mockNullInitialTerritory;
		Territory mockNullEndTerritory;
		Integer numOfUnits;
		Boolean multiMovement;
	@Before
	public void Setup(){
		mockNullEndTerritory=null;
		mockNullInitialTerritory=null;
		mockNullPlayer=null;
		MockitoAnnotations.initMocks(this);
		numOfUnits=4;
		multiMovement=true;
	}
	@Test
	public void TestMoveHopliteActionPlayerWithoutPrestige(){
		mockPlayer.setPrestige(0);
		MoveHopliteAction move=new MoveHopliteAction(mockPlayer, mockRound, mockInitialTerritory, mockEndTerritory, numOfUnits, multiMovement);
		assert(move.getPlayer().getPrestige()==0);
	}
	@Test(expected=IllegalArgumentException.class)
	public void TestMoveHopliteActionNullPlayer(){
		MoveHopliteAction move=new MoveHopliteAction(mockNullPlayer, mockRound, mockInitialTerritory, mockEndTerritory, numOfUnits, multiMovement);
		assert(move.getPlayer().equals(mockNullPlayer));
	}
	@Test(expected=IllegalArgumentException.class)
	public void TestMoveHopliteActionWithNumOfUnitsLessThanZero(){
		numOfUnits=-1;
		MoveHopliteAction move=new MoveHopliteAction(mockNullPlayer, mockRound, mockInitialTerritory, mockEndTerritory, numOfUnits, multiMovement);
		assert(move.getEndTerritory().getHoplitesForAPlayer(move.getPlayer()).size()>=0);
	}
	@Test(expected=IllegalArgumentException.class)
	public void TestMoveHopliteActionNullEndTerritory(){
		MoveHopliteAction move=new MoveHopliteAction(mockNullPlayer, mockRound, mockInitialTerritory, mockNullEndTerritory, numOfUnits, multiMovement);
		assert(move.getEndTerritory().equals(null));
	}
	@Test(expected=IllegalArgumentException.class)
	public void TestMoveHopliteActionNullInitialTerritory(){
		MoveHopliteAction move=new MoveHopliteAction(mockNullPlayer, mockRound, mockNullInitialTerritory, mockEndTerritory, numOfUnits, multiMovement);
		assert(move.getInitialTerritory().equals(null));
	}
}
