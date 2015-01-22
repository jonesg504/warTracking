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
		for (Player play : super.players) {
			totalStars += play.getStars();
		}
	}
	public int getStars() {
		return totalStars;
	}
	public int getNumPlayers() {
		return super.players.size();
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
	public double parting() {
		double full = super.players.size() * 2;
		double part = 0;
		for (Player play : super.players) {
			part += play.getAttackU();
		}
		return (part/full) * 100 ;
	}
	public double losing() {
		double losses = 0;
		for (Player play : super.players) {
			losses += play.getAttackU() - play.getAttackW();
		}
		return losses;
	}
	public double attack(Player player, int opponent, int starsAdded) {
		player.addStars(starsAdded);
		totalStars += starsAdded;
		player.addAttackU();
		if (starsAdded > 0) {
			player.addAttackW();
		}
		int multiplier = (opponent - 8) + 1;
		if (multiplier < 0) {
			multiplier = 0;
		}
		double worth = (Math.pow(2, opponent - player.getThLevel()) * starsAdded) * multiplier;
		worth = Math.round(worth * 100);
		return worth;
	}
	
	public double defense(Player player, int opponent, int starsAdded) {
		double multiplier = Math.pow(2, -starsAdded);
		double worth = Math.pow(2, opponent - player.getThLevel()) * multiplier;
		worth = Math.round(worth * 100);
		return worth;
	}
	
}
