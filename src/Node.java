/**Node Class
 * @author Francis Hinson
 * Node has a key, leftChild, and rightChild
 */

public class Node {
	
	private Key key;
	private Node leftChild;
	private Node rightChild;
	
	/**construct node with null key and children**/
	public Node() {
		this.key = null;
		this.setLeftChild(null);
		this.setRightChild(null);
	}
	/**construct node with key and null children**/
	public Node (Key key) {
		this.key = key;
		this.setLeftChild(null);
		this.setRightChild(null);
	}
	
	/**construct node with key children**/
	public Node (Key key, Node leftChild, Node rightChild) {
		this.key = key;
		this.setLeftChild(leftChild);
		this.setRightChild(rightChild);
	}
	
	/**key accessor**/
	public Key getKey() {
		return key;
	}
	
	/**leftChild accessor**/
	public Node getLeftChild() {
		return leftChild;
	}
	
	/**rightChild accessor**/
	public Node getRightChild() {
		return rightChild;
	}
	
	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}
	
	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}
	
}