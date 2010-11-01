package game;


public class GameEvent {
	private String name;
	private String text;
	private String round;
	
	public GameEvent(String name, String text, String round){
		
		this.name = name;
		this.text = text;
		this.round = round;
		
	}
	
	
	public static void executeAction(String eventName){
		//TODO
	}
	
	public String getName() {
		return name;
	}

	public String getText() {
		return text;
	}

	public String getRound() {
		return round;
	}

}
