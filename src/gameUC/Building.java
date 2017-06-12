package gameUC;

public class Building {

	
	/**  protected anstatt private damit sie in den Unterklassen benutzt werden kann */
	protected int slot;
	protected int cost;
	protected int age;
	protected String buildname;


	/** Sinnvoll: Weg lassen? Kein Objekt der Klasse Building erstellen sondern nur Apartment und Infrastructure
	*Damit es keine Bauwerke an sich gibt sondern nur noch Wohneinheiten und Infra. (au�er Standart Konstruktor) */
	public Building(int slot, int cost, String name ) {
		age = 0;
		this.slot = slot;
		this.cost = cost;
		this.buildname = name;
	}

	/** Die ben�tigten Slots f�r ein Bauwerk */
	int needSlots(){
		
		if (buildname  == Structure.skycraperName){
			return Structure.skycraperSlot;
		}

		if (buildname  == Structure.villaName){
			return Structure.villaSlot;
		}
		if (buildname  == Structure.marketName){
			return Structure.marketSlot;
		}

		if (buildname  == Structure.parkName){
			return Structure.parkSlot;
		}
		if (buildname  == Structure.shopName){
			return Structure.shopSlot;
		}
		return 0;
	}

	/** Standartmiete von dem Bauerwerk */
	public int getIncome (){
		return Structure.rentCost;
	}

	/** Abz�ge f�r das Bauwerk */
	public int getExpenditure(){
		return Structure.dutyCost /** mal die Anzahl an actuelle Einwohner*/;
		

	}

	/** Apartment hat keine Lebensqualit�t deswegen 0 */
	public int getLifequality(){	
		return 0;
	}

	/** Leute wohnen nicht in Infra deswegen 0 */
	public int getPopulation(){
		return 0; 
	}

	/** Zeichnung von den Bauwerken*/
	public String drawing(){
		/** Gibt  SSSSVVVV oder MMMMMMPP aus 
		 * switch-case m�glich
		 */

		String s = "";
		if (buildname == Structure.skycraperName){
			for (int i = 0; i < Structure.skycraperSlot; i++){
				s += "H";
			}
		}

		if (buildname == Structure.villaName){
			for (int i = 0; i < Structure.villaSlot; i++){
				s += "V";
			}
		}

		if (buildname == Structure.marketName){
			for (int i = 0; i < Structure.marketSlot; i++){
				s += "S";
			}
		}

		if (buildname == Structure.parkName){
			for (int i = 0; i < Structure.parkSlot; i++){
				s += "P";
			}
		}
		
		if (buildname == Structure.shopName){
			for (int i = 0; i < Structure.shopSlot; i++){
				s += "E";
			}
		}

		/** liefert einen String, der das Bauwerk repr�sentiert. Die L�nge der
		Zeichenkette soll dabei der Anzahl der ben�tigten Slots verwenden. 
		Eine Villa �ber 4 Slots k�nnte z.B. durch �VVVV� repr�sentiert werden*/

		return s;
	}


	public void round (int totalquality){

		age++;
		
		/** f�hrt eine Spielrunde f�r das Bauwerk aus. 
		* Dabei wird die aktuelle Lebensqualit�t der Ebene �bergeben,
		* da hiervon die Einnahmen oder die Einwohnerentwicklung abh�ngen k�nnen. 
		* Das Alter des Bauwerks wird erh�ht
		* */

	}

}