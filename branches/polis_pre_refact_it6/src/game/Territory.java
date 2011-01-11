package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/** Territory positions class */
public class Territory extends Position{

	private Map<String,Vector<Integer>> resources;
	private List<Unit> plundersUnits;
	private Boolean plundered;
	
	public Territory(String sysName,String name, Map<String,Vector<Integer>> resources){ 
		super(sysName,name); // for this 2 attributes calls the position constructor
		this.resources = resources;
		plundered = false; // by default, territory's resources aren't plundered
		plundersUnits = new ArrayList<Unit>();
	}
	
	/** Getters and setters */

	public Boolean getPlundered() {
		return plundered;
	}

	public void setPlundered(Boolean plundered) {
		this.plundered = plundered;
	}

	public Map<String, Vector<Integer>> getResources() {
		return resources;
	}
	
	public List<Unit> getPlundersUnits()
	{
		return plundersUnits;
	}
	
	public void emptyPlundersUnits()
	{
		plundersUnits = null;
	}
	
	public void addPlunderUnit(Unit u)
	{
		plundersUnits.add(u);
	}
	
}
