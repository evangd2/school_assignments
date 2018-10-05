package Welcome;

import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(System.in);
		System.out.print("Enter a number greater than 0: ");
		int number = reader.nextInt();
		reader.close();
		long product = 1;
		int count = 1;
		while (count <= number){
			product *= count;
			System.out.println("Count = " + count + " Number = " + number);
			System.out.println(product);
			count++;
		}
		System.out.println("The factorial of " + number + " is " + product);
		/* The original issue was that any input that yielded a factorial
		 * larger than (2^31) - 1, such as 20, would print a negative value; 
		 * this is because the maximum value for a Java integer is (2^31) - 1.
		 * Changing the type of the variable "product" to a long variable
		 * fixes the issue until the factorial of a given input, greater than
		 * 25 in this case, is greater than (2^63) - 1, the maximum value for
		 * a Java long. */
	}

}
