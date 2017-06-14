package gameUC;

import java.util.ArrayList;

public class City {

	ArrayList<Level> level;
	private int actualLevel;
	int credit = Structure.creditBeginn;

	public int getCredit() {
		return credit;
	}

	City(){
		level = new ArrayList<Level>();
	}

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

	public void round(int n){

		for (int i = 0; i < n; i++){
			/** F�r jedes Element in Level ausf�hren*/
			for( Level l : level ){
				l.round();
				credit += l.getIncome();
				credit -= l.getExpenditure();
			}
		}

		/** n = �bergebener Parameter Spielrundeanzahl
		 * f�hrt n Spielrunden aus
		 *
		 * Gesammteinnahmen der Ebenen addiert
		 * Gesammtausgaben jeder Ebene vom Guthabe subtrahiert
		 * Structure.creditBeginng ist das Startguthaben */
	}

	public void output(){

		System.out.println("Guthaben: $ " + credit);

		/** welche Bauwerke stehen auf meine Ebene und wie viel Fs hab ich */
		for( Level l : level ){
			
			/** Vergleich bauebene l mit aktueller Bauebene*/
			if(l.equals(level.get(actualLevel))){
				System.out.print(" > ");
			}
			
			/** Bauwerke werden eingezeichnet */
			l.drawSlots();
			/** f�r Freie Slots*/
			int fs = l.getFreeSlots();
			for (int i = 0; i < fs; i++){
				System.out.print("*");
			}
			l.drawInfo();
		}

		/** Struktur der Stadt auf der Konsole ausgeben
		 *
		 * Guthaben $ 0000
		 * > HHVSPP**** Einwohner: 00 Einnahmen: 00 Kosten: 00 Qualit�t: 00 */
	}

	public void buildLevel(int n){
		/** n = Freie Slots
		 *Variante: Anstatt Structure.LevelCost k�nnte auch ein zweiter Parameter �bergeben werden 
		 *
		 *public static void buildLevel(int preis, int n){
		 *
		 *if (credit < preis * n  ){
		 *	System.out.println("Sie haben nicht gen�gend Guthaben");
		 *	return;
		 *}
		 *
		 *level.add(new Level(n));
		 *credit -= preis * n;
		 *}
		 */

		if (credit < Structure.levelCost * n  ){
			System.out.println("Sie haben nicht gen�gend Guthaben");
			return;
		}
		
		/** Element l und ArraList Level hinzugef�gt*/
		level.add(new Level(n));
		credit -= Structure.levelCost * n;

	}

	public void buildSkycraper(){

		/** F�gt Bauwerk Hochhaus auf aktuellen Bauebene aus, WENN gen�gend
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

	public void buildVilla(){
		/** F�gt Bauwerk Villa auf aktuellen Bauebene aus, WENN gen�gend
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

	public void buildMarket(){
		/** F�gt Bauwerk Supermarkt auf aktuellen Bauebene aus, WENN gen�gend
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
	
	public void buildHotel(){
		/** F�gt Bauwerk Villa auf aktuellen Bauebene aus, WENN gen�gend
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

	public void buildPark(){
		/** F�gt Bauwerk Park auf aktuellen Bauebene aus, WENN gen�gend
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
	
	public void buildShop(){
		/** F�gt Bauwerk Park auf aktuellen Bauebene aus, WENN gen�gend
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

	public int destroyer() {
		
		// zerst�rrt ein Geb�ude wenn Geld vorhanden ist
		
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
	
	public void bigDestroyer() {
		
		// Zerst�rrt alle gGeb�ude auf der akutellen Ebene und das aktuelle Level
		
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
		
		
		
			// Ist das Richtig so?
		level.get(actualLevel).destroyEverything();
		
		level.remove(actualLevel);
		
//		if (level.isEmpty()) {
//			actualLevel = 0;
//			return;
//		} 
		actualLevel = 0;
		credit -= Structure.destroyCostLevel;
	
} 
	
	
//	public void secret(){
//		credit = 0;
//		output();
//		System.out.println("Du hast verloren. #Spielleiterwillk�r");
//		System.exit(0);
//	} 


}	