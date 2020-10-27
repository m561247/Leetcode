package easy.array;

import java.util.LinkedList;
import java.util.List;

/**
 * A matrix is Toeplitz if every diagonal from top-left to bottom-right has the
 * same element.
 * 
 * Now given an M x N matrix, return True if and only if the matrix is Toeplitz.
 * 
 * 
 * Example 1:
 * Input: matrix = [ [1,2,3,4],   [00, 11, 22] [01, 12, 23] [02, 13]
 * 					 [5,1,2,3], 
 * 					 [9,5,1,2] ] 
 * Output: True 
 * Explanation:
 * In the above grid, the diagonals are: "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2,
 * 2]", "[3, 3]", "[4]". In each diagonal all elements are the same, so the
 * answer is True. 
 * 
 * Example 2:
 * Input: matrix = [ [1,2], [2,2] ] 
 * Output: False 
 * Explanation: The diagonal "[1,
 * 2]" has different elements.
 * 
 * Note:
 * 
 * matrix will be a 2D array of integers. matrix will have a number of rows and
 * columns in range [1, 20]. matrix[i][j] will be integers in range [0, 99].
 * 
 * Follow up:
 * 
 * 1.What if the matrix is stored on disk, and the memory is limited such that you
 * can only load at most one row of the matrix into the memory at once? 
 * 2.What if
 * the matrix is so large that you can only load up a partial row into the
 * memory at once?
 */
public class _766_ToeplitzMatrix {
	/*
	 * Solution_1 : 
	 */
	public boolean isToeplitzMatrix(int[][] matrix) { // [00, 11, 22] [01, 12, 23] [02, 13]
		for (int i = 0; i < matrix.length - 1; i++) {
			for (int j = 0; j < matrix[i].length - 1; j++) {
				if (matrix[i][j] != matrix[i + 1][j + 1]) {
					return false;
				}
			}
		}
		return true;
    }
	
	/*
	 * Solution_2 : for the follow up 1 & 2
	 */
	public static boolean isToeplitzMatrix_Sol_2(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0	) {
			return true;
		}
		int row = matrix.length;
		int col = matrix[0].length;
		List<Integer> buffer = new LinkedList<>();
		for (int j = 0; j < col; j++) {
			buffer.add(matrix[0][j]);
		}
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				if (buffer.get(j - 1) != matrix[i][j]) {
					return false;
				}
			}
			buffer.remove(buffer.size() - 1);
			buffer.add(0, matrix[i][0]);
		}
		return true;
	}
	public static void main(String[] args) {
		int[][] matrix = new int[][]{{ 1,2,3,4 }, { 5,1,2,3 }, { 9,5,1,2 }};
		System.out.println(isToeplitzMatrix_Sol_2(matrix));
	}
}
