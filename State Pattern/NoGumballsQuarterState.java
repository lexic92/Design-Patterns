

public class NoGumballsQuarterState extends AbstractState {
	
	//=========================================================================
    //======================== SINGLETON PATTERN STUFF ========================
	//=========================================================================
	
	private static NoGumballsQuarterState instance;
	
	public static NoGumballsQuarterState Instance()
	{
		if(instance == null)
		{
			instance = new NoGumballsQuarterState();
		}
		return instance;
	}
	/**
	 * This constructor is private so ONLY THIS CLASS can construct itself:
	 * and that happens in the Instance() method.
	 */
	private NoGumballsQuarterState()
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
    	//Already has a quarter in it.
    }

    /**
     * @author: Lexi Christiansen
     * Updates the state to reflect the fact that there is no quarter.
     */
    public  void removeQuarter(GumballMachine g)
    {
    	changeState(g, NoGumballsNoQuarterState.Instance());
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
    	//I can't believe they want us to rip people off, but the spec said so...!!!!????
    	g.setMoney(g.getMoney() + 0.25f);
    	changeState(g, NoGumballsNoQuarterState.Instance());
    }

}
