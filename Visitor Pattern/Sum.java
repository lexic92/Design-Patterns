
public class Sum extends Visitor {
	private static Integer sum = null;
	
	/**
	 * It will constantly update "sum" if the node's integer is greater than the current max.
	 * @pre node is not null.
	 */
	@Override
	public void visit(Node node, Object... parameters) 
	{
		//1) Update the sum
		if(sum == null)
		{
			sum = node.getValue();
		}
		else
		{
			sum += node.getValue();
		}
		
		//2) Recursively accept the next node.
		if(node.getNextNode() != null)
		{
			node.getNextNode().accept(this);
		}
	}
	
	public int getSum()
	{
		return sum.intValue();
	}

}