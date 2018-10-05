package datnetwork;

public class NetworkTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Start Test Device methods
		System.out.println("Start Device test");
		Device d1 = new Device();
		//Test functionality of the configure() and returnField() methods
		d1.configure("ipv4_address", "10.73.69.4");
		System.out.println(d1.returnField("ipv4_address"));
		d1.configure("ipv4_prefix_length", 27);
		System.out.println(d1.returnField("ipv4_prefix_length"));
		d1.configure("ipv6_address", "2001:db8:cafe:2::2/64");
		System.out.println(d1.returnField("ipv6_address"));
		d1.configure("type", "End Device (PC)");
		System.out.println(d1.returnField("type"));
		d1.configure("name", "Camelot");
		System.out.println(d1.returnField("name"));
		//Make new Device
		d1 = new Device("R1", "Router", "172.16.44.25", "cd2f::a5b2/64", 30);
		System.out.println(d1); 
		System.out.println("End Device test");
		
		//end Device Test
		//Start Switch Test
		
		System.out.println("Start Switch test");
		Switch s1 = new Switch();
		System.out.println(s1.toString());
		//Test constructors
		s1 = new Switch("S1", "Modular", 48, 1000, "Full", "Store-and-forward");
		System.out.println(s1.toString());
		s1 = new Switch("RS1","172.16.44.26","cd2f::a5b3/64", 30);
		//Test Switch-specific methods
		System.out.println(s1.returnSwitchField("form_factor"));
		s1.configureSwitch("duplex", "Full");
		//Test inherited methods
		System.out.println(s1.returnField("ipv4_address"));
		s1.configure("name", "Switch_1");
		System.out.println(s1.toString());
		System.out.println("End Switch test");
		
		//end Switch Test
		//Start Network Test
		System.out.println("Begin Network test");
		Network net1 = new Network();
		System.out.println(net1.toString());
		//Add devices to new network
		net1 = new Network("Best Korea", true, true, "176.16.44.24", "cd2f::a5b1/64", 30);
		net1.manageDevices("add", d1);
		net1.manageDevices("add", s1);
		net1.manageDevices("add", s1);//test error msg
		System.out.println(net1.toString());
		//Remove devices
		net1.manageDevices("remove", s1);
		net1.manageDevices("remove", s1);//test error msg
		net1.manageDevices("add", s1);
		//Change name
		System.out.println(net1.returnField("name"));
		net1.configure("name", "One True Korea");
		System.out.println(net1.toString());
		//End Network Test
	}

}
