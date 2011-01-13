package tests;

import game.Position;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import navigation.Graph;
import navigation.Vertex;

public class TestGraph {


	@Mock Vertex<? extends Position> mockVertex;
	List<Vertex<? extends Position>> mockList;
	Map<Vertex<? extends Position>, List<Vertex<? extends Position>>> mockMap;
	Map<Vertex<? extends Position>, List<Vertex<? extends Position>>> mockNullMap;
	List<Vertex<? extends Position>> mockNullList;
	Vertex<? extends Position> mockNullVertex;

	
@Before
public void setup()
{
	mockList= new ArrayList<Vertex<? extends Position>>();
	mockMap=new HashMap<Vertex<? extends Position>, List<Vertex<? extends Position>>>();
	MockitoAnnotations.initMocks(this);
	mockNullMap=null;
	mockNullList=null;
	mockNullVertex=null;
}

@Test
public void testGraphCreation()
{
	mockList.add(mockVertex);
	mockMap.put(mockVertex, mockList);
	Graph g = new Graph(mockMap);
	assert(g.getMapGraph().equals(mockMap));
}
	
@Test(expected=NullPointerException.class)
public void testNullGraphCreation()
{
	mockNullMap.put(mockNullVertex, mockNullList);
	Graph g = new Graph(mockNullMap);
	assert(g.getMapGraph().equals(mockNullMap));
}
	
}
