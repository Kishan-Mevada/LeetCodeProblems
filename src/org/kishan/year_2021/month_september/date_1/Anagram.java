package org.kishan.year_2021.month_september.date_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 	An Anagram is a word or phrase formed by rearranging the letters of different word
 *
 * 	input = ["eat","tea","tan","ate","nat","bat"]
 *
 * 	Solution Algorithm
 *
 * 	- create a map to track the sorted word -> list of valid anagrams
 * 	- Iterate the array of words
 * 		- sort the current word
 * 		- put into map
 * 	- convert map into list as result
 * 	- return result;
 *
 */
public class Anagram {

	static List<List<String>> groupAnagram(String[] words){
		Map<String,List<String>> map = new HashMap<>();

		for(String word : words){
			String sortedWord = sortWord(word);
			map.putIfAbsent(sortedWord,new ArrayList<>());
			map.get(sortedWord).add(word);
		}

		return convertToList(map);
	}
	private static List<List<String>> convertToList(Map<String,List<String>> map) {
		return new ArrayList<>(map.values());
	}
	private static String sortWord(String word) {
		char[] chars = word.toCharArray();
		Arrays.sort(chars);
		return new String(chars);
	}
	public static void main(String[] args) {
		String[] words = {"eat","tea","tan","ate","nat","bat"};
		System.out.println("Anagrams -> " + groupAnagram(words));
	}
}
