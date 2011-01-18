package navigation;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import game.Player;
import game.Position;

public abstract class GenericGraphNavigator {

	private Player player;
	private Position position1;
	private Position position2;
	protected Boolean exists;
	protected Graph graph;
	
	public GenericGraphNavigator(Player player, Position position1, Position position2){
		
		if(player == null){
			throw new IllegalArgumentException("Player musn't be null");
		}
		if(position1 == null){
			throw new IllegalArgumentException("Position1 musn't be null");
		}
		if(position2 == null){
			throw new IllegalArgumentException("Position2 musn't be null");
		}
		
		this.player = player;
		this.position1 = position1;
		this.position2 = position2;
		this.exists = false;
		
		
	}
	
	protected void existsWay()
	{
		if(getPosition1().getSysName().equals(getPosition2().getSysName())){
			exists = false;
		} 
		else {
			
			Set<Vertex<? extends Position>> searchInGraph = getGraph().getMapGraph().keySet();
			
			Vertex<? extends Position> v = null;
			Vertex<? extends Position> v2 = null;
			
			for(Vertex<? extends Position> vertex: searchInGraph)
			{
	
				if(vertex.getVertexReference().getSysName().equals(getPosition1().getSysName()))
				{
					v = vertex;
				}else if(vertex.getVertexReference().getSysName().equals(getPosition2().getSysName()))
				{
					v2 = vertex;
				}
			}
			
			//Get adjacents of v vertex
			List<Vertex<? extends Position>> initialPositionAdjacents = getGraph().getMapGraph().get(v);
	
			List<Vertex<? extends Position>> visited = new ArrayList<Vertex<? extends Position>>();
			List<Vertex<? extends Position>> queue = new ArrayList<Vertex<? extends Position>>();
			
			for(Vertex<? extends Position> vertex: initialPositionAdjacents)
			{
				
				if(!vertex.getVertexReference().getLockForAPlayer(getPlayer()))
				{
						queue.add(vertex);
				}else
				{
					visited.add(vertex);
				}
				
			}
			
			visited.add(v);
			
			while(!queue.isEmpty() && !exists)
			{
				//extract first vertex
				Vertex<? extends Position> element = queue.remove(0);
				//get adjacents of element and check if exists in visited
				List<Vertex<? extends Position>> adjacents = getGraph().getMapGraph().get(element);
				visited.add(element);
				
				for(Vertex<? extends Position> vertex: adjacents)
				{
					//check if vertex isn't locked and isn't visited
					if(!vertex.getVertexReference().getLockForAPlayer(getPlayer()) && !visited.contains(vertex))
					{
							//add vertex to queue
							queue.add(vertex);
							
							//System.out.print("Pila: ");
							for(Vertex<? extends Position> vertice:queue)
							{
								System.out.print(vertice.getVertexReference().getSysName() + " ");
							}
							//System.out.println(" ");
							//System.out.println(" ");
					}
					
				}
				
				//check if p2 vertex exists in queue
				if(queue.contains(v2))
				{
					exists = true;
				}
			}
		
		}
	}
	
	public Player getPlayer()
	{
		return player;
	}
	
	public Position getPosition1()
	{
		return position1;
	}
	
	public Position getPosition2()
	{
		return position2;
	}
	
	public Boolean getExists()
	{
		return exists;
	}
	
	public Graph getGraph()
	{
		return graph;
	}
	
}
