package warTracking;

import java.util.Iterator;

public class Player{
	private String name;
	private int stars;
	public Player (String name, int stars) {
		this.name = name;
		this.stars = stars;
	}
	public Player (String name) {
		this.name = name;
		stars = 0;
	}
	public String getName() {
		return name;
	}
	public int getStars() {
		return stars;
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
	
	
}
