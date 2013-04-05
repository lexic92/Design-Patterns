
public class Max extends Visitor {
	private static Integer max = null;
	
	/**
	 * It will constantly update "max" if the node's integer is greater than the current max.
	 * @pre node is not null.
	 */
	@Override
	public void visit(Node node, Object... parameters) 
	{
		//1) Update the maximum
		if(max == null)
		{
			max = node.getValue();
		}
		else if(max < node.getValue())
		{
			max = node.getValue();
		}
		
		//2) Recursively accept the next node.
		if(node.getNextNode() != null)
		{
			node.getNextNode().accept(this);
		}
		
	}
	
	public int getMax()
	{
		return max.intValue();
	}

}
