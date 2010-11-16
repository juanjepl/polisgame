package game;

import java.util.List;
import java.util.Set;

/** This class represents a vertex, used like base component by Graph class */
public class Vertex{
    
    private List<String> vertexReference;
    private Set<Vertex> adjacents; // The group of all adjacents vertex to this vertex
    
    public Vertex( List<String> vertexReference, Set<Vertex> adjacents){
        this.vertexReference = vertexReference;
        this.adjacents = adjacents;
    }
    
    public List<String> getVertexReference(){
        return vertexReference;
    }
    
    public Set<Vertex> getAdjacents(){
        return adjacents;
    }

}
