package tests;

import java.util.List;

import game.GameEvent;
import game.Project;
import game.Round4;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class TestRound4 {
	
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
	public void testRound4Creation()
	{
		Round4 u = new Round4(mockProjectsInThisRound,mockGameEventInThisRound);
		assert(u.getProjectsInThisRound() == mockProjectsInThisRound);
		assert(u.getGameEventInThisRound() == mockGameEventInThisRound);
		
	}
	@Test(expected=IllegalArgumentException.class)
	public void testNullRound4Creation()
	{
		Round4 u = new Round4(null,null);
		assert(u.getProjectsInThisRound() == mockNullProjectsInThisRound);
		assert(u.getGameEventInThisRound() == mockNullGameEventInThisRound);
		
	}
}
