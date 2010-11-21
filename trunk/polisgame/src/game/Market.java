package game;

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
}