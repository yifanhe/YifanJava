package Object;

import java.util.ArrayList;

public class Person {
	private String firstName;
	private String lastName;
	private String middleName;
	public static int MAX_ALLOWED_BOOKS = 3;
	private ArrayList<Book> checkedOutBooks; 
	boolean male;
	private Balance balance; 
	
	public Balance getBalance() {
		return balance;
	}

	public boolean isMale() {
		return male;
	}

	public void setMale(boolean male) {
		this.male = male;
	}

	public ArrayList<Book> getCheckedOutBooks() {
		return checkedOutBooks;
	}
	
	//constructor- take parameters and assign them to lasting variables 
	//mp return type: it "returns" a person 
	public Person(String firstName, String lastName, boolean gender){
		this.firstName = firstName; //assigns firstName to the fN parameter.
		middleName=""; //default middle name
		this.lastName = lastName; //this is used to specify the FIELD, 
		//whereas lastName (by itself) is the local parameter.
		checkedOutBooks = new ArrayList<Book>(); 
		male = true;
		balance = new Balance();
	}
	//constructor for middle-named people
	public Person(String firstName, String middleName, String lastName, boolean gender){
		this.firstName=firstName;
		this.middleName=middleName;
		this.lastName = lastName;
		checkedOutBooks = new ArrayList<Book>();
		male = true;
		balance = new Balance();
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public String toString(){
		return firstName+" " +middleName+" "+lastName;
	}
   public void checkOutBook(Book book) {
	   book.setCheckedOut(true);
	   book.setCheckOutDate(System.currentTimeMillis());
	   book.setDueDate(System.currentTimeMillis()+30000);
	   checkedOutBooks.add(book);
   }
   public void returnBook(Book book){
	   book.setCheckedOut(false);
	   book.setCheckOutDate(0);
	   book.setDueDate(0);
	   checkedOutBooks.remove(book);
	   book.updateCondition(System.currentTimeMillis());
	   balance.subtractLateFees(book.getDueDate()-System.currentTimeMillis());
   }
   public void renewBook(Book book){
	   book.setDueDate(System.currentTimeMillis()+30000);
   }
   public String getGenderPosessivePronoun(){
	   if(male)return "his";
	   return "her";

   }
   public String getLibraryDescription(){
	   return firstName + "is viewing the library collection." +
	   		" His balance is " + balance.getAmount() ; 
	   
   }
}
