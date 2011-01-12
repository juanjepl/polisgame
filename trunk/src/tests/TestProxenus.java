package tests;

import game.Player;
import game.Position;
import game.Proxenus;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class TestProxenus {

	@Mock	Player mockPlayer;
	@Mock	Position mockPosition;
	
	        Player mockNullPlayer;
	        Position mockNullPosition;
		
	@Before
	public void setup()
	{
		mockNullPlayer = null;
		mockNullPosition = null;
		MockitoAnnotations.initMocks(this);
		
	}
	
	@Test
	public void testProxenusCreation()
	{
		Proxenus u = new Proxenus(mockPlayer, mockPosition);
		assert(u.getOwner() == mockPlayer);
		assert(u.getPosition() == mockPosition);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testNullProxenusCreation()
	{
		Proxenus u = new Proxenus(mockNullPlayer, mockNullPosition);
		assert(u.getOwner() == mockNullPlayer);
		assert(u.getPosition() == mockNullPosition);
	}

}
