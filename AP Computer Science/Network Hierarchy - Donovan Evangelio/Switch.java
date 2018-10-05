package datnetwork;

public class Switch extends Device{
	private String form_factor;
	private int port_density;
	private int port_speed;
	private String duplex;
	private String forwarding_method;
	
	public Switch(){
		super();
		form_factor = "";
		port_density = 0;
		port_speed = 0;
		duplex = "";
		forwarding_method = "";
	}
	
	public Switch(String nm, String addr4, String addr6, int prfx){
		super(nm, "Switch", addr4, addr6, prfx);
		form_factor = "Fixed";
		port_density = 12;
		port_speed = 100;
		duplex = "Auto";
		forwarding_method = "Store-and-forward";
	}
	
	public Switch(String nm, String form, int density, int speed, String dplx, String method){
		super(nm, "Switch", "", "", 0);
		form_factor = form;
		port_density = density;
		port_speed = speed;
		duplex = dplx;
		forwarding_method = method;
	}
	
	public void configureSwitch(String field, Object value){
		if(field.equals("form_factor")){
			form_factor = (String)value;
		}
		else if(field.equals("port_density")){
			port_density = (int)value;
		}
		else if(field.equals("port_speed")){
			port_speed = (int)value;
		}
		else if(field.equals("duplex")){
			duplex = (String)value;
		}
		else if(field.equals("forwarding_method")){
			forwarding_method = (String)value;
		}
		else{
			System.out.println("Invalid field parameter");
		}
		
	}
	
	public Object returnSwitchField(String field){
		if(field.equals("form_factor")){
			return form_factor;
		}
		else if(field.equals("port_density")){
			return port_density;
		}
		else if(field.equals("port_speed")){
			return port_speed;
		}
		else if(field.equals("duplex")){
			return duplex;
		}
		else if(field.equals("forwarding_method")){
			return forwarding_method;
		}
		else{
			String error = "Invalid field parameter";
			return error;
		}
		
	}
	
	public String toString(){
		String str = "";
		str =   super.toString() +
				"Form Factor: "+ form_factor + "\n" +
				"Port Density: " + port_density + "\n" +
				"Port Speed: " + port_speed + "\n" +
				"Duplex: " + duplex + "\n" + 
				"Forwarding Method: " + forwarding_method + "\n";
		return str;
	}

}
