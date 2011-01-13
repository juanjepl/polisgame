package tests;

import game.Hoplite;
import game.Player;
import game.Position;
import game.Sea;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class TestSea {

	String sysName;
	String name;
	
	String nullSysName;
	String nullName;

		
	@Before
	public void setup()
	{
		nullSysName = null;
		nullName = null;
		MockitoAnnotations.initMocks(this);
		sysName="jonico";
		name="Jonico";
	}
	
	@Test
	public void testSeaCreation()
	{
		Sea u = new Sea(sysName, name);
		assert(u.getSysName().equals(sysName));
		assert(u.getName().equals(name));
	}
		
	@Test(expected=IllegalArgumentException.class)
	public void testNullHopliteCreation()
	{
		Sea u = new Sea(nullSysName, nullName);
		assert(u.getSysName().equals(nullSysName));
		assert(u.getName().equals(nullName));
		
	}

}
