package game;

import java.util.List;
import java.util.ArrayList;
import utils.RandomCollections;

/** Class for game's rounds */
public abstract class Round {

	private List<Turn> turnList;
	private List<Project> projectsInThisRound; // the 3 selected projects for this round from the maze
	private GameEvent gameEventInThisRound; // the game event selected for this round from the actual's round game events maze
	private Integer maximumPositionSlotsForThisRound;
	
	public Round(Integer maximumPositionSlotsForThisRound,List<Project> projectsOfTheGame,List<GameEvent> gameEventsOfTheGame){
		turnList = new ArrayList<Turn>();
		projectsInThisRound = new ArrayList<Project>();
		this.maximumPositionSlotsForThisRound = maximumPositionSlotsForThisRound;
		
		// Initializing projects of this round
		List<Project> availableProjects = new ArrayList<Project>();
		for(Project proj : projectsOfTheGame){
			if(!(proj.getUsed())){
				availableProjects.add(proj);
			}
		}
		
		RandomCollections<Project> randomListOfProjects = new RandomCollections<Project>();
		getProjectsInThisRound().addAll(randomListOfProjects.getRandomSublist(availableProjects,3));

		// Initializing the GameEvent of this round
		RandomCollections<GameEvent> randomGameEvent = new RandomCollections<GameEvent>();
		List<GameEvent>randomGameEventList = randomGameEvent.getRandomSublist(gameEventsOfTheGame, 1);
		gameEventInThisRound = randomGameEventList.get(0);
	}
	
	/**
	 * Getters and setters methods
	 */
	
	/** This method adds a turn into round's turn list */
	public void addTurn(Turn turn){
		if(turn == null){
			throw new IllegalArgumentException("Invalid paramter in addTurn(), must be a Turn instance");
		}
		turnList.add(turn);
	}
	
	public List<Turn> getTurnList(){
		return this.turnList;
	}
	
	public List<Project> getProjectsInThisRound(){
		return projectsInThisRound;
	}

	public void setProjectsInThisRound(List<Project> projectsInThisRound){
		if(projectsInThisRound == null){
			throw new IllegalArgumentException("null is not valid for parameter in setProjectsInThisRound()");
		}
		this.projectsInThisRound = projectsInThisRound;
	}

	public Integer getMaximumPositionSlotsForThisRound(){
		return maximumPositionSlotsForThisRound;
	}
	
	public GameEvent getGameEventInThisRound(){
		return gameEventInThisRound;
	}

	public void setGameEventInThisRound(GameEvent gameEventInThisRound){
		if(gameEventInThisRound == null){
			throw new IllegalArgumentException("Invalid parameter for setGameEventInThisRound(), must be a GameEvent instance");
		}
		this.gameEventInThisRound = gameEventInThisRound;
	}

	
}