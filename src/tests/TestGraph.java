package tests;

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


	@Mock Vertex mockVertex;
	List mockList;
	Map mockMap;
	Map mockNullMap;
	List mockNullList;
	Vertex mockNullVertex;

	
@Before
public void setup()
{
	mockList= new ArrayList<Vertex>();
	mockMap=new HashMap<Vertex,List<Vertex>>();
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
