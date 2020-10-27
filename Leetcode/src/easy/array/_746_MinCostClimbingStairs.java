package easy.array;

/**
 * On a staircase, the i-th step has some non-negative cost cost[i] assigned (0
 * indexed).
 * 
 * Once you pay the cost, you can either climb one or two steps. You need to
 * find minimum cost to reach the top of the floor, and you can either start
 * from the step with index 0, or the step with index 1.
 * 
 * Example 1: 
 * Input: cost = [10, 15, 20] 
 * Output: 15 
 * Explanation: Cheapest is
 * start on cost[1], pay that cost and go to the top. 
 * 
 * Example 2: 
 * Input: cost =
 * [1, 100, 1, 1, 1, 100, 1, 1, 100, 1] 
 * Output: 6 
 * Explanation: Cheapest is start
 * on cost[0], and only step on 1s, skipping cost[3]. Note: cost will have a
 * length in the range [2, 1000]. Every cost[i] will be an integer in the range
 * [0, 999].
 */
public class _746_MinCostClimbingStairs {
	/*
	 * Solution_1 : 
	 */
	public static int minCostClimbingStairs(int[] cost) { // 1, 100, 1, 1, 1, 100, 1, 1, 100, 1
		for (int i = 2; i < cost.length; i++) {
			cost[i] += Math.min(cost[i - 1], cost[i - 2]);
        }
		return Math.min(cost[cost.length - 1], cost[cost.length - 2]);
    }
	
	/*
	 * Solution_2 : Convert the recurrence relation to recursion
	 */
	public static int minCostClimbingStairs_Sol_2(int[] cost) {
		int n = cost.length;
		return Math.min(minCost_Sol_2(cost, n - 1), minCost_Sol_2(cost, n - 2));
	}
	/* help method */
	private static int minCost_Sol_2(int[] cost, int n) { // [10, 15, 20]    10 15 20 25 
		if (n < 0) {								// [1, 100, 1, 1, 1, 100, 1, 1, 100, 1] 
			return 0;
		}
		if (n == 0 || n == 1) {
			return cost[n];
		}
		return cost[n] + Math.min(minCost_Sol_2(cost, n - 1), minCost_Sol_2(cost, n - 2));
	}
	
	/*
	 * Solution_3 : Optimization 1 - Top Down DP - Add memoization to recursion - From exponential to linear.
	 */
	static int[] dp;
	public static int minCostClimbingStairs_Sol_3(int[] cost) { // [10, 15, 20, 25]
		int n = cost.length;
		dp = new int[n];
		return Math.min(minCost_Sol_3(cost, n - 1), minCost_Sol_3(cost, n - 2));
	}
	/* help method */
	private static int minCost_Sol_3(int[] cost, int n) {
		if (n < 0) {
			return 0;
		}
		if (n == 0 || n == 1) {
			return cost[n];
		}
		if (dp[n] != 0) {
			return dp[n];
		}
		dp[n] = cost[n] + Math.min(minCost_Sol_3(cost, n - 1), minCost_Sol_3(cost, n - 2));
		return dp[n];
	}
	
	/*
	 * Solution_4 : Optimization 2 -Bottom Up DP - Convert recursion to iteration - Getting rid of recursive stack
	 */
	public static int minCostClimbingStairs_Sol_4(int[] cost) { // [10, 15, 20, 25]
		int n = cost.length;
		int[] dp = new int[n];
		for (int i = 0; i < n; i++) {
			if (i < 2) {
				dp[i] = cost[i];
			} else {
				dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
			}
		}
		return Math.min(dp[n - 1], dp[n - 2]);
	}
	
	/*
	 * Solution_5 : Optimization 3 - Fine Tuning - Reduce O(n) space to O(1).
	 */
	public int minCostClimbingStairs_Sol_5(int[] cost) {
		int n = cost.length;
		int first = cost[0];
		int second = cost[1];
		if (n <= 2) {
			return Math.min(first, second);
		}
		for (int i = 2; i < n; i++) {
			int curr = cost[i] + Math.min(first, second);
			first = second;
			second = curr;
		}
		return Math.min(first, second);
	}
	
	public static void main(String[] args) {
		int[] nums = { 841,462,566,398,243,248,23};
		System.out.println(minCostClimbingStairs_Sol_3(nums));
	}
}
