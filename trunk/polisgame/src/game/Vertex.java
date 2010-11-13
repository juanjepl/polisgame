package game;

import java.util.Set;

/** This class represents a vertex, used like base component by Graph class */
public class Vertex {
	
	private String vertexName;
	private Set<Vertex> adjacents; // The group of all adjacents vertex to this vertex
	
	public Vertex(String vertexName, Set<Vertex> adjacents){
		this.vertexName = vertexName;
		this.adjacents = adjacents;
	}
	
	public String getVertexName(){
		return vertexName;
	}
	
	public Set<Vertex> getAdjacents(){
		return adjacents;
	}

}
