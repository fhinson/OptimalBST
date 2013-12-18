/**Distributions Class
 * @author Francis Hinson
 * Generates distributions with probabilities summing to 1. Either generates uniformly distributed set or randomly distributed set.
 */

import java.util.ArrayList;
import java.util.Random;

//ideas: normal distribution, poisson distribution

public class Distributions {
	private int size;
	private ArrayList<Double> probabilities;
	private String distributionType;
	
	public Distributions(String distributionType){
		this.distributionType = distributionType;
		this.size = (int)(Math.random() * 150 + 1);
		ArrayList<Double> probabilities = new ArrayList<Double>();
		double sum = 0;
		double n = (Math.random() * 10000 + 1); //random number that doesn't change
		for(int i = 0; i < size; i++){
			double r = (Math.random() * 10000 + 1); //random number that changes per loop
			sum += (distributionType.equals("Random") ? r : n);
			probabilities.add(distributionType.equals("Random") ? r : n);
		}
		for(int j = 0; j < size; j++){
			double place = probabilities.get(j);
			place /= sum;
			probabilities.set(j, place);
		}
		this.probabilities = probabilities;
	}
	
	public ArrayList<Double> getProbabilities(){
		return probabilities;
	}
	
	public String getDistributionType(){
		return distributionType;
	}
}
