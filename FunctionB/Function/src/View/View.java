package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import Logic.PathStorage;
import Control.KeyControl;

public class View extends JFrame implements ActionListener {

	public View() {
		this.setSize(640, 150);
		//Look and Feel
		try {
			UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName() );
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Look and Feel End
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
		this.setLocation((int) (width / 3f), (int) (height / 3f));
		this.setDefaultCloseOperation(3);

		// Layout
		this.setLayout(new BorderLayout());
		// Layout End

		// Components

		panel = new VPanel();
		imager = new VImager();
		
		//this.add(imager, BorderLayout.CENTER);
		this.add(gui, BorderLayout.CENTER);
		this.add(panel, BorderLayout.PAGE_END);
		// Components End

		// Keyboard and Mouse Listener
//		KeyControl key = new KeyControl(fractal);
//		fractal.addKeyListener(key);
		// Keyboard and Mouse Listener End

		// ActionListener
		panel.buttonMapToListener(this);
		// ActionListene1r End

		this.setVisible(true);

	}
	public void popUpGeneratedTextJFrame(){
		JFrame newFrame = new JFrame();
		newFrame.add(textField);
		newFrame.setSize(640, 480);
		newFrame.setLocation(this.getLocation());
		newFrame.setVisible(true);
	}
	public void popUpFractalPanel(){
		JFrame newFrame = new JFrame();
		fractal = new VFractal();
		newFrame.add(fractal);
		newFrame.setSize(640, 480);
		newFrame.setLocation(this.getLocation());
		KeyControl key = new KeyControl(fractal);
		newFrame.addKeyListener(key);
		newFrame.setVisible(true);
	}

	public void actionPerformed(ActionEvent event) {
		String action = event.getActionCommand();
		if (action.equals("Exit")) {
			System.exit(1);
			requestFocusInWindow(); // Bisschen Holzhammer, aber dadurch
									// sind die Listener wieder am Start!
		}
		if (action.equals("Select Directory")) {
			DialogPicker dialog = new DialogPicker();
			// System.out.println(dialog.returnPath()
			// + " <- Diese Datei wurde vom User im Dialog ausgewählt!");
			// imager.setImage(dialog.returnPath()); // Wird dem ImagePanel
			// direkt übergeben und sofort gezeichnet!
			// files.addToList(dialog.returnPath()); // Wird der ArrayListe
			// hinzugefügt!
			files.addDir(dialog.returnPath()); // Ordner mit allen Dateien wird
												// hinzugefügt!
		}
		if (action.equals("Generate File")) {
			imager.setImage(files.getDirectory()
					+ files.getIndex(files.getSelection()));
		}
		if (action.equals("Generate Text")) {
			addStringsToTextPane();
			popUpGeneratedTextJFrame();
		}
		if (action.equals("Change Settings")) {
			popUpFractalPanel();
		}
	}
	
	public void addStringsToTextPane(){
		String x = "";
		x = PathStorage.getIndex(PathStorage.getSelection());
		textField.setText(files.getAllFilesAsString());
	}

	public PathStorage files = new PathStorage();
	public VImager imager;
	public VPanel panel;
	public JPanel middlePanel = new VFixPanel(false);
	public JTextPane textField = new JTextPane();
	public VGUI gui = new VGUI();
	public VFractal fractal;

}
