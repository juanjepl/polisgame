package game;

import java.util.Map;

/**
 * This class manages the assignation
 * of a project into a polis
 */
public class StartAProjectAction extends PoliticAction{
	
	Player player;
	Polis polis;
	Project project;
	Map<String,Integer> paymentChosenByThePlayer;
	
	public StartAProjectAction(Player pl, Polis po, Project proj, Map<String,Integer> payment){
		super();
		
		if(pl == null || po == null || proj == null){
			throw new IllegalArgumentException("Invalid parameter in StartAProjectAction");
		}
	
		player = pl;
		polis = po;
		project = proj;
		paymentChosenByThePlayer = payment;

		for(String str : getPaymentChosenByThePlayer().keySet()){
			getPlayer().setResource(str, getPlayer().getResource(str) - getPaymentChosenByThePlayer().get(str));
		}
		
		getProject().setUsed(true);
		getPolis().addProject(project);
	}

	public Player getPlayer() {
		return player;
	}

	public Polis getPolis() {
		return polis;
	}

	public Project getProject() {
		return project;
	}
	
	public Map<String,Integer> getPaymentChosenByThePlayer(){
		return paymentChosenByThePlayer;
	}
}