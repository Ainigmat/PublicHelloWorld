package Control;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import View.VFractal;

public class KeyControl extends KeyAdapter

{
	private int key = 0;
	private VFractal fractal;

	public KeyControl() {
	}
	public KeyControl(VFractal fractal) {
		this.fractal=fractal;
	}


	public void keyPressed(KeyEvent e) {

		key = e.getKeyCode();
		System.out.println(key);
		if (key == KeyEvent.VK_1 || key == 107) {
			try {
				// || key == KeyEvent.
				// if(tickTimer>8){

			} catch (Exception io) {
			}

			// drawfield(113);

		}
		if (key == KeyEvent.VK_BACK_SPACE) {
			try {
				
			} catch (Exception io) {

			}
		}
		if (key == KeyEvent.VK_2 || key == 109) {
			try {

			} catch (Exception io) {
			}

			// drawfield(113);

		}
		if (key == KeyEvent.VK_ESCAPE) {
			try {
				System.exit(1);
			} catch (Exception io) {

			}
		}
		if (key == KeyEvent.VK_CONTROL) {
			try {
			} catch (Exception io) {

			}
		}
		if (key == KeyEvent.VK_F1) {
			fractal.amount++;
			fractal.createFractal();
			fractal.repaint();
			System.out.println(fractal.amount);
			try {
			} catch (Exception io) {
			}
		}
		if (key == KeyEvent.VK_F2) {
			if(fractal.amount>0){
			fractal.amount--;
			fractal.createFractal();
			fractal.repaint();
			}
			System.out.println(fractal.amount);
			try {
			} catch (Exception io) {
				
		
				
			}
		}
		if (key == KeyEvent.VK_5) {
			try {

			} catch (Exception io) {

			}
		}
		if (key == KeyEvent.VK_6) {
			try {

			} catch (Exception io) {

			}
		}
		if (key == 38) { // pfeil hoch
			VFractal.coefficient += 0.008;
			fractal.createFractal();
			fractal.repaint();
			try {
			} catch (Exception io) {
			
			}
		}
		if (key == 40) { // pfeil runter
			VFractal.coefficient -= 0.008;
			fractal.createFractal();
			fractal.repaint();
			try {
			} catch (Exception io) {
				
			}
		}
		if (key == 37) { // pfeil links
			fractal.startX+=10;
			fractal.createFractal();
			fractal.repaint();
			try {
			} catch (Exception io) {

			}
		}
		if (key == 39) { // pfeil rechts
			fractal.startX-=10;
			fractal.createFractal();
			fractal.repaint();
			try {
				
			} catch (Exception io) {

			}
		} 
		if (key == 107) { //NumLock +
			try {
				System.out.println("slower dia");
			} catch (Exception io) {

			}
		}
		if (key == 109) { //NumLock -
			try {
				System.out.println("faster dia");
			} catch (Exception io) {

			}
		}

		if (key == KeyEvent.VK_F2) { // VK_SPACE
			try {
				
			} catch (Exception io) {
			}

			// drawfield(113);

		}
	}

}
