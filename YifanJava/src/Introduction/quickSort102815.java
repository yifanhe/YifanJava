package Introduction;

import java.util.Arrays;

public class quickSort102815 {

	
	public static void main(String[] args) {
		int[] test = {4,5,2,1,2};
		quickSort(test,0,test.length-1);
	}
	public static void quickSort(int[] array,int start, int end){
		/*int privotIndex = (end-start)/2;
		int pivot=array[privotIndex];
		if(pivot==1)
		{
			return;
		}
		System.out.println("Pivot is " + pivot); //if odd then it rounds down
		int i=start;
		int j=end;
		while(i<j){
			if(array[i]>=pivot && array[j]<=pivot)
			{
				System.out.println("Swapping the " + array[i] + " and " + array[j]);
				swap(array,i,j);
				i++;
				j--;
			}
			if(array[i]<=pivot)
			{
				i++;
			}
			if(array[j]>pivot)
			{
				j--;
			}
		}
		quickSort(array,0,i);
		quickSort(array,i+1, array.length-1);
		System.out.println("Rseult is: " + Arrays.toString(array));*/
		
		if(start == end)return;
		int pivotIndex = (end + start)/ 2;
		int pivot = array[pivotIndex];
		System.out.println(Arrays.toString(array));
		System.out.println("Pivot is " + pivot);
		int i = start;
		int j = end;
		while(i<=j){
			if(array[i] >= pivot && array[j] <= pivot){
				System.out.println("Swaping the " + array[i] + " and " + array[j]);
				swap(array, i, j);
				i++;
				j--;
			}
			if(array[i] <= pivot){
				i++;
			}
			if(array[j] > pivot){
				j--;
			}
		}
		System.out.println("Result is: " + Arrays.toString(array));
		quickSort(array, start, j);
		quickSort(array, j + 1, end);
		//return array;
	}
	public static void swap(int[] array, int a, int b){
		int placeHolder = array[a];
		array[a] = array[b];
		array[b] = placeHolder;
	}
}
