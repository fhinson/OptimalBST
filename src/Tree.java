/**Binary Tree Class
 * @author Francis Hinson
 * Tree has a root Node and total cost
 * Notable methods: setCost, getCost, getRoot, getRootKey, print
 */

public class Tree extends Node {
	
	private Node root;
	private double cost;
	private Node nilNode = new Node(null);
	
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
	
	public void greedyInsert(Key newItem) {
		   if( root == null ) {
		      root = new Node( newItem );
		      return;
		   }
		   Node runner; 
		   runner = root;
		   while (true) {
		      newItem.setPrioritizeFrequency(false);
		      if( newItem.compareTo(runner.getKey()) < 0 ) {
		         if( runner.getLeftChild() == null || runner.getLeftChild() == nilNode) {
		            runner.setLeftChild(new Node( newItem ));
		            runner.getLeftChild().setLeftChild(nilNode);
		            runner.getLeftChild().setRightChild(nilNode);
		            return; 
		         }
		         else
		            runner = runner.getLeftChild();
		      }
		      else {
		         if( runner.getRightChild() == null || runner.getLeftChild() == nilNode) {
		            runner.setRightChild(new Node( newItem ));
		            runner.getRightChild().setLeftChild(nilNode);
		            runner.getRightChild().setRightChild(nilNode);
		            return; 
		         }
		         else
		            runner = runner.getRightChild();
		      }
		   } 
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

	public void setRoot(Node root) {
		this.root = root;
	}
}