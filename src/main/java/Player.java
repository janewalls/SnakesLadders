//2598002w - Jane Walls - 2598002w@student.gla.ac.uk

import java.util.Random;

public class Player {
	protected char name;
	protected Square position;
	
	public Player(char n) {
		name = n;
	}
	
	public void setPosition(Square p) {
		position = p;
		p.setPlayer(this); // allows to add the player reference to the square
	}
	
	
	public boolean move(Board p) {
		Random r = new Random();
		int count = r.nextInt(6) +1; // number between 1 and 6
		position.takePlayer(this); // take player off current square
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
	
	public String toString() {
		return "" + name; // returns player char
	}
	
	public static void main(String[] args) { // Play here to only run on the with both computer players
		Player playerJ = new Player('J'); // creates players
		Player playerA = new Player('A');
		Square sqrOne = new Square(1); // creates square
		playerJ.setPosition(sqrOne); // adds players to square
		playerA.setPosition(sqrOne);
		
		System.out.println(playerJ);
		System.out.println(sqrOne);
		
	}
}
