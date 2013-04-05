
public class Cake {
	private int bitesLeft;
	protected GlobalObjectId globalObjectId;
	
	/**
	 * Constructor
	 */
	Cake(GlobalObjectId globalObjectId)
	{
		this.globalObjectId = globalObjectId;
		bitesLeft = 20;
	}
	/**
	 * Query operation
	 * @return
	 */
	public int bitesLeft()
	{
		return bitesLeft;
	}
	/**
	 * Domain-modifying operation
	 */
	public void takeBite()
	{
		bitesLeft--;
	}
	/**
	 * Get globalObjectId
	 */
	public GlobalObjectId getGlobalObjectId()
	{
		return globalObjectId;
	}
}
