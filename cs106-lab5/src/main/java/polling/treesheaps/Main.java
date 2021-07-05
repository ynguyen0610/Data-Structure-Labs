package polling.treesheaps;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.opencsv.CSVReaderHeaderAware;

public class Main {
	
    public static void main(String[] args) {
    	System.out.println("intTree");
    	BinaryTree intTree = new LinkedBinaryTree();
    	intTree.insert(8);
    	intTree.insert(11);
    	intTree.insert(5);
    	intTree.insert(17);
    	intTree.insert(1);
    	intTree.insert(9);
    	intTree.insert(3);
    	System.out.println("size: " + intTree.size()); 
    	System.out.println("Pre: "+intTree.toStringPreOrder());
    	System.out.println("In: "+intTree.toStringInOrder());
    	System.out.println("Post: "+intTree.toStringPostOrder());    	// TODO: first create tests for your LinkedBinaryTree class (in a separate method below).
    	BinaryTree letterTree = new LinkedBinaryTree(); 
    	letterTree.insert('A'); 
    	letterTree.insert('C'); 
    	letterTree.insert('G'); 
    	letterTree.insert('B'); 
    	letterTree.insert('D'); 
    	letterTree.insert('G'); 
    	// inserting again, should replace 
    	letterTree.insert('F'); 
    	letterTree.insert('E'); 
    	letterTree.insert('H'); 
    	letterTree.insert('I'); 
       	System.out.println("letterTree:");
    	System.out.println("size: " + letterTree.size()); 
    	System.out.println("Pre: "+letterTree.toStringPreOrder());
    	System.out.println("In: "+letterTree.toStringInOrder());
    	System.out.println("Post :"+letterTree.toStringPostOrder());
    	System.out.println("Yen".compareTo("Mai"));	
        
    	// TODO: then read in the polling data from the given files and create a tree of candidates.
    	// Create a binary tree in Main
    	LinkedBinaryTree<Candidate> pollingTree = new LinkedBinaryTree<>();
    	CSVReaderHeaderAware reader = null;
    	for (int i = 0; i < args.length; i++) {
			try {
				reader = new CSVReaderHeaderAware(new FileReader(args[i]));
				ArrayList<String[]> pollingInfo = new ArrayList<String[]>(reader.readAll());
				reader.close();
				for (int z = 0; z < pollingInfo.size(); z++) {
					// Use get method to get an element
					Candidate newCandidate = new Candidate(pollingInfo.get(z));
					pollingTree.insert(newCandidate);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
    	System.out.println(pollingTree);
    }
}
