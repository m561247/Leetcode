package easy.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Given an array of size n, find the majority element. The majority element is
 * the element that appears more than ⌊ n/2 ⌋ times.
 * 
 * You may assume that the array is non-empty and the majority element always
 * exist in the array.
 * 
 * Example 1:
 * Input: [3,2,3] 
 * Output: 3 
 * 
 * Example 2:
 * Input: [2,2,1,1,1,2,2] 
 * Output: 2
 */
public class _169_MajorityElement {
	/*
	 * Soultion_1 : myself
	 */
	public static int majorityElement_Sol_1(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		int result = 0;
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
			if (map.get(nums[i]) > (nums.length / 2)) {
				result = nums[i];
				break;
			}
		}
		return result;
	}
	
	/*
	 * Solution_2 : 
	 */
	public static int majorityElement(int[] nums) {
		int majority = nums[0], count = 1;
		for (int i = 1; i < nums.length; i++) {
			if (count == 0) {
				count++;
				majority = nums[i];
			} else if (majority == nums[i]) {
				count++;
			} else {
				count--;
			}
		}
		return majority;
	}
}
