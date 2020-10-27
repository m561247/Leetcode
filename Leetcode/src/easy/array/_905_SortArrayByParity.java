package easy.array;

/**
 * Given an array A of non-negative integers, return an array consisting of all
 * the even elements of A, followed by all the odd elements of A.
 * 
 * You may return any answer array that satisfies this condition.
 * 
 * 
 * 
 * Example 1:
 * Input: [3,1,2,4] 
 * Output: [2,4,3,1] The outputs [4,2,3,1], [2,4,1,3], and
 * [4,2,1,3] would also be accepted.
 * 
 * 
 * Note:
 * 
 * 1 <= A.length <= 5000 0 <= A[i] <= 5000
 */
public class _905_SortArrayByParity {
	/*
	 * Solution_1 : 
	 */
	public int[] sortArrayByParity(int[] A) {
        int[] result = new int[A.length];
        int start = 0, end = A.length - 1;
        for (int i = 0; i < A.length; i++) {
        	if (A[i] % 2 == 0) {
        		result[start] = A[i];
        		start++;
        	} else {
        		result[end] = A[i];
        		end--;
        	}
        }
        return result;
    }
	
	/*
	 * Solution_2 : 當遇到偶數時就把它丟到 i 的位置，i 從 0 開始
	 */
	public static int[] sortArrayByParity_Sol_2(int[] A) {
        for (int i = 0, j = 0; j < A.length; j++)
            if (A[j] % 2 == 0) {
                int tmp = A[i];
                A[i++] = A[j];
                A[j] = tmp;;
            }
        return A;
    }
	public static void main(String[] args) {
		int[] nums = { 3,1,2,4 };
		sortArrayByParity_Sol_2(nums);
	}
}
