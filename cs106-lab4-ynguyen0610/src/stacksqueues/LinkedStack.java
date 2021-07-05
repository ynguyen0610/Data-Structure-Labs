package stacksqueues;

import java.util.EmptyStackException;

public class LinkedStack<E> implements Stack<E> {
	private Node<E> head;
	private int size;
	
	// Constructor to initialize the fiels
	
	public LinkedStack() {
		head = null;
		size = 0;
	}
	
	// Push method
	@Override
	public void push(E element) {
		Node<E> newest = new Node<E>(element);
		if (isEmpty()) {
			head = newest;
			head.setNext(null);
		}
		else {
			newest.setNext(head);
			head = newest;
		}
		size++;
	}
	
	// Pop method
	@Override
	public E pop() throws EmptyStackException {
		E data;
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		else {
			data = head.getData();
			head = head.getNext();
		}
		size--;
		return data;
	}

	// Peek method
	@Override
	public E peek() throws EmptyStackException {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		else {
			return head.getData();
		}
	}
	
	// Method to return size
	@Override
	public int size() {
		return size;
	}
	
	// Method when the stack is empty
	@Override
	public boolean isEmpty() {
		return size == 0;
	}
	
	@Override
	public String toString() {
		LinkedStack<E> Stack2 = new LinkedStack<E>(); 
		Node<E> temp = head;
		String str = "(";
		if (isEmpty()) {
			return null;
		}
		else {
			while (temp != null) {
				Stack2.push(temp.getData());
				temp = temp.getNext();
			}
			while (Stack2.size() > 1) {
				str = str + Stack2.pop() + ", ";
			} 
			return str = str + Stack2.pop() + ")"; 
		}
	}
}
	
	
