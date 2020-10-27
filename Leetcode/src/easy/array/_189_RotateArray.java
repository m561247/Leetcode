package easy.array;

/**
 * Given an array, rotate the array to the right by k steps, where k is
 * non-negative.
 * 
 * Follow up:
 * 
 * Try to come up as many solutions as you can, there are at least 3 different
 * ways to solve this problem. Could you do it in-place with O(1) extra space?
 * 
 * 
 * Example 1:
 * Input: nums = [1,2,3,4,5,6,7], k = 3 
 * Output: [5,6,7,1,2,3,4] 
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6] rotate 2 steps to the right:
 * [6,7,1,2,3,4,5] rotate 3 steps to the right: [5,6,7,1,2,3,4] 
 * 
 * Example 2:
 * Input: nums = [-1,-100,3,99], k = 2 
 * Output: [3,99,-1,-100] 
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3] rotate 2 steps to the right:
 * [3,99,-1,-100]
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 2 * 10^4 It's guaranteed that nums[i] fits in a 32
 * bit-signed integer. k >= 0
 */
public class _189_RotateArray {
	/*
	 * Solution_1 : myslef, 非常慢
	 */
	public static void rotate(int[] nums, int k) {
		while (k > 0) {
			swap(nums);
			k--;
		}
	}
	/* help method */
	public static void swap(int[] nums) {
		for (int i = nums.length - 1; i > 0; i--) {
			int temp = nums[i];
			nums[i] = nums[i - 1];
			nums[i - 1] = temp;
		}
	}
	
	/*
	 * Solution_2 : 較快的作法，牽涉到矩陣運算
	 */
	public static void rotate_Sol_2(int[] nums, int k) { //[1,2,3,4,5,6,7]
		k %= nums.length;
		reverse(nums, 0, nums.length - 1);
		reverse(nums, 0, k - 1);
		reverse(nums, k, nums.length - 1);
	}
	/* help method */
	public static void reverse(int[] nums, int start, int end) {
		while (start < end) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
	}
	
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
		rotate_Sol_2(nums, 10);
	}
}
