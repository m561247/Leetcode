package easy.math;

/**
 * Given a positive integer, return its corresponding column title as appear in
 * an Excel sheet.
 * 
 * For example:
 * 
 * 1 -> A 
 * 2 -> B 
 * 3 -> C 
 * ... 
 * 26 -> Z 
 * 27 -> AA 
 * 28 -> AB ... 
 * 
 * Example 1:
 * Input: 1 
 * Output: "A" 
 * 
 * Example 2:
 * Input: 28 
 * Output: "AB" 
 * 
 * Example 3:
 * Input: 701 
 * Output: "ZY"
 */
public class _168_ExcelSheetColumnTitle {
	/*
	 * Solution_1 : recursion，26 的時候就會進位，所以要減一
	 */
	public static String convertToTitle_Sol_1(int n) {
		return n == 0 ? "" : convertToTitle_Sol_1(--n / 26) + (char)('A' + (n % 26));
	}
	
	/*
	 * Solution_2 : iteration
	 */
	public static String convertToTitle_Sol_2(int n) {
		String result = "";
		while (n > 0) {
			char temp = (char) ((n % 26 == 0 ? 26 : n % 26) + 64);
			result = temp + result;
			n = (n % 26 == 0 ? n / 26 - 1 : n / 26);
		}
		return result;
	}
	public static void main(String[] args) {
		System.out.println(convertToTitle_Sol_2(701));
	}
	
}
