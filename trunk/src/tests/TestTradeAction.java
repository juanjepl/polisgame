package tests;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import game.TradeAction;
import game.Market;
import game.MarketChart;
import game.Player;
import game.Round;

public class TestTradeAction {
	@Mock Player mockPlayer;
	@Mock Round mockRound;
	@Mock Market mockMarket;
	@Mock MarketChart mockMarketChart;
	Player mockNullPlayer;
	Round mockNullRound;
	Market mockNullMarket;
	MarketChart mockNullMarketChart;
	Integer dice;
	String resource1;
	String resource2;
	
	@Before
	public void Setup(){
		mockNullMarket=null;
		mockNullMarketChart=null;
		mockNullPlayer=null;
		mockNullRound=null;
		MockitoAnnotations.initMocks(this);
		resource1="Wheat";
		resource2="Silver";
		dice=2;
	}
	@Test(expected=IllegalArgumentException.class)
	public void TestTradeActionDiceLessThanZero(){
		dice=-1;
		TradeAction ta=new TradeAction(mockPlayer, mockRound, mockMarketChart, mockMarket, resource1, resource2, dice);
		assert(ta.getDice()==-1);
	}
	@Test(expected=IllegalArgumentException.class)
	public void TestTradeActionEmptyResourcesNames(){
		resource1="";
		resource2="";
		TradeAction ta= new TradeAction(mockPlayer, mockRound, mockMarketChart, mockMarket, resource1, resource2, dice);
		assert(ta.getResource1().equals(resource1));
		assert(ta.getResource2().equals(resource2));
	}
	@Test(expected=IllegalArgumentException.class)
	public void TestTradeActionNullMarket(){
		TradeAction ta= new TradeAction(mockPlayer, mockRound, mockMarketChart, mockNullMarket, resource1, resource2, dice);
		assert(ta.getMarket().equals(mockNullMarket));
	}
	@Test(expected=IllegalArgumentException.class)
	public void TestTradeActionNullMarketChart(){
		TradeAction ta= new TradeAction(mockPlayer, mockRound, mockNullMarketChart, mockMarket, resource1, resource2, dice);
		assert(ta.getMarketChart().equals(mockNullMarketChart));
	}
	@Test(expected=IllegalArgumentException.class)
	public void TestTradeActionNullPlayer(){
		TradeAction ta= new TradeAction(mockNullPlayer, mockRound, mockMarketChart, mockMarket, resource1, resource2, dice);
		assert(ta.getPlayer().equals(mockNullPlayer));
	}
	@Test(expected=IllegalArgumentException.class)
	public void TestTradeActionNullRound(){
		TradeAction ta= new TradeAction(mockPlayer, mockNullRound, mockMarketChart, mockMarket, resource1, resource2, dice);
		assert(ta.getRound().equals(mockNullRound));
	}
	
}
