package Logic;
import java.io.File;
import java.util.ArrayList;

public class PathStorage {

	private static ArrayList<String> files = new ArrayList<String>();
//	private static Imager img;
	private static final String supportedFiles[] = { ".gif", ".jpg", ".png",
			".jpeg" };
	private static int currentSelection;
	private static String directory;

//	public PathStorage(Imager imgr) {
//		// Klasse für ArrayListe voller Strings! Bilder werden nicht abgespeichert, sondern nur der Pfad!
//		this.img = imgr;
//		this.files = new ArrayList<String>();
//		this.currentSelection = 0;
//	}

	public static void clearList() {
		files.clear();
	}

	public static void addToList(String path) {
		files.add(path);
		System.out.println(path + " wurde der ArrayList hinzugefügt");
	}

	public static String getIndex(int x) {
		if (x < getSize()) {
			return files.get(x);
		} else {
			return null;
		}
	}

	public static String getDirectory(){
		return directory;
	}
	
	public static int getSelection(){
		return currentSelection;
	}
	


	public void addDir(String filePath) { // mit dieser Methode holen wir den Ordnerpfad

		int index = filePath.lastIndexOf('\\');
		System.out.println(index);
		clearList();
		directory = filePath.substring(0, index + 1);

		File folder = new File(directory);
		File listOfFiles[] = folder.listFiles();
		try {
			for (int i = 0; i < listOfFiles.length; i++) {

				String file = listOfFiles[i].getPath();
				file = file.substring(file.lastIndexOf('\\') + 1);
				if (isSupported(file))
					addToList(file);
			}
		} catch (Exception e) {
		}
		currentSelection = 0;
//		img.setImage(filePath);
		System.out
				.println(PathStorage.getIndex(currentSelection) + " SELECTED");

	}

	private boolean isSupported(String file) { // hier wird überprüft, ob es sich um ein passendes Format handelt
		try {
			file = file.substring(file.lastIndexOf('.'));
		} catch (StringIndexOutOfBoundsException e) {
			return false;
		}
		for (int i = 0; i < supportedFiles.length; i++)
			if (file.equals(supportedFiles[i]))
				return true;
		return false;
	}

	public static int getSize() {
		return files.size();
	}

	public static void next() {
		System.out.println("next");
		if (files != null) {

			int temp = (currentSelection+1) % (files.size());
			System.out.println(temp);
//			img.setImage(directory + files.get(temp)); // HMM
			currentSelection = temp;
		}

	}

	public static void previous() {
		System.out.println("previous");
		if (files != null) {

			
				//(a % b + b) % b
				currentSelection = ((currentSelection-1)%files.size()+files.size())%files.size();
				System.out.println(currentSelection);
//				img.setImage(directory + files.get(currentSelection));
				
		
		}

	}
	public static String getAllFilesAsString(){
		String tempString = "";
		for (String a : files){
			tempString = tempString+directory+a+"Coordinate "+"\n";
		}
		return tempString;
	}

}
