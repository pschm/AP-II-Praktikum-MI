package GUI;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class JCityPanel extends JPanel {

	public void paintComponent (Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		super.paintComponent(g);
		g2d.drawRect(5, 5, getWidth()-10, getHeight() - 10 );
		}
}
