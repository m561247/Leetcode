package easy.string;

/**
 * Given a string s consisting only of letters 'a' and 'b'. In a single step you
 * can remove one palindromic subsequence from s.
 * 
 * Return the minimum number of steps to make the given string empty.
 * 
 * A string is a subsequence of a given string, if it is generated by deleting
 * some characters of a given string without changing its order.
 * 
 * A string is called palindrome if is one that reads the same backward as well
 * as forward.
 * 
 * 
 * 
 * Example 1:
 * Input: s = "ababa" 
 * Output: 1 
 * Explanation: String is already palindrome
 * 
 * Example 2:
 * Input: s = "abb" 
 * Output: 2 
 * Explanation: "abb" -> "bb" -> "". Remove
 * palindromic subsequence "a" then "bb". 
 * 
 * Example 3:
 * Input: s = "baabb" 
 * Output: 2 
 * Explanation: "baabb" -> "b" -> "". Remove
 * palindromic subsequence "baab" then "b". 
 * 
 * Example 4:
 * Input: s = "" 
 * Output: 0
 * 
 * 
 * Constraints:
 * 
 * 0 <= s.length <= 1000 s only consists of letters 'a' and 'b'
 * 
 * 題目說明 : 判斷要幾步驟可以把字串變成空字串。
 * 			這題很怪，依據網路上的解釋，判斷輸入字串是否為回文，是的話只要一步即可，不是的話就先刪 "a" 或 "b" 其一
 * 			再刪另一個即可
 */
public class _1332_RemovePalindromicSubsequences {
	/*
	 * Solution_1 : 判斷是否回文，是的話1，不是的話2
	 */
	public static int removePalindromeSub_Sol_1(String s) {
        return s.isEmpty() ? 0 : s.equals(new StringBuilder(s).reverse().toString()) ? 1 : 2;
    }
	
	/*
	 * Solution_2 : 概念同 sol_1，差在解法
	 */
	public static int removePalindromeSub_Sol_2(String s) {
		if (s == null || "".equals(s) || s.length() == 0){
			return 0;
		}
		int i = 0, j = s.length() - 1;
		while (i < j) {
			if (s.charAt(i) == s.charAt(j)) {
				i++;
				j--;
			} else {
				return 2;
			}
		}
		return 1;
	}
}