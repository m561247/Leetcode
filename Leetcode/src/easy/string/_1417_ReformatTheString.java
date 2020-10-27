package easy.string;

/**
 * Given alphanumeric string s. (Alphanumeric string is a string consisting of
 * lowercase English letters and digits).
 * 
 * You have to find a permutation of the string where no letter is followed by
 * another letter and no digit is followed by another digit. That is, no two
 * adjacent characters have the same type.
 * 
 * Return the reformatted string or return an empty string if it is impossible
 * to reformat the string.
 * 
 * 
 * 
 * Example 1:
 * Input: s = "a0b1c2" 
 * Output: "0a1b2c" 
 * Explanation: No two adjacent characters
 * have the same type in "0a1b2c". "a0b1c2", "0a1b2c", "0c2a1b" are also valid
 * permutations. 
 * 
 * Example 2:
 * Input: s = "leetcode" 
 * Output: "" 
 * Explanation: "leetcode" has only characters
 * so we cannot separate them by digits. 
 * 
 * Example 3:
 * Input: s = "1229857369" 
 * Output: "" 
 * Explanation: "1229857369" has only digits
 * so we cannot separate them by characters. 
 * 
 * Example 4:
 * Input: s = "covid2019" 
 * Output: "c2o0v1i9d" 
 * 
 * Example 5:
 * Input: s = "ab123" 
 * Output: "1a2b3"
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 500 s consists of only lowercase English letters and/or
 * digits.
 * 
 * 題目說明 : 輸入一個只有小寫字母、數字的字串，將他們重新排列，排列方式為無相鄰字母、數字
 */
public class _1417_ReformatTheString {
	/*
	 * Solution_1 : 
	 */
	public static String reformat(String s) { // "ab123" -> 1a2b3
		if (s == null || s.length() == 0) {
			return "";
		}
		int ds = 0, as = 0;
		char[] chars = s.toCharArray(), res = new char[s.length()];
		for (char c : chars) {
			if (Character.isDigit(c)) {
				ds++;
			} else if (Character.isLetter(c)) {
				as++;
			} else {
				return "";
			}
		}
		if (Math.abs(as -ds) > 1) {
			return "";
		}
		boolean isDigit = ds >= as;
		for (int i = 0, a = 0, d = 0; i < chars.length; i++) {
			if (isDigit) {
				while (!Character.isDigit(chars[d])) { // 找到第一個數字
					d++;
				}
				res[i] = chars[d++];
			} else {
				while (!Character.isLetter(chars[a])) { // 找到第一個字母
					a++;
				}
				res[i] = chars[a++];
			}
			isDigit = !isDigit;
		}
		return String.valueOf(res);
	}
	public static void main(String[] args) {
		String s = "abc123";
		System.out.println(reformat(s));
	}
}
