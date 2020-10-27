package easy.array;

/**
 * Given a binary array, find the maximum number of consecutive 1s in this
 * array.
 * 
 * Example 1: 
 * Input: [1,1,0,1,1,1] 
 * Output: 3 
 * Explanation: The first two digits
 * or the last three digits are consecutive 1s. The maximum number of
 * consecutive 1s is 3. Note:
 * 
 * The input array will only contain 0 and 1. The length of input array is a
 * positive integer and will not exceed 10,000
 */
public class _485_MaxConsecutiveOnes { // [1,0,1,1,0,1]
	/*
	 * Solution_1 : 雙指針的概念，一個負責計數，一個負責遍歷數字
	 */
	public static int findMaxConsecutiveOnes(int[] nums) {
		int i = 0, j = 0, count = 0;
		for (i = 0, j = 0; i < nums.length && j < nums.length; j++) {
			if (j < nums.length && nums[j] == 1) {
				i++;
				count = Math.max(count, i);
			} else {
				i = 0;
			}
		}
		return count;
    }
	
	/*
	 * Solution_2 : 
	 */
	public static int findMaxConsecutiveOnes_Sol_2(int[] nums) {
		int maxHere = 0, max = 0;
		for (int n : nums) {
			max = Math.max(max, maxHere = n == 0 ? 0 : maxHere + 1);
		}
		return max;
	}
	
	
	public static void main(String[] args) {
		int[] nums = { 1,0,1,1,0,1 };
		System.out.println(findMaxConsecutiveOnes(nums));
	}
}
