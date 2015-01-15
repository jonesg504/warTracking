package warTracking;

import java.util.ArrayList;

public class war extends Clan {
	private int totalStars = 0;
	private int attacksWon = 0;
	private int attacksUsed = 0;
	private int warNum = 0;
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
	public double updateWL() {
		attacksWon = 0;
		attacksUsed = 0;
		for (Player play : players) {
			attacksWon += play.getAttackW();
			attacksUsed += play.getAttackU();
		}
		if(attacksUsed == 0) {
			return 0;
		}
		return (attacksWon/attacksUsed);
	}
	public void resetPlayers() {
		for (Player play : super.players) {
			play.setStars(0);
			play.setAttackU(0);
			play.setAttackW(0);
		}
	}
	public double attack(Player player, int opponent, int starsAdded) {
		player.addStars(starsAdded);
		player.addAttackU();
		if (starsAdded > 0) {
			player.addAttackW();
		}
		double worth = Math.pow(10, opponent - player.getThLevel()) * starsAdded;
		return worth;
	}
	
	public double defense(Player player, Player opponent, int starsAdded) {
		double multiplier = Math.pow(2, -starsAdded);
		double worth = Math.pow(10, opponent.getThLevel() - player.getThLevel()) * multiplier ;
		player.addWorth(worth);
		return worth;
	}
	
}
