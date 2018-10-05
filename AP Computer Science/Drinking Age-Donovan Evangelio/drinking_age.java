package Welcome;

import java.util.Scanner;

public class drinking_age {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in); 
		System.out.println("Welcome to the bar! How old are you? ");
		int age = scan.nextInt();
		if( age >= 21 ){
			System.out.println("Have a drink!");
		}else{
			System.out.println("Go home kid.");
		}
		}

}
