/**
 * 
 * Carpet layers are contracted by the job and are paid by the job.
 * 
 * @author lexic92
 *
 */
public class CarpetLayer extends Job {
	/**
	 * The total amount that the customer will pay for the job 
	 * (before any deductions or taxes are taken out)
	 */
	double pay;
	/**
	 * Constructor
	 * 
	 * @param id the unique job id for the job.
	 * @param e the employee who is assigned this job.
	 */
	public CarpetLayer(int id, double pay, Employee e)
	{
		//Initialize everything with the given parameters.
		this.employee = e;
		this.id = id;
		this.pay = pay;
	}
	
	/**
	 * I don't know what this is meant to do, so I have it return the pay.
	 * It might be supposed to return the pay - the FICA.
	 */
	public double computePay()
	{
		return pay;
	}

	
	@Override
	/**
	 * The FICA for carpet laying is 7.65% on any amount for any person who earned 
	 * more than $100 laying carpet on a single job. (Thus, a person who earned $99
	 * on each of 3 carpet laying jobs would pay 0 dollars in FICA money, but a 
	 * person who earned $101 on one carpet laying job will pay $0.0765).
	 */
	public double computeFica() {
		return (pay > 100) ? (pay - 100) * FICA_RATE : 0;
	}
	

	
}
