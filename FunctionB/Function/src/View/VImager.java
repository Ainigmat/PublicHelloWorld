package View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;

import javax.swing.JPanel;

public class VImager extends JPanel{
	// KlassenVariablen Anfang
	private Image img = null;
	private Thread t1;

	private static int time = 175;

	private boolean[][] feld = new boolean[80][80];

	private String path;
	// private String path =
	// "C:\\Users\\Marwin Lebensky\\Documents\\Screenshot001.jpg";
	private boolean stopped;
	private int x = 0;
	private int y = 0;

	// KlassenVariablen Ende
	
	public VImager(){
		this.setBackground(Color.BLACK);
	}
	
	public void setImage(String filePath) {

		img = getToolkit().getImage(filePath);

		path = filePath;
		if (path != null) {
			img = getToolkit().getImage(path);
			MediaTracker mt = new MediaTracker(this);
			mt.addImage(img, 0);
			try {
				mt.waitForAll();
			} catch (InterruptedException ie) {
			}
			repaint();
		}
	}

	public void drawMe(Graphics g) {
		
		
		
		if (path != null) {
			
			MediaTracker mt = new MediaTracker(this);
			mt.addImage(img, 0);
			try {
				mt.waitForAll();
			} catch (InterruptedException interruptedexception) {
			}
			
			int imgX = img.getWidth(null);
			int imgY = img.getHeight(null);
			double props = (double) imgX / (double) imgY;
			double scalePanel = (double) getWidth();
			g.drawImage(img,
					(getWidth() - (int) ((double) getHeight() * props)) / 2, 0,
					(int) ((double) getHeight() * props), getHeight(), this);
		


		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.drawMe(g);
	}
}
