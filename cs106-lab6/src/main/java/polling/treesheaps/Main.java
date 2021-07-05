/**
* The main driver program for Assignment 1.
*
* This program reads the file specified by the first command line
* argument, takes in an unsorted array, create a heap and 
* sort the heap in place.
*
* @author: Yen Nguyen
* @version: April 28, 2021
*/

package polling.treesheaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.opencsv.CSVReaderHeaderAware;
import java.io.FileReader;
public class Main {

    public static void main(String[] args) {

    	// TODO: first create tests for your ArrayHeap class (in a separate method below).
  
        
        Integer[] arr = {-2,3,9,-7,1,2,6,-3};
        ArrayList<Integer> array = new ArrayList<Integer>(Arrays.asList(arr));
		ArrayHeap<Integer> heap = new ArrayHeap<Integer>(array);
        System.out.println(heap); // should print the same heap as before (9, 1 6, ...)
        heap.sort();
        System.out.println(array);

        // TODO: then read in the polling data from the given file (just one) and create
		// a heap of candidates to be sorted by their polling numbers
        
		try {
			CSVReaderHeaderAware reader = new CSVReaderHeaderAware(new FileReader(args[0]));
			ArrayList<String[]> list = new ArrayList<String[]>(reader.readAll());
			ArrayHeap<Candidate> newHeap = new ArrayHeap<Candidate>();
			reader.close();
			
			for (int i = 0; i < list.size(); i++) {
				Candidate heapData = new Candidate(list.get(i));
				newHeap.insert(heapData);
			}
			int size = newHeap.size();
			for (int j = 0; j < size; j++) {
				System.out.println(newHeap.removeMax());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
        
        // Create a new heap, then add the candidates to the heap one by one. 
        // Then, afterward, use removeMax in a loop to remove and print each candidate in turn. 
        // This will create a printout of the candidates from highest polling number to lowest polling number.

       // Make sure to copy over your Candidate class and 
       // change your compareTo method so that polling data objects are ordered based on the candidate's polling number 
        // (using the last name to break ties).
    }
