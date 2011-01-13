package tests;

import game.CreateTradeBoatAction;
import game.Player;
import game.Polis;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class TestCreateTradeBoatAction {
	@Mock Player mockPlayer;
	@Mock Polis mockPolis;
	
		Player mockNullPlayer;
		Polis mockNullPolis;
		String chosenResourceWood;
		String chosenResourceSilver;
	/**we need the following cases: silver less than 5, player 
	 * and/or polis equals null checking results with assert and
	 * expected */
		
		@Before
		public void setup(){
			mockNullPlayer=null;
			mockNullPolis=null;
			chosenResourceWood="Wood";
			chosenResourceSilver="Silver";
			MockitoAnnotations.initMocks(this);
		}
		@Test(expected=IllegalArgumentException.class)
		public void testCreateTradeBoatActionPlayerWithoutSilver(){
			mockPlayer.setSilver(0);
			CreateTradeBoatAction cp=new CreateTradeBoatAction(mockPlayer, mockPolis,chosenResourceSilver);
			assert(cp.getPlayer().getSilver()==0);
		}
		@Test(expected=IllegalArgumentException.class)
		public void testCreateTradeBoatActionPlayerWithoutWood(){
			mockPlayer.setWood(0);
			CreateTradeBoatAction cp=new CreateTradeBoatAction(mockPlayer, mockPolis,chosenResourceSilver);
			assert(cp.getPlayer().getWood()==0);
		}
		
		@Test(expected=IllegalArgumentException.class)
		public void testCreateTrirremeActionNullPlayer(){
			CreateTradeBoatAction cp=new CreateTradeBoatAction(mockNullPlayer, mockPolis,chosenResourceSilver);
			assert(cp.getPlayer()==mockNullPlayer);
			assert(cp.getPolis()==mockPolis);
		}
		@Test(expected=IllegalArgumentException.class)
		public void testCreateTrirremeActionNullPolis(){
			mockPlayer.setWood(1);
			CreateTradeBoatAction cp=new CreateTradeBoatAction(mockPlayer, mockNullPolis,chosenResourceSilver);
			assert(cp.getPlayer()==mockPlayer);
			assert(cp.getPolis()==mockNullPolis);
		}
}
