package gameUC;



public class Building {


	/**  protected anstatt private damit sie in den Unterklassen benutzt werden kann */
	protected int slot;
	protected int cost;
	protected int age;
	protected String buildname;


	/** Sinnvoll: Weg lassen? Kein Objekt der Klasse Building erstellen sondern nur Apartment und Infrastructure
	 *Damit es keine Bauwerke an sich gibt sondern nur noch Wohneinheiten und Infra. (außer Standart Konstruktor) */
	public Building(int slot, int cost, String name ) {
		age = 0;
		this.slot = slot;
		this.cost = cost;
		this.buildname = name;
	}

	/** Die benötigten Slots für ein Bauwerk */
	int needSlots(){

		switch(buildname){

		case Structure.skycraperName : return Structure.skycraperSlot;

		case Structure.villaName : return Structure.villaSlot;

		case Structure.parkName : return Structure.parkSlot;

		case Structure.marketName : return Structure.marketSlot;

		case Structure.hotelName : return Structure.hotelSlot;

		case Structure.shopName : return Structure.shopSlot;

		default: System.out.println("Fehler mit dem Namen");

		}
		return 0;
	}

	/** Standartmiete von einem Bauerwerk */
	public int getIncome (){
		return Structure.rentCost;
	}

	/** Abzüge für ein Bauwerk */
	public int getExpenditure(){
		return Structure.dutyCost;
	}

	/** Apartment hat keine Lebensqualität deswegen 0 */
	public int getLifequality(){	
		return 0;
	}

	/** Infrastrukture hat keine Einwohner deswegen 0 */
	public int getPopulation(){
		return 0; 
	}

	/** Zeichnung von den Bauwerken*/
	public String drawing(){
		/** 
		 * Gibt einen String der das Bauwerk repräsentiert.
		 * 	Anzahl der Slots bestimmt die Länge.
		 */
		String s = "";

		switch(buildname){

		case Structure.skycraperName : 
			for (int i = 0; i < Structure.skycraperSlot; i++){
				s += "H";
			} break;
		case Structure.villaName : 
			for (int i = 0; i < Structure.villaSlot; i++){
				s += "V";
			} break;
		case Structure.parkName : 
			for (int i = 0; i < Structure.parkSlot; i++){
				s += "P";
			} break;
		case Structure.marketName : 			
			for (int i = 0; i < Structure.marketSlot; i++){
				s += "S";
			} break;
		case Structure.hotelName : 
			for (int i = 0; i < Structure.hotelSlot; i++){
				s += "O";
			} break;
		case Structure.shopName : 
			for (int i = 0; i < Structure.shopSlot; i++){
				s += "E";
			} break;
		default: System.out.println("Fehler mit Name oder Slots");

		}
		return s;
	}

	/** Führt eine Spielrunde aus.
	 * Erhöht das Alter des Bauwerks.*/
	public void round (int totalquality){
		age++;
	}
	
}