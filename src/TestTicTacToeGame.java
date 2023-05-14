import org.junit.*;

public class TestTicTacToeGame {
    TicTacToeGame game = new TicTacToeGame();

    @BeforeClass
    public static void setUp() {
      System.out.println("BeforeClass");
    }

    @AfterClass
    public static void tearDown() {
      System.out.println("AfterClass");
    }

    @Test
    public void testGame() {
      System.out.println("HELLO WORLD");
      int x = 5;
      Assert.assertEquals(5, x);

    }
}