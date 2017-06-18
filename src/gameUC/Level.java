package gameUC;

import java.util.ArrayList;

public class Level {

	ArrayList<Building> building;
	private int freeSlots;

	/** Konstruktor der die Anzahl der Freien Slots festlegt*/
	Level(int numFreeSlots){
		freeSlots = numFreeSlots;
		building = new ArrayList<Building>();
	}

	/** Fügt ein Bauwerk am Ende der Liste ein. */
	public void insertBuilding(Building b){
		/** Jedes Bauwerk verbraucht Slots
		 * d.h. die Anzahl der freien Slots muss sinken 
		 * 
		 * Sind genügend Slots vorhanden?
		 * 
		 */

		if (freeSlots >= b.needSlots()){
			building.add(b);
			freeSlots -= b.needSlots();
		}

	}

	public boolean destroyBuilding(){

		if (building.isEmpty()) {
			System.out.println("Kein Gebäude Vorhanden");
			return false;
		}  
		int index = building.size() - 1;

		Building b  = building.get(index);
		building.remove(index);
		
		int lose = 0;
		if (b instanceof Infrastructure){
			lose += ((Infrastructure) b).getPopulation();
			System.out.println("Die Ebene hat " +lose+ " Einwohner verloren");
			
		}
		
		freeSlots += b.needSlots(); 
		return true;
		
		
		
	}

	public void destroyEverything(){

		// Alle Gebäude einer Ebene sollen gelöscht werden
		building.clear();
		freeSlots = Structure.smallLevelSlot;
	}

	/** wie viele Slots sind frei */
	public int getFreeSlots(){
		return freeSlots;
	}

	/** Führt genau eine Spielrunde für diese Ebene aus */
	public void round(){

		int life = getLifequality();
		for(Building b : building){
			if (b instanceof Apartment){
				((Apartment) b).round(life);
			} else 
				if (b instanceof Hotel){
					((Hotel) b).round(life);
				} else 
					if (b instanceof Infrastructure){
						((Infrastructure) b).round(life);
					}

		}
		/** Lebensqualität berechnen
		 * ruft für jedes Bauwerk der Ebene die Methode round(...) mit diesem Wert auf	*/
	}

	/**  Zeichnet die Bauwerke auf den einzelnen Slots*/
	public void drawSlots(){
		String cain = new String();

		for(Building b : building){
			cain += b.drawing();
		}
		System.out.print(cain);	
	}

	/** Gibt Informationen der Ebene aus (Anz Einwohner, Lebenquali, Einnahmen und Ausgaben) */
	public String drawInfo(){
		int pop = getPopulation();
		int life = getLifequality();
		int income = getIncome();
		int expen  = getExpenditure();
		
		String s = " Einwohner: " + pop + " Einnahmen: " + income + " Kosten: " + expen +  " Lebenqualität: " + life ;
		System.out.print( s + "\n" );
		return s;
	}

	/** Anzahl der Einwohner der Ebene */
	public int getPopulation(){
		int pop = 0;

		for (Building b : building){

			if ( b instanceof Apartment ) {
				/** Springt in Klasse: Apartment Methode: getIncome() */
				pop += ((Apartment) b).getPopulation();
			} else if ( b instanceof Hotel ) {
				/** Springt in Klasse: Hotel Methode: getPoplutaion() */
				pop += ((Hotel) b).getPopulation();
			} else {
				/** Springt in Klasse: Building Methode: getIncome() */
				pop += b.getPopulation();
			}
		}
		/** Anzahl der Einahmen der Ebene pro Spielrunde */
		return pop;

	}

	/** Anzahl der Einahmen der Ebene pro Spielrunde */
	public int getIncome(){
		int income = 0;

		for (Building b : building){

			if ( b instanceof Apartment ) {
				/** Springt in Klasse: Apartment Methode: getIncome()*/
				income +=  b.getIncome();
			} else if ( b instanceof Hotel ) {
				/** Springt in Klasse: Apartment Methode: getIncome()*/
				income += ((Hotel) b).getIncome();
			}else {
				if (b instanceof Infrastructure){
					/** Springt in Klasse: Building Methode: getIncome()*/
					income +=  b.getIncome();
				}
				else
					income += b.getIncome();
			} 

		}

		return income;
	}

	/** Anzahl der Ausgaben der Ebene pro Spielrunde */
	public int getExpenditure(){
		int expen = 0;

		/** für jedes Bauwerk in einer Ebene 
		 * in Klasse: City Methode: round() für alle Ebenen*/
		for (Building b : building){

			if ( b instanceof Apartment ) {
				/** Springt in Klasse: Apartment Methode: getIncome() */
				expen += b.getExpenditure();
			} else if ( b instanceof Hotel) {
				/** Springt in Klasse: Hotel Methode: getIncome() */
				expen += b.getExpenditure();
			}
			else 
				expen += b.getExpenditure();
		}
		/** Anzahl der Einahmen der Ebene pro Spielrunde*/
		return expen;

	}

	/** Lebensquali innerhalb der Ebene */
	public int getLifequality(){
		int life = 0;

		for (Building b : building){
			if ( b instanceof Infrastructure ) {
				/** Springt in Klasse: Apartment Methode: getLifequality() */
				life += ((Infrastructure) b).getLifequality();
			} 
			else {
				/** Springt in Klasse: Building Methode: getLifequality() */
				life += b.getLifequality();
			}
		}
		return life;
	}
}
