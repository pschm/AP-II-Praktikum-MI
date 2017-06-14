package gameUC;



public class Infrastructure extends Building {

	private int lifequality = 0;

	/** Konstruktor der Klasse Infrastructure*/
	public Infrastructure(int slots, int cost, String name, int life){
		super(slots, cost, name);
		lifequality = life;
	}

	/** Wer der Lebensqualit�t */
	public int getLifequality(){
		return lifequality;
	}

	public void round(int totalquality){
		/** Neuberechung der Lebensqualit�t */


		super.round(totalquality);
		lifequality += ((age * totalquality)/50);

		if (lifequality > Structure.maxlifequality){
			lifequality = Structure.maxlifequality;
		}

	}

	/** Berechnung des Einkommens f�r einen Shop */
	public int getIncome(){

		int income = super.getIncome();
		if (buildname == Structure.shopName){
			income += ((Structure.shopIncome * lifequality)/20);
		}

		return income;
	}
}


