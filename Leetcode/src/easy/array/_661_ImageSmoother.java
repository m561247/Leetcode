package easy.array;

/**
 * Given a 2D integer M M representing the gray scale of an image, you need
 * to design a smoother to make the gray scale of each cell becomes the average
 * gray scale (rounding down) of all the 8 surrounding cells and itself. If a
 * cell has less than 8 surrounding cells, then use as many as you can.
 * 
 * Example 1: 
 * Input: [[1,1,1], [1,0,1], [1,1,1]] 
 * Output: [[0, 0, 0], [0, 0, 0],
 * [0, 0, 0]] 
 * Explanation: For the point (0,0), (0,2), (2,0), (2,2): floor(3/4)
 * = floor(0.75) = 0 For the point (0,1), (1,0), (1,2), (2,1): floor(5/6) =
 * floor(0.83333333) = 0 For the point (1,1): floor(8/9) = floor(0.88888889) = 0
 * Note: The value in the given M is in the range of [0, 255]. The length
 * and width of the given M are in the range of [1, 150].
 */
public class _661_ImageSmoother {
	/*
	 * Solution : 這題是圖像處理的問題，看不懂題目要問啥
	 */
	public int[][] imageSmoother(int[][] M) {
		if (M == null || M.length == 0) return new int[0][0];
        int m = M.length, n = M[0].length;
        int[][] res = new int[m][n];
        int[][] moves = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {1, 1}, {1, -1}, {-1, 1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = M[i][j];
                int count = 1;
                for (int[] move : moves) {
                    int I = i + move[0];
                    int J = j + move[1];
                    if (I >= 0 && I < m && J >= 0 && J < n) {
                        count++;
                        sum += M[I][J];
                    }
                }
                res[i][j] = sum / count;
            }
        }
        return res;
    }
}
