package game;

/** This class represents a vertex, used like base component by Graph class */
public class Vertex<P extends Position>{
    
	private P vertexReference;
    
    public Vertex(P vertexReference){
        this.vertexReference = vertexReference;
    }
    
    public Position getVertexReference(){
        return vertexReference;
    }

}
