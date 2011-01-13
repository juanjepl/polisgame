package tests;

import game.GameAction;
import game.Turn;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


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
