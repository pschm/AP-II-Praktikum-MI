package gameUC;

public class Apartment extends Building {

//	protected int slot;
//	protected int cost;
//	protected int age;
//	protected String buildname;
	private int maxpopulation;
	private int actualpopulation;
	private int expectation;

	/** Konstruktor */
	public Apartment(int slots, int cost, String name, int maxPop, int expect) {
		super(slots, cost, name);
		expectation   = expect;
		maxpopulation = maxPop;
	}

	/** Pro Runde: Wenn die Erwartungen, das Alter und die totalQuality einen bestimmten Wert über- oder unterschreiten die Einwohnerzahl steigen/sinken */
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

	/** Anzahl der Anwohner zurück geben */
	public int getPopulation(){
		return actualpopulation;
	}

	public int getExpenditure(){
		return (Structure.dutyCost * actualpopulation)+Structure.dutyCost;
	}
}


