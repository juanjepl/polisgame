package game;

import java.util.List;
import java.util.LinkedList;

public class Player {
	private String name;
	private List<Polis> playerPolis;
	private Integer prestige;
	private Integer wood;
	private Integer metal;
	private Integer wine;
	private Integer oil;
	private Integer wheat;
	private Integer silver;
	private Boolean hasPassedTurn;
	
	public Player(String name){
		this.name = name;
		hasPassedTurn = false;
		playerPolis = new LinkedList<Polis>();
		prestige = 0;
		wood = 0;
		metal = 0;
		wine = 0;
		oil = 0;
		wheat = 0;
		silver = 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrestige() {
		return prestige;
	}

	public void setPrestige(Integer prestige) {
		this.prestige = prestige;
	}

	public Integer getWood() {
		return wood;
	}

	public void setWood(Integer wood) {
		this.wood = wood;
	}

	public Integer getMetal() {
		return metal;
	}

	public void setMetal(Integer metal) {
		this.metal = metal;
	}

	public Integer getWine() {
		return wine;
	}

	public void setWine(Integer wine) {
		this.wine = wine;
	}

	public Integer getOil() {
		return oil;
	}

	public void setOil(Integer oil) {
		this.oil = oil;
	}

	public Integer getWheat() {
		return wheat;
	}

	public void setWheat(Integer wheat) {
		this.wheat = wheat;
	}

	public Integer getSilver() {
		return silver;
	}

	public void setSilver(Integer silver) {
		this.silver = silver;
	}

	public List<Polis> getPlayerPolis() {
		return playerPolis;
	}
	
	public void addPolis(Polis polis){
		//TODO
	}
	public void removePolis(Polis polis){
		//TODO
	}
	
	public Boolean getHasPassedTurn() {
		return hasPassedTurn;
	}

	public void setHasPassedTurn(Boolean hasPassedTurn) {
		this.hasPassedTurn = hasPassedTurn;
	}
	
	public static Integer rollTheDice(){
		Integer number = 0;
		//TODO a dice with 4 faces
		return number;
	}


	
	
}
