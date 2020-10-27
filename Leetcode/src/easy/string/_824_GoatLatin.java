package easy.string;

import java.util.*;

/**
 * A sentence S is given, composed of words separated by spaces. Each word
 * consists of lowercase and uppercase letters only.
 * 
 * We would like to convert the sentence to "Goat Latin" (a made-up language
 * similar to Pig Latin.)
 * 
 * The rules of Goat Latin are as follows:
 * 
 * If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of
 * the word. 
 * For example, the word 'apple' becomes 'applema'.
 * 
 * If a word begins with a consonant (i.e. not a vowel), remove the first letter
 * and append it to the end, then add "ma". 
 * For example, the word "goat" becomes "oatgma".
 * 
 * Add one letter 'a' to the end of each word per its word index in the
 * sentence, starting with 1. 
 * For example, the first word gets "a" added to the
 * end, the second word gets "aa" added to the end and so on. Return the final
 * sentence representing the conversion from S to Goat Latin.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: "I speak Goat Latin" 
 * Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
 * Example 2:
 * 
 * Input: "The quick brown fox jumped over the lazy dog" 
 * Output: "heTmaa
 * uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa
 * azylmaaaaaaaaa ogdmaaaaaaaaaa"
 * 
 * 
 * Notes:
 * 
 * S contains only uppercase, lowercase and spaces. Exactly one space between
 * each word. 1 <= S.length <= 150.
 * 
 * 題目說明 : 輸入一串用空白分隔的字串，判斷字串開頭是否為母音，是的話在後面加上"ma"，不是的話把開頭移到字尾再加上"ma"
 * 然後依照被空白分割的字串加上"a"，從一開始計算
 */
public class _824_GoatLatin {
	/*
	 * Solution :
	 */
	public static String toGoatLatin(String S) {//"I speak Goat Latin"
		Set<Character> vowel = new HashSet<>();
		for (char c : "aeiouAEIOU".toCharArray()) {
			vowel.add(c);
		}
		StringBuilder sb = new StringBuilder();
		int count = 1;
		for (String w : S.split("\\s")) {
			String hasVowel = (vowel.contains(w.charAt(0)) ? w : w.substring(1) + w.charAt(0)) + "ma";
			sb.append(" ").append(hasVowel);
			for (int j = 0; j < count; ++j) {
				sb.append("a");
			}
			count++;
		}
		return sb.substring(1).toString();
	}
	public static void main(String[] args) {
		System.out.println(toGoatLatin("I speak Goat Latin"));
	}
}
