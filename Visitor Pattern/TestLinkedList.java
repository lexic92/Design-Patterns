import junit.framework.TestCase;


public class TestLinkedList extends TestCase {
	public void setUp()
	{
		//Do nothing
	}
	public void tearDown()
	{
		//Do nothing
	}
	public void testLinkedList()
	{
		//First, make a new linked list of 3 nodes.
		Node n = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		n.setNextNode(n2);
		n2.setNextNode(n3);
		
		//Linked List now looks like this:
		// [1] -> [2] -> [3]
		
		
		//================================TEST MAX===========================
		Max max = new Max();
		n.accept(max);
		assertTrue(max.getMax() == 3);
		
		
		//================================TEST MIN===========================
		Min min = new Min();
		n.accept(min);
		assertTrue(min.getMin() == 1);
		
		
		//================================TEST SUM===========================
		Sum sum = new Sum();
		n.accept(sum);
		assertTrue(sum.getSum() == 6);
	}
}
