package game;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestGameEvent {
	String sysName;
	String name;
	String text;
	String round;

	@Before
	public void setup() {
		sysName = "sysName";
		name = "name";
		text = "text";
		round = "3";

	}

	@After
	public void tearDown() throws Exception {

	}
	
	
	@Test
	public void testGameEventCreation(){
	
		GameEvent gE = new GameEvent(sysName, name, text, round);
		assert(gE.getName().equals(name));
		assert (gE.getSysName().equals(sysName));
		assert(gE.getRound().equals(round));
		
		
	}
	
	@Test(expected = NullPointerException.class)
	public void testGameEventNull(){
		GameEvent gE = new GameEvent(null, null, null, null);
		assert(gE.getName().equals(name));
		assert (gE.getSysName().equals(sysName));
		assert(gE.getRound().equals(round));
		
		
	}
}
