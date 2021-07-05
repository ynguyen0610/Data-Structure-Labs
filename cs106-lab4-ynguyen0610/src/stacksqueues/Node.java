package stacksqueues;

public class Node<E> {
	private E data;
	private Node<E> next;
	
	public Node(E data) {
		this.data = data;
	}
	
	public void setNext(Node<E> next) {
		this.next = next;
	}
	
	public E getData() { 
		return data; 
	}
	
	public Node<E> getNext() {
		return next;
	}
}