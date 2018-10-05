package dem_functions;

import java.util.*;

public class FunctionTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Create 3 Functions(Test default constructors)
		Polynomial fx = new Polynomial();//Look at this super cool dynamic binding
		PolynomialDerivative gx = new PolynomialDerivative();
		Exponential hx = new Exponential();
		System.out.println(fx.toString() + "\n\n" + gx.toString() + "\n\n" + hx.toString());//print empty function
		sectionBreak();//prints like 40 slashes
		
		//Re-instance each function to test chaining constructors
		//Constructor didn't work with literal arrays, so I assigned them to variables
		List<String> x = new ArrayList();//Value for Function.details
			x.add("input: time");
			x.add("units: m");
		List<Double> y = new ArrayList();//Value for Polynomial.coefficients
			y.add(-4.9);
			y.add(10.0);
			y.add(170.0);
		fx = new Polynomial("Position", x, "s(t)= -4.9t^2 + 10t + 170", 2, y);
		x = new ArrayList();//Value for Function.details
			x.add("input: time");
			x.add("units: m/s");
		gx = new PolynomialDerivative("Velocity", x, "v(t)= -9.8t + 10", (Polynomial)fx);
		y = new ArrayList();//Value for Polynomial.coefficients
			y.add(0.1);
		Polynomial arg_p = new Polynomial("Exponent", x, "0.1x", 1, y);//polynomial argument for Exponential constructor
		hx = new Exponential("Frank's love for humanity over time", x, "3 * 2^0.1x", 2.0, 3.0, arg_p);
		System.out.println(fx.toString() + "\n\n" + gx.toString() + "\n\n" + hx.toString());//Print results of above constructors
		sectionBreak();
		
		//Test the mutators and getters of each class, and use methods from superclass
		//Polynomial
		System.out.println(fx.returnField("function_name") + " with input of 2: " + fx.calculate(2.0));//print name of function and its value with a given input
		fx.redefine("function_name", "goofed");//superclass redefinition method
		fx.changeCoefficients("remove", 170);
		fx.changeDegree(1);
		System.out.println(fx.returnField("function_name") + " " + fx.getDegree() + " " + fx.getCoefficients());
		fx.changeCoefficients("add", 170);
		fx.changeDegree(2);
		System.out.println(fx);
		sectionBreak();
		//Derivative
		gx.redefine("str_repr", gx.setDerivative(fx));//setDerivatives uses changeCoefficients from Polynomial class to 
													  //change its coefficients and generate a string representation
		gx.changeOriginal((String)fx.returnField("function_name"));
		System.out.println(gx.returnField("str_repr"));
		System.out.println(gx.getCoefficients());
		System.out.println(gx.returnField("function_name") + " with input of 2: " + gx.calculate(2.0));
		System.out.println(gx);
		sectionBreak();
		//Exponential
		x = new ArrayList();//Value for Function.details
			x.add("input: time in millenia");
			x.add("units: satisfaction");
		hx.changeDetails("remove", "input: time");
		hx.changeDetails("remove", "units: m/s");
		hx.changeDetails("add", x.get(0));
		hx.changeDetails("add", x.get(1));
		System.out.println(hx.returnField("details"));
		hx.redefineExp("base", 1.96);
		hx.redefineExp("coefficient", 0.03);
		hx.redefine("str_repr", "0.03 * 1.96^0.1x");
		System.out.println(hx.calculate(10));
		System.out.println(hx);
	}
	
	public static void sectionBreak(){//divides each section of the tester
		for(int i = 1; i <= 40; i++){
			System.out.print("/");
		}
		System.out.println();
	}
}
