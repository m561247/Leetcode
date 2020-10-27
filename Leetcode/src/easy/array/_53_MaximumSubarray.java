package easy.array;

/**
 * Given an integer array nums, find the contiguous subarray (containing at
 * least one number) which has the largest sum and return its sum.
 * 
 * Example:
 * Input: [-2,1,-3,4,-1,2,1,-5,4], 
 * Output: 6 
 * Explanation: [4,-1,2,1] has the
 * largest sum = 6. 
 * 
 * Follow up:
 * 
 * If you have figured out the O(n) solution, try coding another solution using
 * the divide and conquer approach, which is more subtle.
 */
public class _53_MaximumSubarray {
	/*
	 * Sol_1 : dp解
	 */
	public static int maxSubArray_Sol_1(int[] nums) { // [-2,1,-3,4,-1,2,1,-5,4]
		int dp[] = new int[nums.length]; int max = nums[0]; dp[0] = nums[0]; 
		for (int i = 1; i < nums.length; i++) {			
			dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
			max = Math.max(max, dp[i]);
		}
		return max;
	}
	
	/*
	 * Solution_2 :
	 */
	public static int maxSubArray_Sol_2(int[] nums) {  // [-3,-2,-1]
		int max = Integer.MIN_VALUE, sum = 0;
		for (int i = 0; i < nums.length; i++) {
			if (sum < 0) {
				sum = nums[i];
			} else {
				sum += nums[i];
			}
			if (sum > max) {
				max = sum;
			}
		}
		return max;
	}
	
	/*
	 * Solution_3 : 
	 */
	public static int maxSubArray_Sol_3(int[] A) {
	    int maxSoFar=A[0], maxEndingHere=A[0];
	    for (int i=1;i<A.length;++i){
	    	maxEndingHere= Math.max(maxEndingHere+A[i],A[i]);
	    	maxSoFar=Math.max(maxSoFar, maxEndingHere);	
	    }
	    return maxSoFar;
	}
	public static void main(String[] args) {
		
	}
}
