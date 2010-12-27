package game;

import java.util.Vector;

/** Class who manages game market chart */
public class MarketChart {
	
	private Integer metalPrice; // Prices by element 
	private Integer woodPrice;
	private Integer winePrice;
	private Integer oilPrice;
	
	private Integer metalPricePointer; // Pointers who point price's vector actual position
	private Integer woodPricePointer;
	private Integer winePricePointer;
	private Integer oilPricePointer;

	private Vector<Integer> round3_prices = new Vector<Integer>(); // Prices's container vector by round
	private Vector<Integer> round4_prices = new Vector<Integer>();
	private Vector<Integer> round5_prices = new Vector<Integer>();
	
	
	public MarketChart(){
		
		// initializes the 3 vectors with prices values by round
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
		
		// pointers initialization ( 0 because it's the first position in a Array/Vector/List ... )
		metalPricePointer = 0;
		woodPricePointer = 0;
		winePricePointer = 0;
		oilPricePointer = 0;
		
		
		// Initializes start prices. (round 3 by default)
		metalPrice = round3_prices.get(metalPricePointer);
		woodPrice = round3_prices.get(woodPricePointer);
		winePrice = round3_prices.get(winePricePointer);
		oilPrice = round3_prices.get(oilPricePointer);
	}
	
	/** Method that manages variations in market chart's prices */
	public void moveResourcePrice(String activeRound, String resource, Integer positions){ // positions must be negative value in some times (when player uses silver to pay)
		
		if(resource.equals("Metal")){
			// adjusts price pointer
			metalPricePointer += positions;  
			if(metalPricePointer > 10){        //
				metalPricePointer = 10;        //
			}                                  //  Prevents out of range fails (same in all next resources source code)
			else if(metalPricePointer < 0){    //
				metalPricePointer = 0;         //
			}                                  //
			
			// adjusts price
			if(activeRound.equals("3")){
				metalPrice = round3_prices.get(metalPricePointer);
			}
			else if(activeRound.equals("4")){
				metalPrice = round4_prices.get(metalPricePointer);
			}
			else if((activeRound.equals("5A"))||(activeRound.equals("5B"))){
				metalPrice = round5_prices.get(metalPricePointer);
			}		
		}
		
		if(resource.equals("Wood")){
			// adjusts price pointer
			woodPricePointer += positions;
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
			else if((activeRound.equals("5A"))||(activeRound.equals("5B"))){
				woodPrice = round5_prices.get(woodPricePointer);
			}		
		}
		
		if(resource.equals("Wine")){
			// adjusts price pointer
			winePricePointer += positions;
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
			else if((activeRound.equals("5A"))||(activeRound.equals("5B"))){
				winePrice = round5_prices.get(winePricePointer);
			}		
		}
		
		if(resource.equals("Oil")){
			// adjusts price pointer
			oilPricePointer += positions;
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
			else if((activeRound.equals("5A"))||(activeRound.equals("5B"))){
				oilPrice = round5_prices.get(oilPricePointer);
			}		
		}
	}

	
	/** Price getters */
	
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
	
	public Integer getPrice(String resource)
	{
		Integer value = 0;
		if(resource.equals("metal"))
		{
			value = metalPrice;
		}else if(resource.equals("wood"))
		{
			value = woodPrice;
		}else if(resource.equals("wine"))
		{
			value = winePrice;
		}else if(resource.equals("oil"))
		{
			value = oilPrice;
		}
		
		return value;
	}	
}