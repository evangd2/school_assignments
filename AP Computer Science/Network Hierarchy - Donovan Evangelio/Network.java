package datnetwork;

import java.util.*;

public class Network {
	private String name;
	private boolean DHCP_enabled;
	private boolean NAT_enabled;
	private String ipv4_address;
	private String ipv6_address;
	private int ipv4_prefix_length;
	private List<Device> devices;//From "extensive" google research, a list/ArrayList can change in size, which is needed for network scalability
	
	public Network(){
		name = ipv4_address = ipv6_address = "";
		DHCP_enabled = NAT_enabled = false;
		ipv4_prefix_length = 0;
		devices = new ArrayList<Device>();
	}
	
	public Network(String nm, boolean dhcp, boolean nat, String v4, String v6, int prfx){
		name = nm;
		DHCP_enabled = dhcp;
		NAT_enabled = nat;
		ipv4_address = v4;
		ipv6_address = v6;
		ipv4_prefix_length = prfx;
		devices = new ArrayList<Device>(((int)Math.pow(2, (32 - prfx))) - 2);		
	}
	
	public Network(String nm, int num_hosts){
		this(nm, false, false, "", "", (32 - (int)Math.ceil((Math.log(num_hosts) / Math.log(2)))));
		/*That previous garbage was just making sure that the
		 * prefix length is 32 - log2(number of hosts); I needed to use
		 * change of base bc Java is too cool for different bases*/
	}
	
	public void configure(String field, Object value){ //DON'T configure devices with this method
		if(field.equals("name")){
			name = (String)value;
		}
		else if(field.equals("DHCP_enabled")){
			DHCP_enabled = (boolean)value;
		}
		else if(field.equals("NAT_enabled")){
			NAT_enabled = (boolean)value;
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
		else if(field.equals("ipv4_prefix_length")){
			ipv4_prefix_length = (int)value;
		}
		else{
			System.out.println("Invalid field parameter");
		}
		
	}
	
	public void manageDevices(String action, Device d1){
		if(action.equals("add")){
			if(devices.size() == ((int)Math.pow(2, (32 - ipv4_prefix_length)) - 2)){
				System.out.println("Maxmium amount of devices reached");
			}
			else{
				devices.add(d1);
			}
		}
		else if(action.equals("remove")){
			if(!(devices.contains(d1))){
				System.out.println("The specified device is not in this network");
			}
			else{
				devices.remove(d1);
			}
		}
		else{
			System.out.println("Invalid action");
		}
	}
	
	public Object returnField(String field){
		if(field.equals("name")){
			return name;
		}
		else if(field.equals("DHCP_enabled")){
			return DHCP_enabled;
		}
		else if(field.equals("NAT_enabled")){
			return DHCP_enabled;
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
		else if(field.equals("devices")){
			return devices;
		}
		else{
			String error = "Invalid field parameter";
			return error;
		}		
	}
	
	public String toString(){
		String str = "";
		str =   "Name: "+ name + "\n" +
				"DHCP Enabled: " + DHCP_enabled + "\n" +
				"NAT Enabled: " + NAT_enabled + "\n" +
				"IPv4 Address: " + ipv4_address + "\n" +
				"IPv6 Address: " + ipv6_address + "\n" + 
				"IPv4 Prefix Length: " + ipv4_prefix_length + "\n\n" +
				"Devices:\n" + devices+ "\n";
		return str;
	}
}
