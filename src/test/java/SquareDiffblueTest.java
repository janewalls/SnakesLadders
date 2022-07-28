
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SquareDiffblueTest {
  /**
  * Methods under test: 
  * 
  * <ul>
  *   <li>{@link Square#Square(int)}
  *   <li>{@link Square#setDelta(int)}
  *   <li>{@link Square#setPosition(int)}
  *   <li>{@link Square#getDelta()}
  *   <li>{@link Square#getNumPlayer()}
  *   <li>{@link Square#getPosition()}
  * </ul>
  */
  @Test
  public void testConstructor() {
    // Arrange and Act
    Square actualSquare = new Square(1);
    actualSquare.setDelta(1);
    actualSquare.setPosition(1);

    // Assert
    assertEquals(1, actualSquare.getDelta());
    assertEquals(0, actualSquare.getNumPlayer());
    assertEquals(1, actualSquare.getPosition());
  }

  /**
   * Method under test: {@link Square#Square(int)}
   */
  @Test
  public void testConstructor2() {
    // Arrange and Act
    Square actualSquare = new Square(1);

    // Assert
    assertEquals(0, actualSquare.getDelta());
    assertEquals(1, actualSquare.getPosition());
    assertEquals(0, actualSquare.getNumPlayer());
  }

  /**
   * Method under test: {@link Square#setPlayer(Player)}
   */
  @Test
  public void testSetPlayer() {
    // Arrange
    Square square = new Square(1);

    // Act
    square.setPlayer(new Player('A'));

    // Assert
    assertEquals(1, square.getNumPlayer());
  }

  /**
   * Method under test: {@link Square#takePlayer(Player)}
   */
  @Test
  public void testTakePlayer() {
    // Arrange
    Square square = new Square(1);

    // Act
    square.takePlayer(new Player('A'));

    // Assert
    assertEquals(-1, square.getNumPlayer());
  }

  /**
   * Method under test: {@link Square#takePlayer(Player)}
   */
  @Test
  public void testTakePlayer2() {
    // Arrange
    Square square = new Square(1);

    // Act
    square.takePlayer(null);

    // Assert
    assertEquals(-1, square.getNumPlayer());
  }

  /**
   * Method under test: {@link Square#toString()}
   */
  @Test
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("   1(   )", (new Square(1)).toString());
  }

  /**
   * Method under test: {@link Square#toString()}
   */
  @Test
  public void testToString2() {
    // Arrange
    Square square = new Square(1);
    square.setDelta(1);

    // Act and Assert
    assertEquals("   1(  1)", square.toString());
  }
}

