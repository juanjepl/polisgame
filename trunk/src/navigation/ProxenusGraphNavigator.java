package navigation;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import game.Player;
import game.Polis;
import game.Position;
import game.Unit;

public class ProxenusGraphNavigator extends GenericGraphNavigator {

	private Integer amountToPayForWay;
	private Polis polis1;
	private Polis polis2;
	
	public ProxenusGraphNavigator(Player player, Polis polis1,
			Polis polis2, Graph graph)
	{
		super(player, polis1, polis2);
		this.graph = graph;
		this.polis1 = polis1;
		this.polis2 = polis2;
		amountToPayForWay = 0;
		existsWay();
	}
	
	public Polis getPolis1()
	{
		return polis1;
	}
	
	public Polis getPolis2()
	{
		return polis2;
	}

	protected void existsWay()
	{
		if(getPolis1().getSysName().equals(getPolis2().getSysName())){
			exists = false;
		}
		else
		{
			Set<Vertex<? extends Position>> searchInGraph = getGraph().getMapGraph().keySet();
			
			Vertex<? extends Position> v = null;
			Vertex<? extends Position> v2 = null;
			for(Vertex<? extends Position> vertex: searchInGraph)
			{

				if(vertex.getVertexReference().getSysName().equals(getPolis1().getSysName()))
				{
					v = vertex;
				}else if(vertex.getVertexReference().getSysName().equals(getPolis2().getSysName()))
				{
					v2 = vertex;
				}
			}
			//Get adjacents of v vertex
			List<Vertex<? extends Position>> initialPositionAdjacents = getGraph().getMapGraph().get(v);
			
			List<Vertex<? extends Position>> visited = new ArrayList<Vertex<? extends Position>>();
			List<Vertex<? extends Position>> queue = new ArrayList<Vertex<? extends Position>>();
			Vertex<? extends Position> bestCandidate = null;
			Integer amountToPayForMovement = 0;
			
			//if initialPosition is sieged proxenus have to pay silver

			if(getPolis1().getSieged())
			{
				Integer oponentUnits = 0;
				
				//create a new list that contains only oponent units
				for(Unit u: getPolis1().getUnits())
				{
					if(!u.getOwner().equals(getPlayer()))
					{
						oponentUnits++;
					}
				}
				
				amountToPayForMovement += oponentUnits;
			}
			
			for(Vertex<? extends Position> vertex: initialPositionAdjacents)
			{
				
				Integer oponentUnits = 0;
				
				//create a new list that contains only oponent units
				for(Unit u: vertex.getVertexReference().getUnits())
				{
					if(!u.getOwner().equals(getPlayer()))
					{
						oponentUnits++;
					}
				}
				
				vertex.setWeight(oponentUnits);
				
				if(bestCandidate == null)
				{
					bestCandidate = vertex;
				}
				else if(bestCandidate.getWeight() > vertex.getWeight() || bestCandidate == null)
				{
					bestCandidate = vertex;
				}else
				{
					if(!visited.contains(vertex))
					{
						visited.add(vertex);
					}
				}

				
			}
			queue.add(bestCandidate);
			amountToPayForMovement += bestCandidate.getWeight();
			
			visited.add(v);
			
			
			while(!queue.isEmpty() && !exists)
			{
				bestCandidate = null;
				//extract first vertex
				Vertex<? extends Position> element = queue.remove(0);
				//get adjacents of element and check if exists in visited
				List<Vertex<? extends Position>> adjacents = getGraph().getMapGraph().get(element);
				
				if(!visited.contains(element))
				{
					visited.add(element);
				}
				
				for(Vertex<? extends Position> vertex: adjacents)
				{
					Integer oponentUnits = 0;
					
					//create a new list that contains only oponent units
					for(Unit u: vertex.getVertexReference().getUnits())
					{
						if(!u.getOwner().equals(getPlayer()))
						{
							oponentUnits++;
						}
					}
					
					vertex.setWeight(oponentUnits);
					
					//check if vertex isn't visited and calculate the weight
					if(bestCandidate == null)
					{
						bestCandidate = vertex;
					}
					else if(vertex.equals(v2))
					{
							bestCandidate = vertex;
					}
					else if(!visited.contains(vertex) && (bestCandidate.getWeight() > vertex.getWeight()))
					{
							//add vertex to queue
							bestCandidate = vertex;
					}else
					{
						if(!visited.contains(vertex))
						{
							visited.add(vertex);
						}
					}
					
				}
				
				queue.add(bestCandidate);
				amountToPayForMovement += bestCandidate.getWeight();
				
				//check if p2 vertex exists in queue
				if(bestCandidate.equals(v2))
				{
					exists = true; //devolver realmente el coste
				}
			}
			
			amountToPayForWay = amountToPayForMovement;

		}
	}
	
	
	public Integer getAmountToPayForWay()
	{
		return amountToPayForWay;
	}

}
