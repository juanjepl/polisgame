package game;

import java.util.List;
import java.util.Map;


public class Market extends Sea{
	
	private Map<String, Map<String,Integer>> resources;
	
	public Market(String sysName,String name, Map<String, Map<String, Integer>> resources){
		super(sysName,name);
		
		this.resources = resources;
		
	}
	
	public Integer tradeResources(String resource1, String resource2)
	{
		//this method trades resource1 with resource2 and return an integer value of resource2
		if(resources.containsKey(resource1))
		{
			return resources.get(resource1).get(resource2);
		} else {
			return -1;
		}
	}

	
}
