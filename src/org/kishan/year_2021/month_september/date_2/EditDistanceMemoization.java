package org.kishan.year_2021.month_september.date_2;

/**
 * 	Given 2 strings, word1 and word2, return the minimum number of operations required to convert word1 to word2
 *
 * 	You have 3 operation permitted on word
 * 		- Insert a character
 * 		- Delete a character
 * 		- Replace a character
 *
 * 	 input
 * 	 word1 = horse
 * 	 word2 = ros
 *
 * 	 output = 3
 *
 * 	 Solution Algorithm (Top Down Memoization approach)
 *
 *		- create following variables
 *			- i , current index of word1
 *			- j , current index of word2
 *			- word1, input word
 *			- word2, input word
 *			- memo, 2D matrix to keep track of minOps
 *
 *	   - base conditions
 *	   		if i and j both out of bound
 *	   			- return 0
 *	   		if i out of bound
 *	   			- return word2.length - j  // we have only insertion
 *	   		if j out of bound
 *	   			- return word1.length - i // we have only deletion
 *	   		if memo[i][j] != 0
 *	   			- return memo[i][j]
 *	   - In each recursive call
 *	   		- if index at i and j, character are same
 *	   			- then we can move forward both i and j and put value into memo[i][j]
 *	   		- else
 *		   		- recursively find the number of operations ops1 if we perform insert (if we insert a character inside word1, we need to increment j inside word2)
 *	   				- set j to j + 1
 *	   			- recursively find the number of operations ops1 if we perform delete (if we delete a character inside word1, we need to increment i inside word1)
 *	   				- set i to i + 1
 *	   			- recursively find the number of operations ops1 if we perform replace (if we replace a character inside word1, we need to increment j and i inside word2,word1 respectively)
 *	   				- set j to j + 1
 *	   		 		- set i to i + 1
 *	   		 	- return memo[i][j] = min(ops1,ops2,ops3) + 1
 *
 *	-- Time : O(mn), where m,n are the length of word1 and word2, 3 for we have 3 choices
 *  -- Space : O(mn), memo matrix
 *
 *
 */
public class EditDistanceMemoization {
	static int minDistance(String word1, String word2) {
		int[][] memo = new int[word1.length()][word2.length()];
		return minDistance(0, 0, word1, word2,memo);
	}
	private static int minDistance(int i, int j, String word1, String word2,int[][] memo) {
		if(i == word1.length() - 1 && j == word2.length() - 1) {
			return 0;
		}
		if(i == word1.length() - 1) {
			return word2.length() - j; // we have only insertion
		}
		if(j == word2.length() - 1) {
			return word1.length() - i; // we have only deletion
		}
		if(memo[i][j] != 0){
			return memo[i][j];
		}
		if(word1.charAt(i) == word2.charAt(j)) {
			return memo[i][j] =  minDistance(i + 1, j + 1, word1, word2,memo);
		}
		return memo[i][j] =  Math.min(minDistance(i + 1, j, word1, word2,memo), Math.min(minDistance(i, j + 1, word1, word2,memo), minDistance(i + 1, j + 1, word1, word2,memo))) + 1;
	}
	public static void main(String[] args) {
		String word1 = "horse";
		String word2 = "ros";
		System.out.println("Min Edit Distance -> " + minDistance(word1, word2));
	}
}
