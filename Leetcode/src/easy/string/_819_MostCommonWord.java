package easy.string;

import java.util.*;

/**
 * Given a paragraph and a list of banned words, return the most frequent word
 * that is not in the list of banned words. It is guaranteed there is at least
 * one word that isn't banned, and that the answer is unique.
 * 
 * Words in the list of banned words are given in lowercase, and free of
 * punctuation. Words in the paragraph are not case sensitive. The answer is in
 * lowercase.
 * 
 * 
 * 
 * Example:
 * 
 * Input: paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
 * banned = ["hit"] 
 * Output: "ball" 
 * Explanation: "hit" occurs 3 times, but it is
 * a banned word. "ball" occurs twice (and no other word does), so it is the
 * most frequent non-banned word in the paragraph. Note that words in the
 * paragraph are not case sensitive, that punctuation is ignored (even if
 * adjacent to words, such as "ball,"), and that "hit" isn't the answer even
 * though it occurs more because it is banned.
 * 
 * 
 * Note:
 * 
 * 1 <= paragraph.length <= 1000. 0 <= banned.length <= 100. 1 <=
 * banned[i].length <= 10. The answer is unique, and written in lowercase (even
 * if its occurrences in paragraph may have uppercase symbols, and even if it is
 * a proper noun.) paragraph only consists of letters, spaces, or the
 * punctuation symbols !?',;. There are no hyphens or hyphenated words. Words
 * only consist of letters, never apostrophes or other punctuation symbols.
 * 
 * 題目說明 : 給一字串及一個字串陣列，回傳除字串陣列中出現的字串外，出現過最多次的字串的個數
 */
public class _819_MostCommonWord {
	/*
	 * Solution_1 : 運用集合API
	 */
//	public static String mostCommonWord(String paragraph, String[] banned) {
//		String[] words = paragraph.replaceAll("\\W+" , " ").toLowerCase().split("\\s+");
//		Set<String> ban = new HashSet<>(Arrays.asList(banned));
//		Map<String, Integer> map = new HashMap<>();
//		for (String word : words) {
//			if (!ban.contains(word)) {
//				map.put(word, map.getOrDefault(word, 0) + 1);
//			}
//		}
//		return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
//	}

	/*
	 * Solution_2 : use trie
	 * 
	 * 這個解法是使用字典樹來解，樹根代表空字串，每個字串都會有26個link，代表26個小寫字母。
	 * 我們在每個TrieNode中存放word(走到這實際的字串)和cnt(記錄這個字串有幾個)。
	 * 在mostCommonWord中，使用StringBuilder每次將合法的字元(大小寫字母)加入(並轉成小寫)，
	 * 在遇到非字母的字元的時候，就把目前的這個字串塞進字典樹裡。
	 * 
	 * TrieNode這邊有三個functions:
	 * 
	 * 1.insert: 
	 * 透過每個字母沿links的路徑走，如果curr.links[index] == null則表示前面還沒走過，
	 * 要自行new出來，並設定其word變數。 在走到底的時候我們要將cnt數加1。 
	 * 2.ban: 
	 * 只要將該string的cnt設成零即可。
	 * 如果在走的路徑途中遇到null，表示段落裡不存在這個string，直接return即可。 
	 * 3.findMax:
	 * 遍歷所有TrieNode並找到最大的cnt及對應的word。
	 */

	public static String res;
	public static int maxcount;

	public static String mostCommonWord(String paragraph, String[] banned) {
		TrieNode root = new TrieNode();
		StringBuilder sb = new StringBuilder();
		res = "";
		maxcount = 0;
		boolean isString = false;
		for (char c : paragraph.toCharArray()) {
			if (c >= 'a' && c <= 'z') {
				sb.append(c);
				isString = true;
			} else if (c >= 'A' && c <= 'Z') {
				sb.append((char) (c + 'a' - 'A'));
				isString = true;
			} else {
				if (isString) {
					root.insert(sb.toString());
					sb = new StringBuilder();
					isString = false;
				}
			}

		}
		if (isString) {
			root.insert(sb.toString());
		}
		for (String s : banned) {
			root.ban(s);
		}
		root.findMax(root);
		return res;
	}

	private static class TrieNode {
		String word = "";
		int count = 0;
		TrieNode[] links = new TrieNode[26];

		void insert(String s) {
			TrieNode curr = this;
			char[] chars = s.toCharArray();
			for (int i = 0; i < chars.length; ++i) {
				int index = chars[i] - 'a';
				if (curr.links[index] == null) {
					curr.links[index] = new TrieNode();
					curr.links[index].word = curr.word + chars[i];
				}
				curr = curr.links[index];
			}
			curr.count += 1;
		}

		void ban(String s) {
			char[] chars = s.toCharArray();
			TrieNode curr = this;
			for (int i = 0; i < chars.length; ++i) {
				int index = chars[i] - 'a';
				if (curr.links[index] == null) {
					return;
				}
				curr = curr.links[index];
			}
			curr.count = 0;
		}

		void findMax(TrieNode curr) {
			if (curr == null) {
				return;
			}
			if (curr.count > maxcount) {
				res = curr.word;
				maxcount = curr.count;
			}
			for (int i = 0; i < curr.links.length; ++i) {
				findMax(curr.links[i]);
			}
		}
	}

	public static void main(String[] args) {
//		String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
//		String[] ban = { "hit" };
//		System.out.println(mostCommonWord(paragraph, ban));
	}

}
