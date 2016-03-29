package View;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import Logic.Line;
import Logic.PathStorage;

public class VFractal extends JPanel implements Runnable{
	
	public static int blackness = 0;
	public static double coefficient = 0.333333;
	public static int startX = 300;
	public static int startY = 600;
	public static int amount = 2;
	
	public static ArrayList<Color> colors = new ArrayList<Color>();
	
	ArrayList<Line> up = new ArrayList<Line>();
	ArrayList<Line> right = new ArrayList<Line>();
	ArrayList<Line> down = new ArrayList<Line>();
	ArrayList<Line> left = new ArrayList<Line>();
	
	public VFractal(){
		this.setBackground(Color.BLACK);
		//createColorPalette();
		//Thread x1 = new Thread(this);
		//x1.start();
		createFractal();
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
	
	public void clearAllLists(){
		up.clear();
		right.clear();
		down.clear();
		left.clear();
	}
	
	
	public void createFractal() {
		clearAllLists();
		int[][][][][][][] ii = new int[1][1][1][1][1][1][1];
		System.out.println("Yo Create Dat Shit");
		
		ArrayList<Line> upTemp = new ArrayList<Line>();
		ArrayList<Line> rightTemp = new ArrayList<Line>();
		ArrayList<Line> downTemp = new ArrayList<Line>();
		ArrayList<Line> leftTemp = new ArrayList<Line>();
		
		//int startX = 300;
		//int startY = 500;
		//double coefficient = 0.22345;
		up.add(new Line(startX,startX,startY,startX));
		right.add(new Line(startY,startX,startY,startY));
		down.add(new Line(startX,startY,startY,startY));
		left.add(new Line(startX,startX,startX,startY));
		
		for (int i = 0; i<amount; i++){
			for (Line l : up){
				int x = l.x;
				int y = l.y;
				int v = l.xEnd;
				int w = l.yEnd;
				double xLength = v-x;
				double yLength = w-y;
				double xThird = coefficient*(xLength);
				double yThird = coefficient*(yLength);
				leftTemp.add(new Line(x+xThird,y-(xThird),x+xThird,y));
				rightTemp.add(new Line(x+(2*xThird),y-(xThird),x+(2*xThird),y));
				upTemp.add(new Line(x,y,x+xThird,y)); //left
				upTemp.add(new Line(x+xThird,y-(xThird),x+(2*xThird),y-(xThird))); //middle
				upTemp.add(new Line(x+(2*xThird),y,v,y)); //right
			}
			for (Line l : left){
				int x = l.x;
				int y = l.y;
				int v = l.xEnd;
				int w = l.yEnd;
				double xLength = v-x;
				double yLength = w-y;
				double xThird = coefficient*(xLength);
				double yThird = coefficient*(yLength);
				downTemp.add(new Line(x-yThird,y+(2*yThird),x,y+(2*yThird)));
				upTemp.add(new Line(x-yThird,y+yThird,x,y+yThird));
				leftTemp.add(new Line(x,y,x,y+yThird)); //up
				leftTemp.add(new Line(x-yThird,y+yThird,x-yThird,y+(yThird*2))); //middle
				leftTemp.add(new Line(x,y+(2*yThird),x,w)); //down
			}
			for (Line l : right){
				int x = l.x;
				int y = l.y;
				int v = l.xEnd;
				int w = l.yEnd;
				double xLength = v-x;
				double yLength = w-y;
				double xThird = coefficient*(xLength);
				double yThird = coefficient*(yLength);
				downTemp.add(new Line(x,y+(2*yThird),x+yThird,y+(2*yThird)));
				upTemp.add(new Line(x,y+yThird,x+yThird,y+yThird));
				rightTemp.add(new Line(x,y,x,y+yThird)); //up
				rightTemp.add(new Line(x+yThird,y+yThird,x+yThird,y+(yThird*2))); //middle
				rightTemp.add(new Line(x,y+(2*yThird),x,w)); //down
			}
				for (Line l : down){
					int x = l.x;
					int y = l.y;
					int v = l.xEnd;
					int w = l.yEnd;
					double xLength = v-x;
					double yLength = w-y;
					double xThird = coefficient*(xLength);
					double yThird = coefficient*(yLength);
					leftTemp.add(new Line(x+xThird,y,x+xThird,y+xThird));
					rightTemp.add(new Line(x+(2*xThird),y,x+(2*xThird),y+xThird));
					downTemp.add(new Line(x,y,x+xThird,y)); //left
					downTemp.add(new Line(x+xThird,y+(xThird),x+(2*xThird),y+(xThird))); //middle
					downTemp.add(new Line(x+(2*xThird),y,v,y)); //right
			}
		
		
			
			up.clear();
			for (Line a : upTemp) up.add(a);
			upTemp.clear();
			
			right.clear();
			for (Line a : rightTemp) right.add(a);
			rightTemp.clear();
			
			left.clear();
			for (Line a : leftTemp) left.add(a);
			leftTemp.clear();
			
			down.clear();
			for (Line a : downTemp) down.add(a);
			downTemp.clear();
			repaint();
		}
	
		
	}
	public void drawFractal(Graphics g){
		
		for (Line l : up){
			g.drawLine(l.x, l.y, l.xEnd, l.yEnd);
		}
		for (Line l : right){
			g.drawLine(l.x, l.y, l.xEnd, l.yEnd);
		}
		for (Line l : down){
			g.drawLine(l.x, l.y, l.xEnd, l.yEnd);
		}
		for (Line l : left){
			g.drawLine(l.x, l.y, l.xEnd, l.yEnd);
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
		this.drawFractal(g);
	}
	public void drawText(Graphics g) {
        super.paintComponent(g);
        int height = getHeight();
        String text = "";

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
