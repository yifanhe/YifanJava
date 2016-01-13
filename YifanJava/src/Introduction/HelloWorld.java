package Introduction;
//statics doesn't need to exist. 
//instance method (you need a value to check with other value) "equals" is an instance method
//static reference is not specific to an object but the entire class itself. 
// ".out" 
import java.util.Scanner;

public class HelloWorld {
	static int numberOfMessages = 0; //bc its used in different methods
	static String username;
	static Scanner input = new Scanner(System.in);
	static boolean running;
	
	/**
	 * @param args
	 * 
	 */
	public static void main(String[] args) {		
		promptName();
		endlessConversation();
	/*	print("whats your fav animal?");
		String favAnimal = waitForInput();
		print("thats great " + username + ". I love " + favAnimal + " too.");
	*/
		
	/*	String message ="This is message assigned to message.";
		int number1=5;
		int number2=6;
		
		System.out.println("Hello World");
		System.out.println(number1 + number2);
		System.out.println(8/7);
		
		print("Hello World1");
		print("Hello World2");
		print(number1 + number2);
		print(8/7);
		
		int i;
		for (i=0; i < 5; i++)
		{ 
			System.out.println(2);
			//System.out.println("this loop has repeated" + number3 + "times");
		}
			
		System.out.println("The numbers are " + number1 +" and " + number2 +" Their sum is "+ (number1+number2));
		// TODO Auto-generated method stub
		/** 
		 *This is how to comment;
		 *System.out.println is OVERLOADED (same method with different arguments);
		*/
		
	
		/*
		  Scanner name = new Scanner (System.in); //it declares a variable call name that is an instance of Scanner. Scanner uses System.in as an auguement in its constructor(constructor = new Scanner)
		  System.out.print("Enter your first name: ");
		  String firstname = name.next();
		  System.out.print("Enter your last name: ");
		  String lastname = name.next();
		  String fullname = firstname + " " + lastname;
		  System.out.println("Hello "+ fullname + "!");
	      
		  Scanner ex1 = new Scanner (System.in);
		  System.out.print("Enter your first name: ");
		  String part1 = ex1.next();
		  System.out.print("Enter your first name again: ");
		  String part2 = ex1.next();
		  if (part1 != part2)
		  {
			  System.out.println("You enter two different strings!");
		  }
		  else
		  {
			  System.out.println("You name is: ");
		  } */
	}
		  public static void endlessConversation(){
			  running = true;
			  while (running)
			  {
				  print("What school do you go to?");
				  String school = waitForInputProvideChoices();    // do this way if we need the variable later.
				  if (school.equals("S"))
				  {
					  print("You typed S.");
					  talkAboutBread();
					  
				  }
				  else if (school.equals("Q"))
				  {
					  running = false;
				  }
				  else
				  {
					  print("Oh, so you go to " + school + " ?"); 
				  }
				  //print("Oh, so you go to " + waitForInput() + " ?"); // do this way if we don't need it again.
			  }
		  
		  }
		  public static void print(String string) {
			  System.out.println(string);
			/*  numberOfMessages++;
			  System.out.println(/*"Look, something is printing: " + string+", "it is the "+numberOfMessages+ "st message."); 
			  */ 
			
		  }
		  public static void print(int number) {
			  System.out.println(number);
			/*numberOfMessages++;
			System.out.println(it is the "+numberOfMessages+ "th message."); */
		  }
		  public static String waitForInput(){
			  String entry=input.nextLine();
			  return entry;
		  }
		  public static String waitForInputProvideChoices(){
			  print("You may type the following commands:\n" + // \n means start a new line
					  " \"Q\" - to quit\n" + 
					  " \"S\" - start over");
			  String entry=input.nextLine();
			  return entry;
		  }
		  public static void talkAboutBread(){
			  print("Talk about bread!");
		  }
		  public static void promptName(){
			  print("please enter your name.");
			  username = waitForInput();
			  print("Okay, I will call you" + username + " .");
		  } 
		  

}
