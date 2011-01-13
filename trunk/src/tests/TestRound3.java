package tests;

import java.util.ArrayList;
import java.util.List;

import game.GameEvent;
import game.Project;
import game.Round3;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class TestRound3 {
	
	@Mock Project mockProject;
	@Mock GameEvent mockGameEvent;
	
	List<Project> mockProjectsInThisRound; 
	List<GameEvent> mockGameEventInThisRound; 

	List<Project> mockNullProjectsInThisRound; 
	List<GameEvent> mockNullGameEventInThisRound; 	
		
	@Before
	public void setup()
	{
		mockNullProjectsInThisRound=null; 
		mockNullGameEventInThisRound=null;
		mockProjectsInThisRound= new ArrayList<Project>();
		mockGameEventInThisRound= new ArrayList<GameEvent>();
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testRound3Creation()
	{
		mockProjectsInThisRound.add(mockProject);
		mockGameEventInThisRound.add(mockGameEvent);
		Round3 u = new Round3(mockProjectsInThisRound,mockGameEventInThisRound);
		assert(u.getProjectsInThisRound() == mockProjectsInThisRound);
		assert(u.getGameEventInThisRound() == mockGameEventInThisRound);
		
	}
	@Test (expected=IllegalArgumentException.class)
	public void testNullRound3Creation()
	{
		Round3 u = new Round3(null,null);
		assert(u.getProjectsInThisRound() == mockNullProjectsInThisRound);
		assert(u.getGameEventInThisRound() == mockNullGameEventInThisRound);
		
	}
}
