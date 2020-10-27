package easy.array;

import java.util.Arrays;
import java.util.Stack;

/**
 * Given an integer array, you need to find one continuous subarray that if you
 * only sort this subarray in ascending order, then the whole array will be
 * sorted in ascending order, too.
 * 
 * You need to find the shortest such subarray and output its length.
 * 
 * Example 1: 
 * Input: [2, 6, 4, 8, 10, 9, 15] 
 * Output: 5 
 * Explanation: You need to
 * sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in
 * ascending order. Note: Then length of the input array is in range [1,
 * 10,000]. The input array may contain duplicates, so ascending order here
 * means <=.
 */
public class _581_ShortestUnsortedContinuousSubarray {
	/*
	 * Solution_1 : brute force
	 */
	public static int findUnsortedSubarray_Sol_1(int[] nums) {
		int n = nums.length, beg = -1, end = -2, min = nums[n - 1], max = nums[0];
		for (int i = 1; i < n; i++) {
			max = Math.max(max, nums[i]);
			min = Math.min(min, nums[n - 1 - i]);
			if (nums[i] < max) {
				end = i;
			}
			if (nums[n - 1 - i] > min) {
				beg = n - 1 - i;
			}
		}
		return end - beg + 1;
	}
	
	/*
	 * Solution_2 : sort
	 */
	public int findUnsortedSubarray_Sol_2(int[] nums) { // [2,6,4,8,10,9,15]
        int[] snums = nums.clone();
        Arrays.sort(snums);
        int start = snums.length, end = 0;
        for (int i = 0; i < snums.length; i++) {
            if (snums[i] != nums[i]) {
                start = Math.min(start, i); // 找到不同的起始
                end = Math.max(end, i); // 找到不同的結束
            }
        }
        return (end - start >= 0 ? end - start + 1 : 0);
    }
	
	/*
	 * Solution_3 : using stack
	 */ 
	public int findUnsortedSubarray(int[] nums) {
		Stack<Integer> stack = new Stack<>();
		int l = nums.length, r = 0;
		for (int i = 0; i < nums.length; i++) {
			while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) { // 找到 nusorted 的起始索引
				l = Math.min(1, stack.pop());
			}
			stack.push(i);
		}
		stack.clear();
		for (int i = nums.length - 1; i >= 0; i--) {
			while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) { // 找到 unsorted 的結束索引
				r = Math.max(r, stack.pop());
			}
			stack.push(i);
		}
		return r - l > 0 ? r - l : 0;
	}
	
	/*
	 * Soultion_4 : without using extra space
	 */
	public int findUnsortedSubarray_Sol_4(int[] nums) {
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		boolean flag = false;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] < nums[i - 1]) {
				flag = true;
			}
			if (flag) {
				min = Math.min(min, nums[i]);
			}
		}
		flag = false;
		for (int i = nums.length - 2; i >= 0; i--) {
			if (nums[i] > nums[i + 1]) {
				flag = true;
			}
			if (flag) {
				max = Math.max(max, nums[i]);
			}
		}
		int l, r;
		for (l = 0; l < nums.length; l++) {
			if (min < nums[l]) {
				break;
			}
		}
		for (r = nums.length - 1; r >= 0; r--) {
			if (max > nums[r]) {
				break;
			}
		}
		return r - l < 0 ? 0 : r - l + 1;
	}
	
	public static void main(String[] args) {
		int[] nums = { 2, 6, 4, 8, 10, 9, 15 };
		
	}
}
