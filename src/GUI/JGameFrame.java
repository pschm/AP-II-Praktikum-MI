package GUI;


import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;

import gameUC.City;
import gameUC.Structure;

@SuppressWarnings("serial")
public class JGameFrame extends JFrame {

	/** Meldung das man Game Over ist wenn man einen Gewissen betrag unterschreitet
	 * 
	 * optional Bank Credit mit (Zins)Kosten pro Runden 
	 * */


	protected int xSize;
	protected int ySize;
	protected String titel;
	protected boolean visible;
	private City c;
	JCityPanel gameUCPanel;
	private int playround = 0;

	public JGameFrame(String newTitel, int newXSize, int newYSize, boolean newVisiblity, City c){

		super();
		this.c = c;
		setSize(newXSize, newYSize);
		setTitle(newTitel);		
		buildGUI();

		setVisible(newVisiblity);
		//gameUCPanel = new JCityPanel(700, 400, c);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public void buildGUI(){

		JPanel gamePanel 	= new JPanel (new FlowLayout());
		JPanel controlPanel = new JPanel (new FlowLayout());
		JPanel conLevPanel	= new JPanel (new FlowLayout());
		JPanel levelPanel   = new JPanel (new FlowLayout());
		JPanel buildPanel   = new JPanel (new FlowLayout());
		gameUCPanel 	    = new JCityPanel(1200, 600, c);
		JPanel roundPanel	= new JPanel (new FlowLayout());
		JPanel wohnPanel    = new JPanel (new FlowLayout());
		JPanel infraPanel   = new JPanel (new FlowLayout());


		JButton btnStart = new JButton("Start");
		JButton sLevel 	 = new JButton("kleine");
		JButton mLevel   = new JButton("mittlere");
		JButton bLevel   = new JButton("große");
		JButton sBuild   = new JButton("Hochhaus");
		JButton vBuild   = new JButton("Villa");
		JButton pBuild   = new JButton("Park");
		JButton mBuild   = new JButton("Supermarkt");
		JButton eBuild	 = new JButton("Einkaufsladen");
		JButton hBuild	 = new JButton("Hotel");
		JButton btnExit  = new JButton("Exit");
		JButton lHigh    = new JButton("Ebende runter");
		JButton lLow     = new JButton("Ebende hoch");
		JLabel lbmenue   = new JLabel("Menüsteuerung");
		JLabel lbInfo    = new JLabel("Du hast "+playround+" Runden gespielt \n" + "Guthaben beträgt: $ " + Structure.creditBeginn);
		JLabel lbLevel	 = new JLabel("Was für eine Bauebene willst du bauen?");
		JLabel lbBuild	 = new JLabel("Was für ein Gebäude willst du bauen?");
		JLabel lbWohn	 = new JLabel("Wohneinheit");
		JLabel lbInfra	 = new JLabel("Infratruktur");

		JButton destry1  = new JButton("Gebäude zerstören");
		JButton destry2  = new JButton("Ebene zerstören");

		/** Sollte zu Beginn als extra Frame auf tauchen*/
//		JTextArea taexplain = new JTextArea(
//				"-------------------------------------Willkommen in Underground City-------------------------------------\n"
//						+ "Zu Beginn gibt es eine kleine Einführung\n"
//						+ "Als aller erstes baust du eine Ebene.\n"
//						+ "Wenn eine Ebene erstellt wurde kannst du Gebäude bauen.\n"
//						+ "Achte auf dein Geld, wenn du Schulden generierst hast du verloren.\n"
//						+ "Du benötigst die Lebensqualität von Parks, Supermärkten und Einkaufsläden damit \n"
//						+ "dein Hochhaus, deine Villa oder dein Hotel Einwohner generieren kann");
		Font f  = new Font(Font.SANS_SERIF, Font.BOLD, 12);
		Font f1 = new Font(Font.SANS_SERIF, Font.PLAIN, 18);
		//		Font f2 = new Font(Font.SANS_SERIF, Font.BOLD, 20);

		sLevel.setFont(f);
		mLevel.setFont(f);
		bLevel.setFont(f);
		sBuild.setFont(f);
		vBuild.setFont(f);
		pBuild.setFont(f);
		mBuild.setFont(f);
		eBuild.setFont(f);
		hBuild.setFont(f);
		btnStart.setFont(f);
		btnExit.setFont(f);	
		destry1.setFont(f);
		destry2.setFont(f);
		lHigh.setFont(f);	
		lLow.setFont(f);
		lbInfo.setFont(f1);
		lbmenue.setFont(f1);
		lbBuild.setFont(f1);
		lbLevel.setFont(f1);
		lbInfra.setFont(f1);
		lbWohn.setFont(f1);
//		taexplain.setFont(f1);

		add(gamePanel);
		gamePanel.add(gameUCPanel);
//		gamePanel.add(taexplain);
		gamePanel.add(lbInfo);
		gamePanel.add(controlPanel);
		gamePanel.add(conLevPanel);
		gamePanel.add(levelPanel);
		gamePanel.add(buildPanel);
		gamePanel.add(roundPanel);

		controlPanel.add(btnStart);
		controlPanel.add(btnExit);
		conLevPanel.add(lbmenue);
		conLevPanel.add(lHigh);
		conLevPanel.add(lLow);
		conLevPanel.add(destry1);
		conLevPanel.add(destry2);

		levelPanel.add(lbLevel);
		levelPanel.add(sLevel);
		levelPanel.add(mLevel);
		levelPanel.add(bLevel);

		buildPanel.add(lbBuild);
		wohnPanel.add(lbWohn);
		wohnPanel.add(sBuild);
		wohnPanel.add(vBuild);
		wohnPanel.add(hBuild);
		infraPanel.add(lbInfra);
		infraPanel.add(pBuild);
		infraPanel.add(mBuild);
		infraPanel.add(eBuild);
		gamePanel.add(wohnPanel);
		gamePanel.add(infraPanel);

		ActionListener alRoundStart = new ActionListener() {
 			
 			@Override
 			public void actionPerformed(ActionEvent e) {
 				c.round(1);
				lbInfo.setText("Guthaben: $ " +c.getCredit());
				
				playround += 1;
				lbInfo.setText("Du hast "+playround+" Runden gespielt \n"
							+ "Guthaben beträgt: $ " +c.getCredit());
 				c.output();
				gameUCPanel.updateDrawing();
 				repaint();
 			}
 		};
 		
		Timer timer = new Timer(1500, alRoundStart);
		
		btnStart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(timer.isRunning()) {
					btnStart.setText("Spiel Starten");
					timer.stop();
				} else {
					btnStart.setText("Spiel Beenden");
					timer.start();
					
				}
			}
		});
		

		btnExit.addActionListener( new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				c.output();
				System.out.println("Spiel wird verlassen");

				System.exit(0);
				/** Hier könnte sich noch ein Frame öffnen welches eine Bestätigung will
				 * 
				 * boolean?
				 * Cancel = Back to Game
				 * Ok = Exit
				 * 
				 *  Bsp: Wollen sie sicher das Spiel beenden?
				 *  			[OK]	[Cancel]
				 */

			}
		});


		lHigh.addActionListener( new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				c.higher();
				lbInfo.setText("Du hast "+playround+" Runden gespielt \n"
						+ "Guthaben beträgt: $ " +c.getCredit());
				c.output();

			}
		});

		lLow.addActionListener( new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				c.lower();
				lbInfo.setText("Du hast "+playround+" Runden gespielt \n"
							+ "Guthaben beträgt: $ " +c.getCredit());
				c.output();


			}
		});

		destry1.addActionListener( new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				c.destroyer();
				lbInfo.setText("Du hast "+playround+" Runden gespielt \n"
						+ "Guthaben beträgt: $ " +c.getCredit());
				c.output();
				gameUCPanel.updateDrawing();
				repaint();

			}
		});

		destry2.addActionListener( new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				c.bigDestroyer();
				lbInfo.setText("Du hast "+playround+" Runden gespielt \n"
						+ "Guthaben beträgt: $ " +c.getCredit());
				c.output();
				gameUCPanel.updateDrawing();
				repaint();

			}
		});

		sLevel.addActionListener( new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				c.buildLevel(Structure.smallLevelSlot);
				lbInfo.setText("Du hast "+playround+" Runden gespielt \n"
						+ "Guthaben beträgt: $ " +c.getCredit());
				c.output();
				gameUCPanel.updateDrawing();
				repaint();
			}
		});

		mLevel.addActionListener( new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				c.buildLevel(Structure.mediumLevelSlot);
				lbInfo.setText("Du hast "+playround+" Runden gespielt \n"
						+ "Guthaben beträgt: $ " +c.getCredit());
				c.output();
				gameUCPanel.updateDrawing();
				repaint();

			}
		});

		bLevel.addActionListener( new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				c.buildLevel(Structure.bigLevelSlot);
				lbInfo.setText("Du hast "+playround+" Runden gespielt \n"
						+ "Guthaben beträgt: $ " +c.getCredit());
				c.output();
				gameUCPanel.updateDrawing();
				repaint();

			}
		});

		sBuild.addActionListener( new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				c.buildSkycraper();
				lbInfo.setText("Du hast "+playround+" Runden gespielt \n"
						+ "Guthaben beträgt: $ " +c.getCredit());
				c.output();
				gameUCPanel.updateDrawing();
				repaint();


			}
		});

		vBuild.addActionListener( new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				c.buildVilla();
				lbInfo.setText("Du hast "+playround+" Runden gespielt \n"
						+ "Guthaben beträgt: $ " +c.getCredit());
				c.output();
				gameUCPanel.updateDrawing();
				repaint();


			}
		});

		pBuild.addActionListener( new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				c.buildPark();
				lbInfo.setText("Du hast "+playround+" Runden gespielt \n"
						+ "Guthaben beträgt: $ " +c.getCredit());
				c.output();
				gameUCPanel.updateDrawing();
				repaint();

			}
		});

		mBuild.addActionListener( new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				c.buildMarket();
				lbInfo.setText("Du hast "+playround+" Runden gespielt \n"
						+ "Guthaben beträgt: $ " +c.getCredit());
				c.output();
				gameUCPanel.updateDrawing();
				repaint();

			}
		});

		eBuild.addActionListener( new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				c.buildShop();
				lbInfo.setText("Du hast "+playround+" Runden gespielt \n"
						+ "Guthaben beträgt: $ " +c.getCredit());
				c.output();
				gameUCPanel.updateDrawing();
				repaint();

			}
		});

		hBuild.addActionListener( new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				c.buildHotel();
				lbInfo.setText("Du hast "+playround+" Runden gespielt \n"
						+ "Guthaben beträgt: $ " +c.getCredit());
				c.output();
				gameUCPanel.updateDrawing();
				repaint();

			}
		});


	}
}