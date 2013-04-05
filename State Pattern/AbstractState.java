

/**
 * @author: Lexi Christiansen
 * The base class for the different states.
 */
public abstract class AbstractState {

    /**
     * @author: Lexi Christiansen
     * Changes the state in GumballMachine.
     */
    protected static void changeState(GumballMachine g, AbstractState s)
    {
    	g.setState(s);
    }

    //===========================================================================================
    //=================== INTERFACE THAT EACH SUBCLASS-STATE IS TO OVERWRITE: ===================
    //===========================================================================================
    
    /**
     * @author: Lexi Christiansen
     * @post gumballs = gumballs + count
     */
    public abstract void addGumballs(GumballMachine g, int count);

    /**
     * @author: Lexi Christiansen
     * Updates the state to reflect the fact that there is a quarter.
     */
    public abstract void insertQuarter(GumballMachine g);

    /**
     * @author: Lexi Christiansen
     * Updates the state to reflect the fact that there is no quarter.
     */
    public abstract void removeQuarter(GumballMachine g);

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
    public abstract void turnHandle(GumballMachine g);

 

}