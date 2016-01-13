package Introduction;
import java.util.Scanner;

public class New {
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		compute();
	}
	
	
	public static void compute(){
		print("Yay! Please type your simple math questions! \n" 
				+ "Unfortunately, I can only do '+', '-', '/', and '*'");
		String mathResponse = waitForInput();
		int count=0;
		mathResponse = mathResponse.replaceAll("[^\\d.+.*./.-]", "");
		//System.out.println(mathResponse);
		if (mathResponse.indexOf(".")>=0){
			count=100;
		}
		if(count==100){
			print("Very sorry to disappoint you.. But right now.. I can only do intergers!");
		
		}
		String[] mathResponse1 = mathResponse.split("");
		//printArrayContent(mathResponse1);
		String[] findRepeat = {"+","-","*","/"}; 
		String operator = ""; 
		for(int i=0;i<mathResponse1.length;i++){
			for(int j=0; j<findRepeat.length;j++){
			    	if(i!=1||i!=mathResponse1.length-1){
    					if(mathResponse1[i].equals(findRepeat[j])){ //if any value of findRepeat[] matches mathResponse1[]
    						count++;
    						operator=mathResponse1[i];
    					}
    					
					}

				}
			}
		if(count!=1){
			print("Wrong");
		}
		//	System.out.println("Count is: "+count);
	}
	public static void printArrayContent(String[] ints){
		String builder ="[";
		for (int i=0; i<ints.length-1; i++){
			builder+=ints[i]+", ";
		}
		builder+=ints[ints.length-1]+"]";
		System.out.println("mathResponse2: "+ builder);
	}
	public static void print(String string) {
		System.out.println(string);
	}
	public static String waitForInput(){
		String entry=input.nextLine();
		return entry;
	}
    
}
