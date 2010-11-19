package game;

import java.util.List;
import java.util.LinkedList;

import utils.RandomCollections;

/** Class for game's rounds */
public class Round<T> {

	private String name;
	private List<Turn> turnList;
	
	private List<Project> projectsInThisRound; // the 3 selected projects for this round from the maze
	private GameEvent gameEventInThisRound; // the game event selected for this round from the actual's round game events maze
	
	public Round(){
		name = "3"; // initial round's name is 3 (from 3, 4, 5a and 5b)
		turnList = new LinkedList<Turn>();
	}
	
	/** This method changes the round's name to the next name (3->4, 4->5a and 5a->5b */
	public void nextRound(){
		if (this.name.equals("3")){
			this.name = "4";
		}
		else if(this.name.equals("4")){
			this.name = "5a";
		}
		else if(this.name.equals("5a")){
			this.name = "5b";
		}
		else{
			//TODO possible exception.
		}
		
		//FIXME more functionalities for this method?
	}
	
	
	/** Getters and setters */
	
	/** This method adds a turn into round's turn list */
	public void addTurn(Turn turn){
		turnList.add(turn);
	}
	
	public String getName(){
		return this.name;
	}
	
	public List<Turn> getTurnList(){
		return this.turnList;
	}
	
	public List<Project> getProjectsInThisRound() {
		return projectsInThisRound;
	}

	public void setProjectsInThisRound(List<Project> projectsInThisRound) { // EndRoundManager.initializeNextRound() will need that "set"
		this.projectsInThisRound = projectsInThisRound;
	}

	public Integer getMaximumPositionSlotsForThisRound(){
		Integer slots = 0;
		
		if(getName().equals("3")){
			slots = 3;
		}
		else if(getName().equals("4")){
			slots = 4;
		}
		else if(getName().equals("5a")||getName().equals("5b")){
			slots = 5;
		}
		else{
			// Do nothing (if name isn't one of the 4, this possible exception is captured before.
		}
		
		
		return slots;
	}
	
	public GameEvent getGameEventInThisRound() {
		return gameEventInThisRound;
	}

	public void setGameEventInThisRound(GameEvent gameEventInThisRound) {
		this.gameEventInThisRound = gameEventInThisRound;
	}

	/** This method initializes the round (can be used by EndRoundManager.initializeNextRound() */
	public void startRound(Game game){
		
		// Takes from the game projects list, 3 random projects
		RandomCollections<Project> randomListOfProjects = new RandomCollections<Project>();
		projectsInThisRound = randomListOfProjects.getRandomSublist(game.getProjectList(),3);
		
		
		// Takes one random GameEvent from actual round
		RandomCollections<GameEvent> randomGameEvent = new RandomCollections<GameEvent>();
		if(getName().equals("3")){
			List<GameEvent>randomGameEventList = randomGameEvent.getRandomSublist(game.getGameEventsRound3(), 1);
			gameEventInThisRound = randomGameEventList.get(0);
		}
		else if(getName().equals("4")){
			List<GameEvent>randomGameEventList = randomGameEvent.getRandomSublist(game.getGameEventsRound4(), 1);
			gameEventInThisRound = randomGameEventList.get(0);
		}
		else if(getName().equals("5a")){
			List<GameEvent>randomGameEventList = randomGameEvent.getRandomSublist(game.getGameEventsRound5a(), 1);
			gameEventInThisRound = randomGameEventList.get(0);
		}
		else if(getName().equals("5b")){
			List<GameEvent>randomGameEventList = randomGameEvent.getRandomSublist(game.getGameEventsRound5b(), 1);
			gameEventInThisRound = randomGameEventList.get(0);
		}
		else{
			//FIXME possible exception (attribute name has wrong value of String)
		}
		
		//Executes the Game Event
		gameEventInThisRound.executeAction();
	}
	
}
