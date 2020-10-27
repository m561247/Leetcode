package easy.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Alice and Bob have candy bars of different sizes: A[i] is the size of the
 * i-th bar of candy that Alice has, and B[j] is the size of the j-th bar of
 * candy that Bob has.
 * 
 * Since they are friends, they would like to exchange one candy bar each so
 * that after the exchange, they both have the same total amount of candy. (The
 * total amount of candy a person has is the sum of the sizes of candy bars they
 * have.)
 * 
 * Return an integer array ans where ans[0] is the size of the candy bar that
 * Alice must exchange, and ans[1] is the size of the candy bar that Bob must
 * exchange.
 * 
 * If there are multiple answers, you may return any one of them. It is
 * guaranteed an answer exists.
 * 
 * 
 * 
 * Example 1:
 * Input: A = [1,1], B = [2,2] 
 * Output: [1,2] 
 * 
 * Example 2:
 * Input: A = [1,2], B = [2,3] 
 * Output: [1,2] 
 * 
 * Example 3:
 * Input: A = [2], B = [1,3] 
 * Output: [2,3] 
 * 
 * Example 4:
 * Input: A = [1,2,5], B = [2,4] 
 * Output: [5,4]
 * 
 * 
 * Note:
 * 
 * 1 <= A.length <= 10000 1 <= B.length <= 10000 1 <= A[i] <= 100000 1 <= B[i]
 * <= 100000 It is guaranteed that Alice and Bob have different total amounts of
 * candy. It is guaranteed there exists an answer.
 */
public class _888_FairCandySwap {
	/*
	 * Solution_1 : by myself
	 */
	public static int[] fairCandySwap(int[] A, int[] B) {
        int[] result = new int[2];
        int sumA = 0, sumB = 0;
        for (int i = 0; i < A.length; i++) {
        	sumA += A[i];
        }
        for (int i = 0; i < B.length; i++) {
        	sumB += B[i];
        }
        for (int i = 0, j = 0; i < A.length; i++) { // A = [1,2,5], B = [2,4] 
        	while (j < B.length && sumA - A[i] + B[j] != sumB - B[j] + A[i]) {
        		j++;
        	}
        	if (j < B.length && sumA - A[i] + B[j] == sumB - B[j] + A[i]) {
        		result[0] = A[i];
        		result[1] = B[j];
        	}
        	j = 0;
        }
        return result;
    }
	
	/*
	 * Solution_2 : Solve the equation
	 */
	public int[] fairCandySwap_Sol_2(int[] A, int[] B) {
		int sa = 0, sb = 0;
		for (int x : A) {
			sa += x;
		}
		for (int x : B) {
			sb += x;
		}
		int delta = (sb - sa) / 2; // if Alice gives x, she expects to receive x + delta
		Set<Integer> setB = new HashSet<>();
		for (int x : B) {
			setB.add(x); // 裝入 set 降低時間複雜度
		}
		for (int x : A) {
			if (setB.contains(x + delta)) {
				return new int[] { x, x + delta };
			}
		}
		return null;
	}
	public static void main(String[] args) {
		int[] A = { 1, 2, 5 }, B = { 2, 4 };
		fairCandySwap(A, B);
	}
}
