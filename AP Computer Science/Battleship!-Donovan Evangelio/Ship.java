package battleship;

import java.util.*;

public class Ship {
	private int size;
	private List<Tile> occupied_tiles;//Format: "Row: x Col: x"
	private int num_hits;
	
	public Ship(int s_size){
		size = s_size;
		occupied_tiles = new ArrayList<Tile>();
		num_hits = 0;
	}
	
	public Ship(Ship s){
		size = s.size;
		occupied_tiles = new ArrayList<Tile>(s.occupied_tiles);
		num_hits = s.num_hits;
	}
	
	public void set_hits(int num){
		num_hits = num;
	}
	
	public int num_hits(){
		if(num_hits == size){
			return -1;
		}
		return num_hits;
	}
	
	public List<Tile> occupied_tiles(){
		return occupied_tiles;
	}
	
	public void random_place(Tile[][] board){
		int k = 0;
		int dir = (int) (Math.random() * 2);
		int[] buf = genNums(board, dir);
		while(k < this.size){
			if(dir == 0){//Horizontal
				if(board[buf[0]][buf[1] + k].status().equals("Vacant")){//Check if next columns are vacant
					occupied_tiles.add(board[buf[0]][buf[1] + k]);
					k++;
					continue;
				}
			}
			else{//Vertical
				if(board[buf[0] + k][buf[1]].status().equals("Vacant")){//Check if next rows are vacant
					occupied_tiles.add(board[buf[0] + k][buf[1]]);
					k++;
					continue;
				}
			}
			occupied_tiles.clear();
			k = 0;
			buf = genNums(board, dir);
		}
		for(Tile cell : occupied_tiles){
			board[cell.x()][cell.y()].setStatus("Occupied");
		}
	}
	//randomly generate a starting row/column pair 
	private int[] genNums(Tile[][] board, int dir){
		int row = 0, col = 0;
		if(dir == 0){
			row = (int)(Math.random() * board.length);
			do{
				col = (int)(Math.random() * board.length);
			} while(col + this.size >= board.length);
		}
		else{
			col = (int)(Math.random() * board.length);
			do{
				row = (int)(Math.random() * board.length);
			} while(row + this.size >= board.length);
		}
		int[] ret = {row, col};
		return ret;
	}
}
