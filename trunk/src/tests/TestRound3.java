package tests;

import java.util.ArrayList;
import java.util.List;

import game.GameEvent;
import game.Project;
import game.Round;
import game.Round3;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class TestRound3 {
	
	@Mock Project mockProject;
	@Mock GameEvent mockGameEvent;
	
	List<Project> mockListProjects; 
	List<GameEvent> mockListGameEvent; 

	List<Project> mockNullListProjects; 
	List<GameEvent> mockNullListGameEvent; 	
		
	@Before
	public void setup()
	{
		mockNullListProjects=null; 
		mockNullListGameEvent=null;
		mockListProjects= new ArrayList<Project>();
		mockListGameEvent= new ArrayList<GameEvent>();
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testRound3Creation()
	{
		mockListProjects.add(mockProject);
		mockListGameEvent.add(mockGameEvent);
		Round3 u = new Round3(mockListProjects,mockListGameEvent);
		assert(u.getProjectsInThisRound().contains(mockProject));
		
	}
	@Test (expected=IllegalArgumentException.class)
	public void testNullRound3Creation()
	{
		Round3 u = new Round3(null,null);
		assert(u.getProjectsInThisRound() == mockNullListProjects);
		assert(u.getGameEventInThisRound() == mockNullListGameEvent);
		
	}
}
