package game;

import java.util.List;
import java.util.Map;

/** This class is used to calculate unit movements on the game map */
public class Graph{

	private Map<Vertex<? extends Position>, List<Vertex<? extends Position>>> graph; // They're all vertex of this graph

	
	public Graph(Map<Vertex<? extends Position>, List<Vertex<? extends Position>>> graph){
		this.graph = graph;
	}

	public Map<Vertex<? extends Position>, List<Vertex<? extends Position>>> getGraph(){
		return graph;
	}
	
}
