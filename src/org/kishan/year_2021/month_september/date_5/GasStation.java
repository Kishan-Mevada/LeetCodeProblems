package org.kishan.year_2021.month_september.date_5;

/**
 * 	-- Time : O(n)
 * 	-- Space : O(1)
 */
public class GasStation {

	static int canCompleteCircuit(int[] gas,int[] cost){
		int start = 0,surplus = 0, deficit = 0;
		for(int i = 0; i < gas.length; i++) {
			surplus += gas[i];

			if(surplus >= cost[i]){
				surplus -= cost[i];
			}
			else{
				deficit += cost[i] - surplus;
				start = i + 1;
				surplus = 0;
			}
		}
		return surplus >= deficit ? start : -1;
	}
	public static void main(String[] args) {
		int[] gas = {1,2,3,4,5};
		int[] cost = {3,4,5,1,2};
		System.out.println("Can Complete Circuit -> " + canCompleteCircuit(gas,cost));
	}
}
