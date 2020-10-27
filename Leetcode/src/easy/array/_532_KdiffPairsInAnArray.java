package easy.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given an array of integers and an integer k, you need to find the number of
 * unique k-diff pairs in the array. Here a k-diff pair is defined as an integer
 * pair (i, j), where i and j are both numbers in the array and their absolute
 * difference is k.
 * 
 * Example 1: 
 * Input: [3, 1, 4, 1, 5], k = 2 
 * Output: 2 
 * Explanation: There are two
 * 2-diff pairs in the array, (1, 3) and (3, 5). Although we have two 1s in the
 * input, we should only return the number of unique pairs. 
 * Example 2: 
 * Input:[1,
 * 2, 3, 4, 5], k = 1 
 * Output: 4 
 * Explanation: There are four 1-diff pairs in the
 * array, (1, 2), (2, 3), (3, 4) and (4, 5). 
 * Example 3: 
 * Input: [1, 3, 1, 5, 4],
 * k = 0 
 * Output: 1 Explanation: There is one 0-diff pair in the array, (1, 1).
 * Note: The pairs (i, j) and (j, i) count as the same pair. The length of the
 * array won't exceed 10,000. All the integers in the given input belong to the
 * range: [-1e7, 1e7].
 */
public class _532_KdiffPairsInAnArray {
	/*
	 * Solution_1 : by myself，
	 */
	public static int findPairs(int[] nums, int k) { // [3,1,4,1,5]
		int n = 0;
		Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
        	for (int j = i + 1; j < nums.length; j++) {
        		n = Math.abs(nums[i] - nums[j]);
        		if (k == n) {
        			if (nums[i] > nums[j]) { /* 數字小的當作 key，避免重複加入 key 沒被計算到 */
        				map.put(nums[j], nums[i]); 
        			}else {
        				map.put(nums[i], nums[j]);
        			}
        		}
        	}
        }
        return map.size();
    }
	
	/*
	 * Solution_2 : 
	 */
	public int findPairs_Sol_2(int[] nums, int k) {
		if (nums == null || nums.length == 0 || k < 0) {
			return 0;
		}
		Map<Integer, Integer> map = new HashMap<>();
		int count = 0;
		for (int i : nums) {
			map.put(i, map.getOrDefault(i, 0) + 1); // 
		}
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (k == 0) {
				// count how many elements in the array that appear more than twice
				if (entry.getValue() >= 2) {
					count++;
				} 
			} else {
				if (map.containsKey(entry.getKey() + k)) {
					count++;
				}
			}
		}
		return count;
	}
	
	/*
	 * Solution_3 : use set & map
	 */
	public int findPairs_Sol_3(int[] nums, int k) {
		if (k < 0) {
			return 0;
		}
		Set<Integer> starters = new HashSet<>();
		Set<Integer> uniqs = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (uniqs.contains(nums[i] - k)) { // 數字小的先出現的話，大的 - k = 小
				starters.add(nums[i] - k);
			}
			if (uniqs.contains(nums[i] + k)) { // 數字大的先出現的話，小的 + k = 大
				starters.add(nums[i]);
			}
			uniqs.add(nums[i]);
		}
		return starters.size();
	}
	public static void main(String[] args) {
		int[] nums = { 10, 20, 30, 40 };
	}
}
