package tests;

import java.util.List;

import game.GameEvent;
import game.Project;
import game.Round5B;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class TestRound5B {
	
	@Mock List<Project> mockProjectsInThisRound; 
	@Mock List<GameEvent> mockGameEventInThisRound; 

	List<Project> mockNullProjectsInThisRound; 
	GameEvent mockNullGameEventInThisRound; 	
		
	@Before
	public void setup()
	{
		mockNullProjectsInThisRound=null; 
		mockNullGameEventInThisRound=null; 
		
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testRound5BCreation()
	{
		Round5B u = new Round5B(mockProjectsInThisRound,mockGameEventInThisRound);
		assert(u.getProjectsInThisRound() == mockProjectsInThisRound);
		assert(u.getGameEventInThisRound() == mockGameEventInThisRound);
		
	}
	@Test(expected=IllegalArgumentException.class)
	public void testNullRound5BCreation()
	{
		Round5B u = new Round5B(null,null);
		assert(u.getProjectsInThisRound() == mockNullProjectsInThisRound);
		assert(u.getGameEventInThisRound() == mockNullGameEventInThisRound);
		
	}
}
