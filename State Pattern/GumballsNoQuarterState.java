

public class GumballsNoQuarterState extends AbstractState {
	
	//=========================================================================
    //======================== SINGLETON PATTERN STUFF ========================
	//=========================================================================
	
	private static GumballsNoQuarterState instance;
	
	public static GumballsNoQuarterState Instance()
	{
		if(instance == null)
		{
			instance = new GumballsNoQuarterState();
		}
		return instance;
	}
	/**
	 * This constructor is private so ONLY THIS CLASS can construct itself:
	 * and that happens in the Instance() method.
	 */
	private GumballsNoQuarterState()
	{
		//Intentionally empty
	}
	
	//=========================================================================
    //========================= IMPLEMENTED METHODS ===========================
	//=========================================================================
	
	/**
     * @author: Lexi Christiansen
     * @post gumballs = gumballs + count
     */
    public  void addGumballs(GumballMachine g, int count)
    {
    	g.setGumballCount(g.getGumballCount() + count);
    }

    /**
     * @author: Lexi Christiansen
     * Updates the state to reflect the fact that there is a quarter.
     */
    public  void insertQuarter(GumballMachine g)
    {
    	changeState(g, GumballsQuarterState.Instance());
    }

    /**
     * @author: Lexi Christiansen
     * Updates the state to reflect the fact that there is no quarter.
     */
    public  void removeQuarter(GumballMachine g)
    {
    	//Do nothing.
    }

    /**
     * @author: Lexi Christiansen
     * If gumballs == 1
     *  		--gumballs
     * 			money += .25
     * 			Goes to "NoGumballsNoQuarterState"
     * Else if gumballs > 1
     * 			--gumballs
     * 			money += .25
     */
    public  void turnHandle(GumballMachine g)
    {
    	//Do nothing.
    }

}
