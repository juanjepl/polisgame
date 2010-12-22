package navigation;

import game.Graph;
import game.Player;
import game.Position;

public class ProxenusGraphNavigator extends GenericGraphNavigator {

	private Integer amountToPayForWay;
	
	public ProxenusGraphNavigator(Player player, Position position1,
			Position position2, Graph graph)
	{
		super(player, position1, position2);
		this.graph = graph;
		existsWay();
	}
	
	protected void existsWay()
	{
		
	}
	
	public Integer getAmountToPayForWay()
	{
		return amountToPayForWay;
	}

}
