package easy.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * For a non-negative integer X, the array-form of X is an array of its digits
 * in left to right order. For example, if X = 1231, then the array form is
 * [1,2,3,1].
 * 
 * Given the array-form A of a non-negative integer X, return the array-form of
 * the integer X+K.
 * 
 * 
 * 
 * Example 1:
 * Input: A = [1,2,0,0], K = 34 
 * Output: [1,2,3,4] 
 * Explanation: 1200 + 34 = 1234
 * 
 * Example 2:
 * Input: A = [2,7,4], K = 181 
 * Output: [4,5,5] 
 * Explanation: 274 + 181 = 455
 * 
 * Example 3:
 * Input: A = [2,1,5], K = 806 
 * Output: [1,0,2,1] 
 * Explanation: 215 + 806 = 1021
 * 
 * Example 4:
 * Input: A = [9,9,9,9,9,9,9,9,9,9], K = 1 
 * Output: [1,0,0,0,0,0,0,0,0,0,0]
 * Explanation: 9999999999 + 1 = 10000000000
 * 
 * 
 * Note：
 * 
 * 1 <= A.length <= 10000 0 <= A[i] <= 9 0 <= K <= 10000 If A.length > 1, then
 * A[0] != 0
 */
public class _989_AddToArray_FormOfInteger {
	/*
	 * Solution_1 : 把 K 當作 carry
	 */
	public static List<Integer> addToArrayForm(int[] A, int K) { // 1200 
		List<Integer> res = new LinkedList<>();
		for (int i = A.length - 1; i >= 0; i--) {
			res.add(0, (A[i] + K) % 10);
			K = (A[i] + K) / 10;
		}
		while (K > 0) {
			res.add(0, K % 10);
			K /= 10;
		}
		return res;
	}
	
	/*
	 * Solution_2 : one pass
	 */
	public List<Integer> addToArrayForm_Sol_2(int[] A, int K) {
		List<Integer> res = new ArrayList<>();
		for (int i = A.length - 1; i >= 0 || K > 0; i--) { // K 有可能比 int[] A 大
			res.add(0, (i >= 0 ? A[i] + K : K) % 10);
			K = (i >= 0 ? A[i] + K : K) / 10;
		}
		return res;
	}
	
	
	public static void main(String[] args) { // [9,9,9,9,9,9,9,9,9,9] 1
		
		int[] A = { 9,9,9,9,9,9,9,9,9,9 };
		int K = 1;
		addToArrayForm(A, K);
	}
}
