package warTracking;

import java.awt.List;
import java.util.ArrayList;

public class graphData {
	public static ArrayList<Double> performance(FileHandle file, ArrayList<String> saveList) {
		int numWars = Integer.parseInt(saveList.get(0));
		ArrayList<Double> scores = new ArrayList<Double>();
		for (int i = 0; i <= numWars; i++) {
			war current = file.loadWar(i);
			current.updateStars();
			scores.add((double) current.getStars());
		}
		return scores;
	}
	public static ArrayList<Double> parting(FileHandle file, ArrayList<String> saveList) {
		int numWars = Integer.parseInt(saveList.get(0));
		ArrayList<Double> scores = new ArrayList<Double>();
		for (int i = 0; i <= numWars; i++) {
			war current = file.loadWar(i);
			scores.add((double) current.parting());
		}
		return scores;
	}
	public static ArrayList<Double> losses(FileHandle file, ArrayList<String> saveList) {
		int numWars = Integer.parseInt(saveList.get(0));
		ArrayList<Double> scores = new ArrayList<Double>();
		for (int i = 0; i <= numWars; i++) {
			war current = file.loadWar(i);
			scores.add((double) current.losing());
		}
		return scores;
	}
}
