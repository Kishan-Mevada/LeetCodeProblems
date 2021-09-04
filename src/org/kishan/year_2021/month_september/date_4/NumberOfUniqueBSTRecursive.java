package org.kishan.year_2021.month_september.date_4;

public class NumberOfUniqueBSTRecursive {

	static int numTrees(int n){
		if(n == 0 || n == 1) return 1;

		int trees = 0;
		for(int i = 1; i <= n; i++) {
			trees += numTrees(i-1) * numTrees(n-i);
		}
		return trees;
	}
	public static void main(String[] args) {
		int n = 3;
		System.out.println("Number of Trees -> " + numTrees(n));
	}
}
