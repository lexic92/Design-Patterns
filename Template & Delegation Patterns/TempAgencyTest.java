
import org.junit.Test;
import static org.junit.Assert.*;

public class TempAgencyTest {
	
	@Test
	public void basicTest() {
		
		TempAgency agency = new TempAgency();
		Employee employee1 = new Employee("Bob");
		Employee employee2 = new Employee("Joe");
		Employee employee3 = new Employee("Jill");
		Employee employee4 = new Employee("Tim");
		
		agency.addEmployee(employee1);
		agency.addEmployee(employee2);
		agency.addEmployee(employee3);
		agency.addEmployee(employee4);
		
		agency.assignCarpetLayerJob(0, 25);
		agency.assignWoodFloorRefinisherJob(1); 
		agency.assignCarpetLayerJob(2, 100);
		agency.assignCarpetLayerJob(3, 101);
		
		//This will either loop to employee 1, or else no one will get the job, I'm not sure which.
		agency.assignCarpetLayerJob(4, 25);
		agency.assignWoodFloorRefinisherJob(5); 
		
		agency.clockOutCarpetLayerJob(0);
		agency.clockOutFloorRefinisherJob(1, 6);
		agency.clockOutCarpetLayerJob(2);
		agency.clockOutCarpetLayerJob(3);
		
		//Either employee 1 got this before he/she was done with the first job, or no one got it. I'm not sure which.
		agency.clockOutCarpetLayerJob(4);
		
		
		
		
		//25 + (15 * 6 hours = 90) + 100 + 101 + 25    =  341
		assertTrue(agency.computeTotalProfitAndPay() == 341);
		
		// 90-50 = 40, 40 * .0765 = 3.06
		// 101-100 = 1, 1 * .0765 =  .0765
		//  3.06 + .0765  = 3.1365
		//So it appears that computeTotalFICA returns the total FICA on qualifying amounts
		// (the income > 100 per carpet job * ficarate, plus the income > 50 per floor jbo * ficarate.)
		assertEquals(agency.computeTotalFICA(), 3.13, 0.01);
		
		//Simply, the TotalProfitAndPay * .9
		assertEquals(agency.getWeeklyEmployeePay(), 306.9, 0.01);
		
		//Simply, the TotalProfitAndPay * .1
		assertEquals(agency.getWeeklyProfit(), 34.1, 0.01);
		
		// Employee 1 had 2 jobs: Carpet (25) and Carpet (25). 50 * .9 = 45.
		// The total pay is simply the total gross pay of all their jobs, * .9 .
		assertTrue(employee1.getTotalPay() == 45);
		
		//This is the sum of the FICA amount on each of the individual jobs.
		assertTrue(employee1.getTotalFICA() == 0);
		
		assertTrue(employee2.getTotalPay() == 81);
		assertEquals(employee2.getTotalFICA(), 3.06, 0.01);
		assertTrue(employee3.getTotalPay() == 90);
		assertTrue(employee3.getTotalFICA() == 0);
		assertEquals(employee4.getTotalPay(), 90.9, 0.01);
		assertEquals(employee4.getTotalFICA(), 0.07, 0.01);
		
		// This should clear all previous data
		agency.endWeek();
		
		
		//===============================================
		//Doing another test run for some data
		//===============================================
		
		agency.assignWoodFloorRefinisherJob(6);
		agency.assignWoodFloorRefinisherJob(7);
		
		agency.clockOutFloorRefinisherJob(6, 3.1);
		agency.clockOutFloorRefinisherJob(7, 3.3);
		agency.clockOutFloorRefinisherJob(5, 27);
		
		
		assertTrue(agency.computeTotalProfitAndPay() == 501);
		assertEquals(agency.computeTotalFICA(), 27.16, 0.01);
		
		assertEquals(employee2.getTotalPay(), 364.5, 0.01);
		assertEquals(employee2.getTotalFICA(), 27.16, 0.01);
		assertEquals(employee3.getTotalPay(), 41.85, 0.01);
		assertTrue(employee3.getTotalFICA() == 0);
		assertEquals(employee4.getTotalPay(), 44.55, 0.01);
		assertTrue(employee4.getTotalFICA() == 0);
	}
	
	@Test
	public void myTest() {
		TempAgency agency = new TempAgency();
		Employee employee1 = new Employee("Bob");

		agency.addEmployee(employee1);

		employee1.addPay(50);
		employee1.addPay(1.2);
		assertEquals(51.2, employee1.getTotalPay(), 0.01);
		
		employee1.addFica(40);
		employee1.addFica(5.2);
		assertEquals(45.2, employee1.getTotalFICA(), 0.01);
		
		employee1.clearPayAndFica();
		assertTrue(0 == employee1.getTotalPay());
		assertTrue(0 == employee1.getTotalFICA());
		
		
		FloorRefinisher f = new FloorRefinisher(1, employee1);
		CarpetLayer c = new CarpetLayer(1, 105, employee1);
		assertTrue(c.computePay() == 105);
		assertEquals(0.3825, c.computeFica(), 0.01);
		
		f.setHours(4); // 4 * 15 = $60
		assertTrue(f.computePay() == 60);
		assertEquals(0.765, f.computeFica(), 0.01); //10 * .0765
		
		
		FloorRefinisher f2 = new FloorRefinisher(1, employee1);
		CarpetLayer c2 = new CarpetLayer(1, 100, employee1);
		assertTrue(c2.computeFica() == 0);
		f2.setHours(3); // 3 * 15 = $45
		assertTrue(f2.computeFica() == 0); 
	}
	

}
