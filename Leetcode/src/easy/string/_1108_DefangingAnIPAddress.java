package easy.string;

/**
 * Given a valid (IPv4) IP address, return a defanged version of that IP
 * address.
 * 
 * A defanged IP address replaces every period "." with "[.]".
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: address = "1.1.1.1" Output: "1[.]1[.]1[.]1" Example 2:
 * 
 * Input: address = "255.100.50.0" Output: "255[.]100[.]50[.]0"
 * 
 * 
 * Constraints:
 * 
 * The given address is a valid IPv4 address.
 */
public class _1108_DefangingAnIPAddress {
	/*
	 * Solution : 太簡單的一題
	 */
	public static String defangIPaddr(String address) {
		char[] chars = address.toCharArray();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == '.') {
				sb.append("[.]");
			} else {
				sb.append(chars[i]);
			}
		}
		return sb.toString();
    }
	public static void main(String[] args) {
		String address = "1.1.1.1";
		System.out.println(defangIPaddr(address));
	}
}
