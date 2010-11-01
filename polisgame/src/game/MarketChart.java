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

	private Vector<Integer> r3_prices = new Vector<Integer>();
	private Vector<Integer> r4_prices = new Vector<Integer>();
	private Vector<Integer> r5_prices = new Vector<Integer>();
	
	
	public MarketChart(){
		
		// initializes the 3 vectors
		r3_prices.add(3);
		r3_prices.add(4);
		r3_prices.add(4);
		r3_prices.add(4);
		r3_prices.add(4);
		r3_prices.add(4);
		r3_prices.add(4);
		r3_prices.add(5);
		r3_prices.add(5);
		r3_prices.add(5);
		r3_prices.add(5);
		
		r4_prices.add(4);
		r4_prices.add(5);
		r4_prices.add(5);
		r4_prices.add(5);
		r4_prices.add(5);
		r4_prices.add(6);
		r4_prices.add(6);
		r4_prices.add(7);
		r4_prices.add(7);
		r4_prices.add(8);
		r4_prices.add(8);
		
		r5_prices.add(5);
		r5_prices.add(6);
		r5_prices.add(6);
		r5_prices.add(7);
		r5_prices.add(7);
		r5_prices.add(8);
		r5_prices.add(9);
		r5_prices.add(10);
		r5_prices.add(11);
		r5_prices.add(12);
		r5_prices.add(13);
		
		// pointers
		metalPricePointer = 0;
		woodPricePointer = 0;
		winePricePointer = 0;
		oilPricePointer = 0;
		
		
		// round 3 default
		metalPrice = r3_prices.get(metalPricePointer);
		woodPrice = r3_prices.get(woodPricePointer);
		winePrice = r3_prices.get(winePricePointer);
		oilPrice = r3_prices.get(oilPricePointer);
		
		
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
				metalPrice = r3_prices.get(metalPricePointer);
			}
			else if(activeRound.equals("4")){
				metalPrice = r4_prices.get(metalPricePointer);
			}
			else if((activeRound.equals("5a"))||(activeRound.equals("5b"))){
				metalPrice = r5_prices.get(metalPricePointer);
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
				woodPrice = r3_prices.get(woodPricePointer);
			}
			else if(activeRound.equals("4")){
				woodPrice = r4_prices.get(woodPricePointer);
			}
			else if((activeRound.equals("5a"))||(activeRound.equals("5b"))){
				woodPrice = r5_prices.get(woodPricePointer);
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
				winePrice = r3_prices.get(winePricePointer);
			}
			else if(activeRound.equals("4")){
				winePrice = r4_prices.get(winePricePointer);
			}
			else if((activeRound.equals("5a"))||(activeRound.equals("5b"))){
				winePrice = r5_prices.get(winePricePointer);
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
				oilPrice = r3_prices.get(oilPricePointer);
			}
			else if(activeRound.equals("4")){
				oilPrice = r4_prices.get(oilPricePointer);
			}
			else if((activeRound.equals("5a"))||(activeRound.equals("5b"))){
				oilPrice = r5_prices.get(oilPricePointer);
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
