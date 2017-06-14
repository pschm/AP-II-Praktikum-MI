package gameUC;

import java.util.ArrayList;

public class City {

	ArrayList<Level> level;
	private int actualLevel;
	int credit = Structure.creditBeginn;


	/** Konstruktur der KLasse City */
	City(){
		level = new ArrayList<Level>();
	}

	/** Die aktuelle Ebene */
	public int getActualLevel() {
		return actualLevel;
	}



	/** Ebene erh�hnen */
	public void higher(){

		/** pr�fen ob die unterste Ebene erreicht wurde */
		if (actualLevel == level.size()-1) {
			System.out.println("Sie befinden sich auf der niedrigsten Ebende");
			return;
		} 

		actualLevel += 1;
	}

	/** Ebene runter */
	public void lower(){

		/** pr�fen ob die h�chste Ebene erreicht wurde */

		if (actualLevel == 0) {
			System.out.println("Sie befinden sich auf der h�chsten Ebende");
			return;
		}
		actualLevel -= 1;
	}

	/** Spielrunde f�r alle Ebenen */
	public void round(int n){

		for (int i = 0; i < n; i++){
			/** F�r jedes Element in Level ausf�hren*/
			for( Level l : level ){
				l.round();
				credit += l.getIncome();
				credit -= l.getExpenditure();
			}
		}

		/**
		 * F�hrt n Spielrunden aus
		 * Gesammteinnahmen den Ebenen addiert
		 * Gesammtausgaben jeder Ebene subtrahiert
		 */
	}

	/** Ausgabe der vorhandenen Informationen */
	public void output(){

		System.out.println("Guthaben: $ " + credit);

		for( Level l : level ){

			/** Vergleich Bauebene l mit aktueller Bauebene*/
			if(l.equals(level.get(actualLevel))){
				System.out.print(" > ");
			}

			/** Bauwerke werden eingezeichnet */
			l.drawSlots();

			/** Freie Slots*/
			int fs = l.getFreeSlots();
			for (int i = 0; i < fs; i++){
				System.out.print("*");
			}
			l.drawInfo();
		}

		/** Struktur der Stadt auf der Konsole ausgeben
		 *
		 * Guthaben $ 0000
		 * HHHHPP**** Einwohner: 00 Einnahmen: 00 Kosten: 00 Qualit�t: 00 
		 * > ******** Einwohner: 00 Einnahmen: 00 Kosten: 00 Qualit�t: 00 
		 * ********** Einwohner: 00 Einnahmen: 00 Kosten: 00 Qualit�t: 00 
		 * 
		 * */
	}

	/** Bauen der Ebene */
	public void buildLevel(int n){
		/** n = Freie Slots */

		if (credit < Structure.levelCost * n  ){
			System.out.println("Sie haben nicht gen�gend Guthaben");
			return;
		}

		/** Element l und ArraList Level hinzugef�gt*/
		level.add(new Level(n));
		credit -= Structure.levelCost * n;

	}

	/** Bauen eines Hochhaus */
	public void buildSkycraper(){

		/** 
		 * F�gt Bauwerk Hochhaus auf aktuellen Bauebene aus, WENN gen�gend
		 * Slots und Guthaben vorhanden sind. Bei bau zieht Guthaben ab
		 */

		if (credit < Structure.skycraperCost ){
			System.out.println("Nicht gen�gend Geld vorhanden");
			return;
		}
		if ( level.get(actualLevel).getFreeSlots() < Structure.skycraperSlot ){
			System.out.println("Deine Ebene ist zu klein");
			return;
		}
		level.get(actualLevel).insertBuilding(new Apartment(Structure.skycraperSlot, Structure.skycraperCost, Structure.skycraperName, Structure.skycraperMaxPopulation, Structure.skycraperExpectation));
		credit -= Structure.skycraperCost;

	}

	/** Bauen eines Villa */
	public void buildVilla(){

		/** 
		 * F�gt Bauwerk Villa auf aktuellen Bauebene aus, WENN gen�gend
		 * Slots und Guthaben vorhanden sind. Bei bau zieht Guthaben ab
		 */

		if (credit < Structure.villaCost){
			System.out.println("Nicht gen�gend Geld vorhanden");
			return;
		}
		if ( level.get(actualLevel).getFreeSlots() < Structure.villaSlot ){
			System.out.println("Deine Ebene ist zu klein");
			return;
		}
		level.get(actualLevel).insertBuilding(new Apartment(Structure.villaSlot, Structure.villaCost, Structure.villaName, Structure.villaMaxPopulation, Structure.villaExpectation));
		credit -= Structure.villaCost;

	}

	/** Bauen eines Supermarktes */
	public void buildMarket(){

		/** 
		 * F�gt Bauwerk Supermarkt auf aktuellen Bauebene aus, WENN gen�gend
		 * Slots und Guthaben vorhanden sind. Bei bau zieht Guthaben ab
		 */

		if (credit < Structure.marketCost){
			System.out.println("Nicht gen�gend Geld vorhanden");
			return;
		}
		if ( level.get(actualLevel).getFreeSlots() < Structure.marketSlot ){
			System.out.println("Deine Ebene ist zu klein");
			return;
		}
		level.get(actualLevel).insertBuilding(new Infrastructure(Structure.marketSlot, Structure.marketCost, Structure.marketName, Structure.marketLifequality)); 
		credit -= Structure.marketCost;

	}

	/** Bauen eines Hotels */
	public void buildHotel(){

		/** 
		 * F�gt Bauwerk Hotels auf aktuellen Bauebene aus, WENN gen�gend
		 * Slots und Guthaben vorhanden sind. Bei bau zieht Guthaben ab
		 */

		if (credit < Structure.hotelCost){
			System.out.println("Nicht gen�gend Geld vorhanden");
			return;
		}
		if ( level.get(actualLevel).getFreeSlots() < Structure.hotelSlot ){
			System.out.println("Deine Ebene ist zu klein");
			return;
		}
		level.get(actualLevel).insertBuilding(new Hotel(Structure.hotelSlot, Structure.hotelCost, Structure.hotelName, Structure.hotelMaxPopulation, Structure.hotelExpectation));
		credit -= Structure.hotelCost;

	}

	/** Bauen eines Parks */
	public void buildPark(){

		/** 
		 * F�gt Bauwerk Park auf aktuellen Bauebene aus, WENN gen�gend
		 * Slots und Guthaben vorhanden sind. Bei bau zieht Guthaben ab
		 */

		if (credit < Structure.parkCost ){
			System.out.println("Nicht gen�gend Geld vorhanden");
			return;
		}
		if ( level.get(actualLevel).getFreeSlots() < Structure.parkSlot ){
			System.out.println("Deine Ebene ist zu klein");
			return;
		}
		level.get(actualLevel).insertBuilding(new Infrastructure(Structure.parkSlot, Structure.parkCost, Structure.parkName, Structure.parkLifequality)); 
		credit -= Structure.parkCost;
	}		

	/** Bauen eines Ladens */
	public void buildShop(){

		/** 
		 * F�gt Bauwerk Ladens auf aktuellen Bauebene aus, WENN gen�gend
		 * Slots und Guthaben vorhanden sind. Bei bau zieht Guthaben ab
		 */

		if (credit < Structure.shopCost ){
			System.out.println("Nicht gen�gend Geld vorhanden");
			return;
		}
		if ( level.get(actualLevel).getFreeSlots() < Structure.shopSlot ){
			System.out.println("Deine Ebene ist zu klein");
			return;
		}
		level.get(actualLevel).insertBuilding(new Infrastructure(Structure.shopSlot, Structure.shopCost, Structure.shopName, Structure.shopLifequality)); 
		credit -= Structure.shopCost;
	}	

	/** zerst�rrt das letzte Geb�ude */
	public int destroyer() {

		/** 
		 * Zerst�rrung wenn Geld vorhanden
		 */

		if (credit < Structure.destroyCostBuilding){
			System.out.println("Nicht gen�gend Geld vorhanden");
			return -1;
		}

		credit -= Structure.destroyCostBuilding;
		if (level.get(actualLevel).destroyBuilding()){
			return 0;
		}


		return -3;

	} 

	/** zerst�rrt eine Ebene */
	public void bigDestroyer() {

		/** 
		 * Zerst�rrung: alle Geb�ude auf der akutellen Ebene und die Ebene selbst
		 * Zerst�rung wenn Geld vorhanden
		 */

		if (credit < Structure.destroyCostLevel){
			System.out.println("Nicht gen�gend Geld");
			return;
		}

		if (level.isEmpty()) {
			System.out.println("Keine Ebene Vorhanden");
			return;
		} 

		int keepDestroying;
		do { 
			keepDestroying = destroyer();
		} while (keepDestroying == 0);


		level.get(actualLevel).destroyEverything();

		level.remove(actualLevel);

		if (level.isEmpty()) {
			actualLevel = 0;
			return;
		} 
		actualLevel = 0;
		credit -= Structure.destroyCostLevel;

	} 

	/** Spielleiter willk�r */
	public void secret(){
		credit = 0;
		output();
		System.out.println("Du hast verloren. #Spielleiterwillk�r");
		System.exit(0);
	} 


}	