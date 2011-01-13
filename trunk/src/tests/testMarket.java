package tests;

import game.Market;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class testMarket {

	String sysName;
	String name;
	Map<String, Map<String, Integer>> resources;

	@Before
	public void setup() {
		sysName = "SysName";
		name = "name";
		resources = new HashMap<String, Map<String, Integer>>();
		Map<String, Integer> alternativeMap = new HashMap<String, Integer>();
		alternativeMap.put("wine", 3);
		resources.put("egypt", alternativeMap);

	}
	@After
	public void tearDown() throws Exception {

	}
	
	@Test 
	public void testMarketCreation(){
		Market mk = new Market(sysName, name, resources);
		assert(mk.getName().equals(name));
		assert(mk.getSysName().equals(sysName));
		assert(mk.getResources().equals(resources));
		
	}
	@Test (expected = IllegalArgumentException.class)
	public void testMarketCreationNullSysname(){
		Market mk = new Market(null, name, resources);
		assert(mk.getName().equals(name));
		assert(mk.getSysName().equals(sysName));
		assert(mk.getResources().equals(resources));
		
	}
	@Test (expected = IllegalArgumentException.class)
	public void testMarketCreationNullName(){
		Market mk = new Market(sysName, null, resources);
		assert(mk.getName().equals(name));
		assert(mk.getSysName().equals(sysName));
		assert(mk.getResources().equals(resources));
		
	}
	@Test (expected = NullPointerException.class)
	public void testMarketCreationNullResources(){
		Market mk = new Market(sysName, name, null);
		assert(mk.getName().equals(name));
		assert(mk.getSysName().equals(sysName));
		assert(mk.getResources().equals(resources));
		
	}
	
	
}
