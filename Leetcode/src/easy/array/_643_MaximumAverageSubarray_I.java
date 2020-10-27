package easy.array;

/**
 * Given an array consisting of n integers, find the contiguous subarray of
 * given length k that has the maximum average value. And you need to output the
 * maximum average value.
 * 
 * Example 1:
 * 
 * Input: [1,12,-5,-6,50,3], k = 4 
 * Output: 12.75 
 * Explanation: Maximum average is
 * (12-5-6+50)/4 = 51/4 = 12.75
 * 
 * 
 * Note:
 * 
 * 1 <= k <= n <= 30,000. Elements of the given array will be in the range
 * [-10,000, 10,000].
 */
public class _643_MaximumAverageSubarray_I {
	/*
	 * Solution_1 : sliding window
	 */
	public static double findMaxAverage(int[] nums, int k) { // [1,12,-5,-6,50,3]
		long sum = 0;
        for (int i = 0; i < k; i++) {
        	sum += nums[i];
        }
        long max = sum;
        
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            max = Math.max(max, sum);
        }
        
        return max / 1.0 / k;
    }
	
	/*
	 * Solution_2 : Cumulative Sum
	 */
	public static double findMaxAverage_Sol_2(int[] nums, int k) {
		int[] sum = new int[nums.length];
		sum[0] = nums[0];
		for (int i = 1; i < nums.length; i++) { // sum[i] 存 nums[0] + ... + nums[i]
			sum[i] = sum[i - 1] + nums[i];
		}
		double res = sum[k - 1] * 1.0 / k;
		for (int i = k; i < nums.length; i++) {
			res = Math.max(res, (sum[i] - sum[i - k]) * 1.0 / k); // 相當於 slide window 的比法
		}
		return res;
	}
	
	
	
	public static void main(String[] args) {
		int[] nums = { 1,12,-5,-6,50,3 };
		findMaxAverage_Sol_2(nums, 4);
	}
}
