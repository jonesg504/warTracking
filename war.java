package warTracking;

import java.util.ArrayList;

public class war extends Clan {
	private int totalStars = 0;
	private int attacksWon = 0;
	private int attacksUsed = 0;
	private int warNum = 0;
	private int rank;
	private ArrayList<Attack> attacks = new ArrayList<Attack>();
	private ArrayList<Player> players = new ArrayList<Player>(50);
	private ArrayList<Defense> defends = new ArrayList<Defense>();
	public war (Player...players) {
		super(players);
	}
	public war (int stars) {
		totalStars = stars;
	}
	public void updateStars() {
		totalStars = 0;
		for (Player play : super.players) {
			play.setStars(0);
		}
		for (Attack play : attacks) {
			getPlayer(play.getPlayer()).addStars(play.getStars());
			totalStars += play.getStars();
		}
	}
	public double getStars() {
		return totalStars;
	}
	public int getNumPlayers() {
		return super.players.size();
	}
	public ArrayList<Player> getPlayers() {
		return super.players;
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
	public double winning() {
		double wins = 0;
		for (Player play : super.players) {
			wins += play.getAttackW();
		}
		return wins;
	}
	public double attack(Player player, Attack att) {
		player.addStars(att.getStars());
		if(att.getStars() == 3) {
			att.setStar3(true);
		}
		player.addAttackU();
		if (att.getStars() > 0) {
			player.addAttackW();
		}
		return att.calcWorth(super.players.size(), player);
	}
	public void loadAttack(Attack att) {
		attacks.add(att);
		totalStars += att.getStars();
	}
	public void updateWorths(Clan clan, int numPlayers) {
		for (Attack att : attacks) {
			att.setWorth((int)att.calcWorth(numPlayers, clan.getPlayer(att.getPlayer())));
		}
	}
	public String toString() {
		updateStars();
		String warString = "";
		warString += "Attacks Won: " + this.winning();
		warString += "\nAttacks Lost: " + this.losing();
		this.updateStars();
		warString += "\nStars: " + totalStars;
		
		
		return warString;
	}
	public double defense(Player player, int opponent, int starsAdded) {
		Defense defense = new Defense(player.getName(), starsAdded, opponent);
		return defense.calcWorth(super.players.size(), player);
	}
	public ArrayList<Attack> getAttacks() {
		return attacks;
	}
	public void setAttacks(ArrayList<Attack> attacks) {
		this.attacks = attacks;
	}
	public int getRank() {
		return rank;
	}
	public ArrayList<Attack> eraseAttacks(String player) {
		ArrayList<Attack> removeAtt = new ArrayList<>();
		for(int i = 0; i < attacks.size(); i++){
			if (attacks.get(i).getPlayer().equals(player)) {
				removeAtt.add(attacks.remove(i));
				i--;
			}
		}
		return removeAtt;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public void updateWarNums() {
		for(Player play : super.players) {
			play.setNumWars(play.getNumWars() + 1);
		}
		
	}
	public void loadDefense(Defense def) {
		defends.add(def);
	}
	public ArrayList<Defense> getDefends() {
		return defends;
	}
	public void setDefends(ArrayList<Defense> defends) {
		this.defends = defends;
	}
	
}
