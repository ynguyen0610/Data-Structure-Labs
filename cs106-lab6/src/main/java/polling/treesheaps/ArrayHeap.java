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
import java.lang.reflect.Array;
import java.util.ArrayList;

public class ArrayHeap<E extends Comparable<E>> implements PriorityQueue<E> {
	
	// Instance variables
	private ArrayList<E> heap = new ArrayList<>();
	public ArrayHeap() { super(); }
	private int parent(int j) { return (j - 1) / 2; }
	private int leftChild(int j) { return 2*j + 1; }
	private int rightChild(int j) { return 2*j + 2; }
	private boolean hasLeft(int j) { return leftChild(j) < heap.size(); }
	private boolean hasRight(int j) { return rightChild(j) > heap.size(); }
	
	/**
	 * BubbleUp method to swap the value since in a max heap, the value of 
	 * each internal node is greater than or equal to the value of its children
	 * @param j Index of array
	 * Swap the lower and bigger value
	 */
	private void bubbleUp(int j) {
		while (j > 0) {
			int p = parent(j);
			if (heap.get(j).compareTo(heap.get(p)) <= 0) break;
				swap(p, j);
				j = p;
		}
	}
	/**
	 *  BubbleDown method to swap the lower value and the bigger value
	 * @param j Index of array
	 * Swap the lower and bigger value
	 */
	private void bubbleDown(int j) {
		while (hasLeft(j)) {
			int leftIndex = leftChild(j);
			int bigChildIndex = leftIndex;
			if (hasRight(j)) {
				int rightIndex = rightChild(j);
				if (heap.get(leftIndex).compareTo(heap.get(rightIndex)) < 0) {
					bigChildIndex = rightIndex;
				}
			}
			if (heap.get(bigChildIndex).compareTo(heap.get(j)) <= 0) break;
				swap(bigChildIndex, j);
				j = bigChildIndex;
			}
		}
	
	/** 
	 * insert method to add elements to the end of the array and call the bubbleUp
	 * method to re-heapify the data structure
	 * @param element data from the file 
	 */
	public void insert(E element) {
		heap.add(element);
		bubbleUp(heap.size() - 1);
	}
	
	/** 
	 * swap method to take in both indices and swap their positions
	 * @param j the first index
	 * @param p the second index
	 */
	private void swap(int j, int p) {
		E temp = heap.get(j);
		heap.set(j, heap.get(p));
		heap.set(p, temp);
	}
	public boolean isEmpty() {
		return size() == 0;
	}
	public int size() { return heap.size(); }
	public E max() {
		if (heap.isEmpty()) return null;
		return heap.get(0);
	}
	
	/**
	 *  removeMax method to save the root element to return later. 
	 *  Put the last element in the heap at the root and "bubble down"
	 *  until the heap is re-heapified
	 */
	public E removeMax() {
		if (heap.isEmpty()) return null;
		E answer = heap.get(0);
		swap(0, heap.size() - 1);
		heap.remove(heap.size() - 1);
		bubbleDown(0); 
		return answer;
	}
	
	@Override
	public String toString() {
		String output = "";
		int power = 0;
		int count = 0;
		for (int i = 0; i < heap.size(); i++) {
			output += heap.get(i) + " ";
			count++;
			if (count == Math.pow(2, power)) {
				power++;
				output += "\n";
				count = 0;
			}
		}
		return output;
	}
	
	// Phase I of Heap Sort 
	// New constructor to take in an unsorted ArrayList
    public ArrayHeap(ArrayList<E> array) {
    	heap = array;
    	for (int i = 0; i < size(); i++) {
    		bubbleUp(i);
    	}
    	System.out.println(heap);
    }
    /** 
     * @param j index of the array
     * @param size size input for the array
     */
    // Modify the bubbleDown method to take in another size variable 
    private void bubbleDown(int j, int size) {
    		while (leftChild(j) < size) {
				int leftIndex = leftChild(j);
				int bigChildIndex = leftIndex;
				
				if (rightChild(j) > size) {
					int rightIndex = rightChild(j);
					if (heap.get(leftIndex).compareTo(heap.get(rightIndex)) < 0) {
						bigChildIndex = rightIndex;
					}
				}
				
				if (heap.get(bigChildIndex).compareTo(heap.get(j)) <= 0) break;
					swap(bigChildIndex, j);
					j = bigChildIndex;
    			}
	}
    // sort method using swap to swap the first and last elements, 
    // and bubbleDown method to sort the array in place
    public void sort() {
    	for (int i = heap.size() - 1; i >= 0; i--) {    		
    		swap(0, i);
    		bubbleDown(0, i);
    	}

    }
}

