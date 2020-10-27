package easy.math;

/**
 * Given a column title as appear in an Excel sheet, return its corresponding
 * column number.
 * 
 * For example:
 * 
 * A -> 1 B -> 2 C -> 3 ... Z -> 26 AA -> 27 AB -> 28 ... 
 * Example 1:
 * 
 * Input: "A" 
 * Output: 1 
 * 
 * Example 2:
 * 
 * Input: "AB" 
 * Output: 28 
 * 
 * Example 3:
 * 
 * Input: "ZY" 
 * Output: 701
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 7 s consists only of uppercase English letters. s is between
 */
public class _171_ExcelSheetColumnNumber {
	/*
	 * Solution_1 : 
	 */
	public static int titleToNumber(String s) {
        int result = 0, i = 0;
        while (i < s.length()) {
        	result = result * 26 + s.charAt(i) - 'A' + 1;
        	i++;
        }
        return result;
    }
	public static void main(String[] args) {
		System.out.println(titleToNumber("ZY"));
	}
}
