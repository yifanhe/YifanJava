package Introduction;

public class exercise093015 { //2D array 
	static boolean[][] mines = new boolean[3][3];
	
	public static void main(String[] args) {
		int [][] grid3X3 = new int[3][3];
		//printArrayContent(grid3X3[0]); //print the first 
		//printArrayContent(grid3X3[1]); //print the second
		//printArrayContent(grid3X3[2]); //print the third
		print2DArrayContent(grid3X3);
	}
	 
	public static void print2DArrayContent(int[][] array){
		for(int[] x: array){
			printArrayContent(x);
		}
	}
	
	public static void print2DArrayContent(boolean[][] array){
		for(boolean[] x: array){
			printArrayContent(x);
		}
	}
	
	private static void checkAdjacentValues(){
		mines[2][1]=true;
		int row = getRandomInt(2);
		int column = getRandomInt(2);
		int typeOfSpace = checkSpace(mines, row, column);
		if (typeOfSpace == 0){
			 System.out.println("at row " + row + ", column " + column + ", the mine was found!");
		}
		if (typeOfSpace == 1){
			System.out.println("at row " + row + ", column " + column + ", the mine is nearby!");
		}
		else{
			System.out.println("at row " + row + ", column " + column + ", NO mine is nearby!");
		}
	}
	public static int checkSpace(boolean [][] array, int row, int column){
		checkAdjacentValues();
		int int0 = 0;
		if (row==2 && column ==1){
			return int0;
		}
		
		
	}
	public static int getRandomInt(int max){
		int random = (int)(Math.random()*max)+1;
		return random;
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
	  

}



