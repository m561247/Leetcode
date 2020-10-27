package easy.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * In a deck of cards, each card has an integer written on it.
 * 
 * Return true if and only if you can choose X >= 2 such that it is possible to
 * split the entire deck into 1 or more groups of cards, where:
 * 
 * Each group has exactly X cards. All the cards in each group have the same
 * integer.
 * 
 * 
 * Example 1:
 * Input: deck = [1,2,3,4,4,3,2,1] 
 * Output: true 
 * Explanation: Possible partition
 * [1,1],[2,2],[3,3],[4,4]. 
 * 
 * Example 2:
 * Input: deck = [1,1,1,2,2,2,3,3] 
 * Output: false
 * Explanation: No possible
 * partition. 
 * 
 * Example 3:
 * Input: deck = [1] Output: false 
 * Explanation: No possible partition. 
 * 
 * Example
 * 4:
 * Input: deck = [1,1] 
 * Output: true 
 * Explanation: Possible partition [1,1].
 * 
 * Example 5:
 * Input: deck = [1,1,2,2,2,2] 
 * Output: true 
 * Explanation: Possible partition
 * [1,1],[2,2],[2,2].
 * 
 * 
 * Constraints:
 * 
 * 1 <= deck.length <= 10^4 0 <= deck[i] < 10^4
 */
public class _914_XOfAKindInADeckOfCards {
	public static boolean hasGroupsSizeX(int[] deck) { // [1,1,1,2,2,2,3,3]
		Map<Integer, Integer> map = new HashMap<>();
		int res = 0;
		for (int i : deck) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		for (int i : map.values()) {
			res = GCD(i, res);
		}
		return res > 1;
    }
	/* help mehod */
	public static int GCD(int a, int b) {
		if (b == 0) {
			return a;
		}
		return GCD(b, a % b);
	}
	public static void main(String[] args) {
		int[] nums = { 1,1,2,2,2,2 };
		hasGroupsSizeX(nums);
		System.out.println();
	}
}
