package easy.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given an array of integers and an integer k, find out whether there are two
 * distinct indices i and j in the array such that nums[i] = nums[j] and the
 * absolute difference between i and j is at most k.
 * 
 * Example 1:
 * Input: nums = [1,2,3,1], k = 3 
 * Output: true 
 * 
 * Example 2:
 * Input: nums = [1,0,1,1], k = 1 
 * Output: true 
 * 
 * Example 3:
 * Input: nums = [1,2,3,1,2,3], k = 2 
 * Output: false
 */
public class _219_ContainsDuplicateII {
	/*
	 * Solution_1 : use set
	 */
	public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
        	if (i > k) {
        		set.remove(nums[i - k - 1]);
        	}
        	if (!set.add(nums[i])) {
        		return true;
        	}
        }
        return false;
    }
	
	/*
	 * Solution_2 : use hash map
	 */
	public boolean containsNearbyDuplicate_Sol_2(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			Integer ord = map.put(nums[i], i);
			if (ord != null && i - ord <= k) {
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(1, 1);
		int before = map.put(1, 10);
		System.out.println(before);
	}
}
