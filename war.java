package warTracking;

import java.util.ArrayList;

public class war extends Clan {
	private int totalStars = 0;
	private ArrayList<Player> players = new ArrayList(50);
	public war (Player...players) {
		super(players);
	}
	public war (int stars) {
		totalStars = stars;
	}
	public void updateStars() {
		for (Player play : players) {
			totalStars += play.getStars();
		}
	}
	public int getStars() {
		return totalStars;
	}
	public ArrayList<Player> getPlayers() {
		return players;
	}
	public double attack(Player player, Player opponent, int starsAdded) {
		player.setStars(starsAdded);
		double worth = Math.pow(10, player.getThLevel() - opponent.getThLevel()) * starsAdded;
		player.addWorth(worth);
		return worth;
	}
	public double defense(Player player, Player opponent, int starsAdded) {
		double multiplier = Math.pow(2, -starsAdded);
		double worth = Math.pow(10, opponent.getThLevel() - player.getThLevel()) * multiplier ;
		player.addWorth(worth);
		return worth;
	}
}