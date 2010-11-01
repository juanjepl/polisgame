package game;

import java.util.List;
import java.util.LinkedList;

public class Round {

	private String name;
	private List<Turn> turnList;
	
	public Round(){
		name = "3";
		
		turnList = new LinkedList<Turn>();
	}
	
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
	}
	
	public void addTurn(Turn turn){
		turnList.add(turn);
	}
	
	public String getName(){
		return this.name;
	}
	
	
	public List<Turn> getTurnList(){
		return this.turnList;
	}
}
