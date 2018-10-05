package Welcome;

import java.util.Scanner;

public class even_sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter first number: ");
		int num1 = scan.nextInt();
		System.out.println("Enter second number, greater than the first: ");
		int num2 = scan.nextInt();
		scan.close();
		int sum = 0;
		
		if (num1 > num2){
			System.out.println("First number is larger than second");
		} else {
			if (num1 % 2 == 1){
				num1++;
			}
			if (num2 % 2 == 1){
				num2--;
			}
			
			for (int k = num1; k <= num2; k += 2){
				sum += k;
			}
		}
		System.out.println(sum);
	}

}
