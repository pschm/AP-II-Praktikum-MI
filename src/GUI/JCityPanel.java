package GUI;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import gameUC.City;
import gameUC.Level;
import gameUC.Structure;

@SuppressWarnings("serial")
public class JCityPanel extends JPanel {
	private City z;
	Font labelFont  = new Font(Font.SANS_SERIF, Font.PLAIN, 18);

	public JCityPanel(int newXSize, int newYSize, City z){
		this.z = z;
		setPreferredSize(new Dimension(newXSize, newYSize));
		buildGui();
	}
	
	public void drawString(){
		z.output();
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

	// Pro Slots ein fillRect(50, 200)

	
	
	public void buildGui(){
		
		ArrayList<Level> nl = z.getLevel();
		
		/**
		 * Schleife über alle Ebenen
		 * 
		 * benötigtes rechtes Panel: datenPanel für die Informationen
		 * benötigtes linkes Pnael: drawingPanel für die Zeichnungen
		 * 
		 */
		for( Level l : nl){
			JPanel datenPanel = new JPanel(new GridLayout());
			JPanel drawingPanel = new JPanel(new GridLayout());
			JLabel infoLabel = new JLabel(l.drawInfo());
			infoLabel.setFont(labelFont);
			datenPanel.add(infoLabel);
			
//			int size = nl.size();
//			if ( size  == Structure.bigLevelSlot)
			
			
				
				
				
			this.add(drawingPanel);
			this.add(datenPanel);
		}
		
		/**
		 * Pro Ebene: Was bin ich?
		 * Zum Testen: String kette aus der Console übernehmen 
		 * Informationen jeder Ebene
		 */
		repaint();
	}
	
	public void updateDrawing(){
		removeAll();
		buildGui();
		
	}
	
	
}
