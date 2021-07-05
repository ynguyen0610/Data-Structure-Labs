package polling.treesheaps;

public class LinkedBinaryTree<E extends Comparable<E>> implements BinaryTree<E> {
	private E root = null;
	private LinkedBinaryTree<E> left;
	private LinkedBinaryTree<E> right;
	private int size;
	
	// Accessor methods
	public E getRootElement() { return root; }
	public int size() { 
		int size = 0;
		if (root == null) { 
			return 0; 
		} 
		else {
			if (right != null) {
				size += right.size();
			} 
			if (left != null) {
				size += left.size();
			}
			size += 1;
		}
		return size;
	}
	public boolean isEmpty() { return size() == 0; }
	
	// Constructor for an empty binary tree
	public LinkedBinaryTree() {
		left = null;
		right = null;
		root = null;
	}
	// Constructor to create a new tree when we know the value of the element
	public LinkedBinaryTree(E element) {
		left = null;
		right = null;
		this.root = element;
	}
	// Method to insert element into the tree
	public void insert(E element) {
		if (root == null) {
			this.root = element;
		} 
		else if (element.compareTo(root) < 0) {
			if (left == null) {
				left = new LinkedBinaryTree(element);
			} 
			else {
				left.insert(element);	
			}
		}
		else if (element.compareTo(root) > 0) {
			if (right == null) {
				right = new LinkedBinaryTree(element);
			}
			else {
				right.insert(element);
			}
		}
		else {
			root = element; 
		}
	}
	
	public String toStringInOrder() {
		String output = "";
		if (left != null) {
			output += left.toStringInOrder();
		}
		output += root;
		if (right != null) {
			output += right.toStringInOrder();
		}
		return output;
	}
	
	public String toStringPreOrder() {
		String output = "";
		output += root;
		if (left != null) {
			output += left.toStringPreOrder();
		}
		if (right != null) {
			output += right.toStringPreOrder();
		}
		return output;
	}
	
	public String toStringPostOrder() {	
		String output = "";
		if (left != null) {
			output += left.toStringPreOrder();
		}
		if (right != null) {
			output += right.toStringPreOrder();
		}
		output += root;
		return output;
	}
}
