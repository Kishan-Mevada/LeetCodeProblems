package org.kishan.year_2021.month_august.date_31;

public class StairCase {

	static void stairCase(int n){
		for(int i = 1; i <= n; i++) {
			StringBuilder sb = new StringBuilder();
			for(int j = 0; j < i; j++) {
				sb.append("#");
			}
			System.out.printf("%" + n +"s",sb.toString());

			if(i != n){
				System.out.println();
			}
		}
	}
	public static void main(String[] args) {
		stairCase(5);
	}
}
