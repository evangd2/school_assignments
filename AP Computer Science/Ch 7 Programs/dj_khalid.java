package Welcome;

import java.util.Scanner;

public class dj_khalid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		while(true){
			System.out.println("Enter starting salary (or enter -69420 to end the program): ");
			int salary = scan.nextInt();
			if(salary == -69420){
				break;
			}
			int raise = salary;
			System.out.println("%\tY1\tY2\tY3");
			
			for(int k = 3; k <= 6; k++){
				double percent = (double) k / 100;
				System.out.print(k + "\t");
				for(int j = 1; j<= 3; j++){
					raise += (raise * percent);
					System.out.print("$" + raise + "\t");
				}
				raise = salary;
				System.out.println();
			}
		}
		scan.close();
	}

}
