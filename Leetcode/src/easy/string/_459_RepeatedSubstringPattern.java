package easy.string;

/**
 * Given a non-empty string check if it can be constructed by taking a substring
 * of it and appending multiple copies of the substring together. You may assume
 * the given string consists of lowercase English letters only and its length
 * will not exceed 10000.
 * 
 * 
 * 
 * Example 1:
 * Input: "abab" 
 * Output: True 
 * Explanation: It's the substring "ab" twice.
 * 
 * Example 2:
 * Input: "aba" 
 * Output: False 
 * 
 * Example 3:
 * Input: "abcabcabcabc" 
 * Output: True 
 * Explanation: It's the substring "abc" four
 * times. (And the substring "abcabc" twice.)
 */
public class _459_RepeatedSubstringPattern {
	/*
	 * Solution_1 : 
	 */
	public static boolean repeatedSubstringPattern_Sol_1(String s) {
		String str = s + s;
		return str.substring(1, str.length() - 1).contains(s);
	}

	/*
	 * Solution_2 : 
	 */
	public static boolean repeatedSubstringPattern(String s) {
		int l = s.length();
		for (int i = l / 2; i >= 1; i--) {
			if (l % i == 0) {
				int times = l / i;
				String subS = s.substring(0, i);
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < times; j++) {
					sb.append(subS);
				}
				if (sb.toString().equals(s)) {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		String str = "abcabcabcabc";
		System.out.println(repeatedSubstringPattern("abcabcabcabc"));
	}
}
