

/**
 * @domain 
 * <pre>
 * totalPay : double - total pay for the week
 * totalFICA : double - total FICA for the week
 * name : String - name of employee
 * </pre>
 */
public class Employee {
	
	//=========================================================================================
	//============================== CLASS ATTRIBUTES =========================================
	//=========================================================================================
	
	/**
	 * How much money the employee has earned over the entire week from any job.
	 * (This is not their gross pay. It is 90% of all of their jobs' gross pay, since
	 * the temp agency gets %10.)
	 */
	double totalPay = 0;
	
	/**
	 * 
	 * 
	 * "The FICA for carpet laying is 7.65% on any amount for any person who earned more 
	 * than $100 laying carpet on a single job. (Thus, a person who earned $99 on each of
	 * 3 carpet laying jobs would pay 0 dollars in FICA money, but a person who earned 
	 * $101 on one carpet laying job will pay $0.0765). For floor refinishing jobs it 
	 * is 7.65% on any amount for any person who earned more than $50 for a floor refinishing
	 * job that week. (Similar to carpet layers, if a person had two floor refinishing jobs
	 * for the week where they earned $49 each, they would owe nothing for FICA, but if 
	 * they earned $51 on one job, they would owe $0.0765)."
	 * 
	 * The total amount of FICA money that the employee has accumulated over the week.
	 * I **assume** it is deducted from the sum of all the GROSS pay of every job of the week
	 * (carpeting or floor refinishing).
	 * (100% of the income of the jobs)
	 */
	//TODO FIGURE OUT IF FICA IS DEDUCTED from the gross pay (100%) or the employee's portion (90%).
	double totalFICA = 0;
	
	/**
	 * The name of the employee
	 */
	String name;
	
	//=========================================================================================
	//================================== METHODS ==== =========================================
	//=========================================================================================
	
	//================================= CONSTRUCTOR ============================================
	
	/**
	 * Public constructor.
	 */
	public Employee(String name) {
		this.name = name;
		
		//An employee starts out with 0 income/taxes because they start out having done 0 jobs.
		totalPay = 0;
		totalFICA = 0;
	}
	
	//====================================== GETTERS ==========================================
	
	/**
	 * Return total pay for the week.
	 * 
	 * @pre none
	 * @post result = totalPay
	 */
	public double getTotalPay() {
		return totalPay;
	}
	
	/**
	 * Return total FICA for the week.
	 * 
	 * @pre none
	 * @post result = totalFICA
	 */
	public double getTotalFICA() {
		return totalFICA;
	}
	
	/**
	 * Return name of employee.
	 * 
	 * @pre none
	 * @post result = name
	 */
	public String getName(){
		return name;
	}
	
	//================================= OTHER METHODS ==========================================
	
	public void addPay(double pay)
	{
		totalPay += pay;
	}
	public void addFica(double fica)
	{
		totalFICA += fica;
	}
	public void clearPayAndFica()
	{
		totalPay = 0;
		totalFICA = 0;
	}
}
