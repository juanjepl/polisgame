package tests;
import java.util.HashMap;
import java.util.Map;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.junit.Before;
import org.junit.Test;
import game.Player;
import game.Polis;
import game.ProjectGame;
import game.StartAProjectAction;
public class TestStartAProjectAction {

	@Mock Player mockPlayer;
	@Mock Polis mockPolis;
	@Mock ProjectGame proj;
	Map<String,Integer> payment;
	
	@Before
	public void Setup(){
		Map<String,Integer>requiredResources=new HashMap<String, Integer>();
		requiredResources.put("Silver", 5);
		ProjectGame proj=new ProjectGame("democritusPhilosopher","Demócrito",4,1,requiredResources);
		payment= new HashMap<String, Integer>();
		MockitoAnnotations.initMocks(this);
	}
	@Test(expected=NullPointerException.class)
	public void TestStartAProjectActionWithoutResources(){
		payment.put("Silver", 4);
		StartAProjectAction spa=new StartAProjectAction(mockPlayer, mockPolis, proj, payment);
		assert(mockPolis.getProjects().contains(spa.getProject()));
	}
}
