package navigation;

import game.Position;

/** This class represents a vertex, used like base component by Graph class */
public class Vertex<P extends Position>{
    
	private P vertexReference;
    private Integer weight;
    
    public Vertex(P vertexReference){
        this.vertexReference = vertexReference;
    }
    
    public Position getVertexReference(){
        return vertexReference;
    }
    
    public Integer getWeight()
    {
    	return weight;
    }
    
    public void setWeight(Integer weight)
    {
    	this.weight = weight;
    }

}
