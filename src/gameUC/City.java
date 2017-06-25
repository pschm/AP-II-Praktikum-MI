package gameUC;

import java.util.ArrayList;
import javax.swing.JOptionPane;


public class City {

	private ArrayList<Level> level;
	private int actualLevel;
	int credit = Structure.creditBeginn;
	String f = "Fehlermeldung";
	String l = "Game Over";
	String w = "Congratulation";

	/** Konstruktur der KLasse City */
	City(){
		level = new ArrayList<Level>();
	}

	/** Die aktuelle Ebene */
	public int getActualLevel() {
		return actualLevel;
	}
	
	/** Setzen der aktuellen Ebene*/
	public void setActualLevel(int actualLevel) {
		this.actualLevel = actualLevel;
	}

	/** Level */
	public ArrayList<Level> getLevel(){
		return level;
	}



	/** Ebene erhöhnen */
	public void higher(){

		/** prüfen ob die unterste Ebene erreicht wurde */
		if (actualLevel == level.size()-1) {
			JOptionPane.showMessageDialog(null, "Sie haben die niedrigste Ebene erreicht");
			System.out.println("Sie befinden sich auf der niedrigsten Ebende");
			return;
		} 

		actualLevel += 1;
	}

	/** Ebene runter */
	public void lower(){

		/** prüfen ob die höchste Ebene erreicht wurde */

		if (actualLevel == 0) {
			JOptionPane.showMessageDialog(null, "Sie haben die höchste Ebene erreicht");
			System.out.println("Sie befinden sich auf der höchsten Ebende");
			return;
		}
		actualLevel -= 1;
	}

	/** Spielrunde für alle Ebenen */
	public void round(int n){

		for (int i = 0; i < n; i++){
			/** Für jedes Element in Level ausführen*/
			for( Level l : level ){
				l.round();
				credit += l.getIncome();
				credit -= l.getExpenditure();
				breakUp();
//				win();
			}
		}

		/**
		 * Führt n Spielrunden aus
		 * Gesammteinnahmen den Ebenen addiert
		 * Gesammtausgaben jeder Ebene subtrahiert
		 */
	}

	/** Ausgabe der vorhandenen Informationen */
	public void output(){

		System.out.println("Guthaben: $ " + credit + "\n");

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
		 * HHHHPP**** Einwohner: 00 Einnahmen: 00 Kosten: 00 Qualität: 00 
		 * > ******** Einwohner: 00 Einnahmen: 00 Kosten: 00 Qualität: 00 
		 * ********** Einwohner: 00 Einnahmen: 00 Kosten: 00 Qualität: 00 
		 * 
		 * */
	}

	/** Bauen der Ebene */
	public void buildLevel(int n){
		/** n = Freie Slots */

		if ( level.size() >= Structure.numMaxLevel){	
			JOptionPane.showMessageDialog(null, "Sie haben die maximale Anzahl an Ebenen erreicht", f, JOptionPane.OK_OPTION);
			System.out.println("Du kannst nicht mehr Ebenen bauen");
			return;
		}
		
		if (credit < Structure.levelCost * n  ){
			JOptionPane.showMessageDialog(null, "Sie haben leider nicht genügend Geld", f, JOptionPane.OK_OPTION);
			System.out.println("Sie haben nicht genügend Guthaben");
			return;
		}

		/** Element l und ArraList Level hinzugefügt*/
		level.add(new Level(n));
		credit -= Structure.levelCost * n;

	}

	/** Bauen eines Hochhaus */
	public void buildSkycraper(){

		/** 
		 * Fügt Bauwerk Hochhaus auf aktuellen Bauebene aus, WENN genügend
		 * Slots und Guthaben vorhanden sind. Bei bau zieht Guthaben ab
		 */

		if (credit < Structure.skycraperCost ){
			JOptionPane.showMessageDialog(null, "Sie haben leider nicht genügend Geld", f, JOptionPane.OK_OPTION);
			System.out.println("Nicht genügend Geld vorhanden");
			return;
		}
		if (level.isEmpty()){
			JOptionPane.showMessageDialog(null, "Es ist keine Ebene vorhanden die bebaut werden könnte", f, JOptionPane.OK_OPTION);
			System.out.println("Keine Ebene vorhanden -  Baue erst eine Ebene");
			return;
		}
		if ( level.get(actualLevel).getFreeSlots() < Structure.skycraperSlot ){
			JOptionPane.showMessageDialog(null, "Die ausgewählte Ebene ist zu klein", f, JOptionPane.OK_OPTION);
			System.out.println("Deine Ebene ist zu klein");
			return;
		}
		level.get(actualLevel).insertBuilding(new Apartment(Structure.skycraperSlot, Structure.skycraperCost, Structure.skycraperName, Structure.skycraperMaxPopulation, Structure.skycraperExpectation));
		credit -= Structure.skycraperCost;

	}

	/** Bauen eines Villa */
	public void buildVilla(){

		/** 
		 * Fügt Bauwerk Villa auf aktuellen Bauebene aus, WENN genügend
		 * Slots und Guthaben vorhanden sind. Bei bau zieht Guthaben ab
		 */

		if (credit < Structure.villaCost){
			JOptionPane.showMessageDialog(null, "Sie haben leider nicht genügend Geld", f, JOptionPane.OK_OPTION);
			System.out.println("Nicht genügend Geld vorhanden");
			return;
		}
		if (level.isEmpty()){
			JOptionPane.showMessageDialog(null, "Es ist keine Ebene vorhanden die bebaut werden könnte", f, JOptionPane.OK_OPTION);
			System.out.println("Keine Ebene vorhanden -  Baue erst eine Ebene");
			return;
		}
		if ( level.get(actualLevel).getFreeSlots() < Structure.villaSlot ){
			JOptionPane.showMessageDialog(null, "Die ausgewählte Ebene ist zu klein", f, JOptionPane.OK_OPTION);
			System.out.println("Deine Ebene ist zu klein");
			return;
		}
		level.get(actualLevel).insertBuilding(new Apartment(Structure.villaSlot, Structure.villaCost, Structure.villaName, Structure.villaMaxPopulation, Structure.villaExpectation));
		credit -= Structure.villaCost;

	}

	/** Bauen eines Supermarktes */
	public void buildMarket(){

		/** 
		 * Fügt Bauwerk Supermarkt auf aktuellen Bauebene aus, WENN genügend
		 * Slots und Guthaben vorhanden sind. Bei bau zieht Guthaben ab
		 */

		if (credit < Structure.marketCost){
			JOptionPane.showMessageDialog(null, "Sie haben leider nicht genügend Geld", f, JOptionPane.OK_OPTION);
			System.out.println("Nicht genügend Geld vorhanden");
			return;
		}
		if (level.isEmpty()){
			JOptionPane.showMessageDialog(null, "Es ist keine Ebene vorhanden die bebaut werden könnte", f, JOptionPane.OK_OPTION);
			System.out.println("Keine Ebene vorhanden -  Baue erst eine Ebene");
			return;
		}
		if ( level.get(actualLevel).getFreeSlots() < Structure.marketSlot ){
			JOptionPane.showMessageDialog(null, "Die ausgewählte Ebene ist zu klein", f, JOptionPane.OK_OPTION);
			System.out.println("Deine Ebene ist zu klein");
			return;
		}
		level.get(actualLevel).insertBuilding(new Infrastructure(Structure.marketSlot, Structure.marketCost, Structure.marketName, Structure.marketLifequality)); 
		credit -= Structure.marketCost;

	}

	/** Bauen eines Hotels */
	public void buildHotel(){

		/** 
		 * Fügt Bauwerk Hotels auf aktuellen Bauebene aus, WENN genügend
		 * Slots und Guthaben vorhanden sind. Bei bau zieht Guthaben ab
		 */

		if (credit < Structure.hotelCost){
			JOptionPane.showMessageDialog(null, "Sie haben leider nicht genügend Geld", f, JOptionPane.OK_OPTION);
			System.out.println("Nicht genügend Geld vorhanden");
			return;
		}
		if (level.isEmpty()){
			JOptionPane.showMessageDialog(null, "Es ist keine Ebene vorhanden die bebaut werden könnte", f, JOptionPane.OK_OPTION);
			System.out.println("Keine Ebene vorhanden -  Baue erst eine Ebene");
			return;
		}
		if ( level.get(actualLevel).getFreeSlots() < Structure.hotelSlot ){
			JOptionPane.showMessageDialog(null, "Die ausgewählte Ebene ist zu klein", f, JOptionPane.OK_OPTION);
			System.out.println("Deine Ebene ist zu klein");
			return;
		}
		level.get(actualLevel).insertBuilding(new Hotel(Structure.hotelSlot, Structure.hotelCost, Structure.hotelName, Structure.hotelMaxPopulation, Structure.hotelExpectation));
		credit -= Structure.hotelCost;

	}

	/** Bauen eines Parks */
	public void buildPark(){

		/** 
		 * Fügt Bauwerk Park auf aktuellen Bauebene aus, WENN genügend
		 * Slots und Guthaben vorhanden sind. Bei bau zieht Guthaben ab
		 */

		if (credit < Structure.parkCost ){
			JOptionPane.showMessageDialog(null, "Sie haben leider nicht genügend Geld", f, JOptionPane.OK_OPTION);
			System.out.println("Nicht genügend Geld vorhanden");
			return;
		}
		if (level.isEmpty()){
			JOptionPane.showMessageDialog(null, "Es ist keine Ebene vorhanden die bebaut werden könnte", f, JOptionPane.OK_OPTION);
			System.out.println("Keine Ebene vorhanden -  Baue erst eine Ebene");
			return;
		}
		if ( level.get(actualLevel).getFreeSlots() < Structure.parkSlot ){
			JOptionPane.showMessageDialog(null, "Die ausgewählte Ebene ist zu klein", f, JOptionPane.OK_OPTION);
			System.out.println("Deine Ebene ist zu klein");
			return;
		}
		level.get(actualLevel).insertBuilding(new Infrastructure(Structure.parkSlot, Structure.parkCost, Structure.parkName, Structure.parkLifequality)); 
		credit -= Structure.parkCost;
	}		

	/** Bauen eines Ladens */
	public void buildShop(){

		/** 
		 * Fügt Bauwerk Ladens auf aktuellen Bauebene aus, WENN genügend
		 * Slots und Guthaben vorhanden sind. Bei bau zieht Guthaben ab
		 */

		if (credit < Structure.shopCost ){
			JOptionPane.showMessageDialog(null, "Sie haben leider nicht genügend Geld", f, JOptionPane.OK_OPTION);
			System.out.println("Nicht genügend Geld vorhanden");
			return;
		}
		if (level.isEmpty()){
			JOptionPane.showMessageDialog(null, "Es ist keine Ebene vorhanden die bebaut werden könnte", f, JOptionPane.OK_OPTION);
			System.out.println("Keine Ebene vorhanden -  Baue erst eine Ebene");
			return;
		}
		if ( level.get(actualLevel).getFreeSlots() < Structure.shopSlot ){
			JOptionPane.showMessageDialog(null, "Die auswählte Ebene ist zu klein", f, JOptionPane.OK_OPTION);
			System.out.println("Deine Ebene ist zu klein");
			return;
		}
		level.get(actualLevel).insertBuilding(new Infrastructure(Structure.shopSlot, Structure.shopCost, Structure.shopName, Structure.shopLifequality)); 
		credit -= Structure.shopCost;
	}	

	/** zerstörrt das letzte Gebäude */
	public int destroyer() {

		/** 
		 * Zerstörrung wenn Geld vorhanden
		 */

		if (credit < Structure.destroyCostBuilding){
			JOptionPane.showMessageDialog(null, "Sie haben leider nicht genügend Geld", f, JOptionPane.OK_OPTION);
			System.out.println("Nicht genügend Geld vorhanden");
			return -1;
		} else
			if (level.isEmpty()){
				JOptionPane.showMessageDialog(null, "Die auswählte Ebene ist zu klein", f, JOptionPane.OK_OPTION);
				System.out.println("Deine Ebene ist zu klein");
				return -1;
			} else 

				if (level.get(actualLevel).destroyBuilding()){
					credit -= Structure.destroyCostBuilding;
					return 0;
				}


		return -3;

	} 

	/** zerstörrt eine Ebene */
	public void bigDestroyer() {

		/** 
		 * Zerstörrung: alle Gebäude auf der akutellen Ebene und die Ebene selbst
		 * Zerstörung wenn Geld vorhanden
		 */

		if (credit < Structure.destroyCostLevel){
			JOptionPane.showMessageDialog(null, "Die haben leider nicht genügend Geld", f, JOptionPane.OK_OPTION);
			System.out.println("Nicht genügend Geld");
			return;
		}

		if (level.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Es ist keine Ebene vorhanden die zerstörrt werden könnte", f, JOptionPane.OK_OPTION);
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

	/** Spielleiter willkür */
	public void secret(){
		credit = 0;
		output();
		JOptionPane.showMessageDialog(null, "Du hast verloren", l, JOptionPane.CANCEL_OPTION);
		System.out.println("Du hast verloren. #Spielleiterwillkür");
		System.exit(0);
	} 

	public int getCredit(){
		return credit;
	}

	public void breakUp(){
		if (credit < 0){
			JOptionPane.showMessageDialog(null, "Du hast verlosen - Grund: Kein Geld mehr", f, JOptionPane.OK_OPTION);
			System.out.println("Du bst Pleite und hast verloren");
			output();
			System.exit(0);
		} 
	}

	public boolean win(){
		if (credit >= 1000000){
			JOptionPane.showMessageDialog(null, "Du hast gewonnen - Grund: Guthaben über 1.000.000", w, JOptionPane.OK_OPTION);
			System.out.println("Du hast gewonnen");
			output();
			return true;
		} 
	 return false;

	}

}	