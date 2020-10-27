package easy.string;

/**
 * Given a string s, the power of the string is the maximum length of a
 * non-empty substring that contains only one unique character.
 * 
 * Return the power of the string.
 * 
 * 
 * 
 * Example 1:
 * Input: s = "leetcode" 
 * Output: 2 
 * Explanation: The substring "ee" is of length
 * 2 with the character 'e' only. 
 * 
 * Example 2:
 * Input: s = "abbcccddddeeeeedcba" 
 * Output: 5 
 * Explanation: The substring "eeeee"
 * is of length 5 with the character 'e' only. 
 * 
 * Example 3:
 * Input: s = "triplepillooooow" 
 * Output: 5 
 * 
 * Example 4:
 * Input: s = "hooraaaaaaaaaaay" 
 * Output: 11 
 * 
 * Example 5:
 * Input: s = "tourist" 
 * Output: 1
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 500 s contains only lowercase English letters.
 */
public class _1446_ConsecutiveCharacters { // triplepillooooow
	/*
	 * Solution :
	 */
	public static int maxPower(String s) {
		int ans = 1, count = 1;
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				count++;
				ans = Math.max(ans, count);
			} else {
				count = 1;
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		String s = "triplepillooooow";
		System.out.println(maxPower(s));
	}
}
