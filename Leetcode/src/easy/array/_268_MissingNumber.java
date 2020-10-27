package easy.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find
 * the one that is missing from the array.
 * 
 * Example 1:
 * Input: [3,0,1] 
 * Output: 2 
 * 
 * Example 2:
 * Input: [9,6,4,2,3,5,7,0,1] Output: 8 
 * Note: Your algorithm should run in
 * linear runtime complexity. Could you implement it using only constant extra
 * space complexity?
 */
public class _268_MissingNumber {
	/*
	 * Soultion_1 : sorting
	 */
	public int missingNumber(int[] nums) {
		Arrays.sort(nums);
		// ensure that n is at the last index
		if (nums[nums.length - 1] != nums.length) {
			return nums.length;
			// ensure that 0 is at the first index
		} else if (nums[0] != 0) {
			return 0;
		}
		for (int i = 1; i < nums.length; i++) {
			int expectedNum = nums[i - 1] + 1;
			if (nums[i] != expectedNum) {
				return expectedNum;
			}
		}
		return -1;
	}
	
	/*
	 * Solution_2 : use xor : a ^ b ^ b = a，對同一個數字 xor 兩次結果不變。
	 */
	public static int missingNumber_Sol_2(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }
	
	/*
	 * Solution_3 : HashSet
	 */
	public static int missingNumber_Sol_3(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int i : set) {
			set.add(i);
		}
		int exceptedNumCount = nums.length + 1;
		for (int i = 0; i < exceptedNumCount; i++) {
			if (!set.contains(i)) {
				return i;
			}
		}
		return -1;
	}
	
	/*
	 * Solution_4 : Gauss' Formula
	 */
	public static int missingNumber_Sol_4(int[] nums) {
		int expectedSum = nums.length * (nums.length + 1) / 2;
		for (int i : nums) {
			expectedSum -= i;
		}
		return expectedSum;
	}
	
	public static void main(String[] args) {
		int[] nums = { 3, 0, 1 };
		System.out.println(missingNumber_Sol_4(nums));
	}
}

