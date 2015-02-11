package warTracking;

import java.awt.List;
import java.util.ArrayList;

import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class graphData {
	public static XYSeriesCollection performance(XMLParser parse) {
		 final XYSeries sample = new XYSeries("Firefox");   
		  int numWars = parse.numWars();
			for (int i = 0; i <= numWars; i++) {
				
				war current = parse.loadWar(i);
				//current.updateStars();
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
	public static XYSeriesCollection parting(XMLParser parse) {
		final XYSeries sample = new XYSeries("Firefox");   
		  int numWars = parse.numWars();
			for (int i = 0; i <= numWars; i++) {
				
				war current = parse.loadWar(i);
				current.updateStars();
				sample.add((double)i + 1, current.parting());
			}
	      final XYSeriesCollection dataset = new XYSeriesCollection( );          
	      dataset.addSeries( sample );          
	      
	      return dataset;
	}
	public static XYSeriesCollection losses(XMLParser parse) {
		final XYSeries sample = new XYSeries("Losses");   
		//final XYSeries wins = new XYSeries("Wins");   
		  int numWars = parse.numWars();
			for (int i = 0; i <= numWars; i++) {
				
				war current = parse.loadWar(i);
				current.updateStars();
				sample.add((double)i + 1, current.losing());
				//wins.add((double)i + 1, current.winning());
			}
	      final XYSeriesCollection dataset = new XYSeriesCollection( );          
	      dataset.addSeries(sample);
	      //dataset.addSeries(wins);
	      
	      return dataset;
	}
	public static XYSeriesCollection playerWarStat(Player player, XMLParser parse) {
		final XYSeries sample = new XYSeries("Stars");
		ArrayList<Integer>  starList = parse.getPlayerStars(player.getName());
		int xPoint = 1;
		for (int i : starList) {
			sample.add(xPoint, i);
			xPoint++;
		}
		
		final XYSeriesCollection dataset = new XYSeriesCollection( ); 
		dataset.addSeries( sample );   
		return dataset;
		
	}
	public static DefaultPieDataset playerWarPart(Player player, XMLParser parse) {
		DefaultPieDataset dataset = new DefaultPieDataset();
		ArrayList<Integer>  starList = parse.getPlayerPart(player.getName());
		int xPoint = 1;
		double percentUsed = 0;
		for (int i : starList) {
			percentUsed += ((double)i/ (starList.size() * 2));
		}
		double percentUnused = 1- percentUsed;
		dataset.setValue("Attacked", percentUsed);
		dataset.setValue("Didn't attack", percentUnused);
		return dataset;
		
	}
	public static DefaultPieDataset playerWarWin(Player player, XMLParser parse) {
		DefaultPieDataset dataset = new DefaultPieDataset();
		ArrayList<Integer>  starList = parse.getPlayerWin(player.getName());
		int xPoint = 1;
		double percentUsed = 0;
		for (int i : starList) {
			percentUsed += ((double)i/ (starList.size() * 2));
		}
		double percentUnused = 1- percentUsed;
		dataset.setValue("Wins", percentUsed);
		dataset.setValue("Losses", percentUnused);
		return dataset;
		
	}
	public static DefaultCategoryDataset playerWarRank(Player player, XMLParser parse) {
		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		ArrayList<ArrayList>  array = parse.getPlayerRank(player.getName());
		ArrayList<Attack>  attacks = array.get(0);
		ArrayList<Integer>  warNum = array.get(1);
		ArrayList<String> catagory = new ArrayList<>();
		int previous = warNum.get(0) - 1;
		for (int i : warNum) {
			if (previous != i) {
				catagory.add("" + i);
				previous = i;
			}
		}
		System.out.println(attacks);
		final String series1 = "Attack1";
		final String series2 = "Attack2";
		int warTrack = warNum.get(0);
		int attackTrack = 0;
		System.out.println(attacks);
		System.out.println(warNum);
		for (int i = 0; i < attacks.size(); i++) {
			if (warTrack == warNum.get(i)) {
				if (attackTrack == 0) {
					System.out.println(warTrack);
					int index = catagory.indexOf("" + warNum.get(i));
					dataset.addValue(attacks.get(i).getBaseRank(), series1, catagory.get(index));
					attackTrack = 1;
				} else {
					int index = catagory.indexOf("" + warNum.get(i));
					dataset.addValue(attacks.get(i).getBaseRank(), series2, catagory.get(index));
					attackTrack = 0;
				}
			} else {
				warTrack++;
				attackTrack = 0;
				if (attackTrack == 0) {
					int index = catagory.indexOf("" + warNum.get(i));
					dataset.addValue(attacks.get(i).getBaseRank(), series1, catagory.get(index));
					attackTrack = 1;
				} else {
					int index = catagory.indexOf("" + warNum.get(i));
					dataset.addValue(attacks.get(i).getBaseRank(), series2, catagory.get(index));
					attackTrack = 0;
				}
			}
		}
		
		return dataset;
		
	}
}
