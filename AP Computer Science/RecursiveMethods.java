package recursion;

public class RecursiveMethods {
	
	public static int gcd(int a, int b){ //Calculate GCD using Euclidean algorithm
		if(a == 0){
			return b;
		}
		else if(b == 0){
			return a;
		}
		else{ 
			if (a > b){ //this allows parameters to be entered in any order
				return gcd(b, a % b);
			}
			else{
				return gcd(a, b % a);
			}
		}
	}
	
	public static String reverse(String s){ //reverses a string
		String str = "";
		if(s.length() == 1){
			str = s;
		}
		else{
			str += reverse(s.substring(1)) + s.charAt(0);
		}
		return str;
	}
	
	public static int int_logarithm(int arg, int base){
		/*Calculates integer logarithm of a given number with a given base, rounding the answer up to nearest
			integer
			Ex: Max number of guesses to find item in field of 1024 items using binary search: 10
			    Max for field of 1100 items: 11
		*/
		int count = 0;
		if(arg % base != 0){
			count = 1;
		}
		if(arg == 1 || arg == 0){
			return 0;
		}
		else{
			count++;
			count += int_logarithm(arg / base, base);
		}
		return count;
		
	}
	
	public static void main(String[] args){
		int c = 100, k = 12;
		System.out.println(gcd(c, k));
		
		String s = "string";
		System.out.println(reverse(s));
		System.out.println(int_logarithm(64, 2));
		System.out.println(int_logarithm(65, 2));
	}
}
