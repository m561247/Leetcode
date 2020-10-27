package easy.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given an array of integers, find if the array contains any duplicates.
 * 
 * Your function should return true if any value appears at least twice in the
 * array, and it should return false if every element is distinct.
 * 
 * Example 1:
 * Input: [1,2,3,1] 
 * Output: true 
 * 
 * Example 2:
 * Input: [1,2,3,4] 
 * Output: false 
 * 
 * Example 3:
 * Input: [1,1,1,3,3,4,3,2,4,2] 
 * Output: true
 */
public class _217_ContainsDuplicate {
	/*
	 * Solution_1 : 暴力解。太慢
	 */
	public static boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
        	for (int j = i + 1; j < nums.length; j++) {
        		if (nums[i] == nums[j]) {
        			return true;
        		}
        	}
        }
        return false;
    }
	
	/*
	 * Solution_2 : hashmap
	 */
	public static boolean containsDuplicate_Sol_2(int[] nums) { // [1,1,1,3,3,4,3,2,4,2] 
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
			if (map.get(nums[i]) > 1) {
				return true;
			}
		}
		return false;
    }
	
	/*
	 * Solution_3 : use set
	 */
	public static boolean containsDuplicate_Sol_3(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int n : nums) {
			if (set.contains(n)) {
				return true;
			}
			set.add(n);
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		
	}
}
