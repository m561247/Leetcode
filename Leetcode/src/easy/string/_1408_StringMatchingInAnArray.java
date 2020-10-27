package easy.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Given an array of string words. Return all strings in words which is
 * substring of another word in any order.
 * 
 * String words[i] is substring of words[j], if can be obtained removing some
 * characters to left and/or right side of words[j].
 * 
 * 
 * 
 * Example 1:
 * Input: words = ["mass","as","hero","superhero"] 
 * Output: ["as","hero"]
 * Explanation: "as" is substring of "mass" and "hero" is substring of
 * "superhero". ["hero","as"] is also a valid answer. 
 * 
 * Example 2:
 * Input: words = ["leetcode","et","code"] 
 * Output: ["et","code"] 
 * Explanation:
 * "et", "code" are substring of "leetcode". 
 * 
 * Example 3:
 * Input: words = ["blue","green","bu"] 
 * Output: []
 * 
 * 
 * Constraints:
 * 
 * 1 <= words.length <= 100 1 <= words[i].length <= 30 words[i] contains only
 * lowercase English letters. It's guaranteed that words[i] will be unique.
 */
public class _1408_StringMatchingInAnArray {
	/*
	 * Solution_1 : use Arrays.sort()，先照字串長度排列再比對，好處是只要比對一次
	 */
	public static List<String> stringMatching_Sol_1(String[] words) {
		Arrays.sort(words, (a, b) -> a.length() - b.length());
		List<String> result = new ArrayList<>();
		for (int i = 0; i < words.length - 1; i++) {
			int j = i + 1;
			while (j < words.length) {
				int index = words[j++].indexOf(words[i]);
				if (index != -1) {
					result.add(words[i]);
					break;
				}
			}
		}
		return result;
	}
	
	/*
	 * Solution_2 : 不事先進行排列，缺點是要互相比對
	 */
	public static List<String> stringMatching_Sol_2(String[] words){
		Set<String> result = new HashSet<>();
		for (int i = 0; i < words.length - 1; i++) {
			String m = words[i];
			for (int j = i + 1; j < words.length; j++) {
				String n = words[j];
				if (m.contains(n)) {
					result.add(n);
				}
				if (n.contains(m)) {
					result.add(m);
				}
			}
		}
		return new ArrayList<String>(result);
	}
}
