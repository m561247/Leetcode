package easy.string;
/**
 * Example:

Input: "Hello, my name is John"
Output: 5
 * @author user
 *
 */
public class _434_NumberOfSegmentsInAString {
	public static int countSegments(String s) {
		int result = 0;
		for (int i = 0; i < s.trim().length(); i++) {
			if (s.charAt(i) != ' ' && (i == 0 || s.charAt(i - 1) == ' ')) {
				result++;
			}
		}
		return result;
	}
	public static void main(String[] args) {
		System.out.println(countSegments("Hello, my name is John"));
	}
}
