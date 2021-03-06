package ui;

import game.Game;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

import cfg.GameConfigurations;

public class MainMenu extends AbstractMenu{
	
	private Game game;
	
	public MainMenu(Map<String,String> gameTexts, List<IMenu> menuList, Game game){
		super(gameTexts,menuList);
		String newGame = getGameTexts().get("mainMenu_newGame");
		String credits = getGameTexts().get("mainMenu_credits");
		String exit = getGameTexts().get("mainMenu_exit");
		getMenuOptionsList().add(newGame);
		getMenuOptionsList().add(credits);
		getMenuOptionsList().add(exit);
		this.game = game;
	}
	
	/**
	 * Getter methods for this class
	 */
	public Game getGame()
	{
		return game;
	}
	
	public String getHeaderMessage(){
		return getGameTexts().get("mainMenu_headerMessage");
	}

	public void execute() {
		showGameTitle();
		showMenuContents();
		setPlayerChoice(requestPlayerChoice());
		
	}

	public IMenu getNextMenu() {
		
		IMenu nextMenu = null;
		if(getPlayerChoice().equals(0))
		{
			nextMenu = new GameMainMenu(getGameTexts(),getMenuList(), getGame());
			nextMenu.setAutoExecutable(false); //FIXME provisional.
			requestPlayerNames();
			
		}else if(getPlayerChoice().equals(1))
		{
			nextMenu = new CreditsMenu(getGameTexts(),getMenuList());
		}else if(getPlayerChoice().equals(2))
		{
			nextMenu = new ExitMenu(getGameTexts(),getMenuList());
		}
		return nextMenu;
	}
	
	/**
	 * Method that shows Game Title message
	 *(last in source code file because its width)
	 */
	
	public void requestPlayerNames(){
		System.out.println(" ");
		System.out.println(getGameTexts().get("gameMainMenu_requestPlayerNames"));
		System.out.println(" ");
		System.out.println(getGameTexts().get("spartaPlayer") + " :");
		
		String spartaName = null;
		String athensName = null;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // request sparta player's name
		try {
			spartaName = br.readLine();
		} catch (Exception e) {	
			//TODO
		}
		
		System.out.println(" ");
		System.out.println(getGameTexts().get("athensPlayer") + " :");
		
		athensName = spartaName;
		Boolean firstTime = true;
		while(spartaName.equals(athensName)){
			
			if(!firstTime){
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