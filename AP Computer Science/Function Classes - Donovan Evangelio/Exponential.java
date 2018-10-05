package dem_functions;

import java.util.List;

public class Exponential extends Function {
	
	private double base;
	private double coefficient;
	private Polynomial exponent;
	
	public Exponential(){
		super();
		base = coefficient = 0.0;
		exponent = new Polynomial();
	}
	
	public Exponential(String name, List<String> vars, String rep){
		super(name, vars, rep);
		base = coefficient = 0.0;
		exponent = new Polynomial();
	}
	
	public Exponential(String name, List<String> vars, String rep, double b, double c, Polynomial p){
		super(name, vars, rep);
		base = b;
		coefficient = c;
		exponent = p;
	}
	
	public void redefineExp(String field, Object value){
		if (field.equals("base")){
			base = (double)value;
		}
		else if (field.equals("coefficient")){
			coefficient = (double)value;
		}
		else if (field.equals("exponent")){
			exponent = (Polynomial)value;
		}
		else{
			System.out.println("That's not a valid option silly");
		}
	}
	
	public Object returnExpField(String field){
		if (field.equals("base")){
			return base;
		}
		else if (field.equals("coefficient")){
			return coefficient;
		}
		else if (field.equals("exponent")){
			return exponent;
		}
		else{
			return("That's not a valid option silly");
		}
	}
	
	public double calculate(double input){
		double res = 0.0;
		res = coefficient * Math.pow(base, exponent.calculate(input));
		return res;
	}
	
	public String toString(){
		String str = "";
		str = super.toString() + "\n"
			+ "Base: " + base + "\n"
			+ "Coefficient: " + coefficient + "\n"
			+ "Exponent: " + exponent.returnField("str_repr");
		return str;
	}
}
