package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.util.Timer;
//import java.util.TimerTask;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import gameUC.City;
import gameUC.Structure;

@SuppressWarnings("serial")
public class JGameFrame extends JFrame {

	protected int xSize;
	protected int ySize;
	protected String titel;
	protected boolean visible;
	private City c;
	JCityPanel gameUCPanel;

	public JGameFrame(String newTitel, int newXSize, int newYSize, boolean newVisiblity, City c){

		super();
		this.c = c;
		setSize(newXSize, newYSize);
		setTitle(newTitel);		
		buildGUI();
		
		setVisible(newVisiblity);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public void buildGUI(){
		
		JPanel gamePanel 	= new JPanel (new FlowLayout());
		JPanel controlPanel = new JPanel (new FlowLayout());
		JPanel conLevPanel	= new JPanel (new FlowLayout());
		JPanel levelPanel   = new JPanel (new FlowLayout());
		JPanel buildPanel   = new JPanel (new FlowLayout());
		JPanel gameUCPanel 	= new JCityPanel(700, 400);
		JPanel roundPanel	= new JPanel (new FlowLayout());
		JFrame roundFrame	= new JFrame ("Rundenanzahl");
			
		JButton btnStart = new JButton("Start");
		JButton sLevel 	 = new JButton("kleine");
		JButton mLevel   = new JButton("mittlere");
		JButton bLevel   = new JButton("große");
		JButton sBuild   = new JButton("Hochhaus");
		JButton vBuild   = new JButton("Villa");
		JButton pBuild   = new JButton("Park");
		JButton mBuild   = new JButton("Supermarkt");
		JButton eBuild	 = new JButton("Einkaufsladen");
		JButton btnExit  = new JButton("Exit");

		JButton lHigh    = new JButton("Ebende runter");
		JButton lLow     = new JButton("Ebende hoch");
		JLabel lbmenue   = new JLabel("Menüsteuerung");
		
		// Runden müssen noch gezählt werden 
		JLabel lbRInfo	 = new JLabel("Du hast .... Runden gespielt");
		JLabel lbInfo    = new JLabel("Guthaben beträgt: $ " + Structure.creditBeginn);
		JLabel lbLevel	 = new JLabel("Was für eine Bauebene willst du bauen?");
		JLabel lbBuild	 = new JLabel("Was für ein Gebäude willst du bauen?");
		
		/** Hierfür müssten noch Kosten anfallen*/
		JButton destry1  = new JButton("Gebäude zerstören");
		JButton destry2  = new JButton("Ebene zerstören");
		
		/** Sollte zu Beginn als extra Frame auf tauchen*/
		JTextArea taexplain = new JTextArea(
				  "-------------------------------------Willkommen in Underground City-------------------------------------\n"
				+ "Zu Beginn gibt es eine kleine Einführung\n"
				+ "Als aller erstes baust du eine Ebene.\n"
				+ "Wenn eine Ebene erstellt wurde kannst du Gebäude bauen.\n"
				+ "Achte auf dein Geld, wenn du Schulden generierst hast du verloren.\n"
				+ "Du benötigst die Lebensqualität von Parks, Supermärkten und Einkaufsläden damit \n"
				+ "dein Hochhaus oder Villa Einwohner generieren kann");
		// Spielverloren wenn Guthaben im Minus
		// Fehlermeldung wenn kein Ebene Vorhaben aber Gebäude gebaut werden soll	
		Font f  = new Font(Font.SANS_SERIF, Font.BOLD, 12);
		Font f1 = new Font(Font.SANS_SERIF, Font.PLAIN, 18);
		Font f2 = new Font(Font.SANS_SERIF, Font.BOLD, 20);

		sLevel.setFont(f);
		mLevel.setFont(f);
		bLevel.setFont(f);
		
		sBuild.setFont(f);
		vBuild.setFont(f);
		pBuild.setFont(f);
		mBuild.setFont(f);
		eBuild.setFont(f);
		
		btnStart.setFont(f);
		btnExit.setFont(f);	
		destry1.setFont(f);
		destry2.setFont(f);
		lHigh.setFont(f);	
		lLow.setFont(f);
		
		
		lbInfo.setFont(f1);
		lbRInfo.setFont(f1);
		lbmenue.setFont(f1);
		lbBuild.setFont(f1);
		lbLevel.setFont(f1);
		taexplain.setFont(f1);

		add(gamePanel);
		gamePanel.add(gameUCPanel);
		gamePanel.add(taexplain);
		gamePanel.add(lbInfo);
		gamePanel.add(lbRInfo);
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
		buildPanel.add(sBuild);
		buildPanel.add(vBuild);
		buildPanel.add(pBuild);
		buildPanel.add(mBuild);
		buildPanel.add(eBuild);
		
	

		btnStart.addActionListener( new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				roundFrame.setSize(400, 200);
				roundFrame.setVisible(true);
				roundFrame.setTitle("Start");
				JPanel info  = new JPanel();
				JLabel round = new JLabel("Wie viele Runden willst du spielen?");
				round.setFont(f2);
				roundFrame.add(info.add(round));
				
				
//				c.round(1);
//				lbInfo.setText("Guthabenbeträgt: $ " + c.getCredit());
//				c.output();
				
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
				c.output();
			}
		});

		lLow.addActionListener( new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				c.lower();
				c.output();

			}
		});

		destry1.addActionListener( new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				c.destroyer();
				c.output();

			}
		});

		destry2.addActionListener( new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				c.bigDestroyer();
				c.output();

			}
		});
		
		sLevel.addActionListener( new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				c.buildLevel(Structure.smallLevelSlot);
				c.output();
			}
		});

		mLevel.addActionListener( new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				c.buildLevel(Structure.mediumLevelSlot);
				c.output();

			}
		});

		bLevel.addActionListener( new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				c.buildLevel(Structure.bigLevelSlot);
				c.output();

			}
		});

		sBuild.addActionListener( new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				c.buildSkycraper();
				c.output();

			}
		});

		vBuild.addActionListener( new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				c.buildVilla();
				c.output();

			}
		});

		pBuild.addActionListener( new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				c.buildPark();
				c.output();
			}
		});

		mBuild.addActionListener( new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				c.buildMarket();
				c.output();
			}
		});
		
		eBuild.addActionListener( new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				c.buildShop();
				c.output();
			}
		});

	}
}
