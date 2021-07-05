package prelab;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.opencsv.CSVReaderHeaderAware;

/*
 * You should use this package for Pre-Lab 2 and Pre-Lab 3 Exercises.
 * Make sure you don't have errors in this package, since it will cause issues
 * with the autograder if there are any compilation issues.
 */



public class Main {
	public static void main(String[] args) throws IOException {		

		try {
		/* Header-aware reader of StudentProfile.csv
		Make sure StudentProfile.csv is accessible or provide the proper path
		Read and write to a file may throw an exception e.g., FileNotFound etc,
		make sure you handle such errors properly */
		CSVReaderHeaderAware csvReader = new CSVReaderHeaderAware(new FileReader("StudentProfile.csv"));
		// ArrayList containing each row of the csv as a String array
		ArrayList<String[]> dataReadRows = new ArrayList<String[]>(csvReader.readAll());
		csvReader.close();
		
		// Create an instance of type FullStudentInfo
		FullStudentInfo student = new FullStudentInfo();
		// Call the method to populate the data set with dataReadRows variable
		student.addAllStudentsToArrList(dataReadRows);	
		// Call the method toString to print out the entire list of students
		System.out.println(student.toString());
		} catch (Exception ex) {
			System.out.print("Exception error occured!");
		}

	}

}
