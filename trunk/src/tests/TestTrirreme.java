package tests;

import game.Player;
import game.Position;
import game.Trirreme;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class TestTrirreme {

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
	public void testTrirremeCreation()
	{
		Trirreme u = new Trirreme(mockPlayer, mockPosition);
		assert(u.getOwner() == mockPlayer);
		assert(u.getPosition() == mockPosition);
	}
		
	@Test(expected=IllegalArgumentException.class)
	public void testNullTrirremeCreation()
	{
		Trirreme u = new Trirreme(mockNullPlayer, mockNullPosition);
		assert(u.getOwner() == mockNullPlayer);
		assert(u.getPosition() == mockNullPosition);
	}

}
