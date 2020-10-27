package easy.array;

import java.util.Arrays;

/**
 * Given an integer array, find three numbers whose product is maximum and
 * output the maximum product.
 * 
 * Example 1:
 * Input: [1,2,3] 
 * Output: 6
 * 
 * 
 * Example 2:
 * Input: [1,2,3,4] 
 * Output: 24
 * 
 * 
 * Note:
 * The length of the given array will be in range [3,104] and all elements are
 * in the range [-1000, 1000]. Multiplication of any three numbers in the input
 * won't exceed the range of 32-bit signed integer.
 */
public class _628_MaximumProductOfTheNumbers {
	/*
	 * Solution_1 : sort
	 */
	public int maximumProduct(int[] nums) {
		Arrays.sort(nums);
		return Math.max(nums[0] * nums[1] * nums[nums.length - 1], nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3]);
	}
	
	/*
	 * Solution_2 : 只需要找到正整數前三大或是負整數前二小、正整數最大
	 */
	public int maximumProduct_Sol_2(int[] nums) {
		int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE, min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
		for (int i : nums) {
			/* 找前三大 */
			if (i > max1) {
				max3 = max2;
				max2 = max1;
				max1 = i;
			} else if (i > max2) {
				max3 = max2;
				max2 = i;
			} else if (i > max3) {
				max3 = i;
			}
			/* 找前二小 */
			if (i < min1) {
				min2 = min1;
				min1 = i;
			} else if (i < min2) {
				min2 = i;
			}
		}
		return Math.max(max1 * max2 * max3, max1 * min1 * min2);
	}
}
