package battleship;

public class Tile {
	private String status;
	private int x_val, y_val;
	
	public Tile(int x, int y){
		status = "Vacant";
		x_val = x;
		y_val = y;
	}
	
	public int x(){
		return x_val;
	}
	
	public int y(){
		return y_val;
	}
	
	public String status(){
		return status;
	}
	
	public void setStatus(String stat){
		status = stat;
	}
	
	public String toString(){
		if(status.equals("Vacant")){
			return(" . ");
		}
		else if(status.equals("Occupied")){
			return(" + ");
		}
		else if(status.equals("Hit")){
			return(" X ");
		}
		else {
			return(" O ");
		}
	}
}
