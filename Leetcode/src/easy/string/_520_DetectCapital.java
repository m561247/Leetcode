package easy.string;
/**
 * 
Example 1:

Input: "USA"
Output: True
 

Example 2:

Input: "FlaG"
Output: False

Note: The input will be a non-empty word consisting of uppercase and
 lowercase latin letters.
 *
 */
public class _520_DetectCapital {
	/*
	 * version 1 : 正規表示法
	 */
//	public static boolean detectCapitalUse(String word) {
//		String regex = "[A-Z]+|[a-z]+|[A-Z][a-z]+";
//		return word.matches(regex);
//	}
	/*
	 * version 2 : API版本
	 */
	public static boolean detectCapitalUse(String word) {
		if (word.length() < 2) {
			return true;
		} else if (word.toUpperCase().equals(word)) {
			return true;
		} else if (word.substring(1).toLowerCase().equals(word.substring(1))) {
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		String s = "1234567";
		System.out.println(detectCapitalUse("aoogle"));
	}
}
