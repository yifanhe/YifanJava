package Object;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JFrame;
//3.5
// 1 (done); 2 (done); 3 (done); 4 (done); 5 (done);

public class BookShelf {

			public static void main(String[] args) {
				ArrayList<Person> libraryCardHolders = new ArrayList<Person>(); 
				Person person1= new Person("Yifan","He1",true);
				Person person2= new Person("Yifan","He2",false);
				libraryCardHolders.add(person1);
				libraryCardHolders.add(person2);
				Person author1= new Person("Noah","Webster", true);
				Person author2= new Person("Anthony","Burgess",true);
				Person author3= new Person("Phillip","K.","Dick",true);
				//	String[] color = {"Red","Orange","Yellow","Green","Blue","Purple"};
				Book book1=new Book("Dictionary",1002,author1);
				book1.setJacketColor(Color.red);
				Book book2=new Book("Clockwork Orange",749,author2);
				book2.setJacketColor(Color.orange);
				Book book3=new Book("Do Androids Dram of Electric Sheep",500,author3);
				book3.setJacketColor(Color.yellow);
		
				//book5.setJacketColor(Color.blue);
				ArrayList<Book> shelf = new ArrayList<Book>(); 
				shelf.add(book1); 
				shelf.add(book2); 
				shelf.add(book3);
				shelf.add(new Book("The Man in the High Castle", 600, author3));
				Book book5 = new Book("The Minority Report",589,author3);
				shelf.add(0,book5);
				shelf.get(4).setJacketColor(Color.pink);
				book5.setJacketColor(Color.cyan);
				sortByAuthor(true, shelf);
				printAll(shelf);
				Library lib = new Library(shelf, libraryCardHolders);//use "books" or "shelf" whatever your ArrayList is 
				lib.setSize(new Dimension(500,500));
				lib.setVisible(true);
				lib.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		
			public static void sortByAuthor(final boolean ascending, ArrayList<Book> shelf){
				Collections.sort(shelf, new Comparator<Book>() {
					public int compare(Book a, Book b) {
						if(ascending)return a.getAuthor().getLastName().compareTo(b.getAuthor().getLastName());  
						return b.getAuthor().getLastName().compareTo(a.getAuthor().getLastName()); 
					}
				}
						);
			}
			public static void sortByTitle(final boolean ascending, ArrayList<Book> shelf){
				Collections.sort(shelf, new Comparator<Book>() {
					public int compare(Book a, Book b) {
						if(ascending)return a.getTitle().compareTo(b.getTitle());  
						return b.getTitle().compareTo(a.getTitle());
					}
				}
						);
			}
			public static void sortByHeight(final boolean ascending, ArrayList<Book> shelf){
				Collections.sort(shelf, new Comparator<Book>() {
					public int compare(Book a, Book b) {
						if(ascending)return b.getHeight() - a.getHeight();
						return a.getHeight() - b.getHeight();
					}
				}
						);
			}
			public static void sortByPageNumber(final boolean ascending, ArrayList<Book> shelf){
				Collections.sort(shelf, new Comparator<Book>() {
					public int compare(Book a, Book b) {
						if(ascending)return a.getNumbOfPages() - b.getNumbOfPages();
						return b.getNumbOfPages() - a.getNumbOfPages();
					}
				}
						);
			}
			public static void notes(){
		
				/*	
		
				book2.setJacketColor(Color.orange);
		
		
				/** <Book> is a generic type. It tells the constructor WHAT is in the ArrayList.
				 * 			We use generic to save ourselves the trouble of type-casting.
				 * "new ArrayList<?>()" constructor does not need to specify length. 
				 * 			(Default is 10, but it doesn't matter, it adjusts as you add objects to it.)
				 * note that ArrayList IS indexed (item 0 is always at index 0, item 1 is always at index 1, and so on)
				 * You cannot make an ArrayList of primitives (no int, boolean, etc)
				 * 			If you wish to make an ArrayList of ints, you use the wrapper class
				 * 			int is Interger, double is Double, etc
		
				//add things to an ArrayList (remember, for arrays, we did Array[0] = book1; 
				shelf.add(book1); 
				//specify index, book1 is automatically index 0
				shelf.add(book2); 
				shelf.add(book3); 
				//you can construct at the same time:
		
				shelf.add(new Book("The Man in the High Castle", 600, author3));
				System.out.println("The first book on the shelf is" +shelf.get(0)); //lost point if you do this wrong;
				int number = 0;
				Book book5 = new Book("The Minority Report",589,author3);
				shelf.add(0,book5); //add it to the top
				//shelf.remove(0);
				//shelf.remove(book1);
		
			//	String word ="the";
				//removeBook(word,shelf);
		
				for (Book b : shelf){
					System.out.println("the book number is " + number +": "+ b);
					number++;
				}
				//adding Objects at specified indices 
		
				System.out.println("The shelf has " + shelf.size() + " books");
				//to get the length of the arrayList, =array.size()
				//recall using arrays= array.length
		
				//or this loop
				/*for(int i=0; i<shelf.size();i++){
					System.out.println(shelf.get(i));
				}
				if(shelf.contains(book2)){ //contain return true or false; identify whether or not an Object is in the list
					System.out.println(book2.getTitle()+ " is the " + shelf.indexOf(book2)+" on the shelf.");
				}
		
				ArrayList<Book> creepyBooks = new ArrayList<Book>(); 
		
				for(Book b:shelf){
					if(b.getAuthor() ==author3)
					{
						creepyBooks.add(b);
						b.setOnFire();
					}
				}
				//printAll(creepyBooks);
				printAll(shelf);
		
		
			/*public static void removeBook(String word, ArrayList<Book> shelf){
				String word1 = word.toLowerCase();
				for(int i=0; i<shelf.size();i++) // for(int i=shelf.size(); i>-1;i--)
				{
					while(i<shelf.size()&&shelf.get(i).toString().toLowerCase().indexOf(word1)>=0){
						shelf.remove(i);
					}
				}
			}*/
			}
			private static void printAll(ArrayList<?> list){
				for(int i=0; i<list.size();i++){
					System.out.println(list.get(i));
				}
			}

}
