package gameUC;

import java.util.Scanner;


import GUI.JGameFrame;

/** 
 * <H1> Underground City </H1>
 * @author Kay Nicole Ruck
 * Matrikelnummer: 11118703
 * Student der Technischen Hochschule K�ln (Campus Gummersbach)
 * <p>
 * Algorithmen und Programmierung 2 - Praktikum Teil 1 + 2
 * <p>
 * @version 1.5
 * @since 2017-05-20
 */

/** 
 * Wir f�gen noch folgende Klassen hinzu
 * Industrie mit Fabriken, Firmen
 * Handwerk mit kleinen Betrieben die die L�den beliefern
 * Freizeit mit Freizeitparks, Schwimmb�der, Kino 
 * �ffentliche Geb�ude mit Rathhaus, Bibliothek etc
 * Versorgungsgeb�ude Elektrizit�t und Wasser
 * Erzeugergeb�ude wie Wind-, Wasseranlagen
 * 
 * Slotssystem muss umgebaut werden
 * 
 */
public class App {

	static int f = 0;
	static City st = new City();
	static JGameFrame gameUC = new JGameFrame("Underground City", 800, 1000, true, st);	
	static Scanner scanner = new Scanner(System.in);
	static int v = 0;
		
	
	public static void main(String[] args) {
		
		String s;
	
		
		do{
			System.out.println("\n--------------------------------Men�steuerung---------------------------------\n"
					+ "		 -: Ebene Runter   +: Ebene Hoch     c: Exit		\n"
					+ "		 a: Geb�ude zerst�ren 	             o: Ebene zerst�ren\n"
					+ "Spiell�nge:	 n: f�r n Runde    3: f�r 3 Runden   5: f�r 5 Runden    7: f�r Runden \n" 
					+ "Ebene bauen:	 k: kleine	   m: mittlere       g: gro�e\n"
					+ "Bauwerk bauen:	 h: Hochhaus	   v: Villa	     s: Supermarkt	p: Park "
					+ "\n		 e: Einkaufsladen  f: Hotel");
			 

			System.out.println("\nGeben Sie einen Befehl ein:"); 

			s = scanner.nextLine();
			menue(s);
			st.output();

		} while (f == 0);
		
		

	}

	public static String menue(String s){
		
		switch(s){

		case "c" : 
			System.out.println("Spiel wird verlassen");
			System.exit(0); /** Wenn hier f = 1 gesetz w�re w�rde noch Info ausgegeben werden*/

		case "+": st.lower();/** Ebene Hoch (im Array eine Stelle zur�ck)*/
			break;

		case "-": st.higher(); /** EbendeRunter (im Array eine Stelle vor) */
			break;

		case "n": 
			System.out.println("Geben Sie an wie viele Runden sie spielen wollen:");
			v = scanner.nextInt();
			st.round(v);
			break;
			
		case "1": st.round(1); /** round() in City bekommt den Parameter n = 1 */
			break;
			
		case "3": st.round(3); /** round() in City bekommt den Parameter n = 3 */
			break;

		case "5": st.round(5); /** round() in City bekommt den Parameter n = 5 */
			break;
			
		case "7": st.round(7); /** round() in City bekommt den Parameter n = 7 */
			break;
			
		case "k": st.buildLevel(Structure.smallLevelSlot); /** kleine Ebene bauen */
			break;

		case "m": st.buildLevel(Structure.mediumLevelSlot); /** mittlere Ebene bauen */
			break;

		case "g": st.buildLevel(Structure.bigLevelSlot); /** grosse Ebene bauen */
			break;

		case "h": st.buildSkycraper(); /** Hochhaus bauen */
			break;

		case "v": st.buildVilla(); /** Villa bauen */
			break;

		case "s": st.buildMarket(); /** Supermarkt bauen */
			break;

		case "p": st.buildPark(); /** Park bauen */
			break;
		
		case "e": st.buildShop(); /** Einkaufsladen bauen */
			break;
			
		case "a": st.destroyer(); //st.secret();
			break;

		case "o": st.bigDestroyer(); //st.secret();
			break;
		
		case "f": st.buildHotel(); /** Hotel bauen */
			break;

			
		default: System.out.println("Ungl�tige Eingabe");
		
		}
		return null;
	}
}
