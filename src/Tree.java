/**Binary Tree Class
 * @author Francis Hinson
 * Tree has a root Node and total cost
 * Notable methods: setCost, getCost, getRoot, getRootKey, print
 */

public class Tree extends Node {
	
	private Node root;
	private double cost;
	
	/**construct empty tree**/
	public Tree() {
		root = null;
	}
	
	/**construct tree with root node**/
	public Tree(Key key) {
		root = new Node(key);
	}
	
	/**construct tree with root node and two children**/
	public Tree(Key key, Node leftChild, Node rightChild) {
		root = new Node(key, leftChild, rightChild);
	}
	
	/**cost mutator**/
	public void setCost(double costCounter) {
		this.cost = costCounter;
	}
	
	/**cost accessor**/
	public double getCost() {
		return cost;
	}
	
	/**root accessor**/
	public Node getRoot() {
		return root;
	}
	
	/**obtain key of root**/
	public Key getRootKey() {
		return root.getKey();
	}
	
	public int determineHeight(Node node){
	    if (node == null)
	        return 0;
	    else
	        return 1 + Math.max(determineHeight(node.getLeftChild()), determineHeight(node.getRightChild()));
	}
	
	public int getHeight(){
		return determineHeight(root);
	}
	
	/**print tree level by level**/
	public void print(int depth) {
	    for (int i = 1; i <= depth; i++) {
	        System.out.print("Depth " + (i-1) + ": ");
	        String levelNodes = printLevel(root, i);
	        System.out.print(levelNodes + "\n");
	    }
	    System.out.println("-------------------------------");
	}

	/**how to print tree at given level**/
	public String printLevel(Node t, int level) {
	    if (t == null)
	        return "";
	    if (level == 1)
	        return t.getKey() + " ";
	    else if (level > 1) {
	        String leftStr = printLevel(t.getLeftChild(), level - 1);
	        String rightStr = printLevel(t.getRightChild(), level - 1);
	        return leftStr + rightStr;
	    }
	    else return "";
	}
}