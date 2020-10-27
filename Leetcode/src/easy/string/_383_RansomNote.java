package easy.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an arbitrary ransom note string and another string containing letters
 * from all the magazines, write a function that will return true if the ransom
 * note can be constructed from the magazines ; otherwise, it will return false.
 * 
 * Each letter in the magazine string can only be used once in your ransom note.
 * 
 * 
 * 
 * Example 1:
 * Input: ransomNote = "a", magazine = "b" 
 * Output: false 
 * 
 * Example 2:
 * Input: ransomNote = "aa", magazine = "ab" 
 * Output: false 
 * 
 * Example 3:
 * Input: ransomNote = "aa", magazine = "aab" 
 * Output: true
 */
public class _383_RansomNote {
	/*
	 * Solution_1 : 用陣列計次
	 */
	public static boolean canConstruct_Sol_1(String ransomNote, String magazine) {
	   int[] arr = new int[26];
	   for (int i = 0; i < magazine.length(); i++) {
		  arr[magazine.charAt(i) - 'a']++; 
	   }
	   for (int i = 0; i < ransomNote.length(); i++) {
		   if (--arr[ransomNote.charAt(i) - 'a'] < 0) {
			   return false;
		   }
	   }
	   return true;
	}
	/*
	 * Solution_2 : 用 map 計次
	 */
	public static boolean canConstruct_Sol_2(String ransomNote, String magazine) {
		Map<Character, Integer> map = new HashMap<>();
		int count;
		for (char c : magazine.toCharArray()) {
			count = map.getOrDefault(c, 0) + 1;
			map.put(c, count);
		}
		for (char c : ransomNote.toCharArray()) {
			count = map.getOrDefault(c, 0) - 1;
			if (count < 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(canConstruct_Sol_2("ab", "ab"));
	}
}
