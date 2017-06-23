package GUI;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
//import java.awt.GridLayout;
import java.util.ArrayList;

//import javax.swing.JLabel;
import javax.swing.JPanel;

import gameUC.City;
import gameUC.Level;
import gameUC.Structure;

@SuppressWarnings("serial")
public class JCityPanel extends JPanel {
	private City z;
	Font labelFont  = new Font(Font.SANS_SERIF, Font.BOLD, 14);

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
//		int xLevel = 20;
		int yLevel = 20;

		/**
		 * Schleife über alle Ebenen 
		 */
				for(int i = 0; i < nl.size(); i++) {
//		for(Level l : nl) {
						Level l = nl.get(i);
			String occu = l.drawSlots();

			int q = 20;


			int freeSlots = l.getNumbSlots();
			g2.setFont(labelFont);

			if (freeSlots == Structure.smallLevelSlot){


				JPanel smallPanel = new JPanel();
				smallPanel.setSize(50*Structure.smallLevelSlot, 50);
				smallPanel.setOpaque(false);
				smallPanel.setLocation(20, yLevel);
				add(smallPanel);

				g3.setColor(Color.LIGHT_GRAY);
				g3.fillRect(20 , yLevel, 50*Structure.smallLevelSlot, 50);
				
				

				final int index = i;
				smallPanel.addMouseListener( new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						z.setActualLevel(index);
						smallPanel.setBackground(Color.CYAN);
						smallPanel.setOpaque(true);
						
						/** Wenn die Maus clicket wird die Ebene cyan 
						 * 
						 * Fehler 1:
						 * 
						 * Allerdings wenn ich dann eine andere Ebene auswähle sind 
						 * zwei Ebenen cyan (Die alte und die neue (akuelle) Ebene)
						 * 
						 * Es sollte aber eigentlich so sein, dass wenn ich eine Ebene auswähle
						 * diese cyan wird und wenn ich eine zweite Ebene auswähle die erste hell 
						 * grau und die zweite cyan wird.
						 * 
						 * Fehler 2:
						 * 
						 * Wenn ich eine Ebene ausgewählt habe wird diese cyan, wenn ich dann 
						 * allerdings noch eine Ebene hinzufüge oder etwas auf der Ebene baue 
						 * verschwindet das cyan wieder.
						 * 
						 * Es sollte so sein, dass sie dauerhaft (bis eine neue Ebene ausgewählt wird)
						 * cyan bleibt.
						 * 
						 */
					}
				});

			}

			if (freeSlots == Structure.mediumLevelSlot)
			{
				JPanel mediumPanel = new JPanel();
				mediumPanel.setSize(50*Structure.mediumLevelSlot, 50);
				mediumPanel.setOpaque(false);
				mediumPanel.setLocation(20, yLevel);
				add(mediumPanel);

				g3.setColor(Color.LIGHT_GRAY);
				g3.fillRect(20 , yLevel, 50*Structure.mediumLevelSlot, 50);

				final int index = i;
				mediumPanel.addMouseListener( new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						z.setActualLevel(index);
					}
				});
			}

			if (freeSlots == Structure.bigLevelSlot)
			{
				JPanel bigPanel = new JPanel();
				bigPanel.setSize(50*Structure.bigLevelSlot, 50);
				bigPanel.setOpaque(false);
				bigPanel.setLocation(20, yLevel);
				add(bigPanel);

				g3.setColor(Color.LIGHT_GRAY);
				g3.fillRect(20 , yLevel, 50*Structure.bigLevelSlot, 50);

				final int index = i;
				bigPanel.addMouseListener( new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						z.setActualLevel(index);
						
					}
				});
			}

			int hCounter = 0;
			int mCounter = 0;
			int vCounter = 0;
			int pCounter = 0;
			int eCounter = 0;
			int oCounter = 0;


			for(int j = 0; j < occu.length(); j++){
				String sign = "" + occu.charAt(j);

				switch(sign){

				case "H": 
					g2.setColor(Color.BLACK);
					g2.fillRect(q, yLevel, 50, 50);
					hCounter++;
					if(hCounter % Structure.skycraperSlot == 0) {
						g2.setColor(Color.WHITE);
						g2.drawRect(q - (50 * (Structure.skycraperSlot-1)), yLevel, 50 * Structure.skycraperSlot, 50);
						g2.drawString(Structure.skycraperName, q - (50 * (Structure.skycraperSlot -1))/2, yLevel + 30);
					}
					q += 50;
					break;

				case "S": 
					g2.setColor(Color.BLACK);
					g2.fillRect(q, yLevel, 50, 50);
					mCounter++;
					if(mCounter % Structure.marketSlot == 0) {
						g2.setColor(Color.WHITE);
						g2.drawRect(q - (50 * (Structure.marketSlot-1)), yLevel, 50 * Structure.marketSlot, 50);
						g2.drawString(Structure.marketName, q - (50 * (Structure.marketSlot -1))/2, yLevel + 30);
					}
					q += 50;

					break;

				case "E": 
					g2.setColor(Color.BLACK);
					g2.fillRect(q, yLevel, 50, 50);
					eCounter++;
					if(eCounter % Structure.shopSlot == 0) {
						g2.setColor(Color.WHITE);
						g2.drawRect(q - (50 * (Structure.shopSlot-1)), yLevel, 50 * Structure.shopSlot, 50);
						g2.drawString(Structure.shopName, q - (50 * (Structure.shopSlot -1))/2 + 10, yLevel + 30);
					}
					q += 50;

					break;

				case "V": 
					g2.setColor(Color.BLACK);
					g2.fillRect(q, yLevel, 50, 50);
					vCounter++;
					if(vCounter % Structure.villaSlot == 0) {
						g2.setColor(Color.WHITE);
						g2.drawRect(q - (50 * (Structure.villaSlot-1)), yLevel, 50 * Structure.villaSlot, 50);
						g2.drawString(Structure.villaName, q - (50 * (Structure.villaSlot -1))/2 + 10, yLevel + 30);
					}
					q += 50;

					break;

				case "O": 

					g2.setColor(Color.BLACK);
					g2.fillRect(q, yLevel, 50, 50);
					oCounter++;
					if(oCounter % Structure.hotelSlot == 0) {
						g2.setColor(Color.WHITE);
						g2.drawRect(q - (50 * (Structure.hotelSlot-1)), yLevel, 50 * Structure.hotelSlot, 50);
						g2.drawString(Structure.hotelName, q - (50 * (Structure.hotelSlot -1))/2, yLevel + 30);
					}
					q += 50;


					break;

				case "P": 

					g2.setColor(Color.BLACK);
					g2.fillRect(q, yLevel, 50, 50);
					pCounter++;
					if(pCounter % Structure.parkSlot == 0) {
						g2.setColor(Color.WHITE);
						g2.drawRect(q - (50 * (Structure.parkSlot-1)), yLevel, 50 * Structure.parkSlot, 50);
						g2.drawString(Structure.parkName, q - (50 * (Structure.parkSlot -1))/2 + 10, yLevel + 30);
					}
					q += 50;

					break;
				default:
					System.out.println("Fehlerhaft Übernommen");

				}

			}            

			g2.setColor(Color.BLACK);
			g2.drawString(l.drawInfo(), 730, yLevel + 30);


			//			this.add(drawingPanel);
			//			this.add(datenPanel);
			yLevel += 55;
		}

		/**
		 * Pro Ebene: Was bin ich?
		 * Zum Testen: String kette aus der Console übernehmen 
		 * Informationen jeder Ebene
		 */
	}


	public void buildGui(){
		repaint();
	}

	public void updateDrawing(){
		removeAll();
		buildGui();

	}


}
