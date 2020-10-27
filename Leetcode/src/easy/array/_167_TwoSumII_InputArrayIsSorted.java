package easy.array;

/**
 * Given an array of integers that is already sorted in ascending order, find
 * two numbers such that they add up to a specific target number.
 * 
 * The function twoSum should return indices of the two numbers such that they
 * add up to the target, where index1 must be less than index2.
 * 
 * Note:
 * 
 * Your returned answers (both index1 and index2) are not zero-based. You may
 * assume that each input would have exactly one solution and you may not use
 * the same element twice. Example:
 * 
 * Input: numbers = [2,7,11,15], target = 9 
 * Output: [1,2] 
 * Explanation: The sum
 * of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 */
public class _167_TwoSumII_InputArrayIsSorted {
	/*
	 * Solution_1 : brute force
	 */
	public static int[] twoSum_Sol_1(int[] numbers, int target) { // [3,24,50,79,88,150,345]
		for (int i = 0; i < numbers.length; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[i] + numbers[j] != target) {
					continue;
				} else if (numbers[i] + numbers[j] == target) {
					return new int[] { i + 1, j + 1 };
				}
			}
		}
		return null;
	}
	
	/*
	 * Solution_2 : 因為已經由大到小排序過
	 */
	public static int[] twoSum(int[] numbers, int target) {
		int[] indice = new int[2];
		if (numbers == null || numbers.length < 2) {
			return indice;
		}
		int left = 0, right = numbers.length - 1;
		while (left < right) {
			int value = numbers[left] + numbers[right];
			if (value == target) {
				indice[0] = left + 1;
				indice[1] = right + 1;
				break;
			} else if (value > target) {
				right--;
			} else {
				left++;
			}
		}
		return indice;
	}
	public static void main(String[] args) {
		
	}
}
