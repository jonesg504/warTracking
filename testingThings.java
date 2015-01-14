package warTracking;

import javax.swing.JFileChooser;

import java.io.BufferedReader;
import java.io.File; 
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
public class testingThings {
	private static File selectedFile = null;
	public static void chooseFile() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		int result = fileChooser.showOpenDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
		    selectedFile = fileChooser.getSelectedFile();
		    if (!selectedFile.getName().equals("save.txt")) {
		    	System.out.println("INVALID SAVE FILE: Please load \"save.txt\"");
		    } else {
		    	System.out.println("Save file loaded successfully!");
		    }
		}
	}
	public static void printFile() throws IOException {
		FileReader fr = new FileReader(selectedFile);
		BufferedReader textReader = new BufferedReader(fr);
		System.out.println(textReader.readLine());
		String tok = textReader.readLine();
		String[] values = tok.split("\\s");
		for (int i = 0; i < values.length; i++) {
			System.out.println(values[i]);
		}
	}
}
