package easy.string;

/**
 * Implement strStr().
 * 
 * Return the index of the first occurrence of needle in haystack, or -1 if
 * needle is not part of haystack.
 * 
 * Example 1:
 * Input: haystack = "hello", needle = "ll" 
 * Output: 2 
 * 
 * Example 2:
 * Input: haystack = "aaaaa", needle = "bba" 
 * Output: -1 
 * 
 * Clarification:
 * 
 * What should we return when needle is an empty string? This is a great
 * question to ask during an interview.
 * 
 * For the purpose of this problem, we will return 0 when needle is an empty
 * string. This is consistent to C's strstr() and Java's indexOf().
 * 
 * 題目說明 : 實作 indexOf()
 */

public class _28_ImplementstrStr {
	/*
	 * Solution_1 : 寫法漂亮，但是速度很慢。值得注意的是此處的 for 迴圈沒有結束條件
	 */
	public static int strStr_Sol_1(String haystack, String needle) {
		for (int i = 0; ; i++) {
			for (int j = 0; ; j++) {
				if (j == needle.length()) {
					return i;
				}
				if (i + j == haystack.length()) {
					return -1;
				}
				if (needle.charAt(j) != haystack.charAt(i + j)) {
					break;
				}
			}
		}
	}
	
	/*
	 * Solution_2 : KMP solution
	 */
	public static int strStr_Sol_2(String haystack, String needle) {
		if (needle.isEmpty()) {
			return 0;
		}
		int[] lps = computeKMPTable(needle);
		int i = 0, j = 0, h = haystack.length(), n = needle.length();
		while (i < h) {
			if (haystack.charAt(i) == needle.charAt(j)) {
				++i;
				++j;
				if(j == n) {
					return i - n;
				}
			} else {
				if (j != 0) {
					j = lps[j - 1];
				} else {
					i++;
				}
			}
		}
		return -1;
	}
	/* help method */
	private static int[] computeKMPTable(String pattern) {
		int i = 1, j = 0, n = pattern.length();
		int[] lps = new int[n];
		while (i < n) {
			if (pattern.charAt(i) == pattern.charAt(j)) {
				lps[i++] = ++j;
			} else {
				if (j != 0) {
					j = lps[j - 1];
				} else {
					i++;
				}
			}
		}
		return lps;
	}
	
	
	public static void main(String[] args) {
		String haystack = "abcdabcdaabcac", needle = "daab";
		System.out.println(strStr_Sol_2(haystack, needle));
	}

}
