package game;


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
	
	
	public static void executeAction(String eventName){
		//TODO
	}
	
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
