

abstract public class Job {
	/**
	 * A unique job id
	 */
	protected int id;
	
	public static final double FICA_RATE = 0.0765;
	
	protected Employee employee;
	
	/**
	 * Method should be overloaded by subclasses.
	 * @throws Exception 
	 */
	public abstract double computePay();
	
	/**
	 * Method should be overloaded by subclasses.
	 * @throws Exception 
	 */
	public abstract double computeFica();

	
	public int getId()
	{
		return id;
	}
	public Employee getEmployee()
	{
		return employee;
	}
}
