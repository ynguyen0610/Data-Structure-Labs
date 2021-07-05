package stacksqueues;

import java.io.StringReader;
import java.util.Scanner;

/**
 *  Implements the shunting yard algorithm.
 *  See http://en.wikipedia.org/wiki/Shunting-yard_algorithm
 */
public class ShuntingYard {
    public static final String WORD = "[a-zA-Z]*\\b";
    public static final String OPERATOR = "[^\\w]";
	public static void main(String[] args) {
	
	if (args.length == 0) {
		System.err.println("Usage: java Postfix <expr>");
		
	} else {
		System.out.println("input: " + args[0]);
		Scanner input = new Scanner(new StringReader(args[0]));
		input.useDelimiter("(\\s+"                  
				+"|(?<=[a-zA-Z])(?=[^a-zA-Z])"      
				+"|(?<=[^a-zA-Z])(?=[a-zA-Z])"      
				+"|(?<=[^0-9\\056])(?=[0-9\\056])"
				+"|(?<=[0-9\\056])(?=[^0-9\\056])" 
				+"|(?<=[^\\w])(?=[^\\w]))");        
		double finalRes = postfix(input);
		System.out.println("result: " + finalRes);
	}	
	}
	
	public static double postfix(Scanner input) {
    	LinkedStack<Object> outputStack = new LinkedStack<>();
    	ArrayDeque<Object> outputQueue = new ArrayDeque<>();
    	while (input.hasNext()) {
			if (input.hasNextDouble()) {
				outputQueue.addLast(input);
			} else if (input.hasNext(OPERATOR)) {
				String operator = input.next(OPERATOR);
					while (outputStack.peek().equals(OPERATOR)) {
						if ()
					}
		return (double) output.pop(); 
		
			}
    	}
	}
	
	public int precedenceLevel(char op) {
		switch (op) {
		case '+': 
		case '-':
			return 1;
		case '*': 
		case '/': 
			return 2;
		}
		return op;
	}
}
	
