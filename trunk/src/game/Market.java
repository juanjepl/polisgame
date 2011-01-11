package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/** Market position class */
public class Market extends Sea{
	
	private Map<String, Map<String,Integer>> resources; // Resources contained in this market
	
	public Market(String sysName,String name, Map<String, Map<String, Integer>> resources){ // uses Position constructor and also its own
		super(sysName,name);
		this.resources = resources;
	}
	
	/** this method trades resource1 with resource2 and return an integer value of resource2 */
	public Integer tradeResources(String resource1, String resource2){
		
		if(resources.containsKey(resource1)){
			return resources.get(resource1).get(resource2);
		} else {
			return -1;
		}
	}
	
	public String getAssociatedResource(String resource, Integer amountResource)
	{
		String associated = null;
		for(String resource1: resources.keySet())
		{
			Map<String, Integer> resource2List = resources.get(resource1);
			if(resource2List.containsKey(resource) && resource2List.containsValue(amountResource))
			{
				associated = resource1;
				break;
			}
		}
		return associated;
	}
	
	public List<String> getListOfAvailableResources(String resource2)
	{
		List<String> list= new ArrayList<String>();
		
		for(String resource1: resources.keySet())
		{
			Map<String, Integer> resource2List = resources.get(resource1);
			if(resource2List.containsKey(resource2))
			{
				list.add(resource1);
				break;
			}
		}
		
		return list;
	}
	
	public Map<String, Map<String, Integer>> getResources()
	{
		return resources;
	}
}
