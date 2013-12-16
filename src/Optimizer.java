/**Optimizer Class
 * @author Francis Hinson
 * Optimizer implements one optimizing  dynamic method
 * Keeps track of recursive calls and overall cost of tree
 */

import java.util.ArrayList;
import java.util.Collections;
public class Optimizer {
	
	private ArrayList<Key> keys = new ArrayList<Key>();
	private int calls = 0;
	private boolean tabling = true;
	private Key nilKey = new Key("nil");
	
	public Optimizer() {}
	
	/**accessor for calls**/
	public int getCalls() {
		return calls;
	}
	
	/**accessor for keys**/
	public ArrayList<Key> getKeys(){
		return keys;
	}
	
	/**mutator for greedy boolean preference**/
	public void setTabling(boolean b) {
		tabling = b;
	}
	
	/**insert a new key with String into keys ArrayList**/
	public void insertKey(String s, double d) {
		keys.add(new Key(s, d));
	}
	
	/**insert a new key with Integer into keys ArrayList**/
	public void insertKey(int x, double d) {
		keys.add(new Key(x, d));
	}
	
	/**returns keys ordered alphabetically, references the Collections library**/
	public Key[] orderKeys() {
		Collections.sort(keys);
		return keys.toArray(new Key[keys.size()]);
	}
	
	public Tree optimize() {
		calls = 0;
		Key[] orderedKeys = orderKeys();
		Tree[][] visited = new Tree[orderedKeys.length][orderedKeys.length];
		return optimize(orderedKeys, 0, orderedKeys.length-1, visited);
	}
	
	private Tree optimize(Key[] listedKeys, int leftChild, int rightChild, Tree[][] visited){
        calls++;
        Tree optimalTree = new Tree(nilKey);

        if(tabling == false && leftChild <= rightChild){
        	if(visited[leftChild][rightChild] != null)
        		return visited[leftChild][rightChild];
        }

        double costCounter = 0;
        for(int i = leftChild; i <= rightChild; i++)
                costCounter += listedKeys[i].getFrequency();

        if(rightChild <= leftChild){
        	if(leftChild == rightChild){
        		Tree tempTree = new Tree(null);
        		optimalTree = new Tree(listedKeys[rightChild],tempTree.getRoot(),tempTree.getRoot());
        		optimalTree.setCost(costCounter);
            }
        	else return new Tree(null);
        }

        else {
        	for(int i = leftChild; i <= rightChild; i++){
        		Tree leftSubTree = optimize(listedKeys, leftChild, i-1, visited);
                Tree rightSubTree = optimize(listedKeys, i+1, rightChild, visited);
                Tree pendingTree = new Tree(listedKeys[i], leftSubTree.getRoot(), rightSubTree.getRoot());
                pendingTree.setCost(leftSubTree.getCost() + rightSubTree.getCost() + costCounter);
                	if(optimalTree.getRootKey().equals(nilKey) || optimalTree.getCost() > pendingTree.getCost())
                		optimalTree = pendingTree;
            }
        }
        visited[leftChild][rightChild] = optimalTree;
        return optimalTree;
	}	
}