package easy.string;

/**
 * Write a function to find the longest common prefix string amongst an array of
 * strings.
 * 
 * If there is no common prefix, return an empty string "".
 * 
 * Example 1:
 * Input: ["flower","flow","flight"] 
 * Output: "fl" 
 * 
 * Example 2:
 * Input: ["dog","racecar","car"] 
 * Output: "" 
 * Explanation: There is no common
 * prefix among the input strings. Note:
 * 
 * All given inputs are in lowercase letters a-z.
 */
public class _14_LongestCommonPrefix {
	/*
	 * Solution_1 : faster solution
	 */
	public static String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0)
			return "";
		String pre = strs[0];
		int i = 1;
		while (i < strs.length) {
			while (strs[i].indexOf(pre) != 0)
				pre = pre.substring(0, pre.length() - 1);
			if (pre.length() == 0) {
				return "";
			} else {
				i++;
			}
		}
		return pre;
	}
	
	/*
	 * Solution_2 : by myself，以字串陣列中第一個字串為基準，從後面慢慢刪去字元再比對
	 */
	public static String longestCommonPrefix_Sol_2(String[] strs) {
		if (strs.length == 0) {
			return "";
		}
		String prefix = strs[0];
		for (int i = 1; i < strs.length; i++) {
			int len = prefix.length();
			while (len > 0) {
				if (strs[i].indexOf(prefix) != 0) {
					prefix = prefix.substring(0, len - 1);
					len--;
				} else {
					break;
				}
			}
		}
		return prefix;
	}
	
	public static void main(String[] args) {
		String[] strs = { "dog", "flower", "flight" };
		System.out.println(longestCommonPrefix(strs));
	}

}
