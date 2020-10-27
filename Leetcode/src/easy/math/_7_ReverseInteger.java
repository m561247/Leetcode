package easy.math;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 * 
 * Example 1:
 * Input: 123 
 * Output: 321 
 * 
 * Example 2:
 * Input: -123 
 * Output: -321 
 * 
 * Example 3:
 * Input: 120 
 * Output: 21
 */
public class _7_ReverseInteger {
	/*
	 * Solution_1 : 
	 */
	public static int reverse(int x) {
		int revers = 0;
		while (x != 0) {
			revers = revers * 10 + x % 10;
			x /= 10;
		}
		return revers;
	}
	public static void main(String[] args) {
		System.out.println(reverse(-123));
	}
}
