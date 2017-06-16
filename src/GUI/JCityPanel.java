package GUI;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import gameUC.City;

@SuppressWarnings("serial")
public class JCityPanel extends JPanel {
	private City z;

	public JCityPanel(int newXSize, int newYSize){
		setPreferredSize(new Dimension(newXSize, newYSize));
	}

	public void paintComponent (Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		Graphics2D g2 = (Graphics2D) g;
		super.paintComponent(g);

		g2d.setColor(Color.WHITE);
		g2d.fillRect(5, 5, getWidth()-10, getHeight()-10 );
		g2d.setColor(Color.BLACK);
		g2d.drawRect(5, 5, getWidth()-10, getHeight()-10 );

			g2.setColor(Color.LIGHT_GRAY);
			g2.fillRect(20, 20, 50, 50);
			
	}

	public void drawSlotsGraphic(){


	}

	// Pro Slots ein fillRect(50, 200)

	public void drawString(){
		z.output();
	}

}
