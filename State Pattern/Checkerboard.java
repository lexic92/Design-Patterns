
public class Checkerboard 
{
	private int numberOfRedPieces;
	private int numberOfBlackPieces;
	private boolean gameIsOver;
	
	
	//=========================================================================
    //======================== SINGLETON PATTERN STUFF ========================
	//=========================================================================
	private static Checkerboard instance;
	
	public static Checkerboard getSingleton()
	{
		if(instance == null)
		{
			instance = new Checkerboard();
		}
		return instance;
	}
	/**
	 * This constructor is private so ONLY THIS CLASS can construct itself:
	 * and that happens in the Instance() method.
	 */
	private Checkerboard()
	{
		//I really don't know how many it's supposed to have... Oh well! Who cares, right??? :)
		numberOfRedPieces = 10;
		numberOfBlackPieces = 10;
		gameIsOver = false;
	}
	
	//=========================================================================
    //=============================== METHODS =================================
	//=========================================================================
	
	public void removeBlackPiece()
	{
		numberOfBlackPieces--;
	}
	
	public void removeRedPiece()
	{
		numberOfRedPieces--;
	}
	public void endGame()
	{
		gameIsOver = true;
	}
	
	//=========================================================================
    //=============================== GETTERS =================================
	//=========================================================================
	public int getBlackPieces()
	{
		return numberOfBlackPieces;
	}
	public int getRedPieces()
	{
		return numberOfRedPieces;
	}
	public boolean getGameIsOver()
	{
		return gameIsOver;
	}
	
}
