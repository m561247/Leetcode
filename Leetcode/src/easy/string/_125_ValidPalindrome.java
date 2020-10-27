package easy.string;

/**
 * Given a string, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases.
 * 
 * Note: For the purpose of this problem, we define empty string as valid
 * palindrome.
 * 
 * Example 1: Input: "A man, a plan, a canal: Panama" 
 * Output: true
 * 
 * Example 2: Input: "race a car" 
 * Output: false
 * 
 * 
 * Constraints:
 * 
 * s consists only of printable ASCII characters.
 */
public class _125_ValidPalindrome {
	/*
	 * Solution_1 : 直觀的解法
	 */
	public static boolean isPalindrome(String s) {
		String lowS = s.toLowerCase();
		char[] chars = lowS.toCharArray();
		int charsLen = chars.length - 1;
		for (int i = 0, j = charsLen; i < j; i++, j--) {
			while (!Character.isLetterOrDigit(chars[i]) && i < j) {
				i++;
			}
			while (!Character.isLetterOrDigit(chars[j]) && i < j) { // 避免 indexOutOfBound exception
				j--;
			}
			if (chars[i] != chars[j]) {
				System.out.println(chars[i]);
				System.out.println(chars[j]);
				return false;
			}
		}
		return true;
	}
	
	/*
	 * Solution_2 : 
	 */
	public static boolean isPalindrome_Sol_2(String s) {
		if (s.isEmpty()) {
			return true;
		}
		int head = 0, tail = s.length() - 1;
		char cHead, cTail;
		while (head <= tail) {
			cHead = s.charAt(head);
			cTail = s.charAt(tail);
			if (!Character.isLetterOrDigit(cHead)) {
				head++;
			} else if (!Character.isLetterOrDigit(cTail)) {
				tail--;
			} else {
				if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
					return false;
				}
				head++;
				tail--;
			}
			
		}
		return true;
	}
	public static void main(String[] args) {
		System.out.println(isPalindrome_Sol_2("A man, a plan, a canal: Panama"));
	}
}
