package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class GraphNavigatorManager {

	public GraphNavigatorManager()
	{
		
	}
	
	public static Boolean existsWay ( Position p1, Position p2, Player player, String type){
		
		Graph graph = null;
		if(p1.getSysName().equals(p2.getSysName())){
			return false;
		}
		else
		{
			
		
		if(type.equals("hoplite"))
		{
			graph = Game.getHopliteGraph();
		}else if(type.equals("trirreme"))
		{
			graph = Game.getTrirremeGraph();
		}else if(type.equals("tradeBoat"))
		{
			graph = Game.getTradeBoatGraph();
		}else if(type.equals("proxenus"))
		{
			graph = Game.getProxenusGraph();
		}
		
		Set<Vertex<? extends Position>> searchInGraph = graph.getGraph().keySet();
		
		Vertex<? extends Position> v = null;
		Vertex<? extends Position> v2 = null;
		for(Vertex<? extends Position> vertex: searchInGraph)
		{

			if(vertex.getVertexReference().getSysName().equals(p1.getSysName()))
			{
				v = vertex;
			}else if(vertex.getVertexReference().getSysName().equals(p2.getSysName()))
			{
				v2 = vertex;
			}
		}
		//Get adjacents of v vertex
		List<Vertex<? extends Position>> initialPositionAdjacents = graph.getGraph().get(v);
		
		
		Boolean exists = false;
		List<Vertex<? extends Position>> visited = new ArrayList<Vertex<? extends Position>>();
		List<Vertex<? extends Position>> queue = new ArrayList<Vertex<? extends Position>>();
		
		for(Vertex<? extends Position> vertex: initialPositionAdjacents)
		{
			
			if(!vertex.getVertexReference().getLockForAPlayer(player))
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
			List<Vertex<? extends Position>> adjacents = graph.getGraph().get(element);
			visited.add(element);
			
			for(Vertex<? extends Position> vertex: adjacents)
			{
				//check if vertex isn't locked and isn't visited
				if(!vertex.getVertexReference().getLockForAPlayer(player) && !visited.contains(vertex))
				{
						//add vertex to queue
						queue.add(vertex);
				}
				
			}
			
			//check if p2 vertex exists in queue
			if(queue.contains(v2))
			{
				exists = true;
			}
		}
		
		return exists;
		}
	}

}
