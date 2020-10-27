package easy.string;

import java.util.HashSet;

/**
 * International Morse Code defines a standard encoding where each letter is
 * mapped to a series of dots and dashes, as follows: "a" maps to ".-", "b" maps
 * to "-...", "c" maps to "-.-.", and so on.
 * 
 * For convenience, the full table for the 26 letters of the English alphabet is
 * given below:
 * 
 * [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
 * Now, given a list of words, each word can be written as a concatenation of
 * the Morse code of each letter. For example, "cba" can be written as
 * "-.-..--...", (which is the concatenation "-.-." + "-..." + ".-"). We'll call
 * such a concatenation, the transformation of a word.
 * 
 * Return the number of different transformations among all words we have.
 * 
 * Example: 
 * Input: words = ["gin", "zen", "gig", "msg"] 
 * Output: 2 
 * Explanation:
 * The transformation of each word is: "gin" -> "--...-." "zen" -> "--...-."
 * "gig" -> "--...--." "msg" -> "--...--."
 * 
 * There are 2 different transformations, "--...-." and "--...--.". Note:
 * 
 * The length of words will be at most 100. Each words[i] will have length in
 * range [1, 12]. words[i] will only consist of lowercase letters.
 * 題目說明 : 
 */
public class _804_UniqueMorseCodeWords {
	/*
	 * Solution : 用set過濾掉相同的摩斯密碼
	 */
	public static int uniqueMorseRepresentations(String[] words) {//words ["gin", "zen", "gig", "msg"] 
		String[] mos = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
		HashSet<String> set = new HashSet<>();
		for (String s : words) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < s.length(); i++) {
				sb.append(mos[s.charAt(i) - 'a']);
			}
			set.add(sb.toString());
		}
		return set.size();
	}
	public static void main(String[] args) {
		String[] words = {"gin", "zen", "gig", "msg"};
		System.out.println(uniqueMorseRepresentations(words));
	}
}
