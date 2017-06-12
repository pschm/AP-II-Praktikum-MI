package GUI;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class JCityPanel extends JPanel {
	
	public JCityPanel(int newXSize, int newYSize){
		setPreferredSize(new Dimension(700, 400));
	}
	
	
	public void paintComponent (Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		super.paintComponent(g);

		g2d.setColor(Color.WHITE);
		g2d.fillRect(5, 5, getWidth()-10, getHeight()-10 );
		g2d.setColor(Color.BLACK);
		g2d.drawRect(5, 5, getWidth()-10, getHeight()-10 );

		}
}
