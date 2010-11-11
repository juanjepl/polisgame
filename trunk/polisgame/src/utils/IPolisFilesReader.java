package utils;
import java.util.Map;
import java.util.List;
import game.Sea;
import game.Territory;
import game.Market;
import game.Project;
import game.TradeDock;
import game.GameEvent;
import game.Polis;


public interface IPolisFilesReader {

	public Map<String,Sea> readSeas();
	public Map<String,TradeDock> readTradeDocks();
	public List<Project> readProjects();
	public Map<String,Market> readMarkets();
	public List<List<GameEvent>> readGameEvents();
	public Map<String,Polis> readPolis();
	public Map<String,Territory> readTerritories();
	
}
