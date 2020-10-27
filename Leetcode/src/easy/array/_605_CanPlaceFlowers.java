package easy.array;

/**
 * Suppose you have a long flowerbed in which some of the plots are planted and
 * some are not. However, flowers cannot be planted in adjacent plots - they
 * would compete for water and both would die.
 * 
 * Given a flowerbed (represented as an array containing 0 and 1, where 0 means
 * empty and 1 means not empty), and a number n, return if n new flowers can be
 * planted in it without violating the no-adjacent-flowers rule.
 * 
 * Example 1: 
 * Input: flowerbed = [1,0,0,0,1], n = 1 
 * Output: True 
 * Example 2:
 * Input: flowerbed = [1,0,0,0,1], n = 2 
 * Output: False 
 * Note: The input array
 * won't violate no-adjacent-flowers rule. The input array size is in the range
 * of [1, 20000]. n is a non-negative integer which won't exceed the input array
 * size.
 */
public class _605_CanPlaceFlowers {
	/*
	 * Solution_1 : Greedy algorithm
	 */
	public static boolean canPlaceFlowers_Sol_1(int[] flowerbed, int n) {
		int count = 0;
		for (int i = 0; i < flowerbed.length && count < n; i++) {
			if (flowerbed[i] == 0) { // [1,0,0,0,1]
				//get next and prev flowerbed slot values. If i lies at the ends the next and prev are considered as 0. 
				int next = (i == flowerbed.length - 1) ? 0 : flowerbed[i + 1];
				int prev = (i == 0) ? 0 : flowerbed[i - 1];
				if (next == 0 && prev == 0) {
					flowerbed[i] = 1;
					count++;
				}
			}
		}
		return count == n;
    }
	
	/*
	 * Solution_2 : 
	 */
	public boolean canPlaceFlowers_Sol_2(int[] flowerbed, int n) { // [1,0,0,0,1] 
		int count = 1, result = 0; // set count = 1 because 
		for (int i = 0; i < flowerbed.length; i++) {
			if (flowerbed[i] == 0) {
				count++;
			} else {
				result += (count - 1) / 2;
				count = 0;
			}
		}
		if (count != 0) {
			result += count / 2;
		}
		return result >= n;
	}
	
	/*
	 * Solution_3 : single scan
	 */
	public boolean canPlaceFlowers(int[] flowerbed, int n) {
		int i = 0, count = 0;
		while (i < flowerbed.length) {
			// 計算可以塞入最多 1 的情況，除了頭尾之外，前後都要是 0 計次才 + 1
			if (flowerbed[i] == 0 
					&& (i == 0 || flowerbed[i - 1] == 0)
					&& (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
				flowerbed[i] = 1;
				count++;
			}
			i++;
		}
		return count >= n;
	}
	
	public static void main(String[] args) {
		int[] nums = { 1,0,0,0,1 };
		canPlaceFlowers_Sol_1(nums, 1);
	}
}
