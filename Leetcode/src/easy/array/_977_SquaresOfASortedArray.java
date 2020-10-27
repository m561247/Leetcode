package easy.array;

import java.util.Arrays;

/**
 * Given an array of integers A sorted in non-decreasing order, return an array
 * of the squares of each number, also in sorted non-decreasing order.
 * 
 * 
 * 
 * Example 1:
 * Input: [-4,-1,0,3,10] 
 * Output: [0,1,9,16,100] 
 * 
 * Example 2:
 * Input: [-7,-3,2,3,11] 
 * Output: [4,9,9,49,121]
 * 
 * 
 * Note:
 * 
 * 1 <= A.length <= 10000 -10000 <= A[i] <= 10000 A is sorted in non-decreasing
 * order.
 */
public class _977_SquaresOfASortedArray {
	/*
	 * Solution_1 : O(nlogn)
	 */
	public int[] sortedSquares(int[] A) {
        for (int i = 0; i < A.length; i++) {
        	A[i] *= A[i];
        }
        Arrays.sort(A);
        return A;
    }
	
	/*
	 * Solution_2 : O(n)，類似 merge sort
	 */
	public int[] sortedSquares_Sol_2(int[] A) { // [-4,-1,0,3,10]
		int n = A.length;
		int[] result = new int[n];
		int i = 0, j = n - 1;
		for (int p = n - 1; p >= 0; p--) {
			if (Math.abs(A[i]) > Math.abs(A[j])) {
				result[p] = A[i] * A[i];
				i++;
			} else {
				result[p] = A[j] * A[j];
				j--;
			}
		}
		return result;
    }
}
