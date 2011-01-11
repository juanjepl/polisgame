package ui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.List;
import java.util.LinkedList;

import cfg.GameConfigurations;
import utils.PolReader;
import game.Player;
import game.Round;
import game.Game;
import game.Turn;

/**
 * This class implements a user interface
 * using text console
 */
public class TextInterface{
	private IMenu focusedMenu;
	private List<IMenu> menuList;
	private Map<String,String> gameTexts;
	private Map<String,Boolean> checkActionsMap;
	
	public TextInterface(){
		PolReader gameTextsFileReader = new PolReader();
		gameTexts = gameTextsFileReader.readGameTexts();
		menuList = new LinkedList<IMenu>();
		
		focusedMenu = new MainMenu(getGameTexts(),getMenuList());
		menuList.add(focusedMenu); // First in the list
		
		//TODO
	}

	public void showMenuContents(){
		System.out.println(" "); // White line
		System.out.println(getMenu().getHeaderMessage()); // Prints message for the player
		System.out.println(" "); // White line
		
		// Shows the list of options to be chosen if exists
		if(!(getMenu().getMenuOptionsList().isEmpty())){
			Integer counter = 0;
			for(String optionInMenu : getMenu().getMenuOptionsList()){
				System.out.println(counter.toString() + " - "+ optionInMenu);
				counter += 1;
			}
		}
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
		
		//TODO
		//TODO
	}
	
	/**
	 * Getters and Setters for this class
	 */
	
	public Map<String,String> getGameTexts(){
		return gameTexts;
	}
	
	public Map<String,Boolean> getCheckActionsMap(){
		return checkActionsMap;
	}
	
	public List<IMenu> getMenuList(){
		return menuList;
	}
	
	public IMenu getMenu(){
		return focusedMenu;
	}
	
	public void setMenu(){
		
		if(focusedMenu.getNextMenu() == null){
			for(IMenu searchedMenu : getMenuList()){
				if(searchedMenu instanceof GameMainMenu){
					focusedMenu = searchedMenu;
					break;
				}
			}
			
			Integer limit = menuList.indexOf(focusedMenu);
			while(menuList.size() > limit){
				menuList.remove((getMenuList().size()) - 1);
			}

		}else{
			focusedMenu = focusedMenu.getNextMenu();
		}
		//TODO posible ampliacion
	}
	public void showNewRound(Round round)
	{
		System.out.println(" ");
		System.out.println(getGameTexts().get("newRound")  + ": " + round.getRoundName());
	}
	
	public void showFirstActionMessage(){
		System.out.println(" ");
		System.out.println("--- "+getGameTexts().get("firstAction") + " " + getGameTexts().get("action")+" ---");
	}
	
	public void requestPlayerNames()
	{

		System.out.println(" ");
		System.out.println(getGameTexts().get("gameMainMenu_requestPlayerNames"));
		System.out.println(" ");
		System.out.println(getGameTexts().get("gameMainMenu_spartaPlayer") + " :");
		
		String spartaName = null;
		String athensName = null;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // request sparta player's name
		try {
			spartaName = br.readLine();
		} catch (Exception e) {	
			//TODO
		}
		
		System.out.println(" ");
		System.out.println(getGameTexts().get("gameMainMenu_athensPlayer") + " :");
		
		athensName = spartaName;
		Boolean firstTime = true;
		while(spartaName.equals(athensName)){
			
			if(!firstTime)
			{
				System.out.println(" ");
				System.out.println(getGameTexts().get("gameMainMenu_errorSameNames") + " :");
			}
			
			BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in)); // request sparta player's name
			try {
				athensName = br2.readLine();
			} catch (Exception e) {	
				//TODO
			}
			
			firstTime = false;
		}
		
		GameConfigurations.setSpartaPlayerName(spartaName);
		GameConfigurations.setAthensPlayerName(athensName);
	}

	/**
	 * Method that shows Game Title message
	 *(last in source code file because its width)
	 */
	
	public void showGameTitle(){
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("                                                      ..");
		System.out.println("                                                  .:.8 $...");
		System.out.println("                                                  DI. IZ..");
		System.out.println("                                                 M. .I,.,");
		System.out.println("                                               .I ..M.NN.");
		System.out.println("                                               ?.,~.  O,");
		System.out.println("                                               7..7N   NN.");
		System.out.println("                                              N..NNN . ONN.");
		System.out.println("                                              . .NNNNNNNNNN");
		System.out.println("                                             .  .DNNNNNNNNM.");
		System.out.println("                                           .  .o...?NN.,.$N= .");
		System.out.println("                                        .  .D.IODNNNNNN.IND  .    ........");
		System.out.println("                                   . . .:...NN:N,NNN.ND.INI......~ND..D.");
		System.out.println("                                   ,O$,.N...NNNNNN~ NNNMN7,$7N7....N....");
		System.out.println("                              ..NN..=...NN8.=N=8NN.=NM.ZN.=..IZ.,...");
		System.out.println("                            .ZNN..D$..NNNNNNDNZNZNNO.II87I     . o.");
		System.out.println("                            oNNNN7NNNNN:  :.?NNN7NNNO$   ~      .NN.");
		System.out.println("                               ,NNNNNNNNNN7NNNN.,NN..N    ,...  =N~Z.");
		System.out.println("                              ,:NNNNONNNNNNN:D,?=.NN N. .. ONN..$..:");
		System.out.println("                          ..8ONNNNNN.NNNN .NNN.?I N.NN. .   . N $...D");
		System.out.println("                    ...INN= $NNNN.NN.NNDN.NZNN 7o NM~8O . ..M .I,...N.");
		System.out.println("                ...D7..  ..NN.M. .N.NNNN:NZNN. D..?N.oN ,.  ,..M ? .N.");
		System.out.println("               .N ...    ,N     .NM.NNNNNNNNN  N.:oN..=...   ..M.N..DD");
		System.out.println("              oNNNND.   ..     .NNNNNNNNNNNND  o..N. ..~.I     M ...Z.");
		System.out.println("             .N=.  N.        .Z:$,o   NNNNNN, .MN? . .DN.,     N. D :..");
		System.out.println("             ~N..ZN         .D. NN    NNNNND .,.D    .8Z:Z .   N. N ..,.");
		System.out.println("             IN=NN .        N. ~oNN  NNNN7ND.$.N..   ...NN.    N..N  DI.");
		System.out.println("             :NNNN        .$...NNNNN7:NNN.oM.D..     ..MN .    N. N  OO");
		System.out.println("        ...:NNNNN.       ..   NNNNNNNN   ZOM...        .~ N=  .,NNN   O.");
		System.out.println("         NNNNNN..       .   .oNNNNNNNNND   .8Z.         N7.,    $N    I.");
		System.out.println("         ,NNNN=        ..   .NNNNNNNNNNNN:  ..N:       ..=..7    .   ..");
		System.out.println("          NN..       .N    .NNNNNNNNNNNNNNNN. ..o        N? ,:");
		System.out.println("          .NM       .8.  .   .NNNNNNNNNNNNNN7I ..~        .          M");
		System.out.println("           .        7~      .INNNNNNNNNNNNNNNN,O..$..     .,  .I   ...");
		System.out.println("                   ?N:.      NNNNNNN .:NNNNNNN8N$Z.N~     ...   .N88..");
		System.out.println("                  $NNN       NNNN~,.  .MZ .NNNN.MNo.o$I");
		System.out.println("                =NNNNo      :NN,D     =,.     :N.NNNNNN.      Z....,.");
		System.out.println("                . NNo       D.N      .:.       .NNNNNNZ         ..");
		System.out.println("                          .:N                 .NNNNNNN");
		System.out.println("                      . .  ,D  .             .NN. NNN");
		System.out.println("                    .ZNNN..NNNN7             NN..=NN.");
		System.out.println("                 ,N$~.. .,NNNNNNN.         . N?..NNN.");
		System.out.println("               :N..DNNNNNNoNNNNZ.          ..N:. NN.");
		System.out.println("        ...  DN~NNNNNNNNNNNNNNNN.          ..N?.NNN");
		System.out.println("       $8D...NNNNNNN?..   . ....             NNNNN..");
		System.out.println("       $NN?DNNNN?.                           NNNNN");
		System.out.println("      .NNNNNN: .                           ..NN.N8");
		System.out.println("      .NNNN.                               .8N.?N~");
		System.out.println("      NNNN                                 .N.~.NN");
		System.out.println("     .NNN.                                 ,NNNNNNN.");
		System.out.println("      .NN.                                ..NNNNNNNNN ...");
		System.out.println("        .                                   8NNNNNNNNNNN.");
		System.out.println("                                                    .");
		System.out.println("");
		System.out.println("        ooooooooo.     .oooooo.   ooooo        ooooo  .oooooo..o");
		System.out.println("        `888   `Y88.  d8P'  `Y8b  `888'        `888' d8P'    `Y8");
		System.out.println("         888   .d88' 888      888  888          888  Y88bo.");
		System.out.println("         888ooo88P'  888      888  888          888   `'Y8888o.");
		System.out.println("         888         888      888  888          888       `'Y88b");
		System.out.println("         888         `88b    d88'  888       o  888  oo     .d8P");
		System.out.println("        o888o         `Y8bood8P'  o888ooooood8 o888o 80088888P'");
		System.out.println("");
		System.out.println("");
	}
}