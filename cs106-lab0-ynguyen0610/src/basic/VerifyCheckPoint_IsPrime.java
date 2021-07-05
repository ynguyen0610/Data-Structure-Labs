package basic;

/*
 * DO NOT MAKE CHANGES TO THIS FILE to ensure your work is verified correctly.
 * If your code does not pass, then you should change your code instead of this file.
 * 
 * This class checks the isPrime method's compatibility with the autograder.
 * Specifically, it checks for the existence of the method and its signature.
 * 
 * Students are expected to get a passing status when they run the Verify files before submitting. 
 */

public class VerifyCheckPoint_IsPrime extends VerifyHelper {
	
	// note: these are not necessarily the most appropriate type. You are responsible for choosing the most appropriate types.
	private Class<?>[][] compatibleParamTypes = new Class<?>[][] {WHOLE};
	private Class<?>[] compatibleReturnTypes = new Class<?>[] {boolean.class};
	
	public VerifyCheckPoint_IsPrime() {
		super("isPrime");
		setCompatibleTypes(compatibleParamTypes, compatibleReturnTypes);
	}
	
	public static void main(String[] args) {
		VerifyHelper checker = new VerifyCheckPoint_IsPrime();
		checker.run();
	}
}
