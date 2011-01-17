package ui;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import utils.PolReader;
import game.Market;
import game.Player;
import game.Position;
import game.Project;
import game.Proxenus;
import game.Round;
import game.Game;
import game.Sea;
import game.Territory;
import game.TradeDock;
import game.Turn;
import game.Polis;
import game.Unit;

/**
 * This class implements a user interface
 * using text console
 */
public class TextInterface{
	private IMenu focusedMenu;
	private List<IMenu> menuList;
	private Map<String,String> gameTexts;
	
	public TextInterface(Game game){
		//game can be null for initialization
		PolReader gameTextsFileReader = new PolReader();
		gameTexts = gameTextsFileReader.readGameTexts();
		menuList = new ArrayList<IMenu>();
		
		focusedMenu = new MainMenu(getGameTexts(),getMenuList(),game);
		menuList.add(focusedMenu); // First in the list

	}

	public void showChangeOfRound(Round theNewRound){
		if(theNewRound == null){
			throw new IllegalArgumentException("Invalid parameter for showChangeOfRound, cannot be null");
		}
		System.out.println(" "); // White line
		System.out.println(getGameTexts().get("TextInterface_newRoundMessage")+" "+getGameTexts().get("round")+" "+theNewRound.getRoundName());
	}
	
	public void showRTAPMessage(Player player, Turn turn){
		if(player == null || turn == null){
			throw new IllegalArgumentException("Invalid paramater(s) for showRTAPMessage(), cannot be null");
		}
		
		String numberAction = "";
		
		if(turn.getSecondAction() == null){
			numberAction = getGameTexts().get("firstAction");
		}else{
			numberAction = getGameTexts().get("secondAction");
		}
		
		System.out.println(" "); // White line
		System.out.println(getGameTexts().get("player")+": "+player.getName()+"   "+getGameTexts().get("turn")+": "+Turn.getTurnCount().toString()+"   "+getGameTexts().get("action")+": "+numberAction);
	}
	
	public void showCurrentStateOfTheGame(Game theGame){
		if(theGame == null){
			throw new IllegalArgumentException("Invalid parameter for showCurrentStateOfTheGame(), cannot be null");
		}
		
		Player focusedPlayer = theGame.getWhoHasTheTurn();
		
		// Shows Round+Turn+Action+Player message (R+T+A+P)
		showRTAPMessage(focusedPlayer,theGame.getRound().getCurrentTurn());
		
		System.out.println(" ");
		System.out.println("::::" + getGameTexts().get("resources") + "::::"); 
		System.out.println(
		"[" + getGameTexts().get("prestige") +": " + focusedPlayer.getPrestige().toString() + "]" + "  " + 
		"[" + getGameTexts().get("metal") +": " + focusedPlayer.getMetal().toString() + "]" + "  " + 
		"[" + getGameTexts().get("wood") +": " + focusedPlayer.getWood().toString() + "]" + "  " +
		"[" + getGameTexts().get("wheat") +": " + focusedPlayer.getWheat().toString() + "]" + "  " +
		"[" + getGameTexts().get("oil") +": " + focusedPlayer.getOil().toString() + "]" + "  " +
		"[" + getGameTexts().get("wine") +": " + focusedPlayer.getWine().toString() + "]" + "  " +
		"[" + getGameTexts().get("silver") +": " + focusedPlayer.getSilver().toString() + "]"
		);
		
		System.out.println(" ");
		System.out.println("::::" + getGameTexts().get("playerPolis") + "::::");	
		
		for(Polis po:focusedPlayer.getPlayerPolis()){
			
			String polisData = "[" + po.getName() + "]" + " => " + "[" + po.getActualPopulation().toString() + "] " + "(" + po.getBasePopulation().toString() + ") " + po.getMaxPopulation().toString() + " " + po.getMaxGrowth().toString();
			String sieged = getGameTexts().get("sieged");
			
			if(po.getSieged()){
				polisData = polisData + " - " + sieged + getGameTexts().get("yes");
			}else{
				polisData = polisData + " - " + sieged + getGameTexts().get("no");
			}
			
			System.out.println(polisData);
			
			String startedProject = "  -> " + getGameTexts().get("startedProject") + ": ";
			String finishedProjects = "  -> " + getGameTexts().get("finishedProjects") + ": " ;
			String none = getGameTexts().get("none");
			
			List<String> projectsFinished = new ArrayList<String>();
			
			// started project
			Boolean started = false;
			if(!po.getProjects().isEmpty()){
				for(Project proj : po.getProjects()){
					if(!proj.getFinished()){
						startedProject = startedProject + proj.getName();
						started = true;
						break;
					}	
				}	
			}
			if(started == false){
				startedProject = startedProject + none;
			}
			
			System.out.println(startedProject);
			
			// finished projects
			Boolean existsAnyFinishedProject = false;
			if(!po.getProjects().isEmpty()){
				for(Project proj : po.getProjects()){
					if(proj.getFinished()){
						projectsFinished.add(proj.getName());
						existsAnyFinishedProject = true;
					}	
				}
				
				for(String s : projectsFinished){
					finishedProjects = finishedProjects + s + " ";
				}
			}
			
			if(!existsAnyFinishedProject){
				finishedProjects = finishedProjects + none;
			}

			System.out.println(finishedProjects);
			
		}
		
		// Units location
		
		System.out.println(" ");
		System.out.println("::::" + getGameTexts().get("units") + "::::"); 

		List<Position> wherePlayerHaveUnits = new ArrayList<Position>();
		
		for(Unit u : focusedPlayer.getPlayerUnits()){
			if(!wherePlayerHaveUnits.contains(u.getPosition()) && !(u instanceof Proxenus)){ // we prefer calculate proxenus in other place
				wherePlayerHaveUnits.add(u.getPosition());
			}
		}
		
		for(Position pos : wherePlayerHaveUnits){
			if(pos instanceof Territory || pos instanceof Polis){
				System.out.println("[" + pos.getName() +"] -> " + pos.getHoplitesForAPlayer(focusedPlayer).size() + " " + getGameTexts().get("hoplites"));
			}
			
			else if(pos instanceof Market || pos instanceof TradeDock){
				System.out.println("[" + pos.getName() +"] -> " + pos.getTradeBoatsForAPlayer(focusedPlayer).size() + " " + getGameTexts().get("tradeBoats"));
			}
			
			else if(pos instanceof Sea){
				System.out.println("[" + pos.getName() +"] -> " + pos.getTrirremesForAPlayer(focusedPlayer).size() + " " + getGameTexts().get("trirremes"));
			}
		}
		
		String proxenusposmess = getGameTexts().get("proxenusPosition") + " ";
		String proxenuspos;
		
		if(focusedPlayer.getPlayerProxenus() == null){
			proxenuspos = getGameTexts().get("noProxenus");
		}else{
			proxenuspos = focusedPlayer.getPlayerProxenus().getPosition().getName();
		}
		
		System.out.println(proxenusposmess + proxenuspos); 
		
		// MarketChart Prices
		System.out.println(" "); // White line
		System.out.println("::::" + getGameTexts().get("marketChartPrices") + "::::");
		System.out.println(getGameTexts().get("metal") + ": " + theGame.getMarketChart().getMetalPrice().toString());
		System.out.println(getGameTexts().get("wood") + ": " + theGame.getMarketChart().getWoodPrice().toString());
		System.out.println(getGameTexts().get("wine") + ": " + theGame.getMarketChart().getWinePrice().toString());
		System.out.println(getGameTexts().get("oil") + ": " + theGame.getMarketChart().getOilPrice().toString());
	}
	
	/**
	 * Getters and Setters for this class
	 */
	
	public Map<String,String> getGameTexts(){
		return gameTexts;
	}
	
	public List<IMenu> getMenuList(){
		return menuList;
	}
	
	public IMenu getMenu(){
		return focusedMenu;
	}
	
	public void executeMenu()
	{
		while(getMenu() != null && getMenu().getAutoExecutable())
		{
			getMenu().execute();
			setMenu();	
		}
	}
	
	public void setMenu(){

		if(!(getMenuList().contains(getMenu())))
		{
			getMenuList().add(getMenu());
		}else
		{
			Integer limit = getMenuList().indexOf(getMenu()); //limit + 2 index = size index
			while(getMenuList().size() - 1 > limit){
				getMenuList().remove((getMenuList().size()) - 1);
			}
		}
		
		focusedMenu = getMenu().getNextMenu();
		
	}
	public void showNewRound(Round round)
	{
		System.out.println(" ");
		System.out.println(getGameTexts().get("newRound")  + ": " + round.getRoundName());
	}
	
	public void showFirstActionMessage(){
		System.out.println(" ");
		System.out.println("---------- "+getGameTexts().get("firstAction") + " " + getGameTexts().get("action")+" ----------");
	}
	
	public void showSecondActionMessage(){
		System.out.println(" ");
		System.out.println("---------- "+getGameTexts().get("secondAction") + " " + getGameTexts().get("action")+" ----------");
	}

	public void setGame(Game game){
		getMenu().setGame(game);
	}
}