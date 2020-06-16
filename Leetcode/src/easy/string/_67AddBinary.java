package easy.string;
/**
Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"
 * @author user
 *
 */
public class _67AddBinary {
	public static String addBinary(String a, String b) {
		StringBuilder sb = new StringBuilder();
		int i = a.length() - 1, j = b.length() -1, carry = 0;
		while (i >= 0 || j >= 0) {
			int sum = carry;
			if (i >= 0) sum += a.charAt(i) - '0';
				i--;
			if (j >= 0) sum += b.charAt(j) - '0';
				j--;
			sb.append(sum % 2);
			carry = sum / 2;
		}
		if (carry != 0) sb.append(carry);
		return sb.reverse().toString();
	}
	public static void main(String[] args) {
		System.out.println(addBinary("11", "1"));
	}

}
