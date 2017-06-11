package GUI;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

// import gameUC.City;

@SuppressWarnings("serial")
public class JGameFrame extends JFrame {

	protected int xSize;
	protected int ySize;
	protected String titel;
	protected boolean visible;
	//private City c;

	public JGameFrame(String newTitel, int newXSize, int newYSize, boolean newVisiblity){

		super();
		setSize(newXSize, newYSize);
		setTitle(newTitel);
		buildGUI();
		setVisible(newVisiblity);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public void buildGUI(){
		
		System.out.println("Hallo");

		JPanel controlPanel = new JPanel (new FlowLayout());
		add(controlPanel);
		JButton btnStart = new JButton("Start");
		JButton sLevel 	 = new JButton("kleine Ebene bauen");
		JButton mLevel   = new JButton("mittlere Ebene bauen");
		JButton bLevel   = new JButton("groﬂe Ebene bauen");
		JButton sBuild   = new JButton("Hochhaus bauen");
		JButton vBuild   = new JButton("Villa bauen");
		JButton pBuild   = new JButton("Park bauen");
		JButton mBuild   = new JButton("Supermarkt bauen");
		JButton btnExit  = new JButton("Exit");
		JLabel lbInfo    = new JLabel("Guthabenbetr‰gt: ....");

		Font f = new Font("Serif" , Font.BOLD, 18);
		
		btnStart.setFont(f);
		sLevel.setFont(f);
		mLevel.setFont(f);
		bLevel.setFont(f);
		sBuild.setFont(f);
		vBuild.setFont(f);
		pBuild.setFont(f);
		mBuild.setFont(f);
		lbInfo.setFont(f);
		btnExit.setFont(f);	

		controlPanel.add(btnStart);
		controlPanel.add(lbInfo);
		controlPanel.add(sLevel);
		controlPanel.add(mLevel);
		controlPanel.add(bLevel);
		controlPanel.add(sBuild);
		controlPanel.add(vBuild);
		controlPanel.add(pBuild);
		controlPanel.add(mBuild);
		controlPanel.add(btnExit);
	}
}
