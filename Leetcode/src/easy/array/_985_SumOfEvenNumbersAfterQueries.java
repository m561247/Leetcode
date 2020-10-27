package easy.array;

/**
 * We have an array A of integers, and an array queries of queries.
 * 
 * For the i-th query val = queries[i][0], index = queries[i][1], we add val to
 * A[index]. Then, the answer to the i-th query is the sum of the even values of
 * A.
 * 
 * (Here, the given index = queries[i][1] is a 0-based index, and each query
 * permanently modifies the array A.)
 * 
 * Return the answer to all queries. Your answer array should have answer[i] as
 * the answer to the i-th query.
 * 
 * 
 * 
 * Example 1:
 * Input: A = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]] 
 * Output: [8,6,2,4]
 * Explanation: 
 * At the beginning, the array is [1,2,3,4]. After adding 1 to
 * A[0], the array is [2,2,3,4], and the sum of even values is 2 + 2 + 4 = 8.
 * After adding -3 to A[1], the array is [2,-1,3,4], and the sum of even values
 * is 2 + 4 = 6. After adding -4 to A[0], the array is [-2,-1,3,4], and the sum
 * of even values is -2 + 4 = 2. After adding 2 to A[3], the array is
 * [-2,-1,3,6], and the sum of even values is -2 + 6 = 4.
 * 
 * 
 * Note:
 * 
 * 1 <= A.length <= 10000 -10000 <= A[i] <= 10000 1 <= queries.length <= 10000
 * -10000 <= queries[i][0] <= 10000 0 <= queries[i][1] < A.length
 */
public class _985_SumOfEvenNumbersAfterQueries {
	/*
	 * TLE
	 */
	public static int[] sumEvenAfterQueries(int[] A, int[][] queries) { // [[1,0],[-3,1],[-4,0],[2,3]] 
        int[] result = new int[A.length];						// [1,2,3,4]
        int sum;
        for (int i = 0; i < queries.length; i++) {
        	int j = queries[i][1];
        	A[j] += queries[i][0];
        	sum = 0;
        	for (int k = 0; k < A.length; k++) {
        		if (A[k] % 2 == 0) {
        			sum += A[k];
        		}
        	}
        	result[i] = sum;
        }
        return result;
    }
	
	/*
	 * Solution_1 : 
	 */
	public static int[] sumEvenAfterQueries_Sol_1(int[] A, int[][] queries) {
		int sum = 0, i = 0;
		for (int a : A) {
			if (a % 2 == 0) {
				sum += a;
			}
		}
		int[] ans = new int[queries.length];
		for (int[] q : queries) {
			if (A[q[1]] % 2 == 0) { // 扣掉舊的值
				sum -= A[q[1]];
			}
			A[q[1]] += q[0];
			if (A[q[1]] % 2 == 0) {
				sum += A[q[1]];
			}
			ans[i] = sum;
			i++;
		}
		return ans;
	}
	
	public static void main(String[] args) {
		int[] A = {1, 2, 3, 4};
		int[][] queries = {{1, 0}, {-3, 1}, {-4, 0}, {2, 3}};
		sumEvenAfterQueries_Sol_1(A, queries);
	}
}
