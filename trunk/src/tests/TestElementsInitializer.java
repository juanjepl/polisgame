package tests;

import game.ElementsInitializer;
import game.Game;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

public class TestElementsInitializer {

//	@Mock Player mockSparta;
//	@Mock Player mockAthens;
//	@Mock Map<String, Territory> mockTerritoriesMap;
//	@Mock Map<String, Sea> mockSeasMap;
//	@Mock Map<String,TradeDock> mockTradeDocksMap;
//	@Mock Map<String,Market> mockMarketsMap;
//	@Mock Map<String,Polis> mockPolisMap;
//	@Mock List<Project> mockGameProjects;
//	@Mock List<List<GameEvent>> mockGameEventsList;
//	@Mock Round mockTheRound;
//	@Mock MarketChart mockTheMarketChart;
//	@Mock Graph mockHopliteGraph;
//	@Mock Graph mockProxenusGraph;
//	@Mock Graph mockTradeBoatGraph;
//	@Mock Graph mockTrirremeGraph;
	
	// Game polisGame = new
	// Game(sparta,athens,territoriesMap,seasMap,tradeDocksMap,marketsMap,
	//polisMap,gameProjects,gameEventsList,theRound,theMarketChart,
	// hopliteGraph, proxenusGraph, tradeBoatGraph, trirremeGraph)
	
	
	@Before
	public void setup() {
	
		MockitoAnnotations.initMocks(this);
	}

	@After
	public void tearDown() throws Exception {

	

	}

	 @Test
	 public void TestInstance(){
		 ElementsInitializer e = new ElementsInitializer();
		assert (e.InitializeGameElements()instanceof Game);
	 }
	 
}
