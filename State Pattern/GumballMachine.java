

public class GumballMachine 
{

	private int gumballCount;
	private float money;
	private AbstractState state;
	
	
	//=========================================================================
	//======================= GETTERS/SETTERS/CTOR  ===========================
	//=========================================================================
	
	/**
	 * Constructor
	 */
	public GumballMachine() 
	{
		gumballCount = 0;
		money = 0.0f;
		state = NoGumballsNoQuarterState.Instance();
	}
	/**
	 * Get gumball count.
	 * @return gumballCount
	 */
	public int getGumballCount() 
	{
		return gumballCount;
	}
	/**
	 * Set gumball count.
	 * @param count
	 */
	public void setGumballCount(int gumballCount)
	{
		this.gumballCount = gumballCount;
	}
	/**
	 * Get money.
	 * @return money
	 */
	public float getMoney() 
	{
		return money;
	}
	/**
	 * Set money.
	 * @return money
	 */
	public void setMoney(float money) 
	{
		this.money = money;
	}
	

	//=========================================================================
    //======================== STATE PATTERN METHODS ==========================
	//=========================================================================
	// I have to pass in "this" as a parameter so it can call this class's 
	// setState method and update other data.
	
	public void addGumballs(int count) 
	{
		state.addGumballs(this, count);
	}
	
	public void insertQuarter() 
	{
		state.insertQuarter(this);
	}
	
	public void removeQuarter() 
	{
		state.removeQuarter(this);
	}
	
	public void turnHandle() 
	{
		state.turnHandle(this);
	}
	public void setState(AbstractState s)
	{
		state = s;
	}
}
