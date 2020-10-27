package easy.math;

/**
 * Count the number of prime numbers less than a non-negative number, n.
 * 
 * Example:
 * 
 * Input: 10 
 * Output: 4 
 * Explanation: There are 4 prime numbers less than 10, they
 * are 2, 3, 5, 7.
 */
public class _204_CountPrimes {
	/*
	 * Solution_1 : 
	 */
	public static int countPrimes(int n) {
		boolean[] m = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (m[i]) {
            	continue;
            }
            count++;
            for (int j = i; j < n; j = j + i) { // 倍數不會是質數
            	  m[j] = true;
            }
        }
        return count;
    }
    
	public static void main(String[] args) {
		countPrimes(10);
	}
}
