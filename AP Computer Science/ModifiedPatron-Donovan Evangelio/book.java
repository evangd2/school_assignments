package patron;

public class book {

	private String title1;
	private String author1; 
	private String barrowed;
	
	//constuctor
	public book ()
	{
		title1 = "";
		author1 = "";
		barrowed = "UnAvailable";
	}
	
	
	public book (String t1, String a1) {
		title1 = t1;
		author1 = a1;
		barrowed ="Available";
		}

	 public String getTitle (){
		   
		 
		     return title1; 
		   }
	
	
	 public String getAuthor (){
		   
	       return author1; 
	   }

	 public String availability (){
		  if (barrowed == "Available")
			  return "Available";
		  else
			  return "Not Available";      
	   }
	 
	
	 public String toString(){
		   //Construct and return a string representation of the student
		      String str;
		      str = "Title:    " + title1  + "\n" +    // "\n" denotes a newline
		            "Author:   " + author1 + "\n" +
		        
		            "Status:   " + barrowed;
		      return str;
	}
	 
	public void modAuthor (String author)
	{
		author1 = author;
		
	}
	
	public void changeAvailibilty (boolean check)
	{
		if (check == true)
			barrowed = "Not Available";
		else
			barrowed = "Available";		
	}

	
}


