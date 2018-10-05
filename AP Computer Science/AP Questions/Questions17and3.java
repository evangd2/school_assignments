package pckg;

public class Questions17and3 {
	
	public static class Fish {
		public String endoskeleton = "bone";
		
		public void action(){
			System.out.println("splash splash");
		}
	}
	
	public static class Shark extends Fish {
		public String endoskeleton = "cartilage";
		
		public void action(){
			System.out.println("chomp chomp");
		}
	}

	public static class A {
		public A () { methodOne(); }
		public void methodOne() {System.out.print("A");}
	}
	
	public static class B extends A {
		public B () { System.out.print("*"); }
		public void methodOne() {System.out.print("B");}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Question 17
		Fish Bob = new Shark();
		System.out.println(Bob.endoskeleton);
		Bob.action();
		
		/*	Output:
		 * 
		 * 		bone
				chomp chomp
				
			Reason:
				When a static subclass is dynamically bound
				to a static superclass variable (like above),
				references to class data revert to the superclass,
				which is why the "endoskeleton" of the supposedly
				"Shark" object was actually "bone". However, 
				polymorphism still applies to method calls, and subclass
				method calls will invoke the subclass method.
		 * */
		
		//Question 3
		A obj = new B();
		
		/*	Output:
		 * 		
		 * 		B*
		 * 	
		 * 	Reason:
		 * 		When a subclass object is instantiated and 
		 * 		dynamically bound to a superclass variable,
		 * 		the default constructor of the superclass is 
		 * 		called in addition to the constructor used for
		 * 		the subclass object. This explains why "B" is 
		 * 		printed out: the line of code first calls the
		 * 		A default constructor, which then calls 
		 * 		B.methodOne(), prints B, and then the B 
		 * 		default constructor is called, printing the
		 * 		asterisk.  
		 * */
	}

}
