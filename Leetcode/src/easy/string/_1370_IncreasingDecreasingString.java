package easy.string;

import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Given a string s. You should re-order the string using the following
 * algorithm:
 * 
	1. Pick the smallest character from s and append it to the result.
	2. Pick the smallest character from s which is greater than the last appended character to the result and append it.
	3. Repeat step 2 until you cannot pick more characters.
	4. Pick the largest character from s and append it to the result.
	5. Pick the largest character from s which is smaller than the last appended character to the result and append it.
	6. Repeat step 5 until you cannot pick more characters.
	7. Repeat the steps from 1 to 6 until you pick all characters from s.
 * 
 * 
 * In each step, If the smallest or the largest character appears more
 * than once you can choose any occurrence and append it to the result.
 * 
 * Return the result string after sorting s with this algorithm.
 * 
 * 
 * 
 * Example 1:
 * Input: s = "aaaabbbbcccc" 
 * Output: "abccbaabccba" 
 * Explanation: After steps 1,
 * 2 and 3 of the first iteration, result = "abc" After steps 4, 5 and 6 of the
 * first iteration, result = "abccba" First iteration is done. Now s = "aabbcc"
 * and we go back to step 1 After steps 1, 2 and 3 of the second iteration,
 * result = "abccbaabc" After steps 4, 5 and 6 of the second iteration, result =
 * "abccbaabccba" 
 * 
 * Example 2:
 * Input: s = "rat" 
 * Output: "art" 
 * Explanation: The word "rat" becomes "art"
 * after re-ordering it with the mentioned algorithm. 
 * 
 * Example 3:
 * Input: s = "leetcode" 
 * Output: "cdelotee" 
 * 
 * Example 4:
 * Input: s = "ggggggg" 
 * Output: "ggggggg" 
 * 
 * Example 5:
 * 
 * Input: s = "spo" 
 * Output: "ops"
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 500 s contains only lower-case English letters.
 *
 * 題目說明 : 
 * 1. 找出 s 字串中字母最小的字元，將它加入要回傳的結果字串
 * 2. 找出 s 字串中比結果字串最後加入的字元大的字元，將它加入結果字串
 * 3. 重複第二步直到無法找到為止
 * 4. 找出 s 字串中最大的字元，將它加入要回傳的結果字串
 * 5. 找出 s 字串中比結果字串最後加入的字元小的字元，將它加入結果字串
 * 6. 重複第五步直到無法找到為止
 * 7. 重複一到六步直到結束
 */
public class _1370_IncreasingDecreasingString {
	/*
	 * Solution_1 : use tree map
	 */
	public static String sortString_Sol_1(String s) {
		StringBuilder ans = new StringBuilder();
		TreeMap<Character, Integer> tm = new TreeMap<>();
		for (char c : s.toCharArray()) {
			tm.put(c, 1 + tm.getOrDefault(c, 0));
		}
		boolean asc = true;
		while (!tm.isEmpty()) {
			for (char c : asc ? new TreeSet<>(tm.keySet()) : new TreeSet<>(tm.descendingKeySet())) {
				ans.append(c);
				tm.put(c, tm.get(c) - 1);
				tm.remove(c, 0);
			}
			asc = !asc; // same as asc ^= true;
		}
		return ans.toString();
	}
	
	/*
	 * Solution_2 : use array
	 */
	public static String sortString_Sol_2(String s) {
		StringBuilder ans = new StringBuilder();
		int[] count = new int[26];
		for (char c : s.toCharArray()) {
			++count[c - 'a'];
		}
		while (ans.length() < s.length()) {
			add(count, ans, true);
			add(count, ans, false);
		}
		return ans.toString();
	}
	
	/* help method */
	private static void add(int[] count, StringBuilder ans, Boolean asc) {
		for (int i = 0; i < 26; i++) {
			int j = asc ? i : 25 - i;
			if (count[j] > 0) {
				ans.append((char) (j + 'a'));
				count[j]--;
			}
		}
	}
	
	/*
	 * Solution_3 : same as Sol_2
	 */
	public static String sortString_Sol_3(String s) {
		int len = s.length();
		int[] freq = new int[26];
		for (int i = 0; i < len; i++) {
			freq[s.charAt(i) - 'a']++;
		}
		StringBuilder sb = new StringBuilder();
		int count = 0;
		while (count < len) {
			for (int i = 0 ; i < 26; i++) {
				if (freq[i] > 0) {
					sb.append((char) (i + 'a'));
					freq[i]--;
					count++;
				}
			}
			for (int j = 25; j >= 0; j--) {
				if (freq[j] > 0) {
					sb.append((char) (j + 'a'));
					freq[j]--;
					count++;
				}
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		String s = "abcabcabcabc";
		System.out.println(sortString_Sol_3(s));
	}
}
