package easy.array;

/**
 * We have two special characters. The first character can be represented by one
 * bit 0. The second character can be represented by two bits (10 or 11).
 * 
 * Now given a string represented by several bits. Return whether the last
 * character must be a one-bit character or not. The given string will always
 * end with a zero.
 * 
 * Example 1: 
 * Input: bits = [1, 0, 0] 
 * Output: True 
 * Explanation: The only way to
 * decode it is two-bit character and one-bit character. So the last character
 * is one-bit character. 
 * 
 * Example 2: 
 * Input: bits = [1, 1, 1, 0] 
 * Output: False
 * Explanation: The only way to decode it is two-bit character and two-bit
 * character. So the last character is NOT one-bit character. Note:
 * 
 * 1 <= len(bits) <= 1000. bits[i] is always 0 or 1.
 */
public class _717_1bitAnd2bitCharacters {
	/*
	 * Solution_1 : 
	 *	問題分析 : 1. 只有一個字元的情況，因為最後一個字元必是 0，所以是 true。
	 * 			2. 陣列結尾是 00 的情況，不管是 1000 或是 1100 結果都為 true。
	 * 			3. 陣列結尾是 10 的情況，要判斷陣列中 1 的個數 :
	 * 				3.1 : 若 1 的個數為奇數，答案為 false。
	 * 				3.2 : 若 1 的個數為偶數，答案為 true。
	 */
	public boolean isOneBitCharacter(int[] bits) {
		int ones = 0;
		// starting from one but last, as last one is always 0.
		for (int i = bits.length - 2; i >= 0 && bits[i] != 0; i--) {
			ones++;
		}
		if (ones % 2 > 0) {
			return false;
		}
		return true;
    }
	
	/*
	 * Solution_2 : 當 bits[i] == 0 的時候只會有一個字元，而當 bits[i] == 1 的時候必有 2 個字元
	 * 				最後判斷字元數。 
	 */
	public boolean isOneBitCharacter_Sol_2(int[] bits) {
		int n = bits.length, i = 0;
		while (i < n - 1) { // 
			if (bits[i] == 0) {
				i++;
			} else {
				i += 2;
			}
		}
		return i == n - 1;
	}
}
