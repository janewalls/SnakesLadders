//2598002w - Jane Walls - 2598002w@student.gla.ac.uk

public class Square {
	private int position;
	private Player[] playerPos = new Player[1];
	private int numPlayer;
	private int delta; // delta represents a snake or a ladder

	public Square(int pos) {
		delta = 0; 
		position = pos;
		numPlayer = 0;
	}
	
	public void setPosition(int p) {
		position = p;
	}
	public int getPosition() {
		return position;
	}
	
	public int getNumPlayer() {
		return numPlayer;
	}
	
	public void setDelta(int i) {
		delta = i;
	}
	
	public int getDelta() {
		return delta;
	}
	
	public void setPlayer(Player n) {
		for(int i= 0; i < playerPos.length; i++) { 
			if(playerPos[i] == null) { // checks for null spaces in Player array first
				playerPos[i] = n; // if null space in array - space is filled
				numPlayer++;
				return;
			}
		}
		if(numPlayer == playerPos.length) { // otherwise if array is full
			Player[] addPlayer = new Player[numPlayer+1]; //creates new, bigger array to fit new player
			for(int i= 0; i < playerPos.length; i++) {
				addPlayer[i] = playerPos[i]; 
			}
			playerPos = addPlayer; 
		}
		playerPos[numPlayer] = n; // adds a player to the end position
		numPlayer++; // corrects player count on square
	}
	
	public void takePlayer(Player n) {
		for(int i = 0; i < playerPos.length; i++) {
			if(playerPos[i] == n) { // finds player in array
				playerPos[i] = null; // removes player from player array on square
			}
		}
		numPlayer--; // corrects player count on square
	}
	
	public String toString() {
		String allPosPlayers = "";
		if(numPlayer > 0) { // if there are any players on the square 
			for(int i = 0; i < playerPos.length; i++) {
				if(playerPos[i] == null) {
					continue; } 
				else {
				allPosPlayers += playerPos[i].toString(); } // adds players to string
			}
		}
		String output = String.format("%1s", allPosPlayers) + String.format("%3d", position); // adds players and position at the start of string
		
		if(delta == 0) { // if there are no snakes or ladders 
			output += "(   )"; // requires empty space 
			return output; 
		}
		else {
			output += "(" + String.format("%3d", delta) + ")"; // add delta value in 3 character spaces
			return output;
		}
	}
}
	
	

