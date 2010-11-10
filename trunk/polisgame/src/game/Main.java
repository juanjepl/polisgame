package game;


public class Main {

	public static void main(String[] args) {
		
		Game polis_game = ElementsInitializer.InitializeGameElements(); // Initializes Game's elements
		StandardStartInitializer.standardStart(polis_game); // Initializes Game's start position
		
		Round gameRound = polis_game.getRound();
		
		Boolean gameEndCondition = false;
		while(gameEndCondition == false){
			
			Boolean endOfRound = false;
			while(endOfRound == false){
				
				//TODO main loop
				
				
				
			}			
			
			
			
		}
		
		
	
	}
}
