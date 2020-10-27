package easy.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some
 * elements appear twice and others appear once.
 * 
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * 
 * Could you do it without extra space and in O(n) runtime? You may assume the
 * returned list does not count as extra space.
 * 
 * Example:
 * Input: [4,3,2,7,8,2,3,1]
 * Output: [5,6]
 */
public class _448_FindAllNumbersDisappearedInAnArray {
	/*
	 * Solution_1 : 
	 */
	public static List<Integer> findDisappearedNumbers_Sol_1(int[] nums) {
		List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if (nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }
        for (int i = 0; i < nums.length; i++) { //4,3,2,7,8,2,3,1 
            if (nums[i] > 0) {
                ret.add(i + 1);
            }
        }
        return ret;
    }
	
	/*
	 * Solution_2 : 以 nums 裡面所存的數字當作索引，若是存在的話就加 8
	 */
	public static List<Integer> findDisappearedNumbers_Sol_2(int[] nums){
		List<Integer> list = new ArrayList<>();
		int n = nums.length;
		for (int i = 0; i < n; i++) { 
			nums[(nums[i] - 1) % n] += n;
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] <= n) {
				list.add(i + 1);
			}
		}
		return list;
	}
	public static void main(String[] args) {
		int[] nums = { 4,3,2,7,8,2,3,1 };
		findDisappearedNumbers_Sol_2(nums);
	}
}
