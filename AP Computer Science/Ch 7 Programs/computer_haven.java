package Welcome;

import java.util.Scanner;

public class computer_haven {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner goof = new Scanner(System.in);
		System.out.println("Enter number of registrants: ");
		int num = goof.nextInt();
		int price = 0;
		goof.close();
		
		if (num % 4 == 0){
			price = (num / 4) * 400;
		} else if (num % 2 == 0){
			price = ((num / 4) * 400) + ((num % 4 / 2) * 300);
		} else {
			price = ((num / 4) * 400) + (((num - 1) % 4) * 300) + 150;
		}
		
		double avg = (double)price / num;
		System.out.print("Cost: " + price + " | Average Cost: " + Math.round(avg * 100d)/100d);
	}

}
