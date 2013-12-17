/**Optimizer Class
 * @author Francis Hinson
 * Optimizer implements either dynamic method or greedy method for optimizing a bst
 * Keeps track of recursive calls and overall cost of tree
 */

import java.util.ArrayList;
import java.util.Collections;
public class Optimizer {
	
	private ArrayList<Key> keys = new ArrayList<Key>();
	private int calls = 0;
	private String optimizeType;
	private Key nilKey = new Key("nil");
	private Tree optimalTree = new Tree();
	
	public Optimizer(String optimizeType) {
		this.optimizeType = optimizeType;
	}
	
	/**accessor for calls**/
	public int getCalls() {
		return calls;
	}
	
	/**accessor for keys**/
	public ArrayList<Key> getKeys(){
		return keys;
	}
	
	/**insert a new key with String into keys ArrayList**/
	public void insertKey(String s, double d) {
		keys.add(optimizeType.equals("Greedy") ? new Key(s, d, true) : new Key(s, d));
	}
	
	/**insert a new key with Integer into keys ArrayList**/
	public void insertKey(int x, double d) {
		keys.add(optimizeType.equals("Greedy") ? new Key(x, d, true) : new Key(x, d));
	}
	
	/**returns keys ordered ascending-order/alphabetically, references the Collections library**/
	public Key[] orderKeys() {
		Collections.sort(keys);
		return keys.toArray(new Key[keys.size()]);
	}
	
	/**returns keys ordered ascending-order/alphabetically, references the Collections library**/
	public ArrayList<Key> orderKeysList() {
		Collections.sort(keys);
		return keys;
	}
	
	public Tree getOptimalTree(){
		return optimalTree;
	}
	
	public String getOptimizeType(){
		return optimizeType;
	}
	
	public void optimize(){
		if(optimizeType.equals("Greedy"))
			greedify();
		else dynamify();
	}
	
	public void greedify(){
        ArrayList<Key> orderedKeys = orderKeysList();
        for(int i = orderedKeys.size()-1; i >= 0; i--)
        	optimalTree.greedyInsert(orderedKeys.get(i));
	}
	
	/**first empty optimize method call, sets recursive call counter to 0, orders all of the keys, and makes a tree matrix to store visited trees**/
	public void dynamify() {
		calls = 0;
		Key[] orderedKeys = orderKeys();
		Tree[][] visited = new Tree[orderedKeys.length][orderedKeys.length];
		dynamify(orderedKeys, 0, orderedKeys.length-1, visited);
	}
	
	private Tree dynamify(Key[] listedKeys, int leftChild, int rightChild, Tree[][] visited){
        calls++;
        Tree dynamicTree = new Tree(nilKey);

        double costCounter = 0;
        for(int i = leftChild; i <= rightChild; i++)
                costCounter += listedKeys[i].getFrequency();

        if(rightChild <= leftChild){
        	if(leftChild == rightChild){
        		Tree tempTree = new Tree(null);
        		dynamicTree = new Tree(listedKeys[rightChild],tempTree.getRoot(),tempTree.getRoot()); /**no two nodes can be equal, pick one and make tree from it**/
        		dynamicTree.setCost(costCounter);
            }
        	else return new Tree(null); /**fails to meet binary structure, thus tree is null**/
        }

        else {
        	for(int i = leftChild; i <= rightChild; i++){
        		Tree leftSubTree = dynamify(listedKeys, leftChild, i-1, visited);
                Tree rightSubTree = dynamify(listedKeys, i+1, rightChild, visited);
                Tree pendingTree = new Tree(listedKeys[i], leftSubTree.getRoot(), rightSubTree.getRoot());
                pendingTree.setCost(leftSubTree.getCost() + rightSubTree.getCost() + costCounter);
                	if(dynamicTree.getRootKey().equals(nilKey) || dynamicTree.getCost() > pendingTree.getCost())
                		dynamicTree = pendingTree;
            }
        }
        visited[leftChild][rightChild] = dynamicTree;
        optimalTree = dynamicTree;
        return dynamicTree;
	}
}