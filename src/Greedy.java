/**Greedy Class
 * @author Francis Hinson
 * Implements one optimizing greedy method for BST
 */

import java.util.ArrayList;
import java.util.Collections;

public class Greedy {

	private ArrayList<Key> keys = new ArrayList<Key>();
    private int calls = 0;
    private boolean tabling = true;
    private Key nilKey = new Key("nil");
    
    public Greedy(){}
    
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
		keys.add(new Key(s, d, true));
	}
	
	/**insert a new key with Integer into keys ArrayList**/
	public void insertKey(int x, double d) {
		keys.add(new Key(x, d, true));
	}
	
	/**returns keys ordered ascending-order/alphabetically, references the Collections library**/
	public ArrayList<Key> orderKeys() {
		Collections.sort(keys);
		return keys;
	}
	
	public Tree greedify(){
		calls = 0;
		ArrayList<Key> orderedKeys = orderKeys();
		return greedify(orderedKeys);
	}
	
	public Tree greedify(ArrayList<Key> listedKeys){
		calls++;
        Tree optimalTree = new Tree(listedKeys.get(listedKeys.size()-1));
		listedKeys.remove(listedKeys.size()-1);
		Node current = optimalTree.getRoot();
        
        if(listedKeys.size() == 0)
        	return optimalTree;
        
        Tree pendingTree = new Tree(listedKeys.get(listedKeys.size()-1));
        	
        	pendingTree.getRootKey().setGreedyReady(false);
        	if(pendingTree.getRootKey().compareTo(current.getKey()) == -1)
        		current.setLeftChild(new Node(pendingTree.getRootKey()));
        		//greedify()
        	else if(pendingTree.getRootKey().compareTo(current.getKey()) == 1)
        		current.setRightChild(new Node(pendingTree.getRootKey()));
        
       //make arraylist smaller within conditionals
       //consider moving first 4 lines of code outside
        	//sleep
        
       
        return optimalTree;
	}
	
	
	
	

}
