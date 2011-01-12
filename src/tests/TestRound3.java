package tests;

import java.util.List;

import game.GameEvent;
import game.Project;
import game.Round3;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class TestRound3 {
	
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
	public void testRound3Creation()
	{
		Round3 u = new Round3(mockProjectsInThisRound,mockGameEventInThisRound);
		assert(u.getProjectsInThisRound() == mockProjectsInThisRound);
		assert(u.getGameEventInThisRound() == mockGameEventInThisRound);
		
	}
	@Test
	public void testNullRound3Creation()
	{
		Round3 u = new Round3(null,null);
		assert(u.getProjectsInThisRound() == mockNullProjectsInThisRound);
		assert(u.getGameEventInThisRound() == mockNullGameEventInThisRound);
		
	}
}
