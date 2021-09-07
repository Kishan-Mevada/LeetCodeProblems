package org.kishan.year_2021.month_september.date_7;

/**
 * 	A newly designed keypad was tested, where a tester pressed a sequence of n keys, one at a time.
 *
 * 	You are given a string keysPressed of length n, where keysPressed[i] was the ith key pressed in the testing sequence, and a sorted list releaseTimes, where releaseTimes[i] was the time the ith key was released. Both arrays are 0-indexed. The 0th key was pressed at the time 0,
 * 	and every subsequent key was pressed at the exact time the previous key was released.
 *
 * 	Input: releaseTimes = [9,29,49,50], keysPressed = "cbcd"
 * Output: "c"
 * Explanation: The keypresses were as follows:
 * Keypress for 'c' had a duration of 9 (pressed at time 0 and released at time 9).
 * Keypress for 'b' had a duration of 29 - 9 = 20 (pressed at time 9 right after the release of the previous character and released at time 29).
 * Keypress for 'c' had a duration of 49 - 29 = 20 (pressed at time 29 right after the release of the previous character and released at time 49).
 * Keypress for 'd' had a duration of 50 - 49 = 1 (pressed at time 49 right after the release of the previous character and released at time 50).
 * The longest of these was the keypress for 'b' and the second keypress for 'c', both with duration 20.
 * 'c' is lexicographically larger than 'b', so the answer is 'c'.
 *
 */
public class SlowKey {

	public static char slowestKey(int[] releaseTimes, String keysPressed) {
		 for(int i =releaseTimes.length-1;i>=1;i--){
			 releaseTimes[i] = releaseTimes[i]-releaseTimes[i-1];
		 }
		 int maxTime = 0;
		 char slowKey = '0';
		for(int i = 0; i < releaseTimes.length; i++) {
			if(releaseTimes[i] > maxTime){
				maxTime = releaseTimes[i];
				slowKey = keysPressed.charAt(i);
			}
			else if(releaseTimes[i] == maxTime && keysPressed.charAt(i) > slowKey){
				slowKey = keysPressed.charAt(i);
			}
		}
		return slowKey;
	}
	public static void main(String[] args) {
		int[] releaseTimes = {23,34,43,59,62,80,83,92,97};
		String keysPressed = "qgkzzihfc";
		System.out.println("Slow Key -> " + slowestKey(releaseTimes,keysPressed));
	}
}
