package Introduction;

//import java.util.Scanner;

public class array092815 {

	public static void main(String[] args) {
	/*	int[] someDigitsOfPi = {3,1,4,1,5,9,2,6,5,3}; 
		int[] someDigitsOfE = new int[4];
		someDigitsOfE[0] = 2;
		someDigitsOfE[1] = 7;
		someDigitsOfE[2] = 1;
		someDigitsOfE[2] = 8;
		System.out.println("The number of digits of pi is " + someDigitsOfPi.length);
		System.out.println("The number of digits of pi is " + someDigitsOfE.length);
		System.out.println(someDigitsOfPi); //output the address of the array
		printArrayContent(someDigitsOfPi);*/
		String[] deck = makeCards();
		shuffle(deck);
		printArrayContent(deck);
		long startTime = System.currentTimeMillis();
		int[] randomArray1 = generateARandomArray(1);
		printArrayContent(randomArray1);
		long endTime = System.currentTimeMillis();
		countPrimes(100000);
		System.out.println("The method took " + (endTime - startTime) + "ms");
	}
	 private static void countPrimes(int max){
		 boolean[] theNumbers = new boolean[max+1];
		 for (int index = 2; index<theNumbers.length; index++){
			 theNumbers[index]=true;//start by assuming every number is prime {except 0 and 1)
		 }
		 for(int index=0; index<theNumbers.length; index++){ //theNumbers.length = max
			 
			 //theNumbers[index] is the same as if(theNumbers[index] ==true;
			 if(theNumbers[index]){ //if the index adds itself then it can't be prime (multipleIndex; thus the the booleans becomes false
				 for(int multipleIndex = index+index; multipleIndex<theNumbers.length; multipleIndex+=index){//multipleIndex=multipleIndex+index
					 theNumbers[multipleIndex] = false;
				 }
			 }
		 }
		 String statement = "";
		 int count =0;
		 for(int index = 0;index<theNumbers.length; index++){
			 if(theNumbers[index]){
				 count++;
				 statement += "" + index+",";
			 }
		 }
		 statement +="\nThere are " + count + " primes between 1 and " + max+ " .";
		 System.out.println(statement);
		// printArrayContent(theNumbers);
	 }
	 private static void swap(String[] deck, int a, int b){
		 String placeHolder = deck[a];
		 deck[a] = deck[b];
		 deck[b] = placeHolder;
	 }
	 private static void shuffle(String[] deck){
		 for(int index=0; index<deck.length; index++)
		 {
			 int swapCard = (int)(Math.random()*deck.length);
			 swap(deck, index, swapCard);
		 }
	 }
	 private static String[] makeCards(){
		 String[] suits= {"Hearts", "Diamond", "Clubs", "Spades"};
		 String[] Cards= {"Ace", "Two", "Three", "Four", "Five","Six", "Seven", "Eight","Nine","Ten","Jack", "Queen","King"};
		 String[] allCards = new String[52];
		 int cardNum = 0;
		 for(int index1=0; index1< Cards.length; index1++)
		 { 
			 for (int index2=0; index2< suits.length; index2++) //nested loop
			 {
				 String tempString = Cards[index1] + " of " + suits[index2];
				 allCards[cardNum] = tempString;
				 cardNum++;
			 }
		 }
		printArrayContent(allCards);
		return allCards;
		 
	 }
	 private static int[] generateARandomArray(int arrayLength){
		 int[] array = new int[arrayLength];
		 for(int index=0; index < array.length; index++)
		 {
			 array[index]=array.length-index; //Backward
			// array[index]=index+1;  //Forward 
		 }
		 return array;
	 }
    private static void printArrayContent(int[] array){
      	String arrayContent = "[";
      	for(int index = 0; index < array.length; index++)
      	{
      		if(index != array.length-1)
      		{
      			arrayContent = arrayContent + array[index] + ",";
      		}
      		else
      		{
      			arrayContent = arrayContent + array[index];
      		}
      	}
      	arrayContent = arrayContent + "]";
      	System.out.println(arrayContent);
    }
    private static void printArrayContent(boolean[] array){
      	String arrayContent = "[";
      	for(int index = 0; index < array.length; index++)
      	{
      		if(index != array.length-1)
      		{
      			arrayContent = arrayContent + array[index] + ",";
      		}
      		else
      		{
      			arrayContent = arrayContent + array[index];
      		}
      	}
      	arrayContent = arrayContent + "]";
      	System.out.println(arrayContent);
    }
    private static void printArrayContent(String [] array){
      	String arrayContent = "[";
      	for(int index = 0; index < array.length; index++)
      	{
      		if(index != array.length-1)
      		{
      			arrayContent = arrayContent + array[index] + ", ";
      		}
      		else
      		{
      			arrayContent = arrayContent + array[index];
      		}
      	}
      	arrayContent = arrayContent + "]";
      	System.out.println(arrayContent);
    }
}
