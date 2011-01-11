package game;

/**
 * This class implements check goods adjust
 * end round game rule. At round endings, player
 * loses perishable goods to half (rounding up)
 */
public class EndRoundCheckGoodsAdjust {

	public EndRoundCheckGoodsAdjust(Player p){
		p.setOil(Math.round((p.getOil() / 2)));
		p.setWine(Math.round((p.getWine() / 2)));
		p.setWheat(Math.round((p.getWheat() / 2)));
	}
}