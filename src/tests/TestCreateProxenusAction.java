package tests;

import game.Player;
import game.Polis;
import game.CreateProxenusAction;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class TestCreateProxenusAction {
	@Mock Player mockPlayer;
	@Mock Polis mockPolis;
	
		Player mockNullPlayer;
		Polis mockNullPolis;
	/**we need the following cases: silver less than 5, player 
	 * and/or polis equals null checking results with assert and
	 * expected */
		
		@Before
		public void setup(){
			mockNullPlayer=null;
			mockNullPolis=null;
			MockitoAnnotations.initMocks(this);
		}
		@Test
		public void testCreateProxenusActionPlayerWithoutSilver(){
			mockPlayer.setSilver(4);
			CreateProxenusAction cp=new CreateProxenusAction(mockPlayer, mockPolis);
			assert(cp.getPlayer().getSilver()==4);
			assert(cp.getPlayer().getPlayerProxenus()==null);
		}
		@Test(expected=IllegalArgumentException.class)
		public void testCreateProxenusActionNullPlayer(){
			CreateProxenusAction cp=new CreateProxenusAction(mockNullPlayer, mockPolis);
			assert(cp.getPlayer()==mockNullPlayer);
			assert(cp.getPolis()==mockPolis);
		}
		@Test(expected=IllegalArgumentException.class)
		public void testCreateProxenusActionNullPolis(){
			CreateProxenusAction cp=new CreateProxenusAction(mockPlayer,mockNullPolis);
			assert(cp.getPlayer()==mockPlayer);
			assert(cp.getPolis()==mockNullPolis);
		}
		
}
