package warTracking;

import java.util.Iterator;

public class Clan implements Iterable{
	private Player[] players = new Player[50];
	public Clan(Player[] players) {
		for(int i = 0; i < players.length; i++) {
			this.players[i] = players[i];
		}
	}
	public String toString() {
		String clanString = "";
		for (int i = 0; i < players.length; i++) {
			clanString = clanString + players[i].toString();
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
	
	@Override
	public Iterator iterator() {
		return new ClanIterator();
	}
	
	private class ClanIterator implements Iterator {
		int current = 0;
		
		public boolean hasNext() {
			return (current < 49 && players[current] != null);
		}

		@Override
		public Player next() {
			Player returnVal = null;
			if(hasNext()) {
				returnVal = players[current];
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
