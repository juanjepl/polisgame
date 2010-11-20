package game;

import java.util.List;
import java.util.Map;

/** This class is used to calculate unit movements on the game map */
public class Graph<P extends Position>{

	private Map<P,List<P>> graph; // They're all vertex of this graph

	
	public Graph(Map<P,List<P>> graph){
		this.graph = graph;
	}

	public Map<P,List<P>> getGraph(){
		return graph;
	}
	
}
