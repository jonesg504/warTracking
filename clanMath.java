package warTracking;

public class clanMath {
	public double warContribution(Clan clan, Player player) {
		int[] stats = clanStats(clan);
		double perc = player.getStars() / stats[1];
		return perc;
	}
	
	public static int[] clanStats(Clan clan) {
		int stars = 0;
		int plays = 0;
		for(Object play : clan) {
			plays++;
			stars += ((Player) play).getStars();
		}
		int[] returnVal = {plays, stars};
		return returnVal;
	}
	
}
