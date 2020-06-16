package easy.string;
/**
 * Example:

Input: "Hello World"
Output: 5
 * @author user
 *
 */
public class _58_LengthOfLastWord {
	public static int lengthOfLastWord(String s) {
		String sTrim = s.trim();
		int result = 0;
		for (int i = sTrim.length() - 1; i > 0; i--) {
			if (sTrim.charAt(i) == ' ')
				break;
			result++;
		}
		return result;
	}
	public static void main(String[] args) {
		System.out.println(lengthOfLastWord("Hello Worlda "));
	}

}
