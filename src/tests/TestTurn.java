package tests;

import game.GameAction;
import game.Position;
import game.Turn;

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

public class TestTurn {


	@Mock GameAction mockAction;
	GameAction mockNullAction;

	
@Before
public void setup()
{
	MockitoAnnotations.initMocks(this);
	mockNullAction=null;
	
}


@Test
public void testAddGameAction(){
	Turn t = new Turn();
	t.addGameAction(mockAction);
	assert(t.getFirstAction().equals(mockAction));
}
	
@Test(expected=IllegalArgumentException.class)
public void testNullAddGameAction(){
	Turn t = new Turn();
	t.addGameAction(mockNullAction);
	assert(t.getFirstAction().equals(mockNullAction));
}
	
}
