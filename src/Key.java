/**Key Class
 * @author Francis Hinson
 * Key has name and frequency and is comparable by name
 */

public class Key implements Comparable<Key>{
	
	private String name;
	private int numericName;
	private double frequency;
	private boolean prioritizeFrequency;
	
	/**construct with null name and 0 frequency**/
	public Key(){
		this.name = null;
		this.frequency = 0;
	}
	
	/**construct with only name**/
	public Key(String name){
		this.name = name;
	}
	
	public Key(int numericName){
		this.numericName = numericName;
	}
	
	/**construct with name and frequency**/
	public Key(String name, double d){
		this.name = name;
		this.frequency = d;
	}
	
	public Key(int numericName, double d){
		this.numericName = numericName;
		this.frequency = d;
	}
	
	/**construct with name and frequency**/
	public Key(String name, double d, boolean prioritizeFrequency){
		this.name = name;
		this.frequency = d;
		this.prioritizeFrequency = prioritizeFrequency;
	}
	
	public Key(int numericName, double d, boolean prioritizeFrequency){
		this.numericName = numericName;
		this.frequency = d;
		this.prioritizeFrequency = prioritizeFrequency;
	}
	
	/**accessor for name**/
	public String getName(){
		return name;
	}
	
	public int getNumericName(){
		return numericName;
	}
	
	/**accessor for frequency**/
	public double getFrequency(){
		return frequency;
	}
	
	/**compare to another key based on name**/
	public int compareTo(Key key){
		if(this.prioritizeFrequency == true)
			return new Double(this.getFrequency()).compareTo(key.getFrequency());
		if(!(this.name == null))
			return (this.name.compareTo(key.getName()));
		return new Integer(this.numericName).compareTo(key.getNumericName());
	}
	
	/**return just the name or numericName for readability**/
	public String toString(){
		if(!(this.name == null))
			return name;
		return Integer.toString(numericName);
	}

	public void setPrioritizeFrequency(boolean b) {
		this.prioritizeFrequency = b;
	}

}