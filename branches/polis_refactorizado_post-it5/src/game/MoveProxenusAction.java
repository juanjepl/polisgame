package game;

public class MoveProxenusAction extends MilitaryAction{

	private Player player;
	private Polis destiny;
	private Integer amountToPayForWay;

	public MoveProxenusAction(Player player, Polis destiny, Integer amountToPayForWay){
		super();
		if(player == null){
			throw new IllegalArgumentException("Player musn't be null");
		}
		
		this.player = player;
		this.destiny = destiny;
		this.amountToPayForWay = amountToPayForWay;
		
		getPlayer().setSilver(getPlayer().getSilver() - getAmountToPayForWay());
	
		getPlayer().getPlayerProxenus().setPosition(getDestiny());
		
	}
	
	public Player getPlayer()
	{
		return player;
	}
	
	public Integer getAmountToPayForWay()
	{
		return amountToPayForWay;
	}
	
	public Polis getDestiny()
	{
		return destiny;
	}
	
}
