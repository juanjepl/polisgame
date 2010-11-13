package game;

import java.util.List;

/** This class is used to calculate unit movements on the game map */
public class Graph {

	private List<Vertex> graph; // They're all vertex of this graph
	
	
	public Graph(List<Vertex> graph){
		this.graph = graph;
	}
	
	public List<Vertex> getGraph(){
		return graph;
	}
}
