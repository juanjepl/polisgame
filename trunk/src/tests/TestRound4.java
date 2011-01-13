package tests;

import java.util.ArrayList;
import java.util.List;

import game.GameEvent;
import game.Project;
import game.Round4;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class TestRound4 {
	
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
	public void testRound4Creation()
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
		Round4 u = new Round4(mockListProjects,mockListGameEvent);
		assert(u.getProjectsInThisRound().contains(mockProject));
		
	}
	@Test (expected=IllegalArgumentException.class)
	public void testNullRound4Creation()
	{
		Round4 u = new Round4(null,null);
		assert(u.getProjectsInThisRound() == mockNullListProjects);
		assert(u.getGameEventInThisRound() == mockNullListGameEvent);
		
	}
}
