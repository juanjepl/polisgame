package game;

import java.util.Vector;

public class MarketChart {
	
	private Integer metalPrice;
	private Integer woodPrice;
	private Integer winePrice;
	private Integer oilPrice;
	
	private Integer metalPricePointer;
	private Integer woodPricePointer;
	private Integer winePricePointer;
	private Integer oilPricePointer;

	private Vector<Integer> round3_prices = new Vector<Integer>();
	private Vector<Integer> round4_prices = new Vector<Integer>();
	private Vector<Integer> round5_prices = new Vector<Integer>();
	
	
	public MarketChart(){
		
		// initializes the 3 vectors
		round3_prices.add(3);
		round3_prices.add(4);
		round3_prices.add(4);
		round3_prices.add(4);
		round3_prices.add(4);
		round3_prices.add(4);
		round3_prices.add(4);
		round3_prices.add(5);
		round3_prices.add(5);
		round3_prices.add(5);
		round3_prices.add(5);
		
		round4_prices.add(4);
		round4_prices.add(5);
		round4_prices.add(5);
		round4_prices.add(5);
		round4_prices.add(5);
		round4_prices.add(6);
		round4_prices.add(6);
		round4_prices.add(7);
		round4_prices.add(7);
		round4_prices.add(8);
		round4_prices.add(8);
		
		round5_prices.add(5);
		round5_prices.add(6);
		round5_prices.add(6);
		round5_prices.add(7);
		round5_prices.add(7);
		round5_prices.add(8);
		round5_prices.add(9);
		round5_prices.add(10);
		round5_prices.add(11);
		round5_prices.add(12);
		round5_prices.add(13);
		
		// pointers
		metalPricePointer = 0;
		woodPricePointer = 0;
		winePricePointer = 0;
		oilPricePointer = 0;
		
		
		// round 3 default
		metalPrice = round3_prices.get(metalPricePointer);
		woodPrice = round3_prices.get(woodPricePointer);
		winePrice = round3_prices.get(winePricePointer);
		oilPrice = round3_prices.get(oilPricePointer);
		
		
	}
	
	public void moveResourcePrice(String activeRound, String resource, Integer positions){
		
		if(resource.equals("Metal")){
			// adjusts price pointer
			metalPricePointer += positions; // positions must be negative in some cases
			if(metalPricePointer > 10){
				metalPricePointer = 10;
			}
			else if(metalPricePointer < 0){
				metalPricePointer = 0;
			}
			
			// adjusts price
			if(activeRound.equals("3")){
				metalPrice = round3_prices.get(metalPricePointer);
			}
			else if(activeRound.equals("4")){
				metalPrice = round4_prices.get(metalPricePointer);
			}
			else if((activeRound.equals("5a"))||(activeRound.equals("5b"))){
				metalPrice = round5_prices.get(metalPricePointer);
			}		
		}
		
		if(resource.equals("Wood")){
			// adjusts price pointer
			woodPricePointer += positions; // positions must be negative in some cases
			if(woodPricePointer > 10){
				woodPricePointer = 10;
			}
			else if(woodPricePointer < 0){
				woodPricePointer = 0;
			}
			
			// adjusts price
			if(activeRound.equals("3")){
				woodPrice = round3_prices.get(woodPricePointer);
			}
			else if(activeRound.equals("4")){
				woodPrice = round4_prices.get(woodPricePointer);
			}
			else if((activeRound.equals("5a"))||(activeRound.equals("5b"))){
				woodPrice = round5_prices.get(woodPricePointer);
			}		
		}
		
		if(resource.equals("Wine")){
			// adjusts price pointer
			winePricePointer += positions; // positions must be negative in some cases
			if(winePricePointer > 10){
				winePricePointer = 10;
			}
			else if(winePricePointer < 0){
				winePricePointer = 0;
			}
			
			// adjusts price
			if(activeRound.equals("3")){
				winePrice = round3_prices.get(winePricePointer);
			}
			else if(activeRound.equals("4")){
				winePrice = round4_prices.get(winePricePointer);
			}
			else if((activeRound.equals("5a"))||(activeRound.equals("5b"))){
				winePrice = round5_prices.get(winePricePointer);
			}		
		}
		
		if(resource.equals("Oil")){
			// adjusts price pointer
			oilPricePointer += positions; // positions must be negative in some cases
			if(oilPricePointer > 10){
				oilPricePointer = 10;
			}
			else if(oilPricePointer < 0){
				oilPricePointer = 0;
			}
			
			// adjusts price
			if(activeRound.equals("3")){
				oilPrice = round3_prices.get(oilPricePointer);
			}
			else if(activeRound.equals("4")){
				oilPrice = round4_prices.get(oilPricePointer);
			}
			else if((activeRound.equals("5a"))||(activeRound.equals("5b"))){
				oilPrice = round5_prices.get(oilPricePointer);
			}		
		}
	}

	public Integer getMetalPrice() {
		return metalPrice;
	}

	public Integer getWoodPrice() {
		return woodPrice;
	}

	public Integer getWinePrice() {
		return winePrice;
	}

	public Integer getOilPrice() {
		return oilPrice;
	}
	
}
