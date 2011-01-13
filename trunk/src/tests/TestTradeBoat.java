package tests;

import game.Player;
import game.Position;
import game.TradeBoat;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class TestTradeBoat {

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
		TradeBoat u = new TradeBoat(mockPlayer, mockPosition);
		assert(u.getOwner() == mockPlayer);
		assert(u.getPosition() == mockPosition);
	}
		
	@Test(expected=IllegalArgumentException.class)
	public void testNullTradeBoatCreation()
	{
		//Checks if Unit throws IllegalArgumentExceptions for null parameters
		TradeBoat u = new TradeBoat(mockNullPlayer, mockNullPosition);
		assert(u.getOwner() == mockNullPlayer);
		assert(u.getPosition() == mockNullPosition);
		
	}

}
