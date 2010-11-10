package game;

import java.util.Set;

public class Vertex {
	
	private String name;
	
	private Set<Vertex> adyacents;
	
	public Vertex(String name, Set<Vertex>adyacents)
	{
		this.name = name;
		this.adyacents = adyacents;
	}
	
	public String getName()
	{
		return name;
	}
	
	public Set<Vertex> getAdyacents()
	{
		return adyacents;
	}

}
