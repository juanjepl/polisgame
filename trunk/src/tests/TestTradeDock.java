package tests;
import game.TradeDock;
import org.junit.Before;
import org.junit.Test;
public class TestTradeDock {

	String sysName;
	String name;
	@Before
	public void Setup(){
		sysName="athensTradeDock";
		name="Puerto comercial de Atenas";
	}
	@Test
	public void TestTradeDockConstructor(){
		TradeDock td=new TradeDock(sysName,name);
	}
}
