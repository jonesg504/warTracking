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
		}
		return clanString;
	}
	public Player getPlayer(Player player) {
		for(Player play : players) {
			if (play == player) {
				return play;
			}
		}
		return null;
	}
	public Player remove(Player player) {
		for (int i = 0; i < players.size(); i++) {
				return players.remove(i);
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
			return (current < 49 && players.get(current) != null);
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
