package game;

import java.util.List;
import java.util.LinkedList;

/** Class for game's rounds */
public class Round {

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
		
		//TODO more functionalities for this method?
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

	public GameEvent getGameEventInThisRound() {
		return gameEventInThisRound;
	}

	public void setGameEventInThisRound(GameEvent gameEventInThisRound) {
		this.gameEventInThisRound = gameEventInThisRound;
	}

	/** This method initializes the round (can be used by EndRoundManager.initializeNextRound() */
	public void startRound(){
		//TODO
		// Add 3 random projects of all
		//TODO
		// Add and execute a GameEvent
		
		
	}
	
}
