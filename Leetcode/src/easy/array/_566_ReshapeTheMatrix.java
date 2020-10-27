package easy.array;

/**
 * In MATLAB, there is a very useful function called 'reshape', which can
 * reshape a matrix into a new one with different size but keep its original
 * data.
 * 
 * You're given a matrix represented by a two-dimensional array, and two
 * positive integers r and c representing the row number and column number of
 * the wanted reshaped matrix, respectively.
 * 
 * The reshaped matrix need to be filled with all the elements of the original
 * matrix in the same row-traversing order as they were.
 * 
 * If the 'reshape' operation with given parameters is possible and legal,
 * output the new reshaped matrix; Otherwise, output the original matrix.
 * 
 * Example 1: 
 * Input: nums = [[1,2], [3,4]] r = 1, c = 4 
 * Output: [[1,2,3,4]]
 * Explanation: The row-traversing of nums is [1,2,3,4]. The new reshaped matrix
 * is a 1 * 4 matrix, fill it row by row by using the previous list. 
 * Example 2:
 * Input: nums = [[1,2], [3,4]] r = 2, c = 4 
 * Output: [[1,2], [3,4]] 
 * Explanation:
 * There is no way to reshape a 2 * 2 matrix to a 2 * 4 matrix. So output the
 * original matrix. Note: The height and width of the given matrix is in range
 * [1, 100]. The given r and c are all positive.
 */
public class _566_ReshapeTheMatrix {
	/*
	 * Solution_1 : by myself，brute force
	 */
	public static int[][] matrixReshape_Sol_1(int[][] nums, int r, int c) {
        int total = 0;
        int[][]	result = null;
        for (int i = 0; i < nums.length; i++) {
        	total += nums[i].length;
        }
        if (total != r * c) {
        	return nums;
        } else {
        	result = new int[r][c];
        	int[] temp = new int[total];
        	int count = 0;
        	for (int i = 0; i < nums.length; i++) {
        		for (int j = 0; j < nums[i].length; j++) {
        			temp[count++] = nums[i][j];
        		}
        	}
        	count = 0;
        	for (int i = 0; i < result.length; i++) {
        		for (int j = 0; j < result[i].length; j++) {
        			result[i][j] = temp[count++];
        		}
        	}
        }
        return result;
    }
	
	/*
	 * Solution_2 : without using extra space
	 */
	public int[][] matrixReshape_Sol_2(int[][] nums, int r, int c){
		int[][] res = new int[r][c];
		if (nums.length == 0 || r * c != nums.length * nums[0].length) {
			return nums;
		}
		int rows = 0, cols = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums[0].length; j++) {
				res[rows][cols] = nums[i][j];
				cols++;
				if (cols == c) {
					rows++;
					cols = 0;
				}
			}
		}
		return res;
	}
	
	/*
	 * Solution_3 : Using division and modulus
	 */
	public static int[][] matrixReshape_Sol_3(int[][] nums, int r, int c){
		int[][] res = new int[r][c];
		if (nums.length == 0 || r * c != nums.length * nums[0].length) {
			return nums;
		}
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums[0].length; j++) {
				res[count / c][count % c] = nums[i][j];
				count++;
			}
		}
		return res;
	}
	
	
	public static void main(String[] args) {
		int[][] nums = new int[][]{ {1, 2}, {3, 4} };
		matrixReshape_Sol_1(nums, 2, 4);
	}
}
