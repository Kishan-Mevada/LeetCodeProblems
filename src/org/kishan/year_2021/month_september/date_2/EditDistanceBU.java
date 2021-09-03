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
 *			- ops[][], 2D matrix
 *
 *		- Iterate through indices from word1.length -> 0, denoted as i
 *			- Iterate through indices from word2.length -> 0, denoted as i
 *				- if i and j both are out of bound
 *					- ops[i][j]	= 0
 *					- continue to next iteration
 *				- if i is out of bound
 *					- ops[i][j]	= word2.length - j
 *					- continue to next iteration
 *				- if j is out of bound
 *					- ops[i][j]	= word1.length - i
 *					- continue to next iteration
 *				- if  character at i and j are same
 *					- ops[i][j]	= ops[i+1][j+1]
 *				- else
 *					- min(ops[i+1][j+1],ops[i+1][j],ops[i][j+1]) + 1
 *
 *
 *	-- Time : O(mn), where m,n are the length of word1 and word2, 3 for we have 3 choices
 *  -- Space : O(mn), 2D matrix
 *
 *
 */
public class EditDistanceBU {
	static int minDistance(String word1, String word2) {
		int[][] ops = new int[word1.length()][word2.length()];
		for(int i = word1.length()-1; i >= 0; i--) {
			for(int j = word2.length()-1; j >= 0; j--) {
				if(i == word1.length() - 1 && j == word2.length() - 1){
					ops[i][j] = 0;
				}
				else if(i == word1.length() - 1){
					ops[i][j] = word2.length() - j;
				}
				else if(j == word2.length() - 1){
					ops[i][j] = word1.length() - i;
				}
				else if(word1.charAt(i) == word2.charAt(j)){
					ops[i][j] = ops[i+1][j+1];
				}
				else{
					ops[i][j] = Math.min(ops[i+1][j+1],Math.min(ops[i][j+1],ops[i+1][j])) + 1;
				}
			}
		}
		return ops[0][0];
	}

	public static void main(String[] args) {
		String word1 = "horse";
		String word2 = "ros";
		System.out.println("Min Edit Distance -> " + minDistance(word1, word2));
	}
}
