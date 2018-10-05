package patron;


public class ModifiedPatronTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Array initialization
		System.out.println("*Array initialization\n");
		patron[] patron_list = new patron[5];
		String names[] = {"warecrash", "lechiffre", "demopathos"};
		for(int n = 0; n < names.length; n++){ 
			patron_list[n] = new patron();
			patron_list[n].setName(names[n]);
		}
		
		//Count instantiated patrons
		System.out.println("*Count instantiated patrons\n");
		int patron_count = 0;
		for(patron p: patron_list){
			if(p != null){ //use == to compare reference (from stackoverflow)
				patron_count++;
			}
		}
		System.out.println("Number of active patrons: " + patron_count + "\n");
		
		//Create 9 books
		System.out.println("*Create 9 books\n");
		book[] book_database = new book[9];
		book_database[0] = new book("Clear and Present Danger", "Tom Clancy");
		book_database[1] = new book("Jurassic Park", "Michael Crichton");
		book_database[2] = new book("Harry Potter and The Prisoner Of Azkaban", "J. K. Rowling");
		book_database[3] = new book("Stand By Me", "Stephen King");
		book_database[4] = new book("The Shawshank Redemption", "Stephen King");
		book_database[5] = new book("The Sum of All Fears", "Tom Clancy");
		book_database[6] = new book("The Hunt for Red October", "Tom Clancy");
		book_database[7] = new book("Patriot Games", "Tom Clancy");
		book_database[8] = new book("Ready Player One", "Ernest Cline");
		
		//Book assignment
		System.out.println("*Book assignment\n");
		for(int i = 0; i < book_database.length; i++){
			if(i < 5){
				patron_list[0].checkout(book_database[i]);
			}
			else if(i < 8){
				patron_list[1].checkout(book_database[i]);
			}
			else{
				patron_list[2].checkout(book_database[i]);
			}
		}
		
		//Search and Display [Type: Patron; Query: Title("Ready Player One")]
		String search_param = "Ready Player One";
		System.out.println("*Search by Title (Keyword: " + search_param + "): \n");
		for(int n = 0; n < patron_list.length; n++){
			if(patron_list[n].searchTitle(search_param) == false){
				continue;
			}
			else{
				n = patron_list.length;//Only one patron can have this book
			}
		}
		//Search and Display [Type: Patron; Query: Author("Tom Clancy")]
		search_param = "Tom Clancy";
		System.out.println("*Search by Author (Keyword: " + search_param + "): \n\n");
		for(int n = 0; n < patron_list.length; n++){
			if(patron_list[n] != null){
				patron_list[n].searchAuthor(search_param);
			}
		}
		
		//Patron 1 returns 3 books
		System.out.println("*Patron 1 returns 3 books\n");
		for(int n = 0; n < 3; n++){
			patron_list[0].checkin(book_database[n]);
		}
		
		//Display num_books and book_list for each patron
		System.out.println("*Display num_books and book_list for each patron\n");
		for(int n = 0; n < patron_list.length; n++){
			if(patron_list[n] != null){
				System.out.println(patron_list[n]);
			}
		}
	}

}
