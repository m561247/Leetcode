package easy.array;

import java.util.Arrays;

/**
 * In a row of seats, 1 represents a person sitting in that seat, and 0
 * represents that the seat is empty.
 * 
 * There is at least one empty seat, and at least one person sitting.
 * 
 * Alex wants to sit in the seat such that the distance between him and the
 * closest person to him is maximized.
 * 
 * Return that maximum distance to closest person.
 * 
 * Example 1:
 * Input: [1,0,0,0,1,0,1]
 * Output: 2 
 * Explanation: If Alex sits in the second open
 * seat (seats[2]), then the closest person has distance 2. If Alex sits in any
 * other open seat, the closest person has distance 1. Thus, the maximum
 * distance to the closest person is 2. 
 * 
 * Example 2:
 * Input: [1,0,0,0] 
 * Output: 3 
 * Explanation: If Alex sits in the last seat, the
 * closest person is 3 seats away. This is the maximum distance possible, so the
 * answer is 3.
 * 
 * 
 * Constraints:
 * 
 * 2 <= seats.length <= 20000 seats contains only 0s or 1s, at least one 0, and
 * at least one 1.
 */
public class _849_MaximizeDistanceToClosestPerson {
	/*
	 * Solution_1 : 
	 */
	public static int maxDistToClosest_Sol_1(int[] seats) {
		int res = 0, n = seats.length, last = -1; // last is index of last seated seat
        for (int i = 0; i < n; i++) {
        	if (seats[i] == 1) {
        		res = last < 0 ? i : Math.max(res, (i - last) / 2);
        		last = i;
        	}
        }
        res = Math.max(res, n - last - 1);
        return res;
    }
	
	/*
	 * Solution_2 : Next Array
	 */
	public static int maxDistToClosest_Sol_2(int[] seats) {
		int N = seats.length;
		int[] left = new int[N], right = new int[N];
		Arrays.fill(left, N);
		Arrays.fill(right, N);
		for (int i = 0; i < N; i++) {
			if (seats[i] == 1) {
				left[i] = 0;
			}else if (i > 0) {
				left[i] = left[i - 1] + 1;
			}
		}
		for (int i = N - 1; i >= 0; i--) {
			if (seats[i] == 1) {
				right[i] = 0;
			} else if (i < N - 1) {
				right[i] = right[i + 1] + 1;
			}
		}
		int ans = 0;
		for (int i = 0; i < N; i++) {
			if (seats[i] == 0) {
				ans = Math.max(ans, Math.min(left[i], right[i]));
			}
		}
		return ans;
	}
	
	/*
	 * Solution_3 : Two Pointer
	 */
	public static int maxDistToClosest_Sol_3(int[] seats) {
		int N = seats.length;
		int prev = -1, future = 0;
		int ans = 0;
		
		for (int i = 0; i < N; i++) {
			if (seats[i] == 1) {
				prev = i;
			} else {
				while (future < N && seats[future] == 0 || future < i) {
					future++;
				}
				int left = prev == -1 ? N : i - prev; // 目前位置離上一個 1 的距離
				int right = future == N ? N : future - i; // 目前位置 離下一個 1 的距離
				ans = Math.max(ans, Math.min(left, right));
			}
		}
		return ans;
	}
	
	/*
	 * Solution_4 : Group by Zero
	 */
	public static int maxDistToClosest_Sol_4(int[] seats) {
		int N = seats.length;
		int K = 0; // current longest group of empty seats
		int ans = 0;
		// 100001 之間的情況
		for (int i = 0; i < N; i++) {
			if (seats[i] == 1) {
				K = 0;
			} else {
				K++;
				ans = Math.max(ans, (K + 1) / 2);
			}
		}
		// 0...01的情況
		for (int i = 0; i < N; i++) {
			if (seats[i] == 1) {
				ans = Math.max(ans, i);
				break;
			}
		}
		// 10...0的情況
		for (int i = N - 1; i >= 0; i--) {
			if (seats[i] == 1) {
				ans = Math.max(ans, N - 1 - i);
				break;
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		int[] nums = { 1,0,0,0,1,0,1 };
		maxDistToClosest_Sol_4(nums);
	}
}
