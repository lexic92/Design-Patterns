

public class GumballsQuarterState extends AbstractState {
	
	//=========================================================================
    //======================== SINGLETON PATTERN STUFF ========================
	//=========================================================================
	
	private static GumballsQuarterState instance;
	
	public static GumballsQuarterState Instance()
	{
		if(instance == null)
		{
			instance = new GumballsQuarterState();
		}
		return instance;
	}
	/**
	 * This constructor is private so ONLY THIS CLASS can construct itself:
	 * and that happens in the Instance() method.
	 */
	private GumballsQuarterState()
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
    	//Do nothing.
    }

    /**
     * @author: Lexi Christiansen
     * Updates the state to reflect the fact that there is no quarter.
     */
    public  void removeQuarter(GumballMachine g)
    {
    	changeState(g, GumballsNoQuarterState.Instance());
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
    public void turnHandle(GumballMachine g)
    {
    	if(g.getGumballCount() == 1)
    	{
    		g.setGumballCount(0);
    		g.setMoney(g.getMoney() + .25f);
    		changeState(g, NoGumballsNoQuarterState.Instance());
    	}
    	else
    	{
    		g.setGumballCount(g.getGumballCount() - 1);
    		g.setMoney(g.getMoney() + .25f);
    		changeState(g, GumballsNoQuarterState.Instance());
    	}
    }
    
}
