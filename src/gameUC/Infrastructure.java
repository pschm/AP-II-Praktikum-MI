package gameUC;

public class Infrastructure extends Building {

	private int lifequality = 0;

	/** Konstruktor */
	public Infrastructure(int slots, int cost, String name, int life){
		super(slots, cost, name);
		lifequality = life;
	}

	/** Wert, um den sich die Lebensqualität erhöhrt */
	public int getLifequality(){
		return lifequality;
	}
	
//	public int getLifequality() {
//		if (buildname == Structure.marketName){
//			lifequality += Structure.marketLifequality;
//		} 
//		
//		if (buildname == Structure.parkName){
//			lifequality += Structure.parkLifequality;
//		}
//		
//		if (lifequality > Structure.maxlifequality){
//			lifequality = Structure.maxlifequality;
//		}
//
//		return lifequality;
//	}

	public void round(int totalquality){
		/** 
		* Pro Runde wird die lebensqualität neu berechnet
		*/

		
		super.round(totalquality);
		lifequality += ((age * totalquality)/50);
		
		if (lifequality > Structure.maxlifequality){
			lifequality = Structure.maxlifequality;
		}
		
	}	
}


