package GUI;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gameUC.City;

@SuppressWarnings("serial")
public class JGameFrame extends JFrame {

	protected int xSize;
	protected int ySize;
	protected String titel;
	protected boolean visible;
	private City c;

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

		JButton btnStart = new JButton("Start");
		JButton sLevel 	 = new JButton("kleine Ebene bauen");
		JButton mLevel   = new JButton("mittlere Ebene bauen");
		JButton bLevel   = new JButton("große Ebene bauen");
		JButton sBuild   = new JButton("Hochhaus bauen");
		JButton vBuild   = new JButton("Villa bauen");
		JButton pBuild   = new JButton("Park bauen");
		JButton mBuild   = new JButton("Supermarkt bauen");
		JButton btnExit  = new JButton("Exit");

		JButton lHigh    = new JButton("Ebende runter");
		JButton lLow     = new JButton("Ebende hoch");
		JLabel lbmenue   = new JLabel("Menüsteuerung");
		JLabel lbInfo    = new JLabel("Guthaben beträgt: ....");
		JButton destry   = new JButton("Letzes Gebäude zerstören");

		Font f  = new Font(Font.SANS_SERIF, Font.BOLD, 12);
		Font f1 = new Font(Font.MONOSPACED, Font.BOLD, 20); 

		btnStart.setFont(f);
		sLevel.setFont(f);
		mLevel.setFont(f);
		bLevel.setFont(f);
		sBuild.setFont(f);
		vBuild.setFont(f);
		pBuild.setFont(f);
		mBuild.setFont(f);
		lbInfo.setFont(f);
		lbmenue.setFont(f1);
		btnExit.setFont(f);	
		destry.setFont(f);
		lHigh.setFont(f);	
		lLow.setFont(f);

		add(gamePanel);
		gamePanel.add(lbmenue);
		gamePanel.add(controlPanel);
		gamePanel.add(conLevPanel);
		gamePanel.add(levelPanel);
		gamePanel.add(buildPanel);

		controlPanel.add(btnStart);
		controlPanel.add(lbInfo);
		controlPanel.add(btnExit);
		conLevPanel.add(lHigh);
		conLevPanel.add(lLow);
		conLevPanel.add(destry);

		levelPanel.add(sLevel);
		levelPanel.add(mLevel);
		levelPanel.add(bLevel);

		buildPanel.add(sBuild);
		buildPanel.add(vBuild);
		buildPanel.add(pBuild);
		buildPanel.add(mBuild);

		btnStart.addActionListener( new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Test1");
				c.round(1);
				lbInfo.setText("Guthabenbeträgt: $" + c.getCredit());
				c.output();
			}
		});

		btnExit.addActionListener( new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});

		lHigh.addActionListener( new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});

		lLow.addActionListener( new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});

		destry.addActionListener( new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});

		sLevel.addActionListener( new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});

		mLevel.addActionListener( new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});

		bLevel.addActionListener( new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});

		sBuild.addActionListener( new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});

		vBuild.addActionListener( new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});

		pBuild.addActionListener( new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});

		mBuild.addActionListener( new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});

		btnStart.addMouseListener(new MouseAdapter () {

			@Override
			public void mouseClicked(MouseEvent e) {

				c.round(1);

			}

		});

	}
}
