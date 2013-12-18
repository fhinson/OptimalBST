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
	
	public Distributions(String distributionType, int size){
		this.distributionType = distributionType;
		this.size = size;
		ArrayList<Double> probabilities = new ArrayList<Double>();
		double sum = 0;
		double n = (Math.random() * 10000 + 1); //random number that doesn't change
		if(distributionType.equals("Random") || distributionType.equals("Uniform")){
			for(int i = 0; i < size; i++){
				double r = (Math.random() * 10000 + 1); //random number that changes per loop
				sum += (distributionType.equals("Random") ? r : n);
				probabilities.add(distributionType.equals("Random") ? r : n);
			}

		}
		else{
			if(distributionType.equals("HumpAt1")){
				for(int i = 0; i < size; i++){
					sum += (size-i);
					probabilities.add((double) (size-i));
				}
			}
			if(distributionType.equals("HumpAtN4")){
				double r = 25;
				int halfway = size/4;
				for(int i = 1; i <= halfway; i++){
					sum+=r++;
					probabilities.add(r);
				}
				for(int i = halfway+1; i <= size; i++){
					sum+=r--;
					probabilities.add(r);
				}
			}
			if(distributionType.equals("Symmetric")){
				double r = 25;
				int halfway = size/2;
				for(int i = 1; i <= halfway; i++){
					sum+=r++;
					probabilities.add(r);
				}
				for(int i = halfway+1; i <= size; i++){
					sum+=r--;
					probabilities.add(r);
				}
			}
			Random rng = new Random();
			if(distributionType.equals("Normal")){
				for(int i = 0; i < size; i++){
					double r = rng.nextGaussian()*0.5+0.5;
					sum+=r;
					probabilities.add(r);
				}
			}
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
