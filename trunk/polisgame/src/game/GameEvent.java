package game;


/** Class who manages everything related with Game Events */
public class GameEvent {
	private String sysName;
	private String name;
	private String text;
	private String round;
	
	
	public GameEvent(String sysName,String name, String text, String round){
		this.sysName = sysName;
		this.name = name;
		this.text = text;
		this.round = round;
		
	}
	
	/** This method executes the game event by its system name */
	public void executeAction(){
		
		//TODO ¿with switch()? ¿else if()? by sysName
		
	}
	
	/** Getters and Setters */
	
	public String getSysName() {
		return sysName;
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
