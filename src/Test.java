/**Test Class
 * @author Francis Hinson
 * Builds different types of distributions for analysis
 * Looks at different test scenarios to draw meaningful conclusions about greedy vs. dynamic solutions to the optimal BST
 */

public class Test {

	public static void main(String[] args) {
		
		Optimizer test = new Optimizer();
		
		test.insertKey("a", 0.22);
        test.insertKey("am", 0.18);
        test.insertKey("and", 0.20);
        test.insertKey("egg", 0.05);
        test.insertKey("if", 0.25);
        test.insertKey("the", 0.02);
        test.insertKey("two", 0.08);
        
        test.setTabling(true);
        Tree bestTree = test.optimize();
        bestTree.print(4);
        
        
        
        for(int i = 1; i <= 100; i++){
        	Optimizer distOpt = new Optimizer();
        	Distributions dist = new Distributions("Random");
        	for(int j = 0; j < dist.getProbabilities().size(); j++){
        		distOpt.insertKey((j+1), dist.getProbabilities().get(j));
        	}
        	distOpt.setTabling(false);
        	Tree distOptTree = distOpt.optimize();
        	System.out.println("CASE " + i);
        	System.out.println("Distribution Type: " + dist.getDistributionType());
        	System.out.println("Total # of Nodes: " + dist.getProbabilities().size());
        	System.out.println("Total # of Recursive Calls: " + distOpt.getCalls());
        	System.out.println("Ratio of Nodes to Calls: " + ((double)dist.getProbabilities().size() / distOpt.getCalls()));
        	System.out.println("Overall Cost of Optimal Tree: " + distOptTree.getCost());
        	distOptTree.print(distOptTree.getHeight()-1);
        }
        
     
       
	}

}
