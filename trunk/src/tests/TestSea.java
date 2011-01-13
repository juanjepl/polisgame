package tests;


import game.Sea;
import org.junit.Before;
import org.junit.Test;


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
