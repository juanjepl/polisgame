package game;

public class TradeAction extends PoliticAction{

	private Player player;
	private Round round;
	private MarketChart marketChart;
	private Market market;
	private String resource1;
	private String resource2;
	private Integer dice;
	
	public TradeAction(Player player,Round round, MarketChart marketChart, Market market, String resource1, String resource2, Integer dice){
		super();
		if(player == null){
			throw new IllegalArgumentException("Player musn't be null");
		}
		if(round == null){
			throw new IllegalArgumentException("Round musn't be null");
		}
		if(marketChart == null){
			throw new IllegalArgumentException("MarketChart musn't be null");
		}
		if(market == null){
			throw new IllegalArgumentException("Market musn't be null");
		}
		
		this.player = player;
		this.round = round;
		this.marketChart = marketChart;
		this.market = market;
		this.resource1 = resource1;
		this.resource2 = resource2;
		this.dice = dice;
		
		if(getResource1().equals("silver")){
			
			//player trade without market fluctuation in resource1
			Integer amountResource2 = getMarket().tradeResources(getResource1(), getResource2());
			
			//player pays the amount of resource1 equivalent to amount of resource2
			Integer amountPaid = getPlayer().getSilver();
			amountPaid -= amountResource2;
			getPlayer().setSilver(amountPaid);
			
			//player obtains amount of resource2 demanded
			Integer amountObtained = getPlayer().getWheat();
			amountObtained += amountResource2;
			getPlayer().setWheat(amountObtained);
			
			//associated resource to resource2 must be revaluated
			
			String associatedResource = getMarket().getAssociatedResource(getResource2(), amountResource2);
			//player rolls the dice twice
			 Integer positions = -getDice();
			
			//market add value to resource associated to resource2
			getMarketChart().moveResourcePrice(getRound().getRoundName(), associatedResource, positions);
			
		}else if(getResource1().equals("wheat")){
			
			//player trade without market fluctuation in resource1
			Integer amountResource2 = getMarket().tradeResources(getResource1(), getResource2());
			
			//player pays the amount of resource1 equivalent to amount of resource2
			Integer amountPaid = getPlayer().getWheat();
			amountPaid -= amountResource2;
			getPlayer().setWheat(amountPaid);
			
			//player obtains amount of resource2 demanded
			Integer amountObtained = getPlayer().getSilver();
			amountObtained += amountResource2;
			getPlayer().setSilver(amountObtained);
			
			//associated resource to resource2 must be revaluated
			
			String associatedResource = getMarket().getAssociatedResource(getResource2(), amountResource2);
			//player rolls the dice twice
			 Integer positions = -getDice();
			
			//market add value to resource associated to resource2
			getMarketChart().moveResourcePrice(getRound().getRoundName(), associatedResource, positions);
			
		}else
		{
			//player pays the amount of resource1 contained in Market Chart
			Integer amountResource2 = getMarket().tradeResources(getResource1(), getResource2());
			Integer amountResource1 = getMarketChart().getPrice(getResource1());
			
			Integer amountPaid = getPlayer().getResource(getResource1());
			amountPaid -= amountResource1;
			getPlayer().setResource(getResource1(), amountPaid);
			
			Integer amountObtained = getPlayer().getResource(getResource2());
			amountObtained += amountResource2;
			getPlayer().setResource(getResource2(), amountObtained);
			
			//market devaluates resource1
			
			//player rolls the dice once
			Integer positions = -getDice();
			getMarketChart().moveResourcePrice(getRound().getRoundName(), getResource1(), positions);
			
		}
	}
	
	public Player getPlayer()
	{
		return player;
		
	}
	
	public Round getRound()
	{
		return round;
	}
	
	public MarketChart getMarketChart()
	{
		return marketChart;
	}
	
	public Market getMarket()
	{
		return market;
	}
	
	public String getResource1()
	{
		return resource1;
	}
	
	public String getResource2()
	{
		return resource2;
	}
	
	public Integer getDice()
	{
		return dice;
	}
}
