import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.alexhoward.tictactoe.TicTacToeGame;

public class TestTicTacToeGame {
    TicTacToeGame game = new TicTacToeGame();

    @BeforeAll
    public static void setUp() {
      System.out.println("BeforeClass");
    }

    @AfterAll
    public static void tearDown() {
      System.out.println("AfterClass");
    }

    @Test
    public void testGame() {
      System.out.println("HELLO WORLD");
      int x = 5;
      assertEquals(5, x);

    }
}