package navigation;

import game.Position;

import java.util.List;
import java.util.Map;

/** This class is used to calculate unit movements on the game map */
public class Graph{

	private Map<Vertex<? extends Position>, List<Vertex<? extends Position>>> mapGraph; // They're all vertex of this graph

	
	public Graph(Map<Vertex<? extends Position>, List<Vertex<? extends Position>>> graph){
		this.mapGraph = graph;
	}

	public Map<Vertex<? extends Position>, List<Vertex<? extends Position>>> getMapGraph(){
		return mapGraph;
	}
	
}
