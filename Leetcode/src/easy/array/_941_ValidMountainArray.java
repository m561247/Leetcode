package easy.array;

/**
 * Given an array A of integers, return true if and only if it is a valid
 * mountain array.
 * 
 * Recall that A is a mountain array if and only if:
 * 
 * A.length >= 3 There exists some i with 0 < i < A.length - 1 such that: A[0] <
 * A[1] < ... A[i-1] < A[i] 
 * A[i] > A[i+1] > ... > A[A.length - 1]
 * 
 * 
 * ---------------------image
 * 
 * 
 * 
 * Example 1:
 * Input: [2,1] 
 * Output: false 
 * 
 * Example 2:
 * Input: [3,5,5] 
 * Output: false 
 * 
 * Example 3:
 * Input: [0,3,2,1] 
 * Output: true
 * 
 * 
 * Note:
 * 
 * 0 <= A.length <= 10000 0 <= A[i] <= 10000
 */
public class _941_ValidMountainArray {
	/*
	 * Solution_1 : brute force
	 */
	public static boolean validMountainArray_Sol_1(int[] A) {
		if (A.length < 3 || A[1] - A[0] < 0 || A[A.length - 1] - A[A.length - 2] > 0) {
			return false;
		}
		int reverse = -1;
        for (int i = 1; i < A.length; i++) {
        	if (A[i] - A[i - 1] > 0) {
        		reverse = i;
        		reverse = Math.max(reverse, i);
        	} else {
        		break;
        	}
        }
        for (int i = reverse + 1; i < A.length; i++) {
        	if (A[reverse] - A[i] > 0) {
        		reverse = i;
        	} else {
        		return false;
        	}
        }
        return true;
    }
	
	/*
	 * Solution_2 : 分頭算，一個從頭開始算，一個從尾開始算，最後位置要相等
	 */
	public static boolean validMountainArray_Sol_2(int[] A) {
		int n = A.length, i = 0, j = n - 1;
		while (i + 1 < n && A[i] < A[i + 1]) {
			i++;
		}
		while (j > 0 && A[j - 1] > A[j]) {
			j--;
		}
		return i > 0 && i == j && j < n - 1;
	}
	
	public static void main(String[] args) {
		int[] nums = { 3,6,5,6,7,6,5,3,0 };
		validMountainArray_Sol_2(nums);
	}
}
