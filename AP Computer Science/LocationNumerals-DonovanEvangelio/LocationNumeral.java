package practiceAPQuestions;
import java.util.*;
public class LocationNumeral {
	public static final String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	public static int getLetterValue(String letter){
		return (letters.contains(letter)) ? (int)(Math.pow(2, letters.indexOf(letter))):-1;
	}
	
	public static String getLetter(int value){
		double l = Math.log(value)/Math.log(2);
		return (l == (int)l && (l>-1 && l<26)) ? letters.substring((int)l, (int)l+1):""; 
	}
	
	public static int getDecimalValue(String numeral){
		int v=0;
		for(int i=0; i<numeral.length(); i++){
			v+=getLetterValue(numeral.substring(i, i+1));
		}
		return v;
	}
	
	public static String sortLocationNumeral(String numeral){
		char[] t = numeral.toCharArray();
		Arrays.sort(t);
		return new String(t);
	}
	
	public static String add_AP(String num1, String num2){
		String oldSum = num1+num2;
		String sum = "";
		while (!sum.equals(oldSum)){
			int i = 0;
			sum = sortLocationNumeral(oldSum);
			while (i < sum.length()-1){
				String currLetter = sum.substring(i, i+1);
				if (currLetter.equals(sum.substring(i+1, i+2))){
					sum = sum.substring(0, i) + getLetter(2*getLetterValue(currLetter)) + sum.substring(i+2);
				}
				else{
					i++;
				}
				oldSum = sum;
				sum = sortLocationNumeral(oldSum);
			}
		}
		return sum;
	}
	
	public static String add_LOG(String num1, String num2){
		String sum = num1+num2;
		int v = getDecimalValue(sum);
		String r = "";
		while (v > 0){
			int exp = (int)(Math.log(v)/Math.log(2));
			r += getLetter((int)Math.pow(2, exp));
			v -= Math.pow(2, exp);
		}
		return sortLocationNumeral(r);
	}
	//random() generates a random numeral with the given length
	public static String random(int length){
		String r = "";
		for(int i=0; i<length; i++){
			r+=getLetter((int)Math.pow(2, (int)(Math.random()*26)));
		}
		return r;
	}
}
