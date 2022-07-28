
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class PlayerDiffblueTest {
  /**
  * Methods under test: 
  * 
  * <ul>
  *   <li>{@link Player#Player(char)}
  *   <li>{@link Player#toString()}
  * </ul>
  */
  @Test
  public void testConstructor() {
    // Arrange, Act and Assert
    assertEquals("A", (new Player('A')).toString());
  }

  /**
   * Method under test: {@link Player#setPosition(Square)}
   */
  @Test
  public void testSetPosition() {
    // Arrange
    Player player = new Player('A');
    Square square = new Square(1);

    // Act
    player.setPosition(square);

    // Assert
    assertEquals(1, square.getNumPlayer());
    assertSame(square, player.position);
  }
}

