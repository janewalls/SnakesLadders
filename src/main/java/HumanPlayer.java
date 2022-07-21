//2598002w - Jane Walls - 2598002w@student.gla.ac.uk

import java.util.Scanner;

public class HumanPlayer extends Player{
	
	public HumanPlayer(char name) {
		super(name);
		}
	
	public boolean move(Board p) {
		Scanner s = new Scanner(System.in); // creates scanner for user input
		System.out.println("Please enter a number between 1 and 6");
		int count = s.nextInt();  // take number from input
		while(count > 6 || count < 1) { // To stop people from cheating and choosing a number not on a die
			System.out.println("The number has to be between 1 and 6\nPlease try again:");
			count = s.nextInt();
		}
		position.takePlayer(this); // here and below same move method from Player class
		System.out.println("You rolled a " + count);
		int newPos = count + position.getPosition(); // find new position number
		int delta = p.helperSqr(newPos).getDelta(); // get the delta (snake or ladder value) for the new position
		newPos += delta; // finds new position
		this.setPosition(p.helperSqr(newPos)); // places player on new square
		if(position.getPosition() == p.helperPos(0,0)) { // if someone wins return true, last square will be 0,0 position on array
			return true;
		}
		else {
			return false;
		}
	}
}
