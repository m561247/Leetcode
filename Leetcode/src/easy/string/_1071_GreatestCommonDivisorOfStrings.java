package easy.string;
import java.util.regex.Pattern;

/**
 * For strings S and T, we say "T divides S" if and only if S = T + ... + T (T
 * concatenated with itself 1 or more times)
 * 
 * Return the largest string X such that X divides str1 and X divides str2.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: str1 = "ABCABC", str2 = "ABC" 
 * Output: "ABC" 
 * 
 * Example 2:
 * 
 * Input: str1 = "ABABAB", str2 = "ABAB" 
 * Output: "AB" Example 3:
 * 
 * Input: str1 = "LEET", str2 = "CODE" 
 * Output: ""
 * 
 * bb              bb
 * abcdabcd        abcd
 * 
 * Note:
 * 
 * 1 <= str1.length <= 1000 1 <= str2.length <= 1000 str1[i] and str2[i] are
 * English uppercase letters.
 * 
 * 題目說明 : 找出能分割str1、str2的最長字串
 */
public class _1071_GreatestCommonDivisorOfStrings {
	/*
	 * Solution_1 : 類似用遞迴找數字gcd
	 */
	public static String gcdOfStrings_Sol_1(String str1, String str2) {//str1 = "ABABAB", str2 = "ABAB" 
		if (str1.length() < str2.length()) {
			return gcdOfStrings_Sol_1(str2, str1);
		} else if (!str1.startsWith(str2)) {
			return "";
		} else if (str2.isEmpty()) {
			return str1;
		} else {
			return gcdOfStrings_Sol_1(str1.substring(str2.length()), str2);
		}
    }
	
	/*
	 * Solution_2 : 疊代
	 */
	public static String gcdOfStrings_Sol_2(String str1, String str2) {
		int i = 1, max = 0, len1 = str1.length(), len2 = str2.length();
		while (i <= len1 && i <= len2 && str1.charAt(i - 1) == str2.charAt(i - 1)) {
			boolean cd = true;// common divisor flag
			if (len1 % i == 0 && len2 % i == 0) { // substring length i must be the common divisor of lengthes of str1 and str2.
				String commonDivisorStr = str1.substring(0, i);
				for (int j = 2 * i; cd && j <= len1; j += i) {
					cd = commonDivisorStr.equals(str1.substring(j - i, j));// (1, 2) (2, 4) (3, 6)，判斷字串是幾個循環一次
				}
				for (int j = 2 * i; cd && j <= len2; j += i) {
					cd = commonDivisorStr.equals(str2.substring(j - i, j));
				}
				if (cd) {
					max = i;
				}
			}
			++i;
		}
		return str1.substring(0, max);
	}
	
	/*
	 * Solution_3 : regular expression
	 */
	public static String gcdOfStrings_Sol_3(String str1, String str2) {
		int d = gcd(str1.length(), str2.length());
		String gcd = str1.substring(0, d), ptn = "(" + gcd + ")+";
		return Pattern.compile(ptn).matcher(str1).matches() &&
				Pattern.compile(ptn).matcher(str2).matches() ? gcd : "";
	}
	
	
	/*
	 * Solution_4 : 在一開始就判斷這兩個字串有沒有可能有最大公因字串
	 */
	public static String gcdOfStrings_Sol_4(String str1, String str2) {
		if (!(str1 + str2).equals(str2 + str1)) {
			return "";
		}
		int len = str1.length();
		int len2 = str2.length();
		int gcd = gcd(len, len2);
		if (len < len2) {
			return str1.substring(0, gcd);
		}
		return str2.substring(0, gcd);
	}
	/* helper method */
	private static int gcd(int a, int b) {
		return a == 0 ? b : gcd(b % a, a);
	}
	
	public static void main(String[] args) {
		String str1 = "ABABAB", str2 = "ABAB", str3 = "bb", str4 = "bb";
		System.out.println(gcdOfStrings_Sol_2(str1, str2));
		System.out.println(gcdOfStrings_Sol_2(str3, str4));
	}
}
