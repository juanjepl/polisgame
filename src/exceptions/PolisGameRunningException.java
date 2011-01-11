package exceptions;

public class PolisGameRunningException extends RuntimeException{

	private static final long serialVersionUID = -4605868325087003586L; // generated serial

	public PolisGameRunningException(){
		super();
	}
	
	public PolisGameRunningException(String message){
		super(message);
	}
}