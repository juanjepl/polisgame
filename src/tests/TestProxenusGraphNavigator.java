package tests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import game.Player;
import game.Polis;
import game.Position;
import game.Sea;
import game.Territory;

import org.junit.Before;
import org.junit.Test;

import navigation.Graph;
import navigation.HopliteGraphNavigator;
import navigation.Vertex;

public class TestProxenusGraphNavigator {

	Player mockPlayer;
	Position mockPosition1;
	Position mockPosition2;
	Graph mockGraph;
	Player mockNullPlayer;
	Position mockNullPosition;
	Graph mockNullGraph;
	Vertex<? extends Position> mockVertex;
	List<Vertex<? extends Position>> mockList;
	Map<Vertex<? extends Position>, List<Vertex<? extends Position>>> mockMap;

	
@Before
public void setup()
{
	mockNullPlayer=null;
	mockNullPosition=null;
	mockNullGraph=null;
	mockPlayer=new Player("Marsé");
	Territory arcanania =new Territory("acarnania","Acarnania", null);
	Territory macedonia=new Territory("macedonia","Macedonia", null);
	List<Sea> arcananiaSeas=new ArrayList<Sea>();
	arcananiaSeas.add(new Sea("ionianSea","Mar Jónico"));
	List<Sea> macedoniaSeas=new ArrayList<Sea>();
	macedoniaSeas.add(new Sea("thraceSea","Mar de Tracia"));
	mockPosition1=new Polis("pidna","Pidna", 2, 1, 3, macedonia, null, macedoniaSeas, null);
	mockPosition2=new Polis("corcyra","Corcira", 2, 1, 3, arcanania, null, arcananiaSeas, null);
	mockVertex = new Vertex(mockPosition1);
	mockList= new ArrayList<Vertex<? extends Position>>();
	mockMap=new HashMap<Vertex<? extends Position>, List<Vertex<? extends Position>>>();
	mockList.add(mockVertex);
	mockMap.put(mockVertex, mockList);
	
}

@Test
public void testHopliteGraphNavigatorCreation()
{
	Graph mockGraph = new Graph(mockMap);
	HopliteGraphNavigator g = new HopliteGraphNavigator(mockPlayer,mockPosition1,mockPosition2,mockGraph);
	assert(g.getPlayer().equals(mockPlayer));
	assert(g.getPosition1().equals(mockPosition1));
	assert(g.getPosition2().equals(mockPosition2));
	assert(g.getGraph().equals(mockGraph));
	
}
	
@Test(expected=IllegalArgumentException.class)
public void testNullHopliteGraphNavigatorCreation()
{
	HopliteGraphNavigator g = new HopliteGraphNavigator(mockNullPlayer,mockNullPosition,mockNullPosition,mockNullGraph);
	assert(g.getPlayer().equals(mockNullPlayer));
	assert(g.getPosition1().equals(mockNullPosition));
	assert(g.getPosition2().equals(mockNullPosition));
	assert(g.getGraph().equals(mockNullGraph));
	
}
	
}
