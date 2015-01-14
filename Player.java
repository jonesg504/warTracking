package warTracking;

public class Player{
	private String name;
	private int stars;
	private int thLevel;
	private double worth = 0;
	public Player (String name, int stars, int thLevel) {
		this.name = name;
		this.stars = stars;
		this.thLevel = thLevel;
	}
	public Player (String name, int thLevel) {
		this.name = name;
		stars = 0;
		this.thLevel = thLevel;
	}
	public Player (String name) {
		this.name = name;
		stars = 0;
		this.thLevel = thLevel;
	}
	public int getThLevel() {
		return thLevel;
	}
	public void setThLevel(int thLevel) {
		this.thLevel = thLevel;
	}
	public String getName() {
		return name;
	}
	public int getStars() {
		return stars;
	}
	public void addWorth(double num) {
		worth += num;
	}
	public void setStars(int stars) {
		this.stars = stars;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String toString() {
		return "Name: " + name + "\nStars: " + stars + "\n";
	}
	public boolean equals(Object other) {
		Player playa = (Player) other;
		if(this.name.equals(playa.name)) {
			return true;
		}
		
		
		return false;
	}
	
	
}
