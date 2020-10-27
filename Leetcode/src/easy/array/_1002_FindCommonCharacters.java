package easy.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array A of strings made only from lowercase letters, return a list
 * of all characters that show up in all strings within the list (including
 * duplicates). For example, if a character occurs 3 times in all strings but
 * not 4 times, you need to include that character three times in the final
 * answer.
 * 
 * You may return the answer in any order.
 * 
 * 
 * 
 * Example 1:
 * Input: ["bella","label","roller"] 
 * Output: ["e","l","l"] 
 * 
 * Example 2:
 * Input: ["cool","lock","cook"] 
 * Output: ["c","o"]
 * 
 * 
 * Note:
 * 
 * 1 <= A.length <= 100 1 <= A[i].length <= 100 A[i][j] is a lowercase letter
 */
public class _1002_FindCommonCharacters {
	/*
	 * Solution_1 : 
	 */
	public static List<String> commonChars(String[] A) {
		List<String> ans = new ArrayList<>();
		// common characters dictionary
		int[] dict = new int[26];
		for (int j = 0; j < A[0].length(); j++) {
			dict[A[0].charAt(j) - 'a']++;
		}
		for (int i = 1; i < A.length; i++) {
			// Dictionary of the current word
			int[] curr = new int[26];
			for (int j = 0; j < A[i].length(); j++) {
				curr[A[i].charAt(j) - 'a']++;
			}
			// 找出相同個數的最小值
			for (int j = 0; j < 26; j++) {
				if (curr[j] < dict[j]) {
					dict[j] = curr[j];
				}
			}
		}
		for (int i = 0; i < 26; i++) {
			for (int j = 0; j < dict[i]; j++) {
				ans.add(Character.toString((char) ('a' + i)));
			}
		}
		return ans;
	}
	
	/*
	 * Solution_2 : hash map
	 */
	public List<String> commonChars_Sol_2(String[] A){
		Map<Character, Integer> map = new HashMap<>();
		for (char c : A[0].toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		for (int i = 1; i < A.length; i++) {
			Map<Character, Integer> temp = new HashMap<>();
			for (int j = 0; j < A[i].length(); j++) {
				char c = A[i].charAt(j);
				if (map.containsKey(c) && map.get(c) > 0) {
					temp.put(c, temp.getOrDefault(c, 0) + 1);
					map.put(c, map.get(c) - 1);
				}
			}
			map = temp;
			if (map.size() == 0) {
				break;
			}
		}
		List<String> res = new ArrayList<>();
		for (Character c : map.keySet()) {
			for (int k = 0; k < map.get(c); k++) {
				res.add("" + c);
			}
		}
		return res;
	}
	
	
	public static void main(String[] args) {
		String[] str = {"bella","label","roller"};
		commonChars(str);
		for (String s : str) {
			s.chars().forEach(c -> System.out.println(c));
		}
	}
}
