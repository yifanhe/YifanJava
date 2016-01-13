package Introduction;

import java.util.Scanner;

public class confirmedEntry {

			static Scanner input = new Scanner(System.in);
		
			
			public static void main(String[] args) {
					String name=question("What is your name?");
				    String food=question("What's your favourite food?");
				    String sport=question("What's your favourite sport?");
				    print("Hello " + name + " ." + " I like " + food + " too. I also like " + sport + " .");
				 }
			public static String question(String questions){
				     String answer="";
				      while(true)
				      {
				          print(questions); 
				          answer = waitForInput();
				          print("Please confirm your entry! \n" +
				          		" \"Yes\" - Enter Yes if the information is correct. \n"+
				          		" \"No\" - Enter No if the information is correct." );
				          String response = waitForInput();
				          if (response.equalsIgnoreCase("Yes"))
						  {
							  break;
						  } 
				      }
			             return answer;
				 }
	
			public static void print(String string) {
				  System.out.println(string);
			}
			public static String waitForInput(){
				  String entry=input.nextLine();
				  return entry;
			}

	
}
