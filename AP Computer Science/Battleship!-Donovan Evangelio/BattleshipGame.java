package battleship;
import java.util.*;
public class BattleshipGame {
	
	public static int shoot(Tile[][] board, Ship[] fleet, int x, int y){
		for(int i = 0; i < fleet.length; i++){
			if(fleet[i] != null){
				for(Tile t: fleet[i].occupied_tiles()){
					if(x == t.x() && y == t.y()){
						System.out.println("Result: Hit\n");
						t.setStatus("Hit");
						fleet[i].set_hits(fleet[i].num_hits() + 1);
						
						if(fleet[i].num_hits() == -1){
							System.out.println("Ship has sunk!\n");
							fleet[i] = null;
						}
						return 1;
					}
				}
			}
		}
		System.out.println("Result: Miss\n");
		board[x][y].setStatus("Miss");
		return 0;
	}
	
	public static int true_length(Ship[] fleet){
		int c = 0;
		for(Ship s: fleet){
			if(s != null){
				c++;
			}
		}
		return c;
	}
	
	public static void printBoard(Tile[][] board, boolean hide_ships){
		System.out.print("   ");
		for(int i = 0; i < board.length; i++){
			System.out.print(" "+ i + " ");
		}
		System.out.println();
		
		for(int i = 0; i < board.length; i++){
			System.out.print( i + " |");
			for(int j = 0; j < board[0].length; j++){
				if(hide_ships && board[i][j].status().equals("Occupied")){
					System.out.print(" . ");
				}
				else{
					System.out.print(board[i][j]);
				}
			}
			System.out.print("|\n");
		}
		//System.out.println("\nLegend:\n\n- : Vacant\n+ : Occupied\nX : Hit\nO : Miss\n");
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		//Create game board
		System.out.println("Creating game boards...");
		Tile[][] CPU_board = new Tile[10][10];
		Tile[][] User_board = new Tile[10][10];
		for(int r = 0; r < CPU_board.length; r++){
			for(int c = 0; c < CPU_board[0].length; c++){
				CPU_board[r][c] = new Tile(r, c);
				User_board[r][c] = new Tile(r, c);
			}
		}
		
		//Create Game Objects
		System.out.println("Creating ships...");
		Ship[] game_pieces = 
			{new Ship(2), 
			new Ship(3),
			new Ship(3),
			new Ship(4),
			new Ship(4)};
		
		Ship[] CPU_Ships = new Ship[5];
		Ship[] User_Ships = new Ship[5];
		
		for(int i = 0; i < 5; i++){
			CPU_Ships[i] = new Ship(game_pieces[i]);
			User_Ships[i] = new Ship(game_pieces[i]);
		}
		
		//Place Objects (Random Place)
		System.out.println("Placing CPU ships...");
		for(Ship piece: CPU_Ships){
			piece.random_place(CPU_board);
		} 
		
		for(Ship piece: User_Ships){
			piece.random_place(User_board);
		} 

		//Begin game loop
		boolean game_running = true;
		//Board legend
		System.out.println("\nLegend:\n\n- : Vacant\n+ : Occupied\nX : Hit\nO : Miss\n");
		//Coordinate variables
		int x = 0, y = 0;
		
		while(game_running){
			//Evaluate game condition
			if(true_length(User_Ships) == 0){
				System.out.println("Game Over: You Lose");
				game_running = false;
				continue;
			}
			else if(true_length(CPU_Ships) == 0){
				System.out.println("Game Over: You Win");
				game_running = false;
				continue;
			}
			//Print boards
			System.out.println("\nCPU Board");
			printBoard(CPU_board, true);//IMPORTANT:To test end game (victory conditions), set the boolean
			//parameter to true to see the CPU Ships
			System.out.println("\nUser Board");
			printBoard(User_board, false);
			//Menu
			//Note: The try{} and catch(){} statements are intended to catch invalid input
			//before it interrupts the game
			System.out.println("\n1) Shoot  2) CPU Ships Remaining  3) User Ships Remaining  4) Quit");
			try{
				String response = input.nextLine();
				if(Integer.valueOf(response) == 1){
					System.out.println("Enter coordinates in the following format: RowColumn (ex: 34)");
					int t = -1;
					while(t == -1){
						response = input.nextLine();
						if(response.length() == 2){
							try{
								x = Integer.valueOf(response.substring(0, 1));
								y = Integer.valueOf(response.substring(1, 2));
								System.out.println("User fires at Row "+ x + " Column " + y);
								t = shoot(CPU_board, CPU_Ships, x, y);
							}
							catch(NumberFormatException e){
								System.out.println("Invalid coordinates; try again");
								continue;
							}
						}
					}
				}
				else if(Integer.valueOf(response) == 2){
					System.out.println("Number of Remaining CPU ships: " + true_length(CPU_Ships));
					continue;
				}
				else if(Integer.valueOf(response) == 3){
					System.out.println("Number of Remaining User ships: " + true_length(User_Ships));
					continue;
				}
				else if(Integer.valueOf(response) == 4){
					game_running = false;
					continue;
				}
				else{
					System.out.println("Invalid option; try again");
					continue;
				}
			}
			catch(NumberFormatException e){
				System.out.println("Invalid option; try again");
				continue;
			}
			//CPU fires
			x = (int)(Math.random() * User_board.length);
			y = (int)(Math.random() * User_board.length);
			System.out.println("CPU fires at Row "+ x + " Column " + y);
			shoot(User_board, User_Ships, x, y);
		}
		
	}

}
