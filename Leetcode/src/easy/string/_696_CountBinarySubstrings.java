package easy.string;

/**
 * Give a string s, count the number of non-empty (contiguous) substrings that
 * have the same number of 0's and 1's, and all the 0's and all the 1's in these
 * substrings are grouped consecutively.
 * 
 * Substrings that occur multiple times are counted the number of times they
 * occur.
 * 
 * Example 1: Input: "00110011" Output: 6 Explanation: There are 6 substrings
 * that have equal number of consecutive 1's and 0's: "0011", "01", "1100",
 * "10", "0011", and "01".
 * 
 * Notice that some of these substrings repeat and are counted the number of
 * times they occur.
 * 
 * Also, "00110011" is not a valid substring because all the 0's (and 1's) are
 * not grouped together. Example 2: Input: "10101" Output: 4 Explanation: There
 * are 4 substrings: "10", "01", "10", "01" that have equal number of
 * consecutive 1's and 0's. Note:
 * 
 * s.length will be between 1 and 50,000. s will only consist of "0" or "1"
 * characters. 
 * 
 * 題目說明 : 當連續的0、1個數相等時結果加一
 */

public class _696_CountBinarySubstrings {
	/*
	 * Solution_1 : curRunlength : 紀錄當下0或1的個數 prevTunlength : 儲存之前紀錄0或1的個數
	 */
	public static int countBinarySubstrings_Sol_1(String s) {
		int prevRunLength = 0, curRunLength = 1, res = 0;
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == s.charAt(i - 1)) {
				curRunLength++;
			} else {
				prevRunLength = curRunLength;
				curRunLength = 1;
			}
			if (prevRunLength >= curRunLength) {
				res++;
			}
		}
		return res;
	}

	/*
	 * Solution_2 : Math.min的應用 : 使得結果只會加上0、1相等的個數
	 */
	public static int countBinarySubstrings_Sol_2(String s) {
		int cur = 1, pre = 0, res = 0;
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == s.charAt(i - 1)) {
				cur++;
			} else {
				res += Math.min(cur, pre);
				pre = cur;
				cur = 1;
			}
		}
		return res + Math.min(cur, pre);
	}

	public static void main(String[] args) {
		System.out.println(countBinarySubstrings_Sol_2("00110"));
	}
}
