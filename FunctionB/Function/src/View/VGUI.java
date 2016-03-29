package View;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import Logic.PathStorage;

public class VGUI extends JPanel implements Runnable{
	
	public static int blackness = 0;
	public static boolean up = true;
	public static boolean moving = true;
	public static ArrayList<Color> colors = new ArrayList<Color>();
	
	public VGUI(){
		this.setBackground(Color.BLACK);
		//createColorPalette();
		//Thread x1 = new Thread(this);
		//x1.start();
	}
	
	public void run(){
		while(true){
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			repaint();
		}
	}
	
	public void drawMe(Graphics g) {
		
		int x = getWidth();
		int y = getHeight();
		//g.drawRect((int)(Math.random()*x), (int)(Math.random()*y), (int)(Math.random()*x), (int)(Math.random()*y));
		
		
		int a = PathStorage.getSize();
		for (int i = 0; i<a;i++){
			g.drawRect(20+(i*5)+1, 20, 0, 40);
		}
		
		
	}
	public void createColorPalette(){
		for (int i = 0; i<512; i++){
			Color c = null;
			if (i<256) 	c = new Color(i,i,i);
			System.out.println(i);
			if (i>=256) c = new Color(255+(256-i),255+(256-i),255+(256-i));
			colors.add(c);
		}
		
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.drawMe(g);
		this.drawText(g);
	}
	public void drawText(Graphics g) {
        super.paintComponent(g);
        int height = getHeight();
        String text = "No Directory or File has been selected yet";

        g.setColor(Color.WHITE);
//        g.drawLine(0, height / 2, getWidth(), height / 2);
        
//      if (blackness<0) blackness = 0;
//      if (blackness==colors.size()) blackness = 0;
//      g.setColor(colors.get(blackness));
//      blackness++;

        FontMetrics fm = g.getFontMetrics();
        int totalWidth = (fm.stringWidth(text) * 2) + 4;

        // Baseline
        int x = (getWidth() - totalWidth) / 2;
        int y = (getHeight() - fm.getHeight()) / 2;


        

      //  g.drawString(text, x, y + ((fm.getDescent() + fm.getAscent()) / 2));

        // Absolute...
        x = fm.stringWidth(text);
     
        y = ((getHeight() - fm.getHeight()) / 2) + fm.getAscent();
        g.drawString(text, (getWidth()/2)-(x/2), y);

    }
}
