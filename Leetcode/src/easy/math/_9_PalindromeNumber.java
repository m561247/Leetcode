package easy.math;

/**
 * Determine whether an integer is a palindrome. An integer is a palindrome when
 * it reads the same backward as forward.
 * 
 * Example 1:
 * Input: 121 
 * Output: true 
 * 
 * Example 2:
 * Input: -121 
 * Output: false 
 * Explanation: From left to right, it reads -121.
 * From right to left, it becomes 121-. Therefore it is not a palindrome.
 * 
 * Example 3:
 * Input: 10 
 * Output: false 
 * Explanation: Reads 01 from right to left. Therefore
 * it is not a palindrome. Follow up:
 * 
 * Coud you solve it without converting the integer to a string?
 */
public class _9_PalindromeNumber {
	/*
	 * Solution_1 : with out convert to string
	 */
	public static boolean isPalindrome(int x) { // 121
        if (x < 0) {
        	return false;
        }
        int revNum = 0, temp = x;
        while (temp != 0) {
        	revNum = revNum * 10 + temp % 10;
        	temp /= 10;
        }
        return revNum == x;
    }
	
	public static void main(String[] args) {
		System.out.println(isPalindrome(121));
		int x = 121;
		int result = 121;
		System.out.println(result == x);
	}
}
