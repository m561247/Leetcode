package easy.math;

/**
 * Given an integer n, return the number of trailing zeroes in n!.
 * 
 * Example 1:
 * Input: 3 
 * Output: 0 
 * Explanation: 3! = 6, no trailing zero. 
 * 
 * Example 2:
 * Input: 5 
 * Output: 1 
 * Explanation: 5! = 120, one trailing zero. 
 * Note: Your
 * solution should be in logarithmic time complexity.
 */
public class _172_FactorialTrailingZeroes {
	/*
	 * Solution : 每多一組 5 x 2 就會多一個 0，而 2 的個數必多於 5 的個數，因此計算 5 的個數即可得知有幾個 0
	 */
	public static int trailingZeroes(int n) {
		return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }
	public static void main(String[] args) {
		System.out.println(trailingZeroes(13));
	}
}
