package game;

import java.util.List;


//this class initialize game map structure

public class Graph {

	private List<Vertex> graph;
	
	public Graph(List<Vertex> graph)
	{
		this.graph = graph;
	}
	
	public List<Vertex> getGraph()
	{
		return graph;
	}
}
