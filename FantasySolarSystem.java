/*
 * Student Slobodov Aleksandr, Student ID 689997
 * In order to get high mark, I have done some improvement work. 
 * Compared to my previous programs I have created more constants,
 * and changed me main counters' names from "i", "n", "k", etc to more understandable names
 * (In class FantasySolarSystem, there is a counter called "planetCount").  
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class FantasySolarSystem {
	
	private final static String TABLE_HEAD = "Name\tMass\tDistance\tPeriods(years)";
	private final static String WELCOME_MSG = "Enter the name of the solar system: ";
	private final static String POLITE_QUESTION = "Now enter planet names - type 'done' to finish";
	private final static String STOP_WORD = "done";
	
	
	private static String systemName;
	private static ArrayList<SolarSystem> planetName = new ArrayList<>();//An array list , contains all the information about planets(e.g. name, mass, period and distance)
	
	public static void getSystemName(String name){
		systemName = name;
	}
	
	private static void getPlanetsName(String name, int i){//This method adds a system name
		
			planetName.add(new SolarSystem(name));		
	}
	
	private static int createPlanets(int count){// In this method all the random data is genereted and added to the array list
		Random rand = new Random();
		double mass;
		double distance;
		mass = rand.nextDouble()*3;//Generates mass
		distance = rand.nextDouble()*3;//Generates distance
		mass = Math.round(mass*1000)/1000.0;//Rounds mass
		distance = Math.round(distance*1000)/1000.0;//Rounds distance
		planetName.get(count).addPlanet(planetName.get(count).getName(), mass, distance);//Adds all the data into the array list
		System.out.println(planetName.get(count).toStrng())	;//Nicely prints planet name, mass, distance and period 
		count+=1;
		return count;//Returns the amount of planets n the system(Included the new one)
	}
	
	private static void niceOutput(int n){//This method prints the final table, using '\t' symbol 
		int i = 0;
		System.out.println(TABLE_HEAD);
		while(i<n-1){
			System.out.println(planetName.get(i).getName()+"\t" + planetName.get(i).getMass() + "\t" 
		    + planetName.get(i).getDistance() + "\t\t" + planetName.get(i).getPeriod());
			i++;
		}
	}
	
	public static void main(String[] args){
		
		Scanner s = new Scanner(System.in);
		int planetCount =0;
		System.out.print(WELCOME_MSG);
		getSystemName(s.nextLine());//Adds system name to an object
		System.out.println(POLITE_QUESTION);
		do{
			getPlanetsName(s.next(), planetCount);
			if(!planetName.get(planetCount).getName().equals(STOP_WORD)){
				
				createPlanets(planetCount);//Adds a planet to an array list 				
			}	
			planetCount++;		
		}while(!planetName.get(planetCount-1).getName().equals(STOP_WORD));//Scans input until "done" is inputed 
		niceOutput(planetCount);//Calls niceOutput method
	}

}
