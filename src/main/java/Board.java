//2598002w - Jane Walls - 2598002w@student.gla.ac.uk

public class Board {
	private int row;
	private int column;
	int playerCount = 0;
	private Player[] allPlayers = new Player[2];
	private Square[][] board;
	
	public Board(int r, int c) { // can choose board size
		row = r;
		column = c;
		board = new Square[r][c];
		makeBoard(); // creates board with Squares, and wrapping positions
	}
	
	
	public void makeBoard() {
		int pos = (row*column); // used for setting position and finds biggest square 
		int x = 0; // will be 0 or 1
		pos +=column; 
		for(int r = 0; r < board.length; r++) {
			if(x == 0) {
				pos -=column + 1; // row positions counts down
				for(int c = 0; c < board[r].length; c++) {
					board[r][c] = new Square(pos--); // creates square and sets position to board array coordinate
				}
			}
			else {
				pos -= column - 1; // row positions counts up
				for(int c = 0; c < board[r].length; c++) {
					board[r][c] = new Square(pos++); // creates square and sets position to board array coordinate
				}
			}
		x = 1 - x; // switch between counting up and counting down for wrapping
		}
	}
	
	public Square getBoard(int r, int c) {
		return board[r][c];
	}
	
	public int getRow() {
		return row;
	}
	
	public int getColumn() {
		return column;
	}

	
	public Square helperSqr(int pos) { // finds a positions coordinate on board array
		for(int r = 0; r < board.length; r++) {
			for(int c = 0; c < board[r].length; c++) {
				if(board[r][c].getPosition() == pos) { // finds position coordinate in array
					return board[r][c];
				}
			}
		}
		return board[0][0]; // if no position found, returns last square
	}
	

	
	public int helperPos(int findRow, int findCol) { // enter coordinates
		return board[findRow][findCol].getPosition(); // get square position number returned
	}
		
	
	public void addPlayer(Player p) {
		if(playerCount == allPlayers.length) { // if player array is full 
			Player[] morePlayers = new Player[playerCount+1]; // creates bigger array
			for(int i= 0; i < allPlayers.length; i++) {
				morePlayers[i] = allPlayers[i]; 
			}
			allPlayers = morePlayers;
		}
		allPlayers[playerCount++] = p; // adds player to array, then corrects total number of players
		p.setPosition(this.helperSqr(0)); // put player at start of the board
	}
	
	public boolean takeTurns() {
		boolean inGame = false;
		int turnCount = 0;
		while(!inGame) { // loop will continue until someone has won
			System.out.println("Player " + allPlayers[turnCount].toString() + "'s turn:");
			inGame = allPlayers[turnCount].move(this);
			System.out.println(this); // prints board after player has moved
			if(inGame == true) { // if move method returns true - i.e. some reaches final square
				System.out.println("Hooray!!!!\nPlayer " + allPlayers[turnCount] + " won!");
				return true;
			}
			else {
				if(turnCount == (allPlayers.length - 1)) { // if all players have had a go
					turnCount = 0; // returns back to first player in loop
				}
				else { // goes to next player
				turnCount++; 
				}
			}
		}
		return false;	
	}
	
	
	public String toString() {
		String output = "";
		int sqSize = 1; 
		for(int r = 0; r < board.length; r++) {
			for(int c = 0; c < board[r].length; c++) {
				if(board[r][c].getNumPlayer() > sqSize) {
					sqSize = board[r][c].getNumPlayer(); // finds out square with most number of players
				}
			}
		}
		String format = ("%" + sqSize + "s"); // allows to adjust board for the number of players on a particular square 
		for(int r = 0; r < board.length; r++) {
			for(int c = 0; c < board[r].length; c++) {
				if(board[r][c].getNumPlayer() == sqSize) { // square with the highest number of players
					output +=  " " + board[r][c].toString(); // prints players
				}
				else {
					output += String.format(format, "") + board[r][c].toString(); // adds in appropriate players/spaces and square
				}
			}
		output += "\n"; 
		}
		return output;
	}
	
	
	public static void main(String[] args) {
		Board game = new Board(10,5);
		System.out.println(game);
		Player playerJ = new Player('J'); // create players
		Player playerA = new Player('A');
		Player playerB = new Player('B');
		game.addPlayer(playerJ); // add players to board
		game.addPlayer(playerB);
		game.addPlayer(playerA);
		System.out.println(game);
	}
	
	
	
	
	
	/* --- Replaced by helperSqr method ---
	 
	public int helperRow(int find) {
		int output = 0;
		for(int r = 0; r < board.length; r++) {
			for(int c = 0; c < board[r].length; c++) {
				if(board[r][c].getPosition() == find) {
				output = r;
				}
			}
		}
		return output;
	}
	
	public int helperCol(int find) {
		int output = 0;
		for(int r = 0; r < board.length; r++) {
			for(int c = 0; c < board[r].length; c++) {
				if(board[r][c].getPosition() == find) {
				output = c;
				}
			}
		}
		return output;
	}
	*/
}
