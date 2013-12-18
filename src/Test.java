/**Test Class
 * @author Francis Hinson
 * Builds different types of distributions for analysis
 * Looks at different test scenarios to draw meaningful conclusions about greedy vs. dynamic solutions to the optimal BST
 */

public class Test {

	public static void main(String[] args) {
		
		Optimizer figure_10_47_greedy = new Optimizer("Greedy");
		System.out.println("Figure 10.47: " + figure_10_47_greedy.getOptimizeType() + " Implementation");
		
		figure_10_47_greedy.insertKey("a", 0.22);
        figure_10_47_greedy.insertKey("am", 0.18);
        figure_10_47_greedy.insertKey("and", 0.20);
        figure_10_47_greedy.insertKey("egg", 0.05);
        figure_10_47_greedy.insertKey("if", 0.25);
        figure_10_47_greedy.insertKey("the", 0.02);
        figure_10_47_greedy.insertKey("two", 0.08);
        
        figure_10_47_greedy.optimize();
        figure_10_47_greedy.getOptimalTree().print(figure_10_47_greedy.getOptimalTree().getHeight());
        
        Optimizer figure_10_47_dynamic = new Optimizer("Dynamic");
        System.out.println("Figure 10.47: " + figure_10_47_dynamic.getOptimizeType() + " Implementation");
		
		figure_10_47_dynamic.insertKey("a", 0.22);
        figure_10_47_dynamic.insertKey("am", 0.18);
        figure_10_47_dynamic.insertKey("and", 0.20);
        figure_10_47_dynamic.insertKey("egg", 0.05);
        figure_10_47_dynamic.insertKey("if", 0.25);
        figure_10_47_dynamic.insertKey("the", 0.02);
        figure_10_47_dynamic.insertKey("two", 0.08);
        
        figure_10_47_dynamic.optimize();
        figure_10_47_dynamic.getOptimalTree().print(figure_10_47_dynamic.getOptimalTree().getHeight());
        
        for(int i = 1; i <= 200; i++){
        	Optimizer testDistribution = new Optimizer(i >= 100 ? "Dynamic" : "Greedy");
        	Distributions dist = new Distributions("Uniform");
        	for(int j = 0; j < dist.getProbabilities().size(); j++)
        		testDistribution.insertKey((j+1), dist.getProbabilities().get(j));
        	testDistribution.optimize();
        	System.out.println("CASE " + i);
        	System.out.println("Optimization Type: " + testDistribution.getOptimizeType());
        	System.out.println("Distribution Type: " + dist.getDistributionType());
        	System.out.println("Total # of Nodes: " + dist.getProbabilities().size());
        	System.out.println("Total # of Recursive Calls: " + testDistribution.getCalls());
        	System.out.println("Overall Cost of Optimal Tree: " + testDistribution.getOptimalTree().getCost());
        	testDistribution.getOptimalTree().print(testDistribution.getOptimalTree().getHeight());
        }
           
	}

}
