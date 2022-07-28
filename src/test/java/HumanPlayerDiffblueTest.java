
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class HumanPlayerDiffblueTest {
  /**
  * Method under test: {@link HumanPlayer#HumanPlayer(char)}
  */
  @Test
  public void testConstructor() {
    // Arrange and Act
    HumanPlayer actualHumanPlayer = new HumanPlayer('A');

    // Assert
    assertEquals('A', actualHumanPlayer.name);
    assertNull(actualHumanPlayer.position);
  }
}

