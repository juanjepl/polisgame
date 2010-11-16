package game;

import java.util.List;
import java.util.Set;

/** This class represents a vertex, used like base component by Graph class */
public class Vertex<P extends Position> {
    
    private List<P> vertexReference;
    private Set<Vertex<P>> adjacents; // The group of all adjacents vertex to this vertex
    
    public Vertex( List<P> vertexReference, Set<Vertex<P>> adjacents){
        this.vertexReference = vertexReference;
        this.adjacents = adjacents;
    }
    
    public List<P> getVertexReference(){
        return vertexReference;
    }
    
    public Set<Vertex<P>> getAdjacents(){
        return adjacents;
    }

}
