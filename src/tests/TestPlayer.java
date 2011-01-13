package tests;

import game.Player;

import org.junit.Before;
import org.junit.Test;


public class TestPlayer {

	String name;
		
	@Before
	public void setup()
	{
		name="Marsé";
		
	}
	
	@Test
	public void testPlayerCreation()
	{
		Player u = new Player(name);
		assert(u.getName().equals(name));
	}
		
	@Test(expected=IllegalArgumentException.class)
	public void testNullPlayerCreation()
	{
		Player u = new Player(null);
		assert(u.getName().equals(null));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSetName()
	{
		Player u = new Player(name);
		u.setName("MariJose");
		assert(u.getName().equals("MariJose"));
	}

}
