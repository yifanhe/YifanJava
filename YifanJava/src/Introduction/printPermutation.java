package Introduction;

public class printPermutation {
		/*
		  Write a method called: public static String[] printPermutations(String[] s1)
		  The method should print every permutation of two strings from s1 with NO duplicates 
		  (DO NOT separate with a space!). This assignment is scaffolded: In the first test, 
		  the s1 will have distinct items In a later test, the s1 will have some duplicate entries
		 */
		/* 	
		Example:
		Suppose the String[] s1 = {"cat", "dog", "mouse", "cat"}
		Then "every permutation of two strings from s1 with NO duplicates" would be:
		{"catdog", "catmouse", "catcat", "dogcat","dogdog", dogmouse", "mousecat", mousedog", "mousemouse"}

		Notice that even though "cat" is listed twice in the original array, there are no duplicates in the returned array.
		 */
	static String[] animals = {"cat", "dog", "mouse", "panda"};
	public static void main(String[] args) {
		printPermutations(animals);
	}

	public static String[] printPermutations(String[] s1){
		String[] animals1 = new String[s1.length*s1.length];
		int num=0;
		for (int index1 = 0; index1 < s1.length; index1++)
		{
			for (int index = 0; index < s1.length; index++)
			{    
				animals1[num] = s1[index] + s1[index1];
				num++;
			}
		}
		 printArray(animals1);
		return animals1;
	}
		
	
	public static void printArray(String[] s){
		String all = "[";
		for(int i=0; i<s.length-1; i++){
			all+=s[i]+", ";
		}
		all+=s[s.length-1]+"]";
		System.out.println(all);
	}
}
/*
For each letter that we choose for the first(leftmost) position,we need to write all the permutations beginning with that letter before we 
change the first letter. Likewise, if we pick up a letter for the second position , 
we need to write out all permutations beginning  with this two letter sequence before 
changing the letters in either the first or second position.
In other words , we can define the permutation process as picking a letter for a given 
position and performing the permutation process starting at the next position to the right before coming back to change the letter we just picked.

As each letter from the input string can appear only once in each permutations, "all allowable 
characters"  cant be defined as every letter in the input string. "All allowable character" 
means all letters in the input string that haven't already been chosen for a position to the left of the current 
position (a position less than n). We need to check this scenario algorithmically . We can check each candidate
 letter for a position n against all the letters in positions  less than n to determine whether it had been used. 
 We can eliminate these inefficient scans by maintaining an array of boolean values corresponding to the positions 
 of the letters in the input string and using this array  to mark letter as used or unused, as appropriate. */


/*1.  If we have past the last position
          Print the String
          Return
2.  Otherwise
          For each letter in the input string         
          If its marked as used, skip to the next letter
          Else, place the letter in the current position
                 Mark the letter as used
                 Permute remaining letters starting at current pos. + 1
                 Mark the letter as unused   */


// http://javahungry.blogspot.com/2014/03/algorithm-to-find-permutations-of-string-using-recursion-in-java.html 











