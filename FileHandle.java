package warTracking;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

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
		    	JOptionPane.showMessageDialog(null, "INVALID FILE: Plz load \"save.txt\"");
		    } else {
		    	JOptionPane.showMessageDialog(null, "Save file loaded successfully!");
		    }
		}
	}
	public void printFile() throws IOException {

		FileReader fr = new FileReader(selectedFile);
		BufferedReader textReader = new BufferedReader(fr);
		String tok = textReader.readLine();
		String[] values = tok.split("\\s");
		for (int i = 0; i < values.length; i++) {
			System.out.println(values[i]);
		}
	}
	public ArrayList<String> loadFile() {
		FileReader fr = null;
		ArrayList<String> fileList = new ArrayList();
		try {
			fr = new FileReader(selectedFile);
			BufferedReader textReader = new BufferedReader(fr);
			String line = textReader.readLine();
			while(true) {
				if (line.equals("endSaveFile")) {
					fileList.add(line);
					break;
				}
				fileList.add(line);
				line = textReader.readLine();
			}
			fr.close();
			return fileList;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileList;
	}
	public Clan loadClan() {
		Clan loadClan = new Clan();
		FileReader fr = null;
		try {
			fr = new FileReader(selectedFile);
			BufferedReader textReader = new BufferedReader(fr);
			String line = textReader.readLine();
			line = textReader.readLine();
			line = textReader.readLine();

			while(true) {
				if (line.equals("endLoadClan")) {
					break;
				}
				String[] profile = line.split("\\s");
				loadClan.add(new Player(profile[0], Integer.parseInt(profile[1]), Double.parseDouble(profile[2]), Integer.parseInt(profile[3])));
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
				loadWar.add(new Player(profile[0], Integer.parseInt(profile[2]), Integer.parseInt(profile[1]), Integer.parseInt(profile[3]), Integer.parseInt(profile[4])));
				line = textReader.readLine();
			}
			fr.close();
			return loadWar;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	public static void saveFile(ArrayList<String> fileSave) {
		 String b = System.getProperty("line.separator");
        String path =System.getProperty("user.dir") + "/save.txt"; 
        FileWriter w = null; 
        try
        {  
              w = new FileWriter(path);  
              for(Object play : fileSave) {
           	   String player = (String) play;
           	   w.write(player  + b);
              }
              w.flush(); 
        }
        catch(IOException ex)
        {
              System.out.println("File Writing Error");
        }
        finally
        {
              try
              {
                    w.close(); 
              }
              catch(IOException ex)
              {
                    System.out.println("File Closing Error");
             }
        }     
	 }


}
