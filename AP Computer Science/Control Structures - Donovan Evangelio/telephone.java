package Welcome;

import java.util.Scanner;

public class telephone {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the length of the call in minutes:");
		int t = scan.nextInt();
		scan.close();
		double ct = (0.50 * (t - 2)) + 1.15;
		System.out.println("Cost: $" + ct);
	}

}
