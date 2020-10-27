package easy.string;

import java.util.Arrays;

/**
 * Given an integer n, return a string with n characters such that each
 * character in such string occurs an odd number of times.
 * 
 * The returned string must contain only lowercase English letters. If there are
 * multiples valid strings, return any of them.
 * 
 * 
 * 
 * Example 1:
 * Input: n = 4 
 * Output: "pppz" 
 * Explanation: "pppz" is a valid string since the
 * character 'p' occurs three times and the character 'z' occurs once. Note that
 * there are many other valid strings such as "ohhh" and "love". 
 * 
 * Example 2:
 * Input: n = 2 
 * Output: "xy" 
 * Explanation: "xy" is a valid string since the
 * characters 'x' and 'y' occur once. Note that there are many other valid
 * strings such as "ag" and "ur". 
 * 
 * Example 3:
 * Input: n = 7 
 * Output: "holasss"
 * 
 * 
 * Constraints:
 * 
 * 1 <= n <= 500
 * 
 * 題目說明 : 給定一個數字 n ，回傳一字串含有 n 個字元，其中每個字元的個數皆為奇數
 */
public class _1374_GenerateAStringWithCharactersThatHaveOddCounts {
	/*
	 * Solution : 
	 */
	public static String generateTheString(int n) {
		char[] str = new char[n];
		Arrays.fill(str, 'a');
		if (n % 2 == 0) {
			str[0] = 'b';
		}
		return String.valueOf(str);
	}
	public static void main(String[] args) {
	}
}
