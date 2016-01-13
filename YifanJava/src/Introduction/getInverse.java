package Introduction;

public class getInverse {
	/*
 	Write a method with the following name, modifiers,
 	
	and parameters: public static double[] getInverses(double[] values) 
	the method should return a double array filled with the multiplicative 
	inverses of whatever double[] is passed as an argument.
	IF the multiplicative inverse is undefined (because the 
	provided value is 0.0) then the returned value 
	should be zero. Make sure your code is equipped to handle such a case!
	*/
	// Testing any any double between -50 and 50, exclusive.
	// Testing positive doubles between 0 and 50, exclusive.
	// Testing non-zero double between -50 and 50, exclusive.
	
    static double[] numberArray  = {-49};
	public static void main(String[] args) {
		getInverses(numberArray);	
	}
	
	public static double[] getInverses(double[] values){
		double[] numberArray1 = new double[values.length];
		
		for (int index = 0; index < values.length; index++)
	      {
	           if (values[index] != 0){
	        	   numberArray1[index] = 1/(values[index]);
	           }
	           else
	           {
	        	   numberArray1[index] = 0;
	           }
	      }
		return numberArray1;
	}
}
/*
public class Main {

static double[] numberArray  = {0.0,1,2,3,4,5,6,7,8,9};
public static void main(String[] args) {
	getInverses(numberArray);	
}

public static double[] getInverses(double[] values){
	for (int index = 0; index < numberArray.length; index++)
   {
        if ( numberArray[index] == 0.0 ){
     	   double temp = 0;
     	   numberArray[index] = temp;
        }
        else
        {
     	    double temp1;
     	    temp1 = 1/(numberArray[index]);
     	    numberArray[index] = temp1;   
        }
   }
	printArrayContent(numberArray);
	return numberArray;
	
}
private static void printArrayContent(double[] array){
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
*/