package Welcome;

public class pattern4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x;
		for(x = 0; x <= 5; x++){
			for(int j = 5 - x; j > 0; j--){
				System.out.print(((j * 2) + (2 * x) - 1) + " ");
			}
			for(int i = x; i > 0; i--){
				System.out.print(((-i * 2) + 1) + " ");
			}
			System.out.println();
		}
	}

}
