package gameUC;

public class Hotel extends Building{
	

	private int actualpopulation;
	
	
	public Hotel(int slots, int cost, String name, int maxPop, int expect){
		super(slots, cost, name);	
	}
	
	public void round (int totalquality){
		
		super.round(totalquality);
		int maxpop = actualpopulation;
		
		maxpop += (int) ( Math.random () * Structure.hotelMaxPopulation);
			
		maxpop -= (int) ( Math.random () * Structure.hotelMaxPopulation);
		
		if( maxpop < 0){
			actualpopulation = 0;
			return;
		}
		
		if( maxpop > 200){
			actualpopulation = Structure.hotelMaxPopulation;
			return;
		}
		
		actualpopulation = maxpop;
		
	}

	public int getIncome(){

		int income = super.getIncome();
		
			income +=  Structure.hotelIncome * actualpopulation;
		
		return income;
	}
	
	public int getPopulation() {
		return actualpopulation;
	}
	
	public int getExpenditure(){
		return Structure.hotelDutyCost;
	}
	
}
