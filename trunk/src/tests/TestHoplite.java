package tests;

import game.Hoplite;
import game.Player;
import game.Position;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class TestHoplite {

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
	public void testHopliteCreation()
	{
		Hoplite u = new Hoplite(mockPlayer, mockPosition);
		assert(u.getOwner() == mockPlayer);
		assert(u.getPosition() == mockPosition);
	}
		
	@Test(expected=IllegalArgumentException.class)
	public void testNullHopliteCreation()
	{
		//Checks if Unit throws IllegalArgumentExceptions for null parameters
		Hoplite u = new Hoplite(mockNullPlayer, mockNullPosition);
		assert(u.getOwner() == mockNullPlayer);
		assert(u.getPosition() == mockNullPosition);
		
	}

}
