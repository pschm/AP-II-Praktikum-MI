package gameUC;

import java.util.Scanner;


import GUI.JGameFrame;

/** 
 * <H1> Underground City </H1>
 * @author Kay Nicole Ruck
 * Matrikelnummer: 11118703
 * Student der Technischen Hochschule K�ln (Campus Gummersbach)
 * <p>
 * Algorithmen und Programmierung 2 - Praktikum Teil 1
 * <p>
 * @version 1.0
 * @since 2017-05-20
 */

public class App {

	static int f = 0;
	static City st = new City();
	static JGameFrame gameUC = new JGameFrame("Underground City", 800, 600, true);	
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s;
		
	
		
		do{
			System.out.println("\n--------------------------------Men�steuerung---------------------------------\n"
					+ "		 -: Ebene Runter   +: Ebene Hoch     e: Exit		a: Secret\n"
					+ "Spiell�nge:	 1: f�r 1 Runde    3: f�r 3 Runden   5: f�r 5 Runden    7: f�r Runden \n" 
					+ "Ebene bauen:	 k: kleine	   m: mittlere       g: gro�e\n"
					+ "Bauwerk bauen:	 h: Hochhaus	   v: Villa	     s: Supermarkt	p: Park");

			System.out.println("\nGeben Sie einen Befehl ein:"); 

			s = scanner.nextLine();
			menue(s);
			st.output();

		} while (f == 0);
		scanner.close();
		

	}

	public static String menue(String s){
		
		switch(s){

		case "e" : 
			System.out.println("Spiel wird verlassen");
			System.exit(0); /** Wenn hier f = 1 gesetz w�re w�rde noch Info ausgegeben werden*/

		case "+": st.lower();/** Ebene Hoch (im Array eine Stelle zur�ck)*/
			break;

		case "-": st.higher(); /** EbendeRunter (im Array eine Stelle vor) */
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
			
		case "a": st.secret();
			break;

		default: System.out.println("Ungl�tige Eingabe");
		
		}
		return null;
	}
}
