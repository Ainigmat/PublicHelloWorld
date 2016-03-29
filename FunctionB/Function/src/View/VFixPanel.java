package View;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class VFixPanel extends JPanel{

	public VFixPanel(){
		this.setBackground(Color.BLACK);
		Dimension d = new Dimension(600,500);
		this.setPreferredSize(d);
	}
	public VFixPanel(int width,int height){
		this.setBackground(Color.BLACK);
		Dimension d = new Dimension(width,height);
		this.setPreferredSize(d);
	}
	public VFixPanel(boolean doYouWantPreferredSize){
		this.setBackground(Color.BLACK);
//		Dimension d = new Dimension(width,height);
//		this.setPreferredSize(d);
		// egal ob true oder false, hehe...
	}
	
}
