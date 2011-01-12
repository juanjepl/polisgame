package tests;

import java.util.List;

import game.GameEvent;
import game.Project;
import game.Round5A;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class TestRound5A {
	
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
	public void testRound5ACreation()
	{
		Round5A u = new Round5A(mockProjectsInThisRound,mockGameEventInThisRound);
		assert(u.getProjectsInThisRound() == mockProjectsInThisRound);
		assert(u.getGameEventInThisRound() == mockGameEventInThisRound);
		
	}
	@Test(expected=IllegalArgumentException.class)
	public void testNullRound5ACreation()
	{
		Round5A u = new Round5A(null,null);
		assert(u.getProjectsInThisRound() == mockNullProjectsInThisRound);
		assert(u.getGameEventInThisRound() == mockNullGameEventInThisRound);
		
	}
}
