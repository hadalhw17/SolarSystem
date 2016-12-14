/*
 * Student Slobodov Aleksandr, Student ID 689997
 * In order to get high mark, I have done some improvement work. 
 * Compared to my previous programs I have created more constants,
 * and changed me main counters' names from "i", "n", "k", etc to more understandable names
 * (In class FantasySolarSystem, there is a counter called "planetCount").  
 */
public class SolarSystem {
	
	private String name;
	private String systemName;
	private double mass;
	private double distance;
	private double period;
	private String addOutput="";
	
	public SolarSystem(String systemName){
		this.systemName = systemName;
		this.name = systemName;
		
	}
	
	public void addPlanet(String name, double mass, double distance){//This method creates new planet with all generated data in FantasySolarSystem added
		
		this.name = name;
		this.mass = Math.round(mass*1000)/1000.0;
		this.distance = Math.round(distance*1000)/1000.0;
		period = Math.round(Math.sqrt(distance*distance*distance)*1000)/1000.0;
		addOutput += "Planet "+name+" has a mass of "+ mass + " Earths, is "+distance+"AU from its star, and orbits in "+period+" years\n";//For each planet it creates a beautiful output
		
	}
	
	//---------------------------------Block of getters starts here--------------------------------------------------//
	public String getName(){
		return name;
	}
	public double getMass(){
		return mass;
	}
	
	public double getDistance(){
		return distance;
	}
	public double getPeriod(){
		return period;
	}
	//-------------------------------Block of getters ends here---------------------------------------------------//
	//I ve created two different two different toString methods because output in the automatic test 1 is different from an output in an automatic test 2
	public String toString(){//Method is created to print an output in an automatic test two, where the input is not going from the keyboard or a file
		String output;
		addOutput = systemName+"\n"+addOutput;
		output = "Planet "+name.toString()+" has a mass of "+ mass + " Earths, is "+distance+"AU from its star, and orbits in "+period+" years";
		return addOutput;
	}
	public String toStrng(){//Method is created to print if the output is done from the keyboard or from the file
		
		String output;
		output = "Planet "+name+" has a mass of "+ mass + " Earths, is "+distance+"AU from its star, and orbits in "+period+" years";
		return output;
	}
}
