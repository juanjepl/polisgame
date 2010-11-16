package game;

import java.util.Set;

/** This class represents a vertex, used like base component by Graph class */
public class Vertex{
    
	private Position vertexReference;
    private Set<Vertex> adjacents; // The group of all adjacents vertex to this vertex
    
    public Vertex(Position vertexReference, Set<Vertex> adjacents){
        this.vertexReference = vertexReference;
        this.adjacents = adjacents;
    }
    
    public Position getVertexReference(){
        return vertexReference;
    }
    
    public Set<Vertex> getAdjacents(){
        return adjacents;
    }

}
