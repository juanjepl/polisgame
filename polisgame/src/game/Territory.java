package game;

import java.util.Map;
import java.util.Vector;


public class Territory extends Position{

	private Map<String,Vector<Integer>> resources;
	private Boolean plundered;
	
	public Territory(String sysName,String name, Map<String,Vector<Integer>> resources){
		super(sysName,name);
		this.resources = resources;
		this.plundered = false;
		
	}

	public Boolean getPlundered() {
		return plundered;
	}

	public void setPlundered(Boolean plundered) {
		this.plundered = plundered;
	}

	public Map<String, Vector<Integer>> getResources() {
		return resources;
	}
	
}
