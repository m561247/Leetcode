package easy.string;

/**
 * Given two strings A and B, find the minimum number of times A has to be
 * repeated such that B is a substring of it. If no such solution, return -1.
 * 
 * For example, with A = "abcd" and B = "cdabcdab".
 * 
 * Return 3, because by repeating A three times (“abcdabcdabcd”), B is a
 * substring of it; and B is not a substring of A repeated two times
 * ("abcdabcd").
 * 
 * Note: The length of A and B will be between 1 and 10000.
 * 
 * 題目說明 : A要乘以自身幾倍才能符合B
 */
public class _686_RepeatedStringMatch {

	public static int repeatedStringMatch(String A, String B) {
		int count = 0;
		StringBuilder sb = new StringBuilder();
		while (sb.length() < B.length()) {
			sb.append(A);
			count++;
		}
		if (sb.indexOf(B) != -1) {
			return count;
			// ex:B = 321321, A = 123
		} else if (sb.append(A).indexOf(B) != -1) {
			return ++count;
		} else {
			return -1;
		}
	}

	public static void main(String[] args) {
		System.out.println(repeatedStringMatch("123", "2312312312"));
	}
}
