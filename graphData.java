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
	public static ArrayList<Double> playerWarStat(Player player, FileHandle file, ArrayList<String> saveList) {
		boolean clanList = true;
		ArrayList<Double> list = new ArrayList<Double>();
		for(String str : saveList) {
			if(str.contains(player.getName())) {
				if (clanList) {
					clanList = false;
				} else {
					String[] values = str.split("\\s");
//					System.out.println(values[0]);
//					System.out.println(values[1]);
//					System.out.println(values[2]);
//					System.out.println(values[3]);
					int stars = Integer.parseInt(values[2]);
					int attacksUsed = Integer.parseInt(values[3]);
					list.add((double) stars);
				}
			}
		}
		
		
		return list;
	}
}
