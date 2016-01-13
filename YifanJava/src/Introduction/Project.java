package Introduction;

import java.util.Scanner;

public class Project {
	
	static Scanner input = new Scanner(System.in);
	static boolean choosing;
	
	public static void main(String[] args) {
		print("You may type the following commands:\n" + // \n means start a new line
				 " \"L\" - Turn Left \n" + 
				  " \"R\" - Turn Right"
			   );
		String entry=input.nextLine();
		String choosing1 = entry; 
		if (choosing1.equals("L"))
		  {
			  turnLeft();
		  }
		  else if (choosing1.equals("R"))
		  {
			  print("You typed R.");
			  turnRight();
		  }
		  else
		  {
			  print("You need to type R or L.");
		  }
		
	}
	
	public static void turnLeft(){
		print("You turned left; You see your mom buying food; You will: \n" + // \n means start a new line
				 " \"L\" - Say Hi to mom \n" + 
				  " \"R\" - Continue Walking"
			   );
		String entry=input.nextLine();
		String choosing1 = entry; 
		if (choosing1.equals("L"))
		  {
			print("And now you are going home with mom. Have fun!");
		  }
		else if (choosing1.equals("R"))
		  {
			  walkingStraight();
		  }
		else
		  {
			  print("You need to CHOOSE a correct letter!.");
		  }

	}
	public static void walkingStraight(){
		print("You walked straigt. You now remember you have a hangout today. You will: \n" + // \n means start a new line
				 " \"L\" - Hang out with friends! \n" + 
				  " \"R\" - Go home and sleep and eat"
			   );
		String entry=input.nextLine();
		String choosing1 = entry; 
		if (choosing1.equals("L"))
		  {
			print("You had a great time with your friends!");
		  }
		else if (choosing1.equals("R"))
		  {
			print("Awww there was no food at home so you went to sleep. Goodnight!");
		  }
		else
		  {
			  print("You need to CHOOSE a correct letter!.");
		  }
	}
	
	
	
	public static void turnRight(){
		print("You turned right. You now remember you have a hangout today. You will: \n" + // \n means start a new line
				 " \"L\" - Hang out with friends! \n" + 
				  " \"R\" - Go home and sleep and eat"
			   );
		String entry=input.nextLine();
		String choosing1 = entry; 
		if (choosing1.equals("L"))
		  {
			print("You had a great time with your friends!");
		  }
		else if (choosing1.equals("R"))
		  {
			print("Awww there was no food at home so you went to sleep. Goodnight!");
		  }
		else
		  {
			  print("You need to CHOOSE a correct letter!.");
		  }
	}
	public static void print(String string) {
		  System.out.println(string);
	}
	
}
