package tests;

import java.util.ArrayList;
import java.util.List;

import game.GameEvent;
import game.Project;
import game.Round5B;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class TestRound5B {
	
	@Mock Project mockProject;
	@Mock GameEvent mockGameEvent;
	
	List<Project> mockListProjects; 
	List<GameEvent> mockListGameEvent; 

	List<Project> mockNullListProjects; 
	List<GameEvent> mockNullListGameEvent; 	
		
	@Before
	public void setup()
	{
		mockListProjects= new ArrayList<Project>();
		mockListGameEvent= new ArrayList<GameEvent>();
		MockitoAnnotations.initMocks(this);
		mockNullListProjects=null; 
		mockNullListGameEvent=null;
		
	}
	
	@Test
	public void testRound5BCreation()
	{
		mockListProjects.add(mockProject);
		mockListProjects.add(mockProject);
		mockListProjects.add(mockProject);
		mockListProjects.add(mockProject);
		mockListProjects.add(mockProject);
		mockListGameEvent.add(mockGameEvent);
		mockListGameEvent.add(mockGameEvent);
		mockListGameEvent.add(mockGameEvent);
		mockListGameEvent.add(mockGameEvent);
		mockListGameEvent.add(mockGameEvent);
		Round5B u = new Round5B(mockListProjects,mockListGameEvent);
		assert(u.getProjectsInThisRound().contains(mockProject));
		
	}
	@Test (expected=IllegalArgumentException.class)
	public void testNullRound5BCreation()
	{
		Round5B u = new Round5B(null,null);
		assert(u.getProjectsInThisRound() == mockNullListProjects);
		assert(u.getGameEventInThisRound() == mockNullListGameEvent);
		
	}
}
