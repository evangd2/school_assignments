package Welcome;

public class pattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 5;
		int z = 0;
		while (z <= 5){
			while (x >= 1){
				int y = x * 2;
				System.out.print(y + " ");
				x--;
			}
			z++;
			x = 5 - z;
			System.out.println();
		}
	}

}
