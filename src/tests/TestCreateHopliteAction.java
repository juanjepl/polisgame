package tests;

import game.CreateHopliteAction;
import game.Player;
import game.Polis;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class TestCreateHopliteAction {
	@Mock Player mockPlayer;
	@Mock Polis mockPolis;
	
		Player mockNullPlayer;
		Polis mockNullPolis;
		String chosenResourceMetal;
		String chosenResourceSilver;
	/**we need the following cases: silver less than 5, player 
	 * and/or polis equals null checking results with assert and
	 * expected */
		
		@Before
		public void setup(){
			mockNullPlayer=null;
			mockNullPolis=null;
			chosenResourceMetal="Metal";
			chosenResourceSilver="Silver";
			MockitoAnnotations.initMocks(this);
		}
		@Test(expected=IllegalArgumentException.class)
		public void testCreateHopliteActionPlayerWithoutSilver(){
			mockPlayer.setSilver(0);
			CreateHopliteAction cp=new CreateHopliteAction(mockPlayer, mockPolis,chosenResourceSilver);
			assert(cp.getPlayer().getSilver()==0);
		}
		@Test(expected=IllegalArgumentException.class)
		public void testCreateHopliteActionPlayerWithoutMetal(){
			mockPlayer.setMetal(0);
			CreateHopliteAction cp=new CreateHopliteAction(mockPlayer, mockPolis,chosenResourceMetal);
			assert(cp.getPlayer().getMetal()==0);
		}
		
		@Test(expected=IllegalArgumentException.class)
		public void testCreateHopliteActionNullPlayer(){
			CreateHopliteAction cp=new CreateHopliteAction(mockNullPlayer, mockPolis,chosenResourceMetal);
			assert(cp.getPlayer()==mockNullPlayer);
			assert(cp.getPolis()==mockPolis);
		}
		@Test(expected=IllegalArgumentException.class)
		public void testCreateHopliteActionNullPolis(){
			mockPlayer.setMetal(1);
			CreateHopliteAction cp=new CreateHopliteAction(mockPlayer,mockNullPolis,chosenResourceMetal);
			assert(cp.getPlayer()==mockPlayer);
			assert(cp.getPolis()==mockNullPolis);
		}
		

}
