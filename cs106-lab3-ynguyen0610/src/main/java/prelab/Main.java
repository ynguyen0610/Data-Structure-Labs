package prelab;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		System.out.println("Given command line arguments: \n" + Arrays.toString(args));
		
		// Variables to keep track of the produce
		ArrayList<String> vegetableNames = new ArrayList<String>();
		ArrayList<String> fruitNames = new ArrayList<String>();
		ArrayList<String> spiceNames = new ArrayList<String>();
		double totalAssetVegetable = 0;
		double totalAssetFruit = 0;
		double totalAssetSpice = 0;
		
		for (int i = 0; i < args.length; i++) {
			if (args[i].equals("-f")) {
				fruitNames.add(args[i+1]);
				totalAssetFruit += Double.parseDouble(args[i+2]);
				
			} 
			else if (args[i].equals("-v")) {
				vegetableNames.add(args[i+1]);
				totalAssetVegetable += Double.parseDouble(args[i+2]);
				
			} 
			else if (args[i].equals("-s")) {
				spiceNames.add(args[i+1]);
				totalAssetSpice += Double.parseDouble(args[i+2]);
			} 		
		}			
		// TODO: parse the command line arguments!
			
		
		
		// TODO: create an object of each type and print it!
		ProduceStand fStand = new ProduceStand(fruitNames, totalAssetFruit, "Fruit Stand");
		System.out.println(fStand.toString());
		ProduceStand vStand = new ProduceStand(vegetableNames, totalAssetVegetable, "Vegetable Stand");
		System.out.println(vStand.toString());
		ProduceStand sStand = new ProduceStand(spiceNames, totalAssetSpice, "Spice Stand");
		System.out.println(sStand.toString());
		
		// TODO: after implementing comparable, compare the objects above! 
		System.out.println();
		System.out.println("Vegetable Stand compared to Fruit Stand: " + vStand.compareTo(fStand));
		System.out.println("Fruit Stand compared to Spice Stand: " + fStand.compareTo(sStand));
		System.out.println("Vegetable Stand compared to Spice Stand: " + vStand.compareTo(sStand)); 
			
		}
	}
