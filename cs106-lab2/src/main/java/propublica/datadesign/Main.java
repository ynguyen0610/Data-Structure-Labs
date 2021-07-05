package propublica.datadesign;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.opencsv.CSVReaderHeaderAware;


//The tasks of this lab, build upon the tasks that you have completed in lab1. Please make reuse of the code that you have already written in lab1.

public class Main {
	// this should become the "Prediction Fails Differently for Black Defendants" table
	public static PropublicaDataTable racialBiasTable = null;
	
    public static void main( String[] args ) {
        // TODO: eventually set racialBiasTable to a new PropublicaDataTable with correct values.
    	
    	CSVReaderHeaderAware reader = null;
		try {
			reader = new CSVReaderHeaderAware(new FileReader("compas-scores.csv"));
			ArrayList<String[]> myEntries = new ArrayList<String[]>(reader.readAll());
			reader.close();
			// Create an instance of type FullCriminalProfile
			FullCriminalProfile criminal = new FullCriminalProfile();
			// Call the method to populate the data set with myEntries variable
			criminal.readAllRows(myEntries);	
			// Call the method toString to print out the entire list of criminals
			System.out.println(criminal.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
		testAdding();
    }

    // Test method for adding methods
    public static void testAdding() {
    	String[] profile1 = {"Female", "Caucasian", "F", "Battery", "7", "High", "1", " ", " "};
    	String[] profile2 = {"Male", "African-American", "M", "Battery", "3", "Low", "1", " ", "(CO3)"};
    	ArrayList<String[]> str = new ArrayList<String[]>();
    	str.add(profile1);
    	str.add(profile2);
    	FullCriminalProfile profile = new FullCriminalProfile();
    	profile.readAllRows(str);
    	System.out.println(profile.toString());
    }
}
