package easy.array;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a non-empty array of non-negative integers nums, the degree of this
 * array is defined as the maximum frequency of any one of its elements.
 * 
 * Your task is to find the smallest possible length of a (contiguous) subarray
 * of nums, that has the same degree as nums.
 * 
 * 
 * 
 * Example 1:
 * Input: nums = [1,2,2,3,1] 
 * Output: 2 
 * Explanation: The input array has a degree
 * of 2 because both elements 1 and 2 appear twice. Of the subarrays that have
 * the same degree: [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2,
 * 2, 3], [2, 2] The shortest length is 2. So return 2. 
 * 
 * Example 2:
 * Input: nums = [1,2,2,3,1,4,2] 
 * Output: 6 
 * Explanation: The degree is 3 because
 * the element 2 is repeated 3 times. So [2,2,3,1,4,2] is the shortest subarray,
 * therefore returning 6.
 * 
 * 
 * Constraints:
 * 
 * nums.length will be between 1 and 50,000. nums[i] will be an integer between
 * 0 and 49,999.
 */
public class _697_DegreeOfAnArray {
	/*
	 * Solution_1 : 我們需要計算每個不同數字的出現的頻率、第一次出現的索引值
	 */
	public static int findShortestSubArray(int[] nums) { // [1,2,2,3,1,4,2]  output : 6
		Map<Integer, Integer> count = new HashMap<>(), first = new HashMap<>();
		int res = 0, degree = 0;
		for (int i = 0; i < nums.length; i++) {
			first.putIfAbsent(nums[i], i); // 記錄數字第一次出現的索引值
			count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
			if (count.get(nums[i]) > degree) {
				degree = count.get(nums[i]);
				res = i - first.get(nums[i]) + 1; // 取得最短 subarray 長度
			} else if (count.get(nums[i]) == degree) {
				res = Math.min(res, i - first.get(nums[i]) + 1);
			}
		}
		return res;
    }
	
	/*
	 * Solution_2 : Right and Left index
	 */
	public static int findShortestSubArray_Sol_2(int[] nums) { // [1,2,2,3,1,4,2]  output : 6
		Map<Integer, Integer> left = new HashMap<>(),
		right = new HashMap<>(), count = new HashMap<>();
		
		for (int i = 0; i < nums.length; i++) {
			int x = nums[i];
			if (left.get(x) == null) { // 存所有數字第一次出現的索引
				left.put(x, i);
			}
			right.put(x, i); // 存所有數字最後出現的索引
			count.put(x, count.getOrDefault(x, 0) + 1); // 存所有數字出現的數字
		}
		
		int ans = nums.length;
		int degree = Collections.max(count.values());
		for (int x : count.keySet()) {
			if (count.get(x) == degree) {
				ans = Math.min(ans, right.get(x) - left.get(x) + 1);
			}
		}
		return ans;
	}
	public static <T> void main(String[] args) {
		
	}
}
