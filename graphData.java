package warTracking;

import java.awt.List;
import java.util.ArrayList;

import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class graphData {
	public static XYSeriesCollection performance(FileHandle file, ArrayList<String> saveList) {
		 final XYSeries sample = new XYSeries("Firefox");   
		  int numWars = Integer.parseInt(saveList.get(0));
			for (int i = 0; i <= numWars; i++) {
				
				war current = file.loadWar(i);
				current.updateStars();
				double starDat = current.getStars();
				if ( i == 0) {
					sample.add(i + 1, (59.0/75.0) * 100);
				} else {
					sample.add(i + 1, (starDat/(current.getNumPlayers() * 3)) * 100);
				}
				
			}
	      final XYSeriesCollection dataset = new XYSeriesCollection( );          
	      dataset.addSeries( sample );          
	      
	      return dataset;
	}
	public static XYSeriesCollection parting(FileHandle file, ArrayList<String> saveList) {
		final XYSeries sample = new XYSeries("Firefox");   
		  int numWars = Integer.parseInt(saveList.get(0));
			for (int i = 0; i <= numWars; i++) {
				
				war current = file.loadWar(i);
				current.updateStars();
				sample.add((double)i + 1, current.parting());
			}
	      final XYSeriesCollection dataset = new XYSeriesCollection( );          
	      dataset.addSeries( sample );          
	      
	      return dataset;
	}
	public static XYSeriesCollection losses(FileHandle file, ArrayList<String> saveList) {
		final XYSeries sample = new XYSeries("Firefox");   
		  int numWars = Integer.parseInt(saveList.get(0));
			for (int i = 0; i <= numWars; i++) {
				
				war current = file.loadWar(i);
				current.updateStars();
				sample.add((double)i + 1, current.losing());
			}
	      final XYSeriesCollection dataset = new XYSeriesCollection( );          
	      dataset.addSeries( sample );          
	      
	      return dataset;
	}
	public static XYSeriesCollection playerWarStat(Player player, FileHandle file, ArrayList<String> saveList) {
		boolean clanList = true;
		final XYSeries sample = new XYSeries("Firefox");
		int i = 1;
		for(String str : saveList) {
			if(str.contains(player.getName())) {
				if (clanList) {
					clanList = false;
				} else {
					String[] values = str.split("\\s");
					int stars = Integer.parseInt(values[2]);
					int attacksUsed = Integer.parseInt(values[3]);
					sample.add((double)i, stars);
					i++;
				}
			}
		}
		final XYSeriesCollection dataset = new XYSeriesCollection( ); 
		dataset.addSeries( sample );   
		return dataset;
		
	}
}
