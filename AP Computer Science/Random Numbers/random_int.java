package stuff;

import java.util.*;

public class random_int {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(System.in);
		Random generator = new Random();
		System.out.println("Enter an integer to generate a random number from the specified ranges, or enter -1 to quit.");
		//0 to 75
		int input;
		while(true){
			input = reader.nextInt();
			if(input == -1){
				reader.close();
				break;
			}
			System.out.println("Range 0 to 75: " + generator.nextInt(75));
			System.out.println("Range 0.0 to 99.0: " + (Math.round((generator.nextDouble() * 100 - 1) * 10d) / 10d));
			System.out.println("Range 35 to 75: " + (generator.nextInt(40) + 35));
			System.out.println("Range -50 to 50: " + (generator.nextInt(100) - 50));
			System.out.println("Range 1 to 101: " + (generator.nextInt(100) + 1));
		}
	}

}
