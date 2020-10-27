package easy.string;

/**
 * Example 1:
 * 
 * Input: a = "aba", b = "cdc" Output: 3 Explanation: The longest uncommon
 * subsequence is "aba", because "aba" is a subsequence of "aba", but not a
 * subsequence of the other string "cdc". Note that "cdc" can be also a longest
 * uncommon subsequence. Example 2:
 * 
 * Input: a = "aaa", b = "bbb" Output: 3 Example 3:
 * 
 * Input: a = "aaa", b = "aaa" Output: -1
 * 
 * 
 * Constraints:
 * 
 * Both strings' lengths will be between [1 - 100]. Only letters from a ~ z will
 * appear in input strings.
 * 
 *
 *         不懂這題在幹嘛，可以跳過
 */
public class _521_LongestUncommonSubsequenceI {
	public int findLUSlength(String a, String b) {
		return a.equals(b) ? -1 : Math.max(a.length(), b.length());
	}
}
