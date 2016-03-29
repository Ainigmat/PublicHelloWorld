package View;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class VPanel extends JPanel{
	
	public VPanel(){
		renameButtons();
		this.add(button1);
		this.add(button2);
		this.add(button3);
		this.add(button4);
		this.add(button5);
	}
	
	
	public void buttonMapToListener(ActionListener l){
		button1.addActionListener(l);
		button2.addActionListener(l);
		button3.addActionListener(l);
		button4.addActionListener(l);
		button5.addActionListener(l);
	}
	public void renameButtons(){
//		button1.setName("Exit");
//		button2.setName("Get Directory");
//		button3.setName("Generate File");
//		button4.setName("Change Settings");
//		button5.setName("Change Settings");
	}
	
	
	JButton button1 = new JButton("Select Directory");
	JButton button2 = new JButton("Generate Text");
	JButton button3 = new JButton("Generate File");
	JButton button4 = new JButton("Change Settings");
	JButton button5 = new JButton("Exit");

}
