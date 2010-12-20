package game;

/** This class contains the methods for execute creation actions in the game */
public class CreatorAction extends GameAction{

	public CreatorAction(){}


	
	/** Creates a Trade Boat unit in polis's trade dock */
	public Boolean createTradeBoat(Player owner, Polis polis, Round round){
		Boolean success = false;
		
		success = AvailableActionsManager.checkCreateTrirremeAction(owner,polis,round);
		
		if(success){

			if(owner.getWood()>=1 && owner.getSilver()<1){
				owner.setWood(owner.getWood() - 1);
			}else if(owner.getWood()<1 && owner.getSilver()>=1){
				owner.setSilver(owner.getSilver() - 1);
			}else{

				String paid = TextModeUi.requestPaidMethod( "tradeBoat" );

				if(paid.equals( "Wood" ) ){
					owner.setWood(owner.getWood() - 1);
				}else if(paid.equals( "Silver" ) ){
					owner.setSilver(owner.getSilver() - 1);
				}else{
					success = false;
				}
			}
			polis.setActualPopulation(polis.getActualPopulation() - 1);
			
			TradeBoat tb = new TradeBoat(owner,owner.getPlayerTradeDock());
			owner.getPlayerTradeDock().addUnit(tb);
			owner.addUnit(tb);
			
			TextModeUi.showMessage("TradeBoat created at "+owner.getPlayerTradeDock().getName()); //FIXME from gameTexts
			
			}else{
				//Do nothing,success=false;
			}
		return success;
	}
	
	/** Creates a Proxenus unit in selected polis */
	public Boolean createProxenus(Player owner, Polis polis){
		Boolean success = false;
		success = AvailableActionsManager.checkCreateProxenusAction (owner , polis);
		
		if(success){
		
		owner.setSilver ( owner.getSilver() - 4);
		polis.setActualPopulation ( polis.getActualPopulation() - 1);
		Proxenus prox = new Proxenus(owner,polis);
		polis.getUnits().add(prox);
		owner.setPlayerProxenus(prox);
		
		TextModeUi.showMessage("Proxenus created at "+polis.getName()); //FIXME from gameTexts
		
		}else{
			//do nothing->return success=false
		}
		return success;
	}

