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
 *			- ops[], array
 *
 *		- Iterate through indices from word1.length -> 0, denoted as i
 *			- create variable prev = 0
 *			- Iterate through indices from word2.length -> 0, denoted as i
 *				- if i and j both are out of bound
 *					- continue to next iteration
 *				- if i is out of bound
 *					- prev = ops[j]
 *					- ops[j]	= word2.length - j
 *					- continue to next iteration
 *				- if j is out of bound
 *					- prev = ops[j]
 *					- ops[j]	= word1.length - i
 *					- continue to next iteration
 *				- create curr variable and set value as ops[j]
 *				- if  character at i and j are same
 *					- ops[i][j]	= prev
 *				- else
 *					- min(prev,curr,ops[j+1]) + 1
 *				- set prev = curr
 *
 *	-- Time : O(mn), where m,n are the length of word1 and word2, 3 for we have 3 choices
 *  -- Space : O(n), array
 *
 *
 */
public class EditDistanceBU1 {
	static int minDistance(String word1, String word2) {
		int[] ops = new int[word2.length()];
		for(int i = word1.length()-1; i >= 0; i--) {
			int prev = 0;
			for(int j = word2.length()-1; j >= 0; j--) {
				if(i == word1.length() - 1 && j == word2.length() - 1){
					continue;
				}
				if(i == word1.length() - 1){
					prev = ops[j];
					ops[j] = word2.length() - j;
					continue;
				}
				if(j == word2.length() - 1){
					prev = ops[j];
					ops[j] = word1.length() - i;
					continue;
				}
				int curr = ops[j];
				if(word1.charAt(i) == word2.charAt(j)){
					ops[j] = prev;
				}
				else{
					ops[j] = Math.min(prev,Math.min(ops[j+1],curr)) + 1;
				}
				prev = curr;
			}
		}
		return ops[0];
	}

	public static void main(String[] args) {
		String word1 = "horse";
		String word2 = "ros";
		System.out.println("Min Edit Distance -> " + minDistance(word1, word2));
	}
}
