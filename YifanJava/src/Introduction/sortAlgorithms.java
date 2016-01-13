package Introduction;

import java.util.Arrays;

public class sortAlgorithms {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test = {9,0,3,7,-3,5,6,3};
	//	int[] test1 = {9,0,3,7,-3,5,6,3};
	//	int[] test1 = {1,2,3,4,5,6};
		
		//selectionSort(test);
		//bubbleSort(test1);
		//System.out.println("10! is " +factorial(4));
		System.out.println(Arrays.toString(mergeSort(test)));
	}
	public static int factorial(int n){
		if(n<2)
		{
			return 1;
		}
		else
		{
			return n*factorial(n-1); //recursion
		}
	}
	public static int[] mergeSort(int[] array){
		if(array.length==1)
		{
			return array;
		}
		int half = (array.length)/2;
		int[] half1= new int[half];
		int[] half2= new int[array.length-half];
		//copy elements from the first half of the array
		for(int i=0;i<half1.length;i++){
			half1[i]=array[i];
		}
		//copy elements from the second half of the array
		for(int j=0;j<half2.length;j++){
			half2[j]=array[half+j];
		}
		//mergeSort(half1);
		//mergeSort(half2);
		System.out.println(Arrays.toString(half1)+" and "+ Arrays.toString(half2));
		return merge(mergeSort(half1),mergeSort(half2));
	}
	
	public static void swap(int[] array, int a, int b){
		int placeHolder = array[a];
		array[a] = array[b];
		array[b] = placeHolder;
	}
	public static void selectionSort(int[] array){
		//represents red 
		for(int i=0;i<array.length;i++){//represents yellow
			int indexOfTempMin=i;
			for(int j=i;j<array.length;j++){ //represents blue
				if(array[j]<array[indexOfTempMin])
				{
					indexOfTempMin=j;
					//	System.out.println("index = " +i+ "and indexOfTempMin = " +j);
				}
			}
			//System.out.println(Arrays.toString(array));
			swap(array, i, indexOfTempMin);//swap with index of tempMin
			System.out.println("we swap " +i+ "and " + indexOfTempMin + Arrays.toString(array));
		}
		printArrayContent(array);
	}
	public static void bubbleSort(int[] array){
		//compares two index at a time
	    //int i=0;
		for(int i=1; i<array.length-1;i++){// i=0; i<array.length;i++   (works but is inefficient)
			for(int j=0;j<array.length-i;j++){  //j=0;j<array.length-1;j++
				if(array[j]>array[j+1])
				{
					swap(array, j, j+1);
					System.out.println("we swap " +j+ "and " + (j+1) + Arrays.toString(array));
				}
			}
		}
		printArrayContent(array);
	}
	public static int[] merge(int[] a,int[] b){
		int i=0;
		int j=0;
		int k=0; //index in results 
		int[] result = new int[a.length+b.length];
		while(i<a.length && j<b.length){  //while loop ends when the array index is out of bound. Then it goes to the next next two while loops
			if(a[i]<=b[j])
			{
				result[k]=a[i];
				i++;  
			}
			else
			{
				result[k]=b[j];
				j++;
			}
			k++;
		}
		while(i<a.length){
			result[k]=a[i];
			i++;
			k++;
		}
		while(j<b.length){
			result[k]=b[j];
			j++;
			k++;
		}
		return result;
	}
	
	public static void printArrayContent(int [] array){
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
