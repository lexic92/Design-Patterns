import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;



/**
 * @domain 
 * <pre>
 * employees : Collection of Employee
 * currentJobs : Collection of Job - current jobs of employees
 * finishedJobs : Collection of Job - weekly finished jobs of employees
 * weeklyPay : double - total weekly pay due to employees
 * weeklyProfit : double - total weekly profit of agency
 * </pre>
 */

public class TempAgency  {
	
	//=========================================================================================
	//============================== CLASS ATTRIBUTES =========================================
	//=========================================================================================
	
	/**
	 * Jobs that are currently assigned to employees.
	 */
	private ArrayList<Job> currentJobs;
	
	/**
	 * Weekly jobs that employees have finished.
	 */
	//I chose an arrayList implementation because it makes more sense conceptually, since it isn't going
	//to have anything "removed" from it (like a queue normally would).
	private ArrayList<Job> finishedJobs;
	
	/**
	 * List of employees of the temp agency.
	 */
	private Queue<Employee> employees;
	
	/**
	 * total weekly pay that is owed to employees (the 90%)
	 */
	private double weeklyPay;
	
	/**
	 * Total weekly profit of agency (the 10%)
	 */
	private double weeklyProfit;
	
	

	//=========================================================================================
	//=================================== METHODS =============================================
	//=========================================================================================
	
	//================================= CONSTRUCTOR ===========================================
	
	
	/**
	 * Public constructor.
	 */
	public TempAgency() {
		//These start out empty when the agency is barely founded and up and running.
		//Likewise, amount of money = 0 for same reason.
		currentJobs = new ArrayList<Job>();
		finishedJobs = new ArrayList<Job>();
		employees = new LinkedList<Employee>();
		weeklyPay = 0;
		weeklyProfit = 0;
	}
	
	//====================================== GETTERS/ADD/REMOVE ==========================================
	
	/**
	 * Return weekly pay of employees.
	 * 
	 * @pre none
	 * @post result = weeklyPay
	 */
	public double getWeeklyEmployeePay() {
		return weeklyPay;
	}
	
	/**
	 * Return weekly profit of agency.
	 * 
	 * @pre none
	 * @post result = weeklyProfit
	 */
	public double getWeeklyProfit() {
		return weeklyProfit;
	}
	
	/**
	 * Add an Employee instance to employees.
	 * 
	 * @param employee, Employee
	 * @pre none
	 * @post employees' = employees + employee
	 */
	public void addEmployee(Employee employee) {
		employees.add(employee);
	}
	
	/**
	 * Remove the given Employee instance from employees.
	 * 
	 * @param employee, Employee
	 * @pre none
	 * @post employees' = employees - employee
	 */
	public void removeEmployee(Employee employee) {
		employees.remove(employee);
	}
	
	
	//====================================== ASSIGN JOBS ==========================================
	
	/**
	 * Request an employee and assign them to work a CarpetLayer job.
	 * 
	 * @param jobId, int : id for CarpetLayer job
	 * @param jobPay, double : pay amount for CarpetLayer job
	 * 
	 * @pre none
	 * @post CarpetLayer job is created and assigned next available employee
	 * @post CarpetLayer.id = jobId
	 * @post CarpetLayer.pay = jobPay
	 * @post currentJobs' = currentJobs + new CarpetLayer job
	 */
	public void assignCarpetLayerJob(int jobId, double jobPay) {
		//Get the first employee from the queue of employees.
		Employee employee = employees.remove();
		
		//Create a carpet layer job using that employee, and add it to the list of current jobs.
		CarpetLayer c = new CarpetLayer(jobId, jobPay, employee);
		currentJobs.add(c);
		
		
		//Add that employee to the back of the list of employees
		employees.add(employee);
		
		
	}
	
	/**
	 * Request an employee and assign them to work a WoodFloorRefinisher job.
	 * 
	 * @param jobId, int : id for WoodFloorRefinisher job
	 * 
	 * @pre none
	 * @post WoodFloorRefinisher job is created and assigned next available employee
	 * @post WoodFloorRefinisher.id = jobId
	 * @post currentJobs' = currentJobs + new WoodFloorRefinisher job
	 */
	public void assignWoodFloorRefinisherJob(int jobId) {
		//Get the first employee from the queue of employees.
		Employee employee = employees.remove();
		
		//Create a floor refinisher job using that employee, and add it to the list of current jobs.
		FloorRefinisher f = new FloorRefinisher(jobId, employee);
		currentJobs.add(f);
		
		//Add that employee to the back of the list of employees
		employees.add(employee);
	}
	
	
	
	
	/**
	 * Remove the corresponding CarpetLayer job from currentJobs and add it to finishedJobs.
	 * 
	 * @param jobId, int : id of CarpetLayer job finished
	 * 
	 * @pre none
	 * @post currentJobs' = currentJobs - CarpetLayerJob w/ jobId
	 * @post finishedJobs' = finishedJobs + CarpetLayerJob w/ jobId
	 */
	public void clockOutCarpetLayerJob(int jobId) {
		Job j = null;
		
		//Find the job with that jobId
		for(Job job : currentJobs)
		{
			if(job.getId() == jobId)
			{
				j = job;
			}
		}
		if(j != null)
		{
			currentJobs.remove(j);
			finishedJobs.add(j);
			weeklyPay += (j.computePay()) * .9;
			weeklyProfit += (j.computePay()) * .1;
			j.getEmployee().addPay(j.computePay() * .9);
			j.getEmployee().addFica(j.computeFica());
		}
	}
	
	/**
	 * Remove the corresponding WoodFloorRefinisher job from currentJobs and add it to finishedJobs.
	 * 
	 * @param jobId, int : id of WoodFloorRefinisher job finished
	 * 
	 * 
	 * @pre none
	 * @post currentJobs' = currentJobs - WoodFloorRefinisher w/ jobId
	 * @post finishedJobs' = finishedJobs + WoodFloorRefinisher w/ jobId
	 */
	public void clockOutFloorRefinisherJob(int jobId, double hours) {
		Job j = null;
		
		//Remove it from the jobs list
		for(Job job : currentJobs)
		{
			if(job.getId() == jobId)
			{
				j = job;
			}
		}
		if(j != null)
		{
			currentJobs.remove(j);
			((FloorRefinisher)j).setHours(hours);
			finishedJobs.add(j);
			weeklyPay += j.computePay() * .9;
			weeklyProfit += j.computePay() * .1;
			j.getEmployee().addPay(j.computePay() * .9);
			j.getEmployee().addFica(j.computeFica());
		}
	}
	
	/**
	 * Remove all jobs from finishedJobs.
	 * 
	 * @pre none
	 * @post finishedJobs' = empty collection
	 * @post for every employee in employees: totalPay = 0 && totalFICA = 0
	 * @post pay = 0
	 * @post profit = 0
	 */
	public void endWeek() {
		for(Employee e : employees)
		{
			e.clearPayAndFica();
		}
		weeklyPay = 0;
		weeklyProfit = 0;
		finishedJobs.clear();
	}

	
	//=========================================================================================
	//=============================== TEMPLATE METHOD PATTERN =================================
	//=========================================================================================
	
	/**
	 * Compute the total pay for employees of the agency.
	 * 
	 * @pre none
	 * @post pay = 90% of the sum of the pay for all finished jobs
	 * @post profit = 10% of the sum of the pay for all finished jobs
	 * @post result = the sum of the pay for all finished jobs
	 */
	public double computeTotalProfitAndPay() {
		
		//Anonymous Inner Class
		double totalMoney = new PerformAppropriateOperationOnAppropriateObject ()
		{
			@Override
			public Iterator<Job> getIterator() {
				return finishedJobs.iterator();
			}

			@Override
			public double getAmount(Job j) {
				return j.computePay(); //<<<----------- THE ONLY DIFFERENCE
			}
		}.execute();
		
		weeklyPay = totalMoney * .9;
		weeklyProfit = totalMoney * .1;
		return totalMoney;
	}
	
	/**
	 * Compute the total FICA for employees of the agency.
	 * 
	 * @pre none
	 * @post result = sum of the FICA for all finished jobs
	 */
	public double computeTotalFICA() {
		//Anonymous Inner Class
		return new PerformAppropriateOperationOnAppropriateObject ()
		{
			@Override
			public Iterator<Job> getIterator() {
				return finishedJobs.iterator();
			}

			@Override
			public double getAmount(Job j) {
				return j.computeFica(); //<<<----------- THE ONLY DIFFERENCE
			}
		}.execute();
		
		
	}
	
	

}
