

public class NoGumballsNoQuarterState extends AbstractState {

	//=========================================================================
    //======================== SINGLETON PATTERN STUFF ========================
	//=========================================================================
	
	private static NoGumballsNoQuarterState instance;
	
	public static NoGumballsNoQuarterState Instance()
	{
		if(instance == null)
		{
			instance = new NoGumballsNoQuarterState();
		}
		return instance;
	}
	
	/**
	 * This constructor is private so ONLY THIS CLASS can construct itself:
	 * and that happens in the Instance() method.
	 */
	private NoGumballsNoQuarterState()
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
    	changeState(g, GumballsNoQuarterState.Instance());
    }

    /**
     * @author: Lexi Christiansen
     * Updates the state to reflect the fact that there is a quarter.
     */
    public  void insertQuarter(GumballMachine g)
    {
    	changeState(g, NoGumballsQuarterState.Instance());
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
