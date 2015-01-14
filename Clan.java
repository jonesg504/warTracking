package warTracking;

import java.util.ArrayList;
import java.util.Iterator;

public class Clan implements Iterable{
	private ArrayList<Player> players = new ArrayList(50);
	public Clan(Player... players) {
		for(int i = 0; i < players.length; i++) {
			this.players.add(players[i]);
		}
	}
	public String toString() {
		String clanString = "";
		for (int i = 0; i < players.size(); i++) {
			clanString = clanString + players.get(i).toString();
			clanString += "  Worth: " + players.get(i).getWorth() + "\n";
		}
		return clanString;
	}
	public ArrayList<Player> getMembers() {
		return players;
	}
	public String printWar() {
		String warString = "";
		for (int i = 0; i < players.size(); i++) {
			warString = warString + players.get(i).toString();
			warString += "  Attacks Used: " + players.get(i).getAttackU() + "\n  Attacks Won: " + players.get(i).getAttackU() + "\n";
		}
		return warString;
	}
	public Player getPlayer(String name) {
		for(Player play : players) {
			if (play.getName().equals(name)) {
				return play;
			}
		}
		return null;
	}
	public Player remove(Player player) {
		for (int i = 0; i < players.size(); i++) {
			if (player.equals(players.get(i))) {
				players.remove(i);
				return player;
			}
		}
		
		return null;
	}
	public void add(Player player) {
		players.add(player);
	}
	
	@Override
	public Iterator iterator() {
		return new ClanIterator();
	}
	
	private class ClanIterator implements Iterator {
		int current = 0;
		
		public boolean hasNext() {
			return (current < players.size() && players.get(current) != null);
		}

		@Override
		public Player next() {
			Player returnVal = null;
			if(hasNext()) {
				returnVal = players.get(current);
				current++;
				return returnVal;
			} else {
				throw new java.util.NoSuchElementException("No next element");
			}
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException("Can't Remove");
			
		}
		
	}
}
