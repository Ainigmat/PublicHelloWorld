package View;

import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;

import javax.swing.JFileChooser;

import Logic.PathStorage;


public class DialogPicker {
	public static String currentPath = null;
public DialogPicker(){
	JFileChooser dialog = new JFileChooser();
	if (dialog.showOpenDialog(null) == (JFileChooser.APPROVE_OPTION)) {
		//PathStorage.clearList();
		
		currentPath = dialog.getSelectedFile().getAbsolutePath();
		System.out.println(currentPath);
	}
		
}

public String returnPath(){
	return currentPath;
	
// EVTL ARRAYLIST MACHEN!!!!!!!!
// 
}
}
