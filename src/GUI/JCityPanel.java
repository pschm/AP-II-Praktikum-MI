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
		Graphics2D g3 = (Graphics2D) g;
		super.paintComponent(g);

		g2d.setColor(Color.WHITE);
		g2d.fillRect(5, 5, getWidth()-10, getHeight()-10 );
		g2d.setColor(Color.BLACK);
		g2d.drawRect(5, 5, getWidth()-10, getHeight()-10 );

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


			String occu = l.drawSlots();

			int q = 0;
			int yLevel = 20;
			int freeSlots = l.getNumbSlots();


			if (freeSlots == Structure.smallLevelSlot)
			{
				g3.setColor(Color.LIGHT_GRAY);
				g3.fillRect(20 , yLevel, 50*Structure.smallLevelSlot, 50);
			}

			if (freeSlots == Structure.mediumLevelSlot)
			{
				g3.setColor(Color.LIGHT_GRAY);
				g3.fillRect(20 , yLevel, 50*Structure.mediumLevelSlot, 50);
			}

			if (freeSlots == Structure.bigLevelSlot)
			{
				g3.setColor(Color.LIGHT_GRAY);
				g3.fillRect(20 , yLevel, 50*Structure.bigLevelSlot, 50);
			}



			for(int i = 0; i < occu.length(); i++){
				String sign = "" + occu.charAt(i);

				switch(sign){

				case "H": 
					//					for (int f = 0; f < Structure.skycraperSlot; f++){

					g2.setColor(Color.BLACK);
					g2.fillRect(20 + q, yLevel, 50, 50);
					g2.setColor(Color.WHITE);
					g2.drawRect(20 + q, yLevel, 50, 50);
					datenPanel.setLocation(250, 50);
					q += 50;
					//					}	

					break;

				case "S": 
					g2.setColor(Color.BLACK);
					g2.fillRect(20 + q, yLevel, 50, 50);
					g2.setColor(Color.WHITE);
					g2.drawRect(20 + q, yLevel, 50, 50);
					datenPanel.setLocation(250, 50);
					q += 50;

					break;

				case "E": 
					g2.setColor(Color.BLACK);
					g2.fillRect(20 + q, yLevel, 50, 50);
					g2.setColor(Color.WHITE);
					g2.drawRect(20 + q, yLevel, 50, 50);
					datenPanel.setLocation(250, 50);
					q += 50;

					break;

				case "V": 
					g2.setColor(Color.BLACK);
					g2.fillRect(20 + q, yLevel, 50, 50);
					g2.setColor(Color.WHITE);
					g2.drawRect(20 + q, yLevel, 50, 50);
					datenPanel.setLocation(250, 50);
					q += 50;

					break;

				case "O": 

					g2.setColor(Color.BLACK);
					g2.fillRect(20 + q, yLevel, 50, 50);
					g2.setColor(Color.WHITE);
					g2.drawRect(20 + q, yLevel, 50, 50);
					datenPanel.setLocation(250, 50);
					q += 50;


					break;

				case "P": 

					g2.setColor(Color.BLACK);
					g2.fillRect(20 + q, yLevel, 50, 50);
					g2.setColor(Color.WHITE);
					g2.drawRect(20 + q, yLevel, 50, 50);
					datenPanel.setLocation(250, 50);
					q += 50;

					break;
					//
					//				default:
					//					for (int f = 0; f < l.getFreeSlots() ; f++){
					//
					//						g2.setColor(Color.GRAY);
					//						g2.fillRect(20 + q, 20, 50, 50);
					//						datenPanel.setLocation(250, 50);
					//						q += 50;
					//					}	

				}

			}



			this.add(drawingPanel);
			this.add(datenPanel);
		}

		/**
		 * Pro Ebene: Was bin ich?
		 * Zum Testen: String kette aus der Console übernehmen 
		 * Informationen jeder Ebene
		 */
	}

	// Pro Slots ein fillRect(50, 200)



	public void buildGui(){


		repaint();
	}

	public void updateDrawing(){
		removeAll();
		buildGui();

	}


}
