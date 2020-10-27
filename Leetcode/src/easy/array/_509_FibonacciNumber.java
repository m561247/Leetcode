package easy.array;

/**
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the
 * Fibonacci sequence, such that each number is the sum of the two preceding
 * ones, starting from 0 and 1. That is,
 * 
 * F(0) = 0, F(1) = 1 F(N) = F(N - 1) + F(N - 2), for N > 1. Given N, calculate
 * F(N).
 * 
 * Example 1:
 * 
 * Input: 2 Output: 1 Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
 * 
 * Example 2: Input: 3 Output: 2 Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
 * 
 * Example 3: Input: 4 Output: 3 Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
 */
public class _509_FibonacciNumber {
	/*
	 * Solution_1 : basic recursive
	 */
	public static int fib_Sol_1(int N) {
		if (N == 0) {
			return 0;
		}
		if (N == 1) {
			return 1;
		}
		return fib_Sol_1(N - 1) + fib_Sol_1(N - 2);
	}

	/*
	 * Solution_2 : by goodritch
	 */
	public static int fib(int N) {
		if (N == 0) {
			return 0;
		}
		int[] result = fibArray(N);
		return result[0];
	}

	/* help method */
	public static int[] fibArray(int N) {
		int[] arr = { 1, 0 };
		if (N == 1) {
			return arr;
		}
		int[] temp = fibArray(N - 1);
		return new int[] { temp[0] + temp[1], temp[0] };
	}

	/*
	 * Solution_3 : Bottom-Up Approach using Memoization
	 */
	public int fib_Sol_3(int N) {
		if (N <= 1) {
			return N;
		}
		return memoize_3(N);
	}

	/* help method */
	public int memoize_3(int N) {
		int[] cache = new int[N + 1];
		cache[1] = 1;

		for (int i = 2; i <= N; i++) {
			cache[i] = cache[i - 1] + cache[i - 2];
		}
		return cache[N];
	}

	/*
	 * Solution_4 : Top-Down Approach using Memoization
	 */
	private Integer[] cache = new Integer[31];

	public int fib_Sol_4(int N) {
		if (N <= 1) {
			return N;
		}
		cache[0] = 0;
		cache[1] = 1;
		return memoize_4(N);
	}

	public int memoize_4(int N) {
		if (cache[N] != null) {
			return cache[N];
		}
		cache[N] = memoize_4(N - 1) + memoize_4(N - 2);
		return memoize_4(N);
	}

	/*
	 * Solution_5 : Iterative Top-Down Approach
	 */
	public int fib_Sol_5(int N) {
		if (N <= 1) {
			return N;
		}
		if (N == 2) {
			return 1;
		}

		int current = 0;
		int prev1 = 1;
		int prev2 = 1;

		for (int i = 3; i <= N; i++) {
			current = prev1 + prev2;
			prev2 = prev1;
			prev1 = current;
		}
		return current;
	}

	/*
	 * Solution_6 : Matrix Exponentiation
	 */
	public int fib_Sol_6(int N) {
		if (N <= 1) {
			return N;
		}
		int[][] A = new int[][] { { 1, 1 }, { 1, 0 } };
		matrixPower(A, N - 1);

		return A[0][0];
	}

	void matrixPower(int[][] A, int N) {
		if (N <= 1) {
			return;
		}
		matrixPower(A, N / 2);
		multiply(A, A);

		int[][] B = new int[][] { { 1, 1 }, { 1, 0 } };
		if (N % 2 != 0) {
			multiply(A, B);
		}
	}

	void multiply(int[][] A, int[][] B) {
		int x = A[0][0] * B[0][0] + A[0][1] * B[1][0];
		int y = A[0][0] * B[0][1] + A[0][1] * B[1][1];
		int z = A[1][0] * B[0][0] + A[1][1] * B[1][0];
		int w = A[1][0] * B[0][1] + A[1][1] * B[1][1];

		A[0][0] = x;
		A[0][1] = y;
		A[1][0] = z;
		A[1][1] = w;
	}

	/*
	 * Solution_7 : Math
	 */
	public int fib_Sol_7(int N) {
		double goldenRatio = (1 + Math.sqrt(5)) / 2;
		return (int) Math.round(Math.pow(goldenRatio, N) / Math.sqrt(5));
	}

	public static void main(String[] args) {
		System.out.println(fib(3));
	}
}
