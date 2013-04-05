import java.lang.Exception;
import java.util.Iterator;

/**
 * Floor refinishers work by the hour and are paid $15 per hour. 
 * @author lexic92
 *
 */
public class FloorRefinisher extends Job {
	/**
	 * The money earned from this job
	 */
	private double pay;
	
	/**
	 * How many dollars earned per hour
	 */
	private static int HOURLY_WAGE = 15;
	
	/**
	 * Constructor
	 * 
	 * @param id the unique job id for the job.
	 * @param pay the amount that the customer will pay
	 * @param e the employee who is assigned this job.
	 */
	public FloorRefinisher(int id, Employee e)
	{
		//Initialize everything with the given parameters.
		this.employee = e;
		this.id = id;
	}
	/**
	 * I don't know what this is meant to do, so I have it return the pay.
	 * It might be supposed to return the pay - the FICA.
	 * @pre someone told this job how many hours it was.
	 */
	@Override
	public double computePay() {
		return pay;
	}
	/**
	 * Similar to carpet layers, if a person had two floor refinishing jobs for 
 	 * the week where they earned $49 each, they would owe nothing for FICA, but
 	 * if they earned $51 on one job, they would owe $0.0765). 
	 * @pre someone told this job how many hours it was.
	 * 
	 */
	@Override
	public double computeFica() {
		return (pay > 50) ? (pay - 50) * FICA_RATE : 0;
	}
	
	public void setHours(double hours)
	{
		pay = hours * HOURLY_WAGE;
	}
	
	
}
