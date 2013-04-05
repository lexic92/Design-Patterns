
abstract class Visitor
{
	/**
	 * @pre visitor != null
	 * @pre parameters != null
	 * @post True (to be anded with the postcondition of the specialization)
	 * @param node
	 * @param parameters
	 */
	abstract public void visit(Node node, Object... parameters);
	
}