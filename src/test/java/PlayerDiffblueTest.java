import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.Ignore;
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

  /**
   * Method under test: {@link Player#move(Board)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testMove() {
    // TODO: Complete this test.
    //   Reason: R013 No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at Player.move(Player.java:22)
    //   In order to prevent move(Board)
    //   from throwing NullPointerException, add constructors or factory
    //   methods that make it easier to construct fully initialized objects used in
    //   move(Board).
    //   See https://diff.blue/R013 to resolve this issue.

    Player player = new Player('A');
    player.move(new Board(1, 1));
  }
}

