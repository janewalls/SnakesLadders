//2598002w - Jane Walls - 2598002w@student.gla.ac.uk

public class Play {
	public static void main(String[] args) {
		// Creates board
		Board gameOne = new Board(10,10);
		// Adds ladders to board
		gameOne.getBoard(2,3).setDelta(4);
		gameOne.getBoard(8,0).setDelta(8);
		gameOne.getBoard(4,1).setDelta(9);
		// Adds snakes to board
		gameOne.getBoard(7,2).setDelta(-4);
		gameOne.getBoard(0,4).setDelta(-7);
		gameOne.getBoard(5,1).setDelta(-10);
		// Creates Players
		Player playerJ = new Player('J');
		HumanPlayer playerA = new HumanPlayer('A');
		Player playerB = new Player('B');
		// Adds players to the board
		gameOne.addPlayer(playerJ);
		gameOne.addPlayer(playerA);
		gameOne.addPlayer(playerB);
		System.out.println("Are you ready\nLets start the game!");
		System.out.println(gameOne);
		// Starts game
		gameOne.takeTurns(); 
		
		System.out.println(); // separates games

		// Second game, adding snakes and ladders
		Board gameTwo = new Board(10,10);
		gameTwo.getBoard(9,8).setDelta(12);
		gameTwo.getBoard(8,0).setDelta(8);
		gameTwo.getBoard(4,9).setDelta(16);
		gameTwo.getBoard(7,7).setDelta(-9);
		gameTwo.getBoard(0,8).setDelta(-15);
		gameTwo.getBoard(5,1).setDelta(-10);
		// Adding players
		Player playerT = new Player('T');
		HumanPlayer playerS = new HumanPlayer('S');
		gameTwo.addPlayer(playerT);
		gameTwo.addPlayer(playerS);
		System.out.println(gameTwo);
		gameTwo.takeTurns();

	
	}
}
