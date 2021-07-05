package stacksqueues;

public class ArrayDeque<E> implements Deque<E> {
	private int front;
	private int rear;
	private int size;
	public static final int CAPACITY = 1000;
	private int capacity;
	private E[] arr;
	
	// Constructor to initialize the array with capacity = 1000	
	
	public ArrayDeque() {
		this(CAPACITY);
	}
	
	// Constructor to allow users to choose the array capacity 
	
	@SuppressWarnings("unchecked")
	public ArrayDeque(int capacity) {
		front = -1;
		rear = -1;
		arr = (E[]) new Object[capacity];
		this.capacity = capacity;
	}

	// Method to add element to the front 
	@Override
	public void addFirst(E element) throws FullQueueException {
		// arr.length ?
		if ((front == 0 && rear == capacity - 1) || (front == rear + 1 )) {
			throw new FullQueueException();
		}
		else if (isEmpty()) {
			front = 0;
			rear = 0;
			arr[front] = element;
		}
		else if (front == 0) {
			front = capacity - 1;
			arr[front] = element;
		}
		else {
			front--;
			arr[front] = element;
		}
	}
	// Method to add element to the rear 
	@Override
	public void addLast(E element) throws FullQueueException {
		if ((front == 0 && rear == capacity - 1) || (front == rear + 1 )) {
			throw new FullQueueException();
		}
		else if (isEmpty()) {
			front = 0;
			rear = 0;
			arr[rear] = element;
		}
		else if (rear == capacity - 1) {
			rear = 0;
			arr[rear] = element;
		}
		else {
			rear++;
			arr[rear] = element;
		}
	}
	// Method to remove element in the front 
	@Override
	public E removeFirst() throws stacksqueues.EmptyQueueException {
		E data = null;
		if (front == -1 && rear == -1) {
			throw new stacksqueues.EmptyQueueException();
		}
		else if (front == rear) {
			data = arr[front];
			front = -1;
			rear = -1;
		}
		else if (front == capacity - 1) {
			data = arr[front];
			front = 0;
		}
		else {
			data = arr[front];
			front++;
		}
		return data;
	}
	
	// Method to remove element at rear
	@Override
	public E removeLast() throws stacksqueues.EmptyQueueException {
		E data = null;
		if (front == -1 && rear == -1) {
			throw new stacksqueues.EmptyQueueException();
		}
		else if (front == rear) {
			data = arr[rear];
			front = -1;
			rear = -1;
		}
		else if (rear == 0) {
			data = arr[rear];
			rear = capacity - 1;
		}
		else {
			data = arr[rear];
			rear--;
		}
		return data;
	}
	// Method to throw exception when the front of the queue is empty 
	@Override
	public E first() throws stacksqueues.EmptyQueueException {
		if (isEmpty()) return null;
		return arr[front];
	}
	// Method to throw exception when the rear of the queue is empty 
	@Override
	public E last() throws stacksqueues.EmptyQueueException {
		if (isEmpty()) return null;
		return arr[rear];
	}
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return front == -1 && rear == -1;
	}
	
	@Override 	
	public String toString() {
		String str = "(";
		if (isEmpty()) {
			return null;
		}
		else {
			int i = front;
			while (i != rear) {
				str = str + arr[i] + ", ";
				i = (i + 1) % capacity;
			}
			str = str + arr[rear] + ")";
		}
		return str;
	}
}



