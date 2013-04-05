import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


public class CheckerboardTest extends TestCase {

	public static Test suite() {
		return new TestSuite(CheckerboardTest.class);
	}

	private Checkerboard board;
	
	public CheckerboardTest() {
		super();
	}

	public CheckerboardTest(String arg0) {
		super(arg0);
	}

	public void setUp() {
		board = Checkerboard.getSingleton();
	}
	
	public void tearDown() {
		return;
	}
	
	public void test() {
		assertEquals(board.getBlackPieces(), 10);
		assertEquals(board.getRedPieces(), 10);
		assertEquals(board.getGameIsOver(), false);
		
		//Test removeBlackPiece();
		for(int i = 0; i < 10; i++)
		{
			board.removeBlackPiece();
			assertEquals(board.getBlackPieces(), 9-i);
		}
		
		//Test getSingleton();
		Checkerboard sameBoard = Checkerboard.getSingleton();
		assertEquals(board.getBlackPieces(), sameBoard.getBlackPieces());
		assertEquals(board.getRedPieces(), sameBoard.getRedPieces());
		assertEquals(board.getGameIsOver(), sameBoard.getGameIsOver());
		
		
		//Test removeRedPiece();
		for(int i = 0; i < 10; i++)
		{
			board.removeRedPiece();
			assertEquals(board.getRedPieces(), 9-i);
		}
		
		//Test endGame();
		board.endGame();
		assertEquals(board.getGameIsOver(), true);
		
		//Test getSingleton();
		sameBoard = Checkerboard.getSingleton();
		assertEquals(board.getBlackPieces(), sameBoard.getBlackPieces());
		assertEquals(board.getRedPieces(), sameBoard.getRedPieces());
		assertEquals(board.getGameIsOver(), sameBoard.getGameIsOver());
	}
	
	public static void main(String[] args) {
		junit.textui.TestRunner.run(suite());
	}

}
