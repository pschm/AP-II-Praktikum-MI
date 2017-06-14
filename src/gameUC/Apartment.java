package gameUC;

public class Apartment extends Building {

//	protected int slot;
//	protected int cost;
//	protected int age;
//	protected String buildname;
	private int maxpopulation;
	private int actualpopulation;
	private int expectation;

	/** Konstruktor der Klasse Apartment */
	public Apartment(int slots, int cost, String name, int maxPop, int expect) {
		super(slots, cost, name);
		expectation   = expect;
		maxpopulation = maxPop;
	}

	/** Wenn Erwartungen, Alter und Gesamte Lebensqualität einen bestimmten Wert
	 *  Unterschreitet sinken
	 *  Überschreitet steigen 
	 */
	public void round (int totalquality){
		
		super.round(totalquality);
		
		int increase = ((totalquality + age)/expectation);	

		if((actualpopulation + increase) < maxpopulation){
			actualpopulation += increase;
		} else {
			//System.out.println("max Einwohnerzahl erreicht ");
			actualpopulation = maxpopulation;
		}
		
	}

	/** Einnahmen abhängig von Einwohnerzahlen */
	public int getIncome(){

		int income = super.getIncome();
		
		if (buildname  == Structure.skycraperName){
			income +=  Structure.skycraperIncome * actualpopulation;
		}

		if (buildname  == Structure.villaName){
			income +=  Structure.villaIncome * actualpopulation;
		}

		return income;
	}

	/** Anzahl der Einwohner */
	public int getPopulation(){
		return actualpopulation;
	}

	/** Ausgaben pro Apartment */
	public int getExpenditure(){
		return (Structure.dutyCost * actualpopulation)+Structure.dutyCost;
	}
}


