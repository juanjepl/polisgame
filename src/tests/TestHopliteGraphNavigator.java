package tests;

import game.Player;
import game.Position;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import navigation.Graph;
import navigation.HopliteGraphNavigator;

public class TestHopliteGraphNavigator {

	@Mock Player mockPlayer;
	@Mock Position mockPosition;
	@Mock Graph mockGraph;
	Player mockNullPlayer;
	Position mockNullPosition;
	Graph mockNullGraph;


	
@Before
public void setup()
{
	mockNullPlayer=null;
	mockNullPosition=null;
	mockNullGraph=null;
	MockitoAnnotations.initMocks(this);
	
}

@Test
public void testHopliteGraphNavigatorCreation()
{
	HopliteGraphNavigator g = new HopliteGraphNavigator(mockPlayer,mockPosition,mockPosition,mockGraph);
	assert(g.getPlayer().equals(mockPlayer));
	assert(g.getPosition1().equals(mockPosition));
	assert(g.getPosition2().equals(mockPosition));
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
