package easy.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D
 * and M.
 * 
 * Symbol Value I 1 V 5 X 10 L 50 C 100 D 500 M 1000 For example, two is written
 * as II in Roman numeral, just two one's added together. Twelve is written as,
 * XII, which is simply X + II. The number twenty seven is written as XXVII,
 * which is XX + V + II.
 * 
 * Roman numerals are usually written largest to smallest from left to right.
 * However, the numeral for four is not IIII. Instead, the number four is
 * written as IV. Because the one is before the five we subtract it making four.
 * The same principle applies to the number nine, which is written as IX. There
 * are six instances where subtraction is used:
 * 
 * I can be placed before V (5) and X (10) to make 4 and 9. X can be placed
 * before L (50) and C (100) to make 40 and 90. C can be placed before D (500)
 * and M (1000) to make 400 and 900. Given a roman numeral, convert it to an
 * integer. Input is guaranteed to be within the range from 1 to 3999.
 * 
 * Example 1:
 * Input: "III" 
 * Output: 3 
 * 
 * Example 2:
 * Input: "IV" 
 * Output: 4 
 * 
 * Example 3:
 * Input: "IX" 
 * Output: 9 
 * 
 * Example 4:
 * Input: "LVIII" 
 * Output: 58 
 * Explanation: L = 50, V= 5, III = 3. Example 5:
 * 
 * Input: "MCMXCIV" Output: 1994 Explanation: M = 1000, CM = 900, XC = 90 and IV
 * = 4.
 * 
 * 題目說明 : 羅馬數字轉10進位數字
 */
public class _13_RomanToInteger {
	/*
	 * Solution_1 : 7ms solution
	 */
	public static int romanToInt_Sol_1(String s) {
		int nums[] = new int[s.length()];
		for (int i = 0; i < s.length(); i++) {
			switch (s.charAt(i)) {
			case 'M':
				nums[i] = 1000;
				break;
			case 'D':
				nums[i] = 500;
				break;
			case 'C':
				nums[i] = 100;
				break;
			case 'L':
				nums[i] = 50;
				break;
			case 'X':
				nums[i] = 10;
				break;
			case 'V':
				nums[i] = 5;
				break;
			case 'I':
				nums[i] = 1;
				break;
			}
		}
		int sum = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] < nums[i + 1])
				sum -= nums[i];
			else
				sum += nums[i];
		}
		return sum + nums[nums.length - 1];
	}
	
	/*
	 * Solution_2 : by myself，跟後面一個數字比，比較小就減，比較大就加
	 */
	public static int romanToInt_Sol_2(String s) {
		Map<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		int result = 0;
		for (int i = 0; i < s.length() - 1; i++) {
			if (map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
				result -= map.get(s.charAt(i));
			} else {
				result += map.get(s.charAt(i));
			}
		}
		result += map.get(s.charAt(s.length() - 1));
		return result;
	}
	public static void main(String[] args) {

	}
}
