package easy.string;

import java.util.Arrays;

/**
 * Let's define a function f(s) over a non-empty string s, which calculates the
 * frequency of the smallest character in s. For example, if s = "dcce" then
 * f(s) = 2 because the smallest character is "c" and its frequency is 2.
 * 
 * Now, given string arrays queries and words, return an integer array answer,
 * where each answer[i] is the number of words such that f(queries[i]) < f(W),
 * where W is a word in words.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: queries = ["cbd"], words = ["zaaaz"] 
 * Output: [1] 
 * Explanation: On the
 * first query we have f("cbd") = 1, f("zaaaz") = 3 so f("cbd") < f("zaaaz").
 * 
 * Example 2:
 * 
 * Input: queries = ["bbb","cc"], words = ["a","aa","aaa","aaaa"] 
 * Output: [1,2]
 * Explanation: On the first query only f("bbb") < f("aaaa"). On the second
 * query both f("aaa") and f("aaaa") are both > f("cc").
 * 
 * Constraints:
 * 
 * 1 <= queries.length <= 2000 1 <= words.length <= 2000 1 <= queries[i].length,
 * words[i].length <= 10 queries[i][j], words[i][j] are English lowercase
 * letters. 
 * 
 * 題目說明 : 用words陣列跟queries陣列比較，分別計算兩個陣列裡每個字串所含最小字母的重複數量
 * 			再返回一個int[]，裝入words陣列每個字串重複最小字母數多於queries陣列每個字串的個數
 */

public class _1170_CompareStringsByFrequencyOfTheSmallestCharacter {
	/*
	 * Solution_1 : 用binary search
	 * 
	 * q :     ["bba","abaaaaaa","aaaaaa","bbabbabaab","aba","aa","baab","bbbbbb","aab","bbabbaabb"]
	   words : ["aaabbb","aab","babbab","babbbb","b","bbbbbbbbab","a","bbbbbbbbbb","baaabbaab","aa"]
	 	expect:
	 	[6,1,1,2,3,3,3,1,3,2]
	 */
	public static int[] numSmallerByFrequency_Sol_1(String[] queries, String[] words) {
		// queries = ["bbb","cc"], words = ["a","aa","aaa","aaaa"]
		int[] q = new int[queries.length], w = new int[words.length];
		for (int i = 0; i < q.length; i++) {
			q[i] = calculateFreq(queries[i]);// 3, 2
		}
		for (int i = 0; i < w.length; i++) {
			w[i] = calculateFreq(words[i]);// 1, 2, 3, 4
		}
		Arrays.sort(w);
		int[] ans = new int[q.length];
		for (int i = 0; i < q.length; i++) {
			int l = 0, r = w.length - 1;
			while (l <= r) {// 若把等於拿掉的情況，output : [7,1,1,2,4,4,4,1,4,2]
				int mid = (l + r) / 2;
				if (w[mid] <= q[i]) {
					l = mid + 1;
				} else {
					r = mid - 1;
				}
			}
			ans[i] = w.length - l;
		}
		return ans;
	}

	/* helper method */
	private static int calculateFreq(String str) {
		int[] arr = new int[26];
		for (char ch : str.toCharArray()) {
			arr[ch - 'a']++;
		}
		for (int i = 0; i < 26; i++) {
			if (arr[i] != 0) {
				return arr[i];
			}
		}
		return 0;
	}

	/*
	 * Solution_2 : 不用binary search
	 */
	public static int[] numSmallerByFrequency_Sol_2(String[] queries, String[] words) {

		int[] fCount = new int[11];

		for (String word : words) {
			int count = getFCount(word);
			fCount[count]++;//最多0 - 10
		}

		int sum = 0;
		for (int i = 0; i < fCount.length; i++) {
			sum += fCount[i];
			fCount[i] = sum;
		}

		int[] res = new int[queries.length];

		for (int i = 0; i < queries.length; i++) {

			int count = getFCount(queries[i]);
			res[i] = fCount[fCount.length - 1] - fCount[count];
		}

		return res;
	}

	/* helper method */
	public static int getFCount(String word) {
		int[] count = new int[26];

		for (int i = 0; i < word.length(); i++) {
			count[word.charAt(i) - 'a']++;
		}

		for (int i = 0; i < count.length; i++) {
			if (count[i] != 0) {
				return count[i];
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		String[] queries = { "bbb", "cc" }, words = { "a", "aa", "aaa", "aaaa" };
		String[] queries2 = { "cbd" }, words2 = { "zaaaz" };
		for (Integer i : numSmallerByFrequency_Sol_1(queries2, words2)) {
			System.out.print(i + " ");
		}
	}
}
