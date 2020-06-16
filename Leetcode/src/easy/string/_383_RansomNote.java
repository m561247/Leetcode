package easy.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 
 * Example 1:

Input: ransomNote = "a", magazine = "b"
Output: false
Example 2:

Input: ransomNote = "aa", magazine = "ab"
Output: false
Example 3:

Input: ransomNote = "aa", magazine = "aab"
Output: true
 * @author user
 * public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            arr[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if(--arr[ransomNote.charAt(i)-'a'] < 0) {
                return false;
            }
        }
        return true;
    }
 */
public class _383_RansomNote {
//	public static boolean canConstruct(String ransomNote, String magazine) {
//	   int[] arr = new int[26];
//	   for (int i = 0; i < magazine.length(); i++) {
//		  arr[magazine.charAt(i) - 'a']++; 
//	   }
//	   for (int i = 0; i < ransomNote.length(); i++) {
//		   if (--arr[ransomNote.charAt(i) - 'a'] < 0) {
//			   return false;
//		   }
//	   }
//	   return true;
//	}
	public static boolean canConstruct(String ransomNote, String magazine) {
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
		System.out.println(canConstruct("ab", "ab"));
	}
}
