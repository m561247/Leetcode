package easy.string;

/**
 * Count the number of segments in a string, where a segment is defined to be a
 * contiguous sequence of non-space characters.
 * 
 * Please note that the string does not contain any non-printable characters.
 * 
 * Example:
 * 
 * Input: "Hello, my name is John" 
 * Output: 5
 */

public class _434_NumberOfSegmentsInAString {
	/*
	 * Solution : 
	 */
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
		String s = ", , , ,        a, eaefa";
		System.out.println(countSegments(s));
	}
	
}
