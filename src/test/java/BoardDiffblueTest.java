
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import org.junit.Test;

public class BoardDiffblueTest {
  /**
  * Methods under test: 
  * 
  * <ul>
  *   <li>{@link Board#Board(int, int)}
  *   <li>{@link Board#getColumn()}
  *   <li>{@link Board#getRow()}
  * </ul>
  */
  @Test
  public void testConstructor() {
    // Arrange and Act
    Board actualBoard = new Board(1, 1);

    // Assert
    assertEquals(1, actualBoard.getColumn());
    assertEquals(1, actualBoard.getRow());
  }

  /**
   * Method under test: {@link Board#Board(int, int)}
   */
  @Test
  public void testConstructor2() {
    // Arrange and Act
    Board actualBoard = new Board(1, 1);

    // Assert
    assertEquals(1, actualBoard.getColumn());
    assertEquals(0, actualBoard.playerCount);
    assertEquals(1, actualBoard.getRow());
  }

  /**
   * Method under test: {@link Board#Board(int, int)}
   */
  @Test
  public void testConstructor3() {
    // Arrange and Act
    Board actualBoard = new Board(2, 1);

    // Assert
    assertEquals(1, actualBoard.getColumn());
    assertEquals(0, actualBoard.playerCount);
    assertEquals(2, actualBoard.getRow());
  }

  /**
   * Method under test: {@link Board#Board(int, int)}
   */
  @Test
  public void testConstructor4() {
    // Arrange, Act and Assert
    assertThrows(NegativeArraySizeException.class, () -> new Board(-1, 1));

  }

  /**
   * Method under test: {@link Board#makeBoard()}
   */
  @Test
  public void testMakeBoard() {
    // Arrange
    HumanPlayer humanPlayer = mock(HumanPlayer.class);
    doNothing().when(humanPlayer).setPosition((Square) any());

    Board board = new Board(1, 1);
    board.addPlayer(humanPlayer);

    // Act
    board.makeBoard();

    // Assert
    verify(humanPlayer).setPosition((Square) any());
  }

  /**
   * Method under test: {@link Board#helperSqr(int)}
   */
  @Test
  public void testHelperSqr() {
    // Arrange
    HumanPlayer humanPlayer = mock(HumanPlayer.class);
    doNothing().when(humanPlayer).setPosition((Square) any());

    Board board = new Board(1, 1);
    board.addPlayer(humanPlayer);

    // Act
    board.helperSqr(1);

    // Assert
    verify(humanPlayer).setPosition((Square) any());
  }

  /**
   * Method under test: {@link Board#helperPos(int, int)}
   */
  @Test
  public void testHelperPos() {
    // Arrange, Act and Assert
    assertEquals(4, (new Board(3, 3)).helperPos(1, 1));
  }

  /**
   * Method under test: {@link Board#addPlayer(Player)}
   */
  @Test
  public void testAddPlayer() {
    // Arrange
    Board board = new Board(1, 1);
    Player player = new Player('A');

    // Act
    board.addPlayer(player);

    // Assert
    assertEquals(1, player.position.getNumPlayer());
    assertEquals(1, board.playerCount);
  }

  /**
   * Method under test: {@link Board#addPlayer(Player)}
   */
  @Test
  public void testAddPlayer2() {
    // Arrange
    Board board = new Board(2, 1);
    Player player = new Player('A');

    // Act
    board.addPlayer(player);

    // Assert
    assertEquals(1, player.position.getNumPlayer());
    assertEquals(1, board.playerCount);
  }

  /**
   * Method under test: {@link Board#addPlayer(Player)}
   */
  @Test
  public void testAddPlayer3() {
    // Arrange
    Board board = new Board(1, 1);
    board.addPlayer(new Player('\u0002'));
    Player player = new Player('A');

    // Act
    board.addPlayer(player);

    // Assert
    assertEquals(2, player.position.getNumPlayer());
    assertEquals(2, board.playerCount);
  }

  /**
   * Method under test: {@link Board#addPlayer(Player)}
   */
  @Test
  public void testAddPlayer4() {
    // Arrange
    Board board = new Board(1, 1);
    board.addPlayer(new Player('\u0002'));
    board.addPlayer(new Player('\u0002'));
    Player player = new Player('A');

    // Act
    board.addPlayer(player);

    // Assert
    assertEquals(3, player.position.getNumPlayer());
    assertEquals(3, board.playerCount);
  }

  /**
   * Method under test: {@link Board#takeTurns()}
   */
  @Test
  public void testTakeTurns() {
    // Arrange
    Board board = new Board(1, 1);
    board.addPlayer(new Player('A'));

    // Act and Assert
    assertTrue(board.takeTurns());
  }

  /**
   * Method under test: {@link Board#takeTurns()}
   */
  @Test
  public void testTakeTurns2() {
    // Arrange
    Board board = new Board(1, 1);
    board.addPlayer(new Player('\u0001'));
    board.addPlayer(new Player('A'));

    // Act and Assert
    assertTrue(board.takeTurns());
  }

  /**
   * Method under test: {@link Board#takeTurns()}
   */
  @Test
  public void testTakeTurns3() {
    // Arrange
    Board board = new Board(1, 2);
    board.addPlayer(new Player('A'));

    // Act and Assert
    assertTrue(board.takeTurns());
  }

  /**
   * Method under test: {@link Board#toString()}
   */
  @Test
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("    0(   )\n", (new Board(1, 1)).toString());
  }
}

