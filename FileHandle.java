package warTracking;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;

public class FileHandle {
	private File selectedFile = null;
	public FileHandle() {
		chooseFile();
	}
	
	
	
	public void chooseFile() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
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
	public void printFile() throws IOException {

		FileReader fr = new FileReader(selectedFile);
		BufferedReader textReader = new BufferedReader(fr);
		System.out.println(textReader.readLine());
		String tok = textReader.readLine();
		String[] values = tok.split("\\s");
		for (int i = 0; i < values.length; i++) {
			System.out.println(values[i]);
		}
	}
	public Clan loadClan() {
		Clan loadClan = new Clan();
		FileReader fr = null;
		try {
			fr = new FileReader(selectedFile);
			BufferedReader textReader = new BufferedReader(fr);
			String line = textReader.readLine();
			line = textReader.readLine();
			while(true) {
				if (line.equals("endLoadClan")) {
					break;
				}
				String[] profile = line.split("\\s");
				loadClan.add(new Player(profile[0], Integer.parseInt(profile[1]), Double.parseDouble(profile[2])));
				line = textReader.readLine();
			}
			fr.close();
			return loadClan;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	public war loadWar(int num) {
		war loadWar = new war();
		FileReader fr = null;
		try {
			fr = new FileReader(selectedFile);
			BufferedReader textReader = new BufferedReader(fr);
			String warNum = "war" + num;
			String line = textReader.readLine();
			while (true) {
				if (line.equals(warNum) || line.contains("END")) {
					break;
				}
				line = textReader.readLine();
			}
			line = textReader.readLine();
			while(true) {
				if (line.equals(warNum + "End")) {
					break;
				}
				String[] profile = line.split("\\s");
				loadWar.add(new Player(profile[0], Integer.parseInt(profile[1]), Integer.parseInt(profile[2])));
				line = textReader.readLine();
			}
			fr.close();
			return loadWar;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
		
	}
}
