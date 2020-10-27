package easy.string;

/**
 * Given a word, you need to judge whether the usage of capitals in it is right
 * or not.
 * 
 * We define the usage of capitals in a word to be right when one of the
 * following cases holds:
 * 
 * All letters in this word are capitals, like "USA". All letters in this word
 * are not capitals, like "leetcode". Only the first letter in this word is
 * capital, like "Google". Otherwise, we define that this word doesn't use
 * capitals in a right way.
 * 
 * 
 * Example 1:
 * Input: "USA" 
 * Output: True
 * 
 * Example 2:
 * Input: "FlaG" 
 * Output: False
 * 
 * 
 * Note: The input will be a non-empty word consisting of uppercase and
 * lowercase latin letters.
 */
public class _520_DetectCapital {
	/*
	 * Solution_1 : 
	 */
	public static boolean detectCapitalUse_Sol_1(String word) {
		String regex = "[A-Z]+|[a-z]+|[A-Z][a-z]+";
		return word.matches(regex);
	}
	/*
	 * Solution_2 : 
	 */
	public static boolean detectCapitalUse_Sol_2(String word) {
		int count = 0;
		for (char c : word.toCharArray()) {
			if ('Z' - c >= 0) {
				count++;
			}
		}
		return (count == 0 || count == word.length()) || 
				('Z' - word.charAt(0) >= 0 && count == 1);
	}
	
	public static void main(String[] args) {
		String s = "1234567";
	}
}
