package easy.array;

/**
 * An array is monotonic if it is either monotone increasing or monotone
 * decreasing.
 * 
 * An array A is monotone increasing if for all i <= j, A[i] <= A[j]. An array A
 * is monotone decreasing if for all i <= j, A[i] >= A[j].
 * 
 * Return true if and only if the given array A is monotonic.
 * 
 * 
 * 
 * Example 1:
 * Input: [1,2,2,3] 
 * Output: true 
 * 
 * Example 2:
 * Input: [6,5,4,4] 
 * Output: true 
 * 
 * Example 3:
 * Input: [1,3,2] 
 * Output: false 
 * 
 * Example 4:
 * Input: [1,2,4,5] 
 * Output: true 
 * 
 * Example 5:
 * Input: [1,1,1] 
 * Output: true
 * 
 * 
 * Note:
 * 
 * 1 <= A.length <= 50000 -100000 <= A[i] <= 100000
 */
public class _896_MonotonicArray {
	/*
	 * Solution_1 : 
	 */
	public boolean isMonotonic_Sol_1(int[] A) { // 110
		boolean inc = true, dec = true;
		for (int i = 1; i < A.length; i++) {
			inc &= A[i - 1] <= A[i]; // 
			dec &= A[i - 1] >= A[i];
		}
		return inc || dec;
    }
	
	/*
	 * Solution_2 : 
	 */
	public static boolean isMonotonic_Sol_2(int[] A) {
		if (A.length == 1) {
			return true;
		}
		int n = A.length;
		boolean trend = (A[n - 1] - A[0]) > 0;
		for (int i = 0; i < n - 1; i++) {
			if (A[i + 1] != A[i] && (A[i + 1] - A[i] > 0) != trend) { // 1223
				return false;
			}
		}
		return true;
	}
	
	/*
	 * Solution_3 : 
	 */
	public boolean isMonotonic_Sol_3(int[] A) {
        int inc=1;
        int dec=1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] - A[i-1] > 0) {
            	inc++;
            } else if (A[i] - A[i-1] < 0) {
            	dec++;
            } else {
                inc++; dec++;
            }
        }
        return inc == A.length || dec == A.length;
    }
	
	public static void main(String[] args) {
		int[] nums = { 1, 2, 4, 5};
		isMonotonic_Sol_2(nums);
	}
}
