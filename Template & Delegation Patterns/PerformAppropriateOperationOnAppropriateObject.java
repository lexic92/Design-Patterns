

import java.util.Iterator;


public abstract class PerformAppropriateOperationOnAppropriateObject {

	public double execute() {
		
		//This is a template method.  This is a concrete method in this abstract class, which calls some abstract
		//methods that subclasses should override.
		
		double sum = 0;
		Iterator<Job> it = getIterator(); //<<<---------- ABSTRACT METHOD
		while(it.hasNext())
		{
			sum += getAmount((Job)it.next()); //<<<---------- ABSTRACT METHOD
		}
		return sum;
	}
	
	public abstract Iterator<Job> getIterator();
	public abstract double getAmount(Job j);
	
}
