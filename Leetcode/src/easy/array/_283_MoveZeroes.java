package easy.array;

/**
 * Given an array nums, write a function to move all 0's to the end of it while
 * maintaining the relative order of the non-zero elements.
 * 
 * Example:
 * 
 * Input: [0,1,0,3,12] 
 * Output: [1,3,12,0,0] Note:
 * 
 * You must do this in-place without making a copy of the array. Minimize the
 * total number of operations.
 */
public class _283_MoveZeroes {
	/*
	 * Solution : 
	 */
	public static void moveZeroes(int[] nums) {
		int j = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				int temp = nums[j];
				nums[j] = nums[i];
				nums[i] = temp;
				j++;
			}
		}
	}

	public static void main(String[] args) {
		int[] nums = { 0, 1, 0, 3, 12 };
		moveZeroes(nums);
		for (int i : nums) {
			System.out.print(i);
		}
	}
}
