import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.alexhoward.tictactoe.TicTacToeGame;

public class TestTicTacToeGame {
  private TicTacToeGame game;

  @BeforeEach
  public void setUp() {
    game = new TicTacToeGame();
  }

    @Test
    public void testGameCreation() {
      assertEquals(1, game.getCurrentPlayer());
      assertEquals(0, game.getGameGrid()[0][0]);
      assertEquals(0, game.getGameGrid()[1][1]);
      assertEquals(0, game.getGameGrid()[2][2]);
      assertEquals(false, game.getGameOver());
      assertEquals(-1, game.getWinner());
      assertEquals(null, game.getLastWinningLine());
    }

    @Test
    public void testMakeMove() {
      game.makeMove(0, 0);
      assertEquals(2, game.getCurrentPlayer());
      assertEquals(1, game.getGameGrid()[0][0]);
      assertEquals(0, game.getGameGrid()[1][1]);
      assertEquals(0, game.getGameGrid()[2][2]);
      assertEquals(false, game.getGameOver());
      assertEquals(-1, game.getWinner());
      assertEquals(null, game.getLastWinningLine());
    }

    @Test
    public void testHorizontalWinRow1() {
      // Winning line should be [0, 0] [0, 1] [0, 2]

      game.makeMove(0, 0);
      game.makeMove(1, 0);
      game.makeMove(0, 1);
      game.makeMove(1, 1);
      game.makeMove(0, 2);

      assertEquals(1, game.getWinner());
      assertEquals(true, game.getGameOver());
      assertEquals(0, game.getLastWinningLine().get(0)[0]);
      assertEquals(0, game.getLastWinningLine().get(0)[1]);
      assertEquals(0, game.getLastWinningLine().get(1)[0]);
      assertEquals(1, game.getLastWinningLine().get(1)[1]);
      assertEquals(0, game.getLastWinningLine().get(2)[0]);
      assertEquals(2, game.getLastWinningLine().get(2)[1]);
    }

    @Test
    public void testHorizontalWinRow2() {
      // Winning line should be [1, 0] [1, 1] [1, 2]

      game.makeMove(1, 0);
      game.makeMove(0, 0);
      game.makeMove(1, 1);
      game.makeMove(0, 1);
      game.makeMove(1, 2);
      
      assertEquals(1, game.getWinner());
      assertEquals(true, game.getGameOver());
      assertEquals(1, game.getLastWinningLine().get(0)[0]);
      assertEquals(0, game.getLastWinningLine().get(0)[1]);
      assertEquals(1, game.getLastWinningLine().get(1)[0]);
      assertEquals(1, game.getLastWinningLine().get(1)[1]);
      assertEquals(1, game.getLastWinningLine().get(2)[0]);
      assertEquals(2, game.getLastWinningLine().get(2)[1]);
    }

    @Test
    public void testHorizontalWinRow3() {
      // Winning line should be [2, 0] [2, 1] [2, 2]

      game.makeMove(0, 0);
      game.makeMove(2, 0);
      game.makeMove(0, 1);
      game.makeMove(2, 1);
      game.makeMove(1, 2);
      game.makeMove(2, 2);

      assertEquals(2, game.getWinner());
      assertEquals(true, game.getGameOver());
      assertEquals(2, game.getLastWinningLine().get(0)[0]);
      assertEquals(0, game.getLastWinningLine().get(0)[1]);
      assertEquals(2, game.getLastWinningLine().get(1)[0]);
      assertEquals(1, game.getLastWinningLine().get(1)[1]);
      assertEquals(2, game.getLastWinningLine().get(2)[0]);
      assertEquals(2, game.getLastWinningLine().get(2)[1]);
    }
      
    @Test
    public void testVerticalWinCol1() {
      // Winning line should be [0,0] [1, 0] [2, 0]
      game.makeMove(0, 0);
      game.makeMove(0, 1);
      game.makeMove(1, 0);
      game.makeMove(0, 2);
      game.makeMove(2, 0);

      assertEquals(1, game.getWinner());
      assertEquals(true, game.getGameOver());
      assertEquals(0, game.getLastWinningLine().get(0)[0]);
      assertEquals(0, game.getLastWinningLine().get(0)[1]);
      assertEquals(1, game.getLastWinningLine().get(1)[0]);
      assertEquals(0, game.getLastWinningLine().get(1)[1]);
      assertEquals(2, game.getLastWinningLine().get(2)[0]);
      assertEquals(0, game.getLastWinningLine().get(2)[1]);

    }

    @Test
    public void testVerticalWinCol2() {
      // Winning line should be [0,1] [1, 1] [2, 1]
      game.makeMove(0, 1);
      game.makeMove(0, 0);
      game.makeMove(1, 1);
      game.makeMove(0, 2);
      game.makeMove(2, 1);

      assertEquals(1, game.getWinner());
      assertEquals(true, game.getGameOver());
      assertEquals(0, game.getLastWinningLine().get(0)[0]);
      assertEquals(1, game.getLastWinningLine().get(0)[1]);
      assertEquals(1, game.getLastWinningLine().get(1)[0]);
      assertEquals(1, game.getLastWinningLine().get(1)[1]);
      assertEquals(2, game.getLastWinningLine().get(2)[0]);
      assertEquals(1, game.getLastWinningLine().get(2)[1]);
      
    }

    @Test
    public void testVerticalWinCol3() {
      // Winning line should be [0,2] [1, 2] [2, 2]
      game.makeMove(0, 2);
      game.makeMove(0, 0);
      game.makeMove(1, 2);
      game.makeMove(0, 1);
      game.makeMove(2, 2);

      assertEquals(1, game.getWinner());
      assertEquals(true, game.getGameOver());
      assertEquals(0, game.getLastWinningLine().get(0)[0]);
      assertEquals(2, game.getLastWinningLine().get(0)[1]);
      assertEquals(1, game.getLastWinningLine().get(1)[0]);
      assertEquals(2, game.getLastWinningLine().get(1)[1]);
      assertEquals(2, game.getLastWinningLine().get(2)[0]);
      assertEquals(2, game.getLastWinningLine().get(2)[1]);

    }

    @Test
    public void testLeftDiagonalWin() {
      // Winning line should be [0,0] [1, 1] [2, 2]
      game.makeMove(0, 0);
      game.makeMove(0, 1);
      game.makeMove(1, 1);
      game.makeMove(0, 2);
      game.makeMove(2, 2);

      assertEquals(1, game.getWinner());
      assertEquals(true, game.getGameOver());
      assertEquals(0, game.getLastWinningLine().get(0)[0]);
      assertEquals(0, game.getLastWinningLine().get(0)[1]);
      assertEquals(1, game.getLastWinningLine().get(1)[0]);
      assertEquals(1, game.getLastWinningLine().get(1)[1]);
      assertEquals(2, game.getLastWinningLine().get(2)[0]);
      assertEquals(2, game.getLastWinningLine().get(2)[1]);
    }

    @Test
    public void testRightDiagonalWin() {
      // Winning line should be [0,2] [1, 1] [2, 0]
      game.makeMove(0, 2);
      game.makeMove(0, 1);
      game.makeMove(1, 1);
      game.makeMove(0, 0);
      game.makeMove(2, 0);

      assertEquals(1, game.getWinner());
      assertEquals(true, game.getGameOver());
      assertEquals(0, game.getLastWinningLine().get(0)[0]);
      assertEquals(2, game.getLastWinningLine().get(0)[1]);
      assertEquals(1, game.getLastWinningLine().get(1)[0]);
      assertEquals(1, game.getLastWinningLine().get(1)[1]);
      assertEquals(2, game.getLastWinningLine().get(2)[0]);
      assertEquals(0, game.getLastWinningLine().get(2)[1]);
    }
  
    @Test
    public void testTie() {
      // Winning line should be null
      game.makeMove(0, 0);
      game.makeMove(0, 1);
      game.makeMove(0, 2);
      game.makeMove(1, 0);
      game.makeMove(1, 2);
      game.makeMove(1, 1);
      game.makeMove(2, 0);
      game.makeMove(2, 2);
      game.makeMove(2, 1);

      assertEquals(0, game.getWinner());
      assertEquals(true, game.getGameOver());
      assertEquals(null, game.getLastWinningLine());
    }
  
    @Test
    public void testChangePlayer() {
      assertEquals(1, game.getCurrentPlayer());
      game.makeMove(0, 0);
      assertEquals(2, game.getCurrentPlayer());
      game.makeMove(0, 1);
      assertEquals(1, game.getCurrentPlayer());

    }
  
}