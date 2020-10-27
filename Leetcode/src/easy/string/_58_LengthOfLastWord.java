package easy.string;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space
 * characters ' ', return the length of last word (last word means the last
 * appearing word if we loop from left to right) in the string.
 * 
 * If the last word does not exist, return 0.
 * 
 * Note: A word is defined as a maximal substring consisting of non-space
 * characters only.
 * 
 * Example:
 * 
 * Input: "Hello World" 
 * Output: 5
 */
public class _58_LengthOfLastWord {
	/*
	 * Solution_1 : use trim()
	 */
	public static int lengthOfLastWord_Sol_1(String s) {
		String use = s.trim();
		int count = 0;
		for (int i = use.length() - 1; i >= 0; i--) {
			if (use.charAt(i) != ' ') {
				count++;
			} else {
				break;
			}
		}
		return count;
	}
	
	/*
	 * Solution_2 : 
	 */
	public static int lengthOfLastWord_Sol_2(String s) {
		int length = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) != ' ') {
				length++;
			} else {
				if (length > 0) {
					return length;
				}
			}
		}
		return length;
	}
	public static void main(String[] args) {
	}

}
