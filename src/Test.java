/**Test Class
 * @author Francis Hinson
 * Builds different types of distributions for analysis
 * Looks at different test scenarios to draw meaningful conclusions about greedy vs. dynamic solutions to the optimal BST
 */

public class Test {

	public static void main(String[] args) {
		
		System.out.println("Figure 10.47 - Greedy-Optimal Solution");
		Optimizer figure_10_47_greedy = new Optimizer("Greedy");
		System.out.println("Figure 10.47: " + figure_10_47_greedy.getOptimizeType() + " Implementation");
		System.out.println("Overall cost: " + figure_10_47_greedy.getOptimalTree().getCost());
		
		figure_10_47_greedy.insertKey("a", 0.22);
        figure_10_47_greedy.insertKey("am", 0.18);
        figure_10_47_greedy.insertKey("and", 0.20);
        figure_10_47_greedy.insertKey("egg", 0.05);
        figure_10_47_greedy.insertKey("if", 0.25);
        figure_10_47_greedy.insertKey("the", 0.02);
        figure_10_47_greedy.insertKey("two", 0.08);
        
        figure_10_47_greedy.optimize();
        figure_10_47_greedy.getOptimalTree().print(figure_10_47_greedy.getOptimalTree().getHeight());
        
        System.out.println("Figure 10.47 - Dynamic-Optimal Solution");
        Optimizer figure_10_47_dynamic = new Optimizer("Dynamic");
        System.out.println("Figure 10.47: " + figure_10_47_dynamic.getOptimizeType() + " Implementation");
        System.out.println("Overall cost: " + figure_10_47_dynamic.getOptimalTree().getCost());
		
		figure_10_47_dynamic.insertKey("a", 0.22);
        figure_10_47_dynamic.insertKey("am", 0.18);
        figure_10_47_dynamic.insertKey("and", 0.20);
        figure_10_47_dynamic.insertKey("egg", 0.05);
        figure_10_47_dynamic.insertKey("if", 0.25);
        figure_10_47_dynamic.insertKey("the", 0.02);
        figure_10_47_dynamic.insertKey("two", 0.08);
        
        figure_10_47_dynamic.optimize();
        figure_10_47_dynamic.getOptimalTree().print(figure_10_47_dynamic.getOptimalTree().getHeight());
        
        System.out.println("Uniform and Random Distributions for both Greedy-Optimal and Dynamic-Optimal Solutions");
        for(int i = 1; i <= 200; i++){
        	Optimizer testDistribution = new Optimizer(i % 2 == 0 ? "Dynamic" : "Greedy");
        	Distributions dist = new Distributions(i >= 100 ? "Uniform" : "Random", (int)(Math.random() * 100 + 1));
        	for(int j = 0; j < dist.getProbabilities().size(); j++)
        		testDistribution.insertKey((j+1), dist.getProbabilities().get(j));
        	testDistribution.optimize();
        	System.out.println("CASE " + i);
        	System.out.println("Optimization Type: " + testDistribution.getOptimizeType());
        	System.out.println("Distribution Type: " + dist.getDistributionType());
        	System.out.println("Total # of Nodes: " + dist.getProbabilities().size());
        	//System.out.println("Total # of Recursive Calls: " + testDistribution.getCalls());
        	System.out.println("Overall Cost of Optimal Tree: " + testDistribution.getOptimalTree().getCost());
        	testDistribution.getOptimalTree().print(testDistribution.getOptimalTree().getHeight());
        }
        
        System.out.println("Test Greedy-Optimal Solution With One Particular N");
        int N = 25;
        for(int i = 1; i <= 8; i++){
        	Optimizer testDistribution = new Optimizer("Greedy");
        	Distributions dist = new Distributions(i % 2 == 0 ? "Random" : "Uniform", i % 2 == 0 ? N : ++N);
        	for(int j = 0; j < dist.getProbabilities().size(); j++)
        		testDistribution.insertKey((j+1), dist.getProbabilities().get(j));
        	testDistribution.optimize();
        	System.out.println("CASE " + i);
        	System.out.println("Optimization Type: " + testDistribution.getOptimizeType());
        	System.out.println("Distribution Type: " + dist.getDistributionType());
        	System.out.println("Total # of Nodes: " + dist.getProbabilities().size());
        	//System.out.println("Total # of Recursive Calls: " + testDistribution.getCalls());
        	System.out.println("Overall Cost of Optimal Tree: " + testDistribution.getOptimalTree().getCost());
        	testDistribution.getOptimalTree().print(testDistribution.getOptimalTree().getHeight());
        }
        
        String[] caseTypes = {"Uniform", "Uniform", "HumpAt1", "HumpAt1", "HumpAtN4", "HumpAtN4", "Symmetric", "Symmetric", "Normal", "Normal"};
        System.out.println("5 Distribution Test Cases");
        int M = 30;
        double previousCost = 0;
        for(int i = 1; i <= 10; i++){
        	Optimizer testDistribution = new Optimizer(i % 2 == 0 ? "Dynamic" : "Greedy");
        	Distributions dist = new Distributions(caseTypes[i-1], M);
        	for(int j = 0; j < dist.getProbabilities().size(); j++)
        		testDistribution.insertKey((j+1), dist.getProbabilities().get(j));
        	testDistribution.optimize();
        	System.out.println("CASE " + i);
        	System.out.println("Optimization Type: " + testDistribution.getOptimizeType());
        	System.out.println("Distribution Type: " + dist.getDistributionType());
        	System.out.println("Total # of Nodes: " + dist.getProbabilities().size());
        	//System.out.println("Total # of Recursive Calls: " + testDistribution.getCalls());
        	System.out.println("Overall Cost of Optimal Tree: " + testDistribution.getOptimalTree().getCost()); 
        	previousCost = i % 2 != 0 ? testDistribution.getOptimalTree().getCost() : previousCost;
        	if(i % 2 == 0)
        		System.out.println("Greedy path cost " + (previousCost == testDistribution.getOptimalTree().getCost() ? "is" : "is not") + " optimal!");
        	testDistribution.getOptimalTree().print(testDistribution.getOptimalTree().getHeight());
        }
           
	}

}
