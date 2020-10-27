package easy.string;

/**
 * Given two binary strings, return their sum (also a binary string).
 * 
 * The input strings are both non-empty and contains only characters 1 or 0.
 * 
 * Example 1:
 * Input: a = "11", b = "1" 
 * Output: "100" 
 * 
 * Example 2:
 * Input: a = "1010", b = "1011" 
 * Output: "10101"
 * 
 * 
 * Constraints:
 * 
 * Each string consists only of '0' or '1' characters. 1 <= a.length, b.length
 * <= 10^4 Each string is either "0" or doesn't contain any leading zero.
 */

public class _67_AddBinary {
	/*
	 * Solution_1 : 利用 reverse 使結果符合
	 */
	public static String addBinary_Sol_1(String a, String b) {
		StringBuilder result = new StringBuilder();
		int i = a.length() - 1, j = b.length() - 1, carry = 0;
		while (i >= 0 || j >= 0) { // 從頭開始加
			int sum = carry; // 記錄總和
			if (i >= 0) {
				sum += a.charAt(i) - '0';
				i--;
			}
			if (j >= 0) {
				sum += b.charAt(j) - '0';
				j--;
			}
			result.append(sum % 2);
			carry = sum / 2; // 補數
		}
		if (carry != 0) {
			result.append(carry);
		}
		return result.reverse().toString();
	}
	
	/*
	 * Solution_2 : 不使用 StringBuilder 的 reverse()
	 */
	public static String addBinary_Sol_2(String a, String b) {
		char[] aArray = a.toCharArray(), bArray = b.toCharArray();
		int aLen = aArray.length, bLen = bArray.length;
		int ptr = 0, carry = 0, aVal = 0, bVal = 0;
		String strToReturn = "";
		while (ptr < aLen || ptr < bLen) {
			aVal = 0; // 重置
			bVal = 0;
			if (ptr < aLen) {
				aVal = (aArray[aLen - 1 - ptr] == '1') ? 1 : 0; // convert from char to int
			}
			if (ptr < bLen) {
				bVal = (bArray[bLen - 1 - ptr] == '1') ? 1 : 0;
			}
			int finalVal = aVal + bVal + carry;
			if (finalVal > 1) { // 要進位
				carry = finalVal - 1;
				if (carry > 1) { 
					finalVal = 1;
					carry = 1;
				} else {
					finalVal = 0;
				}
			} else {
				carry = 0; // if either 0 or 1 after adding carry, just reset carry.
			}
			strToReturn = finalVal + "" + strToReturn; // add to front of string
			ptr++;
		}
		if (carry > 0) {
			strToReturn = "1" + strToReturn;
		}
		return strToReturn;
	}
	
	/*
	 * Solution_3 : beat 100%
	 */
	public static String addBinary_Sol_3(String a, String b) {
		char[] result = new char[Math.max(a.length(), b.length())];
		int carryBit = 0;
		for (int al = a.length() - 1, bl = b.length() - 1; al >= 0 || bl >= 0; --al, --bl) {
			int c1 = al < 0 ? 0 : (a.charAt(al) - '0');
			int c2 = bl < 0 ? 0 : (b.charAt(bl) - '0');
			result[Math.max(al, bl)] = (char) ((c1 + c2 + carryBit) % 2 + (int) '0');
			if ((c1 + c2 + carryBit) / 2 > 0) {
				carryBit = 1;
			} else {
				carryBit = 0;
			}
		}
		return (carryBit > 0 ? "1" : "") + new String(result);
	}
	
	
	
	public static void main(String[] args) {
		System.out.println(addBinary_Sol_3("1111", "1101"));
	}

}
