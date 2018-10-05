package Welcome;

import java.util.Scanner;

public class exponent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a base number:");
		int base = scan.nextInt();
		System.out.println("Enter an exponent number:");
		int exp = scan.nextInt();
		
		/*if (exp != 0){
			for (int j = 1; j <= exp; j++){
				System.out.println((int)Math.pow((double)base, (double)j));
			}
		}else{
			System.out.println("1");
				}*/
		
		int j = 1;
		if (exp != 0){
			while (j <= exp){
				System.out.println((int)Math.pow((double)base, (double)j));
				j++;
			}
		}else{
				System.out.println("1");
			}
			
		}
	}


