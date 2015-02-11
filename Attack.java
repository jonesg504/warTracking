package warTracking;

public class Attack {
	private String player;
	private int stars;
	private int baseRank;
	private int thLevel;
	private int worth;
	private boolean star3;
	
	
	
	
	public Attack(String player, int stars, int baseRank, int thLevel) {
		this.player = player.toLowerCase();
		this.stars = stars;
		this.baseRank = baseRank;
		this.thLevel = thLevel;
	}



	public Attack() {
	}



	public String getPlayer() {
		return player;
	}
	public double calcWorth(int numPlayers, Player play) {
		if (stars == 0) {
			return 0;
		}
		if (play == null) {
			return 0;
		}
		double nop = numPlayers;
		double modifier = 1.3 + (((nop - baseRank)/nop) + (play.getRank() / baseRank)/4);
		modifier =  1 + Math.log10(modifier);
		double multiplier = (play.getRank() / nop);
		
		//multiplier += (nop * 2 - play.getRank() * 2)/(nop/2);
		multiplier = Math.log10(multiplier);
		multiplier += Math.log(stars);
		if (multiplier < 1) {
			multiplier = 1;
		}
		double worth = 1 + Math.log10((Math.pow(2, thLevel - play.getThLevel() )));
		if (play.getThLevel() == 8 && thLevel == 9) {
			worth = 1.1;
		}
		if (stars == 0) {
			worth = 0;
		}
		worth = worth * modifier * multiplier;
		
		worth = Math.round(worth * 100);
		if (star3) {
			worth*= 1.2;
		} else {
			if (stars == 2) {
				worth*= 1.1;
			}
		}
		return Math.round(worth);
	}

	public String toString() {
		return player + "(" + stars + ")\n";
	}
	public String attString() {
		return player;
	}
	public void setPlayer(String player) {
		this.player = player;
	}



	public int getBaseRank() {
		return baseRank;
	}



	public void setBaseRank(int baseRank) {
		this.baseRank = baseRank;
	}



	public int getThLevel() {
		return thLevel;
	}



	public void setThLevel(int thLevel) {
		this.thLevel = thLevel;
	}



	public int getStars() {
		return stars;
	}



	public void setStars(int stars) {
		this.stars = stars;
	}



	public int getWorth() {
		return worth;
	}



	public void setWorth(int worth) {
		this.worth = worth;
	}



	public boolean isStar3() {
		return star3;
	}



	public void setStar3(boolean star3) {
		this.star3 = star3;
	}
}
