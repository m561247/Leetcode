package easy.array;

/**
 * In a list of songs, the i-th song has a duration of time[i] seconds.
 * 
 * Return the number of pairs of songs for which their total duration in seconds
 * is divisible by 60. Formally, we want the number of indices i, j such that i
 * < j with (time[i] + time[j]) % 60 == 0.
 * 
 * 
 * 
 * Example 1:
 * Input: [30,20,150,100,40] 
 * Output: 3 
 * Explanation: Three pairs have a total
 * duration divisible by 60: (time[0] = 30, time[2] = 150): total duration 180
 * (time[1] = 20, time[3] = 100): total duration 120 (time[1] = 20, time[4] =
 * 40): total duration 60 
 * 
 * Example 2:
 * Input: [60,60,60] 
 * Output: 3 
 * Explanation: All three pairs have a total
 * duration of 120, which is divisible by 60.
 * 
 * 
 * Note:
 * 
 * 1 <= time.length <= 60000 1 <= time[i] <= 500
 */
public class _1010_PairsOfSongsWithTotalDurationsDivisibleBy60 {
	/*
	 * Solution_1 : time[] 設裡每個數字為 t，找到 x 滿足 (t + x) % 60 = 0，也就是 x % 60 = 60 - t % 60，而為了避免 x、t 皆為 60 的倍數導致錯誤
	 * 				改寫為 x % 60 = (60 - t % 60) % 60 or x % 60 = (600 - t	) % 60
	 */
	public static int numPairsDivisibleBy60(int[] time) { // [30,20,150,100,40]
		int c[] = new int[60], res = 0;
		for (int t : time) {
			res += c[(600 - t) % 60]; // 等價 (60 - t % 60) % 60
			c[t % 60] += 1;
		}
		return res;
	}
	public static void main(String[] args) {
		int[] nums = {30,20,150,100,40};
		numPairsDivisibleBy60(nums); // 
	}
}
