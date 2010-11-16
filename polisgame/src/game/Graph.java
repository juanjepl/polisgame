package game;

import java.util.List;

/** This class is used to calculate unit movements on the game map */
public class Graph<P extends Position> {

	private List<Vertex<P>> graph; // They're all vertex of this graph
	
	
	public Graph(List<Vertex<P>> graph){
		this.graph = graph;
	}
	
	public List<Vertex<P>> getGraph(){
		return graph;
	}
}
