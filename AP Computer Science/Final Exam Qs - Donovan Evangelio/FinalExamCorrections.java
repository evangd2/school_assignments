/*
Donovan Evangelio
Mr. Diaz
AP Computer Science M1
7 January 2017
							Final Exam Corrections
*/
package stuff;

//Section 1 Question 11 Classes
	class SalesPerson{
		public void sale(){
			System.out.print("greet ");
			pitch();
		}
		public void pitch(){
			System.out.print("pitch ");
		}
	}
	
	class CommissionedSalesPerson extends SalesPerson{
		public void sale(){
			super.sale();
			System.out.print("record ");
		}
		public void pitch(){
			super.pitch();
			System.out.print("close ");
		}
	}
	
//Section 2 Question 10 Classes
	abstract class Movie{
		private String title;
		public Movie(String t){title = t;}
		public String getTitle(){return title;}
		public void setTitle(String t){title = t;}
		public abstract String getRating();
		
	}

	 class MovieWithRating extends Movie{
		private String rating;
		public MovieWithRating(String t, String r){
			super(t);
			rating = r;
		}
		public String getRating(){return rating;}
		public String toString(){
			return this.getTitle() + ", " + rating;
		}
	}
//Section 2 Question 11 Classes
	 class MovieTheater{
		 public static void show(Movie m){
			 System.out.println("Showing: " + m.getTitle());
		 }
		 public static void show(MovieWithRating m){
			 System.out.println("Showing: " + m.getTitle() + ", " + m.getRating());
		 }
	 }

	 

public class FinalExamCorrections {
	
//Section 3 Question 2 Classes
	public static void process(String s){
		s = s.substring(2, 3) + s.substring(1, 2) + s.substring(0, 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Section 1");
		System.out.println(" ");
		/*
	Section 1

		4. C
			Option A can be eliminated because of the first _for_ loop it has:
				for (int j = 6; j < 0; j--){...}
			The code inside will not execute because the condition is false
			to begin with.
			Options B and E can be elimnated because their inner loops include 0 as
			a value when 0 is not included in the pattern.
			Option D has an inner loop that includes 7, which is not included in
			the pattern, leaving Option C to be correct. */ 
			System.out.println("Question 4 Output:");
			for (int j = 0; j < 6; j++){
				for (int k = 6 - j; k > 0; k--){
					System.out.print(k + " ");
				}
				System.out.println(" ");
			}
			System.out.println(" ");
		/*
		8. C
			Options A and E do not use _else if_ statements, leaving the potential
			for code execution to "fall through" consecutive _if_ statements for 
			lower values.
			Option B does not use correct conditional statement syntax.
			Option D does not include 7 and 13 in their respective _else if_
			statements when the table says to include them.*/
			System.out.println("Question 8 Output:");
			String temp = "";
			int age = 2; System.out.println("Age: "+ age);
			if (age < 3){ temp = "Infant";}
			else if (age <= 7){ temp = "Pee-Wee";}
			else if (age <= 13){ temp = "Cub";}
			else if (age > 14){ temp = "Leader";} 
			System.out.println("Temp: "+ temp);
			temp = null;
			System.out.println(" ");
		/*

		**10. B
			Possible combinations of parameters 'x' and 'y' such that all possible
			outcomes of the given code segment are reached:
				('x' is positive, 'y' is positive)
				('x' is negative or 0, 'y' is positive)
				('x' is negative or 0, 'y' is negative) 
				('x' is negative or 0, 'y' is 0)
			Option B contains all of this combinations without redundant 
			combinations.

		11. E
			The SalesPerson variable 'vincent' is actually a 
			CommissionedSalesPerson object, so the subsequent call 'vincent.sale()'
			calls CommissionedSalesPerson.sale(). This calls SalesPerson.sale(),
			printing 'greet ' and then calling pitch(). However, since 'vincent '
			is a CommissionedSalesPerson object, CommissionedSalesPerson.pitch()
			is called. This then calls SalesPerson.pitch(), prints 'pitch ', 
			prints 'close', and then prints 'record ', leading to a final string
			of 'greet pitch close record'.*/
			System.out.println("Question 11 Output:");
			SalesPerson vincent = new CommissionedSalesPerson();
			vincent.sale();
			vincent = null;
			System.out.println(" ");
			System.out.println(" ");
			
			System.out.println("Section 2");
			System.out.println(" ");
		/*
		
	Section 2

		1. D
			The expression set to 'n' is interpreted as -(-3) - (-1) = 4
			Interestingly, the expression '--3 - -1' generates a syntax error.*/
			
			System.out.println("Question 1 Output:");
			int n = - - 3 - -1;
			System.out.println(n);
			System.out.println(" ");
		/*

		3. A
			The statement 's.toUpperCase()' does not change the string 's' without
			assignment, so the final output is 'Lala'.*/
			System.out.println("Question 3 Output:");
			String s = "La";
			s.toUpperCase();
			System.out.println(s + s.toLowerCase());
			System.out.println(" ");
		/*

		9. E
			Option A will not work because the MovieWithRating class doesn't have
			a 'title' variable, and cannot access Movie's private data.
			Options B, C and D will not work because the Movie class has no default
			constructor that can be implicitly called, so none of these 
			substitutions will work.

		10. E
		 	Case I will work by adding the toString() Method to the Movie Class;
		 	since getRating() returns a String regardless of implementation, its
		 	result can be printed even though it is an abstract method.
		 	Case II will work by adding the method to the MovieWithRating Class
		 	using the getTitle() and getRating() methods, which the class has
		 	access to.
		 	Case III will also work; it does the same thing as Case II. Using
		 	'this.getTitle()' is no different than before, and the class has
		 	a private variable called 'rating' that can be used that way. */
			System.out.println("Question 10 Output");
			MovieWithRating m = new MovieWithRating("Monster House", "PG");
			System.out.println(m);
			System.out.println(" ");
		/*
		 11. D 
		 	 All of the code in this question will compile, so Options
		 	 A and B are eliminated.
		 	 Option C can be eliminated because 'm2' is of type 
		 	 MovieWithRating, and passing that class into MovieTheater.show() 
		 	 also prints the rating of the movie.
		 	 Option E can be eliminated because 'm1' is of type Movie, and 
		 	 passing that class into MovieTheater.show() only prints the
		 	 title.*/
			System.out.println("Question 11 Output");
			Movie m1 = new MovieWithRating("Monster House", "PG");
			MovieWithRating m2 = new MovieWithRating("Class Action", "R");
			MovieTheater.show(m1);
			MovieTheater.show(m2);
			System.out.println(" ");
			
			System.out.println(" ");
			
			System.out.println("Section 3");
			System.out.println(" ");
			/*
	Section 3
	
		 2. A
			 Although Strings are Reference Types, they are immutable, so 
			 the reassignment in the process() method actually creates 
			 another String instead of changing s. Since the method doesn't
			 return anything, it cannot change the value of 's'.*/
			System.out.println("Question 2 Output:");
			s = "ABCD";
			process(s);
			System.out.println(s);
			System.out.println(" ");
			/*
		 5. A
			 The method call 's.indexOf(s.substring(n))' returns n, so the
			 code prints the third character of the string.*/
			System.out.println("Question 5 Output:");
			s = "xoxoxo";
			System.out.println(s.substring(s.indexOf(s.substring(2)), s.indexOf(s.substring(3))));
			System.out.println(" ");
			/*
		 8. C
			 The expression '(_m + _n) / 2' evaluates to 4 due to 
			 truncating, and this integer is automatically casted
			 to Double in order to be passed into the method. At the
			 end, 'd' = 2.0 .*/	
			System.out.println("Question 8 Output:");
			int _m = 4, _n = 5;
			double d = Math.sqrt((_m + _n) / 2);
			System.out.println(d);
			System.out.println(" ");
			/*
		 15. C
		 	Hex: 31
			Binary: 110001
			 */	
			System.out.println("Question 15 Output:");
			int x = 49;
			System.out.println("Decimal: " + x + "\n" + 
								"Hex: " + Integer.toHexString(x) + "\n" +
								"Binary: " + Integer.toBinaryString(x));
			System.out.println(" ");
			

	}

}
