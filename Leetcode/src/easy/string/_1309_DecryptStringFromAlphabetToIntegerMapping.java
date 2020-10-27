package easy.string;

/**
 * Given a string s formed by digits ('0' - '9') and '#' . We want to map s to
 * English lowercase characters as follows:
 * 
 * Characters ('a' to 'i') are represented by ('1' to '9') respectively.
 * Characters ('j' to 'z') are represented by ('10#' to '26#') respectively.
 * Return the string formed after mapping.
 * 
 * It's guaranteed that a unique mapping will always exist.
 * 
 * 
 * 
 * Example 1:
 * Input: s = "10#11#12" 
 * Output: "jkab" Explanation: "j" -> "10#" , "k" -> "11#"
 * , "a" -> "1" , "b" -> "2". 
 * 
 * Example 2:
 * Input: s = "1326#" 
 * Output: "acz" Example 3:
 * 
 * Input: s = "25#" 
 * Output: "y" Example 4:
 * 
 * Input: s = "12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"
 * Output: "abcdefghijklmnopqrstuvwxyz"
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 1000 s[i] only contains digits letters ('0'-'9') and '#'
 * letter. s will be valid string such that mapping is always possible.
 * 
 * 題目說明 : 1-9 對應 a-i，j 之後要加上"#"
 */
public class _1309_DecryptStringFromAlphabetToIntegerMapping {
	/*
	 * Solution : 
	 */
	public static String freqAlphabets(String s) {
		StringBuilder sb = new StringBuilder();
		char[] chars = s.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (i < chars.length - 2 && chars[i + 2] == '#') {
				int n = (chars[i] - '0') * 10 + (chars[i + 1] - '0');
				sb.append((char) ('j' + n - 10));
				i += 2;
			} else {
				sb.append((char) ('a' + chars[i] - '1'));
			}
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		String s = "12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#";
		System.out.println(freqAlphabets(s));
	}
}
