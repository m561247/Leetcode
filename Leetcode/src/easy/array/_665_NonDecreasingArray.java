package easy.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array nums with n integers, your task is to check if it could become
 * non-decreasing by modifying at most 1 element.
 * 
 * We define an array is non-decreasing if nums[i] <= nums[i + 1] holds for
 * every i (0-based) such that (0 <= i <= n - 2).
 * 
 * 
 * 
 * Example 1:
 * Input: nums = [4,2,3] 
 * Output: true 
 * Explanation: You could modify the first 4
 * to 1 to get a non-decreasing array. 
 * 
 * Example 2:
 * Input: nums = [4,2,1] 
 * Output: false Explanation: You can't get a
 * non-decreasing array by modify at most one element.
 * 
 * 
 * Constraints:
 * 
 * 1 <= n <= 10 ^ 4 - 10 ^ 5 <= nums[i] <= 10 ^ 5
 */
public class _665_NonDecreasingArray {
	/*
	 * Solution_1 : 判斷前一個數若比當前的數大則計數加一，同時也要判斷再更之前的數字有沒有比自己大的
	 */
	public static boolean checkPossibility(int[] nums) { // 3, 4, 2, 3               3323
		int count = 0;
		for (int i = 1; i < nums.length && count <= 1; i++) {
			if (nums[i - 1] > nums[i]) {
				count++;
				if (i - 2 < 0 || nums[i - 2] <= nums[i]) { // 第一個數就比較大的情況或是符合 non dicreasing的情況
					nums[i - 1] = nums[i];
				} else {
					nums[i] = nums[i - 1];
				}
			}
		}
		return count <= 1;
	}
	
	/*
	 * Solution_2 : 
	 */
	public boolean checkPossibility_Sol_2(int[] nums) { // 3, 4, 2, 3
        if (nums.length == 0) {
            return true;
        }
        for (int i = 0, cur = nums[0], count = 0; i < nums.length - 1; i++) {
            if (cur > nums[i + 1]) { // 45361
                if (count == 1) {
                    return false;
                }
                if (!(i > 0 && nums[i - 1] > nums[i + 1])) { // curr 比較大的話就繼續比
                    cur = nums[i + 1]; 
                } 
                count++;
            } else {
                cur = nums[i + 1];
            }
        }
        return true;
    }
	
	public static void main(String[] args) {
		int[] nums = { 4,4,2,3 };
		System.out.println(checkPossibility(nums));
	}
}
