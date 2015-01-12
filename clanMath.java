package warTracking;

public class clanMath {
	public void warContribution(Clan clan, Player player) {
		
	}
	
	public static void clanStats(Clan clan) {
		for(Object play : clan) {
			System.out.println(play);
			
		}
	}
	public static void main(String[] args) {
		Player p1 = new Player("Griffin", 3);
		Player p2 = new Player("Jeffrey", 6);
		Player[] players = {p1, p2};
		Clan suns = new Clan(players);
		clanStats(suns);
	}
}
