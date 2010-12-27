package game;

/**
 * This class implements megalopolis
 * condition in end rounds, for any polis with
 * more population than its base, its owner wins
 * one point prestige per polis like that
 */
public class EndRoundCheckMegalopolis {

	public EndRoundCheckMegalopolis(Player p){
		for (Polis po : p.getPlayerPolis()) {
			if (po.getActualPopulation() > po.getBasePopulation()) {
				p.setPrestige(p.getPrestige() + 1);
			}
		}
	}
}