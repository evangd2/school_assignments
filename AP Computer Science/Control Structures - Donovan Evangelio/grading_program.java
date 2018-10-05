package Welcome;

import java.util.Scanner;

public class grading_program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the student's percentage grade: ");
		float percent = scan.nextFloat();
		scan.close();
		if(percent < 0){
			System.out.print("Enter a valid percentage.");
		} else {
			System.out.print("The student's letter grade is an ");
			if(percent >= 97){
				System.out.println("A+");
			} else if(percent >= 93){
				System.out.println("A");
			} else if(percent >= 90){
				System.out.println("A-");
			} else if(percent >= 87){
				System.out.println("B+");
			} else if(percent >= 83){
				System.out.println("B");
			} else if(percent >= 80){
				System.out.println("B-");
			} else if(percent >= 77){
				System.out.println("C+");
			} else if(percent >= 73){
				System.out.println("C");
			} else if(percent >= 70){
				System.out.println("C-");
			} else if(percent >= 67){
				System.out.println("D+");
			} else if(percent >= 63){
				System.out.println("D");
			} else if(percent >= 60){
				System.out.println("D-");
			} else {
				System.out.println("F");
			}
		}
		
	}

}
