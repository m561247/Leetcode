package easy.array;

/**
 * Given a binary matrix A, we want to flip the image horizontally, then invert
 * it, and return the resulting image.
 * 
 * To flip an image horizontally means that each row of the image is reversed.
 * For example, flipping [1, 1, 0] horizontally results in [0, 1, 1].
 * 
 * To invert an image means that each 0 is replaced by 1, and each 1 is replaced
 * by 0. For example, inverting [0, 1, 1] results in [1, 0, 0].
 * 
 * Example 1:
 * Input: [[1,1,0],[1,0,1],[0,0,0]] 
 * Output: [[1,0,0],[0,1,0],[1,1,1]]
 * Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]]. Then, invert
 * the image: [[1,0,0],[0,1,0],[1,1,1]] 
 * 
 * Example 2:
 * Input: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]] 
 * Output:
 * [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]] 
 * Explanation: First reverse each
 * row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]. Then invert the image:
 * [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]] Notes:
 * 
 * 1 <= A.length = A[0].length <= 20 0 <= A[i][j] <= 1
 */
public class _832_FlippingAnImage {
	/*
	 * Solution_1 : by myself，brute force
	 */
	public static int[][] flipAndInvertImage(int[][] A) {
        // flip
		for (int i = 0; i < A.length; i++) {
			for (int j = 0, k = A[i].length - 1; j < k; j++, k--) {
				int temp = A[i][j];
				A[i][j] = A[i][k];
				A[i][k] = temp;
			}
		}
		// invert
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[i].length; j++) {
				if (A[i][j] == 1) {
					A[i][j] = 0;
				} else {
					A[i][j] = 1;
				}
			}
		}
		return A;
    }
	
	/*
	 * Solution_2 : 若陣列中的原本的數字不同，交換後再反轉會跟原來的數字相同，因此只有在原本數字相同的情況下操作。
	 */
	public static int[][] flipAndInvertImage_Sol_2(int[][] A) {
        int n = A.length;
        for (int[] row : A)
            for (int i = 0; i * 2 < n; i++) {
            	if (row[i] == row[n - i - 1]) {
                	row[i] = row[n - i - 1] ^= 1;
                }
            }
        return A;
    }
	
	public static void main(String[] args) {
		int[][] A = new int[][] {{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
		flipAndInvertImage_Sol_2(A);
		
	}
}
