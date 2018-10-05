package Welcome;

public class pattern3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x;
		for(x = 0; x <= 4; x++){
			for(int i = 0; i <= x - 1; i++){
				System.out.print("- ");
			}
			System.out.print((1 + x) * 2);
			
			for(int j = 4 - x; j >= 1; j--){
				System.out.print(" -");
			}
			
			System.out.println();
		}
		
	}

}

