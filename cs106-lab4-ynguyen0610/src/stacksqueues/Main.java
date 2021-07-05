package stacksqueues;

public class Main {

	public static void main(String[] args) {
		// TODO: you should add tests for your implemented LinkedStack and
		// ArrayDeque here. We suggest that you group these tests together into
		// two separate methods that you call from this main method.
		
		LinkedStack<Object> test = new LinkedStack<Object>();
		test.push("abc");
		test.push("123");
		System.out.println(test.toString());
		
		ArrayDeque<Object> test2 = new ArrayDeque<Object>();
		test2.addFirst("a");
		System.out.println(test2.toString());
	}
}
