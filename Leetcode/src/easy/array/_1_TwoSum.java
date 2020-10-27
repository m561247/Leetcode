package easy.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target.
 * 
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * 
 * Example:
 * 
 * Given nums = [2, 7, 11, 15], target = 9,
 * 
 * Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
 */

public class _1_TwoSum {
	/*
	 * Solution_1 : 暴力解
	 */
	public static int[] twoSum_Sol_1(int[] nums, int target) {
		int[] result = new int[2];
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					result[0] = i;
					result[1] = j;
				}
			}
		}
		return result;
	}
	
	/*
	 * Solution_2 : HashMap one pass
	 */
	public int[] twoSum_Sol_2(int[] nums, int target) {
	    Map<Integer, Integer> map = new HashMap<>();
	    for (int i = 0; i < nums.length; i++) {
	        int complement = target - nums[i];
	        if (map.containsKey(complement)) {
	            return new int[] { map.get(complement), i };
	        }
	        map.put(nums[i], i);
	    }
	    throw new IllegalArgumentException("No two sum solution");
	}
	
	/*
	 * Solution_3 : HashMap two pass
	 */
	public static int[] twoSum_Sol_3(int[] nums, int target) {
//	    Map<Integer, Integer> map = new HashMap<>();
//	    for (int i = 0; i < nums.length; i++) {
//	        map.put(nums[i], i);
//	    }
//	    for (int i = 0; i < nums.length; i++) {
//	        int complement = target - nums[i];
//	        if (map.containsKey(complement) && map.get(complement) != i) {
//	            return new int[] { i, map.get(complement) };
//	        }
//	    }
//	    throw new IllegalArgumentException("No two sum solution");
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (map.containsKey(complement) && map.get(complement) != i) {
				return new int[] { i, map.get(complement) };
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}
	public static void main(String[] args) {
		int[] nums = {3, 4};
		int target = 7;
		System.out.println(twoSum_Sol_3(nums, target));
	}
}
