package patron;

import java.util.*;

public class patron {
	
	private String name;
	private book[] book_list;
	private static final int SIZE = 5;

	 //constructor 
	public patron() {
		name = " ";
		book_list = new book[SIZE];
	}

	public void setName(String nombre){
		name = nombre;
	}
	
	public int getCheckouts(){
		int count = 0;
		for(book b: book_list){
			if(b != null){
				count++;
			}
		}
		return count;
	}
//checking out a book
	public void checkout (book bookwanted)
	{	
		if (bookwanted.availability().equals("Available")){
			int n;
			for(n = 0; n < book_list.length; n++){
				if(book_list[n] == null){
					book_list[n] = bookwanted;
					bookwanted.changeAvailibilty(true);
					System.out.println("\"" + this.name + "\" checked out \"" + 
					book_list[n].getTitle() + "\"\n");
					n = book_list.length; //used to exit loop without break
				}
			}
			if(n == book_list.length){ //this means that the for loop exited without assigning a book
				System.out.println("No available slots; maximum number of books checked out");
			}
		}
		else{
			System.out.println("This book is not currently available");
		}
	}
	
	//checking in book
	public void checkin (book bookreturn)
	{
		int i = Arrays.asList(book_list).indexOf(bookreturn);//Alternative is iteration
		if(i != -1){
			book_list[i] = null;
			System.out.println("\"" + this.name + "\" checked in \"" + 
					bookreturn.getTitle() + "\"\n");
		}
		else{
			System.out.println("\"" + this.name + "\" has not checked out \"" + 
					bookreturn.getTitle() + "\"\n");
		}
	}
	
public void status (book nameEnter)
{
	int i = Arrays.asList(book_list).indexOf(nameEnter);//Alternative is iteration
	if(i != -1){
		System.out.println(book_list[i]);
	}
	else{
		System.out.println("\"" + this.name +"\" does not carry this book");
	}
}

public boolean searchTitle(String title){//I used iterators because I wanted to
	Iterator<book> book_itr = Arrays.asList(book_list).iterator();
	book argb;
	boolean _case = false;
	do{
		argb = book_itr.next();
		if(argb != null){
			_case = argb.getTitle().toUpperCase().equals(title.toUpperCase());
			if(_case){
				System.out.println(toString() + "\n");
				return true;
			}
		}
	} while(!(_case) && book_itr.hasNext());
	return false;
}

public boolean searchAuthor(String author){//I used iterators because I wanted to
	Iterator<book> book_itr = Arrays.asList(book_list).iterator();
	book argb;
	boolean _case = false;
	do{
		argb = book_itr.next();
		if(argb != null){
			_case = argb.getAuthor().toUpperCase().equals(author.toUpperCase());
			if(_case){
				System.out.println(toString() + "\n");
				return true;
			}
		}
	} while(!(_case) && book_itr.hasNext());
	return false;
}

	
public String toString(){
	      String str;
	      str = "Name:    " + name  + "\n\n" +
	    		"Number of books checked out:    " + getCheckouts() + "\n\n" +
	    		"Books:\n\n";
	      for(book b : book_list){
	    	  if(b != null){
	    		  str += b.toString() + "\n\n";
	    	  }
	    	  else{
	    		  continue;
	    	  }
	      }
	      return str;
}
	
	
	
	
}

