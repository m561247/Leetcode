package easy.string;

/**
 * Given a string s of zeros and ones, return the maximum score after splitting
 * the string into two non-empty substrings (i.e. left substring and right
 * substring).
 * 
 * The score after splitting a string is the number of zeros in the left
 * substring plus the number of ones in the right substring.
 * 
 * 
 * 
 * Example 1:
 * Input: s = "011101" 
 * Output: 5 
 * Explanation: All possible ways of splitting s
 * into two non-empty substrings are: left = "0" and right = "11101", score = 1
 * + 4 = 5 left = "01" and right = "1101", score = 1 + 3 = 4 left = "011" and
 * right = "101", score = 1 + 2 = 3 left = "0111" and right = "01", score = 1 +
 * 1 = 2 left = "01110" and right = "1", score = 2 + 1 = 3 
 * 
 * Example 2:
 * Input: s = "00111" 
 * Output: 5 
 * Explanation: When left = "00" and right = "111",
 * we get the maximum score = 2 + 3 = 5 
 * 
 * Example 3:
 * Input: s = "1111" 
 * Output: 3
 * 
 * 
 * Constraints:
 * 
 * 2 <= s.length <= 500 The string s consists of characters '0' and '1' only.
 * 
 * 題目說明 : 把字串分成左右兩部分，加總左邊的 0 個數、右邊的 1 個數，回傳最大值
 */
public class _1422_MaximumScoreAfterSplittingAString {
	/*
	 * Solution_1 : Logic behind this :
					Result = Max of (ZerosOnLeft + OnesOnRight)
					= Max of (ZerosOnLeft + (TotalOnes - OnesOnLeft))
					= Max of (ZerosOnLeft - OnesOnLeft) + TotalOnes (as TotalOnes is constant)
	 */
	public static int maxScore(String s) {
		int zeros = 0, ones = 0, max = Integer.MIN_VALUE;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '0') {
				zeros++;
			} else {
				ones++;
			}
			if (i != s.length() - 1) {
				max = Math.max(zeros - ones, max);
			}
		}
		return max + ones;
	}
	public static void main(String[] args) {
		
	}
}
