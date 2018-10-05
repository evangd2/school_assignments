package datnetwork;

public class Device {
	/*Device traits
	 * 	-Name
	 * 	-Type
	 * 	-Configuration Type (Static or Dynamic)
	 * 	-IPv4 config
	 * 		-Address
	 * 		-Mask(Prefix length)
	 * 		-Default-gateway
	 * 		-DNS Server
	 * 
	 * Device methods
	 * 	-configure
	 * 	-return field
	 * 	-toString
	 * */
	private String name;
	private String type;
	private String ipv4_address;
	private String ipv6_address;
	private int ipv4_prefix_length;
	
	public Device(){
		name = type = ipv4_address = ipv6_address = "";
		ipv4_prefix_length = 0;
	}
	
	public Device(String nm, String tpe, String addr4, String addr6, int prfx){
		name = nm;
		type = tpe;
		ipv4_address = addr4;
		ipv6_address = addr6;
		ipv4_prefix_length = prfx;
	}
	
	public Device(String nm, String tpe){
		this(nm, tpe, "", "", 0);
	}
	
	public void configure(String field, Object value){//toString instead?
		if(field.equals("name")){
			name = (String)value;
		}
		else if(field.equals("type")){
			type = (String)value;
		}
		else if(field.equals("ipv4_address")){
			ipv4_address = (String)value;
		}
		else if(field.equals("ipv6_address")){
			ipv6_address = (String)value;
		}
		else if(field.equals("ipv4_prefix_length")){
			ipv4_prefix_length = (int)value;
		}
		else{
			System.out.println("Invalid field parameter");
		}
		
	}
	
	public Object returnField(String field){
		if(field.equals("name")){
			return name;
		}
		else if(field.equals("type")){
			return type;
		}
		else if(field.equals("ipv4_address")){
			return ipv4_address;
		}
		else if(field.equals("ipv6_address")){
			return ipv6_address;
		}
		else if(field.equals("ipv4_prefix_length")){
			return ipv4_prefix_length;
		}
		else{
			String error = "Invalid field parameter";
			return error;
		}		
	}
	
	public String toString(){
		String str = "";
		str =   "Name: "+ name + "\n" +
				"Type: " + type + "\n" +
				"IPv4 Address: " + ipv4_address + "\n" +
				"IPv6 Address: " + ipv6_address + "\n" + 
				"IPv4 Prefix Length: " + ipv4_prefix_length + "\n\n";
		return str;
	}
}
