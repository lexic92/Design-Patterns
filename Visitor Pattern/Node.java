/**
 * A node in a linked list.
 * @author lexic92
 *
 */
class Node
{
	private Integer value;
	private Node nextNode;
	
	/**
	 * Constructor
	 * @pre none
	 * @post  value = new Value AND nextNode = null
	 * @param newValue
	 */
	public Node(Integer value)
	{
		this.value = value;
		nextNode = null;
	}
	/**
	 * Gets the value
	 * @pre none
	 * @post result = value
	 * @return value
	 */
	public int getValue()
	{
		return value;
	}
	/**
	 * sets next node
	 * @pre none
	 * @post this.nextNode = nextNode
	 * @param nextNode
	 */
	public void setNextNode(Node nextNode)
	{
		this.nextNode = nextNode;
	}
	/**
	 * gets next node
	 * @pre none
	 * @post result = this.nextNode
	 * @return this.nextNode
	 */
	public Node getNextNode()
	{
		return this.nextNode;
	}
	/**
	 * @pre visitor != null
	 * @post visitor.visit(this, parameters).postcondition
	 * @param visitor
	 * @param parameters
	 */
	public void accept(Visitor visitor, Object... parameters)
	{
		visitor.visit(this);
	}
}
                        
