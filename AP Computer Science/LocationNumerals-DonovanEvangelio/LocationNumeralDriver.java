package practiceAPQuestions;
import java.io.*;
public class LocationNumeralDriver {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		/*Completed: Test helper methods
		System.out.println(LocationNumeral.getLetterValue("F"));//32
		System.out.println(LocationNumeral.getDecimalValue("AAAB"));//5
		System.out.println(LocationNumeral.sortLocationNumeral("OFFABZ"));//ABFFOZ
		System.out.println(LocationNumeral.getLetter(16));//E
		System.out.println(LocationNumeral.random(10));
		*/
		FileWriter file = new FileWriter("output.txt");
		BufferedWriter buffer = new BufferedWriter(file);
		buffer.write(String.format("%s:\t%-24s%-24s%s\n\n","Test#", "add_AP()", "add_LOG()", "Match?"));
		
		int numTests=100, k=1, size=10;
		while(k<=numTests){
			String n1=LocationNumeral.random(size),
					n2=LocationNumeral.random(size),
					log=LocationNumeral.add_LOG(n1, n2),
					ap=LocationNumeral.add_AP(n1, n2);
			boolean match = log.equals(ap);
			buffer.write(String.format("%5d:\t%-24s%-24s%s\n", k, ap, log, match));
			k++;
		}
		buffer.close();
	}

}
