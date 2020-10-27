package easy.math;

/**
 * Implement int sqrt(int x).
 * 
 * Compute and return the square root of x, where x is guaranteed to be a
 * non-negative integer.
 * 
 * Since the return type is an integer, the decimal digits are truncated and
 * only the integer part of the result is returned.
 * 
 * Example 1:
 * 
 * Input: 4 
 * Output: 2 
 * 
 * Example 2:
 * Input: 8 
 * Output: 2 
 * Explanation: The square root of 8 is 2.82842..., and since
 * the decimal part is truncated, 2 is returned.
 */
public class _69_Sqrtx {
	/*
	 * TLE : brute force
	 */
	public static int mySqrt(int x) {
		int result = 0;
        for (int i = 0; i <= x; i++) {
        	if (i * i > x) {
        		result = i - 1;
        		break;
        	} else if (i * i == x) {
        		result = i;
        		break;
        	}
        }
        return result;
    }
	
	/*
	 * Solution_1 : Binary Search
	 */
	public static int sqrt_Sol_1(int x) {
		if (x == 0) {
			return 0;
		}
		int left = 1, right = Integer.MAX_VALUE;
		while (true) {
			int mid = left + (right - left) / 2;
			if (mid > x / mid) {
				right = mid - 1;
			} else if (mid == x / mid || mid + 1 > x / (mid + 1)) {
				return mid;
			} else if (mid < x / mid) {
				left = mid + 1;
			} 
		}
	} 
	public static void main(String[] args) {
		sqrt_Sol_1(8);
	}
}
