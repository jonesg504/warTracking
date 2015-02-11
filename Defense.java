package warTracking;

public class Defense {
	private String player;
	private int stars;
	private int thLevel;
	public Defense(String player, int stars, int thLevel) {
		this.setPlayer(player);
		this.setStars(stars);
		this.thLevel = thLevel;
	}
	public Defense() {
		// TODO Auto-generated constructor stub
	}
	public double calcWorth(int numPlayers, Player play) {
		stars = 3 - stars;
		double multiplier = Math.pow(2, stars);
		double worth = Math.pow(2, thLevel - play.getThLevel()) * multiplier;
		worth = Math.round(worth * 10);
		return worth/3;
	}
	public String getPlayer() {
		return player;
	}
	public void setPlayer(String player) {
		this.player = player;
	}
	public int getStars() {
		return stars;
	}
	public void setStars(int stars) {
		this.stars = stars;
	}
	public int getThLevel() {
		return thLevel;
	}
	public String toString() {
		return player + "(" + stars + ")\n";
	}
	public void setThLevel(int thLevel) {
		this.thLevel = thLevel;
	}
}
