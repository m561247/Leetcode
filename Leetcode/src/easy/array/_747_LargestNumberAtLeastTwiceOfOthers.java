package easy.array;

import java.util.HashMap;

/**
 * In a given integer array nums, there is always exactly one largest element.
 * 
 * Find whether the largest element in the array is at least twice as much as
 * every other number in the array.
 * 
 * If it is, return the index of the largest element, otherwise return -1.
 * 
 * Example 1:
 * Input: nums = [3, 6, 1, 0] 
 * Output: 1 
 * Explanation: 6 is the largest integer,
 * and for every other number in the array x, 6 is more than twice as big as x.
 * The index of value 6 is 1, so we return 1.
 * 
 * 
 * Example 2:
 * Input: nums = [1, 2, 3, 4] 
 * Output: -1 
 * Explanation: 4 isn't at least as big as
 * twice the value of 3, so we return -1.
 * 
 * 
 * Note:
 * 
 * nums will have a length in the range [1, 50]. Every nums[i] will be an
 * integer in the range [0, 99].
 */
public class _747_LargestNumberAtLeastTwiceOfOthers {
	/*
	 * Solution_1 : 用 map 存最大值、他的索引值
	 */
	public static int dominantIndex(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int largest = nums[0];
		for (int i = 0; i < nums.length; i++) {
			largest = Math.max(largest, nums[i]);
			map.putIfAbsent(largest, i);
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == largest) {
				continue;
			}
			if (nums[i] * 2 > largest) {
				return -1;
			}
		}
		return map.get(largest);
    }
	
	/*
	 * Solution_2 : 
	 */
	public static int dominantIndex_Sol_2(int[] nums) {
		int max = -1, index = -1, second = -1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > max) {
				second = max;
				max = nums[i];
				index = i;
			} else if (nums[i] > second) {
				second = nums[i];
			}
		}
		return second * 2  <= max ? index : -1;
	}
	
	public static void main(String[] args) {
		int[] nums = { 3, 6, 1, 0 };
		System.out.println(dominantIndex(nums));
	}
}
