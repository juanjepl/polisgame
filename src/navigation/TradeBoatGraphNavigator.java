package navigation;

import game.Graph;
import game.Player;
import game.Position;

public class TradeBoatGraphNavigator extends GenericGraphNavigator {

	public TradeBoatGraphNavigator(Player player, Position position1,
			Position position2, Graph graph)
	{
		super(player, position1, position2);
		this.graph = graph;
		existsWay();
	}

}
