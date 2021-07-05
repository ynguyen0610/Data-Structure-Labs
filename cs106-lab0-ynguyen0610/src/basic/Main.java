package basic;
public class Main {

	public static void main(String[] args) {
		//Testing for method Power
		System.out.println(Power(5, 6));
		System.out.println(Power(5, 2));
		System.out.println(Power(4, 3));
		System.out.println(Power(1.2, 6));
		System.out.println(Power(2, -8)); // Throw exception
		
		// Testing for method GCD
		System.out.println(GCD(30, 150));
		System.out.println(GCD(6610, 340));
		System.out.println(GCD(12, 61));
		System.out.println(GCD(45, 2800));
		System.out.println(GCD(-260, 3768)); // Throw exception
		
		// Testing for method isPrime
		System.out.println(isPrime(6));
		System.out.println(isPrime(10));
		System.out.println(isPrime(25));
		System.out.println(isPrime(30));
		System.out.println(isPrime(-3));
		System.out.println(isPrime(1));
		
		// Testing for method Round
		System.out.println(round(58.2));
		System.out.println(round(-5.6));
		System.out.println(round(-0.9));
		System.out.println(round(-1.3));
		
		// Testing for method classYear
		System.out.println(classYear(Standing.FIRST_YEAR));
		System.out.println(classYear(Standing.SOPHOMORE));
		System.out.println(classYear(Standing.JUNIOR));
		System.out.println(classYear(Standing.SENIOR));
	} 
	public static double Power(double x, int exp) {
		double result = 1.0; 
		if (exp<0) {
			throw new IllegalStateException("Exponents below 0 is not accepted");
		} else {
			while (exp > 0) {
				result = x * result;
				exp--;
			}
		}
		return result;
	}
	public static int GCD(int number1, int number2) {
		if (number1 <= 0 || number2 <= 0) {
			throw new IllegalStateException("Inputs must be positive numbers");
		}
		int remainder = number1 % number2;
		while (remainder > 0) {
			number1 = number2;
			number2 = remainder;
			remainder = number1 % number2;
		}
		return number2;
	}
	public static boolean isPrime(int n) {
		if (n <= 1) {
			return false;
		}
		if (n % 2 == 0) {
			return false;
		}
		for (int i = 3; i<= Math.sqrt(n); i+=2) {
			if (n % 1 == 0) {
				return false;
			}
		} return true;
	}
	public static int round(double n) {
		if (n % 10 == 0) {
			return (int)n;
		}
		double decimalpart = n * 10 % 10;
		double wholepart = n - decimalpart/10;
		if (n >= 0) {
			if (decimalpart >= 5.0) {
				n = wholepart + 1;
			} else {
				n = wholepart;
			}
		} else {
			decimalpart = decimalpart*(-1);
			if (decimalpart >= 5.0) {
				n = wholepart - 1;
			} else {
				n = wholepart;
			}
		} return (int)n;
	}
	
	public enum Standing {
		FIRST_YEAR,
		SOPHOMORE,
		JUNIOR,
		SENIOR;
	}
	public static String classYear(Standing stand) {
		switch (stand){
			case FIRST_YEAR:
				return ("Class of 2024");
			case SOPHOMORE:
				return ("Class of 2023");
			case JUNIOR:
				return ("Class of 2022");
			case SENIOR:
				return ("Class of 2021");
		}
		return null;
	}
}
