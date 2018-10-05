package dem_functions;

import java.util.*;

public abstract class Function {
	private String function_name;
	private List<String> details;//Rename?
	private String str_repr; //String representation
	
	public Function(){
		function_name = str_repr = "";
	}
	
	public Function(String name, List<String> vars, String rep){
		function_name = name;
		str_repr = rep;
		details = vars;
		
	}
	
	public void redefine(String field, String value){
		//IMPORTANT: Only use primitives, Java APIs, or final classes with the Object parameter
		//Also don't use 
		if(field.equals("function_name")){
			function_name = (String)value;
		}
		else if(field.equals("str_repr")){
			str_repr = (String)value;
		}
		else{
			System.out.println("That's not a valid option silly");
		}
	}
	
	public void changeDetails(String action, String value){
		if(action.equals("add")){
			details.add(value);
		}
		else if(action.equals("remove")){
			details.remove(value);
		}
		else{
			System.out.println("That's not a valid option silly");
		}
	}
	
	public Object returnField(String field){
		if(field.equals("function_name")){
			return function_name;
		}
		else if(field.equals("details")){
			return details;
		}
		else if(field.equals("str_repr")){
			return str_repr;
		}
		else{
			return("That's not a valid option silly");
		}
	}
	
	public abstract double calculate(double input);
	
	public String toString(){
		String str = "";
		
		str = "Name: " + function_name + "\n"
			+ "Details: \n" + details + "\n"
			+ "Defined As: " + str_repr;
		
		return str;
	}
}
