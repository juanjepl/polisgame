package tests;

import game.CreateTrirremeAction;
import game.Player;
import game.Polis;
import game.Sea;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class TestCreateTrirremeAction {
	@Mock Player mockPlayer;
	@Mock Polis mockPolis;
	@Mock Sea mockSea;
		Sea mockNullSea;
		Player mockNullPlayer;
		Polis mockNullPolis;
		String chosenResourceWood;
		String chosenResourceSilver;
	/**we need the following cases: silver less than 5, player 
	 * and/or polis equals null checking results with assert and
	 * expected */
		
		@Before
		public void setup(){
			mockNullSea=null;
			mockNullPlayer=null;
			mockNullPolis=null;
			chosenResourceWood="Wood";
			chosenResourceSilver="Silver";
			MockitoAnnotations.initMocks(this);
		}
		@Test(expected=IllegalArgumentException.class)
		public void testCreateTrirremeActionPlayerWithoutSilver(){
			mockPlayer.setSilver(0);
			CreateTrirremeAction cp=new CreateTrirremeAction(mockPlayer, mockPolis,mockSea,chosenResourceSilver);
			assert(cp.getPlayer().getSilver()==0);
		}
		@Test(expected=IllegalArgumentException.class)
		public void testCreateTrirremeActionPlayerWithoutWood(){
			mockPlayer.setWood(0);
			CreateTrirremeAction cp=new CreateTrirremeAction(mockPlayer, mockPolis,mockSea,chosenResourceWood);
			assert(cp.getPlayer().getWood()==0);
		}
		
		@Test(expected=IllegalArgumentException.class)
		public void testCreateTrirremeActionNullPlayer(){
			CreateTrirremeAction cp=new CreateTrirremeAction(mockNullPlayer, mockPolis,mockSea,chosenResourceWood);
			assert(cp.getPlayer()==mockNullPlayer);
			assert(cp.getPolis()==mockPolis);
			assert(cp.getChoosenSeaToPutTrirreme()==mockSea);
		}
		@Test(expected=IllegalArgumentException.class)
		public void testCreateTrirremeActionNullPolis(){
			mockPlayer.setWood(1);
			CreateTrirremeAction cp=new CreateTrirremeAction(mockPlayer,mockNullPolis,mockSea,chosenResourceWood);
			assert(cp.getPlayer()==mockPlayer);
			assert(cp.getPolis()==mockNullPolis);
			assert(cp.getChoosenSeaToPutTrirreme()==mockSea);
		}
		@Test(expected=IllegalArgumentException.class)
		public void testCreateTrirremeActionNullSea(){
			CreateTrirremeAction cp=new CreateTrirremeAction(mockPlayer, mockPolis,mockNullSea,chosenResourceWood);
			assert(cp.getPlayer()==mockPlayer);
			assert(cp.getPolis()==mockPolis);
			assert(cp.getChoosenSeaToPutTrirreme()==mockNullSea);
		}

}
