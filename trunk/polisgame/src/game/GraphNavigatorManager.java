package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class GraphNavigatorManager {

	public GraphNavigatorManager()
	{
		
	}
	
	public static Boolean existsWay ( Territory p1, Territory p2, Player player, String type){
		
		Graph graph = null;
		
		if(type.equals("hoplite"))
		{
			graph = Game.getHopliteGraph();
			System.out.println(graph.getGraph());
		}else if(type.equals("trirreme"))
		{
			graph = Game.getTrirremeGraph();
			System.out.println(graph);
		}else if(type.equals("tradeBoat"))
		{
			graph = Game.getTradeBoatGraph();
			System.out.println(graph);
		}else if(type.equals("proxenus"))
		{
			graph = Game.getProxenusGraph();
			System.out.println(graph);
		}
		
		System.out.println(graph);
		
		Set<Vertex<? extends Position>> searchInGraph = graph.getGraph().keySet();
		
		Vertex<? extends Position> v = null;
		for(Vertex<? extends Position> vertex: searchInGraph)
		{

			if(vertex.getVertexReference().getSysName().equals(p1.getSysName()))
			{
				v = vertex;
			}
		}
		
		List<Vertex<? extends Position>> initialPositionAdjacents = graph.getGraph().get(v);
		Boolean exists = false;
		
		for(Vertex<? extends Position> vertex: initialPositionAdjacents)
		{
			List<Vertex<? extends Position>> possibleCandidates = possibleCandidates(Game.getHopliteGraph().getGraph().get(vertex.getVertexReference().getSysName()), player);
			
			exists = (exists || findCandidate(possibleCandidates, p2));  
			
		}
	
		return exists;
	}
	
	private static List<Vertex<? extends Position>> possibleCandidates(List<Vertex<? extends Position>> vertices, Player player)
	{
		List<Vertex<? extends Position>> newCandidates = new ArrayList<Vertex<? extends Position>>();
		
		for(Vertex<? extends Position> vertex: vertices)
		{
			
			if(!vertex.getVertexReference().getLockForAPlayer(player))
			{
					newCandidates.add(vertex);
			}
			
		}
		
		
		return newCandidates;
	}
	
	private static Boolean findCandidate(List<Vertex<? extends Position>> possibleCandidates, Position p2)
	{
		Boolean candidate = false;
		
		for(Vertex<? extends Position> vertex: possibleCandidates)
		{
			if(vertex.getVertexReference().getSysName().equals(p2.getSysName()))
			{
				candidate = true;
			}
		}
		
		return candidate;
	}

}
