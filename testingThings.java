package warTracking;

import javax.swing.JFileChooser;

import java.io.BufferedReader;
import java.io.File; 
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
public class testingThings {
	 public static void main(String[] args) 
     {
		 FileHandle save = new FileHandle();
		 ArrayList<String> fileSave = save.loadFile();
		 saveFile(fileSave);
     
     }
	 
	 public static void saveFile(ArrayList<String> fileSave) {
		 String b = System.getProperty("line.separator");
         String path = "C:\\myfile.txt"; 
         FileWriter w = null; 
         System.out.println(fileSave);
         try
         {  
               w = new FileWriter(path);  
               for(Object play : fileSave) {
            	   String player = (String) play;
            	   w.write(player  + b);
               }
               w.flush(); 
               System.out.println("File Written: " + path);
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
