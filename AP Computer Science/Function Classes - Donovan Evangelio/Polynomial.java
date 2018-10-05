package dem_functions;

import java.util.*;

public class Polynomial extends Function {
	private int degree;
	private List<Double> coefficients;
	
	public Polynomial(){
		super();
		degree = 0;
	}
	
	public Polynomial(String name, List<String> vars, String rep){
		super(name, vars, rep);
		degree = 0;
		coefficients = new ArrayList();
	}
	
	public Polynomial(String name, List<String> vars, String rep, int deg, List<Double> k){
		super(name, vars, rep);
		degree = deg;
		coefficients = k;
	}
	
	public void changeDegree(int arg){
		degree = arg;
	}
	
	public void changeCoefficients(String action, double value){
		if(action.equals("add")){
			coefficients.add(value);
		}
		else if(action.equals("remove")){
			coefficients.remove(value);
		}
		else{
			System.out.println("That's not a valid option silly");
		}
	}
	
	public int getDegree(){
		return degree;
	}
	
	public List<Double> getCoefficients(){
		return coefficients;
	}
	
	public double calculate(double input){
		double res = 0;
		int y = 0;
		for(double x: coefficients){
			res += x * Math.pow(input, (degree - y));
			y++;
		}
		return res;
	}
	
	public String toString(){
		String str = "";
		str = super.toString() + "\n"
			+ "Degree:" + degree + "\n"
			+ "Coefficients: \n" + coefficients;
		return str;
	} 
}
