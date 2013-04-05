
public class Min extends Visitor {
	private static Integer min = null;
	
	/**
	 * It will constantly update "min" if the node's integer is less than the current max.
	 * @pre node is not null.
	 */
	@Override
	public void visit(Node node, Object... parameters) 
	{
		//1) Update the minimum.
		if(min == null)
		{
			min = node.getValue();
		}
		else if(node.getValue() < min)
		{
			min = node.getValue();
		}
		
		//2) Recursively accept the next node.
		if(node.getNextNode() != null)
		{
			node.getNextNode().accept(this);
		}
	}
	
	public int getMin()
	{
		return min.intValue();
	}
}
