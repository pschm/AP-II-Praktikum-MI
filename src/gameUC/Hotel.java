package gameUC;

public class Hotel extends Building{
	

	private int actualpopulation;
	
	/** Konstruktor der Klasse Hotel */
	public Hotel(int slots, int cost, String name, int maxPop, int expect){
		super(slots, cost, name);	
	}
	
	/** Random generierte Anzahl an Einwohnern die sich im Hotel befinden */	
	public void round (int totalquality){
	
		super.round(totalquality);
		int maxpop = actualpopulation;
		
		maxpop += (int) ( Math.random () * Structure.hotelMaxPopulation);
			
		maxpop -= (int) ( Math.random () * Structure.hotelMaxPopulation);
		
		/** Abfrage ob der Wert zwischen 0 und maxpopulation ist 
		 * Wenn 0 dann 0 
		 * Wenn maxpopulation dann 200
		 */	
		if( maxpop < 0){
			actualpopulation = 0;
			return;
		}
		
		if( maxpop > Structure.hotelMaxPopulation){
			actualpopulation = Structure.hotelMaxPopulation;
			return;
		}
		
		actualpopulation = maxpop;
		
	}

	/** Einkommen abhänig von der Einwohnerzahl */	
	public int getIncome(){

		int income = super.getIncome();
		
			income +=  Structure.hotelIncome * actualpopulation;
		
		return income;
	}
	
	/** Anzahl der Einwohner */	
	public int getPopulation() {
		return actualpopulation;
	}
	
	/** Ausgaben pro Hotel */	
	public int getExpenditure(){
		return Structure.hotelDutyCost;
	}
	
}
