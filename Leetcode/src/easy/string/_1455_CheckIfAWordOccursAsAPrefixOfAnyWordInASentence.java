package easy.string;

/**
 * Given a sentence that consists of some words separated by a single space, and
 * a searchWord.
 * 
 * You have to check if searchWord is a prefix of any word in sentence.
 * 
 * Return the index of the word in sentence where searchWord is a prefix of this
 * word (1-indexed).
 * 
 * If searchWord is a prefix of more than one word, return the index of the
 * first word (minimum index). If there is no such word return -1.
 * 
 * A prefix of a string S is any leading contiguous substring of S.
 * 
 * 
 * 
 * Example 1:
 * Input: sentence = "i love eating burger", searchWord = "burg" 
 * Output: 4
 * Explanation: "burg" is prefix of "burger" which is the 4th word in the
 * sentence. 
 * 
 * Example 2:
 * Input: sentence = "this problem is an easy problem", searchWord = "pro"
 * Output: 2 
 * Explanation: "pro" is prefix of "problem" which is the 2nd and the
 * 6th word in the sentence, but we return 2 as it's the minimal index. 
 * 
 * Example 3:
 * Input: sentence = "i am tired", searchWord = "you" 
 * Output: -1 Explanation:
 * "you" is not a prefix of any word in the sentence. 
 * 
 * Example 4:
 * Input: sentence = "i use triple pillow", searchWord = "pill" Output: 4
 * 
 * Example 5:
 * Input: sentence = "hello from the other side", searchWord = "they" 
 * Output: -1
 * 
 * 
 * Constraints:
 * 
 * 1 <= sentence.length <= 100 1 <= searchWord.length <= 10 sentence consists of
 * lowercase English letters and spaces. searchWord consists of lowercase
 * English letters.
 * 
 * 題目說明 : 給一段句子字串及欲搜尋的前綴字串，以空白區分句子中的每個單字，回傳符合前綴字串的單字索引
 */
public class _1455_CheckIfAWordOccursAsAPrefixOfAnyWordInASentence {
	/*
	 * Solution : 
	 */
	public static int isPrefixOfWord(String sentence, String searchWord) {
		// i am a dog           dog 4
		int index = 0;
		for (String s : sentence.split(" ")) {
			index++;
			if (s.indexOf(searchWord) == 0) {
				return index;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		String sentence = "this problem is an easy problem";
		String searchWord = "pro";
		System.out.println(isPrefixOfWord(sentence, searchWord));
		String s = "fuck";
		System.out.println(s.indexOf("fu"));
	}
}
