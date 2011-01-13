package tests;

import game.Position;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import navigation.Vertex;

public class TestVertex {


	@Mock Position mockVertexReference;
	Position mockNullVertexReference;

	
@Before
public void setup()
{
	MockitoAnnotations.initMocks(this);
	mockNullVertexReference=null;
}

@Test
public void testVertexCreation()
{
	Vertex<Position> v = new Vertex<Position>(mockVertexReference);
	assert(v.getVertexReference().equals(mockVertexReference));
}
	
@Test(expected=NullPointerException.class)
public void testNullVertexCreation()
{
	Vertex<Position> v = new Vertex<Position>(mockNullVertexReference);
	assert(v.getVertexReference().equals(mockNullVertexReference));
}

@Test
public void testSetWeight(){
	Vertex<Position> v = new Vertex<Position>(mockVertexReference);
	v.setWeight(5);
	assert(v.getWeight().equals(5));
}
	
}
