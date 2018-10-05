package dem_functions;

import java.util.List;

public class PolynomialDerivative extends Polynomial {
	
	private String orig_function;
	
	public PolynomialDerivative(){
		super();
		orig_function = "";
	}
	
	public PolynomialDerivative(String name, List<String> vars, String rep){
		super(name, vars, rep);
		orig_function = "";
	}
	
	public PolynomialDerivative(String name, List<String> vars, String rep, Polynomial p){
		super(name, vars, rep);
		orig_function = p.returnField("str_repr").toString();
	}
	
	public void changeOriginal(String expr){
		orig_function = expr;
	}
	
	public String getOriginal(){
		return orig_function;
	}
	
	public String toString(){
		String str;
		str = super.toString() + "\n"
			+ "Original Function: " + orig_function;
		return str;
	}
	
	public String setDerivative(Polynomial p){
		int y = p.getDegree();
		super.changeDegree(y - 1);
		String res = "";
		for(double x: p.getCoefficients()){
			if(y == 0){
				break;
			}
			double product = x * y;
			super.changeCoefficients("add", product);
			if(y - 1 <= 0){
				res += String.valueOf(product);
			}
			else{
				res += product + "x^"+ (y - 1) + " + ";
			}
			y--;
		}
		return res;
	} 
}
