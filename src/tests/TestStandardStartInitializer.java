package tests;
import game.StandardStartInitializer;
import game.Game;
import org.junit.Before;
import org.junit.Test;

public class TestStandardStartInitializer {
	Game nullGame;
	
	@Before
	public void Setup(){
		nullGame=null;
	}
	@Test(expected=NullPointerException.class)
	public void TestStandardStartInitializerWithNullGame(){
		StandardStartInitializer st=new StandardStartInitializer();
		st.standardStart(nullGame);
	}
}
