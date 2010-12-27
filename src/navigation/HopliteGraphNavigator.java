package navigation;

import game.Player;
import game.Position;

public class HopliteGraphNavigator extends GenericGraphNavigator {

	public HopliteGraphNavigator(Player player, Position position1, Position position2, Graph graph)
	{
		super(player, position1, position2);
		this.graph = graph;
		existsWay();
		
	}
}
